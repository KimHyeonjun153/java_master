package todo.p20231128;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Board {
	// �ʵ�
	private int num;
	private String title;
	private String writer;
	private String content;
	private String writeDate;
	
	// ������
	// 1. �⺻ ������
	public Board(){}

	// 2. ��¥ �ڵ� �Է� ������
	public Board(int num, String title, String writer, String content) {
		Date today = new Date();	//�ý��� �ð��� �������� ����
//		int year = today.getYear();
//		int month = today.getMonth() + 1;
//		int date = today.getDate();
		
		// Date <=> String ��ȯ Ŭ����
		// SimpleDateFormat (import �ʿ�)
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		this.num = num;
		this.title = title;
		this.writer = writer;
		this.content = content;
		this.writeDate = sdf.format(today);	// ��¥ ���Ŀ� �°� String���� ��ȯ
	}
	
	// 3. �ʵ尪 ���� �������� �޴� ������
	public Board(int num, String title, String writer, String content, String writeDate) {
		this.num = num;
		this.title = title;
		this.writer = writer;
		this.content = content;
		this.writeDate = writeDate;
	}
	
	// �޼ҵ�
	
	// 1. �Խù� ���
//	boolean addArticle(Board[] boards, Board board) {
//		boolean exist = false;
//		for(int i = 0; i < boards.length; i++) {
//			if(boards[i] == null) {
//				boards[i] = board;
//				exist = true;
//				break;
//			}
//		}
//		return exist;
//	}
//	
	// 2. ��� ��� �޼ҵ�
	void showInfo() {
		System.out.printf(" %d\t %s\t %s\t\t %s\n", num, title, writer, writeDate);
	}
	
	// 3. �� ���� ��� �޼ҵ�
	String showDetailInfo() {
//		System.out.println("---------------------------------------------");
//		System.out.printf("��ȣ: %d\t/ ����: %s\n�ۼ���: %s\n����: %s\n�Ͻ�: %s\n", 
//				num, title, writer, content, date);
		String result = "��ȣ : " + num + " / ���� : " + title;
		result += "\n�ۼ��� : " + writer;
		result += "\n���� : " + content;
		result += "\n�Ͻ� : " + writeDate;
		return result;
	}
			
	// getter / setter �޼ҵ�
	public int getNum() {
		return num;
	}

	public String getTitle() {
		return title;
	}

	public String getWriter() {
		return writer;
	}

	public String getContent() {
		return content;
	}

	public String getWriteDate() {
		return writeDate;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setWriteDate(String date) {
		this.writeDate = date;
	}
	
}


