public class Account {
    private static int accountCounter = 10000;
    private final String accountNumber;
    private final String owner;
    private double balance;


    public Account(String owner, double initialDeposit) {
        this.accountNumber = generateAccountNumber();
        this.owner = owner;
        this.balance = 0; // Initialize balance to be 0
        deposit(initialDeposit); // Add initial deposit to balance
    }

    private String generateAccountNumber(){
        return String.format("ACC%08d", accountCounter++);
    }

    public String getAccountNumber(){
        return accountNumber;
    }

   /* public String getOwner(){
        return owner;
    }

    public double getBalance(){
        return balance;
    } */

    public void deposit(double amount){
        if (amount > 0) {
            balance += amount;
            System.out.printf("You've Deposited %2f and your balance is %2f", amount , balance);
        } else {
            System.out.println("Invalid Amount");
        }
    }

    public void withdraw (double amount){
        if (amount > 0 && amount <= balance){
            balance -= amount;
            System.out.printf("You just withdraw %3f from your account. you are left with %3f ", amount, balance);
        }
        else {
            System.out.println("Invalid withdrawal amount or insufficient Funds.");
        }
    }

    @Override
    public String toString() {
        return "Account Number: " + accountNumber + ", Owner: " + owner + ", Balance: " + balance;
    }


}
