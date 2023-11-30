package chap07;

// �ڽ�: UnivFriend / �θ�: Friend
public class UnivFriend extends Friend{	// extends: ��Ӱ���
	// �ʵ�.
	private String univ;	// �б�.
	private String major;	// ����.
	
	// ������.
	public UnivFriend() {}
	
	public UnivFriend(String name, String phone, String univ, String major) {
		super(name, phone);	// �θ� Ŭ������ ������ ȣ��.
		this.univ = univ;
		this.major = major;		
	}
	
	// �޼ҵ�.
	@Override
	public String showInfo() {
		return "�̸��� " + getName() + ", ����ó�� " + getPhone() + ", �б��� " + univ + ", ������ " + major;
	}

	public String getUniv() {
		return univ;
	}

	public String getMajor() {
		return major;
	}

	public void setUniv(String univ) {
		this.univ = univ;
	}

	public void setMajor(String major) {
		this.major = major;
	}
	
	
	
}
