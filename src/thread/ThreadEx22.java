package thread;

public class ThreadEx22 {
    public static void main(String[] args) {
        RunnableEx22 r = new RunnableEx22();
        new Thread(r).start();
        new Thread(r).start();
    }
}

class Accounts {
    private int balance = 1000;

    public int getBalance() {
        return balance;
    }

    public synchronized void withdraw(int money) {
        if (balance >= money) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ignored) {
            }
            balance -= money;
        }
    }
}

class RunnableEx22 implements Runnable {

    @Override
    public void run() {
        Accounts acc = new Accounts();
        while (acc.getBalance() > 0) {
            int money = (int) (Math.random() * 3 + 1) * 100;
            acc.withdraw(money);
            System.out.println("balance:"+acc.getBalance());
        }
    }
}


