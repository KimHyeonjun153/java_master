package com.yedam;

import java.sql.*;

public class TicketDAO {

	Connection conn;
	PreparedStatement psmt;
	ResultSet rs;

	// 0. ����Ŭ DB ����.
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

	// 1. Ƽ�� ����
	boolean reserveTicket(Ticket ticket) {
		getConn();
		String sql = "INSERT INTO  ticket " + "VALUES      (ticket_id_seq.NEXTVAL,?,?,?,?,?,?,?,"
				+ "TO_DATE(?, 'YYYY-MM-DD HH24:MI:SS'))";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, ticket.getUser_id());
			psmt.setInt(2, ticket.getSchedule_id());
			psmt.setString(3, ticket.getAge());
			psmt.setString(4, ticket.getSeat_row().toUpperCase());
			psmt.setInt(5, ticket.getSeat_column());
			psmt.setString(6, ticket.getDiscount());
			psmt.setInt(7, ticket.getPrice());
			psmt.setString(8, ticket.getReserveDate());

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

//	
	// 1-1. ���ڸ� ã��
	boolean isOccupied(String row, int column) {
		getConn();
		String sql = "SELECT  * " + "FROM    ticket " + "WHERE   seat_row = ? " + "AND     seat_column = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, row);
			psmt.setInt(2, column);
			rs = psmt.executeQuery();

			if (rs.next()) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disConn();
		}
		return false;
	}

	// 2. ���� Ȯ��
	void showTicket(String userId) {
		getConn();
		String sql = "SELECT  t.ticket_id, s.schedule_id, TO_CHAR(s.schedule_date, 'YYYY-MM-DD HH24:MI') str_date, "//
				+ "			  m.movie_name, t.age, t.seat_row, t.seat_column, "//
				+ "			  TO_CHAR(t.reserve_date, 'YYYY-MM-DD HH24:MI:SS') rsv_date "//
				+ "FROM    ticket t, schedule s, movie m "//
				+ "WHERE   t.schedule_id = s.schedule_id "//
				+ "AND     s.movie_id = m.movie_id "//
				+ "AND     t.user_id = ? " + "ORDER BY 1";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, userId);
			rs = psmt.executeQuery();

			while (rs.next()) {
				System.out.printf("%3s %15s %20s %5s %2s %2d %20s\n", //
						rs.getString("ticket_id"), rs.getString("movie_name"), rs.getString("str_date"), //
						rs.getString("age"), rs.getString("seat_row"), //
						rs.getInt("seat_column"), rs.getString("rsv_date"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disConn();
		}
	}

	// 3. �¼� ����
	boolean modifyTicket(int ticketId, String row, int column) {
		getConn();
		String sql = "UPDATE ticket "
				   + "SET    seat_row = ?, seat_column = ? "
				   + "WHERE  ticket_id = ? ";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, row);
			psmt.setInt(2, column);
			psmt.setInt(3, ticketId);

			int r = psmt.executeUpdate();
			if (r > 0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disConn();
		}
		return false;
	}
	
	int getScheduleId(int modNum) {
		getConn();
		String sql = "SELECT  t.ticket_id, s.schedule_id "
				   + "FROM    ticket t, schedule s "
				   + "WHERE   t.schedule_id = s.schedule_id "
				   + "AND     t.ticket_id = ?";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, modNum);

			rs = psmt.executeQuery();
			if(rs.next()) {
				return rs.getInt("schedule_id");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disConn();
		}
		return 0;
		
	}

	// 4. ���� ���� Ȯ��
	boolean checkTicket(String userId, int delNum) {
		getConn();
		String sql = "SELECT   * "
				   + "FROM    ticket "
				   + "WHERE   user_id = ? "
				   + "AND     ticket_id = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, userId);
			psmt.setInt(2, delNum);

			rs = psmt.executeQuery();
			if (rs.next()) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disConn();
		}
		return false;
	}

}
