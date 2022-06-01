
public interface Tree<T extends Comparable<T>> {

	public int getAgesSum();
	public Node<T> getRoot();
	public Node<T> getKSmallest(Node<T> node, int k);
	
	public void insert(T data);

	public void remove(T data);

	// in-order traversal yields the natural ordering
	public void traversal();

	public T getMin();

	public T getMax();

}
