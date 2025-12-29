
class Main {
  public static void main(String[] args) {
     //  payment gateway here... stripe
    PaymentGateway stripePayments = new PaymentGateway(new Stripe());
    stripePayments.checkout("order1", "user1");

    // payment gateway .. razorPay

    PaymentGateway razorPayPayments = new PaymentGateway(new PaymentAdapterForRazorPay());
    razorPayPayments.checkout("order2", "user2");
  }
}

interface PaymentInterface {
  void pay(String orderId, String userId);
}

class PaymentGateway {
  public PaymentInterface paymentGateway;
  public PaymentGateway(PaymentInterface pay) {
    this.paymentGateway = pay;
  }

  public void checkout(String orderId, String userId) {
    paymentGateway.pay(orderId, userId);
  }
}

class PaymentAdapterForRazorPay implements PaymentInterface {
  private RazorPayAPI razorPay;
  PaymentAdapterForRazorPay() {
    this.razorPay = new RazorPayAPI();
  }

  public void pay(String orderId, String userId) {
    razorPay.makePayments(orderId, userId);
  }
}

class Stripe implements PaymentInterface {
  public void pay(String orderId, String userId) {
    System.out.println("Paid from stripe " + orderId + " " + userId);
  }
}

class RazorPayAPI {
  public void makePayments(String orderId, String userId) {
    System.out.println(" paid from razor pay. " + orderId + " " + userId);
  }
}
