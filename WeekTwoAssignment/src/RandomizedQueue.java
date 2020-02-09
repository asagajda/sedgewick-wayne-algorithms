import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> {
    class RandomizedQueueIterator<Item> implements Iterator {
        public RandomizedQueueIterator() {

        }

        @Override
        public Item next() {
            return null;
        }

        @Override
        public boolean hasNext() {
            return false;
        }
    }


    // construct an empty randomized queue
    public RandomizedQueue() {

    }

    // is the randomized queue empty?
    public boolean isEmpty() {
        return false;
    }

    // return the number of items on the randomized queue
    public int size() {
        return 0;
    }

    // add the item
    public void enqueue(Item item) {

    }

    // remove and return a random item
    public Item dequeue() {
        return null;
    }

    // return a random item (but do not remove it)
    public Item sample() {
        return null;
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator() {
       return new RandomizedQueueIterator<Item>();
    }

    // unit testing (required)
    public static void main(String[] args) {

    }
}
