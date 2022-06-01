/**
 * App
 */
public class App {
    public static void main(String[] args) {
        int[] nums = { 3, 2, 1 };
        QuickSort sort = new QuickSort(nums);
        sort.sort();
        sort.showArray();
    }
}
