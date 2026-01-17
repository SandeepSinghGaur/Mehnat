package designPattern.designPattern.creationalDesignPattern.factory.simpleFactory.taxV1;


public class TaxCalculatorFactory {
    public static TaxAlgorithm getTaxAlgorithm(TaxRegime taxRegime) {
        switch (taxRegime) {
            case OLD:
                return new OldTaxAlgorithm();
            case NEW:
                return new NewTaxAlgorithm();

        }
        throw new RuntimeException("Invalid Regime " + taxRegime);
    }
}
