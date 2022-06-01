
public class App {
	public static void main(String[] args) {
		BinarySrearchTrees<Integer> bst = new BinarySrearchTrees<>();
		bst.insert(10);
		bst.insert(5);
		bst.insert(15);
		bst.insert(14);
		bst.insert(16);
		bst.insert(-1);
		
		System.out.println(bst.getMin());
		
	
	}
}
