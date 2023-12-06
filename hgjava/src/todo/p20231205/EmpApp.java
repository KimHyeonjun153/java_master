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
			// 1. ��� ���.
			case 1:
				System.out.println("< ��� ��� >");
				System.out.print("��� ��ȣ�� �Է��ϼ��� \n>> ");
				String num = scn.nextLine();
				System.out.print("��� �̸��� �Է��ϼ��� \n>> ");
				String name = scn.nextLine();
				System.out.print("��ȭ��ȣ�� �Է��ϼ��� \n>> ");
				String tel = scn.nextLine();
				
				// �Ի��� ���Է½� ���� ��¥�� �ڵ� ����.
				System.out.print("�Ի����� �Է��ϼ��� \n>> ");
				String joinDate = scn.nextLine();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				if (joinDate.equals("")) {
					Date date = new Date();
					joinDate = sdf.format(date);
				}
				
				System.out.print("�޿��� �Է��ϼ��� \n>> ");
				int salary = 0;
				try {
					salary = Integer.parseInt(scn.nextLine());
				} catch (NumberFormatException e) {
					System.out.println("��� ��Ͽ� �����߽��ϴ�");
					continue;
				}

				boolean chk = exe.addEmp(num, name, tel, joinDate, salary);
				if (chk)
					System.out.println("��� ������ ��ϵƽ��ϴ�");
				else
					System.out.println("��� ���� ��Ͽ� �����߽��ϴ�");
				break;

			// 2. ��ü ��� ��ȸ.
			case 2:
				System.out.println("< ��ü ��� ��ȸ > ");
				exe.getEmplist();
				break;

			// 3. �ܰ� ��ȸ(�Ի���).
			case 3:
				System.out.println("< �ܰ� ��ȸ > ");
				System.out.print("��ȸ�� �Ի����� �Է��ϼ��� \n>> ");
				String input = scn.nextLine();
				exe.getEmp(input);
				break;

			// 4. �޿� ����.
			case 4:
				System.out.println("< �޿� ���� > ");
				System.out.print("�޿��� ������ ����� �����ȣ�� �Է��ϼ��� \n>> ");
				input = scn.nextLine();
				System.out.print("������ �޿��� �Է��ϼ��� \n>> ");
				try {
					salary = Integer.parseInt(scn.nextLine());
				} catch (NumberFormatException e) {
					System.out.println("�ùٸ� ������ �Է��ϼ���");
					continue;
				}
				chk = exe.modifySalary(input, salary);
				if (chk)
					System.out.println("��� �޿��� �����Ͽ����ϴ�");
				else
					System.out.println("�޿� ������ �����߽��ϴ�");
				break;

			// 5. ��� ���� ����.
			case 5:
				System.out.println("< ��� ���� ���� > ");
				System.out.print("������ ����� �����ȣ�� �Է��ϼ��� \n>> ");
				input = scn.nextLine();
				chk = exe.removeEmp(input);
				if (chk)
					System.out.println("��� ������ �����Ͽ����ϴ�");
				else
					System.out.println("��� ���� ������ �����߽��ϴ�");
				break;

			// 6. ���α׷� ����.
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
