/**
 * FenwickTree
 */
public class FenwickTree {

    private int[] fenwickTree;

    public FenwickTree(int[] nums) {
        // the constructed FenwickTree (first item is 0 always so the size is greater)
        // initialize the values to be 0s
        this.fenwickTree = new int[nums.length + 1];
        construct(nums);
    }

    // the sum of numbers in the interval [start:end]
    // O(logN) running time complexity
    public int rangeSum(int startIndex, int endIndex) {
        return sum(endIndex) - sum(startIndex - 1);
    }

    // sum of the integers in the range [0:index]
    public int sum(int index) {
        // indexes startart with 0 but in the theory/implemntation we start with 1
        index++;
        // the final result (so the sum of the integers)
        int sum = 0;

        // we may consider the sum of multiple ranges so we have to iterate until
        // index>0
        while (index > 0) {
            // binary index tree contains the sums of given ranges
            sum = sum + this.fenwickTree[index];
            // go to the parent and keep going (basically the items on the left)
            index = parent(index);
        }
        return sum;
    }

    // index of the items on the right (so the parent)
    // O(1) running time complexity
    private int parent(int index) {
        return index - (index & -index);
    }

    // construct the Fenwick tree from the original array of integers
    // O(NlogN) running time complexity
    private void construct(int[] nums) {
        // consider all the items in the original array
        for (int index = 1; index <= nums.length; ++index)
            update(index, nums[index - 1]);
    }

    // update an existing item in the tree with index and value accordingly
    // O(logN) running time complexity
    private void update(int index, int num) {
        // have to check all the ranges that include the index
        while (index < this.fenwickTree.length) {
            this.fenwickTree[index] += num;
            // index of the items on the right
            index = next(index);
        }
    }

    // index of the item on the left
    // O(1) running time complexity
    private int next(int index) {
        return index + (index & -index);
    }

}
