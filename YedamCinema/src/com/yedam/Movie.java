package com.yedam;

import java.util.ArrayList;

import lombok.Data;

@Data

public class Movie {

//	1. ��ȭ ���̺�
//	-��ȭ ��ȣ(PK)
//	-��ȭ �̸�(NOT NULL)
//	-������
//	-������
//	-�帣
//	-��������
//	-�󿵽ð�
//	-�ٰŸ�
//	-�⿬ �����
	
	// �ʵ�.
	private String movieNumber;
	private String movieName;
	private String director;
	private String releaseDate;
	private String genre;
	private int ageLimit;
	private int runningTime;
	private String plot;
	private String actors;
	
	// ������.
	Movie(){}

	public Movie(String movieNumber, String movieName, String director, String releaseDate, String genre, int ageLimit,
			int runningTime, String plot, String actors) {
		super();
		this.movieNumber = movieNumber;
		this.movieName = movieName;
		this.director = director;
		this.releaseDate = releaseDate;
		this.genre = genre;
		this.ageLimit = ageLimit;
		this.runningTime = runningTime;
		this.plot = plot;
		this.actors = actors;
	}
	
	// �޼���.
	
	void showMovieInfo() {
		System.out.printf("%7s | %-14s\t | %-10s\t | %-30s\t \n",
				movieNumber, movieName, director, actors);
	}
	
	void showMovieDetailInfo() {
		System.out.println("----------------------------------------------------------------------------------\n");
		System.out.println("��ȭ��ȣ	: " + movieNumber);
		System.out.println("��ȭ�̸�	: " + movieName);
		System.out.println("����		: " + director);
		System.out.println("�⿬���	: " + actors);
		System.out.println("������		: " + releaseDate);
		System.out.println("�帣		: " + genre);
		if(ageLimit == 0 )
			System.out.println("��������	: ��ü������");
		else
			System.out.println("��������	: " + ageLimit + "�� �̻� ������");
		System.out.println("�󿵽ð�	: " + runningTime + "��");
		System.out.println("�ٰŸ�		: " + plot);
		System.out.println("\n----------------------------------------------------------------------------------");
	}
}
