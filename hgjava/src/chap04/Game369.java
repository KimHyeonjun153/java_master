package chap04;

import java.util.Scanner;

public class Game369 {

	public static void main(String[] args) {
		//Q. 369 ����
		System.out.println("==========369 ����==========");
		int count = 0;
		
		for (int i = 1; i <= 100; i++) {
			//ī��Ʈ �ʱ�ȭ
			count = 0;
			
			//���� �ڸ� 3�� ��� �˻� 
			if(i % 10 == 3 || i % 10 == 6 || i % 10 == 9) count++;
			
			//���� �ڸ� 3�� ��� �˻�
			if(i > 10 && (i / 10) % 3 == 0) count++;
			
			//��Ʈ ������� ���
//			if(count == 0) System.out.print(i + "\t");
//			else if(count == 1) System.out.print("��\t");
//			else System.out.print("����\t");
			
			//switch������ ���
			switch(count) {
			case 0 : System.out.print(i + "\t"); break;
			case 1 : System.out.print("��\t"); break;
			case 2 : System.out.print("����\t");
			}
			
			//10���� �� �ٲ�
			if(i % 10 == 0) System.out.println();
		}
		
		
		//Q. ���� ��ȯ ����
		System.out.println("==========������ȯ ����==========");
		Scanner scInput = new Scanner(System.in);
		
		System.out.print("##��ȯ�� �ݾ� : ");
		int money = scInput.nextInt();
		int change = 0;
		
		System.out.printf("500�� ¥�� : %d��\n", money / 500);
		change = money % 500;
		System.out.printf("100�� ¥�� : %d��\n", change / 100);
		change %= 100;
		System.out.printf("50�� ¥�� : %d��\n", change / 50);
		change %= 50;
		System.out.printf("10�� ¥�� : %d��\n", change / 10);
		change %= 10;
	
		System.out.printf("��ȯ �ݾ� : %d��\n", money - change);
		System.out.printf("���� �ݾ� : %d��\n", change);
		
		
		//Q. ���� ��������
		System.out.println("==========���� ���� ����==========");
		int rNum = (int)(Math.random()*100) + 1;
		System.out.println(rNum);
		
		while(true) {
			System.out.print("���� �Է� : ");
			int gNum = scInput.nextInt();
			
			if(gNum < rNum) {
				System.out.println("UP �ϼ���!");
			}
			else if(gNum > rNum) {
				System.out.println("DOWN �ϼ���!");
			}
			else {
				System.out.println("�����մϴ�!");
				break;
			}
		}
		
		
		//Q. ���� ��� ���α׷�
		System.out.println("==========���� ���==========");
		System.out.print("##�⵵ �Է� : ");
		int yearInput = scInput.nextInt();
		
		if(yearInput % 4 == 0 && yearInput % 100 != 0 || yearInput % 400 == 0 ) {
			System.out.println(yearInput + "���� �����Դϴ�.");
		}
		else {
			System.out.println(yearInput + "���� ����Դϴ�.");
		}
	
		
		//Q. ������ ���α׷�
		for(int i = 2; i <= 9; i++) {
			System.out.printf("  %d��\t", i);
			if(i == 9) System.out.println();
		}
		for(int i = 1; i <= 9; i++) {
			for(int j = 2; j <= 9; j++) {
				System.out.printf("%dx%d= %d\t", j, i, i*j);
				if(j == 9) System.out.println();; 
			}
			
		}
		
//		scInput.close();
		
		//Q. ���������� ���α׷�
		//github java_master repository�� �߰���
		int hDec = 0;
		int cDec = 0;
		int hScore = 0;
		int cScore = 0;
		boolean run = true;
		
		while(run) {
			System.out.print("## ����(0) ����(1) ��(2) : ");
			hDec = scInput.nextInt();
			cDec = (int)(Math.random() * 3);
			if(hDec == 0 && cDec == 2) hDec = 3;
			if(hDec == 2 && cDec == 0) cDec = 3;
						
			if(hDec > cDec) {
				System.out.printf("��� %d, �� %d : ��� �¸�\n", hDec % 3, cDec % 3);
				hScore++;
			}
			else if(hDec < cDec) {
				System.out.printf("��� %d, �� %d : �� �¸�\n", hDec % 3, cDec % 3);
				cScore++;
			}
			else if(hDec == cDec) {
				System.out.printf("��� %d, �� %d : ���º�\n", hDec % 3, cDec % 3);
			}
			
			if(hScore == 3) {
				System.out.printf("���� ���ھ� %d : %d  ��� �¸�!", hScore, cScore);
				run = false;
			}
			if(cScore == 3) {
				System.out.printf("���� ���ھ� %d : %d  ��ǻ�� �¸�!", hScore, cScore);
				run = false;
			}
		}
		
		scInput.close();
	}
}
