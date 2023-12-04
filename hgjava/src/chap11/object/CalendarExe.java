package chap11.object;

import java.util.Calendar;

public class CalendarExe {

	public static void main(String[] args) {

		// Calenadar Ŭ������ ���� �޼ҵ� ȣ�� => �ν��Ͻ� ����( new �ƴ� )
		Calendar cal = Calendar.getInstance();
		
		// 1.YEAR 2.MONTH(0: 1�� ~ 11: 12��) 5:DATE
		cal.set(1,  2022);
//		cal.set(Calendar.YEAR, 2022);
		cal.set(2, 5);
//		cal.set(Calendar.MONTH, 5);
		cal.set(5, 20);
//		cal.set(Calendar.DATE, 20);
		cal.set(2023, 11, 25);
		
		// DAY_OF_WEEK: 1.�� 2.�� ~ 7.��
		System.out.println("��: " + cal.get(Calendar.YEAR));
		System.out.println("��: " + (cal.get(Calendar.MONTH ) + 1));
		System.out.println("��: " + cal.get(Calendar.DATE));
		System.out.println("����: " + cal.get(Calendar.DAY_OF_WEEK));
		System.out.println("���� ������ ��: " + cal.getActualMaximum(Calendar.DATE));
		
		
		
	}

}
