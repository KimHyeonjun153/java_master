package chap08;

import java.util.Scanner;

public class MainExe {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		// �������̽� ������ �����ϴ� Ŭ���� Ÿ�� ����
		DatabaseService svc = new OracleService(); // new MySQLService();
		
		boolean run = true;
		while(run){
			System.out.println("1.��� 2.���� 3.���� 4.����");
			int menu = Integer.parseInt(scn.nextLine());
			switch(menu) {
			case 1:
				svc.add();
				break;
			case 2:
				svc.modify();
				break;
			case 3:
				svc.remove();
				break;
			}
		}
	}

}
