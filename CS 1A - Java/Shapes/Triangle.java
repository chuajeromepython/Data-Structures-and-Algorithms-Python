package javashapes;

class Triangle extends Shape{
	double base, height;
	Triangle(double b, double h){
		this.base = b;
		this.height = h;
	}
	Triangle(){
		this.base = 0;
		this.height = 0;
	}
	@Override
	double area(){
		super.area();
		System.out.print("Triangle" + "(base=" + this.base +", " + "height=" + this.height + "), Area: ");
		return 0.5 * this.base * this.height;
	}
}
