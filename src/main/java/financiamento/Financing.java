package financiamento;

public class Financing {

    private double totalAmount;
    private double income;
    private int months;

    public Financing() {}

    public Financing(double totalAmount, double income, int months) {
        validation(totalAmount, income, months);
        this.totalAmount = totalAmount;
        this.income = income;
        this.months = months;
    }

    public double getTotalAmount() {return totalAmount;}

    public void setTotalAmount(double totalAmount) {
        validation(totalAmount, income, months);
        this.totalAmount = totalAmount;
    }

    public double getIncome() {return income;}

    public void setIncome(double amount) {
        validation(totalAmount, income, months);
        this.income = amount;
    }

    public int getMonths() {return months;}

    public void setMonths(int months) {
        validation(totalAmount, income, months);
        this.months = months;
    }

    public double entry (double totalAmount) {
        return totalAmount * 0.2;
    }

    public double quote (double totalAmount) {
        return (totalAmount - entry(totalAmount))/months;
    }

    private void validation(double totalAmount, double income, int months) {
        if (totalAmount * 0.8 / months > income / 2.0) {
            throw new IllegalArgumentException("A parcela não pode ser maior que a metade da renda");
        }
    }
}
