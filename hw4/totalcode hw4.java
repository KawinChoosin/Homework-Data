public class Node {
    int shares;
    double price;
    Node next;
    public Node(int shares, double price){
        this.shares = shares;
        this.price = price;
    }//จะเป็นการสร้างNode ที่บันทึกค่าของsharesเเละpriceไว้
}


interface List {
    public void push(Node node);
    public void pop();
    public Node top();
}//เป็นlistของฟังก์ชันที่จะใช้







public class Stack implements List{
    // Implement Stack using Linked List without tail
    Node head;
    
    public void push(Node node){
        if (head == null){
            head=node;
        }else{
            node.next=head;
            head=node;
        }
    }//เป็นการเช็คว่าheadว่างมั้ย หากว่างให้headชี้ที่node หากไม่ว่างหมายความว่ามีnodeอยู่เเล้ว จึงให้nodeที่pushเข้ามาชี้ที่nodeที่headชี้อยู่ เเล้วจึงเปลี่ยนให้headมาชี้ที่node
    public void pop(){
        // Fix this function
        if (head!=null){
            head=head.next;
        }else{
            System.out.println("Error: Stack Underflow");
        }
    }//เป็นการนำข้อมูลบนสุดของstackออก โดยจะเช็คว่าlistมีnodeหรือไม่ หากมีจะให้headไปชี้ที่nodeก่อนหน้าnodeสุดท้าย ซึ่งก็คือลบค่าสุดท้ายออกไป เเต่หากlistนี้ว่างจะสั่งให้print errorออกไปแทน
    
    public Node top(){
        // Fix this
        return head;
    }//เป็นการส่งค่าล่าสุดของstackออกไป
    
}









public class Queue implements List{
    // Implement Queue using Linked List with tail
    Node head;
    Node tail;
    
    public void push(Node node){
        if (head == null){
            head=node;
            tail=node;
        }else{
            tail.next=node;
            tail=node;
        }
    }//เป็นการเพิ่มnodeเข้าไปในqueue โดยจะเช็คก่อนว่าheadว่างหรือไม่
//  หรือก็คือเช็คว่าlistนี้มีข้อมูลหรือไม่ หากไม่จะให้headเเละtailชี้ที่node
//  ใหม่ที่pushไป เเต่ถ้าไม่ว่างจะให้ตัวสุดท้ายของlistนี้ชี้ไปที่nodeที่push
//  ไปใหม่ เเล้วให้tailชี้ที่nodeใหม่เเทน
    
    public void pop(){
        if (head != null){
            if (head != tail){
                head=head.next;
            }else{
                head=null;
                tail=null;
            }
        }else{
            System.out.println("Error: Queue Underflow");
        }
    }//จะเป็นการนำnodeหน้าสุดของqueueออก โดยจะเช็คก่อนว่าlistว่างมั้ย หากว่างจะprint error
    //เเต่ถ้าไม่ว่างจะเช็คต่อว่ามีnodeมากกว่า1nodeมั้ย หากมากกว่าจะให้headชี้ไปที่nodeถัดไปเเทน
    //เเต่หากมีnodeเพียงnodeเดียว จะให้headเเละtailชี้ที่nullเเทน
    
    public Node top(){
        return head;
    }//เป็นการส่งค่าเเรกของqueueออกมา
    
}








public class Stock {
    private List list;
    private int totalShares;
    
    public Stock(String costBasis){
        switch (costBasis) {
            case "FIFO":
                list = new Queue();
                break;
            case "LIFO":
                list = new Stack();
                break;
            default:
                System.out.println("Invalid cost basis. Choose FIFO or LIFO");
                break;
        }
    }//จะเป็นการcheck case ว่าเป็นLIFOหรือFIFO แล้วจึงจะสร้างlistขึ้นมาให้ตรงประเภทของข้อมูล
    
    public void buy(int boughtShares, double boughtPrice){
        // Complete this code
        // Something is missing here
        list.push(new Node(boughtShares,boughtPrice));
        totalShares += boughtShares;
    }//เป็นการpush จำนวนหุ้นที่ซื้อกับราคาต่อหุ้นไปในlist เเล้วจะรวมจำนวนหุ้นทั้งหมดไว้ในtotalShares
    
    public void sell(int soldShares, double soldPrice){
        if (soldShares <= totalShares){//เช็คว่าจำนวนหุ้นที่จะขายยังคงน้อยกว่าจำนวนหุ้นทั้งหมด
            double realizedGain = 0.0;
            double unrealizedGain = 0.0;
            
            while(list.top() != null && soldShares>0){//เป็นการloopโดยเช็คว่าlistต้องไม่ว่างเเละหุ้นที่ขายต้องมากกว่า0
                if(soldShares>=list.top().shares){
                    soldShares -= list.top().shares;
                    realizedGain += (soldPrice-list.top().price)*list.top().shares;
                    totalShares-=soldShares;
                    list.pop();
                    //ส่วนนี้จะเช็คว่าจำนวนหุ้นที่ขายต้องไม่ต่ำกว่าจำนวนหุ้นในlistชุดเเรก จากนั้นเปลี่ยนค่าจำนวนหุ้นที่ขาย
                    //โดยหักจากจำนวนหุ้นในlistชุดเเรก เเล้วคำนวณราคาที่ได้จากการขายหุ้นชุดเเรกโดยอิงราคาตามราคา
                    //หุ้นปัจจุบันเทียบกับราคาที่ซื้อมาว่าได้กำไรหรือขาดทุน เเล้วนำไปรวมกับราคาขายที่ได้ก่อนหน้า จากนั้น
		            //เปลี่ยนค่าหุ้นรวมทั้งหมดโดยหักจากจำนวนที่ขาย แล้วpopค่าออก 
                }else{
                    list.top().shares -= soldShares;
                    realizedGain += (soldPrice-list.top().price)*soldShares;
                    totalShares-=soldShares;
                    soldShares = 0;
                    //ถ้าหุ้นที่จะขายต่ำกว่าหุ้นในlistชุดเเรกเเล้ว ให้เปลี่ยนจำนวนหุ้นในlistโดยหักจากหุ้นที่จะขายเเทน จากนั้น
                    //ก็คำนวณราคาที่ได้จากการขายครั้งนี้เเล้วนำไปรวมกับราคาขายที่ได้ก่อนหน้า เเล้วเปลี่ยนจำนวนหุ้นรวมโดยหัก
                    //จากหุ้นที่จะขาย เเล้วเปลี่ยนค่าหุ้นที่จะขายเป็น0
                }
            }
            Node current=list.top();
            while(current!=null){
                unrealizedGain += (soldPrice-current.price)*current.shares;
                current=current.next;
            } //จะเป็นการคำนวณราคาหุ้นที่ไม่ได้ขายไปว่าได้กำไรหรือขาดทุนเท่าไร กับราคาหุ้นในตอนนี้
            
            System.out.println("Realized P/L = " + realizedGain + " Unrealized P/L = " + unrealizedGain);
            //จะเป็นการprintราคาของหุ้นที่ขายเเละไม่ขายว่าได้กำไรหรือขาดทุนเท่าไร
        }else{//ถ้าจำนวนหุ้นที่จะขายมากกว่าหุ้นที่มีจะpritn sell command rejected
            System.out.println("Sell command rejected");
        }
    }
    
    public void showList(){
        Node currentNode = list.top();
        System.out.print("head -> ");
        while (currentNode!=null){
            System.out.print("[" + currentNode.shares + "@" + currentNode.price + "B] -> ");
            currentNode = currentNode.next;
        }
        System.out.println("tail");
    }
}