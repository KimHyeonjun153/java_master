package todo.p20231128;

import java.util.Scanner;

public class BoardApp {
	
	public static void main(String[] args) {
		
		
		Board[] boards = new Board[100];
		boards[0] = new Board(1,"�ڹٰԽ��� �Դϴ�", "user01", "������ ������ �ڹٰԽ����� �����ô�.", "2023-11-28");
		boards[1] = new Board(2,"�����սô�\t", "user02", "�ڹٸ� �����սô�.", "2023-11-28");
		boards[2] = new Board(3,"SQL�� ���˴ϴ�", "user03", "�� �� �� �� �� �� �� ", "2023-11-28");
		Board board = new Board();
		boolean run = true;
		Scanner scn = new Scanner(System.in);

		while(run) {
			System.out.println("---------------------------------------------");
			System.out.println("| 1.�Խù� ���  2.���  3.����ȸ  4.���� |");
			System.out.println("---------------------------------------------");
			System.out.print("������ �Է��ϼ��� >> ");
			int menu = Integer.parseInt(scn.nextLine());
			
			switch(menu) {
			//1. �Խù� ���
			case 1: 
				System.out.println("< �Խù� ��� >");
				System.out.print("�Խñ� ��ȣ >> ");
				int num = Integer.parseInt(scn.nextLine());
				System.out.print("���� >> ");
				String title = scn.nextLine();
				System.out.print("�ۼ��� >> ");
				String writer = scn.nextLine();
				System.out.println("���� >> ");
				String content = scn.nextLine();
				System.out.print("�Ͻ� >> ");
				String date = scn.nextLine();
				Board brd = new Board(num, title, writer, content, date);
				
				if(board.addArticle(boards, brd)) {
					System.out.println("�Խù� ����� �Ϸ�Ǿ����ϴ�");
				}
				else {
					System.out.println("�Խù� ��Ͽ� �����߽��ϴ�");
				}
				break;
			// ��� ��ȸ
			case 2:
				System.out.println("< ��� ��ȸ >");
				System.out.println("---------------------------------------------");
				for(int i = 0; i < boards.length; i++) {
					if(boards[i] != null) {
						boards[i].showList();
					}
				}
				break;
			// ����ȸ
			case 3:
				System.out.println("< �� ��ȸ >");
				System.out.print("��ȸ�� �Խñ� ��ȣ�� �Է��ϼ��� >> ");
				int input = Integer.parseInt(scn.nextLine());
				board.showContent(boards, input);
				break;
			case 4:
				System.out.println("< ���α׷� ���� >");
				scn.close();
				run = false;
			}	// end of switch
		
		}	// end of while
		scn.close();
		System.out.println("end of program");
	}	// end of main()

}
