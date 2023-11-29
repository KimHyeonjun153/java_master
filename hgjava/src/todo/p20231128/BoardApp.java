package todo.p20231128;

import java.util.Scanner;

public class BoardApp {
	
	static BoardExe exe = new BoardExe();	// main�Լ� �ۿ��� ���� => static
	
	public static void main(String[] args) {
		
		UserExe uexe = new UserExe();	// UserExe Ŭ���� ������.
//		BoardExe exe = new BoardExe();	// BoardExe Ŭ���� ������.
		
		exe.initData();
		boolean run = true;
		Scanner scn = new Scanner(System.in);
		String id = null;

		while(true) {
			System.out.print("���̵� �Է��ϼ���\n>> ");
			id = scn.nextLine();
			System.out.print("��й�ȣ�� �Է��ϼ���\n>> ");
			String pw = scn.nextLine();
			User user = uexe.logIn(id, pw);
			if(user != null) {
				System.out.println(user.getUserName() + "�� ȯ���մϴ�!!");
				break;
			}
			else {
				System.out.println("���̵�� ��й�ȣ�� Ȯ���ϼ���");
			}
		}
		
		while(run) {
			System.out.println();
			System.out.println("������������������������������������������������������������������������������������������������������������������������������������");
			System.out.println("�� 1.�Խù� ��� �� 2.��� �� 3.����ȸ �� 4.���� �� 5.���� �� 6.���� ��");
			System.out.println("������������������������������������������������������������������������������������������������������������������������������������");
			System.out.print("������ �Է��ϼ��� \n>> ");
			int menu = Integer.parseInt(scn.nextLine());
			
			switch(menu) {
			// 1. �Խù� ���
			case 1: 
				System.out.println("< �Խù� ��� >");
//				System.out.print("�Խñ� ��ȣ >> ");
//				int num = Integer.parseInt(scn.nextLine());
				System.out.print("���� \n>> ");
				String title = scn.nextLine();
//				System.out.print("�ۼ��� >> ");
//				String writer = scn.nextLine();
				System.out.print("���� \n>> ");
				String content = scn.nextLine();
//				System.out.print("�Ͻ� >> ");
//				String date = scn.nextLine();
				
				Board board = new Board(exe.getSequence(), title, id,  content);
				
				if(exe.addArticle(board)) {
					System.out.println("�Խù� ����� �Ϸ�Ǿ����ϴ�!");
				}
				else {
					System.out.println("�Խù� ��Ͽ� �����߽��ϴ�");
				}
				break;
				
			// 2. ��� ��ȸ
			case 2:
				Board[] boardAry = exe.showList();
				paging(boardAry, 1);
				// ����¡ ó��
//				Board[] pageAry = exe.pageList(boardAry, 1);
//				
//				System.out.println("< ��� ��ȸ >");
//				System.out.println("�۹�ȣ\t\t ����\t\t �ۼ���\t\t �ۼ�����");
//				System.out.println("==================================================================");
//				for(Board brd : pageAry) {
//					if(brd != null) {
//						brd.showInfo();
//					}
//				}
//				System.out.println("==================================================================");
//				
//				// ��ü ������ ����ϰ� ���.
//				int count = exe.getBoardCount();
//				int totalPage = (int)Math.ceil(count/5.0);
//				for (int i = 1; i <= totalPage; i++) {
//					System.out.print(i + " ");
//				}
//				System.out.println("\n�������� �����ϼ��� \n>>");
				while(true) {
					int page = Integer.parseInt(scn.nextLine());
					if(page == 0) {
						break;
					}
					paging(boardAry, page);	// main�Լ� �ۿ��� �޼ҵ� ����.
				}
				break;
				
			// 3. ����ȸ
			case 3:
				System.out.println("< �� ��ȸ >");
				System.out.print("��ȸ�� �Խñ� ��ȣ�� �Է��ϼ��� \n>> ");
				int num = Integer.parseInt(scn.nextLine());
				Board result = exe.showContent(num);
				if(result != null) {
					System.out.println("------------------------------------------------------------------");
					System.out.println(result.showDetailInfo());
					System.out.println("------------------------------------------------------------------");
				}
				else {
					System.out.println("�Խù� ��ȸ�� �����߽��ϴ�");
				}
				break;
				
			// 4. ����
			case 4:
				System.out.println("< �Խñ� ���� >");
				System.out.print("������ �Խñ� ��ȣ�� �Է��ϼ��� \n>> ");
				num = Integer.parseInt(scn.nextLine());
				System.out.print("���� ���� \n>> ");
				title = scn.nextLine();
				System.out.print("���� ���� \n>> ");
				content = scn.nextLine();
				
				if(!exe.checkResponsibility(id, num)) {
					System.out.println("���� ������ �����ϴ�");
					continue;
				}
				if(exe.modifyContent(num, title, content)) {
					System.out.println("�Խù� ������ �Ϸ�Ǿ����ϴ�!");
				}
				else {
					System.out.println("�Խù� ������ �����߽��ϴ�.");
				}
				
				break;
			// 5. ����
			case 5:
				System.out.println("< �Խñ� ���� >");
				System.out.print("������ �Խñ� ��ȣ�� �Է��ϼ��� \n>> ");
				num = Integer.parseInt(scn.nextLine());
				
				if(!exe.checkResponsibility(id, num)) {
					System.out.println("���� ������ �����ϴ�");
					continue;
				}
				
				if(exe.removeContent(num)) {
					System.out.println("�Խù� ������ �Ϸ�Ǿ����ϴ�!");
				}
				else {
					System.out.println("�Խù� ������ �����߽��ϴ�.");
				}
				break;
			// 6. ����
			case 6:
				System.out.println("< ���α׷� ���� >");
				scn.close();
				run = false;
			}	// end of switch
		
		}	// end of while
		scn.close();
		System.out.println("end of program");
	}	// end of main()

	public static void paging(Board[] boardAry, int page) {
		// ����¡ ó��
		Board[] pageAry = exe.pageList(boardAry, page);
		
		System.out.println("< ��� ��ȸ >");
		System.out.println("�۹�ȣ\t\t ����\t\t �ۼ���\t\t �ۼ�����");
		System.out.println("==================================================================");
		for(Board brd : pageAry) {
			if(brd != null) {
				brd.showInfo();
			}
		}
		System.out.println("==================================================================");
		
		// ��ü ������ ����ϰ� ���.
		int count = exe.getBoardCount();
		int totalPage = (int)Math.ceil(count/5.0);
		System.out.printf("[���� ������: %d]  ", page);
		for (int i = 1; i <= totalPage; i++) {
			System.out.print(i + " ");
		}
		System.out.print("\n�������� �����ϼ���(���� : 0 �Է�) \n>>");
	}
}
