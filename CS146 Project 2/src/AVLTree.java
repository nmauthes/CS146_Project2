/**
 * @author Nick Mauthes
 *
 * Generic AVL tree implementation that extends BinarySearchTree.
 *
 * @param <E>
 */
 
public class AVLTree<E extends Comparable<? super E>> extends BinarySearchTree<E> {

	protected boolean printRotations = true;
	
	/**
	 * Public insert method which calls the recursive private method on the root. Sets height when finished.
	 * 
	 * @param e Item to be inserted
	 */
	 
	public void insert(E e) {
		root = insert(e, root);
		height = (root != null) ? root.height : -1;
	}
	
	/**
	 * Private insert method. Attempts to insert duplicate data are ignored.
	 * Calls the parent insert method, the rebalances the tree if
	 * necessary.
	 * 
	 * @param e Item to insert.
	 * @param node Current node.
	 * @return
	 */
	
	protected BinaryNode<E> insert(E e, BinaryNode<E> node) {
		BinaryNode<E> test = super.insert(e, node);
		return balance(test);
	}
	
	/**
	 * Public remove method which calls the private version and adjusts height when finished.
	 * 
	 * @param e Item to remove.
	 */
	
	public void remove(E e) {
		root = remove(e, root);
		height = (root != null) ? root.height : -1;
	}
	
	/**
	 * Private remove method. Calls the parent remove method
	 * then rebalances the tree if necessary.
	 * 
	 * @param e Item to remove
	 * @param node
	 * @return
	 */
	
	protected BinaryNode<E> remove(E e, BinaryNode<E> node) {
		return balance(super.remove(e, node));
	}
	
	/**
	 * AVL balance method. Determines if the tree is balanced or
	 * unbalanced and adjusts accordingly. Adjusts height of nodes
	 * as necessary.
	 * 
	 * @param node
	 * @return
	 */
	 
	protected BinaryNode<E> balance(BinaryNode<E> node) {
		if(node == null)
			return node;
			
		if(nodeHeight(node.left) - nodeHeight(node.right) > 1) {
			if(nodeHeight(node.left.left) >= nodeHeight(node.left.right)) {
				if(printRotations)
					System.out.println("Single right rotation: " + node.data);
					
				node = singleRightRotation(node);
			}
			else {
				if(printRotations)
					System.out.println("Double left-right rotation: " + node.data);
					
				node = doubleLeftRightRotation(node);
			}
		}
		else if(nodeHeight(node.right) - nodeHeight(node.left) > 1) {
			if(nodeHeight(node.right.right) >= nodeHeight(node.right.left)) {
				if(printRotations)
					System.out.println("Single left rotation: " + node.data);
			
				node = singleLeftRotation(node);
			}
			else {
				if(printRotations)
					System.out.println("Double right-left rotation: " + node.data);
					
				node = doubleRightLeftRotation(node);
			}
		}
		
		node.height = getHeight(node);
		return node;
	}
	
	/**
	 * Performs a single right rotation on a tree or subtree.
	 * 
	 * @param k2 Point of rotation
	 * @return
	 */
	 
	protected BinaryNode<E> singleRightRotation(BinaryNode<E> k2) {
		BinaryNode<E> k1 = k2.left;
		
		k2.left = k1.right;
		k1.right = k2;
		k2.height = getHeight(k2);
		k1.height = getHeight(k1);
		
		return k1;
	}
	
	/**
	 * Performs a double left-right rotation on a tree or subtree.
	 * 
	 * @param k3 Point of rotation
	 * @return
	 */
	 
	protected BinaryNode<E> doubleLeftRightRotation(BinaryNode<E> k3) {
		k3.left = singleLeftRotation(k3.left);
		return singleRightRotation(k3);
	}
	
	/**
	 * Performs a double right-left rotation on a tree or subtree.
	 * 
	 * @param k1 Point of rotation
	 * @return
	 */
	 
	protected BinaryNode<E> doubleRightLeftRotation(BinaryNode<E> k1) {
		k1.right = singleRightRotation(k1.right);
		return singleLeftRotation(k1);
	}
	
	/**
	 * Performs a single left rotation on tree or subtree.
	 * 
	 * @param k1 Point of rotation
	 * @return
	 */
	 
	protected BinaryNode<E> singleLeftRotation(BinaryNode<E> k1) {
		BinaryNode<E> k2 = k1.right;
		
		k1.right = k2.left;
		k2.left = k1;
		k1.height = getHeight(k1);
		k2.height = getHeight(k2);
		
		return k2;
	}
	
	/**
	 * Returns the height of a node or -1 if null.
	 * For use with balance method.
	 * 
	 * @param node
	 * @return Height of node
	 */
	 
	protected int nodeHeight(BinaryNode<E> node) {
		if(node != null)
			return node.height;
		else
			return -1;
	}
}