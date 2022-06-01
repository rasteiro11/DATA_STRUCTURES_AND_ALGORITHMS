public class Node<T> {
	private T data;
	private Node<T> leftChild;
	private Node<T> rightChild;
	// because we have to notify the parent after removal or after rotations
	private Node<T> parentNode;
	// AVL trees rely heavily on the height parameter
	private int height;
	
	public Node(T data, Node<T> parentNode) {
		this.data = data;
		this.parentNode = parentNode;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Node<T> getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(Node<T> leftChild) {
		this.leftChild = leftChild;
	}

	public Node<T> getRigthChild() {
		return rightChild;
	}

	public void setRightChild(Node<T> rigthChild) {
		this.rightChild = rigthChild;
	}

	public Node<T> getParentNode() {
		return parentNode;
	}

	public void setParentNode(Node<T> parentNode) {
		this.parentNode = parentNode;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	@Override
	public String toString() {
		return "N" + data;
	}
	
	
	
	
	
	
	
	
	
	
}
