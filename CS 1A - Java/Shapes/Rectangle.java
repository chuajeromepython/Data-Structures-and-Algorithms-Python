package javashapes;

class Rectangle extends Shape{
	double width, height;
	Rectangle(double w, double h){
		this.width = w;
		this.height = h;
	}
	Rectangle(){
		this.width = 0;
		this.height = 0;
	}
	@Override
	double area(){
		super.area();
		System.out.print("Rectangle" + "(width=" + this.width +", " + "height=" + this.height+ "), Area: ");
		return this.width * this.height;
	}

}
