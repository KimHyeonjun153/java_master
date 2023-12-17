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

	// 4. ��ȭ ����
	// 4-1. �� �ð�ǥ ��������// �ʵ�.
	List<Schedule> getScheduleList(String movieId, String strDate) {
		List<Schedule> schedule = new ArrayList<>();
		String sql = "SELECT  s.schedule_id, m.movie_name, "
				+ "        TO_CHAR(s.schedule_date, 'yyyy-MM-dd_HH24:MI') date_time,"
				+ "		  s.remain_seat, s.discount " + "FROM    schedule s, movie m "
				+ "where   s.movie_id = m.movie_id " + "AND     s.movie_id = ? "
				+ "AND	  s.schedule_date >= TO_DATE(?, 'yyyy-MM-dd')";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, movieId);
			psmt.setString(2, strDate);
			rs = psmt.executeQuery();

			while (rs.next()) {
				Schedule schdl = new Schedule(rs.getString("schedule_id"), rs.getString("movie_name"),
						rs.getString("date_time"), rs.getInt("remain_seat"), rs.getString("discount"));

				schedule.add(schdl);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return schedule;
	}

	// 4-1. �� �ð�ǥ ����¡.
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

	// 4-2. �󿵽ð�ǥ ����¡�ؼ� ���
	public void showScheduleList(List<Schedule> searchSchedule, int page) {
		List<Schedule> pagedScheduleList = paging2(searchSchedule, page);

		for (Schedule schedule : pagedScheduleList) {
			schedule.showInfo();
		}
	}

}
