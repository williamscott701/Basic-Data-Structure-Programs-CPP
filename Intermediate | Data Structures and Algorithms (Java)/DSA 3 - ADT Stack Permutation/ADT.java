
import java.util.Scanner;

class Node {

    private int value = 0;
    private Node next = null;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

}

class Stack {

    Node head = new Node();

    int size = 0;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int top() {
        if (isEmpty()) {
            return 0;
        } else {
            return head.getValue();
        }
    }

    public void push(int element, String name) {
        System.out.println("push " + element + " " + name);
        size++;
        Node n = new Node();
        n.setValue(element);
        n.setNext(head);
        head = n;
    }

    public int pop(String name) {
        size--;
        Node t = head;
        head = head.getNext();
        System.out.println("pop " + t.getValue() + " " + name);
        return t.getValue();
    }

    public void print() {
        Node t = head;
        while (t.getNext() != null) {
            System.out.println(t.getValue());
            t = t.getNext();
        }
    }
}

class Queue {

    Node head = new Node();
    Node tail = head;

    int size = 0;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int front() {
        if (isEmpty()) {
            return 0;
        } else {
            return head.getValue();
        }
    }

    public void enqueue(int element, String name) {

        Node n = new Node();
        n.setValue(element);
        n.setNext(null);
        tail.setNext(n);
        tail = n;
        if (isEmpty()) {
            head = tail;
        }

        System.out.println("enqueue " + tail.getValue() + " " + name);

        size++;

    }

    public int dequeue(String name) {
        size--;
        Node t = head;
        if (isEmpty()) {
            head = null;
            tail = head;
        } else {
            head = head.getNext();
        }
        System.out.println("dequeue " + t.getValue() + " " + name);
        return t.getValue();
    }

    public void print() {
        Node h = head;
        if (!isEmpty()) {
            while (h.getNext() != null) {
                System.out.println(h.getValue());
                h = h.getNext();
            }
            System.out.println(h.getValue());
        }
    }

}

public class ADT {

    public static void main(String[] args) {
        try {
            Stack s = new Stack();

            Queue q1 = new Queue();
            Queue q2 = new Queue();

            Scanner in = new Scanner(System.in);

            String input = in.nextLine();

            String input2 = in.nextLine();

            String temp[] = input2.split(" ");

            int permutation[] = new int[temp.length];

            for (int i = 0; i < temp.length; i++) {
                permutation[i] = Integer.parseInt(temp[i]);
            }

            for (int i = 1; i <= Integer.parseInt(input); i++) {
                q1.enqueue(i, "q1");
            }
            System.out.println("\n----------------\n");

            for (int i = 0; i < temp.length; i++) {
                int v = permutation[i];
//            System.out.println("front " + q1.front() + " vvv " + v);
                if (v == q1.front()) {
//                System.out.println("case 1");
                    q2.enqueue(q1.dequeue("q1"), "q2");
                } else if (permutation[i] == s.top()) {
//                System.out.println("case 2");
//                System.out.println("perm: " + permutation[i] + " - stack: " + s.top());
                    q2.enqueue(s.pop("s"), "q2");
                } else {
                    while (q1.front() != v) {
//                    System.out.println("case 3-" + i);
                        s.push(q1.dequeue("q1"), "s");
                    }
                    if (q1.front() == v) {
//                    System.out.println("case 4");
                        q2.enqueue(q1.dequeue("q1"), "q2");
                    }
                }
            }
            System.out.println("\nThe given input is a Stack Permutation");

        } catch (Exception e) {
            System.out.println("\nNot a Stack Permutation, as we are in checkmate");
        }
    }

}
