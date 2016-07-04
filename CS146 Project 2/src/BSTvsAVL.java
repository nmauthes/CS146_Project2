public class BSTvsAVL {
	static int insertCount = 0, containCount = 0;

	public static int randomizer() {
		int random = (int) (Math.random() * 89 + 10);
		return random;
	}
	
	/**
	 * This method generates a Binary Search Tree with a height input and will continue
	 * to run until a tree with the desired height is generated. It 
	 * also prints the tree every time insert is called, even if nothing changes due
	 * to the tree not printing duplicate value nodes.
	 */
	public static void heightBST(BinarySearchTree<Integer> tree, int height) {
		while (tree.height < height ) {
			tree.insert(randomizer() );
			TreePrinter printTree = new TreePrinter(tree);
			printTree.print("Building BST: Height " + tree.height);
		}
		
	}
	
	/**
	 * This method generates an AVL Tree with the number of nodes to be determined by the
	 * input. Should any rotation have occurred due to the insertion causing an imbalance
	 * to the tree, the tree will rotate the root until it is balanced, and will indicate
	 * below the generated tree what type of rotation occurred. 
	 */
	public static void sizeAVLTree(AVLTree<Integer> tree, int nodes) { for (int i = 0; i < nodes; i++) {
			tree.insert(randomizer() );
			TreePrinter printTree = new TreePrinter(tree);
			printTree.print("AVL Tree " + (i + 1) );
		}
	}
	
	/**
	 * This method will continuously delete the root node in the BST until the tree
	 * is empty. The remove method will also determine what node will become the new
	 * root.
	 */
	public static void deleteAll( BinarySearchTree<Integer> bst) {
		while (bst.root != null) {
			bst.remove(bst.root.data);
			TreePrinter printTree = new TreePrinter(bst);
			printTree.print("BST Delete");
		}
	}
	
	/**
	 * This method works exactly the same as the deleteAll method for BinarySearchTree
	 * except this is for AVL Tree.
	 */
	public static void deleteAll( AVLTree<Integer> avl) {
		while (avl.root != null) {
			avl.remove(avl.root.data);
			if (avl.root == null)
				break;
			TreePrinter printTree = new TreePrinter(avl);
			printTree.print("AVL Tree Delete");
		}
	}
		
	/**
	 * This method will time how long it takes to insert a number of nodes to be determined
	 * by argument, and then displays a string that will tell the user how long it took
	 * to complete the insertions
	 */
	public static void timeBST (BinarySearchTree<Integer> tree, int nodes) {
		long startTime = System.nanoTime();
		for (int i = 0; i < nodes; i++) {
			tree.insert(randomizer() );
		}
		
		long endTime = System.nanoTime();
		double time =(endTime - startTime) / 1000000.0; 
		System.out.println("Time to fill BST with " + nodes + " element"
				+ " is "+ time + " milliseconds.");		
		
		return; 
	}
	
	/**
	 * This method does the same thing as the timeBST method except this is for AVL. printRotations
	 * needs to be set to false first so the rotations that occurs during insertion will not print
	 * since all we want to display is the string with the time. It is return back to true before
	 * we return.
	 */
	public static void timeAVL(AVLTree<Integer> tree, int nodes) {
		tree.printRotations = false;
		
		long startTime = System.nanoTime();
		for (int i = 0; i < nodes; i++) {
			tree.insert(randomizer() );
		}
		long endTime = System.nanoTime();
		double time =(endTime - startTime) / 1000000.0; 
		
		System.out.println("Time to fill AVL with " + nodes + " element"
				+ " is "+ time + " milliseconds.");		
		
		tree.printRotations = true;
		return;
		
	}
	
	/**
	 * This method well randomly perform an insert or contain method depending on what was
	 * randomly decided. Once this is occurred a set number of time, the number of inserts
	 * and contains performed will be printed, as well as total number of both actions performed.
	 * This is to show the user the ratio of insert to contains performed, then the speed will
	 * be printed in main so users can compare speed between BST and AVL random insert and contains
	 */
	public static double timeBSTInsert(BinarySearchTree<Integer> tree, int choice) {
		long startTime;
		if (choice == 0) {
			startTime = System.nanoTime();
			tree.insert(randomizer() );
		}
		else {
			startTime = System.nanoTime();
			tree.contains(randomizer() );
		}
		long endTime = System.nanoTime();
		return (endTime - startTime) / 1000000.0;
	}
	
	/**
	 * This method will randomly insert or contains similar to the timeBSTInsert method
	 * previously mentioned, but will not print the number of occurrences since it will
	 * be the same number of times and same ratio as the BST. The total speed will also
	 * be printed in main, like the timeAVLInsert method.
	 */
	public static double timeAVLInsert(AVLTree<Integer> tree, int choice) {
		long startTime;
		if (choice == 0) {
			startTime = System.nanoTime();
			tree.insert(randomizer() );
		}
		else {
			startTime = System.nanoTime();
			tree.contains(randomizer() );
		}
				
		long endTime = System.nanoTime();
		return (endTime - startTime) / 1000000.0;
	}
	
	public static void main(String[] args) {
		final int BSTHeight = 5;
		final int AVLNodes = 35;
		int k = 1000;
		long startTime, endTime;
		double totalTime;
		double BSTTime = 0, AVLTime = 0;
		BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
		AVLTree<Integer> avl = new AVLTree<Integer>();
		
		heightBST(bst, BSTHeight);
		deleteAll(bst);
		
		sizeAVLTree(avl, AVLNodes);
		deleteAll(avl);
		
		System.out.println();
		
		for (int i = 0; i < 4; i++) {
			timeBST(bst, k);
			timeAVL(avl, k);
			
			System.out.println();
			
			startTime = System.nanoTime();
			for (int x = 0; x < k; x++) {
				bst.contains(randomizer() );
			}
			endTime = System.nanoTime();
			totalTime = (endTime - startTime) / 1000000.0;
			System.out.println("Time to search " + k + " value in BST: " + totalTime + " milliseconds.");

			startTime = System.nanoTime();
			for (int x = 0; x < k; x++) {
				bst.contains(randomizer() );
			}
			endTime = System.nanoTime();
			totalTime = (endTime - startTime) / 1000000.0;
			System.out.println("Time to search " + k + " value in AVL: " + totalTime + " milliseconds.");
			System.out.println();
			
			k*=10;
		}
		
		k = 1000000;
		double ratio = 0.01;
		double inc = ratio;
		
		while(ratio < 1) {
			BinarySearchTree<Integer> bstTime = new BinarySearchTree<Integer>();
			AVLTree<Integer> avlTime = new AVLTree<Integer>();
			avlTime.printRotations = false;
			
			for (int i = 0; i < ratio * k; i++) {
				BSTTime += timeBSTInsert(bstTime, 0 );
				AVLTime += timeAVLInsert(avlTime, 0);
			}
			
			for (int i = 0; i < k - (ratio * k); i++) {
				BSTTime += timeBSTInsert(bstTime, 1 );
				AVLTime += timeAVLInsert(avlTime, 1);
			}
			
			System.out.println("Insert: " + (int)(ratio * k) + " Contains: " + (int)(k - (ratio * k)));
			System.out.println("Time to randomly insert or contain for BST: " + BSTTime);
			System.out.println("Time to randomly insert or contain for AVL: " + AVLTime);
			System.out.println();
			BSTTime = 0;
			AVLTime = 0;
			avlTime.printRotations = true;
			
			ratio += inc;
		}
		
	}
}