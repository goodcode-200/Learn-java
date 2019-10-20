
public class Person {
	private String name;
	private int age;
	public Person(String name,int age) {
		this.name = name;
		this.age = age;
	}
	public boolean compare(Person person) {
		if(this == person) { //自己和自己相比
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
		return "姓名:" + this.name + ",年龄:" + this.age;
	}
}
