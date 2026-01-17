package designPattern.designPattern.creationalDesignPattern.factory.simpleFactory.taxV1;


public class Client {
    public static void main(String[] args) {
        TaxCalculator taxCalculator = new TaxCalculator();
        Double tax = taxCalculator.calCulateTax(TaxRegime.NEW, new SalaryDetails(200.10, 100.20, 400.20));
        System.out.printf("Tax %s", tax);
    }
}
