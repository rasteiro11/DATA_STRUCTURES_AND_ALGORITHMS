/**
 * App
 */
public class App {

    public static void main(String[] args) {
        
        Trie trie = new Trie();

        trie.insert("air", 5);
        trie.insert("apple", 10);
        trie.insert("approve", 6);
        trie.insert("bee", 4);

 //       for (String s : trie.autoComplete("a")) {
 //          System.out.println(s); 
 //       }
 

        for (String s : trie.sort()) {
           System.out.println(s); 
        }
    }
}
