package LiveLock;

public class Customer {
    private boolean isPaid = false;

    public void payMoney(Order order) throws InterruptedException {
        while (!order.isShipped()){
            System.out.println("Waiting for shipped...!!!");
            Thread.sleep(2000);
        }

        System.out.println("Order paid...!!!");
        order.setShipped(true);
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }
}
