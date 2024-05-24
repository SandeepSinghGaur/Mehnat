package interview.approval_service.payment_approval_service;

public class ApprovalNotification {
    private String message;

    public ApprovalNotification(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
