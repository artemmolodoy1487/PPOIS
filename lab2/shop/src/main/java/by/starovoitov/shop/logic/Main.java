package by.starovoitov.shop.logic;

public class Main {
    public static void main(String[] args) {
        Wallet wallet = new Wallet(100);
        TourOperator test = new TourOperator(wallet);
        test.printTourPackages();
    }
}
