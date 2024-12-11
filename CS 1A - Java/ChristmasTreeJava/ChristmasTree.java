package christmastree;

abstract class ChristmasTree {
	int layer, pad, trunkW, trunkH, standH;
	ChristmasTree(int l, int p, int tw, int th, int s){
		this.layer = l;
		this.pad = p;
		this.trunkW = tw;
		this.trunkH = th;
		this.standH = s;
	}
	
	abstract void drawHead();
	
	abstract void drawBody();
	
	abstract void drawStand();
	
}
