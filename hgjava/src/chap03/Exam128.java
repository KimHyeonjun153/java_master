package chap03;

import java.util.*;

public class Exam128 {

	public static void main(String[] args) {
		//���� 4
		int penNum = 534;
		int stuNum = 30;
		
		int ppsNum = penNum /stuNum;
		int rempNum = penNum % stuNum;
		System.out.printf("�л� �� ���� �� : %s, ���� ���� �� : %s\n", ppsNum, rempNum);
		
		//���� 6
		int value = 356;
		System.out.println(value + "�� ���� �ڸ� ���� ���� : " + value / 100 * 100);	//���� �ڸ������� ���
		
		//���� 7 => �ε� �Ҽ��� ǥ�� ��� : 0.1f�� 0.1 ���� ū ��
		//���� Ÿ�� ��ȯ : (float)0.1
		
		//���� 8
		//��ٸ����� �ʺ� = (���� + �Ʒ���) * ���� / 2
		int lengthTop = 5;
		int lengthBottom = 10;
		int height = 7;
//		double area = ((double)lengthTop + lengthBottom) * height / 2;
		double area = (lengthTop + lengthBottom) * height / 2.0;
		System.out.println("��ٸ����� ���� : " + area);
		
		//���� 9
		//Scanner �������� ����
		Scanner sc = new Scanner(System.in);
		
		//���ڸ� �Է¹��� �� : nextDouble() ��� ����
		System.out.print("ù��° �� : ");
		double scInput1 = sc.nextDouble();
		
		System.out.print("�ι�° �� : ");
		double scInput2 = sc.nextDouble();

		System.out.println("--------------------");
		
		//������ ��  = 0�̸� "���: ���Ѵ�"
		System.out.println(scInput2 != 0 ? "���: " + scInput1 / scInput2 : "���: ���Ѵ�");
//		if(scInput2 != 0) {
//			System.out.println("���: " + scInput1 / scInput2);			
//		}
//		else {
//			System.out.println("���: ���Ѵ�");			
//		}		
		
		//���� 10
		int var1 = 10;
		int var2 = 3;
		int var3 = 14;
		double var4 = var1 * var1 * Double.parseDouble(var2 + "." + var3);
		System.out.println("���� ���� : " + var4);
		
		//���� 11 : �⺻Ÿ�� ������ ��(==), ����Ÿ�� ��(equals())
		Scanner sc2 = new Scanner(System.in);
		
		System.out.print("���̵� : ");
		String name = sc2.nextLine();
		
		System.out.print("�н����� : ");
		String strPassword = sc2.nextLine();		
		int password = Integer.parseInt(strPassword);
		
		if(name.equals("java")) {
			if(password == 12345) {
				System.out.println("�α��� ����");
			}
			else {
				System.out.println("�α��� ����: �н����尡 Ʋ��");
			}
		}
		else {
			System.out.println("�α��� ����: ���̵� �������� ����");
		}
		
		sc.close();
		sc2.close();
	}//end main()

}//end class
