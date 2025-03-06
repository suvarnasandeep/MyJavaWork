package DataStructureAlgorithm.Stack;

public class CircularQueueImplUsingArray {

    private int [] arr;
    private  int size;
    private int front, rear;

    public CircularQueueImplUsingArray(int size) {
        this.size = size;
        arr = new int[size];
        front = -1;
        rear = -1;
    }

    public boolean isFull(){
        if( front == 0 && rear == size-1){
            return  true;
        }

        if(rear == front-1){
            return true;
        }
        return  false;
    }

    public boolean isEmpty(){
        return front == -1;
    }

    public void enQueue(int data){
        if(isFull()){
            System.out.println("Queue is full");
        } else {
            if(front == -1){
                front = 0;
            }

            rear = (rear + 1)%size;
            arr[rear] = data;
        }
    }

    public void deQueue(){
        if(isEmpty()){
            System.out.println("Queue is empty");
        } else {
            System.out.println(arr[front]);

            front = (front+1)%size;
        }
    }

    //neet to correct the logic
    public void printQueue(){
        System.out.print("[ ");
        for(int i = front; i != rear; i=(i+1)%size){
            System.out.print(arr[i] + " ");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        CircularQueueImplUsingArray circularQueue = new CircularQueueImplUsingArray(4);

        circularQueue.enQueue(1);
        circularQueue.enQueue(2);
        circularQueue.enQueue(3);
        circularQueue.enQueue(4);
        circularQueue.enQueue(5);

        circularQueue.printQueue();

        circularQueue.deQueue();
        circularQueue.deQueue();

        circularQueue.printQueue();

        circularQueue.enQueue(10);
        circularQueue.printQueue();
    }
}
