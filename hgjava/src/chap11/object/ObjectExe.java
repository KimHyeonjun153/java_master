package chap11.object;

public class ObjectExe {
	
	public static void main(String[] args) {
	
	//equals()
	Object obj1 = new Object();
	Object obj2 = new Object();
	// Object�� equals(): ��ü�� �ּҰ��� ��.
	System.out.println(obj1.equals(obj2));	// false.
	 
	String str1 = new String("Hello");
	String str2 = new String("Hello");
	// String�� equals(): ��ü�� ������ ��
	System.out.println(str1.equals(str2));	// true.
	
	Member mem1 = new Member("ȫ�浿", 20);
	Member mem2 = new Member("ȫ�浿", 22);
	System.out.println(mem1.equals(mem2));	// false => �����ǽ� true/
	
	}
}
