
public class AVLTree<E extends Comparable<? super E>> extends BinarySearchTree<E> {

	private final boolean PRINT_ROTATIONS = false;
	
	public void insert(E e) {
		root = insert(e, root);
		height = (root != null) ? root.height : -1;
	}
	
	protected BinaryNode<E> insert(E e, BinaryNode<E> node) {
		BinaryNode<E> test = super.insert(e, node);
		return balance(test);
	}
	
	public void remove(E e) {
		root = remove(e, root);
		height = (root != null) ? root.height : -1;
	}
	
	protected BinaryNode<E> remove(E e, BinaryNode<E> node) {
		return balance(super.remove(e, node));
	}
	
	protected BinaryNode<E> balance(BinaryNode<E> node) {
		if(node == null)
			return node;
			
		if(nodeHeight(node.left) - nodeHeight(node.right) > 1) {
			if(nodeHeight(node.left.left) >= nodeHeight(node.left.right)) {
				if(PRINT_ROTATIONS)
					System.out.println("Single right rotation: " + node.data);
					
				node = singleRightRotation(node);
			}
			else {
				if(PRINT_ROTATIONS)
					System.out.println("Double left-right rotation: " + node.data);
					
				node = doubleLeftRightRotation(node);
			}
		}
		else if(nodeHeight(node.right) - nodeHeight(node.left) > 1) {
			if(nodeHeight(node.right.right) >= nodeHeight(node.right.left)) {
				if(PRINT_ROTATIONS)
					System.out.println("Single left rotation: " + node.data);
			
				node = singleLeftRotation(node);
			}
			else {
				if(PRINT_ROTATIONS)
					System.out.println("Double right-left rotation: " + node.data);
					
				node = doubleRightLeftRotation(node);
			}
		}
		
		node.height = getHeight(node);
		return node;
	}
	
	protected BinaryNode<E> singleRightRotation(BinaryNode<E> k2) {
		BinaryNode<E> k1 = k2.left;
		
		k2.left = k1.right;
		k1.right = k2;
		k2.height = getHeight(k2);
		k1.height = getHeight(k1);
		
		return k1;
	}
	
	protected BinaryNode<E> doubleLeftRightRotation(BinaryNode<E> k3) {
		k3.left = singleLeftRotation(k3.left);
		return singleRightRotation(k3);
	}
	
	protected BinaryNode<E> doubleRightLeftRotation(BinaryNode<E> k1) {
		k1.right = singleRightRotation(k1.right);
		return singleLeftRotation(k1);
	}
	
	protected BinaryNode<E> singleLeftRotation(BinaryNode<E> k1) {
		BinaryNode<E> k2 = k1.right;
		
		k1.right = k2.left;
		k2.left = k1;
		k1.height = getHeight(k1);
		k2.height = getHeight(k2);
		
		return k2;
	}
	
	protected int nodeHeight(BinaryNode<E> node) {
		if(node != null)
			return node.height;
		else
			return -1;
	}
}