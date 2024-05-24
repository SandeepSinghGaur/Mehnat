package interview.approval_service.role_based_access_control;

public class BankingModuleAccess {
    public static void main(String[] args) {
        // Define permissions
        Permission customerManagementPermission = new Permission(BankingModule.customer_management);
        Permission accountManagementPermission = new Permission(BankingModule.account_management);
        Permission transactionManagementPermission = new Permission(BankingModule.transaction_management);
        Permission creditManagementPermission = new Permission(BankingModule.credit_management);
        Permission compliancePermission = new Permission(BankingModule.compliance);
        Permission analyticsPermission = new Permission(BankingModule.analytics);
        Permission fraudDetectionPermission = new Permission(BankingModule.fraud_detection );
        Permission adminPermission = new Permission(BankingModule.admin);

        // Define roles and assign permissions
        Role customerServiceRole = new Role("CustomerService");
        customerServiceRole.addPermission(customerManagementPermission);
        customerServiceRole.addPermission(accountManagementPermission);
        customerServiceRole.addPermission(transactionManagementPermission);

        Role financialAnalystRole = new Role("FinancialAnalyst");
        financialAnalystRole.addPermission(analyticsPermission);

        Role complianceOfficerRole = new Role("ComplianceOfficer");
        complianceOfficerRole.addPermission(compliancePermission);

        Role adminRole = new Role("Admin");
        adminRole.addPermission(adminPermission);

        // Onboard users with specific roles
        User user1 = new User("JohnDoe");
        user1.addRole(customerServiceRole);

        User user2 = new User("JaneSmith");
        user2.addRole(financialAnalystRole);

        User user3 = new User("MikeBrown");
        user3.addRole(complianceOfficerRole);

        User adminUser = new User("AdminUser");
        adminUser.addRole(adminRole);

        // Example usage
        System.out.println(STR."\{user1.getUsername()} can access customer management: \{user1.hasPermission("customer_management")}");
        System.out.println(STR."\{user2.getUsername()} can access analytics: \{user2.hasPermission("analytics")}");
        System.out.println(STR."\{user3.getUsername()} can access compliance: \{user3.hasPermission("compliance")}");
        System.out.println(STR."\{adminUser.getUsername()} is admin: \{adminUser.hasPermission("admin")}");
    }
}