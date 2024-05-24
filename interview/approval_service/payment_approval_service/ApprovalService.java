package interview.approval_service.payment_approval_service;

public class ApprovalService implements ApprovalInterface{
    @Override
    public void approveWorkItem(WorkItem workItem, String approver) {
        synchronized (workItem){
            if (workItem.getState() == ApprovalState.APPROVED || workItem.getState() == ApprovalState.REJECTED) {
                return;
            }

            String currentApprover = workItem.getCurrentApprover();
            if (currentApprover.equals(approver)) {
                workItem.addApprovalToHistory(approver, "approved");
                workItem.addNotification(STR."\{approver} approved the work item");

                workItem.incrementCurrentApproverIndex();
                String nextApprover = workItem.getCurrentApprover();
                if (nextApprover == null) {
                    workItem.setState(ApprovalState.APPROVED);
                    workItem.addNotification("Work item fully approved");
                    workItem.addApprovalToHistory("System", "fully approved");
                } else {
                    workItem.addNotification(STR."Work item submitted for approval to: \{nextApprover}");
                    workItem.addApprovalToHistory("System", "submitted for " + nextApprover + " approval");
                }
            } else {
                throw new IllegalStateException(STR."Approval action not allowed. Current approver: \{currentApprover}");
            }

        }

    }

    @Override
    public void rejectWorkItem(WorkItem workItem, String approver, String reason) {
        synchronized (workItem){
            if (workItem.getState() == ApprovalState.APPROVED || workItem.getState() == ApprovalState.REJECTED) {
                return;
            }

            String currentApprover = workItem.getCurrentApprover();
            if (currentApprover.equals(approver)) {
                workItem.setState(ApprovalState.REJECTED);
                workItem.addNotification(STR."Work item rejected by \{approver}. Reason: \{reason}");
                workItem.setRejectionReason(reason);
                workItem.addApprovalToHistory(approver, "rejected");
            } else {
                throw new IllegalStateException(STR."Rejection action not allowed. Current approver: \{currentApprover}");
            }
        }

    }
}
