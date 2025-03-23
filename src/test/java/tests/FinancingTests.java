package tests;

import factory.FinancingFactory;
import entities.Financing;
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

    @Test
    public void objectShouldNotBeCreatedWhenUnsuccessfulValidation () {

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> FinancingFactory.createFinancing(100000.0, 2000.0, 20));
    }

    @Test
    public void setTotalAmountShouldBeUpdatedWhenSuccessfulValidation () {

        Financing fin;

        fin = FinancingFactory.createFinancing(100000.0, 2000.0, 80);

        fin.setTotalAmount(50000.0);

        Assertions.assertEquals(50000.0, fin.getTotalAmount());
        Assertions.assertEquals(2000.0, fin.getIncome());
        Assertions.assertEquals(80, fin.getMonths());
    }

    @Test
    public void setTotalAmountShouldNotBeUpdatedWhenUnsuccessfulValidation () {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Financing fin;
            fin = FinancingFactory.createFinancing(100000.0, 2000.0, 80);
            fin.setTotalAmount(200000.0);
        });
    }

    @Test
    public void setIncomeShouldBeUpdatedWhenSuccessfulValidation () {

        Financing fin;

        fin = FinancingFactory.createFinancing(100000.0, 2000.0, 80);

        fin.setIncome(3000.0);

        Assertions.assertEquals(100000.0, fin.getTotalAmount());
        Assertions.assertEquals(3000.0, fin.getIncome());
        Assertions.assertEquals(80, fin.getMonths());
    }

    @Test
    public void setIncomeShouldNotBeUpdatedWhenUnsuccessfulValidation () {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Financing fin;
            fin = FinancingFactory.createFinancing(100000.0, 2000.0, 80);
            fin.setIncome(500.0);
        });
    }

    @Test
    public void setMonthsShouldBeUpdatedWhenSuccessfulValidation () {

        Financing fin;

        fin = FinancingFactory.createFinancing(100000.0, 2000.0, 80);

        fin.setMonths(100);

        Assertions.assertEquals(100000.0, fin.getTotalAmount());
        Assertions.assertEquals(2000.0, fin.getIncome());
        Assertions.assertEquals(100, fin.getMonths());
    }

    @Test
    public void setMonthsShouldNotBeUpdatedWhenUnsuccessfulValidation () {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Financing fin;
            fin = FinancingFactory.createFinancing(100000.0, 2000.0, 80);
            fin.setIncome(20);
        });
    }

    @Test
    public void entryShouldBeCorrectedCalculated () {

        Financing fin = FinancingFactory.createFinancing(100000.0, 2000.0, 80);

        Assertions.assertEquals(20000.0, fin.entry(fin.getTotalAmount()));
    }

    @Test
    public void quotaShouldBeCorrectedCalculated () {

        Financing fin = FinancingFactory.createFinancing(100000.0, 2000.0, 80);

        Assertions.assertEquals(1000.0, fin.quote(fin.getTotalAmount()));
    }


}
