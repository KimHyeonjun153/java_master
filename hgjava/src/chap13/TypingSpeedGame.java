package chap13;

import java.util.*;

public class TypingSpeedGame {

	public static void main(String[] args) {
		// ����� �Է°��� �÷����� ���� ���ؼ� ���� �ܾ� ������ �ϳ��� �÷��ǿ��� ����.
		// ���۽��� ~ ����������� �ɸ� �ð��� �� ������ ���.
		// => ex. "�Ϸ��ϴµ� 35�ʰ� �ɸ�"
		
		Scanner scn = new Scanner(System.in);
		String word = "Total coffee acreage in the country is probably about 600,000 hectares";
		String[] words = word.split(" ");
		List<String> list = new ArrayList<>();	// �迭�� List�� �ٲ�
		for (String str : words) {
			list.add(str);
		}
		
		System.out.print("< Ÿ�ڿ��� > \n�����Ϸ��� enter�� �Է��ϼ��� \n>> ");
		scn.nextLine();
		long startTime = System.currentTimeMillis();
		
		while(true) {
			for(int i = 0; i < list.size(); i++) {
				System.out.println(list.get(i));
				String input = scn.nextLine();
				if(list.get(i).equals(input)) 
					list.remove(i);
			}
			if(list.size() == 0) {
				break;
			}
		}
		
		long finishTime = System.currentTimeMillis();
		System.out.println("����!");
		
		long spendTime = (finishTime - startTime) / 1000;
		System.out.println("�ɸ� �ð� : " + spendTime + "��");
		scn.close();
	}
}
