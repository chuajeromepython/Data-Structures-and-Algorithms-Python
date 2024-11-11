package javashapes;

class Circle extends Shape{
	double radius;
	Circle(double r){
		this.radius = r;
	}
	Circle(){
		this.radius = 0;
	}
	@Override
	double area(){
		super.area();
		System.out.print("Circle" + "(radius=" + this.radius + "), Area: ");
		return Math.PI * (this.radius * this.radius);
		
	}
}
