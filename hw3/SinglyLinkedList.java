public class SinglyLinkedList {
    Node head;
    String listName;
    
    public SinglyLinkedList(String name){
        listName=name;
    }
    
    public void popBack() {
        if (isEmpty()){
                System.out.println("ERROR");
        }else{
            Node current = head;
            if(current.next!=null){
            while(current.next.next!=null){
               current=current.next;
            }
            current.next=null;
            }else{
                head=null;
            }
        }
    }
    
    public void popFront(){
        if (isEmpty()){
                System.out.println("ERROR");
        }else{
                head=head.next;
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
            Node current = head;
            while(current.next!=null){
               current=current.next;
            }
            return current;
        }
    }
    
    public void pushFront(Node node){
        if (isEmpty()){
            head=node;
        }else{
            node.next=head;
            head=node; 
        }
    }
    
    public void pushBack(Node node) {
        if (isEmpty()){
            head=node;
        } else {
            Node current = head;
            while(current.next!=null){
               current=current.next;
            }
            current.next=node;
        }
    }

    public Node findNode(int id){
        if (isEmpty()){
            return new Node("Empty List!");
        } else {
            Node find = head;
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
                head=head.next;
                return keep;
    
            }else{
            while(find.next!=null){
                if(find.next.student_id==id){
                    keep=find.next;
                    find.next=find.next.next;
                    return keep;
                }
                find=find.next;
            }
            return new Node("Student Not Found!");
            }
            
        }
    }
    
    public void addNodeAfter(Node node1, Node node2){
        Node current=head;
        while(current.student_id!=node1.student_id){
            current=current.next;
        }
        node2.next=current.next;
        current.next=node2;
    }
    
    public void addNodeBefore(Node node1, Node node2){
        if(node1.student_id == head.student_id) {
            node2.next = node1;
            head = node2;   
        }else{
            Node current = head;
            while(current.next.student_id!=node1.student_id){
                     current=current.next;
                }
            node2.next=node1;
            current.next=node2;
        }
    }
    
    public boolean isEmpty(){
        return head==null;
    }
    public void merge(SinglyLinkedList list){
        if (isEmpty()) {
            head = list.head;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = list.head;
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