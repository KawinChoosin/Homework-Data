public class DoublyLinkedList {
    Node head;
    Node tail;
    String listName;
    
    public DoublyLinkedList(String name){
        listName=name;
    }
    
    
    public void popBack() {
      if (isEmpty()){
            System.out.println("ERROR");
        }else{
            if (tail.previous != null) {
                tail.previous.next = null;
                tail=tail.previous;
            }else{
                tail=null;
                head=tail;
            }
            
        }
    }
    
    public void popFront(){
        if (isEmpty()){
            System.out.println("ERROR"); 
        }else{
            if (head.next != null) {
            head.next.previous = null;
            head = head.next;
            }else{
                head=null;
                tail=head;
            }
            
        }
    }
    
    public Node topFront(){
        if (isEmpty()){
            System.out.println("ERROR");
            return new Node("Empty List!");
        } else {
            return head;
        }
    }
    
    public Node topBack(){
        if (isEmpty()){
            System.out.println("ERROR");
            return new Node("Empty List!");
        } else {
            return tail;
        }
    }
    
    public void pushFront(Node node){
        if (isEmpty()){
            head=node;
            tail=node;
        }else{
            node.next=head;
            head.previous=node;
            node.previous=null;
            head=node;
        }
    }
    
    public void pushBack(Node node) {
        if (isEmpty()) {
            head=node;
            tail=node;
        } else {
            tail.next=node;
            node.previous=tail;
            node.next=null;
            tail=node;
        }
    }

    public Node findNode(int id){
        if (isEmpty()){
            return new Node("Empty List!");
        } else {
            Node find = this.head;
            while(find!=null){
                if(find.student_id==id){
                    return new Node(id,find.name,find.gpa);
                }
                find=find.next;
            }
            
                return new Node("Student Not Found!");
    
        }
    }
    
    public Node eraseNode(int id){
        if (isEmpty()){
            System.out.println("ERROR");
            return new Node("Empty List!");
        } else {
            Node find = head;
            Node keep = head;
                if(find.student_id==id){
                    head = head.next;
                    if (head != null) {
                    head.previous = null;
                }
                    return keep;
                }else{
                    while (find.next != null) { 
                    if (find.next.student_id == id) {
                        keep = find.next;
                        find.next = find.next.next;
                        if (find.next != null) {
                            find.next.previous = find;
                        }
                        return keep;
                    }
                    find = find.next;
                }
            }
            return new Node("Student Not Found!");
        }
    }
    
    public void addNodeAfter(Node node1, Node node2){
        Node current=head;
        while(current.student_id!=node1.student_id){
            current=current.next;
        }
        node2.next=current.next;
        if(current.next != null){
            current.next.previous=node2;
        }
        node2.previous=current;
        current.next=node2;
    }
    
    public void addNodeBefore(Node node1, Node node2){
        if(node1.student_id == head.student_id) {
            node2.next = node1;
            head = node2;   
            head.previous=null;
        }else{
            Node current = head;
            while(current.next.student_id!=node1.student_id){
                     current=current.next;
                }
            node2.next=current.next;
            if(current.next != null){
                 current.next.previous=node2;
            }
            node2.previous=current;
            current.next=node2;
        }

    }
    
    public boolean isEmpty(){
        return head==null;
    }
    public void merge(DoublyLinkedList list){
        if (isEmpty()) {
            head = list.head;
            tail = list.tail;
        } else {
            Node first = head;
            Node last = list.tail;
            while (first.next != null) {
                first = first.next;
            }
            first.next = list.head;
           
        }
    }
    
    public void printStructure(){
        Node current = head;
        System.out.print(listName+": head <->");
        while(current!=null){
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
    
    public Node whoGotHighestGPA(){
        if (isEmpty()) {
             return new Node("Empty List!");
        } else {
             Node high=head;
             Node order=head;
             while(order!=null){
                if(high.gpa<=order.gpa){
                    high=order;
                }
                order=order.next;
            
             } 
            return high;
        }
    }
}