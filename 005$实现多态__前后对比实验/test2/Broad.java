
import java.util.ArrayList;
import java.util.List;

public class Broad {
	private List<Shape> shapes;
	
	public Broad(){
		shapes = new ArrayList<Shape>();
	}
	
	public void addShape(Shape shape){
		shapes.add(shape);
	}
	public void refresh(){
		for(Shape shape : shapes){
			shape.draw();
		}
	}
} 