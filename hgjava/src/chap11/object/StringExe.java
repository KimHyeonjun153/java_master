package chap11.object;

public class StringExe {

	public static void main(String[] args) {
		
		// Q. ���� �̸� ã��
		String[] fileNames = { "c:/images/prod/sample.jpg",//
				"d:/test/sample/americano.png",//
				"d:/goods/test/2023/moka.jpg" };

		for (String file : fileNames) {
			System.out.println(findFileName(file));
		}
		
		// Q. �ֹι�ȣ ���� ã��
		String[] numbers = {"980304-1234567",//
				"980304-2234567",//
				"020101-3456789",//
				"020104-4456789",//
				"0301053545678" };
		
		for (String no : numbers) {
			System.out.println(findGender(no));
		}
		
		// byte �迭 b1�� "Hello" ���ڿ��Ǿƽ�Ű �ڵ� �� �Է�.
		byte[] b1 = "Hello".getBytes();
		for (byte b : b1) {
			System.out.println(b);
		}
		
		// new String().
		String name = new String(new byte[] { 65, 66, 67, 68, 69 }); // byte �迭�� ���� => �ƽ�Ű �ڵ� ��.\
		System.out.println(name);
		
		name = new String(b1);
		System.out.println(name);
		
		// charAt() : �ش� �迭 ��ġ�� ���� ��(char).
		char c1 = name.charAt(0);
		System.err.println(c1);
		
		// ������ ��ȯ.
		
		
	} // end of main().
	
	// �ͺ� Ȯ�� �޼ҵ�.
	static String findGender(String ssn) {
	// �ֹι�ȣ ���ڸ� == 1, 2, 3, 4.
	
	// if��.
//		String gender = ssn.substring(6,8);
//		if(gender.equals("-1") || gender.equals("-3")) {
//			return "��";
//		}
//		else if(gender.equals("-2") || gender.equals("-4")) {
//			return "��";
//		}
//		else {
//			return null;
//		}
	
	// switch��.
//		String gender = ssn.substring(6,8);
//		switch(gender) {
//		case "-1":
//		case "-3":
//			return "��";
//		case "-2":
//		case "-4":
//			return "��";
//		default:
//			return null;
//		}
		
	// "-" ���� ���� �˻�.
		char bar = ssn.charAt(6);
		if(bar == '-') {
			char gender = ssn.charAt(7);
			switch(gender) {
			case '1':
			case '3':
				return "��";
			case '2':
			case '4':
				return "��";
			default:
				return null;
			}
		}
		else {
			char gender = ssn.charAt(6);
			switch(gender) {
			case '1':
			case '3':
				return "��";
			case '2':
			case '4':
				return "��";
			default:
				return null;
			}
		}
	}
		
	// ���ϸ��� ��������.
	// lastIndexOf().
	static String findFileName(String file) {
		int index = file.lastIndexOf("/") + 1;
		return file.substring(index);
	}
	
	// split().
//	static String findFileName(String file) {
//		String[] files = file.split("/");
//		return files[files.length -1];
//	}
	
	// ������ Ǯ��.
//	static String findFileName(String file) {
//		int pos = 0;
//		while(true) {
//			int pos2 = file.indexOf("/", pos);
//			if(pos2 == -1)
//				break;
//			pos2++;
//			pos = pos2;
//		}
//		return file.substring(pos);
//	}
	

} // end of class.

