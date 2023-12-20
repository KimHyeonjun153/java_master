package com.yedam;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class TestApp {

	public static void main(String[] args) {

		// 1. ����ð�
		LocalDateTime now = LocalDateTime.now();
		System.out.println("LocalDateTime now = " + now);
		
		String formattedNow = now.format(DateTimeFormatter.ofPattern("yyyy�� MM�� dd�� HH�� mm��"));
		System.out.println("String formattedNow = " + formattedNow);
		
		int hour = now.getHour();
		System.out.println("now.getHour() = " + hour);
		System.out.println();
		
		// 2. ���� �Է�
		LocalDateTime then = LocalDateTime.of(2023, 12, 20, 8, 00);
		System.out.println("LocalDateTime then = " + then);
		
		String formattedThen = then.format(DateTimeFormatter.ofPattern("yyyy�� MM�� dd�� HH�� mm��"));
		System.out.println("String formattedThen = " + formattedThen);
		
		int hour2 = then.getHour();
		if(hour2 <= 9) {
			System.out.println("������ȭ �Դϴ�");
		}
		else if(hour2 >= 23) {
			System.out.println("�ɾ߿�ȭ �Դϴ�");
		}
		else {
			System.out.println("�Ϲݿ�ȭ �Դϴ�");
		}
		System.out.println();
		
		// 3. String to LocalDateTime
		String strDateTime = "2023-12-16 09:00";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		LocalDateTime ldtDate = LocalDateTime.parse(strDateTime, formatter);
		System.out.println("LocalDateTime ldtDate = " + ldtDate);
		
		// 4. String to LocalDate
		String strDate = "2023-12-16";
		DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate ldDate = LocalDate.parse(strDate, formatter2);
		System.out.println("LocalDate ldDate = " + ldDate);
		
		
		char A = 65;
		char E = 69;
		System.out.println(A + ", " + E);
		
		String movieDate = "2023-12-20 12:00";
		DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		LocalDateTime ldt;
		try {
			ldt = LocalDateTime.parse(movieDate, formatter3);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("VVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVV");
		System.out.println("\n\t   ��ȭ �����\n");
		System.out.println("  2023-12-19 17:30");
		System.out.println(" ================================");
		System.out.println("  12�� �̻� ������\n");
		System.out.println("  ������ ��\n");
		System.out.println("  2023-12-25 12:00 ~ 14:30\n");
		System.out.println("  1�� A�� 5��\n");
		System.out.println(" ================================");
		System.out.println("  ���ο� 1��(����)");
		System.out.println("  �ְ� 15000��\n");
		System.out.println(" --------------------------------");
		System.out.println("  ����ó׸� ��������\n");
		System.out.println("VVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVV");
	}

}
