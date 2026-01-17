package designPattern.designPattern.structuralDesignPattern.adaptor;

import designPattern.designPattern.structuralDesignPattern.adaptor.razorpay.RazorpayGateway;

public class RazorpayPaymentGatewayAdaptor implements PaymentGateway{
    private RazorpayGateway razorpayGateway = new RazorpayGateway();
    @Override
    public Long payViaCC(String cardNumber, int cvv, int expiryMonth, int expiryYear) {
        String cvvString = String.valueOf(cvv);
        String expiryString = String.valueOf(expiryMonth)+"/"+String.valueOf(expiryYear);
        String answer = razorpayGateway.payByCreditCard(cardNumber,cvvString,expiryString);
        return Long.parseLong(answer);
    }

    @Override
    public PaymentStatus getStatus(Long id) {
        boolean status = razorpayGateway.checkPaymentStatus(String.valueOf(id));
        if (status == true) {
            return PaymentStatus.SUCCESS;
        }
        return PaymentStatus.FAILURE;
    }
}
