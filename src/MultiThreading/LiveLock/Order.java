package LiveLock;

public class Order {

    private boolean isShipped = false;

    public void shipOrder(Customer customer) throws InterruptedException {
        while(!customer.isPaid()){
            System.out.println("Waiting for payment...!!!");
            Thread.sleep(3000);
        }

        System.out.println("payment succesfull.... shipping order...!!!");
        customer.setPaid(true);
    }

    public boolean isShipped() {
        return isShipped;
    }

    public void setShipped(boolean shipped) {
        isShipped = shipped;
    }
}
