package remind06;

// ������� :  �迭
// �߰�/����/����/���/�ܰ� ��ȸ
public class StudentExe {
	// �ʵ�
	private Student[] students;	// �迭

	// ������
	StudentExe(){
		students = new Student[100];
		students[0] = new Student("23-001", "������", 88, 77);
		students[1] = new Student("23-002", "������", 89, 92);
		students[2] = new Student("23-003", "������", 100, 100);
	}
	
	// ��� �Լ� ����
	// �߰�
	boolean addStudent(Student std) {
		for(int i = 0; i < students.length; i++) {
			if(students[i] == null) {
				students[i] = std;
				return true;	// �޼ҵ� �ȿ��� return���� �޼ҵ��� ��
			}
		}
		return false;
	}
	
	// ���
	Student[] showStudentList() {
		return students;
	}
	
	// �ܰ� ��ȸ
	Student showStudent(String num) {
		for(int i = 0; i < students.length; i++) {
			if(students[i] != null && students[i].getStuNum().equals(num)) {
				return students[i];
			}
		}
		return null;
	}
	
	//����
	boolean modifyStudent(String num, int eng, int math) {
		for(int i = 0; i < students.length; i++) {
			if(students[i] != null && students[i].getStuNum().equals(num)) {
				students[i].setEngScore(eng);
				students[i].setMathScore(math);
				return true;
			}
		}
		return false;
	}
	
	//����
	boolean removeStudent(String num) {
		for(int i = 0; i < students.length; i++) {
			if(students[i] != null && students[i].getStuNum().equals(num)) {
				students[i] = null;
				return true;
			}
		}
		return false;
	}
	
}
