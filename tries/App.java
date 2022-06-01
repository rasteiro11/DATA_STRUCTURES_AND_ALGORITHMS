/**
 * App
 */
public class App {

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("air");
        trie.insert("apple");
        trie.insert("approve");
        trie.insert("bee");
        System.out.println(trie.search("a"));
    }
}
