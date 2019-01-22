package com.lee.jscbpm2.data;

import java.io.File;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lee.jscbpm2.member.Member;
import com.lee.jscbpm2.sns.Query;
import com.lee.jscbpm2.sns.SnsNo;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@Service
public class DataDAO {

	@Autowired
	private SqlSession ss;
	
	private int AllDataCount;
	
	public void getAllDataCount() {
		AllDataCount = ss.getMapper(DataMapper.class).getAllDataCount();
		System.out.println(AllDataCount);
	}
	
	public void write(Data d, HttpServletRequest req, HttpServletResponse res) {
		String path = req.getSession().getServletContext().getRealPath("resources/file");
		try {
			MultipartRequest mr = new MultipartRequest(req, path, 1024*1024*1024,"utf-8", new DefaultFileRenamePolicy());
			
			String jd_file = mr.getFilesystemName("jd_file");
			if (jd_file != null) {
				jd_file = URLEncoder.encode(jd_file, "utf-8"); // 새.png => %3A.png
			}
			jd_file = jd_file.replace("+", " ");
			d.setJd_file(jd_file);
			
			Member m = (Member) req.getSession().getAttribute("loginMember");
			d.setJd_id(m.getJm_id());
			
			d.setJd_title(mr.getParameter("jd_title").replace("\r\n", "<br>"));
			
			if (ss.getMapper(DataMapper.class).write(d) == 1) {
				req.setAttribute("r", "등록 성공");
				AllDataCount++;
			}
		} catch (Exception e) {
			req.setAttribute("r", "등록 실패");
			e.printStackTrace();
			File f = new File(path + "/" + d.getJd_file());
			f.delete();
		}
	}
	
	public void update(Data d, HttpServletRequest req, HttpServletResponse res) {
		String path = req.getSession().getServletContext().getRealPath("resources/file");
		try {
			MultipartRequest mr = new MultipartRequest(req, path, 1024*1024*1024,"utf-8", new DefaultFileRenamePolicy());
			
			d.setJd_no(new BigDecimal(mr.getParameter("jd_no")));
			d.setJd_title(mr.getParameter("jd_title").replace("\r\n", "<br>"));

			Data dbD = ss.getMapper(DataMapper.class).getOneData(d);
			String jd_file = mr.getFilesystemName("jd_file");
			if (jd_file != null) {
				jd_file = URLEncoder.encode(jd_file, "utf-8"); // 새.png => %3A.png
				jd_file = jd_file.replace("+", " ");
				d.setJd_file(jd_file);
				if (ss.getMapper(DataMapper.class).updateFile(d) == 1) {
					req.setAttribute("r", "수정 성공");
					File f = new File(path + "/" + dbD.getJd_file());
					f.delete();
				}
			} else if (jd_file == null) {
				if (ss.getMapper(DataMapper.class).updateNoFile(d) == 1) {
					req.setAttribute("r", "수정 성공");
				}
			}
		} catch (Exception e) {
			req.setAttribute("r", "등록 실패");
			e.printStackTrace();
			if (d.getJd_file() != null) {
				File f = new File(path + "/" + d.getJd_file());
				f.delete();
			}
		}
	}
	
	public void delete(Data d, HttpServletRequest req, HttpServletResponse res) {
		try {
			Data dbD = ss.getMapper(DataMapper.class).getOneData(d);
			if (ss.getMapper(DataMapper.class).delete(d) == 1) {
				req.setAttribute("r", "삭제 성공");
				String path = req.getSession().getServletContext().getRealPath("resources/file");
				File f = new File(path + "/" + dbD.getJd_file());
				f.delete();
				AllDataCount--;
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("r", "삭제 실패");
		}
	}
	
	public void search(Query q, HttpServletRequest req, HttpServletResponse res) {
		req.getSession().setAttribute("searchDataAl", ss.getMapper(DataMapper.class).search(q));
	}
	
	public void clearSearch(HttpServletRequest req, HttpServletResponse res) {
		req.getSession().setAttribute("searchDataAl", null);
	}
	
	public void paging(int pageNo, HttpServletRequest req, HttpServletResponse res) {
		@SuppressWarnings("unchecked")
		List<Data> searchDataAl = (List<Data>) req.getSession().getAttribute("searchDataAl");
		double count = 8.0;		// 한 페이지당 보여줄 갯수
		req.setAttribute("curPage", pageNo);
		
		try {
			if (searchDataAl != null && searchDataAl.size() > 0) {
				// 검색
				int pageCount = (int) Math.ceil(searchDataAl.size() / count);
				req.setAttribute("pageCount", pageCount);
				
				// 전체 목록 중에서 페이지 번호에 맞는 것만 추줄
				int start = (searchDataAl.size() - ((pageNo - 1) * (int)count));
				int end = (pageNo == pageCount) ? 1 : (start - ((int)count - 1));	// 마지막 페이지는 무조건 1
			
				ArrayList<Data> files = new ArrayList<Data>();
				
				for (int i = start-1; i >= end-1; i--) {
					files.add(searchDataAl.get(i));
				}
				req.setAttribute("files", files);
			} else if (AllDataCount > 0) {
				// 조회
				// 전체 페이지 수 계산
				int pageCount = (int) Math.ceil(AllDataCount / count);
				req.setAttribute("pageCount", pageCount);
				
				// 전체 목록 중에서 페이지 번호에 맞는 것만 추줄
				int start = (AllDataCount - ((pageNo - 1) * (int)count));
				int end = (pageNo == pageCount) ? 1 : (start - ((int)count - 1));	// 마지막 페이지는 무조건 1
			
				SnsNo sn = new SnsNo(new BigDecimal(start), new BigDecimal(end));
				req.setAttribute("files", ss.getMapper(DataMapper.class).getData(sn));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
