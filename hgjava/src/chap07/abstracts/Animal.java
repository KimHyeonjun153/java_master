package chap07.abstracts;

//�߻� Ŭ����.
public abstract class Animal {

	private String name;
	
	public Animal() {
		
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getNeme() {
		return name;
	}
	
	// �߻� �޼ҵ�.
	public abstract void sound();
	
}
