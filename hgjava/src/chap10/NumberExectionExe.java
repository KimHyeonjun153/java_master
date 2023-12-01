package chap10;

import java.util.Scanner;

public class NumberExectionExe {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		boolean run = true;
		
		while(run) {
			System.out.println("1.�߰� 2.���� 3.����");
			int menu = 0;
			
			try {
				menu = Integer.parseInt(scn.nextLine()); // "1" => 1.
			} catch(NumberFormatException e) {
				System.out.println("���ڸ� �Է��ϼ���");
			}
			switch(menu) {
			case 1:
				System.out.println("�߰��մϴ�");
				break;
			case 2:
				System.out.println("�����մϴ�");
				break;
			case 3:
				System.out.println("�����մϴ�");
				run = false;
			}
		}
		scn.close();
		System.out.println("end of prog.");
	}

}
