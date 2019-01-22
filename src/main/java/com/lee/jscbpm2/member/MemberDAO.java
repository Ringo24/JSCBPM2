package com.lee.jscbpm2.member;

import java.io.File;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@Service
public class MemberDAO {

	@Autowired
	private SqlSession ss;
	
	public void join(Member m, HttpServletRequest req, HttpServletResponse res) {
		try {
			String path = req.getSession().getServletContext().getRealPath("resources/file");
			
			MultipartRequest mr = new MultipartRequest(req, path, 30*1024*1024,"utf-8", new DefaultFileRenamePolicy());
			
			String jm_photo = mr.getFilesystemName("jm_photo");
			if (jm_photo != null) {
				jm_photo = URLEncoder.encode(jm_photo, "utf-8"); // 새.png => %3A.png
			}
			// " " => "+"로 바뀌는데, " "는 " "로 놔둬야함
			jm_photo = jm_photo.replace("+", " ");
			m.setJm_photo(jm_photo);
			
			m.setJm_id(mr.getParameter("jm_id"));
			m.setJm_pw(mr.getParameter("jm_pw"));
			m.setJm_name(mr.getParameter("jm_name"));
			m.setJm_addr1(mr.getParameter("jm_addr1"));
			m.setJm_addr2(mr.getParameter("jm_addr2"));
			m.setJm_addr3(mr.getParameter("jm_addr3"));
			
			if (ss.getMapper(MemberMapper.class).join(m) == 1) {
				req.setAttribute("r", "회원가입 성공");
			}
		} catch (Exception e) {
			req.setAttribute("r", "회원가입 실패");
		}
	}
	
	public boolean loginCheck(HttpServletRequest req, HttpServletResponse res) {
		autoLogin(req, res);
		Member m = (Member) req.getSession().getAttribute("loginMember");
		
		if (m != null) {
			// 로그인 됐을 때
			req.setAttribute("loginPage", "member/logon.jsp");
			return true;
		}
		// 로그인 안됐을 때
		req.setAttribute("loginPage", "member/login.jsp");
		return false;
	}
	
	public void autoLogin(HttpServletRequest req, HttpServletResponse res) {
		Cookie[] cookies = req.getCookies();
		
		if (cookies != null) {
			for (Cookie c : cookies) {
				// 쿠키가 있는가
				if (c.getName().equals("autoLoginID")) {
					String jm_id = c.getValue();
					// 쿠키는 있는데 값이 없을 수 있으므로
					if (jm_id != null && jm_id != "") {
						try {
							Member m = new Member(jm_id, null, null, null, null, null, null, null);
							Member dbm = ss.getMapper(MemberMapper.class).getMemberInfoByJM_ID(m);
							
							if (dbm != null) {
								req.getSession().setAttribute("loginMember", dbm);
								req.getSession().setMaxInactiveInterval(15 * 60);
								
								req.setAttribute("r", "로그인 성공");
							} else {
								req.setAttribute("r", "아이디를 확인하세요");
							}
						} catch (Exception e) {
							req.setAttribute("r", "DB서버 이상");
							e.printStackTrace();
						} 
					}
					break;
				}
			}
		}
	}
	
	public void login(Member m, HttpServletRequest req, HttpServletResponse res) {
		try {
			
			Member dbm = ss.getMapper(MemberMapper.class).getMemberInfoByJM_ID(m);
			
			if (dbm != null) {
				if (dbm.getJm_pw().equals(m.getJm_pw())) {
					// 다른 요청에서도 쓸 수 있고
					// 시간 제한
					// 브라우저 닫으면 세션 종료
					req.getSession().setAttribute("loginMember", dbm);
					req.getSession().setMaxInactiveInterval(15 * 60 * 60);
					
					// 자동 로그인
					if (m.getAutoLogin() != null) {
						Cookie autoLoginID = new Cookie("autoLoginID", m.getJm_id());
						autoLoginID.setMaxAge(1 * 60 * 60 * 24);
						res.addCookie(autoLoginID);
					}
					req.setAttribute("r", "로그인 성공");
				} else {
					req.setAttribute("r", "비밀번호를 확인하세요");
				}
			} else {
				req.setAttribute("r", "아이디를 확인하세요");
			}
		} catch (Exception e) {
			req.setAttribute("r", "DB서버 이상");
			e.printStackTrace();
		} 
	}
	
	public void logout(HttpServletRequest req, HttpServletResponse res) {
		req.getSession().setAttribute("loginMember", null);
		req.getSession().setAttribute("searchSnsAl", null);
		
		// 자동 로그인 해제
		Cookie[] cookies = req.getCookies();
		if (cookies != null) {
			for (Cookie c : cookies) {
				if (c.getName().equals("autoLoginID")) {
					c.setValue(null);
					res.addCookie(c);
				}
			}
		}
	}
	
	public void update(Member m, HttpServletRequest req, HttpServletResponse res) {
		try {
			// 수정 전 사진 받아두기
			Member sm = (Member) req.getSession().getAttribute("loginMember");
			String pre_jm_photo = sm.getJm_photo();
			
			String path = req.getSession().getServletContext().getRealPath("resources/file");
			
			MultipartRequest mr = new MultipartRequest(req, path, 30*1024*1024,"utf-8", new DefaultFileRenamePolicy());
			
			String jm_photo = mr.getFilesystemName("jm_photo");
			if (jm_photo != null) {
				jm_photo = URLEncoder.encode(jm_photo, "utf-8"); // 새.png => %3A.png
			}
			// " " => "+"로 바뀌는데, " "는 " "로 놔둬야함
			jm_photo = jm_photo.replace("+", " ");
			m.setJm_photo(jm_photo);
			
			m.setJm_id(mr.getParameter("jm_id"));
			m.setJm_pw(mr.getParameter("jm_pw"));
			m.setJm_name(mr.getParameter("jm_name"));
			m.setJm_addr1(mr.getParameter("jm_addr1"));
			m.setJm_addr2(mr.getParameter("jm_addr2"));
			m.setJm_addr3(mr.getParameter("jm_addr3"));
			
			int result = 0;
			if (jm_photo != null) {
				result = ss.getMapper(MemberMapper.class).updateWithPhoto(m);
			} else {
				result = ss.getMapper(MemberMapper.class).updateWithoutPhoto(m);
			}
			if (result == 1) {
				req.setAttribute("r", "수정 성공");
				login(m, req, res);
				// 이전 사진 삭제
				pre_jm_photo = URLDecoder.decode(pre_jm_photo, "utf-8");
				File f = new File(path + "/" + pre_jm_photo);
				f.delete();
			}
		} catch (Exception e) {
			req.setAttribute("r", "수정 실패");
			e.printStackTrace();
		} 
	}
	
	public void delete(HttpServletRequest req, HttpServletResponse res) {
		try {
			Member m = (Member) req.getSession().getAttribute("loginMember");
			if (ss.getMapper(MemberMapper.class).delete(m) == 1) {
				req.setAttribute("r", "탈퇴 성공");
				// 사진 삭제
				String jm_photo = URLDecoder.decode(m.getJm_photo(), "utf-8");
				String path = req.getSession().getServletContext().getRealPath("resources/file");
				File f = new File(path + "/" + jm_photo);
				f.delete();
				// 로그아웃
				logout(req, res);
			}
		} catch (Exception e) {
			req.setAttribute("r", "탈퇴 실패");
			e.printStackTrace();
		}
	}
	
	public Members idCheck(Member m) {
		ArrayList<Member> al = new ArrayList<Member>();
		al.add(ss.getMapper(MemberMapper.class).getMemberInfoByJM_ID(m));
		Members ms = new Members(al);
		return ms;
	}
}
