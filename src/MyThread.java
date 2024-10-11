public class MyThread extends  Thread{
    @Override
    public void run(){
        for(int i = 1; i<1000; i++){
//            try {
//                Thread.sleep(10); // pose for given time.
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
            System.out.println(i);
//            Thread.yield(); // give chances to another Thread.
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        t1.start(); // Thread Start.
        t2.start();
    //    t1.interrupt();
    //    t1.setDaemon(true);
        for(int i = 0; i<100; i++){
            System.out.println("Hello");
        }
    //    t2.join(); // wait for, end the work to current Thread.
        System.out.println("Thread end");
    }

}
