package todo.p20231206;

import java.text.SimpleDateFormat;
import java.util.*;

public class InOutExe {
	// �ʵ�.
	// �̱��� ���� : getInstance()�� ������ �ϳ��� �ν��Ͻ� ������.
	ProductExe pExe = ProductExe.getInstance();
	static ArrayList<InOut> inOutList = new ArrayList<>();
	
	// ������.
	InOutExe(){
		inOutList.add(new InOut("P001", "2023-12-06", 10));
		inOutList.add(new InOut("P001", "2023-12-06", -2));
		inOutList.add(new InOut("P001", "2023-12-06", -3));
	}
	
	// �޼ҵ�.
	// 1. ��ǰ �Ǹ� �޼ҵ�.
	public boolean sellProduct(String inputCode, int inputQuantity) {	
		// productList�� ��� �ݺ���.
		for(Product product : pExe.productList) {
			// (1)��ǰ �ڵ尡 ���� (2)���-�Ǹŷ��� ������ �ƴҶ� �Ǹ� �̷����.
			if(product.getProdCode().equals(inputCode) && (remainQuantity(inputCode) - inputQuantity) >= 0) {
				// �ŷ����ڴ� ���� ��¥�� �ڵ� ����.
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				Date date = new Date();
				String transDate = sdf.format(date);
				// inOutList�� �ŷ� ����.
				// inputQuantity ����� ���� / ������ �Ǹ�
				inOutList.add(new InOut(inputCode, transDate, -inputQuantity));
				return true;
			}
		}
		return false;
	}
	
	// 2. ��ǰ ���� �޼ҵ�.
	public boolean buyProduct(String inputCode, int inputQuantity) {
		for(Product product : pExe.productList) {
			if(product.getProdCode().equals(inputCode)) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				Date date = new Date();
				String transDate = sdf.format(date);
				inOutList.add(new InOut(inputCode, transDate, inputQuantity));
				return true;
			}
		}
		return false;
	}
	
	// 3. ��� Ȯ�� �޼ҵ�.
	public int remainQuantity(String InputCode) {
		// ��� 0���� �ʱ�ȭ
		int remainQuantity = 0;
		for(InOut inout : inOutList) {
			// inOutList �ݺ��� ������ �ϳ��ϳ� �ŷ��� �հ� ����
			// ���� : ��� / �Ǹ� : ����
			if(inout.getProdCode().equals(InputCode)) {
				remainQuantity += inout.getQuantity();
			}
		}
		return remainQuantity;
	}
}
