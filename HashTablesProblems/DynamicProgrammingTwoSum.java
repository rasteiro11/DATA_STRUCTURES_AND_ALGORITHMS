import java.util.HashMap;
import java.util.Map;

public class DynamicProgrammingTwoSum {

    private int[] nums;
    private int S;
    private Map<Integer, Integer> hashTable;

    public DynamicProgrammingTwoSum(int[] nums, int S) {
        this.hashTable = new HashMap<>();
        this.nums = nums;
        this.S = S;
    }

    // we can eliminate the second for loop with a hash table (running time memory
    // complexity tradeoff)
    public void solve() {
        // consider all the items once so it has O(N) running time complexity
        for (int i = 0; i < nums.length; ++i) {
            // check the remainder (actuial value - target value)
            int remainder = S - nums[i];
            // check if the remainder exists in the hashTable: it means we have found a pair
            if (hashTable.containsValue(remainder)) {
                System.out.println("Solution: " + nums[i] + "+" + remainder + "=" + S);
            }
            // add the current number to the hashTable
            hashTable.put(i, nums[i]);
        }
    }
}
