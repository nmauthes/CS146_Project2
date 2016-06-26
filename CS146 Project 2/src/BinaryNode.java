
public class BinaryNode<E extends Comparable<? super E>> {
		
	protected E data;
	protected BinaryNode<E> left, right;
	protected int height;
	
	protected BinaryNode(E d, BinaryNode lft, BinaryNode rt) {
		data = d;
		left = lft;
		right = rt;
		height = 0;
	}
	
	public BinaryNode<E> getLeft() {
		return left;
	}
	
	public BinaryNode<E> getRight() {
		return right;
	}
	
	public E getData() {
		return data;
	}
}