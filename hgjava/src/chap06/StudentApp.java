package chap06;

import java.util.Scanner;

public class StudentApp {

	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		boolean run = true;
		StudentExe exe = new StudentExe();
//		Student[] students = new Student[100];
		
		while(run) {	
			String numInput;
//			boolean exist = false;
			
			System.out.println("-------------------------------------------------------");
			System.out.println("| 1.���  2.���  3.�ܰ� ��ȸ  4.����  5.����  6.���� |");
			System.out.println("-------------------------------------------------------");
			System.out.print("��ȣ�� �Է��ϼ��� >> ");
			int menu = Integer.parseInt(scn.nextLine());
			
			switch(menu) {
			case 1: 
//				Student student = new Student();
//				System.out.println("�л� ��� >> ");
//				System.out.print("�л� ��ȣ �Է� >> ");
//				student.setStuNum(scn.nextLine());
//				System.out.print("�л� �̸� �Է� >> ");
//				student.setStuName(scn.nextLine());
//				System.out.print("���� ���� �Է� >> ");
//				student.setEngScore(Integer.parseInt(scn.nextLine()));
//				System.out.print("���� ���� �Է� >> ");
//				student.setMathScore(Integer.parseInt(scn.nextLine()));
//				int count = 0;
//				students[count] = student;
//				count++;
				
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
//				for(int i = 0; i < students.length; i++) {
//					if(students[i] == null) {
//						students[i] = std;
//						break;
//					}
//				}
				if(exe.addStudent(std)) {
					System.out.println("����Ǿ����ϴ�\n");
				}
				else {
					System.out.println("���� �����Ͽ����ϴ�\n");
				}
				break;
			case 2:
				System.out.println("< ��ü ��� ��ȸ >");
//				for(int i = 0; i < students.length; i++) {
//					if(students[i] != null)
//						students[i].showInfo();
//				}
				for(Student stdnt : exe.showStudentList()) {	//Student[] �迭Ÿ��
					if(stdnt != null) {
						stdnt.showInfo();
					}
				}	
				System.out.println();
				break;
			case 3:
				System.out.println("< �ܰ� ��ȸ >");
				System.out.print("��ȸ�� �л� ��ȣ�� �Է��ϼ��� >> ");
				numInput = scn.nextLine();
//				exist = false;
//				for(int i = 0; i < students.length; i++) {
//					if(students[i] != null && students[i].getStuName().equals(nameInput)) {
//							students[i].showInfo();
//							exist = true;
//					}
//				}
//				if(!exist) System.out.println("ã�� �̸��� �����ϴ�");
				Student stdnt = exe.showStudent(numInput);
				if(stdnt != null) {
					stdnt.showInfo();
					System.out.println();
				}
				else {
					System.out.println("��ȸ �����Ͽ����ϴ�\n");
				}
				break;
			case 4:
				System.out.println("< �л� ���� ���� >");
				System.out.print("�����Ϸ��� �л� ��ȣ �Է� >> ");
				numInput = scn.nextLine();
//				exist = false;
//				for(int i = 0; i < students.length; i++) {
//					if(students[i] != null && students[i].getStuName().equals(numInput)) {
//						System.out.print("�л� ��ȣ �Է� >> ");
//						num = scn.nextLine();
//						System.out.print("�л� �̸� �Է� >> ");
//						name = scn.nextLine();
//						System.out.print("���� ���� ���� >> ");
//						eng = Integer.parseInt(scn.nextLine());
//						students[i].setEngScore(eng);
//						System.out.print("���� ���� ���� >> ");
//						math = Integer.parseInt(scn.nextLine());
//						students[i].setMathScore(math);
//						exist = true;
//						System.out.println("�л� ������ �����Ǿ����ϴ�");
//					}
//				}
//				if(!exist) System.out.println("ã�� �̸��� �����ϴ�");
				System.out.print("���� ���� ���� >> ");
				eng = Integer.parseInt(scn.nextLine());
				System.out.print("���� ���� ���� >> ");
				math = Integer.parseInt(scn.nextLine());
				if(exe.modifyStudent(numInput, eng, math)) {
					System.out.println("�л� ������ �����Ǿ����ϴ�\n");
				}
				else {
					System.out.println("���� �����Ͽ����ϴ�\n");
				}
				break;

			case 5:
				System.out.println("< �л� ���� ���� > ");
				System.out.print("�����Ϸ��� �л� ��ȣ �Է� >> ");
				numInput = scn.nextLine();
//				exist = false;
//				for(int i = 0; i < students.length; i++) {
//					if(students[i] != null && students[i].getStuName().equals(numInput)) {
//						students[i] = null;
//						exist = true;
//						System.out.println("�л� ������ �����Ǿ����ϴ�");
//					}	// �ٱ��� if
//				}	// end of for
//				if(!exist) System.out.println("ã�� �̸��� �����ϴ�");
//				System.out.println();
				if(exe.removeStudent(numInput)) {
					System.out.println("�л� ������ �����Ǿ����ϴ�\n");
				}
				else {
					System.out.println("���� �����Ͽ����ϴ�\n");
				}
				break;
			case 6:
				System.out.println("���α׷��� �����մϴ�");
				scn.close();
				run = false;
			}	// end of switch
			
		}	// end of while
		System.out.println("end of program");
	}	// end of main()
}
