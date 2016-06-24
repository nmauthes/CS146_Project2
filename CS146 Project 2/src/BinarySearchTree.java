
public class BinarySearchTree<E extends Comparable<? super E>> {
	
	protected BinaryNode<E> root;
	protected int height;
	
	public BinarySearchTree() {
		root = null;
	}
	
	public void insert(E e) {
		root = insert(e, root);
	}
	
	protected BinaryNode<E> insert(E e, BinaryNode<E> node) {
		if(node == null) {
			return new BinaryNode<E>(e, null, null);
		}
		
		int comparison = e.compareTo(node.data);
		
		//System.out.println(comparison);
		
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
		
		//System.out.println(comparison);
		
		if(comparison < 0)
			return contains(e, node.left);
		else if(comparison > 0)
			return contains(e, node.right);
		else
			return true;
	}
	
	public boolean remove(E e) {
		return false;
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
		System.out.print(node.data);
		printContents(node.right);
	}
		
}
