
public class Person {
	private String name;
	private int age;
	public Person(String name,int age) {
		this.name = name;
		this.age = age;
	}
	public boolean compare(Person person) {
		if(this == person) { //�Լ����Լ����
			return true;
		}
		if(person == null) {
			return false;
		}
		if(this.name.equals(person.name) && this.age == person.age) {
			return  true;
		}
		return false;
	}
	public String getInfo() {
		return "����:" + this.name + ",����:" + this.age;
	}
}
