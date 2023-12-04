package chap11.object;

public class MathExe {

	public static void main(String[] args) {

		double a = -1.5;
		
		long result = Math.round(a);
		System.out.println("round: " + result);
		
		double result2 = Math.rint(a);	
		System.out.println("rint: " + result2);
		
		for (int i = 1; i <= 10; i++) {
			int r = (int)(Math.random() * (100 - 61 + 1) + 61 );
			System.out.println(r);
		}
		
		// Q. 1 ~ 6 ���� ���� �߻� => �ߺ����� �ʰ� �迭�� ����.
		int[] numbers = new int[5];
		for(int i = 0; i < 5; i++)  {
			boolean check = true;
			
			// 1~6 ���� �߻�
			int dice = (int)(Math.random() * 6 + 1);
			
			// �迭 �� �������� ��ġ�ϴ� �� üũ.
			for(int j = 0; j < 5; j++) {
				if(dice == numbers[j]) {
					check = false;
				}
			}
			
			// �ߺ� �� ���� �� �迭�� ����.
			if(check == true)
				numbers[i] = dice;
			// �ߺ� �� ������ => �ٽ� �ѹ� �� ���� ����.
			else {
				i--;
				continue;	// 
			}
				
			System.out.println(numbers[i]);
		}
		
	}

}
