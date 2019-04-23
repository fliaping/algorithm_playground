import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class LockImpl {
    String[] buff = new String[10];
    int index = -1;

    ReentrantLock lock = new ReentrantLock();
    Condition notEmpty = lock.newCondition();
    Condition notFull = lock.newCondition();

    class Producer implements Runnable {
        int id = 0;

        @Override
        public void run() {
            String threadName = Thread.currentThread().getName();
            while (true) {
                lock.lock();
                try {
                    while (index == buff.length - 1) {
                        System.out.println("生产者：" + threadName + ", 缓存满了，等待");
                        notFull.await();
                    }
                    String name = threadName + "：" + id;
                    buff[++index] = name;
                    System.out.println("生产数据：" + name + ", index:" + index);
                    notEmpty.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
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
                lock.lock();
                try {
                    while (index < 0) {
                        System.out.println("消费者：" + threadName + ", 缓存空了，等待");
                        notEmpty.await();
                    }
                    System.out.println("消费数据：" + buff[index] + ", index:" + index);
                    index--;
                    notFull.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }

                try {
                    Thread.sleep(1002);
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
        new LockImpl().start();
    }
}