package todo.p20231128;

public class MainExe {

	public static void main(String[] args) {
		
		BoardApp app = BoardApp.getInstance();
//		BoardApp app2 = BoardApp.getInstance();
//		System.out.println(app == app2);	// true.
		// �ν��Ͻ� ������ �����Ϸ��ص� �ϳ��� ������ => �̱��� ����	
		app.start();
		
	}
	
}
