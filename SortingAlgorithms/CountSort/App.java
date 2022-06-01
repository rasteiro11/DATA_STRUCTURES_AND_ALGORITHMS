/**
 * App
 */
public class App {

    public static void main(String[] args) {
        int[] nums = { 5, 4, 3, 2, 1 };
        CountingSort sort = new CountingSort(nums);
        sort.sort();
        sort.showArray();
    }
}
