package designPattern.designPattern.structuralDesignPattern.adaptor.razorpay;

public class RazorpayGateway {
    public String payByCreditCard(String cardNumber, String cvv, String expiryMonth){
        System.out.printf("Payment Done by Razorpay");
        return "12345678";
    }
    public Boolean checkPaymentStatus(String id){
        return false;
    }
}
