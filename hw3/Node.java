public class Node {
    public int student_id;
    public String name;
    public double gpa;
    
    Node next;
    Node previous;
    
    // Constructor 1
    public Node(int id, String name, double gpa){
        this.student_id=id;
        this.name=name;
        this.gpa=gpa;

    }
    // Constructor 2
    public Node(String name){
        this.student_id=0;
        this.name=name;
        this.gpa=0.0;
    }
    // Constructor 3 (dummy)
    public Node(){
        // You can leave this function blank
    }
    
    public void printIDName(){
        System.out.println("StudentID: " + this.student_id + " , Name: " + this.name);
    }


    //ในส่วนนี้จะเป็นการกำหนดclass Node เพื่อใช้ในDoublyLinkedList เเละ SinglyLinkedList
}