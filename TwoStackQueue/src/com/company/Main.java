package com.company;

//import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;


class Stack<Item> {
    class Node {
        public Node next;
        public Item value;
    }

    private Node first = null;

    public void push(Item value) {
       Node oldFirst = first;
       first = new Node();
       first.next = oldFirst;
       first.value = value;
    }

    public Item pop() {
        Node prev = this.first.next;
        this.first = prev;
        return prev.value;
    }

    public boolean isEmpty() {
       return this.first == null;
    }
}

class TwoStackQueue<Item> {
    Stack push = new Stack<java.lang.Float>();
    Stack pop = new Stack();

    public void enqueue(Item item) {
        while(!this.push.isEmpty()) {
            Item popped = this.push.pop();
            this.pop.push(popped);
        }
        this.push.push((Object) item);
    }

    public denqueue() {
        while(!this.push.isEmpty()) {
            Item popped = this.push.pop();
            this.pop.push(popped);
        }
        if(this.pop.isEmpty()) {
            return null;
        }
        return this.pop.pop();
    }

    public isEmpty() {
        return this.push.isEmpty() && this.pop.isEmpty();
    }
}

public class Main {

    public static void main(String[] args) {
        // write your code here
        Double testArray = new Double(){1,2,3,4,6};
        TwoStackQueue queue = new TwoStackQueue();
        for(int i = 0; i < testArray.length; i++) {
            queue.enqueue(testArray[i]);
        }
        while(!queue.isEmpty()) {
            StdOut.print(queue.deenqueue());
        }
    }
}
