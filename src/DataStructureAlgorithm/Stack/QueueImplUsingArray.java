package DataStructureAlgorithm.Stack;

public class QueueImplUsingArray {

    private Integer[] arr;
    private int front;
    private int rear;
    private int size;

    public QueueImplUsingArray(int size) {
        this.size = size;
        arr = new Integer[size];
        front = -1;
        rear = -1;
    }

    public void enqueue(Integer data){
        if(isFull()){
            System.out.println("Queue is full");
        } else {
            if(front == -1){
                front = 0;
            }
            arr[++rear] = data;
        }
    }

    public void deQueue(){
        if (isEmpty()){
            System.out.println("Queue is empty");
        } else {
            int data = arr[front];
            System.out.println(data);
            if(front >= rear){
                front = -1;
                rear = -1;
            } else {
                front++;
            }
        }
    }

    private boolean isEmpty() {
        return front == -1;
    }

    private boolean isFull() {
        return rear  == size -1 && front == 0;
    }


    public void printQueue(){
        System.out.print("[ ");
        for(int i = front; i <= rear; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        QueueImplUsingArray queue = new QueueImplUsingArray(5);

        queue.enqueue(1);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(6);
        queue.enqueue(7);

        queue.printQueue();

        queue.deQueue();
        queue.deQueue();
        //queue.deQueue();
        queue.deQueue();

        queue.printQueue();
    }
}
