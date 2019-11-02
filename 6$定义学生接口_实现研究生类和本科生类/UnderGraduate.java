
public class UnderGraduate implements Student {
	private int grade;

	public UnderGraduate(int grade) {
		this.grade = grade;
	}
	
	@Override
	public int get_grade() {
		return this.grade;
	}
	
	@Override
	public boolean is_graduate() {
		// TODO Auto-generated method stub
		return (this.grade > 26) ? true:false;
	}
}
