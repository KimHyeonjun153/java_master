package chap07.casting;

public class MainExe {

	public static void main(String[] args) {
		
		double d1 = 100;
		int n1 = (int) 100.0;
		
		// �ڵ� ����ȯ(promotion).
		Parent p1 = new Child();	// �ڽ� Ŭ������ �θ� Ŭ������ �ڵ� ����ȯ.
		
		// ���� ����ȯ(casting).
		// Child c1 = (Child)new Parent();	// �θ� Ŭ������ �ڽ� Ŭ������ ���� ����ȯ �ʿ�.
				
		// ���� ����ȯ.
		// �ڽ� �ν��Ͻ��� ��� �ִ� �θ� �ν��Ͻ��� �ڽ� Ŭ������ ���� ����ȯ ����.
		// == �θ� Ŭ������ ����ȯ �� �� �ִ� �ν��Ͻ��� �ٽ� �ڽ� Ŭ������ ����ȯ ����
		// ����: �����Ͽ��� / ���࿡��.
		Parent p2 = new Parent();
		Child c2 = new Child();
		
		 p2 = c2;
		
		 //����ȯ ���� �ν��Ͻ� ���� üũ
		 if(p2 instanceof Child) {
			 Child c3 = (Child) p2;
			 System.out.println("����Ϸ�");
		 }
		System.out.println("end of prog.");
	}

}
