package todo.p20231205;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class EmpApp {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		EmpExe exe = new EmpExe();
		boolean run = true;

		while (run) {

			System.out.println();
			System.out.println("��������������������������������������������������������������������������������������������������������������������������������������������");
			System.out.println("�� 1.��� ��� �� 2.��� ��ȸ �� 3.�ܰ� ��ȸ �� 4.���� �� 5.���� �� 6.���� ��");
			System.out.println("��������������������������������������������������������������������������������������������������������������������������������������������");
			System.out.print("������ �Է��ϼ��� \n>> ");
			int menu;
			try {
				menu = Integer.parseInt(scn.nextLine());
			} catch (NumberFormatException e) {
				menu = 0;
			}

			switch (menu) {
			case 1:
				System.out.println("< ��� ��� >");
				System.out.print("��� ��ȣ�� �Է��ϼ��� \n>> ");
				String num = scn.nextLine();
				System.out.print("��� �̸��� �Է��ϼ��� \n>> ");
				String name = scn.nextLine();
				System.out.print("��ȭ��ȣ�� �Է��ϼ��� \n>> ");
				String tel = scn.nextLine();
				System.out.print("�޿��� �Է��ϼ��� \n>> ");
				int salary = 0;
				try {
					salary = Integer.parseInt(scn.nextLine());
				} catch (NumberFormatException e) {
					System.out.println("��� ��Ͽ� �����߽��ϴ�");
					continue;
				}
				Date date = new Date();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				String joinDate = sdf.format(date);
				
				boolean chk = exe.addEmp(num, name, tel, joinDate, salary);
				if(chk)
					System.out.println("��� ������ ��ϵƽ��ϴ�");
				else
					System.out.println("��� ���� ��Ͽ� �����߽��ϴ�");
				break;
			case 2:
				System.out.println("< ��ü ��� ��ȸ > ");
	
				exe.getEmplist();
				break;
			case 3:
				System.out.println("< �ܰ� ��ȸ > ");
				System.out.print("�Ի����ڸ� �Է��ϼ��� \n>> ");
				joinDate = scn.nextLine();
				
				break;
			case 4:
				break;
			case 5:
				break;
			case 6:
				System.out.println("���α׷��� �����մϴ�.");
				scn.close();
				run = false;
				break;
			default:
				System.out.println("�ùٸ� ������ �Է��ϼ���");
			} // end of switch
		} // end of while
		System.out.println("end of prog.");
	} // end of main
}
