package todo.p20231201;

import java.util.Calendar;

public class CalenderExe {
	public static void main(String[] args) {
		
		// 10�� �޷� �����.
		String[] days = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
		
		System.out.println("=========== 12 �� ===========");
		for(String day : days) {
			System.out.printf("%4s", day);
		}
		System.out.println();
		
		int j;
		for(j = 0; j < 5; j++) {
			System.out.printf("%4s", " ");
		}
		
		for(int i = 1; i <= 31; i++) {
			System.out.printf("%4d", i);
			if((i + j) % 7 == 0) {
				System.out.println();
			}
		}
		System.out.println("\n========== the end ==========\n");
		
		// ������ �ٲ�� �޷� �����.
		int year = 2023;
		int month = 12;
		
		Calendar today = Calendar.getInstance();
		
		today.set(Calendar.YEAR, year);
		today.set(Calendar.MONTH, month - 1);
		today.set(Calendar.DATE, 1);
		// 1���� ���� = ���� �����ϴ� ���� ���� => ���� ����.
		int firstDayOfWeek = today.get(Calendar.DAY_OF_WEEK);
		// ������ �� => for�� ���� ��¥ ���
		int lastDate = today.getActualMaximum(Calendar.DATE);

		// �� ���.
		System.out.printf("=========== %d �� ===========\n", month);
		// ���� ���.
		for(String day : days) {
			System.out.printf("%4s", day);
		}
		System.out.println();
		// ���� ��� => ù°�� ���� -1 ��ŭ
		for(int i = 1; i < firstDayOfWeek; i++) {
			System.out.printf("%4s", " ");
		}		
		// ��¥ ��� => ���� �������� ���� �ݺ�
		for(int i = 1; i <= lastDate; i++) {
			System.out.printf("%4d", i);
			// ����(ù°�� ���� -1) + i �� 7�� ����� ������ �� �ٲ�
			if((firstDayOfWeek - 1 + i) % 7 == 0)
				System.out.println();
		}
		System.out.println("\n========== the end ==========\n");
		
		
		
	}
}

