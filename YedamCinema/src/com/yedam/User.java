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
	private String userId;
	private String passwd;
	private String userName;
	private String userTel;
	
	// ������.
	User() {}

	public User(String userId, String passwd, String userName, String userTel) {
		this.userId = userId;
		this.passwd = passwd;
		this.userName = userName;
		this.userTel = userTel;
	}
	
	// �޼���.
	void showUserInfo() {
		System.out.println("User [userId=" + userId + 
				", userName= " + userName + ", userTel= " + userTel + "]"); 
	}

}
