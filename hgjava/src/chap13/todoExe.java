package chap13;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class todoExe {

	public static void main(String[] args) {
		
		// ����, ����(To Do), DueDate �߰�
		Map<Integer, Todo> todoList = new HashMap<>();
		Scanner scn = new Scanner(System.in);
		
		while(true) {
			System.out.print("��ȣ ���� >> ");
			String input = scn.nextLine();
			String[] inAry = input.split(" ");
			
			// �ɷ��� ����.
			if(inAry.length != 2 && inAry.length != 3) {
				System.out.println("�Է°��� Ȯ���ϼ���");
				continue;
			}
			
			String order = inAry[0];
			String title = inAry[1];
			
			Todo todo = null;
			if(inAry.length == 2) {
				todo = new Todo(title);
			}
			else if(inAry.length == 3){
				String dueDate = inAry[2];
				// Date <=> String : format
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				try {
					todo = new Todo(title, sdf.parse(dueDate));
				} catch (ParseException e) {
					e.printStackTrace();
				}
			} // end of if.
		
			todoList.put(Integer.parseInt(order), todo);
			
			if(todoList.size() == 3) {
				break;
			}
		}
		System.out.println("��ȣ ���� DueDate");
		System.out.println("==================");
		Set<Entry<Integer, Todo>> entry = todoList.entrySet();
		for(Entry<Integer, Todo> ent : entry) {
//			int key = ent.getKey();
//			String todo = ent.getValue().getTodo();
//			String date = ent.getValue().getDueDate();
			
			System.out.println(ent.getKey() + " " + ent.getValue());
		}	
		
		System.out.println("end of prog.");
	}
}

