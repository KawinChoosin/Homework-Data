public class Node extends BTreePrinter { // Fix this line

    Node left;
    Node right;
    int data;

    public Node(int data) {
        this.data=data;
    }

    public void printTree() {
        // Understand this line before uncommenting
        super.printTree(this);
    }

}

public static Node constructTree1(){
    Node root = new Node(3); // Fix this
    root.left = new Node(7);
    root.right = new Node(5);
    root.left.left = new Node(2);
    root.left.right = new Node(6);
    root.left.right.left=new Node(1);
    root.left.right.right=new Node(8);
    root.right.right=new Node(9);
    root.right.right.left=new Node(4);
    return root;
}



public static Node constructTree2(){
    Node root = new Node(1); // Fix this
    root.left=new Node(2);
    root.left.left=new Node(4);
    root.left.right = new Node(5);
    root.left.right.left = new Node(7);
    root.left.right.right = new Node(8);
    root.left.right.right.right = new Node(10);
    root.right=new Node(3);
    root.right.right=new Node(6);
    root.right.right.left=new Node(9);
    return root;
}


public class Stack {
    Node[] arr; // regular array
    int capacity;
    int size;

    public Stack(int cap){
        arr=new Node[cap];
        capacity=cap;
    }//เป็นการจองarrayให้มีขนาดเท่ากับcapเเละเซ็ทcapacityเป็นcap
    
    public void push(Node node){
        if (!isFull()){
            arr[size]=node;
            size++;
        }else{
            System.out.println("Stack Overflow!!!");
        }
    }//เป็นการpush nodeในarray โดยจะเช็คว่าarrเต็มมั้ยหากเต็มจะprint stack overflow 
    //หากไม่เต็มจะเปลี่ยนค่าarrayตำเเหน่งถัดไปเป็นnodeเเทน เเล้วเพิ่มค่าsizeไปหนึ่ง
    
    public Node pop(){
        
        if (!isEmpty()){
            Node popvalue=arr[size-1];
            arr[size-1]=null;
            size--;
            return popvalue;
        }else{
            System.out.println("Stack Underflow!!!");
            
        }
        return null;// fix this (out of place)
    }//เป็นการpop nodeล่าสุดที่pushมาออก โดยจะcheckก่อนว่าarrว่างมั้ยถ้าว่างจะprint stack underflow
     //ถ้าไม่จะกำหนดnodeใหม่มาเก็บค่าของตัวที่จะpopเเล้วเปลี่ยนตำแหน่งนั้นเป็นnullเพื่อpopค่าออก
     //จากนั้นเปลี่ยนค่าsizeลดลง เเล้วreturnค่าที่popออกมา โดยถ้าว่างจะreturn nullด้วย
   
    public boolean isFull(){
        return size==capacity; // fix this
    }//เช็คว่าsize==capacityมั้ย ถ้าเท่าหมายความว่าarrเต็ม
    
    public boolean isEmpty(){
        return size==0; // fix this
    }//เช็คว่าsize==0มั้ยถ้าใช่หมายความว่าarrayว่าง
    
    public void printStack(){
        if (!isEmpty()) {
            System.out.print("[Bottom] ");
            for(int i=0;i<size;i++){
                 System.out.print(arr[i].data+" ");
            }
            System.out.println("[Top]");
        } else {
            System.out.println("Empty Stack!!!");
        }
    }
}//เป็นfor loop เพื่อprint ค่าdataที่อยู่ในnodeที่อยู่ในarrayอีกที



public class Queue {
    Node[] arr; // circular array
    int capacity;
    int front;
    int back;
    int size;
    
    public Queue(int cap){
        arr=new Node[cap];
        capacity=cap;
    }//เป็นการจองarrayให้มีขนาดเท่ากับcapเเละเซ็ทcapacityเป็นcap
    
    public void enqueue(Node node){
        if (!isFull()){
            arr[back]=node;
            back++;
            back=back%capacity;
            size++;
            
        }else{
            System.out.println("Queue Overflow!!!");
        }
    }//เปรียบเสมือนการpush nodeในarray โดยจะเช็คว่าarrเต็มมั้ยหากเต็มจะprint Queue overflow 
    //หากไม่เต็มจะเปลี่ยนค่าarrayตำเเหน่งถัดไปเป็นnodeเเทน เเล้วเพิ่มค่าsizeและbackไปหนึ่ง โดยbackจะเปลี่ยน
    //เป็นback%capacityคือในกรณีที่enqueueข้อมูลถึงตัวสุดท้ายเเล้ว ด้านหน้าของarrayมีช่องว่างที่เกิดจากdequeue
    //backก็จะไปชี้ที่เเรกเเทน 
    
    public Node dequeue(){
        
        if (!isEmpty()){
            Node dequeuevalue=arr[front];
            arr[front]=null;
            front++;
            front=front%capacity;
            size--;
            return dequeuevalue;
        }else{
            System.out.println("Queue Underflow!!!");
        }
        return null; // fix this (out of place)
    }//เปรียบเสมือนการpop nodeล่าสุดที่enqueueมาออก โดยจะcheckก่อนว่าarrว่างมั้ยถ้าว่างจะprint 
     //Queue underflow ถ้าไม่จะกำหนดnodeใหม่มาเก็บค่าของตัวที่จะpopเเล้วเปลี่ยนตำแหน่งนั้นเป็นnull
     //เพื่อpopค่าออก จากนั้นเปลี่ยนค่าsizeลดลง เเล้วเพื่มค่าfrontไป1ค่า โดยfrontจะเปลี่ยนเป็น
     //front%capacityคือในกรณีที่dequeueข้อมูลถึงตัวสุดท้ายเเล้ว ด้านหน้าของarrayมีข้อมูลที่เกิดจาก
     //enqueue แล้วต้องการdequeueอีกจึงต้อง%เพื่อให้frontมาชึ้ที่ตัวเเรกเเทน จากนั้นจึงreturn ค่าที่จะ
     //dequeueออกมาเเทน โดยถ้าว่างจะreturn nullด้วยย
    
    public boolean isEmpty(){
        return size==0; // fix this
    }//เช็คว่าsize==0มั้ยถ้าใช่หมายความว่าarrayว่าง
    
    public boolean isFull(){
        return size==capacity; // fix this
    }//เช็คว่าsize==capacityมั้ย ถ้าเท่าหมายความว่าarrเต็ม
    
    public void printCircularIndices(){
        System.out.println("Front index = " + front + " Back index = " + back);
    }
    
    public void printQueue(){
        if (!isEmpty()){
            System.out.print("[Front] ");
            for(int i=0;i<size;i++){
                System.out.print(arr[(front+i)%(capacity)].data+" ");
            }
            System.out.println("[Back]");
        }else{
            System.out.println("Empty Queue!!!");
        }
    }
    //เป็นfor loop เพื่อprint ค่าdataที่อยู่ในnodeที่อยู่ในarrayอีกทีโดยจะเปลี่ยนค่าต่ำเเหน่งของarray
    //โดยเกิดจากการ%ตำเเหน่ง
}



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
        q.enqueue(this);
        while(!q.isEmpty()){
            Node current=q.dequeue();
            System.out.print(current.data+" ");
            if(current.left!=null){
                q.enqueue(current.left);
            }
            if(current.right!=null){
                q.enqueue(current.right);
            }
        }
        
        System.out.println("]");
    }//จะนำdataตัวเเรกenqueueเข้าไปในqueue q เเล้วจะวนloopให้หยุดถ้าqว่าง ถ้าqไม่ว่าง
    //จะสร้างNode currentมาโดยมีค่าเท่ากับqที่dequeueออกมา เเล้วสั่งprintค่านั้น โดยจะ
    //เช็คต่ออีก2เงื่อนไขคือเช็คลูกทางด้านซ้ายว่ามีมั้ยถ้ามีก็จะenqueue เข้าไปในq เเละเงื่อนไข
    //ที่สองคือเช็คว่ามีลูกด้านขวามั้ยเเล้ววนloopต่อไป

    public void printDFT() { // PreOrder
        Stack s = new Stack(50);
        System.out.print("DFT node sequence [ ");
        s.push(this);
        while(!s.isEmpty()){
        Node current=s.pop();
        System.out.print(current.data+" ");
        if(current.right!=null){
            s.push(current.right);
        }
        
        if(current.left!=null){
            s.push(current.left);
        }
        }
        System.out.println("]");
    }//ส่วนนี้จะทำคล้ายเเบบBFTด้านบน ต่างกันที่ใช้stack sเเทนqueue เเละเช็คลูกด้านขวาก่อนลูกข้างซ้าย
}
