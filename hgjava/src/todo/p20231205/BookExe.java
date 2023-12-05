package todo.p20231205;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookExe {

	private List<Book> books;
	Scanner scn = new Scanner(System.in);

	BookExe() {
		books = new ArrayList<>();
		books.add(new Book("B001", "�̰��� �ڹٴ�", "�ſ��", "�Ѻ��̵��", 25000));
		books.add(new Book("C003", "�ڹ� ����", "�����", "�������ۺ���", 20000));
		books.add(new Book("D001", "�ڹٸ�����", "�����", "��������ȫ��", 15000));
	}

	// 0. ���α׷� ����
	int progStart() {
		System.out.println();
		System.out.println("��������������������������������������������������������������������������������������������������������������������������������������������");
		System.out.println("�� 1.���� ��� �� 2.��� ��ȸ �� 3.�ܰ� ��ȸ �� 4.���� �� 5.���� �� 6.���� ��");
		System.out.println("��������������������������������������������������������������������������������������������������������������������������������������������");
		System.out.print("������ �Է��ϼ��� \n>> ");
		int menu = 0;
		try {
			menu = Integer.parseInt(scn.nextLine());
		} catch (Exception e) {
			return menu;
		}
		return menu;
	}

	// 1. ���� ���.
	void addBook() {
		System.out.println("< ���� ��� >");
		System.out.print("���� �ڵ带 �Է��ϼ��� \n>> ");
		String bookCode = scn.nextLine();
		System.out.print("�������� �Է��ϼ��� \n>> ");
		String bookName = scn.nextLine();
		System.out.print("���ڸ� �Է��ϼ��� \n>> ");
		String author = scn.nextLine();
		System.out.print("���ǻ縦 �Է��ϼ��� \n>> ");
		String publisher = scn.nextLine();
		System.out.print("������ �Է��ϼ��� \n>> ");
		int bookCost = 0;
		try {
			bookCost = Integer.parseInt(scn.nextLine());
		} catch (Exception e) {
			System.out.println("�ùٸ� ���� ������ �Է��ϼ���");
			return;
		}
		books.add(new Book(bookCode, bookName, author, publisher, bookCost));
		System.out.println("���� ������ ��ϵǾ����ϴ�");
	}

	// 2. ���� ��� ��ȸ.
	void showBookList() {
		System.out.println("< ���� ��� ��ȸ >");
		System.out.printf("%7s %10s %10s %11s %10s\n", "�����ڵ�", "������", "����", "���ǻ�", "����");
		System.out.println("======================================================================");
		for (Book book : books) {
			book.showInfo();
		}
	}

	// 3. ���� �ܰ� ��ȸ
	void showBook() {
		System.out.println("< ���� �ܰ� ��ȸ >");
		System.out.print("���� �ڵ带 �Է��ϼ��� \n>> ");
		String bookCode = scn.nextLine();
		System.out.printf("%7s %10s %10s %11s %10s\n", "�����ڵ�", "������", "����", "���ǻ�", "����");
		System.out.println("======================================================================");
		boolean chk = false;
		for (Book book : books) {
			if (book.getBookCode().equals(bookCode)) {
				book.showInfo();
				chk = true;
			}
		}
		if (!chk)
			System.out.println("ã�� ������ �����ϴ�");
	}

	// 4. ���� ���� ����.
	void modifyBook() {
		System.out.println("< ���� ���� ���� >");
		System.out.print("������ ���� �ڵ带 �Է��ϼ��� \n>> ");
		String bookCode = scn.nextLine();
		System.out.print("������ �Է��ϼ��� \n>> ");
		int bookCost = 0;
		try {
			bookCost = Integer.parseInt(scn.nextLine());
		} catch (Exception e) {
			System.out.println("�ùٸ� ���� ������ �Է��ϼ���");
			return;
		}
		boolean chk = false;
		for (Book book : books) {
			if (book.getBookCode().equals(bookCode)) {
				book.setBookCost(bookCost);
				chk = true;
			}
		}
		if (chk)
			System.out.println("���� ������ �����Ǿ����ϴ�");
		else
			System.out.println("ã�� ���� ������ �����ϴ�");
	}

	// 5. ���� ���� ����
	void removeBook() {
		System.out.println("< ���� ���� ���� >");
		System.out.print("������ ���� �ڵ带 �Է��ϼ��� \n>> ");
		String bookCode = scn.nextLine();
		System.out.print("������ �����Ͻðڽ��ϱ�? (Y/N) \n>> ");
		String yesNo = scn.nextLine();
		boolean chk = false;
		if (yesNo.equals("Y") || yesNo.equals("y")) {
			for (int i = 0; i < books.size(); i++) {
				if (books.get(i).getBookCode().equals(bookCode)) {
					books.remove(i);
					chk = true;
				}
			}
		} else {
			System.out.println("���� ���� ������ ��ҵǾ����ϴ�");
			return;
		}
		if (chk)
			System.out.println("���� ������ �����Ǿ����ϴ�");
		else
			System.out.println("ã�� ���� ������ �����ϴ�");
	}

}
