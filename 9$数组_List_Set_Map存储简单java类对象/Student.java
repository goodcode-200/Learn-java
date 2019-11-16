
public class Student implements java.lang.Comparable{
	private String name;
	private static int start_id = 1000;
	private int id;
	public Student(String name) {
		super();
		this.name = name;
		this.id = start_id++;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public static int getStart_id() {
		return start_id;
	}
	public static void setStart_id(int start_id) {
		Student.start_id = start_id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
    public int compareTo(Object o){      // 实现 Comparable 接口的抽象方法，定义排序规则
           Student p = (Student)o;
           return this.id - p.id;                      // 升序排列，反之降序
    }
	
	@Override
	public String toString() {
		return "Student [name=" + name + ", id=" + id + "]";
	}
	
}
