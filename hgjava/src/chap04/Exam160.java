package chap04;

import java.util.Scanner;

public class Exam160 {

	public static void main(String[] args) {
		//���� 2 : 3�� ��� ��
		int sum = 0;
		for(int i = 1; i <= 100; i++) {
			if(i % 3 == 0) {
				sum += i;
			}
		}
		System.out.println(sum);
		
		//���� 3
		while(true) {
		int dice1 = (int)(Math.random()* 6) + 1;
		int dice2 = (int)(Math.random()* 6) + 1;
		
		System.out.printf("(%s, %s)\n", dice1, dice2);
		if(dice1 + dice2 == 5) {
				System.out.println("����");
				break;
			}
		}
		
		//���� 4		
		for(int x = 1; x <= 10; x++) {
			for(int y = 1; y <= 10; y++) {
				if(4*x + 5*y == 60) {
					System.out.printf("(%s, %s)\n", x, y);
					break;
				}
			}
		}
		
		//���� 5
		int line = 4;
		String stars = "";
		for (int i = 1; i <= line; i++) {
			for (int j = 1; j <= i; j++) {
				stars += "*";
			}
			stars += "\n";
		}
		System.out.println(stars);
		
		//���� 6
		for (int i = 1; i <= line; i++) {
			for(int j = line-1; j >= i; j--) {
				stars += " ";
			}
			for (int j = 1; j <= i; j++) {
				stars += "*";
			}
			stars += "\n";
		}
		System.out.println(stars);
		
		//���� 7
		boolean run = true;
		int balance = 0;
		Scanner scanner = new Scanner(System.in);
		
		bankProgram: while(run) {
			System.out.println("------------------------------------");
			System.out.println("1.���� | 2.��� | 3.�ܰ� | 4.����");
			System.out.println("------------------------------------");
			System.out.print("����> ");
			
			String scInput = scanner.nextLine();
			
			switch(scInput) {
				case "1" :
				case "����" : 
					System.out.print("���ݾ�> ");
					scInput = scanner.nextLine();
					balance += Integer.parseInt(scInput);
					System.out.println();
					break;
				case "2" : 
				case "���" :
					System.out.print("��ݾ�> ");
					scInput = scanner.nextLine();
					if(Integer.parseInt(scInput) <= balance) {
						balance -= Integer.parseInt(scInput);
						System.out.println();						
					}
					else {
						System.out.println("�ܾ��� �����մϴ�");						
						System.out.println();						
					}
					break;
				case "3" : 
				case "�ܰ�" :
					System.out.printf("�ܰ�> %d\n", balance);
					System.out.println();
					break;
				case "4" :
				case "����" :
					System.out.println();
					break bankProgram;
//					run = false;
//					break;
				default : 
					System.out.println("�ٽ� �Է��ϼ���\n");
			}
		}
		System.out.println("���α׷� ����");
		scanner.close();
		
	}

}
