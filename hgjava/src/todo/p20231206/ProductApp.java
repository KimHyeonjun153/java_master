package todo.p20231206;

import java.util.Scanner;

public class ProductApp {
	

	public static void main(String[] args) {
		
		// ProductExe�� ��ü�� ���� ���� getInstance() �޼ҵ� ȣ��(�̱���).
		ProductExe pExe = ProductExe.getInstance();
		InOutExe ioExe = new InOutExe();
		Scanner scn = new Scanner(System.in);

		boolean run = true;
		
		while(run) {
			System.out.println();
			System.out.println("��������������������������������������������������������������������������������");
			System.out.println("�� 1.��ǰ ���� �� 2.����� ���� �� 3.���� ��");
			System.out.println("��������������������������������������������������������������������������������");
			System.out.print("������ �Է��ϼ��� \n>> ");
			int menu;
			//Integer.parseInt() ����ó�� => �������� default�� ���� while�� �ٽ� ����.
			try {
				menu = Integer.parseInt(scn.nextLine());
			} catch(NumberFormatException e) {
				menu = 0;
			}
			
			switch(menu) {
			
			// 1. ��ǰ ����.
			case 1:
				boolean run2 = true;
				while(run2) {
					System.out.println("\n< ��ǰ ���� >");
					System.out.println("������������������������������������������������������������������������������");
					System.out.println("�� 1.��� �� 2.���� �� 3.��� �� 4.������ ��");
					System.out.println("������������������������������������������������������������������������������");
					System.out.print("������ �Է��ϼ��� \n>> ");
					int subMenu;
					//Integer.parseInt() ����ó��.
					try {
						subMenu = Integer.parseInt(scn.nextLine());
					} catch(NumberFormatException e) {
						subMenu = 0;
					}
					switch(subMenu) {
					// 1-1) ��ǰ ���.
					case 1:
						System.out.println("\n< ��ǰ ��� >");
						System.out.print("��ǰ�ڵ带 �Է��ϼ��� \n>> ");
						String inputCode = scn.nextLine();
						System.out.print("��ǰ���� �Է��ϼ��� \n>> ");
						String inputName = scn.nextLine();
						System.out.print("������ �Է��ϼ��� \n>> ");
						// Integer.parseInt() ����ó��.
						int inputPrice = 0;
						try {
							inputPrice = Integer.parseInt(scn.nextLine());
						} catch(NumberFormatException e) {
							System.out.println("�ùٸ� ��ǰ ������ �Է��ϼ���");;
						}
						
						// ProductExe Ŭ������ ��ǰ ��� �޼ҵ� ȣ��.
						boolean chk = pExe.addProduct(inputCode, inputName, inputPrice);
						if(chk)
							System.out.println("��ǰ ����� �Ϸ�Ǿ����ϴ�");
						else
							System.out.println("��ǰ �ڵ尡 �ߺ��Ǿ����ϴ�.");
						break;
					
					// 1-2) ��ǰ ����
					case 2:
						System.out.println("\n< ��ǰ ���� >");
						System.out.print("��ǰ�ڵ带 �Է��ϼ��� \n>> ");
						inputCode = scn.nextLine();
						System.out.print("������ ��ǰ���� �Է��ϼ��� \n>> ");
						inputName = scn.nextLine();
						System.out.print("������ ������ �Է��ϼ��� \n>> ");
						inputPrice = 0;
						// Integer.parseInt() ����ó��.
						try {
							inputPrice = Integer.parseInt(scn.nextLine());
						} catch(NumberFormatException e) {
							System.out.println("�ùٸ� ��ǰ ������ �Է��ϼ���");;
						}
						
						//  ProductExe Ŭ������ ��ǰ ���� �޼ҵ� ȣ��.
						chk = pExe.modifyProduct(inputCode, inputName, inputPrice);
						if(chk)
							System.out.println("��ǰ ���� ������ �Ϸ�Ǿ����ϴ�");
						else
							System.out.println("��ǰ ���� ������ �����߽��ϴ�.");
						break;
					
					// 1-3) ��� ��ȸ
					case 3:
						System.out.println("\n< ��ǰ ��� ��ȸ>");
						System.out.printf("%5s %8s %8s\n", "��ǰ�ڵ�", "��ǰ��", "����");
						System.out.println("===================================");
						
						//  ProductExe Ŭ������ ��� ��ȸ �޼ҵ� ȣ��.
						pExe.getProductList();
						break;
						
					// 1-4) subMenu while�� ����.
					case 4:
						System.out.println("< ������ >");
						run2 = false;
						break;
						
					default:
						break;
					}
				}
				break;
				
			// 2. ����� ����.	
			case 2:
				boolean run3 = true;
				while(run3) {
					System.out.println("\n< ����� ���� >");
					System.out.println("������������������������������������������������������������������������������");
					System.out.println("�� 1.�Ǹ� �� 2.���� �� 3.��� �� 4.������ ��");
					System.out.println("������������������������������������������������������������������������������");
					System.out.print("������ �Է��ϼ��� \n>> ");
					int subMenu;
					try {
						subMenu = Integer.parseInt(scn.nextLine());
					} catch(NumberFormatException e) {
						subMenu = 0;
					}
					switch(subMenu) {
					
					// 2-1) ��ǰ �Ǹ�
					case 1:
						System.out.println("\n< ��ǰ �Ǹ� >");
						System.out.print("�Ǹ��� ��ǰ�� ��ǰ�ڵ带 �Է��ϼ��� \n>> ");
						String inputCode = scn.nextLine();
						System.out.print("�Ǹ� ������ �Է��ϼ��� \n>> ");
						int inputQuantity = 0;
						// Integer.parseInt() ����ó��.
						try {
							inputQuantity = Integer.parseInt(scn.nextLine());
						} catch(NumberFormatException e) {
							System.out.println("�ùٸ� ��ǰ ������ �Է��ϼ���");;
						}
						
						// InOutExe Ŭ������ ��ǰ �Ǹ� �޼ҵ� ȣ��.
						boolean chk = ioExe.sellProduct(inputCode, inputQuantity);
						if(chk)
							System.out.println("��ǰ �ǸŰ� �Ϸ�Ǿ����ϴ�");
						else
							System.out.println("��ǰ �Ǹſ� �����߽��ϴ�");
						break;
						
					// 2-2) ��ǰ ����
					case 2:
						System.out.println("\n< ��ǰ ���� >");
						System.out.print("������ ��ǰ�� ��ǰ�ڵ带 �Է��ϼ��� \n>> ");
						inputCode = scn.nextLine();
						System.out.print("���� ������ �Է��ϼ��� \n>> ");
						inputQuantity = 0;
						// Integer.parseInt() ����ó��.
						try {
							inputQuantity = Integer.parseInt(scn.nextLine());
						} catch(NumberFormatException e) {
							System.out.println("�ùٸ� ��ǰ ������ �Է��ϼ���");;
						}
						
						// InOutExe Ŭ������ ��ǰ ���� �޼ҵ� ȣ��.
						chk = ioExe.buyProduct(inputCode, inputQuantity);
						if(chk)
							System.out.println("��ǰ ���Ű� �Ϸ�Ǿ����ϴ�");
						else
							System.out.println("��ǰ ���ſ� �����߽��ϴ�");
						break;
					
					// 2-3) ��� ��ȸ
					case 3:
						System.out.println("\n< ��� ��ȸ>");
						System.out.printf("%5s %6s\n", "��ǰ�ڵ�", "������");
						System.out.println("=========================");
						
						// productList�� �Ѱ��Ѱ��� ��� �ݺ������� ���.
						for(Product product : pExe.productList) {
							// InOutExe Ŭ������ ��� ��ȸ �޼ҵ� ȣ��.
							System.out.printf("%8s %8d\n",product.getProdCode(), ioExe.remainQuantity(product.prodCode));
						}
						break;
					// 2-4) subMenu while�� ����
					case 4:
						System.out.println("< ������ >");
						run3 = false;
						break;
					default:
					}
				}
				break;
				
			case 3:
				System.out.println("���α׷��� �����մϴ�");
				scn.close();
				run = false;
				break;
				
			default:
				System.out.println("�ùٸ� ������ �Է��ϼ���");
				break;
			} // end of switch.
			
		} // end of while.
		
		System.out.println("end of prog.");
		
	} // end of main.

}
