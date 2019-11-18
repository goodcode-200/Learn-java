
public class Triangle extends Shape{
	private String _text;
	public Triangle(String text){
		_text = text;
	}
	public void draw(){
		System.out.println("Triangle:"+_text);
	}
}
