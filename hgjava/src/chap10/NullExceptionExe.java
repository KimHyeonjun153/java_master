package chap10;

public class NullExceptionExe {
	public static void main(String[] args) {
		
		//Null ���� ������ ��� [����]
		String name = "Hong";
		name = null;
		String menu = "2";
		int[] numAry = {2, 5, 7};

		try {
			name = "";
			System.out.println(name.toString());
			int num = Integer.parseInt(menu);
			System.out.println("�Է°��� " + num);
			System.out.println(numAry[3]);
			
		} catch (NullPointerException | NumberFormatException e) {
			System.out.println("null ���� �߻�");
			// e.printStackTrace();
//		} catch (NumberFormatException ne) {
//			System.out.println("���ڰ��� �Է��ϼ���");
		} catch (Exception ee) {
			System.out.println("�� �� ���� ����");
		}
		
		System.out.println("end of prog.");
	}
}
