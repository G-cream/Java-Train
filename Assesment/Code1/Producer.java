import java.util.concurrent.BlockingQueue;

class Producer implements Runnable {
	
	public int ordernum;
	
    protected BlockingQueue<Order> queue;

    Producer(BlockingQueue<Order> theQueue) {
        this.ordernum = 0;
    	this.queue = theQueue;
    }

    public void run() {
        try {
            while (true) {
            	Order justProduced = getResource();
                queue.put(justProduced);
                System.out.println("Wating order " + justProduced.id);
                System.out.println("Produced resource - Queue size now = "
                        + queue.size());
            }
        } catch (InterruptedException ex) {
            System.out.println("Producer INTERRUPTED");
        }
    }

    Order getResource() {
        try {
            Thread.sleep(100); // simulate time passing during read
        } catch (InterruptedException ex) {
            System.out.println("Producer Read INTERRUPTED");
        }
        // return order with state New
        if(this.ordernum == 100) {
        	// if all the orders have been generated, exit the process
        	System.out.println("All the orders have been generated");
        	System.exit(0);
        } 
        ++this.ordernum;
        return new Order(this.ordernum, 0);      
    }
}