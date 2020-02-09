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
        if (this.first == null) return null;
        Node oldFirst = this.first;
        this.first = oldFirst.next;
        return oldFirst.value;
    }

    public boolean isEmpty() {
        return this.first == null;
    }
}

class TwoStackQueue<Item> {
    Stack push = new Stack<Item>();
    Stack pop = new Stack<Item>();

    public void enqueue(Item item) {
        this.push.push(item);
    }

    public Item denqueue() {
        while(!this.push.isEmpty()) {
            Item popped = (Item) this.push.pop();
            this.pop.push(popped);
        }
        if(this.pop.isEmpty()) {
            return null;
        }
        return (Item) this.pop.pop();
    }

    public boolean isEmpty() {
        return this.push.isEmpty() && this.pop.isEmpty();
    }
}

public class Main {

    public static void main(String[] args) {
        // write your code here
        Float[] testArray = new Float[]{1f, 2f, 3f, 4f, 6f};
        TwoStackQueue queue = new TwoStackQueue<Float>();
        Stack justTestStack = new Stack<Float>();
        for(int i = 0; i < testArray.length; i++) {
            queue.enqueue(testArray[i]);
        }
        while(!queue.isEmpty()) {
            StdOut.print(queue.denqueue() + "\t");
        }
        StdOut.println();
        for(int i = 0; i < testArray.length; i++) {
            justTestStack.push(testArray[i]);
        }
        while(!justTestStack.isEmpty()) {
            StdOut.print(justTestStack.pop() + "\t");
        }
    }
}