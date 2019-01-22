package com.lee.jscbpm2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lee.jscbpm2.data.DataDAO;
import com.lee.jscbpm2.member.MemberDAO;
import com.lee.jscbpm2.sns.SnsDAO;

@Controller
public class HomeController {
	
	@Autowired
	private MemberDAO mDAO;
	@Autowired
	private SnsDAO sDAO;
	@Autowired
	private DataDAO dDAO;
	
	private boolean firstReq; // 첫 요청인지 따질 변수
	
	public HomeController() {
		firstReq = true;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpServletRequest req, HttpServletResponse res) {
		if (firstReq) {
			sDAO.getAllSnsCount();
			dDAO.getAllDataCount();
			firstReq = false;
		}
		mDAO.loginCheck(req, res);
		sDAO.clearSearch(req, res);
		sDAO.paging(1, req, res);
		req.setAttribute("contentPage", "cafe.jsp");
		return "index";
	}
	@RequestMapping(value = "index.do", method = RequestMethod.GET)
	public String index(HttpServletRequest req, HttpServletResponse res) {
		if (firstReq) {
			sDAO.getAllSnsCount();
			dDAO.getAllDataCount();
			firstReq = false;
		}
		mDAO.loginCheck(req, res);
		sDAO.clearSearch(req, res);
		sDAO.paging(1, req, res);
		req.setAttribute("contentPage", "cafe.jsp");
		return "index";
	}
	
}
