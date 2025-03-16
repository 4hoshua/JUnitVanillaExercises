package factory;

import financiamento.Financing;

public class FinancingFactory {

    public static Financing createFinancing(double totalAmount, double income, int months) {
        return new Financing(totalAmount, income, months);
    }
}
