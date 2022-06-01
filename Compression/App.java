/**
 * App
 */
public class App {

    public static void main(String[] args) {

        String text = "My name is Joiii";

        int[] charFrequencies = new int[256];

        for (char c : text.toCharArray())
            ++charFrequencies[c];

        HuffmanCode code = new HuffmanCode();
        HuffmanTree huffmanTree = code.buildTree(charFrequencies);
        code.printCode(huffmanTree, new StringBuilder());

    }

}
