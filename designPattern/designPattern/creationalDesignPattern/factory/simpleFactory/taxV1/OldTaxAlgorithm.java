package designPattern.designPattern.creationalDesignPattern.factory.simpleFactory.taxV1;


public class OldTaxAlgorithm implements TaxAlgorithm{
    @Override
    public Double calculateTax(SalaryDetails salaryDetails) {
        return 0.4 * salaryDetails.getBasePay() + 0.3 * salaryDetails.getHra();
    }
}
