package chap07;

public class CompFriend extends Friend{
	// �ʵ�.
	private String comp;
	private String dept;
	
	// ������.
	public CompFriend(String name, String phone, String comp, String dept){
		super(name, phone);	// �θ� Ŭ������ ������.
		this.comp = comp;
		this.dept = dept;
	}
	
	// �޼ҵ�.
	
	@Override
	public String showInfo() {
		return "�̸��� " + getName() + ", ����ó�� " + getPhone() + ", ȸ��� " + comp + ", �μ��� " + dept;
	}
	
	String getCompany() {
		return comp;
	}

	String getDept() {
		return dept;
	}
	
	void setCompany(String comp) {
		this.comp = comp;
	}
	
	void setDept(String dept) {
		this.dept = dept;
	}
}
