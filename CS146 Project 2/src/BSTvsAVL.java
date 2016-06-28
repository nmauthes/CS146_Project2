import java.util.Random;

public class BSTvsAVL {
	public static void main(String[] args) {
		BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
		Random rand = new Random();
		
		//bst.printRoot();
		
//		for(int i = 1; i <= 3; i++) {
//			bst.insert(i);
//			bst.printRoot();
//		}

		while(bst.height != 5) {
			bst.insert(rand.nextInt(90) + 10);
		}
		
		System.out.println(bst.contains(50));
		
		
		//bst.remove(2);
		//bst.printRoot();
		
		//bst.printContents();
		
		TreePrinter printer = new TreePrinter(bst);
		printer.print("Test");
	}
}
