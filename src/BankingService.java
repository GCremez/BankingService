import java.util.*;

public class BankingService {
    private final Map<String, Account> accounts = new HashMap<>();
    private final Scanner scanner = new Scanner(System.in);

    public void start(){
        while (true) {
            System.out.println("\n1. CREATE ACCOUNT\n2. DEPOSIT\n3. WITHDRAW\n4. VIEW ACCOUNT INFO\n5. EXIT");
            System.out.print("ENTER CHOICE: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    createAccount();
                    break;
                }
                case 2 -> {
                    deposit();
                    break;
                }

                case 3 -> {
                    withdraw();
                    break;
                }


                case 4 -> {
                    viewAccountInfo();
                    break;
                }


                case 5 -> {
                    System.out.println("THANKS FOR USING OUR SERVICE");
                    break;
                }
                default -> throw new IllegalStateException("Unexpected value: " + choice);
            }
        }
    }

    public void createAccount() {
        System.out.println("WELCOME, THANK YOU FOR CHOOSING OUR SERVICE");
        System.out.println("WHAT IS YOUR FULL NAME: ");
        String owner = scanner.nextLine();

        System.out.println("WILL YOU LIKE TO MAKE A INITIAL DEPOSIT?");
        System.out.println("1. YES\n 2. NO");
        int answer = scanner.nextInt();
        double initialDeposit = 0;
        if (answer == 1) {
            System.out.println("HOW MUCH WILL YOU LIKE TO DEPOSIT: ");
            initialDeposit = scanner.nextDouble();
            scanner.nextLine();
        }
            Account newAccount = new Account(owner, initialDeposit);
            accounts.put(newAccount.getAccountNumber(), newAccount);
            System.out.println("THANK YOU FOR OPENING YOUR ACCOUNT WITH US");
            System.out.println("YOUR ACCOUNT NUMBER IS: " + newAccount.getAccountNumber()
                    + "\n AND ACCOUNT HOLDER IS: " + owner + "\n ACCOUNT BALANCE: " + initialDeposit);

    }

    public void deposit(){
        System.out.print("HELLO! THANK YOU FOR USING OUR SERVICE TODAY");
        System.out.println("WHAT IS YOUR ACCOUNT NUMBER?");
        String accNumber = scanner.nextLine();
        Account acc = accounts.get(accNumber);
        if (acc != null){
            System.out.println("ENTER AMOUNT YOU WANT TO DEPOSIT");
            double amount = scanner.nextDouble();
            acc.deposit(amount);
        } else {
            System.out.println("WRONG ACCOUNT NUMBER");
        }

    }

    public void withdraw(){
        System.out.println("WHAT IS YOUR ACCOUNT NUMBER");
        String accNumber = scanner.nextLine();
        Account acc = accounts.get(accNumber);
        if (acc != null) {
            System.out.println("HOW MUCH WILL YOU LIKE TO WITHDRAW");
            double amount = scanner.nextDouble();
            // making Sure the amount is not less than zero
            if (amount > 0) {
                acc.withdraw(amount);
            } else {
                System.out.println("INVALID AMOUNT");
            }
        } else {
            System.out.println("ACCOUNT IS NOT FOUND");
        }

    }

    public void viewAccountInfo(){
        System.out.print("Enter account number: ");
        String accNumber = scanner.nextLine();
        Account acc = accounts.get(accNumber);
        if (acc != null) {
            System.out.println(acc);
        } else {
            System.out.println("Account not found.");
        }
    }

}
