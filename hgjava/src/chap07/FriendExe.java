package chap07;

public class FriendExe {

	static Friend[] storage = new Friend[10];
	
	// 0. �ʱⰪ ����
	public static void initData(){
		storage[0] = new Friend("������", "010-1111-1111");
		storage[1] = new UnivFriend("������", "010-2222-2222", "����", "�ڹ�");
		storage[2] = new CompFriend("�ֽ¹�", "010-3333-3333", "�¿�", "����");
	}

	// 1. ���.
	public static boolean addFriend(Friend friend) {
		for (int i = 0; i < storage.length; i++) {
			if(storage[i] == null) {
				storage[i] = friend;
				return true;
			}
		}
		return false;
	}
	
	// 2. ���.
	public static Friend[] friendList() {
		for (Friend friend : storage) {
			if(friend != null) {
				System.out.println(friend.showInfo());
			}
		}
		return storage;
	}

	// 3. ��ȸ.
	// ����� null ���η� üũ �Ұ���. => null �ƴ� �� � �ִ��� üũ
	public static Friend[] searchName(String name) {
		// ��ȯ������ ����������.(�迭 �̹� ����Ǿ� ���� => null �ƴ�)
		Friend[] result = new Friend[10];
		int count = 0;
		for (int i = 0; i < storage.length; i++) {
			if(storage[i] != null && storage[i].getName().equals(name)) {
				result[count] = storage[i];
				count++;
			}
		}
		return result;
	}

	// ����� null ���η� üũ ����.
	public static Friend searchPhone(String phone) {
		for (int i = 0; i < storage.length; i++) {
			if(storage[i] != null && storage[i].getPhone().equals(phone)) {
				return storage[i];
			}
		}
		return null;
	}
	
}
