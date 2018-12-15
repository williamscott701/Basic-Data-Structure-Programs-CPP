//William Scott

import java.util.ArrayList;
import java.util.Scanner;


//Node class to use this as a object for all the nodes and leaves
class Node {

    private int data = 0;
    private Node left = null, right = null;

    //Simple constructor
    public Node() {
    }

    //constructor initializing the node value
    public Node(int d) {
        this.data = d;
    }

    //getters and setters
    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

}

public class CheckBST {

    //declaring few necessary variables
    static ArrayList alPostOrder;
    static ArrayList alInOrder;
    static ArrayList violations;
    static Node root = null;
    static int posPointerPost, postorderElement;

    
    //funciton taking left and right positions of the selected portion of the inorder list to map the left and right of node
    //static variables are used inside for simpler funcitonality, instead of passing the whole object data everytime
    static Node buildTreePost(int l, int r) {

        //checking if the lef crossed right, if crossed there is no node after that.
        if (l > r) {
            return null;
        }

        //if the pointer in post order ends, then there are no elements to check with, so returning null
        if (posPointerPost == -1) {
            return null;
        }

        //getting the value of element in post order using the pointer and decementing pointer
        postorderElement = (int) alPostOrder.get(posPointerPost--);

        //creating a temporary node which will be attached to some left or right node of parent
        Node temp = new Node(postorderElement);

        //if left and right becomes equal then there are no children for the remp node and direclty reutrning the Node itself
        if (l == r) {
            return temp;
        }

        //getting the position of the selected element (that we selected in post order) in inorder
        int inoderPosition = (int) alInOrder.indexOf(postorderElement);

        //reccursive call to attach the return value to the right of the temp node
        temp.setRight(buildTreePost(inoderPosition + 1, r));

        //reccursive call to attach the return value to the left of the temp node
        temp.setLeft(buildTreePost(l, inoderPosition - 1));

        //returning the node that we built
        return temp;

    }

    //printing the elements in preorder
    static void printPreOrder(Node n) {
        //checking for null, as there can be a child of a parent as null
        if (n != null) {
            System.out.print(n.getData() + " ");
            printPreOrder(n.getLeft());
            printPreOrder(n.getRight());
        }
    }

    //checking for BST in inorder
    static void checkBSTIN() {
        //going through the inorder to check for the voilations and storig in the violations arraylist
        for (int i = 1; i < alInOrder.size(); i++) {
            if ((int) alInOrder.get(i - 1) > (int) alInOrder.get(i)) {
                violations.add(alInOrder.get(i - 1));
            }
        }

        //pintint the elements if there are voilations, else printing that its a valid binary tree
        if (violations.isEmpty()) {
            System.out.println("Valid Binary Search Tree");
        } else {
            System.out.print("\nNot Valid Binary Search Tree\n");
            System.out.print("\nViolated at: ");
            for (int i = 0; i < violations.size(); i++) {
                System.out.print(violations.get(i) + " ");
            }
        }
        System.out.println("");
    }

    //Postorder: 1 2 10 7 8 11 9 5
    //Inorder: 1 2 5 7 10 9 8 11
    public static void main(String[] args) {

        //initialising  few necessary objects
        Scanner in = new Scanner(System.in);
        alPostOrder = new ArrayList();
        alInOrder = new ArrayList();
        violations = new ArrayList();

        //taking the postorder input from user
        System.out.println("Enter Postorder");
        String temp = in.nextLine();
        String ip[] = temp.split(" ");

        //passing values to arraylist
        for (String arg : ip) {
            alPostOrder.add(Integer.parseInt(arg));
        }

        //taking the inorder input from user
        System.out.println("Enter Inorder");
        temp = in.nextLine();
        ip = temp.split(" ");

        //passing values to arraylist
        for (String arg : ip) {
            alInOrder.add(Integer.parseInt(arg));
        }

        posPointerPost = alPostOrder.size() - 1;

		//building root, and calling the recursive function
        root = buildTreePost(0, posPointerPost);

		//printing the preorder notation
        System.out.println("\nPreorder: ");
        printPreOrder(root);

		//checking for BST and printing
        System.out.println("");
        checkBSTIN();

    }

}
