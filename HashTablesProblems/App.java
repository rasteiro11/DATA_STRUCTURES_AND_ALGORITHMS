public class App {

    public static void main(String[] args) {
        int[] nums = { 3, 5, 2, -4, 8, 11 };
        int S = 7;

        DynamicProgrammingTwoSum naiveSolution = new DynamicProgrammingTwoSum(nums, S);
        naiveSolution.solve();
    }
}
