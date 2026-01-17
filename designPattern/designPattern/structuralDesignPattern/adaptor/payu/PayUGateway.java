package designPattern.designPattern.structuralDesignPattern.adaptor.payu;

public class PayUGateway {
    public String makeCCPayment(Long creditNumber,Long cvv,Long expiry){
        System.out.printf("Payment Done by PayU");
        return "12ertyu";
    }
    public PayUPaymentStatus checkPaymentStatus(String id){
        return PayUPaymentStatus.FAILURE;
    }
}
