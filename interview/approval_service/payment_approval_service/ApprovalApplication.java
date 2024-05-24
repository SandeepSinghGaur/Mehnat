package interview.approval_service.payment_approval_service;

import java.util.List;
import java.util.Scanner;

public class ApprovalApplication {
    private static WorkItemServiceInterface workItemService = new WorkItemService();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n/*******  Menu  ********/");
            System.out.println("1. Create Work Item");
            System.out.println("2. Approve Work Item");
            System.out.println("3. Reject Work Item");
            System.out.println("4. View Work Item");
            System.out.println("5. View All Work Items");
            System.out.println("6. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    createWorkItem();
                    break;
                case 2:
                    approveWorkItem();
                    break;
                case 3:
                    rejectWorkItem();
                    break;
                case 4:
                    viewWorkItem();
                    break;
                case 5:
                    viewAllWorkItems();
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void createWorkItem() {
        System.out.print("Enter payment amount: ");
        double paymentAmount = scanner.nextDouble();
        scanner.nextLine();  // Consume newline

        WorkItem workItem = workItemService.createWorkItem(paymentAmount);
        System.out.println(STR."Work item created with ID: \{workItemService.getAllWorkItems().size() - 1}");
    }

    private static void approveWorkItem() {
        System.out.print("Enter work item ID: ");
        int workItemId = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        System.out.print("Enter approver name: ");
        String approver = scanner.nextLine();

        try {
            workItemService.approveWorkItem(workItemId, approver);
            System.out.println("Work item approved.");
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void rejectWorkItem() {
        System.out.print("Enter work item ID: ");
        int workItemId = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        System.out.print("Enter approver name: ");
        String approver = scanner.nextLine();

        System.out.print("Enter rejection reason: ");
        String reason = scanner.nextLine();

        try {
            workItemService.rejectWorkItem(workItemId, approver, reason);
            System.out.println("Work item rejected.");
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void viewWorkItem() {
        System.out.print("Enter work item ID: ");
        int workItemId = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        WorkItem workItem = workItemService.getWorkItemById(workItemId);
        System.out.println(STR."Work Item ID: \{workItemId}");
        System.out.println(STR."State: \{workItem.getState()}");
        System.out.println(STR."Payment Amount: \{workItem.getPaymentAmount()}");
        System.out.println("Notifications: ");
        for (ApprovalNotification notification : workItem.getNotifications()) {
            System.out.println(STR." - \{notification.getMessage()}");
        }
        System.out.println("Approval History: ");
        for (String history : workItem.getApprovalHistory()) {
            System.out.println(STR." - \{history}");
        }
        if (workItem.getState() == ApprovalState.REJECTED) {
            System.out.println(STR."Rejection Reason: \{workItem.getRejectionReason()}");
        }
    }

    private static void viewAllWorkItems() {
        List<WorkItem> workItems = workItemService.getAllWorkItems();
        for (int i = 0; i < workItems.size(); i++) {
            WorkItem workItem = workItems.get(i);
            System.out.println(STR."Work Item ID: \{i}");
            System.out.println(STR."State: \{workItem.getState()}");
            System.out.println(STR."Payment Amount: \{workItem.getPaymentAmount()}");
            System.out.println("Notifications: ");
            for (ApprovalNotification notification : workItem.getNotifications()) {
                System.out.println(STR." - \{notification.getMessage()}");
            }
            System.out.println("Approval History: ");
            for (String history : workItem.getApprovalHistory()) {
                System.out.println(STR." - \{history}");
            }
            if (workItem.getState() == ApprovalState.REJECTED) {
                System.out.println(STR."Rejection Reason: \{workItem.getRejectionReason()}");
            }
            System.out.println();
        }
    }
}
