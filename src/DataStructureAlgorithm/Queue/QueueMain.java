package DataStructureAlgorithm.Queue;

import DataStructureAlgorithm.Queue.circularQueue.CircularQueue;
import DataStructureAlgorithm.Queue.simpleQueue.Queue;

public class QueueMain {

    public static void main(String[] args) {

        //testSimpleQueue();

        testCircularQueue();

    }

    private static void testCircularQueue() {

        CircularQueue circularQueue = new CircularQueue(4);

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

    private static void testSimpleQueue(){
        //simple queue
        Queue queue = new Queue(5);

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
