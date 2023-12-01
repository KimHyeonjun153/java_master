package todo.p20231128;

import java.util.Scanner;

// MVC(Model: ������ ��Ƶ� / View: ȭ�� / Control: ó��, ����).
public class BoardApp {

//	static BoardExe BoardExe = new BoardExe();	// main�Լ� �ۿ��� ���� => static.
//	�����͸��� �ٸ� ������ ���� �ʿ䰡 ���� Ŭ������ static ��� ����.
	
	// �ʵ�.
	private Scanner scn = new Scanner(System.in);
	private String id = null;
	private static BoardApp instance = new BoardApp(); // ���� �ʵ� ���� => �ڱ� Ŭ���� �ȿ��� �ν��Ͻ� ����(�̱���)
	
	// ������.
	private BoardApp() {}	// �̱��� => ������ ȣ�� ����
	
	// �޼���.
	public static BoardApp getInstance() {	// �ڱ� Ŭ�������� ������ �ν��Ͻ� ��ȯ.
		return instance;					// => �ܺο��� �ν��Ͻ� ���� ���ϱ� ������ static ����.
	}
	
	private void boardAdd(){
		System.out.println("< �Խù� ��� >");
//		System.out.print("�Խñ� ��ȣ >> ");
//		int num = Integer.parseInt(scn.nextLine());
		System.out.print("���� \n>> ");
		String title = scn.nextLine();
//		System.out.print("�ۼ��� >> ");
//		String writer = scn.nextLine();
		System.out.print("���� \n>> ");
		String content = scn.nextLine();
//		System.out.print("�Ͻ� >> ");
//		String date = scn.nextLine();

		Board board = new Board(BoardExe.getSequence(), title, id, content);

		if (BoardExe.addArticle(board)) {
			System.out.println("�Խù� ����� �Ϸ�Ǿ����ϴ�!");
		} else {
			System.out.println("�Խù� ��Ͽ� �����߽��ϴ�");
		}
	}
	
	private void boardList() {
		Board[] boardAry = BoardExe.showList();
		paging(boardAry, 1);
		// ����¡ ó��
//		Board[] pageAry = exe.pageList(boardAry, 1);
//		
//		System.out.println("< ��� ��ȸ >");
//		System.out.println("�۹�ȣ\t\t ����\t\t �ۼ���\t\t �ۼ�����");
//		System.out.println("==================================================================");
//		for(Board brd : pageAry) {
//			if(brd != null) {
//				brd.showInfo();
//			}
//		}
//		System.out.println("==================================================================");
//		
//		// ��ü ������ ����ϰ� ���.
//		int count = BoardExe.getBoardCount();
//		int totalPage = (int)Math.ceil(count/5.0);
//		for (int i = 1; i <= totalPage; i++) {
//			System.out.print(i + " ");
//		}
//		System.out.println("\n�������� �����ϼ��� \n>>");
		while (true) {
			int page = Integer.parseInt(scn.nextLine());
			if (page == 0) {
				break;
			}
			paging(boardAry, page); // main�Լ� �ۿ��� �޼ҵ� ����.
		}
	}
	
	private void getBoard() {
		System.out.println("< �� ��ȸ >");
		int num = 0;
		while(true) {
			System.out.print("��ȸ�� �Խñ� ��ȣ�� �Է��ϼ��� \n>> ");
			try {
				num = Integer.parseInt(scn.nextLine());
				break;
			} catch(NumberFormatException e) {
				System.out.println("��Ȯ�� ��ȣ�� �Է��ϼ���");
			}
		}
		Board result = BoardExe.showContent(num);
		if (result != null) {
			System.out.println("------------------------------------------------------------------");
			System.out.println(result.showDetailInfo());
			System.out.println("------------------------------------------------------------------");
		} else {
			System.out.println("�Խù� ��ȸ�� �����߽��ϴ�");
		}
	}
	
	private void boardEdit() {
		System.out.println("< �Խñ� ���� >");
		System.out.print("������ �Խñ� ��ȣ�� �Է��ϼ��� \n>> ");
		int num = Integer.parseInt(scn.nextLine());
		System.out.print("���� ���� \n>> ");
		String title = scn.nextLine();
		System.out.print("���� ���� \n>> ");
		String content = scn.nextLine();

		if (!BoardExe.checkResponsibility(id, num)) {
			System.out.println("���� ������ �����ϴ�");
//			continue;
			return;
		}
		if (BoardExe.modifyContent(num, title, content)) {
			System.out.println("�Խù� ������ �Ϸ�Ǿ����ϴ�!");
		} else {
			System.out.println("�Խù� ������ �����߽��ϴ�.");
		}
	}
	
	private void boardDel() {
		System.out.println("< �Խñ� ���� >");
		System.out.print("������ �Խñ� ��ȣ�� �Է��ϼ��� \n>> ");
		int num = Integer.parseInt(scn.nextLine());

		if (!BoardExe.checkResponsibility(id, num)) {
			System.out.println("���� ������ �����ϴ�");
//			continue;
			return;
		}

		if (BoardExe.removeContent(num)) {
			System.out.println("�Խù� ������ �Ϸ�Ǿ����ϴ�!");
		} else {
			System.out.println("�Խù� ������ �����߽��ϴ�.");
		}
	}
	
	private void paging(Board[] boardAry, int page) {
		// ����¡ ó��
		Board[] pageAry = BoardExe.pageList(boardAry, page);

		System.out.println("< ��� ��ȸ >");
		System.out.println("�۹�ȣ\t\t ����\t\t �ۼ���\t\t �ۼ�����");
		System.out.println("==================================================================");
		for (Board brd : pageAry) {
			if (brd != null) {
				brd.showInfo();
			}
		}
		System.out.println("==================================================================");

		// ��ü ������ ����ϰ� ���.
		int count = BoardExe.getBoardCount();
		int totalPage = (int) Math.ceil(count / 5.0);
		System.out.printf("[���� ������: %d]  ", page);
		for (int i = 1; i <= totalPage; i++) {
			System.out.print(i + " ");
		}
		System.out.print("\n�������� �����ϼ���(���� : 0 �Է�) \n>>");
	}
	
	public void start() {
		boolean run = true;
		UserExe uexe = new UserExe(); // UserExe Ŭ���� ������.
//		BoardExe exe = new BoardExe();	// BoardExe Ŭ���� ������.

		BoardExe.initData();

		while (true) {
			System.out.print("���̵� �Է��ϼ���\n>> ");
			id = scn.nextLine();
			System.out.print("��й�ȣ�� �Է��ϼ���\n>> ");
			String pw = scn.nextLine();
			User user = uexe.logIn(id, pw);
			if (user != null) {
				System.out.println(user.getUserName() + "�� ȯ���մϴ�!!");
				break;
			} else {
				System.out.println("���̵�� ��й�ȣ�� Ȯ���ϼ���");
			}
		}

		while (run) {
			System.out.println();
			System.out.println("������������������������������������������������������������������������������������������������������������������������������������");
			System.out.println("�� 1.�Խù� ��� �� 2.��� �� 3.����ȸ �� 4.���� �� 5.���� �� 6.���� ��");
			System.out.println("������������������������������������������������������������������������������������������������������������������������������������");
			System.out.print("������ �Է��ϼ��� \n>> ");
			
			
			int menu = 0;
			try {
				menu = Integer.parseInt(scn.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("��Ȯ�� �޴��� �����ϼ���");
				continue;
			}

			switch (menu) {
			// 1. �Խù� ���
			case 1:
				boardAdd();
				break;

			// 2. ��� ��ȸ
			case 2:
				boardList();
				break;

			// 3. ����ȸ
			case 3:
				getBoard();
				break;

			// 4. ����
			case 4:
				boardEdit();
				break;
			// 5. ����
			case 5:
				boardDel();
				break;
			// 6. ����
			case 6:
				System.out.println("< ���α׷� ���� >");
				scn.close();
				run = false;
			default:
				System.out.println("��Ȯ�� �޴��� �����ϼ���");
				break;
			} // end of switch

		} // end of while
		scn.close();
		System.out.println("end of program");
	} // end of start()
}
