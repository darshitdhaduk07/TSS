class Q {
    int n;
    boolean valueSet = false;

    // Consumer method
    synchronized int get() {
        while (!valueSet) {
            try {
                wait(); // wait until producer puts value
            } catch (InterruptedException e) {
                System.out.println("InterruptedException caught");
            }
        }

        System.out.println("Got: " + n);
        valueSet = false;
        notify(); // notify producer
        return n;
    }

    // Producer method
    synchronized void put(int n) {
        while (valueSet) {
            try {
                wait(); // wait until consumer consumes value
            } catch (InterruptedException e) {
                System.out.println("InterruptedException caught");
            }
        }

        this.n = n;
        valueSet = true;
        System.out.println("Put: " + n);
        notify(); // notify consumer
    }
}

// Producer Thread
class Producer implements Runnable {
    Q q;

    Producer(Q q) {
        this.q = q;
        new Thread(this, "Producer").start();
    }

    public void run() {
        int i = 1;
        while (true) {
            q.put(i++);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {}
        }
    }
}

// Consumer Thread
class Consumer implements Runnable {
    Q q;

    Consumer(Q q) {
        this.q = q;
        new Thread(this, "Consumer").start();
    }

    public void run() {
        while (true) {
            q.get();
            try {
                Thread.sleep(800);
            } catch (InterruptedException e) {}
        }
    }
}

// Main class
public class PCFixed {
    public static void main(String[] args) {
        Q q = new Q();

        new Producer(q);
        new Consumer(q);

        System.out.println("Press Ctrl+C to stop.");
    }
}
