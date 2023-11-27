package todo.p20231127;

import java.util.Scanner;

public class FriendApp {
	
	static Scanner scn = new Scanner(System.in);
	static Friend[] friends = null;		// Friend ���� Ÿ�� ���� ��ҷ� ���� �迭 friends ����
	
	// case 1 ģ�� �迭 ũ�� �Է�
	public static void friendNum() {
		System.out.print("ģ�� �� �Է� >> ");
		int frndNum = Integer.parseInt(scn.nextLine());
		friends = new Friend[frndNum];	// friends �迭�� ũ�� �Է�
	}
	
	// case 2 ģ�� ���� �Է�
	public static void addFriend() {
		System.out.println("ģ�� ���� �Է� >> ");
		for(int i = 0; i < friends.length; i++) {
			Friend friend = new Friend();	// Friend Ŭ������ �ν��Ͻ� friend ����
			System.out.printf("[%d]��° ģ�� �̸� �Է� >> ", i);
			friend.name = scn.nextLine();
			System.out.printf("[%d]��° ģ�� ����ó �Է� >> ", i);
			friend.telNum = scn.nextLine(); 
			System.out.printf("[%d]��° ģ�� ������ �Է� >> ", i);
			friend.bloodType = scn.nextLine();
			friends[i] = friend;	// friend �ν��Ͻ��� friends �迭�� ��ҷ� ����
		}
	}
	
	// case 3 ��ü ģ�� ��� ��ȸ
	public static void searchFriend() {
		System.out.println("ģ�� ��� >> ");
		for(Friend frnd : friends) {
			System.out.printf("�̸� : %s\t ����ó : %s\t ������ : %s\n",frnd.name, frnd.telNum, frnd.bloodType);
		}
	}
	
	// case 4 ģ�� ���� ����
	public static void modify() {
		System.out.print("��ȸ�� �̸� �Է� >> ");
		String srcName = scn.nextLine();
		boolean exist = false;	// ���� �̷� ��ȸ
		for(int i = 0; i < friends.length; i++) {
			if(srcName.equals(friends[i].name)) {
				System.out.print("������ ����ó �Է� >> ");
				friends[i].telNum = scn.nextLine();
				System.out.print("������ ������ �Է� >> ");
				friends[i].bloodType = scn.nextLine();
				exist = true;
			}
		}
		if(!exist) {
			System.out.println("ã�� �̸��� �����ϴ�");
		}
	}

	public static void main(String[] args) {
	
		boolean run = true;
		
		while(run) {
			System.out.println("----------------------------------------");
			System.out.println("| 1.ģ���� 2.�Է� 3.��� 4.���� 5.���� |");
			System.out.println("----------------------------------------");
			System.out.print("��ȣ�� �Է��ϼ��� >> ");
			
			int menu = Integer.parseInt(scn.nextLine());
			
			switch(menu) {
			case 1:
				friendNum();
				break;
			case 2:
				addFriend();
				break;
			case 3:
				searchFriend();
				break;
			case 4:
				modify();
				break;
			case 5:
				System.out.println("���� >> ");
				run = false;
				break;
			}
			
		}
		System.out.println("end program");
		
	} // end of main()

}	// end of FriendApp
