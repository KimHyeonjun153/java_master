package com.yedam;

import java.util.Scanner;

public class EmpApp {

	public static void main(String[] args) {

		//ExpDAO �ν��Ͻ� dao ����.
		EmpDAO dao = new EmpDAO();
		Scanner scn = new Scanner(System.in);
		boolean run = true;

		while (run) {
			System.out.println();
			System.out.println("��������������������������������������������������������������������������������������������������������������������������������������������������������");
			System.out.println("�� 1.��� �� 2.��� �� 3.����(�޿�) �� 4.���� �� 5.��ȸ(����:�Ի�����) �� 6.���� ��");
			System.out.println("��������������������������������������������������������������������������������������������������������������������������������������������������������");
			System.out.print("������ �Է��ϼ��� >> ");
			int menu;
			// parseInt ����ó��.
			try {
				menu = Integer.parseInt(scn.nextLine());
			} catch (NumberFormatException e) {
				menu = 0;
			}

			switch (menu) {
			// 1. �߰�.
			case 1:
				System.out.println("< ��� ��� >");
				System.out.print("��� �Է� >> ");
				String empNo = scn.nextLine();
				System.out.print("�̸� �Է� >> ");
				String empName = scn.nextLine();
				System.out.print("��ȭ��ȣ �Է� >> ");
				String empTel = scn.nextLine();
				System.out.print("�Ի��� �Է� >> ");
				String empDate = scn.nextLine();
				System.out.print("�޿� �Է� >> ");
				int salary = 0;
				// parseInt ����ó��.
				try {
					salary = Integer.parseInt(scn.nextLine());
				} catch (NumberFormatException e) {
					System.out.println("�ùٸ� �޿��� �Է��ϼ���");
					continue;
				}
				// ExeDAO�� �߰� �Լ� ȣ��.
				boolean check = dao.addEmployee(empNo, empName, empTel, empDate, salary);
				if (check)
					System.out.println("��� ������ ��ϵǾ����ϴ�");
				else
					System.out.println("��� ��Ͽ� �����߽��ϴ�");
				break;

			// 2. ��� ���.
			case 2:
				System.out.println("< ��� ��� >");
				System.out.printf("%3s %3s %5s\n", "���", "�̸�", "��ȭ��ȣ");
				System.out.println("========================");
				// ExeDAO ��� ��� �Լ� ȣ��.
				dao.getEmployeeList();
				break;

			// 2. ����(�޿�).
			case 3:
				System.out.println("< �޿� ���� >");
				System.out.print("��� �޿� >> ");
				String input = scn.nextLine();
				// ExeDAO �޿� ���� �Լ� ȣ��.
				check = dao.modifyEmploy(input);
				if (check)
					System.out.println("�޿��� �����Ǿ����ϴ�");
				else
					System.out.println("�޿� ������ �����߽��ϴ�");
				break;

			// 4. ����.
			case 4:
				System.out.println("< ��� ���� >");
				System.out.print("��� >> ");
				input = scn.nextLine();
				// ExeDAO ��� ���� �Լ� ȣ��.
				check = dao.removeEmploy(input);
				if (check)
					System.out.println("��� ������ �����Ǿ����ϴ�");
				else
					System.out.println("��� ������ �����߽��ϴ�");
				break;

			// 5. ��ȸ.
			case 5:
				System.out.println("< ��� ��ȸ >");
				System.out.print("�Ի����� >> ");
				input = scn.nextLine();
				System.out.printf("%3s %3s %5s\n", "���", "�̸�", "�Ի�����");
				System.out.println("========================");
				// ExeDAO ��� ��ȸ �Լ� ȣ��.
				dao.getEmployee(input);
				break;

			// 6. ����.
			case 6:
				System.out.println("���α׷��� �����մϴ�");
				scn.close();
				run = false;
				break;
			default:

			} // end of switch.

		} // end of while.

		System.out.println("end of prog.");

	} // end of main.
}
