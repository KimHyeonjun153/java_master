package com.yedam;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ScheduleDAO {

	Connection conn;
	PreparedStatement psmt;
	ResultSet rs;

	// 0. ����Ŭ DB ����.
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

	Schedule getSchedule(int ticketNum) {
		getConn();
		Schedule schedule = new Schedule();
		String sql = "SELECT * "//
				+ "FROM   schedule "//
				+ "WHERE  schedule_id = (SELECT schedule_id "//
				+ "                      FROM   ticket "//
				+ "                      WHERE  ticket_id = ?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, ticketNum);
			rs = psmt.executeQuery();

			while (rs.next()) {
				schedule.setScheduleId(rs.getInt("schedule_id"));
				schedule.setMovieId(rs.getString("movie_id"));
				schedule.setMovieDate(rs.getString("schedule_date"));
				schedule.setRemainSeat(rs.getInt("remain_seat"));		
				schedule.setDiscount(rs.getString("discount"));
				return schedule;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConn();
		}
		return schedule;
	}
	
	// 1. �� �ð�ǥ ��������.
	List<Schedule> getScheduleList(String movieId, String strDate) {
		getConn();
		List<Schedule> schedule = new ArrayList<>();
		String sql = "SELECT  s.schedule_id, m.movie_name, "//
				+ "        TO_CHAR(s.schedule_date, 'yyyy-MM-dd HH24:MI') date_time, "//
				+ "		  s.remain_seat, s.discount  "//
				+ "   FROM    schedule s, movie m "//
				+ "   WHERE   s.movie_id = m.movie_id "//
				+ "   AND     s.movie_id = ? "//
				+ "   AND	  TO_CHAR(s.schedule_date, 'yyyy-MM-dd') = ? "//
				+ "   ORDER BY 3";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, movieId);
			psmt.setString(2, strDate);
			rs = psmt.executeQuery();

			while (rs.next()) {
				Schedule schdl = new Schedule(getSequence(schedule), rs.getInt("schedule_id"),
						rs.getString("movie_name"), rs.getString("date_time"), rs.getInt("remain_seat"),
						rs.getString("discount"));

				schedule.add(schdl);
			}
		} catch (SQLException e) {
			return schedule;
		} finally {
			disConn();
		}
		return schedule;
	}

	// 1-0. �����ڿ� �� ��� ��������
	List<Schedule> getAllScheduleList(String strDate) {
		getConn();
		List<Schedule> schedule = new ArrayList<>();
		String sql = "SELECT  s.schedule_id, m.movie_name, m.movie_id, "//
				+ "        TO_CHAR(s.schedule_date, 'yyyy-MM-dd HH24:MI') date_time, "//
				+ "		  s.remain_seat, s.discount  "//
				+ "   FROM    schedule s, movie m "//
				+ "   WHERE   s.movie_id = m.movie_id "//
				+ "   AND	  TO_CHAR(s.schedule_date, 'yyyy-MM-dd') = ? "//
				+ "   ORDER BY 3, 4";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, strDate);
			rs = psmt.executeQuery();

			while (rs.next()) {
				Schedule schdl = new Schedule(getSequence(schedule), rs.getInt("schedule_id"),
						rs.getString("movie_name"), rs.getString("date_time"), rs.getInt("remain_seat"),
						rs.getString("discount"));

				schedule.add(schdl);
			}
		} catch (SQLException e) {
			return schedule;
		} finally {
			disConn();
		}
		return schedule;
	}

	// 1-1. �� �ð�ǥ ����¡.
	public static List<Schedule> paging(List<Schedule> scheduleList, int page) {
		List<Schedule> resultList = new ArrayList<>();

		int start = (page - 1) * 5; // 0 ���� ����
		int end = page * 5; // 5 ������ (5��)

		for (int i = 0; i < scheduleList.size(); i++) {
			if (i >= start && i < end) {
				resultList.add(scheduleList.get(i));
			}
		}
		return resultList;
	}

	// 1-2. �󿵽ð�ǥ ����¡�ؼ� ���
	public void showScheduleList(List<Schedule> searchSchedule, int page) {
		List<Schedule> pagedScheduleList = paging(searchSchedule, page);

		for (Schedule schedule : pagedScheduleList) {
			schedule.showInfo();
		}
	}
	
	public void showScheduleList2(List<Schedule> searchSchedule, int page) {
		List<Schedule> pagedScheduleList = paging(searchSchedule, page);

		for (Schedule schedule : pagedScheduleList) {
			schedule.showInfo2();
		}
	}

	// 1-3. ��ȣ �ڵ� �ű��
	public static int getSequence(List<Schedule> schedules) {
		int seqNum = 1;
		int maxNum = 0; // �ִ� ��ȣ �� ����

		for (Schedule schdl : schedules) {
			if (schdl.getNum() > maxNum) {
				maxNum = schdl.getNum();
			}
		}
		seqNum = maxNum + 1;
		return seqNum;
	}

	// 1-4. scheduleId ��������
	int getScheduleId(int scheduleNum, List<Schedule> schedules) {
		for (Schedule schdl : schedules) {
			if (schdl.getNum() == scheduleNum) {
				return schdl.getScheduleId();
			}
		}
		return 0;
	}

	// 1-5. discount ��������
	String getDiscount(int scheduleNum, List<Schedule> schedules) {
		for (Schedule schdl : schedules) {
			if (schdl.getNum() == scheduleNum) {
				return schdl.getDiscount();
			}
		}
		return null;
	}

	// 2. �¼� ���
	// 2-1. �¼� �ʱ�ȭ
	String[][] iniSeats() {
		String[][] seat = new String[5][11];
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 11; j++) {
				seat[i][j] = "��";
			}
		}
		return seat;
	}

	// 2-2. �¼� ���
	void showSeats(int scheduleId) {
		getConn();
		String[][] seat = iniSeats();

		String sql = "SELECT  ticket_id, seat_row, seat_column "//
				+ "FROM   ticket "
				+ "WHERE  schedule_id = ? ";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, scheduleId);
			rs = psmt.executeQuery();

			int seat_row = 0;

			while (rs.next()) {
				switch (rs.getString("seat_row")) {
				case "A":
				case "a":
					seat_row = 0;
					break;
				case "B":
				case "b":
					seat_row = 1;
					break;
				case "C":
				case "c":
					seat_row = 2;
					break;
				case "D":
				case "d":
					seat_row = 3;
					break;
				case "E":
				case "e":
					seat_row = 4;
				}
				seat[seat_row][rs.getInt("seat_column")] = "��";
			}
		} catch (SQLException e) {
			return;
		}

		char row = 'A';
		System.out.println("  1 2 3 4 5 6 7 8 9 10");
		for (int i = 0; i < 5; i++) {
			System.out.print(row + " ");

			for (int j = 1; j < 11; j++) {
				System.out.print(seat[i][j] + " ");
			}
			row++;
			System.out.println();
		}

		disConn();
	}

	// ���� �ڸ� �� DB�� �ݿ�
	void updateSeats(int scheduleId) {
		getConn();
		String sql = "UPDATE  schedule "//
				+ "SET     remain_seat = 50 - (SELECT  COUNT(*) "//
				+ "                            FROM    ticket "//
				+ "                            WHERE   schedule_id = ?) "//
				+ "WHERE   schedule_id = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, scheduleId);
			psmt.setInt(2, scheduleId);

			int r = psmt.executeUpdate(); // ó���� �Ǽ� ��ȯ => �� �� ó���� 1

			if (r > 0) {
				return;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConn();
		}
		return;

	}

	boolean addSchedule(String movieNum, String movieDate) {
		getConn();
		String sql = "INSERT INTO schedule " 
					+ "VALUES (schedule_id_seq.NEXTVAL, ?, "
					+ "TO_DATE(?, 'YYYY-MM-DD HH24:MI'), 50,' ')";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, movieNum);
			psmt.setString(2, movieDate);

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

	boolean chkSchedule(int schdlNum) {
		getConn();
		String sql = "SELECT	* " 
		           + "FROM		schedule " 
				   + "WHERE 	schedule_id = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, schdlNum);
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

	boolean delSchedule(int schdlNum) {
		getConn();
		String sql = "DELETE schedule " 
				   + "WHERE  schedule_id = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, schdlNum);
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
	
	boolean updateJojo() {
		getConn();
		String sql = "UPDATE schedule\r\n"
				+ "SET    discount = '����' "//
				+ "WHERE  TO_CHAR(schedule_date, 'HH24') <= 9 "//
				+ "AND    discount <> '����'";
		try {
			psmt = conn.prepareStatement(sql);
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

	boolean updateSimya() {
		getConn();
		String sql = "UPDATE schedule "//
				+ "SET    discount = '�ɾ�' "//
				+ "WHERE  TO_CHAR(schedule_date, 'HH24') >= 23 "//
				+ "AND    discount <> '�ɾ�'";
		try {
			psmt = conn.prepareStatement(sql);
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
	
}
