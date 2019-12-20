package com.bigdata2019.guestbook.dao.test;

import java.util.List;

import com.bigdata2019.guestbook.dao.GuestbookDao;
import com.bigdata2019.guestbook.vo.GuestbookVo;

public class GuestbookDaoTest {

	public static void main(String[] args) {
		//testInsert();
		testFindAll();
	}

	public static void testFindAll() {
		List<GuestbookVo> list = new GuestbookDao().findAll();
		for(GuestbookVo vo : list) {
			System.out.println(vo);
		}
	}
	
	public static void testInsert() {
		GuestbookVo vo = new GuestbookVo();
		vo.setName("또치");
		vo.setPassword("1234");
		vo.setContents("테스트입니다.");
		
		new GuestbookDao().insert(vo);
	}
}
