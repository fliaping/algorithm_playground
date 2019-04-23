public class WaitNotifyImpl {

    String[] buff = new String[10];
    int index = -1;
    final Object lock = new Object();

    class Producer implements Runnable {
        int id = 0;

        @Override
        public void run() {
            String threadName = Thread.currentThread().getName();
            while (true) {
                synchronized (lock) {
                    while (index == buff.length - 1) {
                        try {
                            System.out.println("生产者：" + threadName + ", 缓存满了，等待");
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    String name = threadName + "：" + id;
                    buff[++index] = name;
                    System.out.println("生产数据：" + name + ", index:" + index);
                    lock.notify();
                }
                id++;
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
                synchronized (lock) {
                    while (index < 0) {
                        try {
                            System.out.println("消费者：" + threadName + ", 缓存空了，等待");
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("消费数据：" + buff[index] + ", index:" + index);
                    index--;
                    lock.notify();
                }

                try {
                    Thread.sleep(1000);
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
        new WaitNotifyImpl().start();
    }
}