package com.bigdata2019.guestbook.dao.test;

import java.util.List;

import com.bigdata2019.guestbook.dao.GuestbookDao;
import com.bigdata2019.guestbook.vo.GuestbookVo;

public class GuestbookDaoTest {

	public static void main(String[] args) {
		testInsert();
		//testDelete();
		testFindAll();
	}

	public static void testFindAll() {
		List<GuestbookVo> list = new GuestbookDao().findAll();
		for(GuestbookVo vo : list) {
			System.out.println(vo);
		}
	}
	
	public static void testDelete() {
		new GuestbookDao().delete(3L, "1234");
	}
	
	public static void testInsert() {
		GuestbookVo vo = new GuestbookVo();
		vo.setName("두번째사람");
		vo.setPassword("1234");
		vo.setContents("2");
		
		new GuestbookDao().insert(vo);
	}
}
