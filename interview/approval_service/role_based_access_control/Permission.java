package interview.approval_service.role_based_access_control;

class Permission {
    private BankingModule name;

    public Permission(BankingModule name) {
        this.name = name;
    }

    public BankingModule getName() {
        return name;
    }
}
