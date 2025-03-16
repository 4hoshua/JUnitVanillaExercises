package tests;

import factory.FinancingFactory;
import financiamento.Financing;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FinancingTests {

    @Test
    public void objectShouldBeCreatedWhenSuccessfulValidation () {

        Financing fin;

        fin = FinancingFactory.createFinancing(100000.0, 2000.0, 80);

        Assertions.assertEquals(100000.0, fin.getTotalAmount());
        Assertions.assertEquals(2000.0, fin.getIncome());
        Assertions.assertEquals(80, fin.getMonths());
    }
}
