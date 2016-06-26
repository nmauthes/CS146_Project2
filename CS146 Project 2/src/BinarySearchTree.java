
public class BinarySearchTree<E extends Comparable<? super E>> {
	
	protected BinaryNode<E> root;
	protected int height;
	
	public BinarySearchTree() {
		root = null;
		height = -1;
	}
	
	public void insert(E e) {
		root = insert(e, root);
	}
	
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
	
	public boolean contains(E e) {
		return contains(e, root);
	}
	
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
	
	public void remove(E e) {
		root = remove(e, root);
	}
	
	protected BinaryNode<E> remove(E e, BinaryNode<E> node) {
		if(node == null)
			return null;
			
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
	
	protected BinaryNode<E> findMin(BinaryNode<E> node) {
		if(node == null)
			return null;
		else if(node.left == null)
			return node;
		return findMin(node.left);
	}
	
	protected BinaryNode<E> findMax(BinaryNode<E> node) {
		if(node == null)
			return node;
		else if(node.right == null)
			return node;
		return findMax(node.right);
	}
	
	public int height() {
		return height;
	}
	
	public BinaryNode<E> getRoot() {
		return root;
	}
	
	public void printContents() {
		printContents(root);
	}
	
	public void printRoot() {
		String printVal = (root != null) ? root.data.toString() : "null";
		System.out.println(printVal);
	}
	
	protected void printContents(BinaryNode<E> node) {
		if(node == null)
			return;
		
		printContents(node.left);
		System.out.println(node.data);
		printContents(node.right);
	}
		
}
