package com.company;

import edu.princeton.cs.algs4.StdOut;

class Stack<Item extends Comparable> {
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

class StackWithMax<Item extends Comparable> {
    Stack<Item> stack;
    Stack<ValueAndCount<Item>> countStack;
    private ValueAndCount max = null;

    StackWithMax() {
        this.stack = new Stack<Item>();
        this.countStack = new Stack<ValueAndCount<Item>>();
    }

    class ValueAndCount<Item extends Comparable> implements Comparable {
        ValueAndCount(Item value, int count) {
           this.value = value;
           this.count = count;
        }
        public Item value;
        public int count;

        @Override
        public int compareTo(Object o) {
            return (((ValueAndCount) o)).compareTo(this.value);
        }
    }

    public void push(Item value) {
        stack.push(value);
        if (this.max == null || this.max.value.compareTo(value) < 0) {
            ValueAndCount newMax = new ValueAndCount(value, 1);
            countStack.push(newMax);
            max = newMax;
            return;
        }
        if (this.max.value.compareTo(value) == 0) {
            this.max.count++;
            return;
        }
    }

    public Item pop() {
        Item popped = this.stack.pop();
        if (popped.compareTo(this.max.value) == 0) {
            if (this.max.count > 1) {
                this.max.count--;
            } else {
                this.countStack.pop();
                ValueAndCount temp = this.countStack.pop();
                if (temp == null) {
                   this.max = null;
                } else {
                    this.countStack.push(this.max);
                    this.max = temp;
                }
            }
        }
        return popped;
    }

    public Item max() {
        return this.max != null ? (Item) this.max.value : null;
    }
}

public class Main {

    public static void main(String[] args) {
        StackWithMax maxStack = new StackWithMax();
        StdOut.println(maxStack.max());
        maxStack.push(1);
        StdOut.println(maxStack.max());
        maxStack.push(4);
        StdOut.println(maxStack.max());
        maxStack.push(2);
        StdOut.println(maxStack.max());
        maxStack.push(3);
        StdOut.println(maxStack.max());
        maxStack.push(5);
        StdOut.println(maxStack.max());
        maxStack.push(2);
        StdOut.println(maxStack.max());
        maxStack.push(5);
        StdOut.println(maxStack.max());
        maxStack.pop();
        StdOut.println(maxStack.max());
        maxStack.pop();
        StdOut.println(maxStack.max());
        maxStack.pop();
        StdOut.println(maxStack.max());
        maxStack.pop();
        StdOut.println(maxStack.max());
        maxStack.pop();
        StdOut.println(maxStack.max());
        maxStack.pop();
        StdOut.println(maxStack.max());
        maxStack.pop();
        StdOut.println(maxStack.max());
    }
}
