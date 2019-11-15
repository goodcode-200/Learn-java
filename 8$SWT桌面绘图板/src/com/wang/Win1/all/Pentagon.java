package com.wang.Win1.all;

import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.widgets.Display;

import com.wang.Win1.depend.IShape;

public class Pentagon implements IShape { //正五边形
	private int left;
	private int top;
	private int width;
	private int height;
	private GC gcMain;
	final static Display display = Display.getDefault();
	
	private int bottom;
	private int[] points = new int[10];
	
	public Pentagon() {}
	public Pentagon(int left,int top,int weigth,int height,GC gc) {
		this.left = left;
		this.top = top;
		this.gcMain = gc;
		this.height = height;
		this.width = width;
	}
	public void runInner() {
		this.bottom = this.top + this.height;
		//第一个点
		points[0] = left;
		points[1] = top;
		//第二个点
		double arc1 = (18*Math.PI)/180;
		double arc = (36*Math.PI)/180;
		points[4] = left + (int)(Math.tan(arc1)*this.height) ;
		points[5] = this.bottom;
		//第三个点
		double fang = Math.pow((points[4] - this.left), 2) + Math.pow((points[5] - this.top), 2);
		double len = Math.sqrt(fang);
		points[8] = (int)(points[4] - Math.cos(arc)*len) ;
		points[9] = (int)(points[5] - Math.sin(arc)*len) ;
		//第五个点
		points[6] = this.left - (int)(Math.tan(arc1)*this.height) ;
		points[7] = this.bottom ;
		//第四个点
		points[2] = (int)(points[6] + Math.cos(arc)*len) ;
		points[3] = (int)(points[7] - Math.asin(arc)*len) ;
	}
	@Override
	public void draw() {     
		/**
		 * TODO:填充里面形状
		 */
		this.gcMain.fillPolygon(points);
	    this.gcMain.drawPolygon(points);       
	}
	@Override
	public void setTop(int x) {
		this.left = x;
	}
	@Override
	public void setWidth(int x) {
		this.width = x;
	}
	@Override
	public void setLeft(int x) {
		this.top = x;
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
		// TODO Auto-generated method stub
		return this.width;
	}
}
