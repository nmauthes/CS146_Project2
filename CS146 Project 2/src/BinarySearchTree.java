/**
 * @author Nick Mauthes
 * 
 * Generic binary search tree structure for storing data.
 *
 * @param <E>
 */

public class BinarySearchTree<E extends Comparable<? super E>> {
	
	protected BinaryNode<E> root;
	protected int height;
	 
	/**
	 * Default constructor to initialize the tree.
	 */
	 
	public BinarySearchTree() {
		root = null;
		height = -1;
	}
	
	/**
	 * Public insert method which calls the recursive private method on the root. Sets height when finished.
	 * 
	 * @param e Item to be inserted
	 */
	 
	public void insert(E e) {
		root = insert(e, root);
		height = getHeight(root);
	}
	
	/**
	 * Private recursive insert method. Attempts to insert duplicate data are ignored.
	 * 
	 * @param e Item to insert.
	 * @param node Current node.
	 * @return
	 */
	 
	protected BinaryNode<E> insert(E e, BinaryNode<E> node) {
		if(node == null)
			return new BinaryNode<E>(e, null, null);
		
		int comparison = e.compareTo(node.data);
		
		if(comparison < 0)
			node.left = insert(e, node.left);
		else if(comparison > 0)
			node.right = insert(e, node.right);
		else
			; // duplicate node
			
		return node;
	}
	
	/**
	 * Public contains method which calls the private version.
	 * 
	 * @param e Item to search for.
	 * @return Returns true if found, false otherwise.
	 */
	 
	public boolean contains(E e) {
		return contains(e, root);
	}
	
	/**
	 * Private recursive contains method.
	 * 
	 * @param e Item to search for.
	 * @param node
	 * @return Returns true if found, false otherwise.
	 */
	 
	protected boolean contains(E e, BinaryNode<E> node) {
		if(node == null)
			return false;
		
		int comparison = e.compareTo(node.data);
		
		if(comparison < 0)
			return contains(e, node.left);
		else if(comparison > 0)
			return contains(e, node.right);
		else
			return true;
	}
	
	/**
	 * Public remove method which calls the private version and adjusts height when finished.
	 * 
	 * @param e Item to remove.
	 */
	 
	public void remove(E e) {
		root = remove(e, root);
		height = getHeight(root);
	}
	
	/**
	 * Private recursive remove method.
	 * 
	 * @param e Item to remove
	 * @param node
	 * @return
	 */
	 
	protected BinaryNode<E> remove(E e, BinaryNode<E> node) {
		if(node == null)
			return node;
			
		int comparison = e.compareTo(node.data);
		
		if(comparison < 0)
			node.left = remove(e, node.left);
		else if(comparison > 0)
			node.right = remove(e, node.right);
		else if(node.left != null && node.right != null) {
			node.data = findMin(node.right).data;
			node.right = remove(node.data, node.right);
		}
		else
			node = (node.left != null) ? node.left : node.right;
			
		return node;
	}
	
	/**
	 * Helper method which finds the minimum node of the tree
	 * recursively.
	 * 
	 * @param node
	 * @return
	 */
	 
	protected BinaryNode<E> findMin(BinaryNode<E> node) {
		if(node == null)
			return node;
		else if(node.left == null)
			return node;
		return findMin(node.left);
	}
	
	/**
	 * Helper method which finds the maximum node in the tree
	 * recursively.
	 * 
	 * @param node
	 * @return
	 */
	 
	protected BinaryNode<E> findMax(BinaryNode<E> node) {
		if(node == null)
			return node;
		else if(node.right == null)
			return node;
		return findMax(node.right);
	}
	
	/**
	 * Helper method which finds the height of a tree or subtree
	 * recursively.
	 * 
	 * @param node
	 * @return Returns the height (int)
	 */
	 
	protected int getHeight(BinaryNode<E> node) {
		if(node == null)
			return -1;
		else
			return 1 + Math.max(getHeight(node.left), getHeight(node.right));
	}
	
	/**
	 * Returns the height member of the tree.
	 * 
	 * @return height
	 */
	 
	public int height() {
		return height;
	}
	
	/**
	 * Returns the root of the tree.
	 * 
	 * @return root
	 */
	 
	public BinaryNode<E> getRoot() {
		return root;
	}
	
	/**
	 * Method which prints all the data in the tree inorder.
	 * Used for testing purposes.
	 */
	 
	public void printContents() {
		printContents(root);
	}
	
	protected void printContents(BinaryNode<E> node) {
		if(node == null)
			return;
		
		printContents(node.left);
		System.out.println(node.data);
		printContents(node.right);
	}
		
}
