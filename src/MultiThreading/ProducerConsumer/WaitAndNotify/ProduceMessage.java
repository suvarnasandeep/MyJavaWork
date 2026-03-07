package MultiThreading.ProducerConsumer.WaitAndNotify;

import java.util.Queue;
import java.util.concurrent.BlockingQueue;

public class ProduceMessage {

    boolean isEmpty = true;
    Queue<Integer> queue;
    int size;

    public ProduceMessage(Queue<Integer> queue, int size) {
        this.queue = queue;
        this.size = size;
    }

    public synchronized void produce(int i){
        if(queue.size() == size){
            System.out.println("queue is full");
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        queue.add(i);
        System.out.println("message produced : " + i);
        notifyAll();

        /*for(int i=0; i<15; i++){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("added : " + i);
            queue.add(i);
        }*/
        //System.out.println("message produced");
    }
}
