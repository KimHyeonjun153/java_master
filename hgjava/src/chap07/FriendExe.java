package chap07;

public class FriendExe {

	static Friend[] storage = new Friend[10];

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
		if(count != 0) {
			return result;
		}
		else{
			return null;
		}
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
