
public class Circle extends Shape{
	private String _text;
	public Circle(String text){
		_text = text;
	}
	public void draw(){
		System.out.println("Circle:"+_text);
	}
}