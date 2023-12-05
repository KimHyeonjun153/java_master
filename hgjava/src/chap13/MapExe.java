package chap13;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapExe {

	public static void main(String[] args) {
		
		// Map.
		// Ű(key) : ��(value) ������ ���� => ��Ʈ��.
		Map<String, Integer> map = new HashMap<>();
		
		// �߰� : put(Ű, ��).
		map.put("ȫ�浿", 80);
		map.put("��浿", 85);
		map.put("������", 100);
		map.put("ȫ�浿", 90);
		
		// �� �������� : get(Ű)
		Integer result = map.get("ȫ�浿");
		System.out.println("ȫ�浿�� �� : " + result);
		
		// ��ü��� �������� : Set �÷��� ���
		Set<String> set = map.keySet();	// Set: �������� Ű �� ���� ����
		for(String key : set) {
			System.out.println("key : " + key + ", value : " + map.get(key));
		}
	}
}
