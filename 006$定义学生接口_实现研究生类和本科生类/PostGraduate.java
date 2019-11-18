
public class PostGraduate implements Student{
	private int grade;
	
	public PostGraduate(int grade) {
		this.grade = grade;
	}
	
	@Override
	public int get_grade() {
		// TODO Auto-generated method stub
		return this.grade;
	}
	
	@Override
	public boolean is_graduate() {
		// TODO Auto-generated method stub
		return (this.grade > 15) ? true:false;
	}


}
