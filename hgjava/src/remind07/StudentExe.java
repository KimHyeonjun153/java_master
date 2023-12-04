package remind07;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// ������� :  �迭
// �߰�/����/����/���/�ܰ� ��ȸ
public class StudentExe {
	
	// �ʵ�
	private List<Student> students = new ArrayList<>();
	Scanner scn = new Scanner(System.in);
	
	//������
	StudentExe(){
		students.add(new Student("23-001", "������", 88, 77));
		students.add(new Student("23-002", "������", 91, 86));
		students.add(new Student("23-003", "������", 91, 97));
	}

	// ��� �Լ� ����
	// 0. ����
	int progStart() {
		System.out.println();
		System.out.println("��������������������������������������������������������������������������������������������������������������������������������������������");
		System.out.println("�� 1.�л� ��� �� 2.��� ��ȸ �� 3.�ܰ� ��ȸ �� 4.���� �� 5.���� �� 6.���� ��");
		System.out.println("��������������������������������������������������������������������������������������������������������������������������������������������");
		System.out.print("������ �Է��ϼ��� \n>> ");
		
		int menu = 0;
		try {
		menu= Integer.parseInt(scn.nextLine());
		} catch(Exception e) {
			return 0;
		}
		return menu;
	}
	
	// 1. �߰�
	void addStudent() {
		System.out.println("< �л� ��� >");
		System.out.print("�л���ȣ �л��̸� �������� �������� ������ �Է� \n>> ");
	
		String input = scn.nextLine();
		String[] inAry;
		String num;
		String name;
		int eng;
		int math;
		
		try {
			inAry = input.split(" ");
		num = inAry[0];
		name = inAry[1];
		eng = Integer.parseInt(inAry[2]);
		math = Integer.parseInt(inAry[3]);
		} catch(Exception e) {
			System.out.println("�ùٸ� �л� ������ �Է��ϼ���");
			return;
		}
		
		Student std = new Student(num, name, eng, math);
		students.add(std);
		System.out.println(name + " �л� ������ ��ϵǾ����ϴ�");
		}
	
	// 2. ��ü ��� ��ȸ.
	void showStudentList() {
		System.out.println("< ��ü ��� ��ȸ >");
		System.out.printf("%6s %10s %9s %5s\n","��ȣ", "�̸�", "��������", "��������");
		System.out.println("===============================================");
		for(int i = 0; i < students.size(); i++) {
			students.get(i).showInfo();
			}	
	}
	
	// 3. �ܰ� ��ȸ.
	void showStudent() {
		System.out.println("< �ܰ� ��ȸ >");
		System.out.print("��ȸ�� �л� ��ȣ�� �Է��ϼ��� \n>> ");
		String input = scn.nextLine();
		boolean chk = false;
		System.out.printf("%6s %10s %9s %5s\n","��ȣ", "�̸�", "��������", "��������");
		System.out.println("===============================================");
		for(Student stdnt : students) {
			if(stdnt.getStuNum().equals(input)) {
				stdnt.showInfo();
				chk = true;
			}
		}
		if(!chk) System.out.println("��ȸ �����Ͽ����ϴ�\n");
	}
	
	//����
	void modifyStudent() {
		
		System.out.println("< �л� ���� ���� >");
		System.out.print("�����Ϸ��� �л� ��ȣ �Է� \n>> ");
		String numInput = scn.nextLine();
		System.out.print("�������� �������� ������ ������ ���� �Է��ϼ��� \n>> ");
		String scoreInput = scn.nextLine();
		
		String[] inAry = scoreInput.split(" ");
		int eng = 0;
		int math = 0;
		
		try {
		eng = Integer.parseInt(inAry[0]);
		math = Integer.parseInt(inAry[1]);
		} catch(Exception e) {
			System.out.println("�ùٸ� ���� �Է��ϼ���");
			return;
		}
		boolean chk = false;
		
		for(Student stdnt : students) {
			if(stdnt.getStuNum().equals(numInput)) {
				stdnt.setEngScore(eng);
				stdnt.setMathScore(math);
				chk = true;
			}
		}
		if(chk)		
			System.out.println("�л� ������ �����Ǿ����ϴ�\n");
		else 
			System.out.println("���� �����Ͽ����ϴ�\n");
	}
	
	//����
	void removeStudent() {
		System.out.println("< �л� ���� ���� > ");
		System.out.print("�����Ϸ��� �л� ��ȣ �Է� \n>> ");
		String input = scn.nextLine();
		boolean chk = false;
		
		for(int i = 0; i < students.size(); i++) {
			if(students.get(i).getStuNum().equals(input)) {
				students.remove(i);
				chk = true;
			}
		}
		if(chk) 
			System.out.println("�л� ������ �����Ǿ����ϴ�\n");
		else 
			System.out.println("���� �����Ͽ����ϴ�\n");
		
		
	}
	
}
