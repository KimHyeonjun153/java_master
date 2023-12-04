package chap13;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListExe {

	public static void main(String[] args) {
		
		// �迭.
		// �� �տ� ��� Ÿ�� ����.
		String[] strs = {"Mon", "Tue", "Wed"};
		// ��� �߰�.
		strs[0] = "Thr";
		// ��� ����: null �� ����(�� ���� ����).
		strs[0] = null;
		//����: .length
		for (int i = 0; i < strs.length; i++) {
			System.out.println(strs[i]);
			
		}
		
		
		// List �÷���: ���� �ȿ� ��� Ÿ�� ����, ũ�� ������ ����.
		List<String> list = new ArrayList<String>();
		// ��� �߰�.
		list.add("Apple");
		list.add("Banana");
		list.add("Cherry");
		// ��� ����: �ε��� or ��(�� ���� ���� �ڸ� �����).
		list.remove(0);	// "Apple" ����.
		list.remove("Banana"); // "banana" ����.
		// ��� ����
		list.set(0, "ü��");
		// ��ü ��� ����.
		list.clear();		
		// ����: .size() �޼ҵ�
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		// �÷����� ũ�� ����.
		for (int i = 0; i < 100; i++) {
			list.add("" + i);
		}
//		for (int i = 0; i < list.size(); i++) {
//			System.out.println(list.get(i));
//		}
		
		// �̸� ����
		List<String> names = new ArrayList<String>();
		names.add("ȫ�浿");	// 0: ù��°.
		names.add("��浿");	// 1: �ι�°.
		names.add("��ö��");	// 2: ����°.
		
		String search = "�浿";
		int count = 0;	
		for(String str : names) {
			if(str.indexOf(search) != -1) {
				count++;
			}
		}
		System.out.printf("%s �� \"%s\"�� ��ġ�ϴ� �̸�: %d��\n",names, search, count);
		
	}
}
