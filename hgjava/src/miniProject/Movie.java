package miniProject;

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
	private String[] actors;
	
	// ������.
	Movie(){}

	public Movie(String movieNumber, String movieName, String director, String releaseDate, String genre, int ageLimit,
			int runningTime, String plot, String[] actors) {
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
	
	
}
