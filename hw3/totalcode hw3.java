public class Node {
    public int student_id;
    public String name;
    public double gpa;
    
    Node next;
    Node previous;
    
    // Constructor 1 // สร้างตัวแปรให้มีค่าตามค่าที่ผู้ใช้กำหนด
    public Node(int id, String name, double gpa){
        this.student_id=id;
        this.name=name;
        this.gpa=gpa;

    }
    // Constructor 2 // สร้างตัวแปรให้มีค่า name ตามที่ผู้ใช้กำหนดเมื่อ input มีแค่ค่า name เท่านั้น
    public Node(String name){
        this.student_id=0;
        this.name=name;
        this.gpa=0.0;
    }
    // Constructor 3 (dummy)
    public Node(){
        // You can leave this function blank
    }
    
    public void printIDName(){ //แสดงค่า StudentID และ name ของ Node
        System.out.println("StudentID: " + this.student_id + " , Name: " + this.name);
    }


    //ในส่วนนี้จะเป็นการกำหนดclass Node เพื่อใช้ในDoublyLinkedList เเละ SinglyLinkedList
}



public class SinglyLinkedList {
    Node head;
    String listName;
    
    public SinglyLinkedList(String name){ //ให้ชื่อของ list คือค่าของตัวแปร name
        listName=name;
    }
    
    public void popBack() {  //ฟังก์ชันที่ลบตัวสุดท้ายของlist
        if (isEmpty()){     //ถ้าlistว่างให้แสดงว่า error
                System.out.println("ERROR");
        }else{       //แต่ถ้าlist ไม่ว่าง ให้ทำการเช็คอีกครั้ง
            Node current = head;     //สร้าง node ใหม่ ให้ค่าเท่ากับ head
            if(current.next!=null){     //ถ้าตัวถัดไปของ current ไม่เท่ากับ null
            while(current.next.next!=null){     //วนจนกว่าตัวถัดไปของถัดไปของ current ไม่เท่ากับ null
               current=current.next;            //เลื่อน node
            }
            current.next=null;         //กำหนดค่าให้เป็น null นั่นคือลบตัวสุดท้ายไป     
            }else{      //แต่ถ้าตัวถัดไปของ current เท่ากับ null
                head=null;
            }
        }
    }
    
    public void popFront(){ //ฟังก์ชันที่ลบตัวหน้าสุดของlist
        if (isEmpty()){     //ถ้าlistว่างให้แสดงว่า error
                System.out.println("ERROR");
        }else{   //แต่ถ้าlist ไม่ว่าง ให้เท่ากับตัวถัดไป
                head=head.next;
        }
    }
    
    public Node topFront(){     //ฟังก์ชันที่แสดงค่าของnode ตัวที่อยู่หน้าสุดของ list
        if (isEmpty()){          //ถ้าlistว่างให้แสดงว่า error
            System.out.println("ERROR");
            return new Node("Empty List!");      //สร้างnodeใหม่ แสดงข้อความ
        } else {    //แต่ถ้าlist ไม่ว่าง 
            return head;    //ส่งค่า head
        }
    }
    
    public Node topBack(){ //ฟังก์ชันที่แสดงค่าของnode ตัวที่อยู่หลังสุดของ list
        if (isEmpty()){   //ถ้าlistว่าง ให้แสดงว่า error
            System.out.println("ERROR");
            return new Node("Empty List!");      //สร้างnodeใหม่ แสดงข้อความ
        } else {    //แต่ถ้าlist ไม่ว่าง 
            Node current = head;
            while(current.next!=null){ //วนจนกว่าตัวถัดไป current ไม่เท่ากับ null
               current=current.next;    // เลื่อน node
            }
            return current; 
        }
    }
    
    public void pushFront(Node node){    //ฟังก์ชันที่นำ node มาเติมข้างหน้าสุดของ list
        if (isEmpty()){      //ถ้าlistว่าง ให้แสดงว่า error
            head=node;       //ให้ head มีค่าเท่ากับ node
        }else{  //แต่ถ้าlist ไม่ว่าง 
            node.next=head;        // ให้ตัวถัดไปของ node เป็น  head 
            head=node;             // ได้ head ที่เป็น node ที่เติม
        }
    }
    
    public void pushBack(Node node) {   //ฟังก์ชันที่นำ node มาต่อท้าย list
        if (isEmpty()){ //ถ้าlistว่าง ให้แสดงว่า error
            head=node;        //ให้ head มีค่าเท่ากับ node
        } else {    //แต่ถ้าlist ไม่ว่าง 
            Node current = head;
            while(current.next!=null){ //วนจนกว่าตัวถัดไป current ไม่เท่ากับ null
               current=current.next;
            }
            current.next=node;    // ได้ corrent.next ที่เป็น  node ที่มาต่อท้าย
        }
        }
    

    public Node findNode(int id){       //ฟังก์ชั่นแสดงnode ที่มีค่า student_id = id
        if (isEmpty()){      //ถ้า list ว่าง สร้างnodeใหม่ แสดงข้อความ
            return new Node("Empty List!");
        } else {
            Node find = head;      // กำหนด node ที่ใช้หา โดยเริ่มต้นที่ head
            while(find!=null){     // ถ้าfind ยังไม่เท่ากับ null ให้วนลูปไปเรื่อยๆ
                if(find.student_id==id){        // ถ้า id ตรงกัน ให้ แสดง id ,name , gpa
                    return new Node(id,find.name,find.gpa);
                }
                find=find.next;      // ให้เป็น node ถัดไป 
            }
            
                return new Node("Student Not Found!");      // หา node นั้นไม่เจอ
    
    
        }
    }
    
    public Node eraseNode(int id){      //ฟังก์ชันที่ลบ node ที่ต้องการ
        if (isEmpty()){ //ถ้าlistว่าง ให้แสดงว่า error
            System.out.println("ERROR");
            return new Node("Empty List!");      //สร้างnodeใหม่ แสดงข้อความ
        } else {     // แต่ถ้าlist ไม่ว่าง นั่นคือ มี node อยู่
            Node find = head;   //สร้าง node ที่มีค่าเริ่มต้นเป็น head
            Node keep = head;   //สร้าง node ที่มีค่าเริ่มต้นเป็น head
            if(find.student_id==id){    //ถ้าid ที่ต้องการหา มีค่า เท่ากับ id ของ head
                head=head.next;         // ให้ Head เท่ากับ node ถัดไป
                return keep;             // แสดง  keep
    
            }else{   // แต่ถ้าid ที่ต้องการหา มีค่าไม่เท่ากับ id ของ  head
            while(find.next!=null){       // ถ้าตัวถัดไปของ find ยังไม่เท่ากับ null ให้วนลูป
                if(find.next.student_id==id){       //ถ้าid ตัวถัดไปของ find มีค่า เท่ากับ id 
                    keep=find.next;                  // เก็บค่า ตัวถัดไปของ find 
                    find.next=find.next.next;          //ให้ ตัวถัดไปของ find เท่ากับตัว ถัดไปอีก
                    return keep;        //แสดงค่า keep
                }
                find=find.next;         // เลื่อนไปเรื่อยๆ
            }
            return new Node("Student Not Found!");      // หา node นั้นไม่เจอ
            }
            
        }
    }
    
    public void addNodeAfter(Node node1, Node node2){ //ฟังก์ชันที่นำ node2 ไปแทรกด้านหลัง  node1
        Node current=head;  //สร้าง node ใหม่ ให้ค่าเท่ากับ head
        while(current.student_id!=node1.student_id){ // ถ้า id current ยังไม่เท่ากับ id node1 ให้วนลูปไปเรื่อยๆ
            current=current.next;   //เลื่อน node
        }
        node2.next=current.next;    // เมื่อพบก็ให้ ตัวถัดไปของ node2 เท่ากับ ตัวถัดไปของ current
        current.next=node2;         // ตัวถัดไปของ current = node 2
    }
    
    public void addNodeBefore(Node node1, Node node2){      // ฟังก์ชันที่นำ node2 ไปแทรกด้านหน้า  node1
        if(node1.student_id == head.student_id) {   // ถ้า id node1 = id head
            node2.next = node1;                             // ให้ ตัวถัดไปของ node2 = node 1 
            head = node2;                                   // ให้ head = node 2
        }else{
            Node current = head;
            while(current.next.student_id!=node1.student_id){// ถ้า id ตัวถัดไปของตัวถัดไป current ยังไม่เท่ากับ id node1 ให้วนลูปไปเรื่อยๆ
                current=current.next;                      //เลื่อน node
                }
            node2.next=node1;   // ถ้าตัวถัดไปของ node2 = node1
            current.next=node2; // ถ้าตัวถัดไปของ current = node 2 
        }
    }
    
    public boolean isEmpty(){   //ฟังก์ชันที่บอกว่าlist นี้ว่างหรือไม่
        return head==null;
    }
    public void merge(SinglyLinkedList list){   //ฟังก์ชันที่รวม 2 list
        if (isEmpty()) {      //ถ้าว่างให้เหมือนเดิม
            head = list.head;
        } else {
            Node current = head;
            while (current.next != null) {// วนลูปจนกว่า ตัวถัดไปของ current จะไม่เท่ากับ null
                current = current.next;
            }
            current.next = list.head; // กำหนดตัวท้าย
           
        }
    }
    
    public void printStructure(){
        Node current = head;
        System.out.print(listName+": head ->");
        while(current!=null){
             System.out.print(" {"+current.student_id+"} ->");
             current=current.next;
        }
         System.out.print(" null\n");
     
    }
    
    public Node whoGotHighestGPA(){     //ฟังก์ชันหา node ที่มี่ GPA สูงสุด
        if (isEmpty()) {    //ถ้า list ว่าง ให้ แสดงข้อความ
            return new Node("Empty List!");
        } else {     //แต่ถ้าไม่ว่าง
            Node high=head; //สร้าง node ใหม่
            Node order=head;
            while(order!=null){ // วนลูปจนหมด list
                if(high.gpa<=order.gpa){ //ถ้า gpa high น้อยกว่า gpa order ให้  high = order
                    high=order;
                }
                order=order.next;  // เลื่อน node
            
            } 
            return high; //ส่ง node ที่ gpa สูงสุดออกไป
        }
        }
    }




    public class DoublyLinkedList {
        Node head;
        Node tail;
        String listName;
        
        public DoublyLinkedList(String name){ //ให้ชื่อของ list คือค่าของตัวแปร name
            listName=name;
        }
        
        
        public void popBack() {     //ฟังก์ชันที่ลบตัวสุดท้ายของlist
          if (isEmpty()){   //ถ้าlistว่างให้แสดงว่า error
                System.out.println("ERROR");
            }else{          //แต่ถ้าlist ไม่ว่าง ให้ทำการเช็คอีกครั้ง
                if (tail.previous != null) {        // ถ้าข้างหน้า tail ไม่เท่ากับ null นั่นคือ มี node อยู่
                    tail.previous.next = null;      // ให้ให้ตัวต่อไปของตัวข้างหน้าtail เป็น null นั่นคือการลบ node tail
                    tail=tail.previous;             // แล้วจากนั้นก็ให้ tail = ตัวก่อนหน้า tail
                }else{       //ไม่มี node อยู่เลย 
                    tail=null;      // นั่นคือไม่มีหางlist
                    head=tail;      // จึงทำให้ head และ tail เท่ากัน
                }
                
            }
        }
        
        public void popFront(){ //ฟังก์ชันที่ลบตัวหน้าสุดของlist
            if (isEmpty()){     //ถ้าlistว่างให้แสดงว่า error
                System.out.println("ERROR"); 
            }else{               //แต่ถ้าlist ไม่ว่าง ให้ทำการเช็คอีกครั้ง
                if (head.next != null) {        // ถ้าตัวถัดไปของ head ไม่เท่ากับ null นั่นคือ มี node อยู่
                head.next.previous = null;      // ให้ตัวก่อนหน้าตัวถัดไป head  เป็น null นั่นคือการลบ node head
                head = head.next;               // แล้วจากนั้นก็  head = ตัวถัดไปของ head
                }else{           //ไม่มี node อยู่เลย
                    head=null;   // นั่นคือไม่มี head ของ list
                    tail=head;   // จึงทำให้ head และ tail เท่ากัน
                }
                
            }
        }
        
        public Node topFront(){ //ฟังก์ชันที่แสดงค่าของnode ตัวที่อยู่หน้าสุดของ list
            if (isEmpty()){     //ถ้าlistว่าง ให้แสดงว่า error
                System.out.println("ERROR");
                return new Node("Empty List!");     //สร้างnodeใหม่ แสดงข้อความ
            } else {     //แต่ถ้าlist ไม่ว่างให้ แสดง head
            return head;
            }
        }
        
        public Node topBack(){  //ฟังก์ชันที่แสดงค่าของnode ตัวที่อยู่หลังสุดของ list
            if (isEmpty()){     //ถ้าlistว่าง ให้แสดงว่า error
                System.out.println("ERROR");
                return new Node("Empty List!");     //สร้างnodeใหม่ แสดงข้อความ
            } else {      //แต่ถ้าlist ไม่ว่างให้ แสดง tail
                return tail;
            }
        }
        
        public void pushFront(Node node){ //ฟังก์ชันที่นำ node มาเติมข้างหน้าสุดของ list
            if (isEmpty()){       //ถ้าlistว่าง ให้ head , tail มีค่าเท่ากับ node
                head=node;
                tail=node;
            }else{               // แต่ถ้าlist ไม่ว่าง นั่นคือ มี node อยู่
                node.next=head;         // ให้ตัวถัดไปของ node เป็น  head 
                head.previous=node;     // ให้ตัวก่อนหน้าของของ head เป็น node
                node.previous=null;     // ให้ตัวก่อนหน้า node เป็น  null
                head=node;              // ได้ head ที่เป็น node ที่เติม
            }
        }
        
        public void pushBack(Node node) {   //ฟังก์ชันที่นำ node มาต่อท้าย list
            if (isEmpty()) {    //ถ้าlistว่าง ให้ head , tail มีค่าเท่ากับ node
                head=node;
                tail=node;
            } else {            // แต่ถ้าlist ไม่ว่าง นั่นคือ มี node อยู่
                tail.next=node;         // ให้ตัวถัดไปของ tail เป็น node
                node.previous=tail;     // ให้ตัวก่อนหน้าของของ node เป็น tail
                node.next=null;         // ให้ตัวถัดไปของ node เป็น  null
                tail=node;              // ได้ tail ที่เป็น  node ที่มาต่อท้าย
            }
        }
    
        public Node findNode(int id){   //ฟังก์ชั่นแสดงnode ที่มีค่า student_id = id
            if (isEmpty()){      //ถ้า list ว่าง สร้างnodeใหม่ แสดงข้อความ
                return new Node("Empty List!"); 
            } else {        // แต่ถ้าlist ไม่ว่าง นั่นคือ มี node อยู่
                Node find = this.head;      // กำหนด node ที่ใช้หา โดยเริ่มต้นที่ head
                while(find!=null){          // ถ้าfind ยังไม่เท่ากับ null ให้วนลูปไปเรื่อยๆ
                    if(find.student_id==id){    // ถ้า id ตรงกัน ให้ แสดง id ,name , gpa 
                        return new Node(id,find.name,find.gpa);
                    }
                    find=find.next;     // ให้เป็น node ถัดไป  
                }
                
                    return new Node("Student Not Found!");  // หา node นั้นไม่เจอ
        
            }
        }
        
        public Node eraseNode(int id){      //ฟังก์ชันที่ลบ node ที่ต้องการ
            if (isEmpty()){     //ถ้าlistว่าง ให้แสดงว่า error
                System.out.println("ERROR");
                return new Node("Empty List!");         //สร้างnodeใหม่ แสดงข้อความ
            } else {         // แต่ถ้าlist ไม่ว่าง นั่นคือ มี node อยู่
                Node find = head;       //สร้าง node ที่มีค่าเริ่มต้นเป็น head
                Node keep = head;       //สร้าง node ที่มีค่าเริ่มต้นเป็น head
                    if(find.student_id==id){    //ถ้าid ที่ต้องการหา มีค่า เท่ากับ id ของ head
                        head = head.next;       // ให้ Head เท่ากับ node ถัดไป
                        if (head != null) {     // และถ้า head มี  node อยู่
                        head.previous = null;   // ให้node หน้า head เป็น null
                    }
                        return keep;  //แสดงค่า keep
                    }else{                      // แต่ถ้าid ที่ต้องการหา มีค่าไม่เท่ากับ id ของ  head
                        while (find.next != null) {     // ถ้าตัวถัดไปของ find ยังไม่เท่ากับ null ให้วนลูป
                        if (find.next.student_id == id) {       //ถ้าid ตัวถัดไปของ find มีค่า เท่ากับ id 
                            keep = find.next;                   // เก็บค่า ตัวถัดไปของ find 
                            find.next = find.next.next;         //ให้ ตัวถัดไปของ find เท่ากับตัว ถัดไปอีก
                            if (find.next != null) {            // ถ้าตัวถัดไปของ find ไม่เท่ากับ null
                                find.next.previous = find;      // แล้วก็ให้ตัวก่อนหน้าของ ตัวถัดไปของ find = find 
                            }
                            return keep;    // แสดง  keep
                        }
                        find = find.next; // เลื่อนไปเรื่อยๆ
                    }
                }
                return new Node("Student Not Found!");      // หา node นั้นไม่เจอ
            }
        }
        
        public void addNodeAfter(Node node1, Node node2){   //ฟังก์ชันที่นำ node2 ไปแทรกด้านหลัง  node1
            Node current=head;      //สร้าง node ใหม่ ให้ค่าเท่ากับ head
            while(current.student_id!=node1.student_id){     // ถ้า id current ยังไม่เท่ากับ id node1 ให้วนลูปไปเรื่อยๆ
                current=current.next;   //เลื่อน node
            }
            node2.next=current.next;  // เมื่อพบก็ให้ ตัวถัดไปของ node2 เท่ากับ ตัวถัดไปของ current
            if(current.next != null){   //ถ้าตัวถัดไปของ current ไม่เท่ากับnull  ให้ตัวก่อนหน้าของตัวนี้ เท่ากับ node 2
                current.next.previous=node2;    
            }
            node2.previous=current;     // ตัวก่อนหน้าของ node 2 = current
            current.next=node2;         // ตัวถัดไปของ current = node 2 
        }
            
        public void addNodeBefore(Node node1, Node node2){      // ฟังก์ชันที่นำ node2 ไปแทรกด้านหน้า  node1
            if(node1.student_id == head.student_id) {           // ถ้า id node1 = id head
                node2.next = node1;                             // ให้ ตัวถัดไปของ node2 = node 1 
                head = node2;                                   // ให้ head = node 2
                head.previous=null;                             
            }else{  //กรณีอื่น
                Node current = head;        //สร้าง node ใหม่ ให้ค่าเท่ากับ head
                while(current.next.student_id!=node1.student_id){   // ถ้า id ตัวถัดไปของตัวถัดไป current ยังไม่เท่ากับ id node1 ให้วนลูปไปเรื่อยๆ
                         current=current.next;                      //เลื่อน node
                    }
                node2.next=current.next;                            // เมื่อพบก็ให้ ตัวถัดไปของ node2 เท่ากับ ตัวถัดไปของ current
                if(current.next != null){                           //ถ้าตัวถัดไปของ current ไม่เท่ากับ null  ให้ตัวก่อนหน้าของตัวนี้ เท่ากับ node 2
                     current.next.previous=node2;
                }
                node2.previous=current;                             // ตัวก่อนหน้าของ node 2 = current
                current.next=node2;                                  // ถ้าตัวถัดไปของ current = node 2 
        }
            }
    
        
        
        public boolean isEmpty(){ //ฟังก์ชันที่บอกว่าlist นี้ว่างหรือไม่
            return head==null;
        }
     
        public void merge(DoublyLinkedList list){ //ฟังก์ชันที่รวม 2 list
            if (isEmpty()) {    //ถ้าว่างให้เหมือนเดิม
                head = list.head;
                tail = list.tail;
            } else {   //แต่ถ้าไม่ว่างให้ สร้าง node ใหม่  เพื่อ รองรับค่า head , tail
                Node first = head;          //ตัวแรก คือ head ของ list แรก
                Node last = list.tail;      //ตัวท้าย คือ tail ของ List ที่มาต่อ
                while (first.next != null) {    // วนลูปจนกว่า ตัวถัดไปของ first จะไม่เท่ากับ null
                    first = first.next;         // เลื่อน node
                }
                first.next = list.head;     // กำหนดตัวท้าย
               
            }
        }
        
        public void printStructure(){   //ฟังก์ชันแสดงสถานะข้อมูลของ list
            Node current = head;
            System.out.print(listName+": head <->"); 
            while(current!=null){       //  วนลูปจนกว่าจะหมด list
                 System.out.print(" {"+current.student_id+"} <->");
                 current=current.next;
            }
             System.out.print(" tail\n");
        }
        
        // This may be useful for you for implementing printStructure()
        public void printStructureBackward(){ 
            Node current=tail;
            System.out.print(listName + ": tail <-> ");
            while(current!=null){
                System.out.print("{" + current.student_id + "} <-> ");
                current = current.previous;
            }
            System.out.println("head");
        }
        
        public Node whoGotHighestGPA(){     //ฟังก์ชันหา node ที่มี่ GPA สูงสุด
            if (isEmpty()) {       //ถ้า list ว่าง ให้ แสดงข้อความ
                 return new Node("Empty List!");
            } else {    //แต่ถ้าไม่ว่าง
                 Node high=head;       //สร้าง node ใหม่
                 Node order=head;
                 while(order!=null){    // วนลูปจนหมด list
                    if(high.gpa<=order.gpa){    //ถ้า gpa high น้อยกว่า gpa order ให้  high = order
                        high=order;
                    }
                    order=order.next;       // เลื่อน node
                
                 }  
                return high;        //ส่ง node ที่ gpa สูงสุดออกไป
            }
        }
    }
    