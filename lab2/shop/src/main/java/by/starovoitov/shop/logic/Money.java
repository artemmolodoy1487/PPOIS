package by.starovoitov.shop.logic;

public class Money {
    private int amount;

     public Money(int amount) {
         this.amount = amount;
     }

     public int getAmount() {
         return amount;
     }

     public void setAmount(int amount) {
         this.amount = amount;
     }

     public void minusAmount(int amount) {
         this.amount -= amount;
     }

     public void plusAmount(int amount) {
         this.amount += amount;
     }

}
