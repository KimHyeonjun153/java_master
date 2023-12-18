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
				+ "   AND	  TO_CHAR(s.schedule_date, 'yyyy-MM-dd') = ?";

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

	// 1-1. �� �ð�ǥ ����¡.
	public static List<Schedule> paging2(List<Schedule> scheduleList, int page) {
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
		List<Schedule> pagedScheduleList = paging2(searchSchedule, page);

		for (Schedule schedule : pagedScheduleList) {
			schedule.showInfo();
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
	void showSeats() {
		getConn();
		String[][] seat = iniSeats();

		String sql = "SELECT  ticket_id, seat_row, seat_column "//
				+ "FROM   ticket ";
		try {
			psmt = conn.prepareStatement(sql);
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
	void updateSeats(int schedulId) {
		getConn();
		String sql = "UPDATE  schedule "//
				+ "SET     remain_seat = 50 - (SELECT  COUNT(*) "//
				+ "                            FROM    ticket "//
				+ "                            WHERE   schedule_id = ?) "//
				+ "WHERE   schedule_id = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, schedulId);
			psmt.setInt(2, schedulId);

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

}
