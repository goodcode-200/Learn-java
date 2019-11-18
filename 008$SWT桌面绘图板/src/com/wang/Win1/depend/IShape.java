package com.wang.Win1.depend;

import org.eclipse.swt.graphics.GC;

public interface IShape {
	void draw();
	public void setTop(int x);
	public void setWidth(int x);
	public void setLeft(int x);
	public void setHeight(int x);
	public void setGcMain(GC gc);
	public int getWidth();
	public void runInner();
}