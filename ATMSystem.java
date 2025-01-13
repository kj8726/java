import java.util.Scanner;  
  
class BankAccount {  
    private double balance;  
  
    public BankAccount(double initialBalance) {  
        this.balance = initialBalance;  
    }  
  
    public double getBalance() {  
        return balance;  
    }  
  
    public boolean withdraw(double amount) {  
        if (amount > 0 && amount <= balance) {  
            balance -= amount;  
            return true;  
        } else {  
            return false;  
        }  
    }  
  
    public void deposit(double amount) {  
        if (amount > 0) {  
            balance += amount;  
        }  
    }  
}  
  
class ATM {  
    private BankAccount account;  
    private Scanner scanner;  
  
    public ATM(BankAccount account) {  
        this.account = account;  
        this.scanner = new Scanner(System.in);  
    }  
  
    public void start() {  
        boolean exit = false;  
  
        while (!exit) {  
            System.out.println("\nWelcome to the ATM!");  
            System.out.println("1. Check Balance");  
            System.out.println("2. Deposit Money");  
            System.out.println("3. Withdraw Money");  
            System.out.println("4. Exit");  
            System.out.print("Choose an option: ");  
  
            int choice = scanner.nextInt();  
  
            switch (choice) {  
                case 1:  
                    checkBalance();  
                    break;  
                case 2:  
                    deposit();  
                    break;  
                case 3:  
                    withdraw();  
                    break;  
                case 4:  
                    System.out.println("Thank you for using the ATM. Goodbye!");  
                    exit = true;  
                    break;  
                default:  
                    System.out.println("Invalid option. Please try again.");  
            }  
        }  
    }  
  
    private void checkBalance() {  
        System.out.println("Your current balance is: $" + account.getBalance());  
    }  
  
    private void deposit() {  
        System.out.print("Enter the amount to deposit: $");  
        double amount = scanner.nextDouble();  
  
        if (amount > 0) {  
            account.deposit(amount);  
            System.out.println("Deposit successful. Your new balance is: $" + account.getBalance());  
        } else {  
            System.out.println("Invalid amount. Please try again.");  
        }  
    }  
  
    private void withdraw() {  
        System.out.print("Enter the amount to withdraw: $");  
        double amount = scanner.nextDouble();  
  
        if (account.withdraw(amount)) {  
            System.out.println("Withdrawal successful. Your new balance is: $" + account.getBalance());  
        } else {  
            System.out.println("Insufficient funds or invalid amount. Please try again.");  
        }  
    }  
}  
  
public class ATMSystem {  
    public static void main(String[] args) {  
        BankAccount userAccount = new BankAccount(500.0); // Initial balance: $500  
        ATM atm = new ATM(userAccount);  
        atm.start();  
    }  
}  