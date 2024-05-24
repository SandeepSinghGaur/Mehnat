package interview.approval_service.payment_approval_service;

import java.util.List;

public interface WorkItemServiceInterface {
    WorkItem createWorkItem(double paymentAmount);
    void approveWorkItem(int workItemId, String approver);
    void rejectWorkItem(int workItemId, String approver, String reason);
    WorkItem getWorkItemById(int workItemId);
    List<WorkItem> getAllWorkItems();
}
