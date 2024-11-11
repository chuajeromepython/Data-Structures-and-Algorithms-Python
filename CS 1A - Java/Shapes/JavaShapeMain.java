package javashapes;

import java.util.ArrayList;

public class JavaShapeMain {
	public static void main(String[] args) {
		Circle c = new Circle(5);
		Rectangle r = new Rectangle(5,5);
		Triangle t = new Triangle(5,5);
		/*
		Shape[] shapes_array = {c,r,t};
		for (Shape shape: shapes_array){
			System.out.println(shape.area());
		}
		*/
		ArrayList<Shape> shapes = new ArrayList<Shape>();
		shapes.add(c);
		shapes.add(r);
		shapes.add(t);
		for (Shape shape: shapes){
			System.out.println(shape.area());
		}

	}
}
