package com.bigdata2019.guestbook.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bigdata2019.guestbook.vo.GuestbookVo;

public class GuestbookDao {
	
	public List<GuestbookVo> findAll(){
		List<GuestbookVo> result = new ArrayList<GuestbookVo>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			
			String sql = 
"   select no," + 
"          name," + 
"          contents," + 
"          date_format(reg_date, '%Y-%c-%d %h:%i:%s')" + 
"     from guestbook" + 
" order by no desc";
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				GuestbookVo vo = new GuestbookVo();
				vo.setNo(rs.getLong(1));
				vo.setName(rs.getString(2));
				vo.setContents(rs.getString(3));
				vo.setRegDate(rs.getString(4));
				
				result.add(vo);
			}
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 클래스 로딩 실패:" + e);
		} catch (SQLException e) {
			System.out.println("에러:" + e);
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(stmt != null) {
					stmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	
		return result;
	}
	
	private Connection getConnection() throws ClassNotFoundException, SQLException {
		//1. JDBC Driver(Mysql) 로딩
		Class.forName("com.mysql.jdbc.Driver");
		
		//2. 연결하기
		String url = "jdbc:mysql://localhost:3306/webdb";
		Connection conn = DriverManager.getConnection(url, "webdb", "webdb");
		
		return conn;
	}	
}
