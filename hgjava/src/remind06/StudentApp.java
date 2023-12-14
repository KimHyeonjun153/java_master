package remind06;

import java.util.Scanner;

public class StudentApp {

	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		boolean run = true;
//		StudentExe exe = new StudentExe();
		StudentDAO dao = new StudentDAO();	// ����Ŭ DB ���� => DB�� ���� ����
		
		while(run) {	
			String numInput;
			System.out.println("����������������������������������������������������������������������������������������������������������������������������������");
			System.out.println("�� 1.��� �� 2.��� ��ȸ �� 3.�ܰ� ��ȸ �� 4.���� �� 5.���� �� 6.���� ��");
			System.out.println("����������������������������������������������������������������������������������������������������������������������������������");
			System.out.print("��ȣ�� �Է��ϼ��� >> ");
			int menu = Integer.parseInt(scn.nextLine());
			
			switch(menu) {
			
			//�л� ���
			case 1: 
				System.out.println("< �л� ��� >");
				System.out.print("�л� ��ȣ �Է� >> ");
				String num = scn.nextLine();
				System.out.print("�л� �̸� �Է� >> ");
				String name = scn.nextLine();
				System.out.print("���� ���� �Է� >> ");
				int eng = Integer.parseInt(scn.nextLine());
				System.out.print("���� ���� �Է� >> ");
				int math = Integer.parseInt(scn.nextLine());
				
				Student std = new Student(num, name, eng, math);

				// �߰��Լ� ���� => DB ����.
				if(dao.addStudent(std)) {
					System.out.println("����Ǿ����ϴ�\n");
				}
				else {
					System.out.println("���� �����Ͽ����ϴ�\n");
				}
				break;
				
			// ��� ��ȸ.
			case 2:
				System.out.println("< ��ü ��� ��ȸ >");
				
				// ��� ��ȸ �Լ� ����.
				Student[] stdAry = dao.getStudentList();
				for(Student stdnt : stdAry) {	//Student[] �迭Ÿ��.
					if(stdnt != null) {
						stdnt.showInfo();
					}
				}	
				System.out.println();
				break;
				
			// �ܰ� ��ȸ.
			case 3:
				System.out.println("< �ܰ� ��ȸ >");
				System.out.print("��ȸ�� �л� ��ȣ�� �Է��ϼ��� >> ");
				numInput = scn.nextLine();
				
				// �ܰ���ȸ �Լ� ����.
				Student stdnt = dao.getStudent(numInput);
				if(stdnt != null) {
					stdnt.showInfo();
					System.out.println();
				}
				else {
					System.out.println("��ȸ �����Ͽ����ϴ�\n");
				}
				break;
				
			// ���� ����.
			case 4:
				System.out.println("< �л� ���� ���� >");
				System.out.print("�����Ϸ��� �л� ��ȣ �Է� >> ");
				numInput = scn.nextLine();
				System.out.print("���� ���� ���� >> ");
				eng = Integer.parseInt(scn.nextLine());
				System.out.print("���� ���� ���� >> ");
				math = Integer.parseInt(scn.nextLine());
				
				// ���� ���� �Լ� ����.
				if(dao.modifyStudent(numInput, eng, math)) {
					System.out.println("�л� ������ �����Ǿ����ϴ�\n");
				}
				else {
					System.out.println("���� �����Ͽ����ϴ�\n");
				}
				break;

			// ���� ����.
			case 5:
				System.out.println("< �л� ���� ���� > ");
				System.out.print("�����Ϸ��� �л� �̸� �Է� >> ");
				numInput = scn.nextLine();
				
				// ���� ���� �Լ� ����.
				if(dao.removeStudent(numInput)) {
					System.out.println("�л� ������ �����Ǿ����ϴ�\n");
				}
				else {
					System.out.println("���� �����Ͽ����ϴ�\n");
				}
				break;
			
			// ���α׷� ����
			case 6:
				System.out.println("���α׷��� �����մϴ�");
				scn.close();
				run = false;
			}	// end of switch
			
		}	// end of while
		System.out.println("end of program");
	}	// end of main()
}
