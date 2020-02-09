import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
    Node first;
    Node last;
    int size;

    class Node {
        Item value;
        Node next;
        Node prev;

        Node(Item item) {
           this.value = item;
           this.next = null;
           this.prev = null;
        }
    }

    class DequeIterator<Item> implements Iterator {
        DequeIterator(Deque<Item> deque) {
            this.current = deque.first;
        }

        Deque<Item>.Node current;

        @Override
        public boolean hasNext() {
            return !(this.current == null);
        }

        @Override
        public Item next() {
            if (this.current == null) {
                throw new NoSuchElementException();
            }
            Item val = this.current.value;
            this.current = current.next;
            return val;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    // construct an empty deque
    public Deque() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    // is the deque empty?
    public boolean isEmpty() {
        return first == null;
    }

    // return the number of items on the deque
    public int size() {
        return this.size;
    }

    // add the item to the front
    public void addFirst(Item item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }
        this.size++;
        Node newFirst = new Node(item);
        newFirst.next = this.first;
        if (this.first != null) {
            this.first.prev = newFirst;
        }
        this.first = newFirst;
        if (this.size == 1) {
            this.last = this.first;
        }
    }

    // add the item to the back
    public void addLast(Item item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }
        this.size++;
        Node newLast = new Node(item);
        newLast.prev = last;
        if (this.last != null) {
            this.last.next = newLast;
        }
        this.last.next = newLast;
        this.last = newLast;
        if (this.size == 1) {
            this.first = this.last;
        }
    }

    // remove and return the item from the front
    public Item removeFirst() {
        if (this.size > 0) {
            this.size--;
            Item itemToReturn = this.first.value;
            this.first = this.first.next;
            if (this.first != null) {
                this.first.prev = null;
            } else {
                this.last = null;
                this.first = null;
            }
            return itemToReturn;
        } else {
            throw new NoSuchElementException();
        }
    }

    // remove and return the item from the back
    public Item removeLast() {
        if (this.size > 0) {
            this.size--;
            Item itemToReturn = this.last.value;
            if (this.last.prev != null) {
                this.last = this.last.prev;
                this.last.next = null;
            } else {
                this.last = null;
                this.first = null;
            }
            return itemToReturn;
        } else {
            throw new NoSuchElementException();
        }
    }

    // return an iterator over items in order from front to back
    public Iterator<Item> iterator() {
        return new DequeIterator(this);
    }

    // unit testing (required)
    public static void main(String[] args) {
        Deque<Integer> deque = new Deque<Integer>();
        deque.addFirst(1);
        deque.addFirst(2);
        deque.addFirst(3);
        deque.addFirst(3);
        deque.addFirst(4);
        deque.removeFirst();
        deque.removeFirst();
        deque.removeFirst();
        deque.removeLast();

        StdOut.println();
        for (Integer dequeItem: deque) {
            StdOut.print(dequeItem);
        }
    }

}