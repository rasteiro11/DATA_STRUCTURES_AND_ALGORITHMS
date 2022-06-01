
public class App {
	public static void main(String[] args) {
		/*
		 * MaxItemStack maxItemStack = new MaxItemStack(); maxItemStack.push(10);
		 * maxItemStack.push(5); maxItemStack.push(1); maxItemStack.push(12);
		 * maxItemStack.push(11);
		 * 
		 * System.out.println(maxItemStack.getMaxItem());
		 */

		StacksWithQueues queue = new StacksWithQueues();

		queue.enqueue(10);
		queue.enqueue(5);
		queue.enqueue(20);

		System.out.println(queue.dequeue());

		queue.enqueue(100);

		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());

	}
}
