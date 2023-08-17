package hw5;

import java.util.Stack;

public class Node extends BTreePrinter { // Fix this line

    Node left;
    Node right;
    int data;

    public Node(int data) {
        this.data=data;
    }

    public void printTree() {
      
        super.printTree(this);
    }

    public void printBFT() {
        Queue q = new Queue(50);
        System.out.print("BFT node sequence [ ");
        System.out.println("]");
    }

    public void printDFT() { // PreOrder
        Stack s = new Stack(50);
        System.out.print("DFT node sequence [ ");
        System.out.println("]");
    }
}
