package lx.edu.eleventh.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lx.edu.eleven.vo.AddrBook;


@Repository
public class AddrBookDAO {
	
	@Autowired
	SqlSession session;

	public int insertAddrBook(AddrBook ab) throws Exception {
		return session.insert("insertAddrBook", ab);
	}
	
	public List<AddrBook>  getListAddrBook() throws Exception {
		return session.selectList("getListAddrBook");
	}
	
	public AddrBook getAddrBookById(int id) throws Exception {
		return session.selectOne("getAddrBookById", id);
	}

	public int edit(AddrBook ab) {
		return session.update("edit", ab);
	}
	public int delete(int abId) {
		return session.delete("edit", abId);
	}
	
}
