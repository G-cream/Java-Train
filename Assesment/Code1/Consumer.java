import java.util.concurrent.BlockingQueue;

class Worker implements Runnable {
    protected BlockingQueue<Order> queue;

    Worker(BlockingQueue<Order> theQueue) {
        this.queue = theQueue;
    }

    public void run() {
        try {
            while (true) {
            	Order obj = queue.take();
                System.out.println("Consumed resource - Queue size now = "
                        + queue.size());
                take(obj);
                //Fulfill the order and print the state
                obj.state = 1;
                System.out.println("FulFill Order " + obj.id);
            }
        } catch (InterruptedException ex) {
            System.out.println("CONSUMER INTERRUPTED");
        }
    }

    void take(Order obj) {
        try {
            Thread.sleep(1000); // simulate time passing
        } catch (InterruptedException ex) {
            System.out.println("Consumer Read INTERRUPTED");
        }
    }
}