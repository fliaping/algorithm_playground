import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
public class BlockingQueueImpl {
    BlockingQueue<String> buff = new ArrayBlockingQueue<>(10);

        class Producer implements Runnable {
            int id = 0;
            @Override
            public void run() {
                String threadName = Thread.currentThread().getName();
                while (true) {
                    String name = threadName + ", " + id++;
                    try {
                        buff.put(name);
                        System.out.println("生产者" + threadName + ", 生产数据：" + name);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        class Consumer implements Runnable {

            @Override
            public void run() {
                String threadName = Thread.currentThread().getName();
                while (true) {
                    try {
                        String name = buff.take();
                        System.out.println("消费者：" + threadName + ",消费数据：" + name);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        public void start() {
            for (int i = 0; i < 10; i++) {
                new Thread(new Producer()).start();
                new Thread(new Consumer()).start();
            }
        }

        public static void main(String[] args) {
            new BlockingQueueImpl().start();
        }
}