import java.util.ArrayList;
import java.util.List;

public class Broad {
	private List<Rect> rects;
	private List<Circle> circles;
	private List<Triangle> tris;
	
	public Broad(){
		rects = new ArrayList<Rect>();
		circles = new ArrayList<Circle>();
		tris = new ArrayList<Triangle>();
	}
	
	public void addRect(Rect rect){
		rects.add(rect);
	}
	public void addCircle(Circle circle){
		circles.add(circle);
	};
	public void addTrian(Triangle trian){
		tris.add(trian);
	}
	public void refresh(){
		for(Rect rect : rects){
			rect.draw();
		}
		for(Circle circle : circles){
			circle.draw();	
		}
		for(Triangle trian : tris){
			trian.draw();
		}
	}
} 
