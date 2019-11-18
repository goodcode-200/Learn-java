
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Broad b = new Broad();
		
		Rect R1 = new Rect("R1");
		Rect R2 = new Rect("R2");
		Rect R3 = new Rect("R3");
		
		Circle C1 = new Circle("C1");
		Circle C2 = new Circle("C2");
		Circle C3 = new Circle("C3");
		
		Triangle T1 = new Triangle("T1");
		Triangle T2 = new Triangle("T2");
		Triangle T3 = new Triangle("T3");
		
		b.addShape(R1);
		b.addShape(R2);
		b.addShape(R3);
		
		b.addShape(C1);
		b.addShape(C2);
		b.addShape(C3);
		
		b.addShape(T1);
		b.addShape(T2);
		b.addShape(T3);
		
		b.refresh();
	}

}
