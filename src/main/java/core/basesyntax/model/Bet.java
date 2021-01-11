package core.basesyntax.model;

public class Bet {
    private int amount;
    private double risk;

    public Bet(int amount, double risk) {
        this.amount = amount;
        this.risk = risk;
    }

    public int getAmount() {
        return amount;
    }

    public double getRisk() {
        return risk;
    }

    @Override
    public String toString() {
        return "Bet{"
                + "amount=" + amount
                + ", risk=" + risk
                + '}';
    }
}
