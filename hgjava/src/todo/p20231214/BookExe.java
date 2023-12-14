package todo.p20231214;

import java.util.ArrayList;
import java.util.List;

public class BookExe {

	private List<Book> books;
	

	BookExe() {
		books = new ArrayList<>();
		books.add(new Book("B001", "�̰��� �ڹٴ�", "�ſ��", "�Ѻ��̵��", 25000));
		books.add(new Book("C003", "�ڹ� ����", "�����", "�������ۺ���", 20000));
		books.add(new Book("D001", "�ڹٸ�����", "�����", "��������ȫ��", 15000));
	}

	// 1. ���� ���.
	boolean addBook(Book book) {
		books.add(book);
		return true;		
	}

	// 2. ���� ��� ��ȸ.
	void getBookList() {
		for (Book book : books) {
			book.showInfo();
		}
	}

	// 3. ���� �ܰ� ��ȸ
	boolean showBook(String bookCode) {
		for (Book book : books) {
			if (book.getBookCode().equals(bookCode)) {
				book.showInfo();
				return true;
			}
		}
		return false;
	}

	// 4. ���� ���� ����.
	boolean modifyBook(String bookCode, int bookCost) {
		
		for (Book book : books) {
			if (book.getBookCode().equals(bookCode)) {
				book.setBookCost(bookCost);
				return true;
			}
		}
		return false;
	}

	// 5. ���� ���� ����
	boolean removeBook(String bookCode) {
		for (int i = 0; i < books.size(); i++) {
			if (books.get(i).getBookCode().equals(bookCode)) {
				books.remove(i);
				return true;
			}
		}
		return false;
	}
}
