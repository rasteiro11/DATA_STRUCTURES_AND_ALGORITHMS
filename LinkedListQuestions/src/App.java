
public class App {
	public static void main(String[] args) {
		LinkedList<Integer> numbers = new LinkedList<>();
		numbers.insert(1);
		numbers.insert(2);
		numbers.insert(3);
		numbers.insert(4);
		numbers.insert(5);
		numbers.insert(6);
		numbers.insert(7);
		
		numbers.traverse();
		
		Node<Integer> middleNode = numbers.getMiddleNode();
		System.out.println(middleNode);
		
		//System.out.println(numbers.getMiddleNode());
	}
}
