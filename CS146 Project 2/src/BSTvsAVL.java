
public class BSTvsAVL {
	public static void main(String[] args) {
		BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
		TreePrinter printer = new TreePrinter(bst);
		
		bst.printRoot();
		
//		for(int i = 1; i <= 3; i++) {
//			bst.insert(i);
//			bst.printRoot();
//		}

		bst.insert(2);
		bst.insert(3);
		bst.insert(1);
		
		
		//bst.remove(2);
		//bst.printRoot();
		
		bst.printContents();
		
		printer.print("Test");
	}
}
