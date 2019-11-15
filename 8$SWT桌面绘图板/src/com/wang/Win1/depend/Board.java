package com.wang.Win1.depend;

import java.util.ArrayList;
import java.util.List;

public class Board {
	private List<IShape> shapes;
	
	public Board() {
		shapes = new ArrayList<IShape>();
	}
	
	public void insertShape(IShape shape) {
		shapes.add(shape);
	}
	
	public void refresh() {
		for(IShape shape:shapes) {
			shape.draw();
		}
	}
	public void del_last() {
		int size = shapes.size();
		if (size>=1) {
			shapes.remove(size-1);
		}
	}
	public int printLen() {
		return shapes.size();
	}
}