package thread;

public class ThreadEx21 {
    public static void main(String[] args) {
        RunnableEx21 r = new RunnableEx21();
        new Thread(r).start();
        new Thread(r).start();
    }
}

class Account {
    private int balance = 1000;

    public int getBalance() {
        return balance;
    }

    public void withdraw(int money) {
        if (balance >= money) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ignored) {
            }
            balance -= money;
        }
    }
}

class RunnableEx21 implements Runnable {

    @Override
    public void run() {
        Account acc = new Account();
        while (acc.getBalance() > 0) {
            int money = (int) (Math.random() * 3 + 1) * 100;
            acc.withdraw(money);
            System.out.println("balance:"+acc.getBalance());
        }
    }
}
