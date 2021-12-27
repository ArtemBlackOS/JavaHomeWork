package com.pb.IndiukhovA.hw13;

import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    public static class Manufacturer extends Thread {
        private final Object lock;
        private final Queue<String> someQueue;

        public Manufacturer(Object lock, Queue<String> someQueue) {
            this.lock = lock;
            this.someQueue = someQueue;
        }

        @Override
        public void run() {
            String someText = "";
            for (int i = 0; i < 50; i++) {

                if (someQueue.size() < 5) {
                    someText = someText + i;
                    synchronized (lock) {
                        someQueue.add(someText);
                        lock.notify();

                        if (someQueue.size() >= 5) {
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }
    }

    public static class Сonsumer extends Thread {
        private final Object lock;
        private final Queue<String> someQueue;

        public Сonsumer(Object lock, Queue<String> someQueue) {
            this.lock = lock;
            this.someQueue = someQueue;
        }

        @Override
        public void run() {
            String someText = "";

            while (true) {
                if (!someQueue.isEmpty()) {

                    synchronized (lock) {
                        System.out.println(someText);
                        someText = someQueue.remove();
                        lock.notify();

                        if (someQueue.isEmpty()) {
                            try {
                                lock.wait(2500);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }

                }
            }
        }
    }

    public static void main(String[] args) {
        Object lock = new Object();
        Queue<String> someQueue = new PriorityQueue<>();
        Manufacturer manufacturer = new Manufacturer(lock, someQueue);
        Сonsumer consumer = new Сonsumer(lock, someQueue);

        manufacturer.start();
        consumer.start();

        while (true) {
            if (!manufacturer.isAlive() && someQueue.isEmpty()) {
                System.exit(0);
            }
        }
    }
}
