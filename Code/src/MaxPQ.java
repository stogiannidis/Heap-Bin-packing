public class MaxPQ <T extends Comparable<T>>{
    private T[] pq;                    // store items at indices 1 to n
    private int n;                       // number of items on priority queue
    @SuppressWarnings("unchecked")
    public MaxPQ(int initCapacity) {
        pq = (T[]) new Comparable[initCapacity + 1];
        n = 0;
    }
    //Initializes an empty priority queue.
    public MaxPQ() {
        this(1);
    }
    //Checks if the heap is empty
    public boolean isEmpty() {
        return n == 0;
    }

    public void insert(T x) {

        // double size of array if necessary
        if (n == pq.length - 1) resize(2 * pq.length);

        // add x, and percolate it up to maintain heap invariant
        pq[++n] = x;
        swim(n);
    }
    public T getMax() {
        if (isEmpty()) {
            System.out.println("The priority queue is empty!! Can not remove.");
            return null;
        }
        T max = pq[1];
        exch(1, n--);
        sink(1);
        pq[n + 1] = null;     // to avoid loitering and help with garbage collection
        if ((n > 0) && (n == (pq.length - 1) / 4)) resize(pq.length / 2);
        return max;
    }
    public void print() {
        StringBuilder sb = new StringBuilder();
        //sb.append(" ");
        for (int i=1; i<pq.length; i++) {
            if (pq[i] == null)
                break;
            sb.append(pq[i].toString());
        }
        sb.append('\n');
        System.out.println(sb.toString());
    }

    /***************************************************************************
     * Helper functions to restore the heap invariant.
     ***************************************************************************/

    private void swim(int k) {
        while (k > 1 && less(k / 2, k)) {
            exch(k, k / 2);
            k = k / 2;
        }
    }

    private void sink(int k) {
        while (2 * k <= n) {
            int j = 2 * k;
            if (j < n && less(j, j + 1)) j++;
            if (!less(k, j)) break;
            exch(k, j);
            k = j;
        }
    }

    /***************************************************************************
     * Helper functions for compares and swaps and resize the heap.
     ***************************************************************************/
    private boolean less(int i, int j){
        return pq[i].compareTo(pq[j]) < 0;
    }

    private void exch(int i, int j) {
        T swap = pq[i];
        pq[i] = pq[j];
        pq[j] = swap;
    }
    // helper function to double the size of the heap array
    @SuppressWarnings("unchecked")
    private void resize(int capacity) {
        assert capacity > n;
        T[] temp = (T[]) new Comparable[capacity];
        if (n >= 0) System.arraycopy(pq, 1, temp, 1, n);
        pq = temp;
    }

}