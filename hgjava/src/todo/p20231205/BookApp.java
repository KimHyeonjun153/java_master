package todo.p20231205;

public class BookApp {

	public static void main(String[] args) {

		BookExe exe = new BookExe();
		boolean run = true;
		
		while(run) {

			// 0. ���α׷� ����
			int menu = exe.progStart();
			
			switch(menu) {
			// 1.���� ���.
			case 1:
				exe.addBook();
				break;
				
			// 2.��� ��ȸ.
			case 2:
				exe.showBookList();
				break;
				
			// 3.�ܰ� ��ȸ.
			case 3:
				exe.showBook();
				break;
					
			// 3.���� ����.	
			case 4:
				exe.modifyBook();
				break;
				
			// 4.���� ����.
			case 5:
				exe.removeBook();
				break;
				
			// 5.����.
			case 6:
				System.out.println("���α׷��� �����մϴ�.");
				run = false;
				break;
				
			default:
				System.out.println("�ùٸ� ������ �Է��ϼ���");
			} // end of switch.
			
		} // end of while.
		
		System.out.println("end of prog.");
		
	} // end of main.

}
