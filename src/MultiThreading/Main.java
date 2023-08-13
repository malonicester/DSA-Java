package MultiThreading;

import java.util.ArrayList;
import java.util.List;


class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product [name=" + name + ", price=" + price + "]";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}

class ThreadDemo implements Runnable {
    List<Product> list;

    double total;
    public ThreadDemo(List<Product> list) {
        this.list = list;
    }

    public void run() {
        synchronized (list) {
            System.out.println(Thread.currentThread().getName()  + " In Execution");
            for (Product p : list) {
                total += p.getPrice();
            }
            System.out.println(Thread.currentThread().getName() + " Calculation done");
            list.notify();
            try {
                list.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Khatam Tata Bye Bye Gaya!");
            list.notify();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        List<Product> list = new ArrayList<>();
        list.add(new Product("prod1", 350));
        list.add(new Product("prod2", 550));
        list.add(new Product("prod3", 540));
        list.add(new Product("prod4", 670));
        list.add(new Product("prod5", 670));
        list.add(new Product("prod6", 560));
        list.add(new Product("prod7", 890));
        list.add(new Product("prod8", 850));
        list.add(new Product("prod9", 1000));
        list.add(new Product("prod10", 1250));

        ThreadDemo d1 = new ThreadDemo(list);
        Thread t1 = new Thread(d1);
        t1.setName("Masai");
        t1.start();
        synchronized (list) {
            try {
                list.wait();
                System.out.println(d1.total);
                list.notify();
                list.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Bye Bye");
    }
}
