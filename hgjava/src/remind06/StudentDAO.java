package remind06;

import java.sql.*;

// ������� : Oracle DB.

// �߰�, ����, ����(executeUpdate) / ���, �ܰ� ��ȸ(executeQuery) ���.
public class StudentDAO {

	Connection conn;
	PreparedStatement psmt;
	ResultSet rs;
	
	// ����Ŭ DB�� ����
	Connection getConn() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection(url, "dev", "dev");
			System.out.println("���Ἲ��!!");
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return conn;
	}
	
	
	// ��� ��ȸ.
	Student[] getStudentList() {
		getConn();
		Student[] students = new Student[10];
		String sql = "SELECT * FROM student ORDER BY 1";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			// Resultset.next() : ������ �ڸ��� ����Ű�� Ŀ��
			//                    �����Ͱ� �ִ� �� ����Ű�� TRUE, ���� �� ����Ű�� FALSE
			while(rs.next()) {
				Student student = new Student();
				student.setStuNum(rs.getString("student_number"));
				student.setStuName(rs.getString("student_name"));
				student.setEngScore(rs.getInt("english_score"));
				student.setMathScore(rs.getInt("mathematics_score"));
				
				// �迭�� �� ���� �� �� ����.				
				for (int i = 0; i < students.length; i++) {
					if(students[i] == null) { 
						students[i] = student;
						break; // for �ݺ��� ����.
						
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return students;
	}
	
	// ���� �߰�.
	boolean addStudent(Student std) {
		getConn();
		String sql = "INSERT INTO student VALUES(?, ?, ?, ?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, std.getStuNum());
			psmt.setString(2, std.getStuName());
			psmt.setInt(3, std.getEngScore());
			psmt.setInt(4, std.getMathScore());
			
			int r = psmt.executeUpdate(); // ó���� �Ǽ� ��ȯ => �� �� ó���� 1
			if(r == 1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	// �ܰ� ��ȸ.
	Student getStudent(String sno) {
		getConn();
		String sql = "SELECT * FROM student WHERE student_number = ?";	// ����ǥ ����ǥ ������ �ȵ�
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, sno);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				Student student = new Student();
				student.setStuNum(rs.getString("student_number"));
				student.setStuName(rs.getString("student_name"));
				student.setEngScore(rs.getInt("english_score"));
				student.setMathScore(rs.getInt("mathematics_score"));
				return student;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;	// ��ȸ�� �� ������ null�� ��ȯ
	}
	
	// ���� ����.
	boolean modifyStudent(String num, int eng, int math) {
		getConn();
		String sql = "UPDATE student "//
				   + "SET    english_score = ?, "//
				   + "       mathematics_score = ? "//
				   + "WHERE  student_number = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, eng);
			psmt.setInt(2, math);
			psmt.setString(3, num);
			int r = psmt.executeUpdate();
			if(r > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	// ���� ����.
	boolean removeStudent(String name) {
		getConn();
		String sql = "DELETE student "
				   + "WHERE  student_name = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1,name);
			int r = psmt.executeUpdate();
			if(r > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
