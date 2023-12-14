package todo.p20231214;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookApp {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
//		BookExe exe = new BookExe();
		BookDAO dao = new BookDAO();
		boolean run = true;
		
		while(run) {

			System.out.println();
			System.out.println("��������������������������������������������������������������������������������������������������������������������������������������������");
			System.out.println("�� 1.���� ��� �� 2.��� ��ȸ �� 3.�ܰ� ��ȸ �� 4.���� �� 5.���� �� 6.���� ��");
			System.out.println("��������������������������������������������������������������������������������������������������������������������������������������������");
			System.out.print("������ �Է��ϼ��� \n>> ");
			int menu = 0;
			try {
				menu = Integer.parseInt(scn.nextLine());
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
			switch(menu) {
			// 1.���� ���.
			case 1:
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
				}
				Book book = new Book(bookCode, bookName, author, publisher, bookCost);
				
				if(dao.addBook(book)) {
					System.out.println("���� ������ ��ϵǾ����ϴ�");
				}
				else {
					System.out.println("���� ���� ��Ͽ� �����߽��ϴ�");
				}
				break;
				
			// 2.��� ��ȸ.
			case 2:
				System.out.println("< ���� ��� ��ȸ >");
				System.out.printf("%7s %10s %10s %11s %10s\n", "�����ڵ�", "������", "����", "���ǻ�", "����");
				System.out.println("======================================================================");
				
				List<Book> books = new ArrayList<>();
				books =	dao.getBookList();
				
				for (int i = 0; i < books.size(); i++) {
					books.get(i).showInfo();
				}
				break;
				
			// 3.�ܰ� ��ȸ.
			case 3:
				System.out.println("< ���� �ܰ� ��ȸ >");
				System.out.print("���� �ڵ带 �Է��ϼ��� \n>> ");
				bookCode = scn.nextLine();
				System.out.printf("%7s %10s %10s %11s %10s\n", "�����ڵ�", "������", "����", "���ǻ�", "����");
				System.out.println("======================================================================");
				
				Book bk = dao.getBook(bookCode);
				bk.showInfo();
				break;
					
			// 3.���� ����.	
			case 4:
				System.out.println("< ���� ���� ���� >");
				System.out.print("������ ���� �ڵ带 �Է��ϼ��� \n>> ");
				bookCode = scn.nextLine();
				System.out.print("������ �Է��ϼ��� \n>> ");
				bookCost = 0;
				try {
					bookCost = Integer.parseInt(scn.nextLine());
				} catch (Exception e) {
					System.out.println("�ùٸ� ���� ������ �Է��ϼ���");
					return;
				}if (dao.modifyBook(bookCode, bookCost))
					System.out.println("���� ������ �����Ǿ����ϴ�");
				else
					System.out.println("ã�� ���� ������ �����ϴ�");
				break;
				
			// 4.���� ����.
			case 5:
				System.out.println("< ���� ���� ���� >");
				System.out.print("������ ���� �ڵ带 �Է��ϼ��� \n>> ");
				bookCode = scn.nextLine();
				System.out.print("������ �����Ͻðڽ��ϱ�? (Y/N) \n>> ");
				String yesNo = scn.nextLine();
				
				if (yesNo.equals("Y") || yesNo.equals("y")) {
					if(dao.removeBook(bookCode)) {
					System.out.println("���� ������ �����Ǿ����ϴ�");
					} 
					else {
					System.out.println("ã�� ���� ������ �����ϴ�");
					}
				} 
				else {
					System.out.println("���� ���� ������ ��ҵǾ����ϴ�");
				}
				
				
				break;
				
			// 5.����.
			case 6:
				System.out.println("���α׷��� �����մϴ�.");
				scn.close();
				run = false;
				break;
				
			default:
				System.out.println("�ùٸ� ������ �Է��ϼ���");
			} // end of switch.
			
		} // end of while.
		
		System.out.println("end of prog.");
		
	} // end of main.

}
