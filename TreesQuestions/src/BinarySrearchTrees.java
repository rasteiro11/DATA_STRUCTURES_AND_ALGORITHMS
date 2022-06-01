
public class BinarySrearchTrees<T extends Comparable<T>> implements Tree<T> {

	private Node<T> root;

	@Override
	public void insert(T data) {
		// this is when we insert the first node into the BST (parent is null)
		if (root == null) {
			root = new Node<>(data, null);
		} else {
			// there are already items in the BSD
			insert(data, root);
		}

	}

	private void insert(T data, Node<T> node) {

		// this is the case when the data is SMALLER than the value in the node
		// GO TO LEFT SUBTREE
		if (node.getData().compareTo(data) > 0) {
			// there is a valid (not NULL) left child so we go there
			if (node.getLeftChild() != null) {
				insert(data, node.getLeftChild());
				// the left child is null so we create a left child
			} else
				node.setLeftChild(new Node<>(data, node));
			// this is the case when the data is GREATER than the value in the node
			// GO TO THE RIGHT SUBTREE
		} else {
			// there is a valid (not NULL) right child so we go there
			if (node.getRightChild() != null) {
				insert(data, node.getRightChild());
				// the left child is a NULL so we create a left child
			} else
				node.setRightChild(new Node<>(data, node));
		}
	}

	@Override
	public void remove(T data) {
		if (root != null)
			remove(data, root);
	}

	private void remove(T data, Node<T> node) {
		if (node == null)
			return;

		// first we have to search for the item we want to remove
		if (data.compareTo(node.getData()) < 0) {
			remove(data, node.getLeftChild());
		} else if (data.compareTo(node.getData()) > 0) {
			remove(data, node.getRightChild());
		} else {
			// WE HAVE FOUND THE ITEM WE WANT TO REMOVE !!!

			// if the node is a leaf node (without left and right children)
			// THIS IS THE CASE 1
			if (node.getLeftChild() == null && node.getRightChild() == null) {
				// weather the node is a left child or a right child
				Node<T> parent = node.getParentNode();

				// the node is a left child
				if (parent != null && parent.getLeftChild() == node) {
					parent.setLeftChild(null);
					// the node is a right child
				} else if (parent != null && parent.getRightChild() == node) {
					parent.setRightChild(null);
				}
				// maybe the root node is the one we want to remove
				if (parent == null)
					root = null;
				// remove the node and make it eligible for GC
				node = null;
				// CASE 2 when we remove items with a single child
				// a single right child
			} else if (node.getLeftChild() == null && node.getRightChild() != null) {
				Node<T> parent = node.getParentNode();
				// the node is a left child
				if (parent != null && parent.getLeftChild() == node) {
					parent.setLeftChild(node.getRightChild());
					// the node is a right child
				} else if (parent != null && parent.getRightChild() == node) {
					parent.setRightChild(node.getRightChild());
				}
				// when we deal with the root node
				if (parent == null) {
					root = node.getRightChild();
				}

				// have to update the right child's parent
				node.getRightChild().setParentNode(parent);
				node = null;
				// ir is approximatley the same CASE 2 BUT we have to deal with left child
			} else if (node.getLeftChild() != null && node.getRightChild() == null) {
				Node<T> parent = node.getParentNode();
				// the node is a left child
				if (parent != null && parent.getLeftChild() == node) {
					parent.setLeftChild(node.getLeftChild());
					// the node is a right child
				} else if (parent != null && parent.getRightChild() == node) {
					parent.setRightChild(node.getLeftChild());
				}
				// when we deal with the root node
				if (parent == null) {
					root = node.getLeftChild();
				}

				// have to update the right child's parent
				node.getLeftChild().setParentNode(parent);
				node = null;
			}
			// remove 2 children
			else {
				// find the predecessor (max item in the left subtree)
				Node<T> predecessor = getPredecessor(node.getLeftChild());

				// swap just the values !!!
				T temp = predecessor.getData();
				predecessor.setData(node.getData());
				node.setData(temp);

				// we have to call the remove method recursively on the predecessor
				remove(data, predecessor);

			}

		}

	}

	private Node<T> getPredecessor(Node<T> node) {
		if (node.getRightChild() != null) {
			return getPredecessor(node.getRightChild());
		}
		return node;
	}

	@Override
	public void traversal() {
		// in-order traversal in O(N) linear running time
		if (root == null)
			return;
		traversal(root);
	}

	// O(N)
	private void traversal(Node<T> node) {
		if (node.getLeftChild() != null)
			traversal(node.getLeftChild());
		System.out.println(node + "");
		if (node.getRightChild() != null)
			traversal(node.getRightChild());
	}

	@Override
	public T getMin() {
		// the max item is the leftmost item in the tree
		if (root == null) {
			return null;
		}
		return getMin(root);
	}

	private T getMin(Node<T> node) {
		if (node.getLeftChild() != null) {
			return getMin(node.getLeftChild());
		}
		return node.getData();

	}

	@Override
	public T getMax() {
		// the max item is the rightmost item in the tree
		if (root == null) {
			return null;
		}
		return getMax(root);
	}

	private T getMax(Node<T> node) {
		if (node.getRightChild() != null) {
			return getMax(node.getRightChild());
		}
		return node.getData();

	}

	@Override
	public Node<T> getRoot() {
		return this.root;
	}

	@Override
	public Node<T> getKSmallest(Node<T> node, int k) {

		// number of nodes in the left subtree
		// +1 because we count the root node of the subtree as well
		int n = treeSize(node.getLeftChild()) + 1;

		// this is when we find the kth smallest item
		if (n == k) {
			return node;
		}

		// if the number of nodes in the left subtree ? k-th smallest item
		// it means the k-th smallest is in the left subtree
		if (n > k)
			return getKSmallest(node.getLeftChild(), k);

		// if the number of nodes in the left subtree smaller then the k-th
		// smallest item then we can discard the left subtree and consider the
		// right subtree
		// NOW WE ARE NOT LOOKING FOR THE K-TH BUT THE K-Nth SMALLEST ITEM
		if (n < k)
			return getKSmallest(node.getRightChild(), k - n);

		return null;
	}

	// calculate the size of a subtree with root node 'node'
	private int treeSize(Node<T> node) {

		// this is the base case
		if (node == null)
			return 0;

		// recursively sum up the size of the left subtree + size of right subtree
		// size of tree = size left subtree + size of right subtree + 1(because of root)
		return (treeSize(node.getLeftChild()) + treeSize(node.getRightChild()) + 1);

	}

	@Override
	public int getAgesSum() {
		return getAges(this.root);
	}

	private int getAges(Node<T> node) {
		System.out.println("considering node " + node);

		// we have to reinitialize the variables (sum is the parent's node value so the
		// sum of the subtrees so far)
		int sum = 0;
		int leftSum = 0;
		int rightSum = 0;

		// null nodes have sum value 0
		if (node == null) {
			return 0;
		}

		// we do a simple post-order traversal because here we have to calculate both
		// left and right value to
		// be able to calculate the parent's value (sum of childrens' ages)
		// check the left subtree recursively
		leftSum = getAges(node.getLeftChild());
		// check the right subtree recursively
		rightSum = getAges(node.getRightChild());

		// update the sum ... given node's value is the own value + left subtree sum +
		// right subtree sum
		System.out.println("Considering node " + node + " total ages so far is "
				+ (((Person) node.getData()).getAge() + leftSum + rightSum));
		sum = ((Person) node.getData()).getAge() + leftSum + rightSum;

		return sum;

	}

}
