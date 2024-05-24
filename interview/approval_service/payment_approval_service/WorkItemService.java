package interview.approval_service.payment_approval_service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WorkItemService implements WorkItemServiceInterface{
    private List<WorkItem> workItems;
    private ApprovalService approvalService;

    public WorkItemService() {
        this.workItems = new ArrayList<>();
        this.approvalService = new ApprovalService();
    }
    @Override
    public WorkItem createWorkItem(double paymentAmount) {
        WorkItem workItem = new WorkItem(paymentAmount);

        if (paymentAmount > 500000) {
            workItem.setApprovers(Arrays.asList("Program Manager", "General Manager", "Finance Director"));
        } else if (paymentAmount <= 500000 && paymentAmount >= 200000) {
            workItem.setApprovers(Arrays.asList("Program Manager", "General Manager"));
        } else {
            workItem.setApprovers(Arrays.asList("Program Manager"));
        }

        workItem.setState(ApprovalState.PROGRAM_MANAGER_APPROVAL);
        workItem.addNotification(STR."Work item created and submitted for approval to: \{workItem.getCurrentApprover()}");
        workItem.addApprovalToHistory("System", STR."submitted for \{workItem.getCurrentApprover()} approval");

        workItems.add(workItem);
        return workItem;
    }

    @Override
    public void approveWorkItem(int workItemId, String approver) {
        WorkItem workItem = getWorkItemById(workItemId);
        approvalService.approveWorkItem(workItem, approver);

    }

    @Override
    public void rejectWorkItem(int workItemId, String approver, String reason) {
        WorkItem workItem = getWorkItemById(workItemId);
        approvalService.rejectWorkItem(workItem, approver, reason);

    }

    @Override
    public WorkItem getWorkItemById(int workItemId) {
        return workItems.get(workItemId);
    }

    @Override
    public List<WorkItem> getAllWorkItems() {
        return workItems;
    }
}
