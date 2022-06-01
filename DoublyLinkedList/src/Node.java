
public class Node<T extends Comparable<T>>  {
	private T data;
	private Node<T> previusNode;
	private Node<T> nextNode;

	
	public Node(T data) {
		super();
		this.data = data;
	}

	public Node<T> getPreviusNode() {
		return previusNode;
	}
	
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	
	public void setPreviusNode(Node<T> previusNode) {
		this.previusNode = previusNode;
	}
	public Node<T> getNextNode() {
		return nextNode;
	}
	public void setNextNode(Node<T> nextNode) {
		this.nextNode = nextNode;
	}
	
	@Override
	public String toString() {
		return "Node [data=" + data + ", previusNode=" + previusNode + ", nextNode=" + nextNode + "]";
	}
	
	
	
}
