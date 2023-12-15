package com.yedam;

import java.util.*;

public class TheaterApp {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		UserDAO userDao = new UserDAO();
		MovieDAO movieDao = new MovieDAO();
		boolean run1 = true;
		boolean run2 = true;
		
		
		// ����ȭ��.
		while(run1) {
			System.out.println();
			System.out.println("����������������������������������������������������������������������������������������������������������������������������������������������");
			System.out.println("��                         ����ó׸� ��������                         ��");
			System.out.println("����������������������������������������������������������������������������������������������������������������������������������������������");
			System.out.println("����������������������������������������������������������������������������������������������������������������������������������������������");
			System.out.println("��            1. �α���              ��            2.ȸ������           ��");
			System.out.println("����������������������������������������������������������������������������������������������������������������������������������������������");
			System.out.print("������ �Է��ϼ��� \n>>>> ");
			int menu;
			try {
				menu = Integer.parseInt(scn.nextLine());
			} catch (Exception e) {
				menu = 0;
			}
			
			// 1. �α���.
			switch(menu) {
			case 1:
				System.out.println("< �α��� >");
				System.out.print("���̵� �Է��ϼ��� \n>>>> ");
				String userId = scn.nextLine();
				System.out.print("��й�ȣ�� �Է��ϼ��� \n>>>> ");
				String passwd = scn.nextLine();
				
				if(userDao.login(userId, passwd)) {			
					System.out.println("�α��� �Ϸ�!");
					String userName = userDao.getName(userId);
					System.out.println(userName + "�� ȯ���մϴ�!");
					run1 = false;
				}
				else {
					System.out.println("���̵�� ��й�ȣ�� Ȯ���ϼ���");
				}
				break;
			
			// 2. ȸ������.
			case 2 :
				System.out.println("< ȸ�� ���� >");
				System.out.print("���̵� �Է��ϼ��� \n>>>> ");
				userId = scn.nextLine();
				System.out.print("��й�ȣ�� �Է��ϼ��� \n>>>> ");
				passwd = scn.nextLine();
				System.out.print("��й�ȣ�� �ѹ� �� �Է��ϼ��� \n>>>> ");
				String passwd2 = scn.nextLine();
				System.out.print("�̸��� �Է��ϼ��� \n>>>> ");
				String userName = scn.nextLine();
				System.out.print("����ó�� �Է��ϼ��� \n>>>> ");
				String userTel = scn.nextLine();
					
				if(passwd.equals(passwd2)) {
					User user = new User(userId, passwd, userName, userTel);
					if(userDao.signUp(user)) {
						System.out.println("ȸ������ �Ϸ�!");
					}
				}
				else {
					System.out.println("��й�ȣ�� �ٸ��ϴ�");					
				}
				break;
			default :
				System.out.println("�ùٸ� ������ �Է��ϼ���");
			} // end of switch
		} // end of while(run1)
		
		while(run2) {
			System.out.println();
			System.out.println("����������������������������������������������������������������������������������������������������������������������������������������������");
			System.out.println("�� 1.��ȭ ��� �� 2.��ȭ �˻� �� 3.��ȭ ���� �� 4.���������� �� 5.�α׾ƿ� ��");
			System.out.println("����������������������������������������������������������������������������������������������������������������������������������������������");
			System.out.print("������ �Է��ϼ��� \n>>>> ");
			int menu;
			try {
				menu = Integer.parseInt(scn.nextLine());
			} catch (Exception e) {
				menu = 0;
			}
			
			switch(menu) {
			// 1. ��ü ��ȭ ��� ��ȸ
			case 1:
				System.out.println("< ��ȭ ��� >");
				System.out.println(" ��ȣ	  ��ȭ �̸�		   ����                    �⿬���"); 
				System.out.println("----------------------------------------------------------------------------------");
				List<Movie> movies = new ArrayList<>();
				movies = movieDao.getMovieList();
				
				for (int i = 0; i < movies.size(); i++) {
					movies.get(i).showMovieInfo();
				}
				System.out.println("----------------------------------------------------------------------------------");

				System.out.println("����������������������������������������������������������������");
				System.out.println("�� 1.��ȭ ���� ���� �� 2. ������ ��");
				System.out.println("����������������������������������������������������������������");
				System.out.print("������ �Է��ϼ��� \n>>>> ");
				int subMenu;
				try {
					subMenu = Integer.parseInt(scn.nextLine());
				} catch (Exception e) {
					subMenu = 0;
				}
				
				switch(subMenu) {
				case 1: 
					System.out.println("< ��ȭ ���� ���� >");
					System.out.print("��ȭ ��ȣ�� �Է��ϼ��� \n>>>> ");
					String movieNumber = scn.nextLine();
					Movie movie = movieDao.getMovie(movieNumber);
					try {
						movie.showMovieDetailInfo();
					} catch (NullPointerException e) {
						System.out.println("�ùٸ� ��ȭ ��ȣ�� �Է��ϼ���");
					}
					break;
				case 2:
					break;
				default :
					break;
				}
				
				break;
				
			// 2. ��ȭ �ܰ� ��ȸ
			case 2:
				System.out.println("< ��ȭ �ܰ� ��ȸ >");
				System.out.print("�˻�� �Է��ϼ��� \n>>>> ");
				String search = scn.nextLine();
				
				System.out.println("< ��ȭ ��� >");
				System.out.println(" ��ȣ	  ��ȭ �̸�		   ����                    �⿬ ���"); 
				System.out.println("----------------------------------------------------------------------------------");
				List<Movie> movies2 = movieDao.searchMovie(search);
				
				for (int i = 0; i < movies2.size(); i++) {
					movies2.get(i).showMovieInfo();
				}				
				System.out.println("----------------------------------------------------------------------------------");
				
				System.out.println("����������������������������������������������������������������");
				System.out.println("�� 1.��ȭ ���� ���� �� 2. ������ ��");
				System.out.println("����������������������������������������������������������������");
				System.out.print("������ �Է��ϼ��� \n>>>> ");
				try {
					subMenu = Integer.parseInt(scn.nextLine());
				} catch (Exception e) {
					subMenu = 0;
				}
				
				switch(subMenu) {
				case 1: 
					System.out.println("< ��ȭ ���� ���� >");
					System.out.print("��ȭ ��ȣ�� �Է��ϼ��� \n>>>> ");
					String movieNumber = scn.nextLine();
					Movie movie = movieDao.getMovie(movieNumber);
					try {
						movie.showMovieDetailInfo();
					} catch (NullPointerException e) {
						System.out.println("�ùٸ� ��ȭ ��ȣ�� �Է��ϼ���");
					}
					break;
				case 2:
					break;
				default :
					break;
				}
				
				break;
			
			// ��ȭ ����.
			case 3:
				System.out.println("< ��ȭ ���� >");
				
				
				break;
			case 4:
				break;
			case 5:
				System.out.println("�α׾ƿ� �Ǿ����ϴ�");
				scn.close();
				run2 = false;
				break;
			default:
				System.out.println("�ùٸ� ������ �Է��ϼ���");
			} // end of switch
			
		} // end of while(run2)
		System.out.println("end of prog.");
	}

}
