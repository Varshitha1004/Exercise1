public class FacadeDesignPattern {  // This is the main class, and the file name must be FacadeDesignPattern.java
    public static void main(String[] args) {
        OrderFacade orderFacade = new OrderFacade();
        orderFacade.placeOrder("Laptop", "Credit Card");
    }
}

// InventoryService.java equivalent
class InventoryService {
    public boolean checkStock(String item) {
        System.out.println("Checking stock for " + item);
        return true;
    }
}

// PaymentService.java equivalent
class PaymentService {
    public boolean processPayment(String paymentDetails) {
        System.out.println("Processing payment for " + paymentDetails);
        return true;
    }
}

// ShippingService.java equivalent
class ShippingService {
    public void shipItem(String item) {
        System.out.println("Shipping " + item);
    }
}

// OrderFacade.java equivalent
class OrderFacade {
    private InventoryService inventoryService;
    private PaymentService paymentService;
    private ShippingService shippingService;

    public OrderFacade() {
        inventoryService = new InventoryService();
        paymentService = new PaymentService();
        shippingService = new ShippingService();
    }

    public void placeOrder(String item, String paymentDetails) {
        System.out.println("Placing order for " + item);

        if (inventoryService.checkStock(item)) {
            if (paymentService.processPayment(paymentDetails)) {
                shippingService.shipItem(item);
                System.out.println("Order placed successfully!");
            } else {
                System.out.println("Payment failed.");
            }
        } else {
            System.out.println("Item is out of stock.");
        }
    }
}
