package todo.p20231128;

import java.util.Scanner;

public class BoardApp {
	
	public static void main(String[] args) {
		
		Board[] board;
		Board
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
				System.out.println("�Ͻ� >> ");
				String date = scn.nextLine();
				Board brd = new Board(num, title, writer, content, date);
				addWriting(brd);
				
			
			}	// end of switch
		
		}	// end of while
	}	// end of main()

}
