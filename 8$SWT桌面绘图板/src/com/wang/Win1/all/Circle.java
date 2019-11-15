package com.wang.Win1.all;
import org.eclipse.swt.graphics.GC;
import com.wang.Win1.depend.IShape;

public class Circle implements IShape {
	private int top;
	private int left;
	private int width;
	private int height;
	private GC gcMain;
	
	public Circle() {}
	public Circle(int top,int left,int width,int height,GC gc) {
		this.top = top;
		this.left = left;
		this.width = width;
		this.height = height;
		this.gcMain = gc;
	}
	@Override
	public void draw() {
		this.gcMain.drawOval(this.top, this.left, this.width, this.height);
	}
	@Override
	public void setTop(int x) {
		this.top = x;
	}
	@Override
	public void setWidth(int x) {
		this.width = x;
	}
	@Override
	public void setLeft(int x) {
		this.left = x;
	}
	@Override
	public void setHeight(int x) {
		this.height = x;
	}
	@Override
	public void setGcMain(GC gc) {
		this.gcMain = gc;
	}
	@Override
	public int getWidth() {
		return this.width;
	}
	@Override
	public void runInner() {
		// TODO Auto-generated method stub
	}
}
