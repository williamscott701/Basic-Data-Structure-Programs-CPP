
import java.util.ArrayList;

public class MaxHeap {

    StudentNode root = null;
    int size = 0;

    public void resetRootParent() {
        root.getParent().setFirstName(root.getFirstName());
        root.getParent().setLastName(root.getLastName());
    }

    public void insert(StudentNode student) {
        System.out.println("-------------------\nInserting " + student.getFullName());
        size++;

        if (root == null) {
            student.setParent(new StudentNode(student.getFirstName(), student.getLastName()));
            root = student;
        } else {

            ArrayList<StudentNode> queue = new ArrayList<>();

            StudentNode temp = root;

            while (true) {
                if (temp.getLeft() != null) {
                    queue.add(temp.getLeft());
                } else {
                    student.setParent(temp);
                    student.setIsLeft(true);
                    temp.setLeft(student);
                    break;
                }
                if (temp.getRight() != null) {
                    queue.add(temp.getRight());
                } else {
                    student.setParent(temp);
                    student.setIsLeft(false);
                    temp.setRight(student);
                    break;
                }
                if (!queue.isEmpty()) {
                    temp = queue.remove(0);
                } else {
                    break;
                }
            }
        }

        printLevelOrderInLevel();
        heapAfterInsert(getLast());
        printLevelOrderInLevel();
    }

    public StudentNode maximum() {
        System.out.println("Returning Maximum");
        return root;
    }

    public StudentNode extractMax() {
        System.out.println("Extrating Maximum");
        size--;

        StudentNode last = getLast();

        StudentNode tempRoot = new StudentNode(root.getFirstName(), root.getLastName(), root.getCoursesTaken());

        root.setFirstName(last.getFirstName());
        root.setLastName(last.getLastName());
        root.setCoursesTaken(last.getCoursesTaken());

        deleteLast();

        heapifyAfterMaxRemoved(root);
        resetRootParent();

        return tempRoot;
    }

    public void deleteLast() {
        System.out.println("Deleting Last Node");
        StudentNode last = getLast();

        StudentNode tempLastParent = last.getParent();
        if (last.isLeft) {
            tempLastParent.setLeft(null);
        } else {
            tempLastParent.setRight(null);
        }
    }

    public void delete(String firstName, String lastName) {
        System.out.println("\nDeleting");

        ArrayList<StudentNode> queue = new ArrayList<>();

        StudentNode temp = root;

        while (temp != null) {
            if (temp.getLeft() != null) {
                if (temp.getLeft().getFullName().equals(firstName.toLowerCase() + lastName.toLowerCase())) {
                    StudentNode last = getLast();
                    temp.getLeft().setFirstName(last.getFirstName());
                    temp.getLeft().setLastName(last.getLastName());
                    temp.getLeft().setCoursesTaken(last.getCoursesTaken());

                    deleteLast();
                } else {
                    queue.add(temp.getLeft());
                }
            }
            if (temp.getRight() != null) {
                if (temp.getRight().getFullName().equals(firstName.toLowerCase() + lastName.toLowerCase())) {
                    StudentNode last = getLast();
                    temp.getRight().setFirstName(last.getFirstName());
                    temp.getRight().setLastName(last.getLastName());
                    temp.getRight().setCoursesTaken(last.getCoursesTaken());

                    deleteLast();
                } else {
                    queue.add(temp.getRight());
                }
            }
            if (!queue.isEmpty()) {
                temp = queue.remove(0);
            } else {
                break;
            }
        }
    }

    public void heapifyAfterMaxRemoved(StudentNode n) {
        if (n != null) {
            if (n.getLeft() != null) {
                String max = n.getFullName();
                int maxFound = 0;
                if (max.compareTo(n.getLeft().getFullName()) < 0) {
                    max = n.getLeft().getFullName();
                    maxFound = 1;
                }
                if (n.getRight() != null) {
                    if (max.compareTo(n.getRight().getFullName()) < 0) {
                        maxFound = 2;
                    }
                }
                if (maxFound == 1) {
                    swap(n, true);
                    heapifyAfterMaxRemoved(n.getLeft());
                } else if (maxFound == 2) {
                    swap(n, false);
                    heapifyAfterMaxRemoved(n.getRight());
                }
            }
        }
    }

    public void heapAfterInsert(StudentNode n) {
        if (n != null) {
            if (n.getParent() != null) {
                if (n.getFullName().compareTo(n.getParent().getFullName()) > 0) {
                    if (n.isIsLeft()) {
                        swap(n.getParent(), true);
                    }
                    if (!n.isIsLeft()) {
                        swap(n.getParent(), false);
                    }
                    heapAfterInsert(n.getParent());
                }
            }
        }
    }

    public StudentNode getLast() {
        ArrayList<StudentNode> queue = new ArrayList<>();

        StudentNode selected = root;

        while (selected != null) {
            if (selected.getLeft() != null) {
                queue.add(selected.getLeft());
            }
            if (selected.getRight() != null) {
                queue.add(selected.getRight());
            }
            if (!queue.isEmpty()) {
                selected = queue.remove(0);
            } else {
                break;
            }
        }
        return selected;
    }

    public void swap(StudentNode n, boolean isLeft) {
        if (isLeft) {
            StudentNode temp = new StudentNode(n.getLeft().getFirstName(), n.getLeft().getLastName(), n.getLeft().getCoursesTaken());

            n.getLeft().setFirstName(n.getFirstName());
            n.getLeft().setLastName(n.getLastName());
            n.getLeft().setCoursesTaken(n.getCoursesTaken());
            n.setFirstName(temp.getFirstName());
            n.setLastName(temp.getLastName());
            n.setCoursesTaken(temp.getCoursesTaken());
        } else {
            StudentNode temp = new StudentNode(n.getRight().getFirstName(), n.getRight().getLastName(), n.getRight().getCoursesTaken());
            n.getRight().setFirstName(n.getFirstName());
            n.getRight().setLastName(n.getLastName());
            n.getRight().setCoursesTaken(n.getCoursesTaken());
            n.setFirstName(temp.getFirstName());
            n.setLastName(temp.getLastName());
            n.setCoursesTaken(temp.getCoursesTaken());
        }
        resetRootParent();
    }

    public void show() {

        ArrayList<StudentNode> queue = new ArrayList<>();

        StudentNode temp = root;

        System.out.println("\nDisplaying all Students: ");

        while (temp != null) {
            System.out.print(temp.getFullName() + " ");
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

    public void printLevelOrderInLevel() {

        ArrayList<StudentNode> queue = new ArrayList<>();

        queue.add(root);
        System.out.println("\nLevel Order: ");
        while (true) {
            if (queue.isEmpty()) {
                break;
            }

            int noOfItems = queue.size();

            while (noOfItems != 0) {
                StudentNode temp = queue.get(0);
                System.out.print(temp.getParent().getFullName().toUpperCase() + "." + temp.getFullName() + " ");
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
}
