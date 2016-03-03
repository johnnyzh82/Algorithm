package MultiThread;
import java.util.Vector;

/**
 * Created by yunlong on 3/1/16.
 */
public class ProducerAndConsumer {
    public static void main(String args[]) {
        Producer producer = new Producer();
        producer.start();
        new Consumer(producer).start();
    }
}


class Producer extends Thread {
    static final int MAXQUEUE = 5;
    private Vector messages = new Vector();

    @Override
    public void run() {
        try {
            int i = 0;
            while (i < 30) {
                putMessage();
                i++;
                //sleep(5000);
            }
        } catch (InterruptedException e) {
        }
    }

    private synchronized void putMessage() throws InterruptedException {
        if (messages.size() == MAXQUEUE) {
            wait();
        }
        messages.addElement(new java.util.Date().toString());
        System.out.println("put message");
        notify();
        //Later, when the necessary event happens, the thread that is running it calls notify() from a block synchronized on the same object.
    }

    // Called by Consumer
    public synchronized String getMessage() throws InterruptedException {
        notify();
        if (messages.size() == 0) {
            wait();
            //By executing wait() from a synchronized block, a thread gives up its hold on the lock and goes to sleep.
        }
        String message = (String) messages.firstElement();
        messages.removeElement(message);
        return message;
    }
}

class Consumer extends Thread {
    Producer producer;
    Consumer(Producer p) {
        producer = p;
    }

    @Override
    public void run() {
        try {
            int i = 0;
            while (i < 30) {
                String message = producer.getMessage();
                System.out.println("Got message: " + message);
                i++;
                //sleep(200);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
