package christmastree;

class TreeComponents extends ChristmasTree{
	int n = 5;
	int prune = 0;
	TreeComponents(int layer, int pad, int trunkW, int trunkH, int standH){
		super(layer, pad, trunkW, trunkH, standH);
	}
	@Override
	void drawHead(){
		for (int out = 0; out < layer; out++){
			for (int i = 1; i <= n; i++){
				for (int j = prune; j < (n - i) + this.pad; j++){
					System.out.print(" ");
				}
				for (int k = 0; k < (2 * i - 1) + prune; k++){
					System.out.print("*");
				}
				System.out.println();
			}
			this.prune += 2;
			n += 1;
		}
	}
	@Override
	void drawBody(){
		for (int i = 0; i < this.trunkH; i++){
			for (int j = 1; j < ((prune * 2) - 2) + this.pad - 2; j++){
				System.out.print(" ");
			}
			for (int k = 0; k < this.trunkW; k++){
				System.out.print("*");
			}
			System.out.println();
		}
	}
	@Override
	void drawStand(){
		for (int i = 0; i < this.standH; i ++){
			for (int j = 0; j < n * 2 + 4; j++){
				System.out.print(" ");
			}
			for (int k = 0; k < (n * 2) - 1; k++){
				System.out.print("*");
			}
			System.out.println();
		}	
	}
}
public class ChristmasTreeMain {
	public static void main(String[] args) {
		TreeComponents tc = new TreeComponents(2, 20, 3, 2, 1);
		tc.drawHead();
		tc.drawBody();
		tc.drawStand();
	}

}