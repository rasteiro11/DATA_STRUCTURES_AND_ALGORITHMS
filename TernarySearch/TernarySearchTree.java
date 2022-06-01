/**
 * TernarySearchTree
 */
public class TernarySearchTree {

    // we have access to the root node
    private Node root;

    // we implement associative array
    public void put(String key, int value) {
        root = insert(root, key, value, 0);
    }
    
    // associative arrays - we get a value based on a key
    public Integer get(String key) {
        Node node = get(root, key, 0);
        // there may be a search miss
        if(node == null) return null;
        return node.getValue();
    } 

    private Node get(Node node, String key, int index) {
        // base case
        if(node == null) return null;
        // we consider the letters in the key one by one
        char c = key.charAt(index);
        if(c < node.getCharacter()) {
            return get(node.getLeftChild(), key, index);
        } else if(c > node.getCharacter()) {
            return get(node.getRightNode(), key, index);
        }else if(index < key.length() - 1) {
            return get(node.getMiddleNode(), key, index+ 1);
        } else {
            // we have considered all the letters 
            if(!node.isLeaf()) return null;
            // while have found the node 
            return node;
        }

	}

	private Node insert(Node node, String key, int value, int index) {

        // actual index of the key
        char c = key.charAt(index);

        // if the node is a null
        if (node == null) {
            node = new Node(c);
        }

        // check the location of the new node
        if (c < node.getCharacter()) {
            node.setLeftChild(insert(node.getLeftChild(), key, value, index));
        } else if (c > node.getCharacter()) {
            node.setRightNode(insert(node.getRightNode(), key, value, index));
        // this is not the last letter AND this is the middle child
        } else if(index < key.length()-1) {
            node.setMiddleNode(insert(node.getMiddleNode(), key, value, index+1));
        } else {
            // this node is the leaf node
            node.setLeaf(true);
            // we assign the values to the leaf nodes (last letters of the keys)  
            node.setValue(value);
        }
        return node;
    }

    public void traverse() {
        if(root != null) 
            traverse(root, "");
       
    }

	private void traverse(Node node, String s) {
        // left + root + right RECURSIVE MANER
        if(node.getMiddleNode() == null || node.getValue() != 0)
            System.out.println(s + node.getCharacter() + ": "+ node.getValue());
        // recursively to the left 
        if(node.getLeftChild() != null)
            traverse(node.getLeftChild(), s);
        // middle child
        if(node.getMiddleNode() != null)
            traverse(node.getMiddleNode(), s + node.getCharacter());
        // recursively to the right 
        if(node.getRightNode() != null)
            traverse(node.getRightNode(), s);
	}





}
