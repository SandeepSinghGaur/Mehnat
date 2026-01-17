package designPattern.designPattern.creationalDesignPattern.factory.simpleFactory.taxV1;


public class TaxCalculator {
    public static Double calCulateTax(TaxRegime taxRegime, SalaryDetails salaryDetails) {
        return TaxCalculatorFactory
                .getTaxAlgorithm(taxRegime)
                .calculateTax(salaryDetails);
    }
}
