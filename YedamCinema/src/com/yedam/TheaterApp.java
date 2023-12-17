package com.yedam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class TheaterApp {

	public static void main(String[] args) {
		
		// UserDAO, MovieDAO ��ü ����.
		UserDAO userDao = new UserDAO();
		MovieDAO movieDao = new MovieDAO();
		
		// Oracle DB ����.
		userDao.getConn();
		movieDao.getConn();
		
		Scanner scn = new Scanner(System.in);
		boolean run1 = true;
		boolean run2 = true;
		
		// 0. ���� Ÿ��Ʋ.
		System.out.println("����������������������������������������������������������������������������������������������������������������������������������������������");
		System.out.println("�� ��                                                                 �� ��");
		System.out.println("��                         ����ó׸� ��������                         ��");
		System.out.println("�� ��                                                                 �� ��");
		System.out.println("����������������������������������������������������������������������������������������������������������������������������������������������");
		
		// I. �α��� / ȸ������.
		while(run1) {
			System.out.println();
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
			
			switch(menu) {
			// 1. �α���.
			case 1:
				System.out.println("\n< �α��� >");
				System.out.print("���̵� �Է��ϼ��� \n>>>> ");
				String userId = scn.nextLine();
				System.out.print("��й�ȣ�� �Է��ϼ��� \n>>>> ");
				String passwd = scn.nextLine();
				
				// UserDAO �α��� �Լ� ȣ��.
				if(userDao.login(userId, passwd)) {			
					System.out.println("�α��� �Ϸ�!");
					// UserDAO ���� �̸� �������� �Լ� ȣ��.
					String userName = userDao.getName(userId);
					System.out.println(userName + " �� ȯ���մϴ�!");
					run1 = false;
				}
				else {
					System.out.println("���̵�� ��й�ȣ�� Ȯ���ϼ���");
				}
				break;
			
			// 2. ȸ������.
			case 2 :
				System.out.println("\n< ȸ�� ���� >");
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
				
				// ��й�ȣ ��ġ Ȯ��.
				if(passwd.equals(passwd2)) {
					// User ��ü ���� => UseDAO ȸ������ �Լ� �μ���.
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
		
		// II. ���� ȭ��
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
			// 1 ��ü ��ȭ ��� ��ȸ.
			case 1:
				boolean run3 = true;
				int page = 1;
				while(run3){
					System.out.println("\n< ��ȭ ��� >");
					System.out.println(" ��ȣ	  ��ȭ �̸�		   ����                    �⿬���"); 
					System.out.println("----------------------------------------------------------------------------------");
					// MovieDAO ����¡ �� ��ȭ��� ��� �Լ�.
					movieDao.showAllMovie(page);
					System.out.println("----------------------------------------------------------------------------------");
					System.out.printf("[���� ������: %d]  ", page);
					
					// ��ü ������ �� ���.
					// MovieDAO ��ü ��ȭ ��� �������� �Լ� => ��ȭ �� count.
					int count = movieDao.getAllMovie().size();
					// ��ü ��ȭ �� / 5 + �Ҽ� �ڸ��� �ø� => ��ü ������ ��.
					int totalPage = (int) Math.ceil(count / 5.0);
					for (int i = 1; i <= totalPage; i++) {
						System.out.print(i + " ");
					}
					
					// ����޴�.
					System.out.println();
					System.out.println("����������������������������������������������������������������������������������������������������������������������������������");
					System.out.println("�� 1.���� ������ �� 2. ���������� �� 3. ��ȭ �� ���� �� 4. ������ ��");
					System.out.println("����������������������������������������������������������������������������������������������������������������������������������");
					System.out.print("������ �Է��ϼ��� \n>>>> ");
					int subMenu;
					try {
						subMenu = Integer.parseInt(scn.nextLine());
					} catch (Exception e) {
						subMenu = 0;
					}
					
					switch(subMenu) {
					// 1-1. ���� ������.
					case 1: 
						if(page > 1) {
							page--;
						}
						break;
					// 1-2. ���� ������.
					case 2:
						if(page < totalPage) {
							page++;
						}
						break;
					// 1-3. ��ȭ �� ���� ��ȸ.
					case 3:	
						System.out.println("\n< ��ȭ �� ���� ��ȸ >");
						System.out.print("��ȭ ��ȣ�� �Է��ϼ��� \n>>>> ");
						String movieNumber = scn.nextLine();
						//	MovieDAO ��ȭ ��ȣ�� ��ȭ ã�� ���� �Լ�.
						Movie movie = movieDao.getMovieDetail(movieNumber);
						try {
							// Movie ��ȭ ���� ��� �Լ�.
							movie.showMovieDetailInfo();
						} catch (NullPointerException e) {
							System.out.println("�ùٸ� ��ȭ ��ȣ�� �Է��ϼ���");
						}
						break;
					// 1-4. ������
					case 4:
						run3 = false;
						break;
					default :
						break;
					}
					
				}
				break;
				
			// 2. ��ȭ �˻�.
			case 2:
				System.out.println("\n< ��ȭ �˻� >");
				System.out.print("�˻�� �Է��ϼ��� \n>>>> ");
				String search = scn.nextLine();
				
				System.out.println("< ��ȭ ��� >");
				System.out.println(" ��ȣ	  ��ȭ �̸�		   ����                    �⿬ ���"); 
				System.out.println("----------------------------------------------------------------------------------");
				// MovieDAO ��ȭ ã�� �Լ�.
				List<Movie> movies = movieDao.searchMovie(search);
				
				for (int i = 0; i < movies.size(); i++) {
					// Movie ��ȭ ���� ����Լ�.
					movies.get(i).showMovieInfo();
				}				
				System.out.println("----------------------------------------------------------------------------------");
				
				// ����޴�.
				System.out.println();
				System.out.println("����������������������������������������������������������������");
				System.out.println("�� 1.��ȭ �� ���� �� 2. ������ ��");
				System.out.println("����������������������������������������������������������������");
				System.out.print("������ �Է��ϼ��� \n>>>> ");
				
				int subMenu;
				try {
					subMenu = Integer.parseInt(scn.nextLine());
				} catch (Exception e) {
					subMenu = 0;
				}
				
				switch(subMenu) {
				// 2-1. ��ȭ ������ ��ȸ (== 1-3).
				case 1: 
					System.out.println("\n< ��ȭ �� ���� ��ȸ >");
					System.out.print("��ȭ ��ȣ�� �Է��ϼ��� \n>>>> ");
					String movieNumber = scn.nextLine();
					Movie movie = movieDao.getMovieDetail(movieNumber);
					try {
						movie.showMovieDetailInfo();
					} catch (NullPointerException e) {
						System.out.println("�ùٸ� ��ȭ ��ȣ�� �Է��ϼ���");
					}
					break;
				// 2-2. ������.
				case 2:
					break;
				default :
					break;
				}

				break;
			
			// 3. ��ȭ ����.
			case 3:
				boolean run4 = true;
				page = 1;
				while(run4){
					System.out.println("\n< ��ȭ ��� >");
					System.out.println(" ��ȣ	  ��ȭ �̸�		   ����                    �⿬���"); 
					System.out.println("----------------------------------------------------------------------------------");
					// MovidDAO ���� ������ ��ȭ��ȸ �Լ�(���� ��¥ ����)/
					movieDao.showAvailableMovie(page);
					System.out.println("----------------------------------------------------------------------------------");
					System.out.printf("[���� ������: %d]  ", page);
					
					int count = movieDao.getAvailableMovie().size();
					int totalPage = (int) Math.ceil(count / 5.0);
					for (int i = 1; i <= totalPage; i++) {
						System.out.print(i + " ");
					}
					
					// ����޴�.
					System.out.println();
					System.out.println("����������������������������������������������������������������������������������������������������������������������������������");
					System.out.println("�� 1.���� ������ �� 2. ���������� �� 3. ��ȭ ���� �ϱ� �� 4. ������ ��");
					System.out.println("����������������������������������������������������������������������������������������������������������������������������������");
					System.out.print("������ �Է��ϼ��� \n>>>> ");
					try {
						subMenu = Integer.parseInt(scn.nextLine());
					} catch (Exception e) {
						subMenu = 0;
					}
					
					switch(subMenu) {
					// 3-1. ���� ������.
					case 1: 
						if(page > 1) {
							page--;
						}
						break;
					// 3-2. ���� ������.
					case 2:
						if(page < totalPage) {
							page++;
						}
						break;
					// 3-3. �����ϱ�
					case 3:	
						System.out.println("\n< ��ȭ ���� �ϱ� >");
						// 3-3-1. ��¥ ����
						System.out.print("������ ��¥�� �Է��ϼ��� (YYYY-MM-DD) \n>>>> ");
						String strDate = scn.nextLine();
						
						// String => Date ��¥ ����
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
						Date date = new Date();
						try {
							date = sdf.parse(strDate);
							System.out.println(strDate);
						} catch (ParseException e) {
							System.out.println("�ùٸ� ��¥�� �Է��ϼ���");
							break;
						}
						
						// 3-3-2. ��ȭ ����
						System.out.print("������ ��ȭ ��ȣ�� �Է��ϼ��� \n>>>> ");
						String movieNumber = scn.nextLine();
						
						
						List<Movie> movies2 = movieDao.getAvailableMovie();
						
						boolean chk = false;
						for(Movie movie : movies2){
							if(movie.getMovieNumber().equals(movieNumber)) {
								chk = true;
							}
						}
						if(!chk) {
							System.out.println("�ùٸ� ��ȭ ��ȣ�� �Է��ϼ���");
							break;
						}
						List<String[]> schedule = movieDao.searchSchedule(movieNumber);
						movieDao.getSchedule(schedule);
						
						break;
						
					case 4:
						run4 = false;
						break;
					default :
						break;
					}
				}
				
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
