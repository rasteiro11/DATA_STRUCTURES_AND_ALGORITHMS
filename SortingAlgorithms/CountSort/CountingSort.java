/**
 * CountingSort
 */
public class CountingSort {

    public CountingSort(int[] data) {
        this.data = data;
    }

    private static final int ITEMS = 10;
    private int[] data;

    public void sort() {
        // we need additional memory
        int[] output = new int[data.length];
        int[] count = new int[ITEMS];

        // we have to consider the items in the data in O(N)
        for (int i = 0; i < data.length; ++i) {
            count[data[i]]++;
        }
        // transform the count array into a cumulative array
        for (int j = 1; j < count.length; ++j) {
            count[j] += count[j - 1];
        }

        // cumulative array to get the position of the items int the original (data)
        // we have to consider the items in a reverse order
        for (int k = data.length - 1; k >= 0; --k) {
            count[data[k]]--;
            output[count[data[k]]] = data[k];
        }
        // sorted order in the output array
        for (int l = 0; l < data.length; ++l) {
            data[l] = output[l];
        }

    }

    public void showArray() {
        for (int i : data) {
            System.out.println(" " + i);
        }
    }
}
