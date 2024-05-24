package interview.approval_service.payment_approval_service;

import java.util.ArrayList;
import java.util.List;

public class WorkItem {
    private ApprovalState state;
    private double paymentAmount;
    private List<ApprovalNotification> notifications;
    private List<String> approvalHistory;
    private String rejectionReason;
    private List<String> approvers;
    private int currentApproverIndex;

    public WorkItem(double paymentAmount) {
        this.state = ApprovalState.DRAFT;
        this.paymentAmount = paymentAmount;
        this.notifications = new ArrayList<>();
        this.approvalHistory = new ArrayList<>();
        this.approvers = new ArrayList<>();
        this.currentApproverIndex = 0;
    }

    // Getters and Setters

    public ApprovalState getState() {
        return state;
    }

    public void setState(ApprovalState state) {
        this.state = state;
    }

    public double getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public List<ApprovalNotification> getNotifications() {
        return notifications;
    }

    public void addNotification(String message) {
        this.notifications.add(new ApprovalNotification(message));
    }

    public List<String> getApprovalHistory() {
        return approvalHistory;
    }

    public void addApprovalToHistory(String approver, String action) {
        this.approvalHistory.add(approver + " " + action);
    }

    public String getRejectionReason() {
        return rejectionReason;
    }

    public void setRejectionReason(String rejectionReason) {
        this.rejectionReason = rejectionReason;
    }

    public List<String> getApprovers() {
        return approvers;
    }

    public void setApprovers(List<String> approvers) {
        this.approvers = approvers;
    }

    public int getCurrentApproverIndex() {
        return currentApproverIndex;
    }

    public void incrementCurrentApproverIndex() {
        this.currentApproverIndex++;
    }

    public String getCurrentApprover() {
        if (currentApproverIndex < approvers.size()) {
            return approvers.get(currentApproverIndex);
        }
        return null;
    }
}
