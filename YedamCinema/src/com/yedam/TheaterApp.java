package com.yedam;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class TheaterApp {

	public static void main(String[] args) {

		// UserDAO, MovieDAO ��ü ����.
		UserDAO userDao = new UserDAO();
		MovieDAO movieDao = new MovieDAO();
		ScheduleDAO scheduleDao = new ScheduleDAO();
		TicketDAO ticketDao = new TicketDAO();

		boolean run0 = true;
		Scanner scn = new Scanner(System.in);

		while (run0) {
			boolean run1 = true;
			boolean run2 = true;
			boolean run3 = false;
			String userId = "";

			// 0. ���� Ÿ��Ʋ.
			System.out.println("����������������������������������������������������������������������������������������������������������������������������������������������");
			System.out.println("�� ��                                                                 �� ��");
			System.out.println("��                         ����ó׸� ��������                         ��");
			System.out.println("�� ��                                                                 �� ��");
			System.out.println("����������������������������������������������������������������������������������������������������������������������������������������������");

			// I. �α��� / ȸ������.
			while (run1) {
				System.out.println();
				System.out.println("������������������������������������������������������������������������������������������������������������������������������������������");
				System.out.println("��     1.�α���      ��      2.ȸ������      ��     3.���α׷� ����    ��");
				System.out.println("������������������������������������������������������������������������������������������������������������������������������������������");
				System.out.print("������ �Է��ϼ��� \n>>>> ");
				int menu = 0;
				try {
					menu = Integer.parseInt(scn.nextLine());
				} catch (Exception e) {
					e.printStackTrace();
				}

				switch (menu) {
				// 1. �α���.
				case 1:
					System.out.println("\n< �α��� >");
					System.out.print("���̵� �Է��ϼ��� \n>>>> ");
					userId = scn.nextLine();
					System.out.print("��й�ȣ�� �Է��ϼ��� \n>>>> ");
					String passwd = scn.nextLine();

					// UserDAO �α��� �Լ� ȣ��.
					if (userDao.login(userId, passwd)) {
						System.out.println("�α��� �Ϸ�!");
						// UserDAO ���� �̸� �������� �Լ� ȣ��.
						String userName = userDao.getName(userId);
						System.out.println(userName + " �� ȯ���մϴ�!");

						// ������ �����Ͻ� ������ �������� �ٷ� �Ѿ
						if (userId.equals("sys")) {
							run2 = false;
							run3 = true;
						}
						run1 = false;
					} else {
						System.out.println("���̵�� ��й�ȣ�� Ȯ���ϼ���");
					}
					break;

				// 2. ȸ������.
				case 2:
					System.out.println("\n< ȸ�� ���� >");
					System.out.print("���̵� �Է��ϼ��� \n>>>> ");
					userId = scn.nextLine();

					// ������ ���̵� ���� ����
					if (userId.equals("sys")) {
						System.out.println("������ �� ���� ���̵��Դϴ�");
						break;
					}
					// �ߺ� ���̵� ���� ����
					if (userDao.chkUserId(userId)) {
						System.out.println("�̹� �����ϴ� ���̵��Դϴ�");
						break;
					}

					System.out.print("��й�ȣ�� �Է��ϼ��� \n>>>> ");
					passwd = scn.nextLine();
					System.out.print("��й�ȣ�� �ѹ� �� �Է��ϼ��� \n>>>> ");
					String passwd2 = scn.nextLine();

					// ��й�ȣ ��ġ Ȯ��.
					if (!passwd.equals(passwd2)) {
						System.out.println("��й�ȣ�� �ٸ��ϴ�");
						break;
					}

					System.out.print("�̸��� �Է��ϼ��� \n>>>> ");
					String userName = scn.nextLine();
					System.out.print("����ó�� �Է��ϼ��� \n>>>> ");
					String userTel = scn.nextLine();

					// User ��ü ���� => UseDAO ȸ������ �Լ� �μ���.
					User user = new User(userId, passwd, userName, userTel);
					if (userDao.signUp(user)) {
						System.out.println("ȸ������ �Ϸ�!");
					}
					else {
						System.out.println("ȸ�����Կ� �����߽��ϴ�");
					}
					break;

				case 3:
					System.out.println("���α׷� ����");
					run0 = false;
					run1 = false;
					run2 = false;
					break;
				default:
					System.out.println("�ùٸ� ������ �Է��ϼ���");
					break;
				} // end of switch
			} // end of while(run1)

			// II. ���� ȭ��
			while (run2) {
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

				switch (menu) {
				// 1 ��ü ��ȭ ��� ��ȸ.
				case 1:
					boolean run4 = true;
					int page = 1;
					while (run4) {
						System.out.println("\n< ��ȭ ��� >");
						System.out.println(" ��ȣ	  ��ȭ �̸�		   ����                    �⿬���");
						System.out.println(
								"----------------------------------------------------------------------------------");
						// MovieDAO ����¡ �� ��ȭ��� ��� �Լ�.
						movieDao.showMovieList(page);
						System.out.println(
								"----------------------------------------------------------------------------------");
						System.out.printf("[���� ������: %d]  ", page);

						// ��ü ������ �� ���.
						// MovieDAO ��ü ��ȭ ��� �������� �Լ� => ��ȭ �� count.
						int count = movieDao.getMovieList().size();
						// ��ü ��ȭ �� / 5 + �Ҽ� �ڸ��� �ø� => ��ü ������ ��.
						int totalPage = (int) Math.ceil(count / 5.0);
						for (int i = 1; i <= totalPage; i++) {
							System.out.print(i + " ");
						}

						// ����޴�.
						System.out.println();
						System.out.println("������������������������������������������������������������������������������������������������������������������������������");
						System.out.println("�� 1.���� ������ �� 2.���� ������ �� 3.��ȭ �� ���� �� 4.������ ��");
						System.out.println("������������������������������������������������������������������������������������������������������������������������������");
						System.out.print("������ �Է��ϼ��� \n>>>> ");
						int subMenu;
						try {
							subMenu = Integer.parseInt(scn.nextLine());
						} catch (Exception e) {
							subMenu = 0;
						}

						switch (subMenu) {
						// 1-1. ���� ������.
						case 1:
							if (page > 1) {
								page--;
							}
							break;
						// 1-2. ���� ������.
						case 2:
							if (page < totalPage) {
								page++;
							}
							break;
						// 1-3. ��ȭ �� ���� ��ȸ.
						case 3:
							System.out.println("\n< ��ȭ �� ���� ��ȸ >");
							System.out.print("��ȭ ��ȣ�� �Է��ϼ��� \n>>>> ");
							String movieNumber = scn.nextLine();
							// MovieDAO ��ȭ ��ȣ�� ��ȭ ã�� ���� �Լ�.
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
							run4 = false;
							break;
						default:
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
					System.out.println(
							"----------------------------------------------------------------------------------");
					// MovieDAO ��ȭ ã�� �Լ�.
					List<Movie> movies = movieDao.searchMovie(search);

					for (int i = 0; i < movies.size(); i++) {
						// Movie ��ȭ ���� ����Լ�.
						movies.get(i).showMovieInfo();
					}
					System.out.println(
							"----------------------------------------------------------------------------------");

					// ����޴�.
					System.out.println();
					System.out.println("��������������������������������������������������������������");
					System.out.println("�� 1.��ȭ �� ���� �� 2.������ ��");
					System.out.println("��������������������������������������������������������������");
					System.out.print("������ �Է��ϼ��� \n>>>> ");

					int subMenu;
					try {
						subMenu = Integer.parseInt(scn.nextLine());
					} catch (Exception e) {
						subMenu = 0;
					}

					switch (subMenu) {
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
					default:
						break;
					}

					break;

				// 3. ��ȭ ����.
				case 3:
					boolean run5 = true;
					page = 1;
					while (run5) {
						System.out.println("\n< ��ȭ ��� >");
						System.out.println(" ��ȣ	  ��ȭ �̸�		   ����                    �⿬���");
						System.out.println(
								"----------------------------------------------------------------------------------");
						// MovidDAO ���� ������ ��ȭ��ȸ �Լ�(���� ��¥ ����)/
						movieDao.showMovieList(page);
						System.out.println(
								"----------------------------------------------------------------------------------");
						System.out.printf("[���� ������: %d]  ", page);

						int count = movieDao.getMovieList().size();
						int totalPage = (int) Math.ceil(count / 5.0);
						for (int i = 1; i <= totalPage; i++) {
							System.out.print(i + " ");
						}

						// ����޴�.
						System.out.println();
						System.out.println("������������������������������������������������������������������������������������������������������������������������������");
						System.out.println("�� 1.���� ������ �� 2.���� ������ �� 3.��ȭ ���� �ϱ� �� 4.������ ��");
						System.out.println("������������������������������������������������������������������������������������������������������������������������������");
						System.out.print("������ �Է��ϼ��� \n>>>> ");
						try {
							subMenu = Integer.parseInt(scn.nextLine());
						} catch (Exception e) {
							subMenu = 0;
						}

						switch (subMenu) {
						// 3-1. ���� ������.
						case 1:
							if (page > 1) {
								page--;
							}
							break;
						// 3-2. ���� ������.
						case 2:
							if (page < totalPage) {
								page++;
							}
							break;
						// 3-3. �����ϱ�
						case 3:
							System.out.println("\n< ��ȭ ���� �ϱ� >");

							// 3-3-1. ��¥ ����
							System.out.print("������ ��¥�� �Է��ϼ��� (YYYY-MM-DD) \n>>>> ");
							String strDate = scn.nextLine();

							DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
							LocalDate localDate;
							try {
								localDate = LocalDate.parse(strDate, formatter2);
							} catch (Exception e) {
								System.out.println("�ùٸ� ��¥ ������ �Է��ϼ���");
								break;
							}
							LocalDate now = LocalDate.now();
							if (localDate.isBefore(now)) {
								System.out.println("���Ű����� ��¥�� �ƴմϴ�");
								break;
							}

							// 3-3-2. ��ȭ ����
							System.out.print("������ ��ȭ ��ȣ�� �Է��ϼ��� \n>>>> ");
							String movieNumber = scn.nextLine();

							List<Movie> movies2 = movieDao.getMovieList();
							boolean chk = false;
							for (Movie movie : movies2) {
								if (movie.getMovieNumber().equals(movieNumber)) {
									chk = true;
								}
							}
							if (!chk) {
								System.out.println("�ùٸ� ��ȭ ��ȣ�� �Է��ϼ���");
								break;
							}

							// �� �ð�ǥ ���
							boolean run6 = true;
							while (run6) {
								List<Schedule> schedules = scheduleDao.getScheduleList(movieNumber, strDate);
								for (int i = 0; i < schedules.size(); i++) {
									scheduleDao.updateSeats(schedules.get(i).getScheduleId());
								}

								System.out.println("\n< �� �ð�ǥ >");
								System.out.println("  ��ȣ	  ��ȭ �̸�	  	    �� �ð�        ���� �¼�      ����");
								System.out.println(
										"----------------------------------------------------------------------------------");

								scheduleDao.showScheduleList2(schedules, page);

								System.out.println(
										"----------------------------------------------------------------------------------");
								System.out.printf("[���� ������: %d]  ", page);

								// ��ü ������ �� ���.
								// MovieDAO ��ü ��ȭ ��� �������� �Լ� => ��ȭ �� count.
								count = scheduleDao.getScheduleList(movieNumber, strDate).size();
								// ��ü ��ȭ �� / 5 + �Ҽ� �ڸ��� �ø� => ��ü ������ ��.
								totalPage = (int) Math.ceil(count / 5.0);
								for (int i = 1; i <= totalPage; i++) {
									System.out.print(i + " ");
								}

								System.out.println();
								System.out.println("������������������������������������������������������������������������������������������������������������������������������");
								System.out.println("�� 1.���� ������ �� 2.���� ������ �� 3.�� �ð� ���� �� 4.������ ��");
								System.out.println("������������������������������������������������������������������������������������������������������������������������������");
								System.out.print("������ �Է��ϼ��� \n>>>> ");
								int subMenu2 = 0;
								try {
									subMenu2 = Integer.parseInt(scn.nextLine());
								} catch (Exception e) {
									subMenu2 = 0;
								}

								switch (subMenu2) {
								// 3-1. ���� ������.
								case 1:
									if (page > 1) {
										page--;
									}
									break;
								// 3-2. ���� ������.
								case 2:
									if (page < totalPage) {
										page++;
									}
									break;

								// 3-3. ��ȭ ����
								case 3:
									System.out.print("\n������ �� ��ȣ�� �Է��ϼ��� \n>>>> ");
									int scheduleNum = 0;
									try {
										scheduleNum = Integer.parseInt(scn.nextLine());
									} catch (Exception e) {
										System.out.println("��Ȯ�� �󿵹�ȣ�� �Է����ּ���");
										break;
									}
									int scheduleId = scheduleDao.getScheduleId(scheduleNum, schedules);
									String discount = scheduleDao.getDiscount(scheduleNum, schedules);

									System.out.println("���� �ż��� �Է����ּ���");
									int adult = 0;
									int youth = 0;

									try {
										System.out.print("����    >>>> ");
										adult = Integer.parseInt(scn.nextLine());
										System.out.print("û�ҳ�  >>>> ");
										youth = Integer.parseInt(scn.nextLine());
									} catch (Exception e) {
										System.out.println("��Ȯ�� ���� �ż��� �Է����ּ���");
										break;
									}

									char rowChar;
									int column = 0;
									for (int i = 0; i < adult; i++) {
										scheduleDao.showSeats(scheduleId);

										System.out.println("������ �¼��� �����ϼ���(����)");
										try {
											System.out.print("\n���� �Է��ϼ���(A~E) \n>>>> ");
											rowChar = scn.nextLine().toUpperCase().charAt(0);
											if (rowChar < 65 || rowChar > 69) {
												System.out.println("�ùٸ� �¼� ��ȣ�� �Է��ϼ���");
												i--;
												continue;
											}

											System.out.print("\n���� �Է��ϼ���(1~10) \n>>>> ");
											column = Integer.parseInt(scn.nextLine());

											if (column < 1 || column > 10) {
												System.out.println("�ùٸ� �¼� ��ȣ�� �Է��ϼ���");
												i--;
												continue;
											}

										} catch (Exception e) {
											System.out.println("�ùٸ� �¼� ��ȣ�� �Է��ϼ���");
											i--;
											continue;
										}

										String row = String.valueOf(rowChar);
										Ticket ticket = new Ticket(userId, scheduleId, "����", row, column, discount);

										System.out.println(ticket.reserveDate);
										if (ticketDao.isOccupied(row, column, scheduleId)) {
											System.out.println("�̹� ���ŵ� �¼��Դϴ�\n");
											i--;
											continue;
										} else {
											if (ticketDao.reserveTicket(ticket)) {
												;
												System.out.println("���Ű� �Ϸ�Ǿ����ϴ�\n");
												for (int j = 0; j < schedules.size(); j++) {
//												scheduleDao.updateSeats(schedules.get(i).getScheduleId());
												}
											} else {
												System.out.println("���ſ� �����߽��ϴ�\n");
											}
										}

									} // end of for

									for (int i = 0; i < youth; i++) {
										scheduleDao.showSeats(scheduleId);

										System.out.println("������ �¼��� �����ϼ���(û�ҳ�)");
										try {
											System.out.print("\n���� �Է��ϼ���(A~E) \n>>>> ");
											rowChar = scn.nextLine().toUpperCase().charAt(0);
											if (rowChar < 65 || rowChar > 69) {
												System.out.println("�ùٸ� �¼� ��ȣ�� �Է��ϼ���");
												i--;
												continue;
											}

											System.out.print("\n���� �Է��ϼ���(1~10) \n>>>> ");
											column = Integer.parseInt(scn.nextLine());

											if (column < 1 || column > 10) {
												System.out.println("�ùٸ� �¼� ��ȣ�� �Է��ϼ���");
												i--;
												continue;
											}

										} catch (Exception e) {
											System.out.println("�ùٸ� �¼� ��ȣ�� �Է��ϼ���");
											i--;
											continue;
										}

										String row = String.valueOf(rowChar);
										Ticket ticket = new Ticket(userId, scheduleId, "û�ҳ�", row, column, discount);
										if (ticketDao.isOccupied(row, column, scheduleId)) {
											System.out.println("�̹� ���ŵ� �¼��Դϴ�\n");
											i--;
											continue;
										} else {
											if (ticketDao.reserveTicket(ticket)) {
												;
												System.out.println("���Ű� �Ϸ�Ǿ����ϴ�\\n");
												for (int j = 0; j < schedules.size(); j++) {
													scheduleDao.updateSeats(schedules.get(i).getScheduleId());
												}
											} else {
												System.out.println("���ſ� �����߽��ϴ�\\n");
											}
										}

									} // end of for

									break;
								case 4:
									run6 = false;
									break;
								default:
									break;
								}
							} // end of while(run6)
							break;
						case 4:
							run5 = false;
							break;
						default:
							break;

						}
					} // end of while(run5)
					break;
					// 4. ����������
				case 4:
					boolean run7 = true;
					while (run7) {
						System.out.println();
						System.out.println("������������������������������������������������������������������������������������������������������������������������������������");
						System.out.println("�� 1.���� Ȯ�� �� 2.�¼� ���� �� 3.���� ��� �� 4.�� ���� �� 5.������ ��");
						System.out.println("������������������������������������������������������������������������������������������������������������������������������������");
						System.out.print("������ �Է��ϼ��� \n>>>> ");
						try {
							subMenu = Integer.parseInt(scn.nextLine());
						} catch (Exception e) {
							subMenu = 0;
						}

						switch (subMenu) {
						// 4-1. ���� Ȯ��
						case 1:
							System.out.println("\n< ���� Ȯ�� >");
							System.out.println("��ȣ	  ��ȭ�̸�	  	 �󿵳�¥         ����   �¼�	    ���ų�¥");
							System.out.println(
									"----------------------------------------------------------------------------------");
							ticketDao.showTicket(userId);
							System.out.println(
									"----------------------------------------------------------------------------------");
							System.out.println("��������������������������������������������������������");
							System.out.println("�� 1.��ȭǥ ���� �� 2.������ ��");
							System.out.println("��������������������������������������������������������");
							int subMenu2 = 0;
							try {
								subMenu2 = Integer.parseInt(scn.nextLine());
							} catch (Exception e) {
								subMenu2 = 0;
							}
							if(subMenu2 == 1) {
								System.out.print("��ȸ�� ���� ��ȣ�� �Է��ϼ��� \n>>>> ");
								int scrNum = 0;
								try {
									scrNum = Integer.parseInt(scn.nextLine());
								} catch (Exception e) {
									System.out.println("�ùٸ� ���� ��ȣ�� �Է��ϼ���");
									break;
								}
								Ticket ticket = ticketDao.getTicket(scrNum);
								Schedule schedule = scheduleDao.getSchedule(scrNum);
								Movie movie = movieDao.getMovie(scrNum);
								
								System.out.println("VVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVV");
								System.out.println("\n\t   ��ȭ �����\n");
								System.out.println("  " + ticket.getReserveDate());
								System.out.println(" ================================");
								System.out.println("  " + movie.getAgeLimit() + "�� �̻� ������\n");
								System.out.println("  " + movie.getMovieName() + "\n");
								System.out.println("  " + schedule.getMovieDate() + "\n");
								System.out.println("  1�� " + ticket.getSeat_row()+"�� "+ ticket.getSeat_column() +"��\n");
								System.out.println(" ================================");
								System.out.println("  ���ο� 1��("+ ticket.getAge() +")");
								System.out.println("  " + ticket.getPrice() +"\n");
								System.out.println(" --------------------------------");
								System.out.println("  ����ó׸� ��������\n");
								System.out.println("VVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVV");
							}

							break;
						// 4-2. �¼� ����
						case 2:
							System.out.println("\n< �¼� ���� >");
							System.out.println("��ȣ	  ��ȭ�̸�	  	 �󿵳�¥         ����   �¼�	    ���ų�¥");
							System.out.println(
									"----------------------------------------------------------------------------------");
							ticketDao.showTicket(userId);
							System.out.println(
									"----------------------------------------------------------------------------------");
							System.out.print("�¼��� ������ ���� ��ȣ�� �Է��ϼ��� \n>>>> ");
							int modNum;
							try {
								modNum = Integer.parseInt(scn.nextLine());
							} catch (Exception e) {
								modNum = 0;
							}
							if (!ticketDao.checkTicket(userId, modNum)) {
								System.out.println("���� ��ȣ�� �����ϴ�");
								break;
							} else {
								int scheduleId = ticketDao.getScheduleId(modNum);

								char rowChar;
								int column = 0;
								scheduleDao.showSeats(scheduleId);

								System.out.println("������ �¼��� �����ϼ���");
								try {
									System.out.print("\n���� �Է��ϼ���(A~E) \n>>>> ");
									rowChar = scn.nextLine().toUpperCase().charAt(0);
									if (rowChar < 65 || rowChar > 69) {
										System.out.println("�ùٸ� �¼� ��ȣ�� �Է��ϼ���");
										break;
									}
									System.out.print("\n���� �Է��ϼ���(1~10) \n>>>> ");
									column = Integer.parseInt(scn.nextLine());

									if (column < 1 || column > 10) {
										System.out.println("�ùٸ� �¼� ��ȣ�� �Է��ϼ���");
										break;
									}
								} catch (Exception e) {
									System.out.println("�ùٸ� �¼� ��ȣ�� �Է��ϼ���");
									break;
								}

								String row = String.valueOf(rowChar);

								if (ticketDao.isOccupied(row, column, modNum)) {
									System.out.println("�̹� ���ŵ� �¼��Դϴ�\n");
									break;
								} else {
									if (ticketDao.modifyTicket(modNum, row, column)) {
										System.out.println("�¼� ������ �Ϸ�Ǿ����ϴ�");
									} else {
										System.out.println("�¼� ���濡 �����߽��ϴ�");
									}
								}
							}
							break;
						// ���� ���
						case 3:
							System.out.println("\n< �¼� ���� >");
							System.out.println("��ȣ	  ��ȭ�̸�	  	 �󿵳�¥         ����   �¼�	    ���ų�¥");
							System.out.println(
									"----------------------------------------------------------------------------------");
							ticketDao.showTicket(userId);
							System.out.println(
									"----------------------------------------------------------------------------------");
							System.out.print("����� ���� ��ȣ�� �Է��ϼ��� \n>>>> ");
							int delNum;
							try {
								delNum = Integer.parseInt(scn.nextLine());
							} catch (Exception e) {
								delNum = 0;
							}
							if (!ticketDao.checkTicket(userId, delNum)) {
								System.out.println("���� ��ȣ�� �����ϴ�");
								break;
							} else {
								if (ticketDao.deleteTicket(delNum)) {
									System.out.println("���� ��Ұ� �Ϸ�Ǿ����ϴ�");
								} else {
									System.out.println("���� ��ҿ� �����߽��ϴ�");
									break;
								}
							}
							break;
						// �� ����
						case 4:
							System.out.println("< �� ���� ���� >");
							User user = userDao.getUser(userId);
							System.out.println("----------------------------------------------------------------------------------\n");
							System.out.println("���̵�\t: " + user.getUserId());
							System.out.println("�̸�\t: " + user.getUserName());
							System.out.println("����ó\t: " + user.getUserTel());
							System.out.println("������\t: " + user.getJoinDate());
							System.out.println("\n----------------------------------------------------------------------------------");
							break;
						// ������
						case 5:
							run7 = false;
							break;
						default:
							break;
						}
					} // end of while(run7)
					break;
				case 5:
					System.out.println("�α׾ƿ� �Ǿ����ϴ�");
					run2 = false;
					break;
				default:
					System.out.println("�ùٸ� ������ �Է��ϼ���");
				} // end of switch

			} // end of while(run2)

			// III. ������ ȭ��.
			while (run3) {
				System.out.println("\n< ������ ������ >");
				System.out.println("��������������������������������������������������������������������������������������������������������������������������������������������");
				System.out.println("�� 1.��ȭ ���� �� 2.�� ���� �� 3.���� ���� �� 4.ȸ�� ���� �� 5.�α׾ƿ� ��");
				System.out.println("��������������������������������������������������������������������������������������������������������������������������������������������");
				System.out.print("������ �Է��ϼ��� \n>>>> ");
				int menu;
				try {
					menu = Integer.parseInt(scn.nextLine());
				} catch (Exception e) {
					menu = 0;
				}
				switch (menu) {
				// 1. ��ȭ ����
				case 1:
					boolean run4 = true;
					int page = 1;
					while (run4) {
						System.out.println("\n< ��ȭ ��� >");
						System.out.println(" ��ȣ	  ��ȭ �̸�		   ����                    �⿬���");
						System.out.println(
								"----------------------------------------------------------------------------------");
						// MovieDAO ����¡ �� ��ȭ��� ��� �Լ�.
						movieDao.showMovieList(page);
						System.out.println(
								"----------------------------------------------------------------------------------");
						System.out.printf("[���� ������: %d]  ", page);

						// ��ü ������ �� ���.
						// MovieDAO ��ü ��ȭ ��� �������� �Լ� => ��ȭ �� count.
						int count = movieDao.getMovieList().size();
						// ��ü ��ȭ �� / 5 + �Ҽ� �ڸ��� �ø� => ��ü ������ ��.
						int totalPage = (int) Math.ceil(count / 5.0);
						for (int i = 1; i <= totalPage; i++) {
							System.out.print(i + " ");
						}

						// ����޴�.
						System.out.println();
						System.out.println("����������������������������������������������������������������������������������������������������������������������������������������������");
						System.out.println("�� 1.���� ������ �� 2.���� ������ �� 3.���� �� 4.�߰� �� 5.���� �� 6.������ ��");
						System.out.println("����������������������������������������������������������������������������������������������������������������������������������������������");
						System.out.print("������ �Է��ϼ��� \n>>>> ");
						int subMenu;
						try {
							subMenu = Integer.parseInt(scn.nextLine());
						} catch (Exception e) {
							subMenu = 0;
						}

						switch (subMenu) {
						// 1-1. ���� ������.
						case 1:
							if (page > 1) {
								page--;
							}
							break;
						// 1-2. ���� ������.
						case 2:
							if (page < totalPage) {
								page++;
							}
							break;
						// 1-3. ��ȭ �� ���� ��ȸ.
						case 3:
							System.out.println("\n< ��ȭ �� ���� ��ȸ >");
							System.out.print("��ȭ ��ȣ�� �Է��ϼ��� \n>>>> ");
							String movieNumber = scn.nextLine();
							// MovieDAO ��ȭ ��ȣ�� ��ȭ ã�� ���� �Լ�.
							Movie movie = movieDao.getMovieDetail(movieNumber);
							try {
								// Movie ��ȭ ���� ��� �Լ�.
								movie.showMovieDetailInfo();
							} catch (NullPointerException e) {
								System.out.println("�ùٸ� ��ȭ ��ȣ�� �Է��ϼ���");
							}
							break;
						// 1-4. ��ȭ �߰�
						case 4:
							System.out.println("\n< ��ȭ ���� �߰� >");
							System.out.print("��ȭ��ȣ�� �Է��ϼ��� \n>>>> ");
							String movieNum = scn.nextLine();
							if (movieDao.chkMovie(movieNum)) {
								System.out.println("�ߺ��� ��ȭ��ȣ�Դϴ�");
								break;
							}
							System.out.print("��ȭ�̸��� �Է��ϼ��� \n>>>> ");
							String movieName = scn.nextLine();
							System.out.print("�������� �Է��ϼ��� \n>>>> ");
							String director = scn.nextLine();
							System.out.print("�⿬ ������ �Է��ϼ��� \n>>>> ");
							String actors = scn.nextLine();
							System.out.print("�������� �Է��ϼ���(YYYY-MM-DD) \n>>>> ");
							String releaseDate = scn.nextLine();
							DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
							try {
								LocalDate localDate = LocalDate.parse(releaseDate, formatter2);
							} catch (Exception e) {
								System.out.println("�ùٸ� ��¥ ������ �Է��ϼ���");
								break;
							}
							System.out.print("�帣�� �Է��ϼ��� \n>>>> ");
							String genre = scn.nextLine();
							System.out.print("���������� �Է��ϼ��� \n>>>> ");
							int ageLimit = 0;
							try {
								ageLimit = Integer.parseInt(scn.nextLine());
							} catch (Exception e) {
								e.printStackTrace();
							}
							System.out.print("�󿵽ð��� �Է��ϼ��� \n>>>> ");
							int runningTime = 0;
							try {
								runningTime = Integer.parseInt(scn.nextLine());
							} catch (Exception e) {
								e.printStackTrace();
							}
							System.out.print("�ٰŸ��� �Է��ϼ��� \n>>>> ");
							String plot = scn.nextLine();
							Movie newMovie = new Movie(movieNum, movieName, director, releaseDate, genre, ageLimit,
									runningTime, plot, actors);
							if (movieDao.addMovie(newMovie)) {
								System.out.println("��ȭ ���� �߰��� �Ϸ�Ǿ����ϴ�");
							} else {
								System.out.println("��ȭ ���� �߰��� �����߽��ϴ�");
							}
							break;
						// 1-5. ��ȭ ����
						case 5:
							System.out.println("\n< ��ȭ ���� ���� >");
							System.out.print("��ȭ��ȣ�� �Է��ϼ��� \n>>>> ");
							movieNum = scn.nextLine();
							if (movieDao.chkMovie(movieNum)) {
								String mName = movieDao.getMovieName(movieNum);
								System.out.print(mName + " ��ȭ�� �����Ͻðڽ��ϱ�?(Y/N)");
								String delChk = scn.nextLine();
								switch (delChk) {
								case "Y":
								case "y":
									if (movieDao.deleteMovie(movieNum)) {
										System.out.println("��ȭ ������ �Ϸ�Ǿ����ϴ�");
									} else {
										System.out.println("��ȭ ������ �����߽��ϴ�");
									}
									break;
								case "N":
								case "n":
								default:
									System.out.println("��ȭ ������ ��ҵǾ����ϴ�");
									break;
								}
							} else {
								System.out.println("��ȭ��ȣ�� �����ϴ�");
								break;
							}
							break;
						// 1-6. ������
						case 6:
							run4 = false;
							break;
						default:
							break;
						}
					}
					break;
				// 2. �󿵰���
				case 2:
					System.out.print("��ȸ�� ��¥�� �Է��ϼ��� (YYYY-MM-DD) \n>>>> ");
					String strDate = scn.nextLine();

					DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
					LocalDate localDate;
					try {
						localDate = LocalDate.parse(strDate, formatter2);
					} catch (Exception e) {
						System.out.println("�ùٸ� ��¥ ������ �Է��ϼ���");
						break;
					}
					LocalDate now = LocalDate.now();
					if (localDate.isBefore(now)) {
						System.out.println("��ȸ������ ��¥�� �ƴմϴ�");
						break;
					}

					// �� �ð�ǥ ���
					boolean run6 = true;
					page = 1;
					while (run6) {
						List<Schedule> schedules = scheduleDao.getAllScheduleList(strDate);
						for (int i = 0; i < schedules.size(); i++) {
							scheduleDao.updateSeats(schedules.get(i).getScheduleId());
						}

						System.out.println("\n< �� �ð�ǥ >");
						System.out.println("  ��ȣ   �󿵹�ȣ    ��ȭ �̸�	  	     �� �ð�        ���� �¼�    ����");
						System.out.println(
								"----------------------------------------------------------------------------------");

						scheduleDao.showScheduleList(schedules, page);

						System.out.println(
								"----------------------------------------------------------------------------------");
						System.out.printf("[���� ������: %d]  ", page);

						// ��ü ������ �� ���.
						// MovieDAO ��ü ��ȭ ��� �������� �Լ� => ��ȭ �� count.
						int count = scheduleDao.getAllScheduleList(strDate).size();
						// ��ü ��ȭ �� / 5 + �Ҽ� �ڸ��� �ø� => ��ü ������ ��.
						int totalPage = (int) Math.ceil(count / 5.0);
						for (int i = 1; i <= totalPage; i++) {
							System.out.print(i + " ");
						}

						System.out.println("\n< ���� ȭ�� >");
						System.out.println("����������������������������������������������������������������������������������������������������������������������������");
						System.out.println("�� 1.���� ������ �� 2.���� ������ �� 3.�߰� �� 4.���� �� 5.������ ��");
						System.out.println("����������������������������������������������������������������������������������������������������������������������������");
						System.out.print("������ �Է��ϼ��� \n>>>> ");
						int subMenu;
						try {
							subMenu = Integer.parseInt(scn.nextLine());
						} catch (Exception e) {
							subMenu = 0;
						}

						switch (subMenu) {
						// 3-1. ���� ������.
						case 1:
							if (page > 1) {
								page--;
							}
							break;
						// 3-2. ���� ������.
						case 2:
							if (page < totalPage) {
								page++;
							}
							break;

						// 3-3. �� �ð�ǥ �߰�
						case 3:
							System.out.println("< �� �ð�ǥ �߰� >");
							System.out.print("�߰��� ��ȭ ��ȣ�� �Է��ϼ��� \n>>>> ");
							String movieNum = scn.nextLine();
							System.out.print("�߰��� ��¥�� �ð��븦 �Է��ϼ���(yyyy-MM-dd HH:mm) \n>>>> ");
							String movieDate = scn.nextLine();
							DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
							LocalDateTime ldt;
							try {
								ldt = LocalDateTime.parse(movieDate, formatter3);
							} catch (Exception e) {
								System.out.println("�ùٸ� ��¥ ������ �Է��ϼ���");
								break;
							}
							LocalDateTime ldtNow = LocalDateTime.now();
							if (ldt.isBefore(ldtNow)) {
								System.out.println("�߰� ������ ��¥�� �ƴմϴ�");
								break;
							}
							if (scheduleDao.addSchedule(movieNum, movieDate)) {
								System.out.println("�� �ð�ǥ �߰��� �Ϸ�Ǿ����ϴ�.");
								scheduleDao.updateJojo();
								scheduleDao.updateSimya();
							} else {
								System.out.println("�� �ð�ǥ �߰��� �����߽��ϴ�.");
							}
							break;
						// 3-4. �� �ð�ǥ ����
						case 4:
							System.out.println("\n< �� �ð�ǥ ���� >");
							System.out.print("�� ��ȣ�� �Է��ϼ��� \n>>>> ");
							int schdlNum;
							try {
								schdlNum = Integer.parseInt(scn.nextLine());
							} catch (Exception e) {
								System.out.println("�ùٸ� �� ��ȣ�� �Է��ϼ���");
								break;
							}
							if (scheduleDao.chkSchedule(schdlNum)) {
								System.out.print(schdlNum + "�� �� ������ �����Ͻðڽ��ϱ�?(Y/N) \n>>>> ");
								String delChk = scn.nextLine();
								switch (delChk) {
								case "Y":
								case "y":
									if (scheduleDao.delSchedule(schdlNum)) {
										System.out.println("�� ���� ������ �Ϸ�Ǿ����ϴ�");
									} else {
										System.out.println("�� ���� ������ �����߽��ϴ�");
									}
									break;
								case "N":
								case "n":
								default:
									System.out.println("�� ���� ������ ��ҵǾ����ϴ�");
									break;
								}
							} else {
								System.out.println("��ȭ��ȣ�� �����ϴ�");
								break;
							}
							break;
						case 5:
							run6 = false;
							break;
						default:
							break;
						}
					} // end of while(run6)
					break;
				// 3. ���� ����
				case 3:
					System.out.println("< ���� ���� >");
					System.out.print("��ȸ�� ��¥�� �Է��ϼ���(YYYY-MM-DD) \n>>>> ");
					String srcDate = scn.nextLine();
					formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
					try {
						localDate = LocalDate.parse(srcDate, formatter2);
					} catch (Exception e) {
						System.out.println("�ùٸ� ��¥ ������ �Է��ϼ���");
						break;
					}

					boolean run8 = true;
					page = 1;
					while (run8) {
						List<Ticket> tickets = ticketDao.getTicketList(srcDate);

						System.out.println("\n< ���� ���� >");
						System.out.println("  ��ȣ       ���̵�    �� ��ȣ  ����    �¼�         ����         ��������");
						System.out.println(
								"---------------------------------------------------------------------------------------");

						ticketDao.showScheduleList(tickets, page);

						System.out.println(
								"---------------------------------------------------------------------------------------");
						System.out.printf("[���� ������: %d]  ", page);

						// ��ü ������ �� ���.
						// MovieDAO ��ü ��ȭ ��� �������� �Լ� => ��ȭ �� count.
						int count = ticketDao.getTicketList(srcDate).size();
						// ��ü ��ȭ �� / 5 + �Ҽ� �ڸ��� �ø� => ��ü ������ ��.
						int totalPage = (int) Math.ceil(count / 5.0);
						for (int i = 1; i <= totalPage; i++) {
							System.out.print(i + " ");
						}

						System.out.println();
						System.out.println("��������������������������������������������������������������������������������������������������������������������");
						System.out.println("�� 1.���� ������ �� 2.���� ������ �� 3.���� Ȯ�� �� 4.������ ��");
						System.out.println("��������������������������������������������������������������������������������������������������������������������");
						System.out.print("������ �Է��ϼ��� \n>>>> ");
						int subMenu;
						try {
							subMenu = Integer.parseInt(scn.nextLine());
						} catch (Exception e) {
							subMenu = 0;
						}

						switch (subMenu) {
						// 3-1. ���� ������.
						case 1:
							if (page > 1) {
								page--;
							}
							break;
						// 3-2. ���� ������.
						case 2:
							if (page < totalPage) {
								page++;
							}
							break;
						// 3-3. ���� ��ȸ
						case 3:
							ticketDao.dailySales();
							break;
						// 3-4. ������
						case 4:
							run8 = false;
							break;
						default:
							break;
						}
					}
					break;
				// 4. ȸ�� ����
				case 4:
					System.out.println("\n< ȸ�� ���� >");
					page = 1;
					boolean run9 = true;
					while (run9) {
						List<User> users = userDao.getUserList();

						System.out.println("\n< �� �ð�ǥ >");
						System.out.println("  ��ȣ  ���̵�     �̸�	  	   ����ó        ��������");
						System.out.println(
								"----------------------------------------------------------------------------------");

						userDao.showUserList(users, page);

						System.out.println(
								"----------------------------------------------------------------------------------");
						System.out.printf("[���� ������: %d]  ", page);

						// ��ü ������ �� ���.
						// MovieDAO ��ü ��ȭ ��� �������� �Լ� => ��ȭ �� count.
						int count = userDao.getUserList().size();
						// ��ü ��ȭ �� / 5 + �Ҽ� �ڸ��� �ø� => ��ü ������ ��.
						int totalPage = (int) Math.ceil(count / 5.0);
						for (int i = 1; i <= totalPage; i++) {
							System.out.print(i + " ");
						}

						System.out.println();
						System.out.println("��������������������������������������������������������������������������������������������������������������������������������������������������");
						System.out.println("�� 1.���� ������ �� 2.���� ������ �� 3.ȸ�� �߰� �� 4.ȸ�� ���� �� 5. ������ ��");
						System.out.println("��������������������������������������������������������������������������������������������������������������������������������������������������");
						System.out.print("������ �Է��ϼ��� \n>>>> ");
						int subMenu;
						try {
							subMenu = Integer.parseInt(scn.nextLine());
						} catch (Exception e) {
							subMenu = 0;
						}

						switch (subMenu) {
						// 4-1. ���� ������.
						case 1:
							if (page > 1) {
								page--;
							}
							break;
						// 4-2. ���� ������.
						case 2:
							if (page < totalPage) {
								page++;
							}
							break;
						// 4-3. ������
						case 3:
							System.out.println("\n< ȸ�� �߰� >");
							System.out.print("�߰��� ���̵� �Է��ϼ��� \n>>>> ");
							userId = scn.nextLine();

							// ������ ���̵� ���� ����
							if (userId.equals("sys")) {
								System.out.println("������ �� ���� ���̵��Դϴ�");
								break;
							}
							// �ߺ� ���̵� ���� ����
							if (userDao.chkUserId(userId)) {
								System.out.println("�̹� �����ϴ� ���̵��Դϴ�");
								break;
							}

							System.out.print("��й�ȣ�� �Է��ϼ��� \n>>>> ");
							String passwd = scn.nextLine();
							System.out.print("��й�ȣ�� �ѹ� �� �Է��ϼ��� \n>>>> ");
							String passwd2 = scn.nextLine();

							// ��й�ȣ ��ġ Ȯ��.
							if (!passwd.equals(passwd2)) {
								System.out.println("��й�ȣ�� �ٸ��ϴ�");
								break;
							}

							System.out.print("�̸��� �Է��ϼ��� \n>>>> ");
							String userName = scn.nextLine();
							System.out.print("����ó�� �Է��ϼ��� \n>>>> ");
							String userTel = scn.nextLine();

							User user = new User(userId, passwd, userName, userTel);
							if (userDao.signUp(user)) {
								System.out.println("ȸ�� �߰��� �Ϸ�Ǿ����ϴ�");
							}
							else {
								System.out.println("ȸ�� �߰��� �����߽��ϴ�");
							}
							break;
						case 4:
							System.out.println("\n< ȸ�� ���� >");
							System.out.print("������ ���̵� �Է��ϼ��� \n>>>> ");
							userId = scn.nextLine();
							// ������ ���̵� ���� ����
							if (userId.equals("sys")) {
								System.out.println("������ �� ���� ���̵��Դϴ�");
								break;
							}
							// ���� ���̵� �Է� ����
							if (!userDao.chkUserId(userId)) {
								System.out.println("�������� �ʴ� ���̵��Դϴ�");
								break;
							}
							if(userDao.deleteUser(userId)) {
								System.out.println("ȸ�� ������ �Ϸ�Ǿ����ϴ�");
							}
							else {
								System.out.println("ȸ�� ������ �����߽��ϴ�");
							}
							
							break;
						case 5:
							run9 = false;
							break;
						default:
							break;
						}
					}
					break;
				case 5:
					System.out.println("�α׾ƿ� �Ǿ����ϴ�");
					run3 = false;
					break;
				default:
					break;
				}
			} // end of while(run3)
		} // end of while(run0)
		scn.close();
		System.out.println("end of prog.");
	}

}
