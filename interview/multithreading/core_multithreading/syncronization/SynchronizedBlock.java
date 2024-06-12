package interview.multithreading.core_multithreading.syncronization;

public class SynchronizedBlock {
        private int count = 0;

        public void increment() {
            synchronized (this) {
                count++;
            }
        }

        public int getCount() {
            return count;
        }

        public static void main(String[] args) {
            SynchronizedBlock synchronizedBlock = new SynchronizedBlock();

            Runnable task = () -> {
                for (int i = 0; i < 1000; i++) {
                    synchronizedBlock.increment();
                }
            };

            Thread thread1 = new Thread(task);
            Thread thread2 = new Thread(task);

            thread1.start();
            thread2.start();

            try {
                thread1.join();
                thread2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(STR."Final count: \{synchronizedBlock.getCount()}");
        }


}
