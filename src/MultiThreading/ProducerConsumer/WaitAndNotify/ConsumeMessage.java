package MultiThreading.ProducerConsumer.WaitAndNotify;

import java.util.Queue;
import java.util.concurrent.BlockingQueue;

public class ConsumeMessage {

    boolean isEmpty = true;
    Queue<Integer> queue;
    int size;

    public ConsumeMessage(Queue<Integer> queue, int size) {
        this.queue = queue;
        this.size = size;
    }


    public synchronized void consume(){

        if(queue.isEmpty()){
            System.out.println("queue is empty");
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("message consumed : " + queue.poll());
        notify();
        /*System.out.println("queue size" + queue.size());
        while(!queue.isEmpty()){
            try {
                System.out.println("message consumed : " + queue.take());
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }*/

    }
}
