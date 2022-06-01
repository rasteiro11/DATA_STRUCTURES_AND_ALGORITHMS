/**
 * App
 */
public class App {

    public static void main(String[] args) {
        int[] nums = { -5, 2, 0, 1, -3, 6, 6, 7 };
        ShellSort sort = new ShellSort(nums);
        sort.sort();
        sort.showArray();
    }
}
