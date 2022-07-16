package LiveLock;

public class LivelockTestMain {

    public  static void main(String[] arg){

        Customer customer = new Customer();
        Order order = new Order();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    customer.payMoney(order);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run(){
                try {
                    order.shipOrder(customer);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();
    }
}
