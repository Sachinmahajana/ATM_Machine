import java.util.Scanner;

 class ATMS {
    public static void main(String[] args) {
        ATM obj = new ATM();
        obj.checkPin();
    }
}

class ATM {
    float balance;
    int pin = 5674;

    public void checkPin() {
        System.out.println("Enter Your Pin");
        Scanner sc = new Scanner(System.in);
        int enteredPin = sc.nextInt();

        if (enteredPin == pin) {
            Menu();
        } else {
            System.out.println("Invalid pin");
            checkPin();
        }
    }
    public void changePin() {
        System.out.println("Enter your current PIN:");
        Scanner sc = new Scanner(System.in);
        int currentPin = sc.nextInt();

        if (currentPin == pin) {
            System.out.println("Enter your new PIN:");
            int newPin = sc.nextInt();
            pin = newPin;
            System.out.println("PIN changed successfully.");
          //  transactionHistory.add("Changed PIN");
        } else {
            System.out.println("Incorrect current PIN.");
        }
        Menu();
    }
    public void Menu() {
        System.out.println("Enter your Choice");
        System.out.println("1. Check Acc Balance");
        System.out.println("2. Withdraw Money");
        System.out.println("3. Deposit Money");
        System.out.println("4.Change pin");
        System.out.println("5. Exit");

        Scanner sc = new Scanner(System.in);
        int opt = sc.nextInt();

        if (opt == 1) {
            checkBalance();
        } else if (opt == 2) {
            withdrawMoney();
        } else if (opt == 3) {
            depositMoney();
        } else if (opt == 4) {
            changePin();
        } 
        else if(opt==5){
            return;
        }
        else {
            System.out.println("Enter invalid choice");
        }
    }

    public void checkBalance() {
        System.out.println("Balance: " + balance);
        Menu();
    }

    public void withdrawMoney() {
        System.out.println("Enter amount to withdraw money");
        Scanner sc = new Scanner(System.in);
        float amount = sc.nextFloat();
        if (amount > balance) {
            System.out.println("Insufficient funds");
        } else {
            balance = balance - amount;
            System.out.println("Money withdrawal successful");
        }
        Menu();
    }

    public void depositMoney() {
        System.out.println("Enter the amount");
        Scanner sc = new Scanner(System.in);
        float amount = sc.nextFloat();
        balance = balance + amount;
        System.out.println("Money deposited successfully");
        Menu();
    }
}
