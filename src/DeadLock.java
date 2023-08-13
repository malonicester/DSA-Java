class Common {
    static boolean isPrinterAvailable = false;
    static boolean isDvdWriterAvailable = false;

    synchronized void occupyPrinter(Common c2) {
//		Printer is not available so wait for it to get free
        if (!isPrinterAvailable) {
            try {
//                notify();
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
//		You are here means printer is available
//		Use printer for 1000ms
        System.out.println("Printer is occupied by " + Thread.currentThread().getName());
        try {
            Thread.sleep(1000); // Using the printer for 1000ms
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        isPrinterAvailable = true;
        c2.occupyDVDWriter(this);
        notify();
    }

    synchronized void occupyDVDWriter(Common c1) {
        if (!isDvdWriterAvailable) {
            try {
//                notify();
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("DVD Writer is Occupied by  " + Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        isDvdWriterAvailable = true;
        c1.occupyPrinter(this);
        notify();
    }

}

class RunOne implements Runnable {
    Common c1, c2;

    public RunOne(Common c1, Common c2) {
        this.c1 = c1;
        this.c2 = c2;
    }

    @Override
    public void run() {
        c1.occupyPrinter(c2);
        c2.occupyDVDWriter(c1);
    }

}

class RunTwo implements Runnable {
    Common c1, c2;

    public RunTwo(Common c1, Common c2) {
        this.c1 = c1;
        this.c2 = c2;
    }

    @Override
    public void run() {
        c2.occupyDVDWriter(c1);
        c1.occupyPrinter(c2);
    }

}

public class DeadLock {
    public static void main(String[] args) {
        Common c1 = new Common();
        Common c2 = new Common();

        RunOne one = new RunOne(c1, c2);
        RunTwo two = new RunTwo(c1, c2);

        Thread t1 = new Thread(one);
        Thread t2 = new Thread(two);

        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Bye Bye Main");
    }
}

