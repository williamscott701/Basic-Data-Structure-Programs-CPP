
//William Scott | WS
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        MaxHeap heap = new MaxHeap();

        heap.insert(new StudentNode("A", "B", new String[1]));
        heap.insert(new StudentNode("B", "D", new String[1]));
        heap.insert(new StudentNode("D", "F", new String[1]));
        heap.insert(new StudentNode("E", "F", new String[1]));
        heap.insert(new StudentNode("F", "F", new String[1]));
        heap.insert(new StudentNode("G", "F", new String[1]));
        heap.insert(new StudentNode("C", "F", new String[1]));

        heap.show();

        System.out.println("");
        heap.printLevelOrderInLevel();

        System.out.println("");
        System.out.println(heap.extractMax().getFirstName());
        heap.printLevelOrderInLevel();

        heap.deleteLast();
        heap.printLevelOrderInLevel();

        heap.delete("C", "F");
        heap.printLevelOrderInLevel();
    }

}
