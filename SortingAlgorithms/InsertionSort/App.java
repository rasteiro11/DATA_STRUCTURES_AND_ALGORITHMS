/**
 * App
 */
public class App {
    public static void main(String[] args) {
        int[] nums = { 4, 3, 2, 1 };
        InsertionSort sort = new InsertionSort(nums);
        sort.sort();
        sort.showArray();
    }
}
