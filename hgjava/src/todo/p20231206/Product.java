package todo.p20231206;

import lombok.Data;

@Data
public class Product {
	
	// �ʵ�.
	String prodCode;
	String prodName;
	int prodPrice;

	// ������.
	Product(){}

	Product(String prodCode, String prodName, int prodPrice) {
		super();
		this.prodCode = prodCode;
		this.prodName = prodName;
		this.prodPrice = prodPrice;
	}
	
	// �޼ҵ�.
	// �ʵ� ��� �޼ҵ�.
	void showInfo() {
		System.out.printf("%8s %10s %10d\n", prodCode, prodName, prodPrice);
	}
	
}
