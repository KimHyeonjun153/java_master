package remind07;

public class StudentApp {

	public static void main(String[] args) {
		
		boolean run = true;
		StudentExe exe = new StudentExe();
		
		while(run) {	
			int menu = exe.progStart();
			
			switch(menu) {
			// 1.�л� �߰�.
			case 1: 
				exe.addStudent(exe.autoNumbering());
				break;
			// 2.��ü ��� ��ȸ
			case 2:
				exe.showStudentList();
				break;
			// 3. �ܰ� ��ȸ
			case 3:
				exe.showStudent();
				break;
			// 4. �л� ���� ����
			case 4:
				exe.modifyStudent();
				break;
			// 5. �л� ���� ����
			case 5:
				exe.removeStudent();
				break;
			case 6:
				System.out.println("���α׷��� �����մϴ�");
				run = false;
				break;
			default:
				System.out.println("�ùٸ� ������ �Է��ϼ���");
			}	// end of switch
			
		}	// end of while
		System.out.println("end of program");
	}	// end of main()
}
