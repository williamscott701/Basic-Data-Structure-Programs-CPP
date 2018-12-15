
public class StudentNode {

    String firstName;
    String lastName;
    String[] coursesTaken;

    StudentNode left;
    StudentNode right;
    StudentNode parent;
    boolean isLeft;

    public StudentNode(String firstName, String lastName, String[] coursesTaken) {
        this.firstName = firstName.toLowerCase();
        this.lastName = lastName.toLowerCase();
        this.coursesTaken = coursesTaken;
    }

    StudentNode(String firstName) {
        this.firstName = firstName;
    }

    StudentNode(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String[] getCoursesTaken() {
        return coursesTaken;
    }

    public void setCoursesTaken(String[] coursesTaken) {
        this.coursesTaken = coursesTaken;
    }

    public StudentNode getLeft() {
        return left;
    }

    public void setLeft(StudentNode left) {
        this.left = left;
    }

    public StudentNode getRight() {
        return right;
    }

    public void setRight(StudentNode right) {
        this.right = right;
    }

    public StudentNode getParent() {
        return parent;
    }

    public void setParent(StudentNode parent) {
        this.parent = parent;
    }

    public boolean isIsLeft() {
        return isLeft;
    }

    public void setIsLeft(boolean isLeft) {
        this.isLeft = isLeft;
    }

    public String getFullName() {
        return this.firstName + this.lastName;
    }

}
