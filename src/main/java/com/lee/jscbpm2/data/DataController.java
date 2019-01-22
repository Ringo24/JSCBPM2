package com.lee.jscbpm2.data;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lee.jscbpm2.member.MemberDAO;
import com.lee.jscbpm2.sns.Query;
import com.lee.jscbpm2.sns.SnsDAO;

@Controller
public class DataController {

	@Autowired
	private MemberDAO mDAO;
	@Autowired
	private DataDAO dDAO;
	@Autowired
	private SnsDAO sDAO;
	
	private boolean firstReq;
	
	public DataController() {
		firstReq = true;
	}
	
	@RequestMapping(value = "data.do", method = RequestMethod.GET)
	public String goDataroom(HttpServletRequest req, HttpServletResponse res) {
		if (firstReq) {
			sDAO.getAllSnsCount();
			dDAO.getAllDataCount();
			firstReq = false;
		}
		mDAO.loginCheck(req, res);
		dDAO.clearSearch(req, res);
		dDAO.paging(1, req, res);
		req.setAttribute("contentPage", "dataroom/dataroom.jsp");
		return "index";
	}
	@RequestMapping(value = "write.data", method = RequestMethod.POST)
	public String write(Data d, HttpServletRequest req, HttpServletResponse res) {
		if (mDAO.loginCheck(req, res)) {
			dDAO.write(d, req, res);
		}
		mDAO.loginCheck(req, res);
		dDAO.clearSearch(req, res);
		dDAO.paging(1, req, res);
		req.setAttribute("contentPage", "dataroom/dataroom.jsp");
		return "index";
	}
	
	@RequestMapping(value = "search.data", method = RequestMethod.POST)
	public String search(Query q, HttpServletRequest req, HttpServletResponse res) {
		dDAO.search(q, req, res);
		dDAO.paging(1, req, res);
		mDAO.loginCheck(req, res);
		req.setAttribute("contentPage", "dataroom/dataroom.jsp");
		return "index";
	}
	@RequestMapping(value = "page.data", method = RequestMethod.GET)
	public String goPage(HttpServletRequest req, HttpServletResponse res) {
		dDAO.paging(Integer.parseInt(req.getParameter("p")), req, res);
		mDAO.loginCheck(req, res);
		req.setAttribute("contentPage", "dataroom/dataroom.jsp");
		return "index";
	}
	
	@RequestMapping(value = "updateData.go", method = RequestMethod.GET)
	public String goUpdate(Data d, HttpServletRequest req, HttpServletResponse res) {
		if (mDAO.loginCheck(req, res)) {
			req.setAttribute("modify", Integer.parseInt(req.getParameter("jd_no")));
		}
		mDAO.loginCheck(req, res);
		dDAO.paging(1, req, res);
		req.setAttribute("contentPage", "dataroom/updateDataroom2.jsp");
		return "index";
	}
	@RequestMapping(value = "update.data", method = RequestMethod.POST)
	public String update(Data d, HttpServletRequest req, HttpServletResponse res) {
		if (mDAO.loginCheck(req, res)) {
			dDAO.update(d, req, res);
		}
		mDAO.loginCheck(req, res);
		dDAO.clearSearch(req, res);
		dDAO.paging(1, req, res);
		req.setAttribute("contentPage", "dataroom/dataroom.jsp");
		return "index";
	}
	@RequestMapping(value = "delete.data", method = RequestMethod.GET)
	public String delete(Data d, HttpServletRequest req, HttpServletResponse res) {
		if (mDAO.loginCheck(req, res)) {
			dDAO.delete(d, req, res);
		}
		mDAO.loginCheck(req, res);
		dDAO.clearSearch(req, res);
		dDAO.paging(1, req, res);
		req.setAttribute("contentPage", "dataroom/dataroom.jsp");
		return "index";
	}
	
}
