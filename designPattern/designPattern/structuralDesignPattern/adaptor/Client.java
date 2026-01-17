package designPattern.designPattern.structuralDesignPattern.adaptor;

public class Client {
    public static void main(String[] args) {

        Flipkart flipkart = new Flipkart(new RazorpayPaymentGatewayAdaptor());
        flipkart.makePaymentViaCC("123412341234",123,9,2025);
    }
}
