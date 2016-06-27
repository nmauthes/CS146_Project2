
public class BinaryNode<E extends Comparable<? super E>> {
		
	protected E data;
	protected BinaryNode<E> left, right;
	
	protected BinaryNode(E d, BinaryNode<E> lft, BinaryNode<E> rt) {
		data = d;
		left = lft;
		right = rt;
	}
	
	protected BinaryNode<E> getLeft() {
		return left;
	}
	
	protected BinaryNode<E> getRight() {
		return right;
	}
	
	protected E getData() {
		return data;
	}
}