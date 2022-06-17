package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.GuestBookVo;

@Repository
public class GuestBookDao {

	@Autowired
	private SqlSession sqlSession;

	// select
	public List<GuestBookVo> getList() {
		List<GuestBookVo> gList = sqlSession.selectList("guestbook.selectList");
		System.out.println(gList);
		return gList;
	}

	// insert
	public int insert(GuestBookVo guestBookVo) {
		int count = -1;
		count = sqlSession.insert("guestbook.insert", guestBookVo);
		return count;
	}

	// search individual
	public GuestBookVo getList(int no) {
		GuestBookVo guestBookVo = null;
		guestBookVo = sqlSession.selectOne("guestbook.getList", no);
		return guestBookVo;
	}

	// delete
	public int delete(String password, int no) {
		int count = -1;
		count = sqlSession.delete("guestbook.delete", password);
		System.out.println(count + "건 삭제되었습니다.");
		return count;
	}

}
