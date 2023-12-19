package com.yedam;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
		String sql = "INSERT INTO  ticket "//
				+ "VALUES      (ticket_id_seq.NEXTVAL,?,?,?,?,?,?,?,"//
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
		String sql = "SELECT  * "//
				+ "FROM    ticket "//
				+ "WHERE   seat_row = ? "//
				+ "AND     seat_column = ?";
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
				System.out.printf("%3s %-15s %20s %7s %4s %-2d %20s\n", //
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

	// ��ü ���� ���� ��������
	List<Ticket> getTicketList(String date) {
		getConn();
		List<Ticket> tickets = new ArrayList<>();
		String sql = "SELECT  ticket_id, user_id, schedule_id, "//
				+ "			  age, seat_row, seat_column, discount, price, reserve_date " //
				+ "FROM    ticket "//
				+ "WHERE   TO_CHAR(reserve_date, 'yyyy-MM-dd') = ? " + "ORDER BY 1";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, date);
			rs = psmt.executeQuery();

			while (rs.next()) {
				Ticket ticket = new Ticket(getSequence(tickets), rs.getInt("ticket_id"), rs.getString("user_id"),
						rs.getInt("schedule_id"), rs.getString("age"), rs.getString("seat_row"),
						rs.getInt("seat_column"), rs.getString("discount"), rs.getInt("price"),
						rs.getString("reserve_date"));
				tickets.add(ticket);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disConn();
		}
		return tickets;
	}

	// ����¡
	public static List<Ticket> paging(List<Ticket> ticketList, int page) {
		List<Ticket> resultList = new ArrayList<>();

		int start = (page - 1) * 5; // 0 ���� ����
		int end = page * 5; // 5 ������ (5��)

		for (int i = 0; i < ticketList.size(); i++) {
			if (i >= start && i < end) {
				resultList.add(ticketList.get(i));
			}
		}
		return resultList;
	}

	// ���ų��� ����¡�ؼ� ���
	public void showScheduleList(List<Ticket> searchTicket, int page) {
		List<Ticket> pagedTicketList = paging(searchTicket, page);

		for (Ticket ticket : pagedTicketList) {
			ticket.showInfo();
		}
	}

	// ��ȣ �ڵ� �ű��
	public static int getSequence(List<Ticket> schedules) {
		int seqNum = 1;
		int maxNum = 0; // �ִ� ��ȣ �� ����

		for (Ticket schdl : schedules) {
			if (schdl.getNum() > maxNum) {
				maxNum = schdl.getNum();
			}
		}
		seqNum = maxNum + 1;
		return seqNum;
	}

	// 3. �¼� ����
	boolean modifyTicket(int ticketId, String row, int column) {
		getConn();
		String sql = "UPDATE ticket "//
				+ "SET    seat_row = ?, seat_column = ? "//
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

	int getScheduleId(int ticketId) {
		getConn();
		String sql = "SELECT  t.ticket_id, s.schedule_id "//
				+ "FROM    ticket t, schedule s "//
				+ "WHERE   t.schedule_id = s.schedule_id "//
				+ "AND     t.ticket_id = ?";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, ticketId);

			rs = psmt.executeQuery();
			if (rs.next()) {
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
	boolean checkTicket(String userId, int ticketId) {
		getConn();
		String sql = "SELECT   * "//
				+ "FROM    ticket "//
				+ "WHERE   user_id = ? "//
				+ "AND     ticket_id = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, userId);
			psmt.setInt(2, ticketId);

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

	// 5. ���� ���
	boolean deleteTicket(int ticketId) {
		getConn();
		String sql = "DELETE  ticket "//
				+ "WHERE   ticket_id = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, ticketId);

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

	// ���� ���� ��ȸ
	void dailySales() {
		getConn();
		String sql = "SELECT  COUNT(*) count, SUM(price) sum "
					+ "FROM    ticket "
					+ "WHERE   TO_CHAR(reserve_date, 'YYYY-MM-DD') =  TO_CHAR(SYSDATE, 'YYYY-MM-DD')";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			if (rs.next()) {
				System.out.println("������ ���� �� : " + rs.getInt("count"));
				System.out.println("������ ����    : " + rs.getInt("sum") + "��");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disConn();
		}
	}

}
