/**
 * Node
 */
public class Node {

    private char character;
    private int value;
    private Node leftChild;
    private Node middleNode;
    private Node rightNode;
    private boolean leaf;

    public Node(char character) {
        this.character = character;
    }

    public char getCharacter() {
        return character;
    }

    public void setCharacter(char character) {
        this.character = character;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public Node getMiddleNode() {
        return middleNode;
    }

    public void setMiddleNode(Node middleNode) {
        this.middleNode = middleNode;
    }


    public Node getRightNode() {
		return rightNode;
	}

	public void setRightNode(Node rightNode) {
		this.rightNode = rightNode;
	}

	public boolean isLeaf() {
        return leaf;
    }

    public void setLeaf(boolean leaf) {
        this.leaf = leaf;
    }

}
