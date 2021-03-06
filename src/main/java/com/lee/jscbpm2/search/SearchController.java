package com.lee.jscbpm2.search;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lee.jscbpm2.member.MemberDAO;
import com.lee.jscbpm2.sns.Query;

@Controller
public class SearchController {

	@Autowired
	private MemberDAO mDAO;
	@Autowired
	private SearchDAO scDAO;
	
	@RequestMapping(value = "search.go", method = RequestMethod.GET)
	public String goSearch(HttpServletRequest req, HttpServletResponse res) {
		mDAO.loginCheck(req, res);
		req.setAttribute("contentPage", "search/shopping.jsp");
		return "index";
	}
	@RequestMapping(value = "search.do", method = RequestMethod.POST)
	public String search(Query q, HttpServletRequest req, HttpServletResponse res) {
		scDAO.search(q, req, res);
		mDAO.loginCheck(req, res);
		req.setAttribute("contentPage", "search/shopping.jsp");
		return "index";
	}
	@RequestMapping(value = "search.shop", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	public @ResponseBody String searchJson(HttpServletRequest req, HttpServletResponse res) {
		return scDAO.shopping(req, res);
	}
	@RequestMapping(value = "map.go", method = RequestMethod.GET)
	public String goMap(HttpServletRequest req, HttpServletResponse res) {
		mDAO.loginCheck(req, res);
		req.setAttribute("contentPage", "search/map.jsp");
		return "index";
	}
	@RequestMapping(value = "calendar.go", method = RequestMethod.GET)
	public String goCalendar(HttpServletRequest req, HttpServletResponse res) {
		mDAO.loginCheck(req, res);
		req.setAttribute("contentPage", "search/calendar.jsp");
		return "index";
	}
}
