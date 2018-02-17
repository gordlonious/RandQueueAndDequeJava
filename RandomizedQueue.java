/**
 *
 * @author Gordon Portzline
 */
import java.util.Iterator;
import java.util.NoSuchElementException;
import edu.princeton.cs.algs4.StdRandom;

public class RandomizedQueue<Item> implements Iterable<Item> {
    private Item[] q;
    private int n, first, last;
    public RandomizedQueue() {
//        Item[] a = (Item[]) Array.newInstance(q.getClass().getComponentType(), 0); // more type safe than option b ?
//        this.q = a;
         Item[] b = (Item[]) new Object[2]; // start with two elements so you don't have to resize before inserting the first element
         this.q = b;
         // System.out.printf("Constructor values: %d %d %d%n", n, first, last);
    }
    
    public boolean isEmpty() {
        return n == 0;
    }
    
    public int size() {
        return this.n;
    }
    
    // resize the underlying array
    private void resize(int capacity) {
        System.out.println("RESIZING...");
        assert capacity >= n;
        Item[] temp = (Item[]) new Object[capacity];
        for (int i = 0; i < n; i++) {
            System.out.printf("Q index is: %d%n", ((first + i) % q.length));
            temp[i] = q[(first + i) % q.length];
        }
        q = temp;
        first = 0;
        last  = n;
    }
    
    public void enqueue(Item item) {
        if (item == null) throw new NullPointerException("cannot add null to random queue");
        if (n == q.length) resize(2*q.length);   // double size of array if necessary
        q[last++] = item;                        // add item
        if (last == q.length) last = 0;          // wrap-around
        n++;
    }
    
    public Item sample() {
        return q[StdRandom.uniform(0, n)];
    }
    
    public Item dequeue() {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        Item item = q[first];
        q[first] = null;                            // to avoid loitering
        n--;
        first++;
        if (first == q.length) first = 0;           // wrap-around
        // shrink size of array if necessary
        if (n > 0 && n == q.length/4) resize(q.length/2); 
        return item;
    }
    
    @Override
    public Iterator<Item> iterator() {
        return new RandomQueueIterator();
    }
    
    private class RandomQueueIterator implements Iterator<Item> {
        private int i;
        private int[] ria;
        public RandomQueueIterator() {
            ria = new int[n];
            for (int i = 0; i < ria.length; i++) {
                ria[i] = i;
            }
            StdRandom.shuffle(ria);
        }
        
        public boolean hasNext() {
            return i < ria.length;
        }
        public Item next() {
            Item temp = q[ria[i]];
            i++;
            return temp;
        }
        public void remove() {
            throw new UnsupportedOperationException("Remove Operation Not Supported In RandomQueueIterator");
        }
    }


    public static void main(String[] args) {
        // test constructor
        RandomizedQueue<Integer> rq1 = new RandomizedQueue<>();
        System.out.printf("rq has type: %s%n", rq1.getClass().getName());
        
        // test resize/enqueue and sample
        rq1.enqueue(1);
        rq1.enqueue(2);
        rq1.enqueue(3);
        rq1.enqueue(4);
        rq1.enqueue(5);
        System.out.println(rq1.sample());
        
        // test dequeue/resize
        rq1.dequeue();
        rq1.dequeue();
        rq1.dequeue();
        rq1.dequeue();
        rq1.dequeue();
        
        // test iterator
        RandomizedQueue<Integer> rq2 = new RandomizedQueue<>();
        rq2.enqueue(3);
        rq2.enqueue(7);
        rq2.enqueue(11);
        rq2.enqueue(42);
        rq2.enqueue(12);
        System.out.printf("one loop test: ");
        for (int i : rq2) {
            System.out.printf(" %d ", i);
        }
        
        // test iterable/iterator with nested loop
        rq1.enqueue(22);
        rq1.enqueue(33);
        rq1.enqueue(56);
        rq1.enqueue(89);
        rq1.enqueue(17);
        System.out.printf("inner loop random items (5 lines):%n");
        for (int i : rq1) {
            for (int j : rq1) {
                System.out.printf(" %d ", j);
            }
            System.out.printf("%n %d %n", i);
        }
    }
}