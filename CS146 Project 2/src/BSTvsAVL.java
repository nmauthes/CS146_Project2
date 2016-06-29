import java.util.Random;

public class BSTvsAVL {
	public static void main(String[] args) {
		//BinarySearchTree<Integer> avl = new BinarySearchTree<>();
		AVLTree<Integer> avl = new AVLTree<>();
		Random rand = new Random();
		
		//avl.printRoot();
		
//		for(int i = 1; i <= 3; i++) {
//			avl.insert(i);
//			avl.printRoot();
//		}

		while(avl.height != 5) {
			avl.insert(rand.nextInt(90) + 10);
		}
//		
//		System.out.println(avl.contains(50));
		
//		avl.insert(5);
//		avl.insert(4);
//		avl.insert(6);
//		avl.insert(7);
//		
//		avl.remove(5);
//		avl.remove(6);
//		avl.remove(7);
//		avl.remove(4);
		
		//System.out.println(avl.height());
		
		//avl.remove(2);
		//avl.printRoot();
		
		//avl.printContents();
		
		TreePrinter printer = new TreePrinter(avl);
		printer.print("Test");
	}
}
