package com.lee.jscbpm2.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lee.jscbpm2.sns.Query;
import com.lee.jscbpm2.sns.SnsDAO;

@Controller
public class MemberController {

	@Autowired
	private MemberDAO mDAO;
	@Autowired
	private SnsDAO sDAO;
	
	@RequestMapping(value = "join.go", method = RequestMethod.GET)
	public String goJoin(Member m, HttpServletRequest req, HttpServletResponse res) {
		mDAO.loginCheck(req, res);
		req.setAttribute("contentPage", "member/join.jsp");
		return "index";
	}
	@RequestMapping(value = "update.go", method = RequestMethod.GET)
	public String goUpdate(Member m, HttpServletRequest req, HttpServletResponse res) {
		mDAO.loginCheck(req, res);
		req.setAttribute("contentPage", "member/info.jsp");
		return "index";
	}
	@RequestMapping(value = "join.member", method = RequestMethod.POST)
	public String join(Member m, HttpServletRequest req, HttpServletResponse res) {
		mDAO.join(m, req, res);
		mDAO.loginCheck(req, res);
		sDAO.clearSearch(req, res);
		sDAO.paging(1, req, res);
		req.setAttribute("contentPage", "cafe.jsp");
		return "index";
	}
	@RequestMapping(value = "login.member", method = RequestMethod.POST)
	public String login(Member m, HttpServletRequest req, HttpServletResponse res) {
		mDAO.login(m, req, res);
		mDAO.loginCheck(req, res);
		sDAO.clearSearch(req, res);
		sDAO.paging(1, req, res);
		req.setAttribute("contentPage", "cafe.jsp");
		return "index";
	}
	@RequestMapping(value = "logout.member", method = RequestMethod.GET)
	public String logout(HttpServletRequest req, HttpServletResponse res) {
		if (mDAO.loginCheck(req, res)) {
			mDAO.logout(req, res);
		}
		mDAO.loginCheck(req, res);
		sDAO.clearSearch(req, res);
		sDAO.paging(1, req, res);
		req.setAttribute("contentPage", "cafe.jsp");
		return "index";
	}
	@RequestMapping(value = "delete.member", method = RequestMethod.GET)
	public String delete(HttpServletRequest req, HttpServletResponse res) {
		if (mDAO.loginCheck(req, res)) {
			mDAO.delete(req, res);
		}
		mDAO.loginCheck(req, res);
		sDAO.clearSearch(req, res);
		sDAO.paging(1, req, res);
		req.setAttribute("contentPage", "cafe.jsp");
		return "index";
	}
	@RequestMapping(value = "update.member", method = RequestMethod.POST)
	public String update(Member m, HttpServletRequest req, HttpServletResponse res) {
		if (mDAO.loginCheck(req, res)) {
			mDAO.update(m, req, res);
		}
		mDAO.loginCheck(req, res);
		sDAO.clearSearch(req, res);
		sDAO.paging(1, req, res);
		req.setAttribute("contentPage", "cafe.jsp");
		return "index";
	}
	@RequestMapping(value = "mySns.go", method = RequestMethod.GET)
	public String mySns(Query q, HttpServletRequest req, HttpServletResponse res) {
		if (mDAO.loginCheck(req, res)) {
			sDAO.search(q, req, res);
			req.setAttribute("contentPage", "member/mySns.jsp");
		} else {
			req.setAttribute("contentPage", "cafe.jsp");
		}
		mDAO.loginCheck(req, res);
		sDAO.paging(1, req, res);
		return "index";
	}
	
	@RequestMapping(value = "member.id.check", method = RequestMethod.GET, produces = "application/xml; charset=utf-8")
	public @ResponseBody Members idCheck(Member m, HttpServletRequest req, HttpServletResponse res) {
		return mDAO.idCheck(m);
	}
}
