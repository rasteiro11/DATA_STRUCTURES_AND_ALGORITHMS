import java.util.ArrayList;
import java.util.List;

/**
 * Trie
 */
public class Trie {

    private Node root;

    public Trie() {
        // representing the empty string
        root = new Node("");
    }

    public List<String> sort() {
        return autoComplete("");
    }

    public List<String> autoComplete(String prefix) {

        Node trieNode = root;
        List<String> autoCompleteList = new ArrayList<>();

        // first weather have to consider the letters of the prefix
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            int asciiIndex = c - 'a';
            if (trieNode.getChild(asciiIndex) == null) {
                return autoCompleteList;
            }
            trieNode = trieNode.getChild(asciiIndex);
        }
        // this is the in-order traversal (DFS)
        collect(trieNode, prefix, autoCompleteList);
        return autoCompleteList;
    }

    private void collect(Node node, String prefix, List<String> list) {
        // base case
        if(node == null) return;
        // when we hit a leaf node 
        if(node.isLeaf()) 
            list.add(prefix);
        // all the children of the actual node (node=letter)
        for (Node childNode : node.getChildren()) {
           if(childNode == null) continue; 
           String childCharacter = childNode.getCharacter();
           // depth-first search
           collect(childNode, prefix+childCharacter, list);
        }

	}

	public void insert(String key, int value) {
        Node tempNode = root;

        // we have to consider all the letters in the key
        for (int i = 0; i < key.length(); i++) {
            // this is how we get the letter at the given index
            char c = key.charAt(i);
            // we have to deal with ASCII values
            // in our ASCII table the first letter is 'a'
            int asciiIndex = c - 'a';
            // while have to check weather the given letter is allready
            // a children of the given node
            if (tempNode.getChild(asciiIndex) == null) {
                Node node = new Node(String.valueOf(c));
                tempNode.setChildren(asciiIndex, node);
                tempNode = node;
            } else {
                // the node with the given letter is already a child
                tempNode = tempNode.getChild(asciiIndex);
            }
        }
        tempNode.setLeaf(true);
        tempNode.setValue(value);
    }

    public Integer search(String key) {
        Node tempNode = root;

        for (int i = 0; i < key.length(); i++) {
            // this is how we get the letter at the given index
            char c = key.charAt(i);
            // we have to deal with ASCII values
            // in our ASCII table the first letter is 'a'
            int asciiIndex = c - 'a';
            if (tempNode.getChild(asciiIndex) == null) {
                // search miss as the letter withth index (asciiIndex)
                // is not present in the trie
                return null;
            } else {
                // because the given node exists in the trie
                tempNode = tempNode.getChild(asciiIndex);
            }

        }
        // this is when the key is not present
        if (!tempNode.isLeaf())
            return null;

        // this is always a leaf node's value
        return tempNode.getValue();
    }
}
