package com.yedam;

import java.sql.*;

public class UserDAO {

	Connection conn;
	PreparedStatement psmt;
	ResultSet rs;
	
	// 0. ����Ŭ DB ����
	Connection getConn() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection(url, "dev", "dev");
//			System.out.println("���Ἲ��!!");
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return conn;
	}
	
	// 1. �α���.
	boolean login(String id, String pw) {
		getConn();
		String sql = "SELECT	* "//
				   + "FROM		t_user "//
				   + "WHERE		user_id = ? "//
				   + "AND		passwd = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, pw);
			
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	// 1-1. ȸ�� �̸� ��������
	String getName(String userId) {
		getConn();
		String sql = "SELECT * "//
				   + "FROM   t_user "//
				   + "WHERE  user_id = ?";
		String userName = "";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, userId);
			
			rs = psmt.executeQuery();
			if(rs.next()){
				userName = rs.getString("user_name");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userName;
	}
	
	// 2. ȸ�� ����.
	boolean signUp(User user) {
		getConn();
		String sql = "INSERT INTO t_user(user_id, passwd, user_name, user_tel) "
				   + "VALUES (?, ?, ?, ?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, user.getUserId());
			psmt.setString(2, user.getPasswd());
			psmt.setString(3, user.getUserName());
			psmt.setString(4, user.getUserTel());
			
			int r = psmt.executeUpdate(); // ó���� �Ǽ� ��ȯ => �� �� ó���� 1
			if(r > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;		
	}
	
	
	
}
