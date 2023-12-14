package todo.p20231214;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {

	Connection conn;
	PreparedStatement psmt;
	ResultSet rs;
	
	// ����Ŭ DB�� ����.
	Connection getConn() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection(url, "dev", "dev");
			System.out.println("���� ����!!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	// 1. ���� ���.
		boolean addBook(Book book) {
			getConn();
			String sql = "INSERT INTO books "//
					   + "VALUES (?, ?, ?, ?, ?)";
			try {
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, book.getBookCode());
				psmt.setString(2, book.getBookName());
				psmt.setString(3, book.getAuthor());
				psmt.setString(4, book.getPublisher());
				psmt.setInt(5, book.getBookCost());
				
				int r = psmt.executeUpdate(); // ó���� �Ǽ� ��ȯ => �� �� ó���� 1
				if(r > 0) {
					return true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return false;		
		}

		// 2. ���� ��� ��ȸ.
		List<Book> getBookList() {
			getConn();
			List<Book> books = new ArrayList<>();
			String sql = "SELECT	* "//
					   + "FROM		books "//
					   + "ORDER BY 	1";
			try {
				psmt = conn.prepareStatement(sql);
				rs = psmt.executeQuery();
				
				while(rs.next()) {
					Book book = new Book();
					book.setBookCode(rs.getString("book_code"));
					book.setBookName(rs.getString("book_name"));
					book.setAuthor(rs.getString("author"));
					book.setPublisher(rs.getString("publisher"));
					book.setBookCost(rs.getInt("book_cost"));
				
					books.add(book);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return books;
		}

		// 3. ���� �ܰ� ��ȸ
		Book getBook(String bookCode) {
			getConn();
			String sql = "SELECT   * "
					   + "FROM     books "
					   + "WHERE    book_code = ?";
			try {
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, bookCode);
				rs = psmt.executeQuery();
				
				if(rs.next()) {
					Book book = new Book();
					book.setBookCode(rs.getString("book_code"));
					book.setBookName(rs.getString("book_name"));
					book.setAuthor(rs.getString("author"));
					book.setPublisher(rs.getString("publisher"));
					book.setBookCost(rs.getInt("book_cost"));
					return book;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return null;
		}

		// 4. ���� ���� ����.
		boolean modifyBook(String bookCode, int bookCost) {
			getConn();
			String sql = "UPDATE books "//
					   + "SET    book_cost = ? "//
					   + "WHERE  book_code = ?";
			try {
				psmt = conn.prepareStatement(sql);
				psmt.setInt(1, bookCost);
				psmt.setString(2, bookCode);
				int r = psmt.executeUpdate();
				if(r > 0) {
					return true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return false;
		}

		// 5. ���� ���� ����
		boolean removeBook(String bookCode) {
			getConn();
			String sql = "DELETE books "
					   + "WHERE  book_code = ?";
			try {
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, bookCode);
				
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
