package todo.p20231206;

import lombok.Data;

@Data

public class InOut {
	
	// �ʵ�.
	String prodCode;
	String transDate;
	int quantity;
	
	// ������.
	InOut(){}
	
	public InOut(String prodCode, String transDate, int quantity) {
		super();
		this.prodCode = prodCode;
		this.transDate = transDate;
		this.quantity = quantity;
	}

	// �޼ҵ�.
	// ��ǰ�ڵ�+��� ��� �޼ҵ�.
	void showInOutList() {
		String sellBuy = "";
		if(quantity >= 0) 
			sellBuy = "����";
		else 
			sellBuy = "�Ǹ�";
		
		System.out.printf("%5s %15s %5d %8s\n", prodCode, transDate, quantity, sellBuy);
	}

	public static void main(String[] args) {
		
//		InOutExe ioExe = new InOutExe();	// inOutExe�� �ν��Ͻ��� �޾ƿ��� ������ ��� �� �𸣰���
		
		System.out.println("< �Ǹ����� >");
		System.out.println("��ǰ�ڵ�    ó����¥    ����     ��(��)��");
		System.out.println("=========================================");
		for(int i = 0; i < InOutExe.inOutList.size(); i++) {
			// inOutList ��ü ��� ���
			InOutExe.inOutList.get(i).showInOutList();
		}
		
	}
}
