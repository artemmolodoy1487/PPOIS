package by.starovoitov.touragency;

public class Insurance {
    private String provider;
    private double amount;

    public Insurance(String provider, double amount) {
        this.provider = provider;
        this.amount = amount;
    }

    public String getProvider() {
        return provider;
    }

    public double getAmount() {
        return amount;
    }
}
