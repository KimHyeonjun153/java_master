package chap13;

import lombok.Data;

@Data

public class Member {
	
	private String memberNo;
	private String memberName;
	private int point;
	
	public Member(String memberNo, String memberName, int point) {
		this.memberNo = memberNo;
		this.memberName = memberName;
		this.point = point;
	}
	
	public String getMemberNo() {
		return memberNo;
	}

	public String getMemberName() {
		return memberName;
	}

	public int getPoint() {
		return point;
	}

	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public void setPoint(int point) {
		this.point = point;
	}
	
	// (MapExe2.java) 
	// hashCode, equals �������Կ� ����, ���� ������ ��ü�� Ű�� ������ ���� ��ü ��޵� �� ����
	// object Ŭ������ hashCode() : ������ ���ϼ� �Ǵ�
	// lombok�� �������� hashCode() : ���� ���ϼ� �Ǵ�
//	@Override
//	public int hashCode() {
//		return super.hashCode();
//	}
	
}