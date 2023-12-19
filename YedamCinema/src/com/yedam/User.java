package com.yedam;

import lombok.Data;

@Data

public class User {

//	2. ȸ�� ���̺�
//	-ID(PK)
//	-��й�ȣ(NOT NULL)
//	-�̸�
//	-����ó
	
	// �ʵ�.
	private int num;
	private String userId;
	private String passwd;
	private String userName;
	private String userTel;
	private String joinDate;
	
	// ������.
	User() {}

	public User( String userId, String passwd, String userName, String userTel) {
		this.userId = userId;
		this.passwd = passwd;
		this.userName = userName;
		this.userTel = userTel;
	}
	
	public User(int num, String userId, String passwd, String userName, String userTel, String joinDate) {
		this.num = num;
		this.userId = userId;
		this.passwd = passwd;
		this.userName = userName;
		this.userTel = userTel;
		this.joinDate = joinDate;
	}
	
	public User(String userId, String passwd, String userName, String userTel, String joinDate) {
		this.userId = userId;
		this.passwd = passwd;
		this.userName = userName;
		this.userTel = userTel;
		this.joinDate = joinDate;
	}
	
	// �޼���.
	void showUserInfo() {
		System.out.printf("%5d %10s %5s %20s %20s\n", num, userId, userName, userTel, joinDate); 
	}

}
