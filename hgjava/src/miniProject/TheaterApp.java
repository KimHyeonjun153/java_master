package miniProject;

import java.util.Scanner;

public class TheaterApp {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		boolean run = true;
		
		System.out.println();
		System.out.println("��������������������������������������������������������������������������������������������������������������������������������������������");
		System.out.println("��                        ����ó׸� ��������                         ��");
		System.out.println("��������������������������������������������������������������������������������������������������������������������������������������������");
		System.out.println("��������������������������������������������������������������������������������������������������������������������������������������������");
		System.out.println("��            1. �α���             ��            2.ȸ������           ��");
		System.out.println("��������������������������������������������������������������������������������������������������������������������������������������������");
		System.out.print("������ �Է��ϼ��� \n>>>> ");
		int menu = 0;
		try {
			menu = Integer.parseInt(scn.nextLine());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(menu == 1) {
			System.out.println("< �α��� >");
			System.out.print("���̵� �Է��ϼ��� \n>>>>");
			String userId = scn.nextLine();
			System.out.print("��й�ȣ�� �Է��ϼ��� \n>>>>");
			String passwd = scn.nextLine();
			
		}
				
		while(run) {
			
		}
	}

}
