public class App {
    public static void main(String[] args) {
       // Heap heap = new Heap();
       // heap.insert(6);
       // System.out.println(heap.getMax());
       // heap.insert(1);
       // System.out.println(heap.getMax());
       // heap.insert(12);
       // System.out.println(heap.getMax());
       // heap.insert(-2);
       // System.out.println(heap.getMax());
       // heap.insert(3);
       // System.out.println(heap.getMax());
       // heap.insert(8);
       // System.out.println(heap.getMax());
       // heap.insert(-5);
       // System.out.println(heap.getMax());
       // 
       // heap.heapSort();
        
       // int[] nums = {13, 5, -2, 10, 0};
       // CheckHeap checkHeap = new CheckHeap();
       // System.out.println(checkHeap.isMinHeap(nums));
           
       int[] maxHeap = {210, 100, 23, 2, 5};

       HeapConverter heapConverter = new HeapConverter(maxHeap);

       int[] minHeap = heapConverter.transform();

       for (int i = 0; i < minHeap.length; i++) {
          System.out.println(minHeap[i]);
       }




    }
    
}
