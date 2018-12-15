
import java.util.Scanner;

/**
 *
 * @author williamscott
 */
class Node {

    int value = 0;
    Node next = null;

    void setNextNode(Node n) {
        next = n;
    }

    void setValue(int v) {
        this.value = v;
    }

    Node getNextNode() {
        return next;
    }

    int getValue() {
        return value;
    }

}

class LinkedList {

    Node pointerNode = new Node();

    int size = 0;

    Node head = pointerNode;

    void insertNode(int v) {
        size++;
        Node n = new Node();
        pointerNode.setValue(v);
        pointerNode.setNextNode(n);
        pointerNode = n;
    }

    void printLinkedList() {
        Node t = head;
        while (t.getNextNode() != null) {
            System.out.println(t.value);
            t = t.getNextNode();
        }
    }

    String getLinkedListData() {
        Node t = head;
        String output = "" + t.getValue();
        t = t.getNextNode();
        while (t.getNextNode() != null) {
            output = output + "->" + t.value;
            t = t.getNextNode();
        }
        output += "->NULL";
        return output;
    }

    void sortLinkedList() {

        Node current = head;

        Node oddPointer = head;

        int temp;
        while (current.getNextNode() != null && current.getValue() % 2 == 0) {
            current = current.next;
        }

        while (current.getNextNode() != null) {

//            System.out.println("current value: " + current.getValue());
            if (current.getValue() % 2 == 0) {

//                System.out.println("\ncurrent Even--: " + current.getValue() + "\n");
                //clone oddpointer
                Node oddPointerClone = oddPointer;

                temp = oddPointerClone.getValue();

                oddPointerClone.setValue(current.getValue());

//                System.out.println("temp: " + temp);
//                printLinkedList();
//                System.out.println("");
                oddPointerClone = oddPointerClone.next;
                while (oddPointerClone.value % 2 == 1) {
//                    System.out.println("VALUE: " + oddPointerClone.value);
//                    System.out.println("Inside");
//                    printLinkedList();

                    //swap temp-value
                    int swap = temp;
                    temp = oddPointerClone.value;
                    oddPointerClone.value = swap;

                    oddPointerClone = oddPointerClone.next;
//                    System.out.println("after swap");
//                    printLinkedList();

                }

                int swap = temp;
                temp = oddPointerClone.value;
                oddPointerClone.value = swap;

                oddPointer = oddPointer.next;
            }
            current = current.next;
        }

    }
}

public class Main {

    public static void main(String[] args) {
        
        System.out.println("Note: Please dont copy paste input");
        
        LinkedList l = new LinkedList();

        Scanner in = new Scanner(System.in);

        String input = in.nextLine();

        String sp[] = input.split("->");

        for (String string : sp) {
            if (!string.equalsIgnoreCase("null")) {
//                System.out.println(string);
                l.insertNode(Integer.parseInt(string));
            }
        }

        l.sortLinkedList();

//        l.printLinkedList();
        System.out.println(l.getLinkedListData());
    }

}
