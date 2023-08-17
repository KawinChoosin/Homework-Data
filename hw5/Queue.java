public class Queue {
    Node[] arr; // circular array
    int capacity;
    int front;
    int back;
    int size;
    
    public Queue(int cap){
        arr=new Node[cap];
        capacity=cap;
    }
    
    public void enqueue(Node node){
        if (!isFull()){
            arr[back]=node;
            back++;
            back=back%capacity;
            size++;
            
        }else{
            System.out.println("Queue Overflow!!!");
        }
    }
    
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
    }
    
    public boolean isEmpty(){
        return size==0; // fix this
    }
    
    public boolean isFull(){
        return size==capacity; // fix this
    }
    
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
 
}