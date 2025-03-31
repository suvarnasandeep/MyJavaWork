package LeetCode;

public class QueueImplUsingArray {
    int[] arr ;
    int start;
    int end;
    int curSize;
    int maxSize;

    public static void main(String[] args) {
        QueueImplUsingArray queue = new QueueImplUsingArray(5);
        queue.push(4);
        queue.push(14);
        queue.push(24);
        queue.push(34);
        queue.push(44);

        System.out.println(queue.top());
        System.out.println(queue.size());
        System.out.println(queue.pop());
        System.out.println(queue.top());
        System.out.println(queue.size());
    }

    QueueImplUsingArray(int queueSize){
        this.maxSize = queueSize;
        arr = new int[queueSize];
        start = end =  -1;
        curSize = 0;
    }

    public void push(int data){
        if(isFull()){
            System.out.println("queue is full");
            return;
        }

        if(end == -1){
            start=0;
            end=0;
        } else {
            end = end+1;
        }
        arr[end] = data;
        curSize++;
    }

    public int pop(){
        if (isEmpty()){
            System.out.println("queue is empty");
            return -1;
        }
        int pop = arr[start];

        if (curSize == 1){
            start=-1;
            end=-1;
        } else {
            start = start+1;
        }

        curSize--;
        return pop;
    }

    public int top(){
        if (isEmpty()){
            System.out.println("queue is empty");
            return -1;
        }
        return arr[start];
    }

    public int size(){
        return curSize;
    }

    public boolean isFull(){
        return curSize == maxSize;
    }

    public boolean isEmpty(){
        return start == -1;
    }
}
