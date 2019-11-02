import java.util.ArrayList;

public class StudentGover {
	public static void main(String [] args) {
		ArrayList<Student> students = new ArrayList<Student>();
		
		UnderGraduate a = new UnderGraduate(24);
		UnderGraduate b = new UnderGraduate(55);
		UnderGraduate c = new UnderGraduate(16);
		UnderGraduate d = new UnderGraduate(31);
        students.add(a);
        students.add(b);
        students.add(c);
        students.add(d);
		
		PostGraduate e = new PostGraduate(21);
		PostGraduate f = new PostGraduate(11);
		PostGraduate g = new PostGraduate(41);
		PostGraduate h = new PostGraduate(10);
		students.add(e);
        students.add(f);
        students.add(g);
        students.add(h);
        
        for (Student stu : students) {
        	System.out.println( "成绩：" + String.valueOf(stu.get_grade()) +","+ ((stu.is_graduate())?"可以毕业":"学分不够") );
        }
		
		
	}
}
