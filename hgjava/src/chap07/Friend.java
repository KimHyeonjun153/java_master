package chap07;

// �θ�: �̸�, ����ó, showInfo(). 
public class Friend {
	// �ʵ�.
	private String name;
	private String phone;
	
	// ������.
	public Friend() {
		super();	// ��� Ŭ������ Object Ŭ������ ��� ���� (extends Object)
	}
	
	public Friend(String name, String phone){
		this.name = name;
		this.phone = phone;
	}

	// �޼ҵ�.
	
	@Override
	public String toString() {
		return "Friend [name=" + name + ", phone=" + phone + "]";
	}
	
	public String showInfo() {
		return "�̸��� " + name + ", ����ó�� " + phone + " �Դϴ�.";
		
	}

	public String getName() {
		return name;
	}

	public String getPhone() {
		return phone;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
}
