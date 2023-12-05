package chap13;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapExe2 {

	public static void main(String[] args) {

		// HashMap ����
		Map<Member, String> map;
		map = new HashMap<>();
		
		// ��� �߰�.
		map.put(new Member("M001","ȫ�浿", 100), "��⵵ 100����");
		map.put(new Member("M002","��μ�", 90), "����� 200����");
		map.put(new Member("M003","������", 80), "�뱸�� 300����");
		map.put(new Member("M001","ȫ�浿", 100), "��⵵ 400����");
		// ȫ�浿 Ű �� ���ƺ����� ���� new�� ������ ������ �ν��Ͻ�(������).
		// hashCode(), equals() �������ϸ� ������ ��ü�� ��� ����(����)
		
		// ��� ����.
		map.remove(new Member("M001","ȫ�浿", 100));
		
		// ��� ��������.
		// 1.
		// key => Set �÷��ǿ� ����
		Set<Member> set = map.keySet();
		for(Member member : set) {
			System.out.println("key : " + member + ", value : " + map.get(member));
		}
		
		// 2. key, value => Set �÷��ǿ� ����
		Set<Entry <Member, String>> entry = map.entrySet();	// key + value �ѽ� => entry
		for(Entry<Member, String> ent: entry) {
			System.out.println("key : " + ent.getKey() + ", val : " + ent.getValue());
		}
		
	}
	
}
