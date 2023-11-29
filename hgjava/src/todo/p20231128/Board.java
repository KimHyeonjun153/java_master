package todo.p20231128;

public class Board {
	// �ʵ�
	private int num;
	private String title;
	private String writer;
	private String content;
	private String date;
	
	// ������
	public Board(){}

	public Board(int num, String title, String writer, String content, String date) {
		super();
		this.num = num;
		this.title = title;
		this.writer = writer;
		this.content = content;
		this.date = date;
	}
	
	// �޼ҵ�
	
	boolean addArticle(Board[] boards, Board board) {
		boolean exist = false;
		for(int i = 0; i < boards.length; i++) {
			if(boards[i] == null) {
				boards[i] = board;
				exist = true;
				break;
			}
		}
		return exist;
	}
	void showList() {
		System.out.printf("%d\t %s\t %s\n", num, title, writer);
	}
	
	void showContent(Board[] boards, int input) {
		boolean exist = false;
		for(int i = 0; i < boards.length; i++) {
			if(boards[i] != null && boards[i].getNum() == input) {
				System.out.println("---------------------------------------------");
				System.out.printf("��ȣ: %d\t/ ����: %s\n�ۼ���: %s\n����: %s\n�Ͻ�: %s\n", 
						boards[i].num, boards[i].title, boards[i].writer, boards[i].content, boards[i].date);
				exist = true;
			}
		}
		if(!exist) {
			System.out.println("ã�� �Խù� ��ȣ�� �����ϴ�.");
		}
	}

	// get / set
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

	public String getDate() {
		return date;
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

	public void setDate(String date) {
		this.date = date;
	}
	
}


