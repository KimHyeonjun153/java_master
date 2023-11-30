package todo.p20231128;

import java.text.SimpleDateFormat;
import java.util.Date;

// �����: boards
public class BoardExe {	// ���� ��� ó���ϴ� �뵵�� Ŭ����.
	// �ʵ�
	static Board[] boards;	// static ������ ����.
	
	// ������
	BoardExe(){
//		boards = new Board[100];	// ũ�� 100 �迭 �⺻ ���� => static ������ �ν��Ͻ� ���� �ʿ� ����
	}
	static {
		boards = new Board[100];	//	
	}
	
	// 0-1. �ʱⰪ � �̸� ����
	public static void initData() {
//		boards[0] = new Board(1, "�ڹٰԽ��� �Դϴ�", "user01", "������ ������ �ڹٰԽ����� �����ô�.", "2023-11-27");
//		boards[1] = new Board(2, "�����սô�\t", "user02", "�ڹٸ� �����սô�.", "2023-11-28");
//		//board[2] <= 5����
//		boards[3] = new Board(4, "SQL�� ���˴ϴ�", "user03", "���� ���˴ϴ� ", "2023-11-28");
		
		boards[0] = new Board(1, "ù ��° �Խù�  ", "user01", "ù��° �Խù� �Դϴ� ", "2023-11-27");
		boards[1] = new Board(2, "�� ��° �Խù�  ", "user01", "�ι�° �Խù� �Դϴ� ", "2023-11-27");
		boards[2] = new Board(3, "�� ��° �Խù�  ", "user01", "����° �Խù� �Դϴ� ", "2023-11-28");
		boards[3] = new Board(4, "�� ��° �Խù�  ", "user02", "�׹�° �Խù� �Դϴ� ", "2023-11-28");
		boards[4] = new Board(5, "�ټ� ��° �Խù�", "user02", "�ټ���° �Խù� �Դϴ� ", "2023-11-28");
		boards[5] = new Board(6, "���� ��° �Խù�", "user03", "������° �Խù� �Դϴ� ", "2023-11-28");
		boards[6] = new Board(7, "�ϰ� ��° �Խù�", "user03", "�ϰ���° �Խù� �Դϴ� ", "2023-11-29");
		boards[7] = new Board(8, "���� ��° �Խù�", "khj93", "������° �Խù� �Դϴ� ", "2023-11-29");
		
	}
	
	// 0-2. �ű� ��ȣ �ڵ� ���� : ���� �� ��ȣ +1
	public static int getSequence() {
		int seqNum = 1;
		int maxNum = 0;	// �ִ� ��ȣ �� ����
		
		for(int i = 0; i < boards.length; i++) {
			if(boards[i] != null && boards[i].getNum() > maxNum) {
				maxNum = boards[i].getNum();
			}
		}
		seqNum = maxNum + 1;
		return seqNum;
	}
	
	// 1. ��� �޼ҵ�
	public static boolean addArticle(Board board) {
		for(int i = 0; i < boards.length; i++) {
			if(boards[i] == null) {
				boards[i] = board;
				return true;	// �ݺ��� ���� (= break;) 
			}
		}
		return false;
	}
	
	// 2. ��� ��ȸ �޼ҵ� + ���� => Board[] �迭 ��ȯ
	public static Board[] showList() {
		// ���� : i�� ��Ҹ� i+1�� ��ҿ� �� => �ڸ� �ٲٱ�
		Board temp = null;
		for (int i = 0; i < boards.length - 1; i++) {
			for (int j = 0; j < boards.length - 1; j++) {
				if(boards[j] != null && boards[j+1] != null) {
					if(boards[j].getNum() > boards[j + 1].getNum()) {
					temp = boards[j];
					boards[j] = boards[j + 1]; 
					boards[j + 1] = temp;
					}
				}
			}
		}
		return boards;
	}
	
	// 2-1. �Խ��� ������ �迭 ����� => �� �κ� �� �� ���� �ʿ�!!
	public static Board[] pageList(Board[] ary, int page) {	// ���� Board[] �迭 ������.
		Board[] resultAry = new Board[5];
		// �� �������� �Խù� 5�� ��� �迭 ���� 
		// => ���� �迭 5���� �߶� �ٿ��ֱ�.
		// => 5���� ������.
		
		int start = (page -1) * 5;	// 0 ���� ����
		int end = page * 5;	// 6 ������ (5��)
		int j = 0;
		
		for (int i = 0; i < ary.length; i++) {
			if(i >= start && i < end) {
				resultAry[j++] = ary[i];
			}
		}
		return resultAry;
	}
	
	// 3. �ܰ���ȸ. �Ű����� : �۹�ȣ / ��ȯ�� : Board => Board Ŭ�������� ��¹�
	public static Board showContent(int num) {
		for(int i = 0; i < boards.length; i++) {
			if(boards[i] != null && boards[i].getNum() == num) {
				return boards[i];
			}
		}
		return null;
	}
	
	// 4. ���� �޼ҵ�
	public static boolean modifyContent(int num, String title, String content) {
		Date today = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		for(int i = 0; i < boards.length; i++) {
			if(boards[i] != null && boards[i].getNum() == num) {
				boards[i].setTitle(title);
				boards[i].setContent(content);
				boards[i].setWriteDate(sdf.format(today));;
				return true;
			}
		}
		return false;
	}
	
	// 5. ���� �޼ҵ�
	public static boolean removeContent(int num) {
		for(int i = 0; i < boards.length; i++) {
			if(boards[i] != null && boards[i].getNum() == num) {
				boards[i] = null;
				return true;
			}
		}
		return false;
	}
	
	// 6. ����ڰ� �ش� �� ��ȣ ����, ���� ���� üũ �޼ҵ� => boolean.
	public static boolean checkResponsibility(String id, int num) {
		for (int i = 0; i < boards.length; i++) {
			if(boards[i] != null//
					&& boards[i].getNum() == num//
					&& boards[i].getWriter().equals(id)) {
				return true;
			}
		}
		return false;
	}
	
	// 7. �Խñ��� ��� �ִ� �迭���� ���� �ִ� �Ǽ��� ��ȯ. = ������ �Ǽ�
	public static int getBoardCount() {
		int realCount = 0;
		for (int i = 0; i < boards.length; i++) {
			if(boards[i] != null) {
				realCount++;
			}
		}
		return realCount++;	// null�� �ƴ� ������ �Ǽ� ī��Ʈ
	}
	
}
