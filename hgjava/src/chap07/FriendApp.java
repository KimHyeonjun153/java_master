package chap07;

import java.util.Scanner;

public class FriendApp {
	
	static Scanner scn = new Scanner(System.in);

	
	public static void main(String[] args) {

		boolean run = true;
		
		while(run) {
			System.out.println();
			System.out.println("����������������������������������������������������������������������������������");
			System.out.println("�� 1.��� �� 2.��� �� 3.����ȸ �� 4.���� ��");
			System.out.println("����������������������������������������������������������������������������������");
			System.out.print("������ �Է��ϼ��� \n>> ");
			int menu = Integer.parseInt(scn.nextLine());
			
			switch(menu) {
			case 1:
				addFriend(); 
				break;
			case 2:
				friendList(); 
				break;
			case 3:
				getFriend(); 
				break;
			default:
				System.out.println("�����մϴ�");
				run = false;
			}
		}
		System.out.println("end of program");
	} // end of main.
	
	// 1. ���.
	private static void addFriend() {
		System.out.println("��������������������������������������������������������");
		System.out.println("�� 1.ģ�� �� 2.�б� �� 3.ȸ�� ��");
		System.out.println("��������������������������������������������������������");
		System.out.print("�з��� �����ϼ��� \n>> ");
		int subMenu = Integer.parseInt(scn.nextLine());
		System.out.print("�̸� \n>> ");
		String name = scn.nextLine();
		System.out.print("����ó \n>> ");
		String phone = scn.nextLine();
		
		Friend friend = null; // UnivFriend, CompFriend �ν��Ͻ� ���� ����.
		
		// ģ��: �̸�, ����ó.
		if(subMenu == 1 ) {
			friend = new Friend(name, phone);	// Friend �ν��Ͻ�.
		}
		// �б�: �̸�, ����ó, �б�, ����.
		else if(subMenu == 2) {
			System.out.print("�б� \n>> ");
			String univ = scn.nextLine();
			System.out.print("���� \n>> ");
			String major = scn.nextLine();
			friend = new UnivFriend(name, phone, univ, major);
		}
		// ȸ��: �̸�, ����ó, ȸ��, �μ�.
		else if(subMenu == 3) {
			System.out.print("ȸ�� \n>> ");
			String comp = scn.nextLine();
			System.out.print("�μ� \n>> ");
			String dept = scn.nextLine();
			friend = new CompFriend(name, phone, comp, dept);
		}
		else {
			System.out.println("1, 2, 3  �߿��� �����ϼ���");
			return;
		}
		// �迭�� �߰�
		if(FriendExe.addFriend(friend)) {
			System.out.println("ģ�� �߰��� �����߽��ϴ�!");
		}
		else {
			System.out.println("ģ�� �߰��� �����߽��ϴ�");
		}
		
	} 
	
	// 2. ���.
	private static void friendList() {
		System.out.println("=========================================");
		FriendExe.friendList();
		System.out.println("=========================================");

	} 
	
	// 3. �ܰ� ��ȸ.
	private static void getFriend() { // �̸� ��ȸ, ����ó ��ȸ
		System.out.println("������������������������������������������");
		System.out.println("�� 1.�̸� �� 2.����ó ��");
		System.out.println("������������������������������������������");
		System.out.print("�˻� �з��� �Է��ϼ��� \n>> ");
		int subMenu = Integer.parseInt(scn.nextLine());
		String searchCond = "";
		
		if(subMenu == 1) {
			System.out.print("�̸��� �Է��ϼ��� \n>> ");
			searchCond = scn.nextLine();
			Friend[] friend = null; 
			friend = FriendExe.searchName(searchCond);
			
			if(friend == null){
				System.out.println("��Ȯ�� �̸��� �Է��ϼ���");
			}
			else {
				for (int i = 0; i < friend.length; i++) {
					if(friend[i] != null) {
						System.out.println(friend[i].showInfo());
					}

				}
			}
		}
		
		else if(subMenu == 2) {
			System.out.print("����ó�� �Է��ϼ��� \n>> ");
			searchCond = scn.nextLine();
			Friend friend = null;
			friend = FriendExe.searchPhone(searchCond);
			if(friend != null) {
				System.out.println(friend.showInfo());
			}
			else {
				System.out.println("��Ȯ�� ����ó�� �Է��ϼ���");
			}
		}
		else {
			System.out.println("1 �Ǵ� 2 �߿��� �����ϼ���");
		}
	} 
	
	
	void backup() { // ���� �ۼ��Ѱ� �����.

		Friend parent = new Friend();
		parent.setName("ȫ�浿");
		parent.setPhone("010-1234-5678");
		System.out.println(parent.toString());

		UnivFriend child = new UnivFriend();
		child.setName("��ö��");
		child.setPhone("010-1111-2222");
		child.setUniv("���̴��б�");
		child.setMajor("��ǻ�Ͱ��а�");
		System.out.println(child.showInfo());

		Friend[] friends = new Friend[10];
		friends[0] = parent;
		friends[1] = child;

	}

}
