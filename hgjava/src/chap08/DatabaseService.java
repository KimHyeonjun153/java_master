package chap08;

// �߻� Ŭ����ó�� �߻� �޼ҵ常 ���� / ������ ������.
// ex) DBȸ�� �� ����� => Oracle: insert(), update() / MySQL:  add(), modify().
public interface DatabaseService {
 
	// �ʵ�.
	public static final String name = "";	// ����� ��� ����.
	public String CONSTANT = "";	// ����̸� : �빮�� 
	
	// �޼ҵ�. => ��� �߻� �޼ҵ�
	// �Է�, ����, ����.
	public void add();
	public void modify();
	public void remove();
	
	
}
