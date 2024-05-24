package interview.approval_service.payment_approval_service;

public interface ApprovalInterface {
    void approveWorkItem(WorkItem workItem, String approver);
    void rejectWorkItem(WorkItem workItem, String approver, String reason);
}
