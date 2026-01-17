package designPattern.designPattern.creationalDesignPattern.factory.simpleFactory.taxV0;

public class TaxCalculator {
    public static Double calculateTax(TaxRegime taxRegime, SalaryDetails salaryDetails) {
        switch (taxRegime) {
            case OLD:
                return 0.4 * salaryDetails.getBasePay() + 0.3 * salaryDetails.getHra();
            case NEW:
                return 0.4 * salaryDetails.getBasePay() + 0.3 * salaryDetails.getHra() + 0.2 * salaryDetails.getLta();
        }
        throw new RuntimeException("Invalid Regime " + taxRegime);
    }
}
