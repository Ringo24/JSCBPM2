package com.lee.jscbpm2.sns;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lee.jscbpm2.member.MemberDAO;

@Controller
public class SnsController {

	@Autowired
	private SnsDAO sDAO;
	@Autowired
	private MemberDAO mDAO;
	
	@RequestMapping(value = "write.sns", method = RequestMethod.POST)
	public String write(Sns s, HttpServletRequest req, HttpServletResponse res) {
		if (mDAO.loginCheck(req, res)) {
			sDAO.write(s, req, res);
		}
		mDAO.loginCheck(req, res);
		sDAO.clearSearch(req, res);
		sDAO.paging(1, req, res);
		req.setAttribute("contentPage", "cafe.jsp");
		return "index";
	}
	@RequestMapping(value = "write.reply", method = RequestMethod.GET)
	public String writeReply(Reply r, HttpServletRequest req, HttpServletResponse res) {
		if (mDAO.loginCheck(req, res)) {
			sDAO.writeReply(r, req, res);
		}
		mDAO.loginCheck(req, res);
		sDAO.clearSearch(req, res);
		sDAO.paging(1, req, res);
		req.setAttribute("contentPage", "cafe.jsp");
		return "index";
	}
	
	@RequestMapping(value = "page.sns", method = RequestMethod.GET)
	public String goPage(HttpServletRequest req, HttpServletResponse res) {
		mDAO.loginCheck(req, res);
		sDAO.paging(Integer.parseInt(req.getParameter("p")), req, res);
		req.setAttribute("contentPage", "cafe.jsp");
		return "index";
	}
	@RequestMapping(value = "search.sns", method = RequestMethod.POST)
	public String search(Query q, HttpServletRequest req, HttpServletResponse res) {
		sDAO.search(q, req, res);
		mDAO.loginCheck(req, res);
		sDAO.paging(1, req, res);
		req.setAttribute("contentPage", "cafe.jsp");
		return "index";
	}
	
	@RequestMapping(value = "delete.sns", method = RequestMethod.GET)
	public String delete(Sns s, HttpServletRequest req, HttpServletResponse res) {
		if (mDAO.loginCheck(req, res)) {
			sDAO.delete(s, req, res);
		}
		mDAO.loginCheck(req, res);
		sDAO.clearSearch(req, res);
		sDAO.paging(1, req, res);
		req.setAttribute("contentPage", "cafe.jsp");
		return "index";
	}
	@RequestMapping(value = "delete.reply", method = RequestMethod.GET)
	public String deleteReply(Reply r, HttpServletRequest req, HttpServletResponse res) {
		if (mDAO.loginCheck(req, res)) {
			sDAO.deleteReplybyJrno(r, req, res);
		}
		mDAO.loginCheck(req, res);
		sDAO.clearSearch(req, res);
		sDAO.paging(1, req, res);
		req.setAttribute("contentPage", "cafe.jsp");
		return "index";
	}
	@RequestMapping(value = "updateSns.go", method = RequestMethod.GET)
	public String goUpdate(HttpServletRequest req, HttpServletResponse res) {
		if (mDAO.loginCheck(req, res)) {
			req.setAttribute("modify", Integer.parseInt(req.getParameter("js_no")));
		}
		mDAO.loginCheck(req, res);
		sDAO.paging(1, req, res);
		req.setAttribute("contentPage", "update.jsp");
		return "index";
	}
	@RequestMapping(value = "update.sns", method = RequestMethod.POST)
	public String update(Sns s, HttpServletRequest req, HttpServletResponse res) {
		if (mDAO.loginCheck(req, res)) {
			sDAO.update(s, req, res);
		}
		mDAO.loginCheck(req, res);
		sDAO.clearSearch(req, res);
		sDAO.paging(1, req, res);
		req.setAttribute("contentPage", "update.jsp");
		return "index";
	}
	@RequestMapping(value = "update.reply", method = RequestMethod.GET)
	public String updateReply(Reply r, HttpServletRequest req, HttpServletResponse res) {
		if (mDAO.loginCheck(req, res)) {
			sDAO.updateReply(r, req, res);
		}
		mDAO.loginCheck(req, res);
		sDAO.clearSearch(req, res);
		sDAO.paging(1, req, res);
		req.setAttribute("contentPage", "cafe.jsp");
		return "index";
	}
	
}
