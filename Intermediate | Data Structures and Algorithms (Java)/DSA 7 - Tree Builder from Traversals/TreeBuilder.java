
import static java.lang.System.exit;
import java.util.ArrayList;
import java.util.Scanner;

class Node {

    char data;

    Node left = null, right = null;

    public Node(char d) {
        this.data = d;
    }

    public Node() {
    }

    public Node(char data, Node left, Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public char getData() {
        return data;
    }

    public void setData(char data) {
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

public class TreeBuilder {

    static Node root = null;

    static int pointer = 0;

    static String inorder = "", postorder = "", preorder = "", output = "";

    static char selectedElementPostorder;

    static int findElemInInorder(char c) {
        for (int i = 0; i < inorder.length(); i++) {
            if (c == inorder.charAt(i)) {
                return i;
            }
        }
        return -1;
    }

    static Node buildTreeInPre(int l, int r) {
        char selectedElementPreorder = ' ';
        int posOfElementInoder = 0;

        if (pointer < preorder.length()) {
            selectedElementPreorder = preorder.charAt(pointer);
            posOfElementInoder = findElemInInorder(selectedElementPreorder);
            pointer++;
        }

        Node n = new Node();

        if (l > r) {
            return null;
        }

        n.setData(selectedElementPreorder);

        if (l == r) {
            return n;
        }

        if (l <= posOfElementInoder - 1) {
            n.setLeft(buildTreeInPre(l, posOfElementInoder - 1));
        }

        n.setRight(buildTreeInPre(posOfElementInoder + 1, r));

        return n;
    }

    static Node buildTreeInPost(int l, int r) {

        if (l > r) {
            return null;
        }

        if (pointer == -1) {
            return null;
        }

        selectedElementPostorder = postorder.charAt(pointer--);

        Node n = new Node(selectedElementPostorder);

        if (l == r) {
            return n;
        }

        int posOfElementInoder = findElemInInorder(selectedElementPostorder);

        n.setRight(buildTreeInPost(posOfElementInoder + 1, r));

        n.setLeft(buildTreeInPost(l, posOfElementInoder - 1));

        return n;

    }

    static void printLevelOrderInLine(Node root) {

        ArrayList<Node> queue = new ArrayList<>();

        Node temp = root;

        System.out.println("\n\nLevel Order: ");

        while (temp != null) {
            System.out.print(temp.getData() + " ");
            if (temp.getLeft() != null) {
                queue.add(temp.getLeft());
            }
            if (temp.getRight() != null) {
                queue.add(temp.getRight());
            }
            if (!queue.isEmpty()) {
                temp = queue.remove(0);
            } else {
                break;
            }

        }
    }

    static void printLevelOrderInLevel(Node root) {

        ArrayList<Node> queue = new ArrayList<>();

        queue.add(root);
        System.out.println("\n\nLevel Order: ");
        while (true) {
            if (queue.isEmpty()) {
                break;
            }

            int noOfItems = queue.size();

            while (noOfItems != 0) {
                Node temp = queue.get(0);
                System.out.print(temp.getData() + " ");
                if (temp.getLeft() != null) {
                    queue.add(temp.getLeft());
                }
                if (temp.getRight() != null) {
                    queue.add(temp.getRight());
                }
                queue.remove(0);
                noOfItems--;
            }
            System.out.println("");
        }
    }

    static void printPreOrder(Node n) {
        if (n != null) {
            System.out.print(n.data);
            printPreOrder(n.getLeft());
            printPreOrder(n.getRight());
        }
    }

    static void printPostOrder(Node n) {
        if (n != null) {
            printPostOrder(n.getLeft());
            printPostOrder(n.getRight());
            System.out.print(n.data);
        }
    }

    //preorder = "abdfgehijklcmnopqr";
    //inorder = "fdgbeihkjlamcoqprn";
    //postorder = "fgdikljhebmqrponca";
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        while (true) {
            System.out.println("\n**Options**\n1. Inorder - Preorder\n2. Inorder - Postorder\n3. Exit\n\nEnter your choice: ");
            int choice = in.nextInt();
            switch (choice) {
                case 1:

                    pointer = 0;
                    System.out.print("Enter Pre Order: ");
                    preorder = in.next();

                    System.out.print("Enter In Order: ");
                    inorder = in.next();
                    root = new Node(preorder.charAt(0), root, root);
                    root = buildTreeInPre(0, inorder.length() - 1);

                    System.out.print("\nPost Order: ");
                    printPostOrder(root);
                    printLevelOrderInLine(root);
                    printLevelOrderInLevel(root);

                    break;
                case 2:

                    System.out.print("Enter Post Order: ");
                    postorder = in.next();

                    System.out.print("Enter In order: ");
                    inorder = in.next();

                    pointer = postorder.length() - 1;
                    output = "";
                    root = new Node(postorder.charAt(pointer));
                    root = buildTreeInPost(0, inorder.length() - 1);
                    printPreOrder(root);
                    printLevelOrderInLevel(root);
                    break;
                case 3:
                    exit(0);
                default:
                    System.out.println("Invalid Input");
                    break;
            }
        }
    }
}
