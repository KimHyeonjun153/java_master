package chap06;
// ȸ������ ��
// ȸ����ȣ, �̸�, ����ó, ����
// public <-> private

public class Member {
	// �Ӽ�(�ʵ�)
	private int memberNo;	// �� �ܾ� �̻��� ���� : CamelCase
	private String memberName;
	private String phone;
	private String gender;	// Men or Women
	
	// ������ : �ʵ��� �ʱⰪ�� ����
	// �⺻������ �����Ϸ��� ����
	Member() {
		
	}
	
	Member(int memberNo, String memberName){
		this.memberNo = memberNo;
		this.memberName = memberName;
	}
		
	public Member(int memberNo, String memberName, String phone, String gender) {
		this.memberNo = memberNo;
		this.memberName = memberName;
		this.phone = phone;
		this.gender = gender;
	}
	
	//��� (�޼ҵ�)
	void showInfo() {
		System.out.printf("�̸��� %s�̰� ����ó�� %s �Դϴ�.\n", memberName, phone);
	}
	
	String showAllInfo() {
		String result = "�̸��� " + memberName + "�̰� ��ȣ�� " + memberNo +//
				"�̰� ����ó�� " + phone + "�̰� ������ " + gender + "�Դϴ�.";
		return result;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public int getMemberNo() {
		return memberNo;
	}
	
	public String getMemberName() {
		return memberName;
	}

	public String getPhone() {
		return phone;
	}

	public String getGender() {
		return gender;
	}
	
}
