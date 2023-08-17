public class DynamicArray {
    private int[] arr;
    private int capacity;
    private int size; // Last element can be indexed at size-1
    
    public DynamicArray(int cap){ // Class Constructor
        arr = new int[cap];
        capacity = cap;
    }
    
    public void pushBack(int data){
        if(size==capacity){
            capacity *=2;
            int[] arr2 = new int[capacity];
            for(int i=0;i<size;i++){
                arr2[i]=arr[i];
            }
            arr=arr2;
        }
        size++;
        arr[size-1]=data;
    }

// ในส่วนนี้จะเป็นการเพิ่มdataไปเพิ่มข้างหลังarr โดยในifจะเป็นการเช็คว่าsizeของarrมีค่าเท่ากับcapของarrมั้ย 
// หากเท่ากันจะจองarrใหม่ที่มีขนาดมากกว่าเดิม2เท่า เพื่อลดจำนวนครั้งในการจองarr หลังจากนั้นจะใช่for loop 
// เพื่อcopy ข้อมูลจากarrเก่าไปในarrใหม่ที่มีขนาดใหญ่กว่าเดิม เเล้วจะส่งarrที่สร้างใหม่ไปเป็นตัวเเปรarr private 
// ด้านนอก ในตอนนี้เราจะได้arrที่มีขนาดใหญ่กว่าเดิมเเล้ว จากนั้นก็เพิ่มsizeครั้งละ1 เพื่อให้รู้ว่ามีข้อมูลเพิ่มมา
// เเละก็เปลี่ยนข้อมูลในตำเหน่งหลังสุดให้เป็นข้อมูลที่เราต้องการ

    public int popBack(){
        int caller=0;
        if(size==0){
            System.out.println("ERROR");
            return 0;
        }else{
            caller=arr[size-1];
            arr[size-1]=0;
            size--;
            return caller;
        }
        
    }
    
// ในส่วนนี้จะเป็นการpopข้อมูลออกมาคือเอาข้อมูลตัวสุดท้ายออกมา โดยในเงื่อนไขแรกคือตรวจสอบว่าarrนี้มีข้อมูลไหม 
// ถ้าไม่มีให้print ERRORออกมา แต่ถ้ามีข้อมูลจะ return ค่าค่าสุดท้ายออกมา แล้วลดsizeของarrลง

    public int get(int i){
        if(i < size && i>=0){
            return arr[i];
        }else{
            System.out.println("ERROR");
            return 0;
        }
    }
    
// ในส่วนนี้จะเป็นการgetข้อมูล คือการโชว์ข้อมูลตำแหน่งที่ i โดยในเงื่อนไขแรกคือตรวจสอบว่า i
// ที่ได้รับมามีค่ามากกว่าหรือเท่ากับ 0 เพราะว่า0คือตำเเหน่งแรกของarr เเละน้อยกว่าsize
// เพราะตัวสุดท้ายของarrคือsize-1 หากiอยู่ในเงื่อนไขจะ return ค่าที่ตำแหน่งนั้นออกมา 
// หากไม่อยู่จะprint ERRORออกมาเเทน

    public void set(int i, int value){
        if(i < size && i>=0){
            arr[i]=value;
        }else{
            System.out.println("ERROR");
        }
       
    }
    
//ในส่วนนี้จะมีเงื่อนไขตรวจสอบiเหมือนข้อก่อนหน้า หากถูกตามเงื่อนไข จะเปลี่ยนค่าที่ตำเเหน่งiเป็นvalue 
//หากไม่อยู่จะprint ERRORออกมาเเทน
    
    public void remove(int i){
        int k=0;
        int arr3[] = new int [size-1];
        if(i < size && i>=0){
                for(int j=0;j<size;j++){
                if(j!=i){
                arr3[k]=arr[j];
                k++;
                }else{
                    continue;
                }
            }
            arr=arr3;
            size--;
        }else{
            System.out.println("ERROR");
        }
        
    }
    
// ในส่วนนี้จะเป็นการลบarr[i] โดยจะสร้างarrใหม่ขึ้นมาที่มีขนาดsize-1เพราะจะมีตำแหน่ง 1 ตำแหน่ง
// ถูกลบออกไป หลังจากนั้นก็จะเช็ค i เเละprint ERRORเหมือนข้อก่อนหน้า โดยตัวแปรที่ใช้ในการเปลี่ยน
// ข้อมูลจะมี2ค่าคือkกับj โดยจะเริ่มต้นใช้for loopที่มีเงื่อนไขด้านในคือถ้าjไม่เท่ากับiแล้วจึงเปลี่ยนค่าarr
// ที่สร้างขึ้นใหม่เป็นarrเก่า แล้วเมื่อiเท่ากับjจะใช้continueเพื่อกลับไปที่for loopใหม่ 
// ซึ่งในตอนนั้นค่าjจะมากกว่าค่าkอยู่1 นั่นหมายความว่าในตอนที่เจอarrตำเเหน่งที่iเเล้วให้ข้ามตัวนั้นไป 
// แล้วจะได้arrที่ไม่มีค่าที่ตำเเหน่งi เปรียบได้กับลบค่านั้นไปเเล้วค่อยเซ็ทค่าarrเก่าเป็นarrใหม่ที่พึ่งสร้างไป 
// เเล้วเปลี่ยนค่าsizeให้ลดลง1ค่า
    
    public boolean isEmpty(){
        if(size==0){
            return true;
        }else{
            return false;
        }
        
    }
    
//ส่วนนี้จะเป็นการเช็คว่าsize=oมั้ย ถ้าใช่return true ไม่ใช่return false
    
    public int getSize(){
        return size;
    }
    
//จะเป็นส่วนที่เอาไว้return size
    
    public void printStructure(){
        // FIX THIS
        System.out.print("Size = " + size + ", Cap = " + capacity + ", arr = [ ");
        if(isEmpty()){
            System.out.print("]");
            System.out.println();
        }else{
            for(int i=0;i<size-1;i++){
                System.out.print(arr[i]+", ");
            }
            System.out.print(arr[size-1]+" ]");
            System.out.println();
        }
    }
}

// ในส่วนนี้จะเป็นส่วนที่เอาไว้โชว์ค่าโดยที่เพิ่มมาคือเงื่อนไขที่เอาไว้เช็คว่าarrนั้นมีข้อมูลหรือไม่ 
// ถ้าไม่มีก็จะปริ้นอีกแบบ ถ้ามีก็จะเป็นอีกแบบตา้ามีก็จะเป็นอีกแบบตามรูปเเบบโจทย์