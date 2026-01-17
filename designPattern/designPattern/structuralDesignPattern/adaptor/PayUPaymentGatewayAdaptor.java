package designPattern.designPattern.structuralDesignPattern.adaptor;

import designPattern.designPattern.structuralDesignPattern.adaptor.payu.PayUGateway;

public class PayUPaymentGatewayAdaptor implements PaymentGateway{
    private PayUGateway payUGateway = new PayUGateway();
    @Override
    public Long payViaCC(String cardNumber, int cvv, int expiryMonth, int expiryYear) {
        Long longCardNumber = Long.parseLong(cardNumber);
        Long longCvv = Long.valueOf(cvv);
        Long longExpiry = Long.parseLong(String.valueOf(expiryMonth)+"/"+String.valueOf(expiryYear));
        String ans = payUGateway.makeCCPayment(longCardNumber,longCvv,longExpiry);
        return Long.parseLong(ans);
    }

    @Override
    public PaymentStatus getStatus(Long id) {
        String status = String.valueOf(payUGateway.checkPaymentStatus(String.valueOf(id)));
        if (status == "SUCCESS") {
            return PaymentStatus.SUCCESS;
        }
        return PaymentStatus.FAILURE;
    }
}
