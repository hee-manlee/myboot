package lx.edu.eleventh.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import lx.edu.eleven.vo.AddrBook;
import lx.edu.eleventh.dao.AddrBookDAO;


@Controller
public class ABController {
	
	@Autowired
	AddrBookDAO dao;
	
	@RequestMapping("/")
	public String home() {
		return "home";
		//prefix : /WEB-INF/views suffix : .jsp
		// /WEB-INF/views/home.jsp
	}
	
	@RequestMapping("/list.do")
	public String list(HttpServletRequest req, Model model) throws Exception {
		//AddrBookDAO의 메서드를 실행하여 리퀘스트에 넣는다.
		List<AddrBook> list = dao.getListAddrBook();
		//req.setAttribute("memberlist", list);
		model.addAttribute("memberlist", list);
		return "addrbook/addrbook_list";
	}

	@RequestMapping("/form.do")
	public String form() throws Exception {
		return "addrbook/addrbook_form";
	}
	
	@RequestMapping(value="/register.do")
	public String register(AddrBook ab, HttpServletRequest req) throws Exception {
		//AddrBook ab = RequestUtil.extractAddrBook(req);
		System.out.println(ab);
		dao.insertAddrBook(ab);
//		List<AddrBook> list = dao.getListAddrBook();
//		req.setAttribute("memberlist", list);
//		return "addrbook/addrbook_list";
		return "redirect:/list.do";
	}
	
	@RequestMapping("/edit_form.do")
	public String editForm(HttpServletRequest req, int id) throws Exception {
		//String id = req.getParameter("id");
		System.out.println("id=" + id);
		//
		AddrBook ab = dao.getAddrBookById(id);
		System.out.println(ab);
		req.setAttribute("ab", ab);
		return "addrbook/addrbook_edit_form";
	}
	@RequestMapping("/edit.do")
	public String edit(AddrBook ab) throws Exception {
		System.out.println(ab);
		int result = dao.edit(ab);
		return "redirect:/list.do";
	}
	
	@RequestMapping("/delete.do")
	public String addrbook(int abId) throws Exception {
		int result = dao.delete(abId);
		return "redirect:/list.do";
	}
	
}
