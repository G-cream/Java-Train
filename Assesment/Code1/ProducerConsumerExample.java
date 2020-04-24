import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ProducerConsumerExample {
    public static void main(String[] args) throws InterruptedException {
        
        // Here we make the size of the queue be 5
        BlockingQueue<Order> myQueue = new LinkedBlockingQueue<Order>(5);

        new Thread(new Producer(myQueue)).start();

        new Thread(new Worker(myQueue)).start();

        // Let the simulation run for, say, 10 seconds
        Thread.sleep(10 * 1000);
    }
}