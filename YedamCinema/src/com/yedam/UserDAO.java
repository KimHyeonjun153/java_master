package com.yedam;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

	Connection conn;
	PreparedStatement psmt;
	ResultSet rs;

	// 0. ����Ŭ DB ����
	Connection getConn() {
		String url = "jdbc:oracle:thin:@192.168.0.35:1521:xe";
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection(url, "dev", "dev");
//			System.out.println("���Ἲ��!!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	// 0-1. DB ���� ����
	void disConn() {
		try {
			if (conn != null)
				conn.close();
			if (rs != null)
				rs.close();
			if (psmt != null)
				psmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	User getUser(String userId) {
		getConn();
		User user = new User();
		String sql = "SELECT * "//
				+ "	  FROM	 t_user "//
				+ "   WHERE  user_id = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, userId);

			rs = psmt.executeQuery();

			if (rs.next()) {
				user.setUserId(rs.getString("user_id"));
				user.setPasswd(rs.getString("passwd"));
				user.setUserName(rs.getString("user_name"));
				user.setUserTel(rs.getString("user_tel"));
				user.setJoinDate(rs.getString("join_date"));
				return user;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConn();
		}
		return null;
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

			if (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConn();
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
			if (rs.next()) {
				userName = rs.getString("user_name");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConn();
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
			if (r > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConn();
		}
		return false;
	}

	// 2-1. �ߺ� ���̵� ���� ����
	boolean chkUserId(String userId) {
		getConn();
		String sql = "SELECT * "//
				+ "FROM   t_user "//
				+ "WHERE  user_id = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, userId);

			rs = psmt.executeQuery();
			if (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConn();
		}
		return false;
	}
	
	// ���� ���� ��������
	List<User> getUserList() {
		getConn();
		List<User> users = new ArrayList<>();
		String sql = "SELECT * "//
				+ "FROM   t_user "//
				+ "ORDER BY 1";

		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();

			while (rs.next()) {
				User user = new User(getSequence(users),rs.getString("user_id"), rs.getString("passwd"), rs.getString("user_name"),
						rs.getString("user_tel"), rs.getString("join_date"));
				users.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disConn();
		}
		return users;
	}

	// ����¡
	public static List<User> paging(List<User> userList, int page) {
		List<User> resultList = new ArrayList<>();

		int start = (page - 1) * 5; // 0 ���� ����
		int end = page * 5; // 5 ������ (5��)

		for (int i = 0; i < userList.size(); i++) {
			if (i >= start && i < end) {
				resultList.add(userList.get(i));
			}
		}
		return resultList;
	}

	// ���ų��� ����¡�ؼ� ���
	public void showUserList(List<User> searchTicket, int page) {
		List<User> pagedTicketList = paging(searchTicket, page);

		for (User user : pagedTicketList) {
			user.showUserInfo();
		}
	}

	// ��ȣ �ڵ� �ű��
	public static int getSequence(List<User> users) {
		int seqNum = 1;
		int maxNum = 0; // �ִ� ��ȣ �� ����

		for (User user : users) {
			if (user.getNum() > maxNum) {
				maxNum = user.getNum();
			}
		}
		seqNum = maxNum + 1;
		return seqNum;
	}

	// ���� ����
	boolean deleteUser(String userId) {
		getConn();
		String sql = "DELETE t_user " 
					+ "WHERE user_id = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, userId);
			
			int r = psmt.executeUpdate(); // ó���� �Ǽ� ��ȯ => �� �� ó���� 1
			if (r > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			disConn();
		}
		return false;
	}
	
}
