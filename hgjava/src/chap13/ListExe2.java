package chap13;

import java.util.ArrayList;
import java.util.List;

public class ListExe2 {

	public static void main(String[] args) {
		
		List<Member> members = new ArrayList<>();	// �ڿ� ���� ���� �Ⱦ��� �տ����� �˾Ƽ� �ν���
		members.add(new Member("M-001", "ȫ�浿", 1000));
		members.add(new Member("M-002", "��浿", 1500));
		members.add(new Member("M-003", "���μ�", 2000));
		System.out.println(members.size());
		
		String search = "�浿";
		int count = 0;
		for(int i = 0; i < members.size(); i++) {
			if(members.get(i).getMemberName().indexOf(search) != -1//
					&& members.get(i).getPoint() >= 1500) {
				count++;
				members.remove(i);
			}
			
		}
		System.out.printf("\"%s\"�� �̸��� ��ġ�ϰ� 1500 �̻��� ���: %d��\n", search, count);
		for(Member mem : members) {
			System.out.println(mem.getMemberName());
		}
	}
}
