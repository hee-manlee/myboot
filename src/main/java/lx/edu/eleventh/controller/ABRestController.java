package lx.edu.eleventh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lx.edu.eleven.vo.AddrBook;
import lx.edu.eleventh.dao.AddrBookDAO;


@RestController
public class ABRestController {
	
	@Autowired
	AddrBookDAO dao;
	
	
	@RequestMapping(value="/addrbook/{id}", produces = "application/json")
	public @ResponseBody AddrBook getAddrBook(@PathVariable int id) throws Exception {
		//id에 해당하는 방명록 정보를 가져와야 한다.
		return dao.getAddrBookById(id);
	}

}
