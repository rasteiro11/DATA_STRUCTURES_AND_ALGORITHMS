/**
 * App
 */
public class App {

    public static void main(String[] args) {
        int[] nums = { 4, 3, 2, 1, 0 };
        SelectionSort sort = new SelectionSort(nums);
        sort.sort();
        sort.showArray();
    }
}
