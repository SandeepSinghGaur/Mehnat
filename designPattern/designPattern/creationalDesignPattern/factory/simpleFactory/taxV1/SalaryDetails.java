package designPattern.designPattern.creationalDesignPattern.factory.simpleFactory.taxV1;


public class SalaryDetails {
    private Double basePay;
    private Double hra;
    private Double lta;

    public SalaryDetails(double basePay, double hra, double lta) {
        this.basePay = basePay;
        this.hra = hra;
        this.lta = lta;
    }

    public Double getBasePay() {
        return basePay;
    }

    public Double getHra() {
        return hra;
    }

    public Double getLta() {
        return lta;
    }

    public void setBasePay(Double basePay) {
        this.basePay = basePay;
    }

    public void setHra(Double hra) {
        this.hra = hra;
    }

    public void setLta(Double lta) {
        this.lta = lta;
    }
}
