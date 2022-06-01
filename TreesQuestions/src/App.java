
public class App {
	public static void main(String[] args) {
		Tree<Integer> bst1 = new BinarySrearchTrees<>();
		bst1.insert(2);
		bst1.insert(55);
		bst1.insert(67);
		bst1.insert(12);
		bst1.insert(11);
		
		Tree<Integer> bst2 = new BinarySrearchTrees<>();
		bst2.insert(2);
		bst2.insert(55);
		bst2.insert(67);
		bst2.insert(12);
		bst2.insert(11);
		
		TreeCompareHelper<Integer> helper = new TreeCompareHelper<>();
		System.out.println(helper.compareTrees(bst1.getRoot(), bst2.getRoot()));
		
		System.out.println(bst1.getKSmallest(bst1.getRoot(), 3));
		
		Tree<Person> bst = new BinarySrearchTrees();
		
		bst.insert(new Person("Adam",47));
		bst.insert(new Person("Kevin",21));
		bst.insert(new Person("Joe",55));
		bst.insert(new Person("Arnold",20));
		bst.insert(new Person("Noel",34));
		bst.insert(new Person("Marko",68));
		bst.insert(new Person("Susan",23));
		bst.insert(new Person("Rose",38));
		
		System.out.println(bst.getAgesSum());
		

	}
}
