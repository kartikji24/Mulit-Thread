import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAcount {
    private int balance = 100;
    private Lock lock = new ReentrantLock();

    public void withdraw(int amount) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + "Attempting to withdraw" + amount);
        try {
            if (lock.tryLock(3000, TimeUnit.MILLISECONDS)) {
                if (amount <= balance) {
                    try {
                        System.out.println(Thread.currentThread().getName() + "proceeding to withdraw" + amount);
                        Thread.sleep(5000);
                        balance -= amount;
                        System.out.println(Thread.currentThread().getName() + "completed the withdraw. Remaining amount" + balance);
                    } catch (Exception e) {
                    } finally {
                        lock.unlock();
                    }
                } else {
                    System.out.println(Thread.currentThread().getName() + "Insufficient");
                }

            } else {
                System.out.println(Thread.currentThread().getName() + " could not acquire");
            }
        }catch (Exception e){

        }
    }


}
