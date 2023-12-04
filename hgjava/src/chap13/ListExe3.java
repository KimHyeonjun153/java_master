package chap13;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListExe3 {
	
	static Scanner scn = new Scanner(System.in);
	static List<Member> members = new ArrayList<>();
	
	public static void main(String[] args) {
		
		// ȸ�����(ȸ����ȣ, �̸�, ����Ʈ).
		// 1.��� 2.�̸���ȸ 3.����Ʈ ���� 4.���� 5. ����
		
		members.add(new Member("M-001", "ȫ�浿", 1000));
		members.add(new Member("M-002", "��浿", 1500));
		members.add(new Member("M-003", "���μ�", 2000));
		
		boolean run = true;
		
		while(run) {
			System.out.println();
			System.out.println("������������������������������������������������������������������������������������������������������������������������������");
			System.out.println("�� 1.ȸ�� ��� �� 2.�̸� ��ȸ �� 3.����Ʈ ���� �� 4.���� �� 5.���� ��");
			System.out.println("������������������������������������������������������������������������������������������������������������������������������");
			System.out.print("������ �Է��ϼ��� \n>> ");
			int menu = 0;
			String name = "";
			
			try {
			menu = Integer.parseInt(scn.nextLine());
			} catch(Exception e) {
				System.out.println("�ùٸ� ������ �Է��ϼ���");
				continue;
			}
			
			switch(menu) {
			// 1.ȸ�� ���
			case 1:
				addMember();
				break;
				
			// 2.�̸� ��ȸ
			case 2:
				findMember();
				break;
				
			// 3.����Ʈ ����
			case 3:
				changePoint();
				break;
				
			// 4.����
			case 4:
				removeMember();
				break;
				
			// 5.����
			case 5:
				System.out.println("���α׷��� �����մϴ�.");
				scn.close();
				run = false;
		
			}
		} // end of while.
		System.out.println("end of prog.");
		
	} // end of main.
	
	public static void addMember() {
		System.out.println("< ȸ�� ��� >");
		System.out.print("ȸ����ȣ �̸� ����Ʈ ������ �Է��ϼ��� \n>> ");
		String input = " ";
		input = scn.nextLine();
		String[] inAry = input.split(" ");
		
		try {
			members.add(new Member(inAry[0], inAry[1], Integer.parseInt(inAry[2])));
			System.out.println("ȸ�� ��� �Ϸ�!");
		} catch(Exception e) {
			System.out.println("�ùٸ� ȸ�������� �Է��ϼ���");
			return;
		}
	}
	
	public static void findMember() {
		System.out.println("< ȸ�� ��ȸ >");
		System.out.print("��ȸ�� ȸ���� �̸��� �Է��ϼ��� \n>> ");
		String name = scn.nextLine();
		boolean chk = false;
		System.out.printf("%7s %9s %9s\n","ȸ����ȣ", "�̸�", "����Ʈ");
		System.out.println("=======================================");
		
		for(Member mem : members) {
			if(mem.getMemberName().indexOf(name) != -1) { 
				System.out.printf("%10s %10s %10d\n",mem.getMemberNo(), mem.getMemberName(), mem.getPoint());
				chk = true;
			}
		}
		if(chk == false) System.out.println("ã�� �̸��� �����ϴ�.");
	}
	
	public static void changePoint() {
		System.out.println("< ����Ʈ ���� >");
		System.out.print("�̸� ����Ʈ ������ �Է��ϼ��� \n>> ");
		String input = scn.nextLine();
		String[] inAry2 = input.split(" ");
		
		boolean chk = false;
		for(int i = 0; i < members.size(); i++) {
			if(members.get(i).getMemberName().equals(inAry2[0])) {
				members.get(i).setPoint(Integer.parseInt(inAry2[1]));
				chk = true;
			}
		}
		if(chk) {
			System.out.println("����Ʈ ���� �Ϸ�!");
		}
		else {
			System.out.println("����Ʈ ���濡 �����߽��ϴ�");
		}
	}
	
	public static void removeMember() {
		System.out.println("< ȸ�� ���� >");
		System.out.print("������ ȸ���� �̸��� �Է��ϼ��� \n>> ");
		String name = scn.nextLine();
		boolean chk = false;
		for(int i = 0; i < members.size(); i++) {
			if(members.get(i).getMemberName().equals(name)) {
				members.remove(i);
				chk = true;
			}
		}
		if(chk) {
			System.out.println("ȸ�� ���� �Ϸ�!");
		}
		else {
			System.out.println("ȸ�� ������ �����߽��ϴ�");
		}
	}
	
} // end of class.
