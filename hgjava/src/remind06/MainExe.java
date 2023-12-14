package remind06;

import java.sql.*;

public class MainExe {

	static Connection conn;
	public static void main(String[] args) {

		// jdbc lib.
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		try {
			// jdbc ����̹� ����. 
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection(url, "dev", "dev"); // => dev ���� ����.
			System.out.println("���Ἲ��!!");
			
			// SELECT ���� �Լ�
			select();
			
			// INSERT ����
			String sql = "INSERT INTO student VALUES(?, ?, ?, ?)";
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1,  "23-003");
			psmt.setString(2,  "�ھ�");
			psmt.setInt(3, 80);
			psmt.setInt(4, 85);
			
			// �Է�, ����, ���� => executeUpdate();
			int r = psmt.executeUpdate();
			if(r == 1) {
				System.out.println("�Է� ����!!");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
//			System.out.println("Driver ����.");
		}
		
	} // end of main.
	
	public static void select() throws Exception{
		// SQL ������ �ۼ�.
		// ������ ������ SQLSyntaxError => Į���� ��ŸX, �����ݷ� �������.
		String sql = "select * from student";	
		PreparedStatement psmt = conn.prepareStatement(sql);
		ResultSet rs = psmt.executeQuery();
		
		// SQL ������� ���.
		while(rs.next()) {
			System.out.println("��ȣ: " + rs.getString("student_number")//
						   + ", �̸�: " + rs.getString("student_name")//
						   + ", ����: " + rs.getInt("english_score")//
						   + ", ����: " + rs.getInt("mathematics_score"));
		}
	}
} // end of class.

