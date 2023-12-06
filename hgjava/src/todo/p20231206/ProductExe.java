package todo.p20231206;

import java.util.*;

public class ProductExe {
	// <�̱��� ����> :
	// ��ü ���α׷����� �ϳ��� �ν��Ͻ��� ���� ����.
	// 1. Ŭ���� �ܺο��� new �����ڷ� ȣ�� ���ϰ� ���� => private ������
	// 2. �ڽ� Ÿ���� �����ʵ� �����ϰ� �ʱ�ȭ => private static ProductExe
	// 3. �ܺο��� ȣ�� ������ ���� �޼ҵ� getInstance() ���� => static �ʵ��� �ν��Ͻ� ����
	//
	// => �ٸ� Ŭ�������� ProductExe Ŭ������ �ν��Ͻ� �������� getInstance() �޼ҵ常 �����
	// => getInstance�� �� �ϳ��� ��ü�� ����
	
	// �ʵ�.
	private static ProductExe instance = new ProductExe();
	ArrayList<Product> productList = new ArrayList<>();
	
	// ������.
	private ProductExe(){
		productList.add(new Product("P001", "����", 1000));
		productList.add(new Product("P002", "����", 1200));
		productList.add(new Product("N001", "��Ʈ100", 1000));
		productList.add(new Product("N002", "���̾", 3000));
	}

	// �޼ҵ�.
	// 0. �ڽ� Ÿ���� �ν��Ͻ� ��ȯ �޼ҵ�(�̱���)
	public static ProductExe getInstance() {
		return instance;
	}
	
	// 1. ��ǰ �߰� �޼ҵ�.
	public boolean addProduct(String inputCode, String inputName, int inputPrice) {
		// �ߺ� üũ: productList�� ��ǰ �ڵ�� ��ġ�ϴ� �� ������ false ����.
		for(Product product : productList) {
			if(product.getProdCode().equals(inputCode)) {
				return false;
			}
		}
		// �ߺ��� ������ productList�� �߰�.
		productList.add(new Product(inputCode, inputName, inputPrice));
		return true;
	}

	// 2. ��ǰ ���� �޼ҵ�
	public boolean modifyProduct(String inputCode, String inputName, int inputPrice) {
		// productList�� ��ǰ �ڵ�� ��ġ�ϴ� �� ������ set �޼ҵ�� �� ����
		for(Product product : productList) {
			if(product.getProdCode().equals(inputCode)) {
				product.setProdName(inputName);
				product.setProdPrice(inputPrice);
				return true;
			}
		}
		return false;
	}

	// 3. ��� ��ȸ �޼ҵ�
	public void getProductList() {
		// for�� ������ �ϳ��� showInfo()�� ���
		for(Product product : productList) {
			product.showInfo();
		}
	}
	
	
	
}
