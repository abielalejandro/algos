package com.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;

public class CounterPrimes {

    class Counter implements Runnable {
        private final int page;
        private final int limit;
        public final static AtomicLong total = new AtomicLong(0);

        public Counter(int page, int limit) {
            this.page = page;
            this.limit = limit;
        }

        private void count() {
            int start = ((page - 1) * limit) + 1;
            int end = (page * limit);

            for (; start <= end; start++) {
                if (isPrime(start)) {
                    total.incrementAndGet();
                }
            }
        }

        private boolean isPrime(int number) {
            if (number <= 1) {
                return false;
            }

            for (int i = 2; i < number; i++) {
                if (number % i == 0) {
                    return false;
                }
            }
            return true;
        }

        @Override
        public void run() {
            count();
        }
    }

    private final int MAX_NUMBER;
    private final int NUM_OF_THREADS;

    public CounterPrimes(int numOfThreads, int maxNumber) {
        MAX_NUMBER = maxNumber;
        NUM_OF_THREADS = numOfThreads;
    }

    public int run(int number) {
        if (number <= 1)
            return 0;

        int range = (int) Math.ceil((double) number / NUM_OF_THREADS);
        ExecutorService executor = Executors.newFixedThreadPool(NUM_OF_THREADS);
        for (int t = 1; t <= NUM_OF_THREADS; t++) {
            executor.execute(new Counter(t, range));
        }

        executor.shutdown();

        while(!executor.isTerminated()) {}
        return Counter.total.intValue();
    }
}
