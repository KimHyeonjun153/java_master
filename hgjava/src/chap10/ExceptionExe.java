package chap10;

public class ExceptionExe {

	public static void main(String[] args) {

		try {
			test();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("���� �߻�");
		}
		System.out.println("end of prog");
		
	}
	
	public static void test() throws ClassNotFoundException {	//
		// �Ϲݿ��� : ���� ó�� ���ϸ� ������ �ȵ�(RuntimeExcioption ����Ŭ���� �ƴ϶�)
			Class.forName("java.lang.String");
		
	}
}
