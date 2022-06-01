/**
 * App
 */
public class App {

    public static void main(String[] args) {
        int[] nums = { 4, 3, 2, 1 };
        MergeSort sort = new MergeSort(nums);
        sort.sort();
        sort.showArray();
    }
}
