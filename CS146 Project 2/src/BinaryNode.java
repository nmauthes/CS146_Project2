/**
 * @author Nick Mauthes
 * 
 * Generic node class for use with binary and AVL trees.
 *
 * @param <E>
 */
 
public class BinaryNode<E extends Comparable<? super E>> {
		
	protected E data;
	protected BinaryNode<E> left, right;
	protected int height;
	
	/**
	 * Parameterized contructor to initialize the node.
	 * 
	 * @param d
	 * @param lft
	 * @param rt
	 */
	 
	protected BinaryNode(E d, BinaryNode<E> lft, BinaryNode<E> rt) {
		data = d;
		left = lft;
		right = rt;
		height = 0;
	}
	
	/**
	 * Returns the node's left child
	 * 
	 * @return Left child
	 */
	 
	protected BinaryNode<E> getLeft() {
		return left;
	}
	
	/**
	 * Returns the node's right child.
	 * 
	 * @return Right child
	 */
	 
	protected BinaryNode<E> getRight() {
		return right;
	}
	
	/**
	 * Returns the node's data.
	 * 
	 * @return Data
	 */
	 
	protected E getData() {
		return data;
	}
}