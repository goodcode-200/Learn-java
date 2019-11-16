import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Main {
	public static void main(String[] args) {
		Student li_1 = new Student("ÕÅÃ÷");
		Student li_2 = new Student("Àî½ğºÚ");
		Student li_3 = new Student("Ã«Í¬");
		
		//Êı×é´æ´¢
		Student[] stus = new Student[3];
		stus[0] = li_1;
		stus[1] = li_2;
		stus[2] = li_3;
		for(int i=0; i<3; i++) {
			System.out.println(stus[i]);
		}
		System.out.println();
		
		//List´æ´¢
		List<Student> list = new ArrayList<Student>();
		li_1 = new Student("ºÚ½ğ");
		li_2 = new Student("ÕÔÁù");
		li_3 = new Student("Àî½üÍ¬");
		list.add(li_1);
		list.add(li_2);
		list.add(li_3);
		for(Student stu:list) {
			System.out.println(stu);
		}
		System.out.println();
		
		//set´æ´¢
		Set<Student> set = new TreeSet<Student>();
		li_1 = new Student("ÃçÈÊ");
		li_2 = new Student("²Ü²Ù");
		li_3 = new Student("¹ØÓğ");
		set.add(li_1);
		set.add(li_2);
		set.add(li_3);
		for(Student stu:set) {
			System.out.println(stu);
		}
		System.out.println();
		
		//map´æ´¢
		Map<String,Student> map = new HashMap<String,Student>();
		li_1 = new Student("Àî°×");
		li_2 = new Student("¶Å¸¦");
		li_3 = new Student("Íõ²ıÁä");
		map.put("1", li_1);
		map.put("2",li_2);
		map.put("3",li_3);
		for(String key : map.keySet()) {
			System.out.println(map.get(key));
		}
		System.out.println();
	}
}
