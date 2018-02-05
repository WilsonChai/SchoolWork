/**********************************************
Workshop 1
Course:JAC444 - Semester 4
Last Name: Chai
First Name: Wilson
ID: 030-918-114
Section: DD
This assignment represents my own work in accordance with Seneca Academic Policy.
Signed by Wilson Chai
Date: February 13, 2018
**********************************************/
import java.util.Date;
import java.util.Scanner;
public class Account{
    // data members
    private int id;
    private double balance;
    private double annualInterestRate;
    private Date dateCreated;

    // default constructor
    public Account(){
        this.id=0;
        this.balance=0;
        this.annualInterestRate=0;
        this.dateCreated=new Date();
    }

    // constructor with id, balance
    public Account(int id, double balance){
        this.id=id;
        this.balance=balance;
        this.annualInterestRate=0;
        this.dateCreated=new Date();
    }

    // accessor methods
    public int get_id(){
        return this.id;
    }
    public double get_balance(){
        return this.balance;
    }
    public double get_annualInterestRate(){
        return this.annualInterestRate;
    }
    public Date get_dateCreated(){
        return this.dateCreated;
    }

    // mutator methods
    public void set_id(int id){
        this.id=id;
    }
    public void set_balance(double balance){
        this.balance=balance;
    }
    public void set_annualInterestRate(double annualInterestRate){
        this.annualInterestRate=annualInterestRate;
    }

    // returns monthly interest rate
    public double getMonthlyInterestRate(){
        double ret;
        ret=this.annualInterestRate/12;
        return ret;
    }

    // returns monthly interest
    public double getMonthlyInterest(){
        double ret;
        ret=this.balance*this.getMonthlyInterestRate();
        return ret;
    }

    // withdraws specified amount from the account
    public void withdraw(double amount){
        this.balance-=amount;
    }

    // deposits a specified amount from the account
    public void deposit(double amount){
        this.balance+=amount;
    }

    // main method - contains test programs
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        Account account = new Account();
        CheckingAccount checking = new CheckingAccount();
        SavingsAccount savings = new SavingsAccount();

        // Set object-account to values specified from workshop
        account.set_id(1122);
        account.set_balance(20000);
        account.set_annualInterestRate(0.045);
        account.withdraw(2500);
        account.deposit(3000);

        // Test program for Account class
        System.out.println("\nTest program for Account class");
        System.out.println("--------------------------------");
        System.out.printf("The balance is $%.2f\n",account.get_balance());
        System.out.printf("The monthly interest is $%.2f\n",account.getMonthlyInterest());
        System.out.println("Date account was created: "+account.get_dateCreated());

        // Test program for Checking and Savings Account subclasses
        int account_choice, menu_choice;
        double amount;
        System.out.println("\nTest program for Checking and Savings Account");
        System.out.println("---------------------------------------------");
        do{
            System.out.println("\nChoose an account");
            System.out.println("1: checking");
            System.out.println("2: savings");
            System.out.println("3: exit");
            System.out.print(": ");

            account_choice = input.nextInt();

            if(account_choice==1){
                System.out.println("\nChecking account menu");
            }else if(account_choice==2){
                System.out.println("\nSavings account menu");
            }else if(account_choice==3){
                System.out.println("Exiting program...");
                break;
            }else{
                System.out.println("Error - invalid input");
            }
            System.out.println("1: check balance");
            System.out.println("2: withdraw");
            System.out.println("3: deposit");
            System.out.println("4: exit");
            System.out.print("Enter a choice: ");

            menu_choice = input.nextInt();

            if(account_choice==1){
                switch(menu_choice){
                    case 1:
                        System.out.println("Current balance: $"+checking.get_balance());
                        break;
                    case 2:
                        System.out.print("Enter amount to withdraw: $");
                        amount = input.nextDouble();
                        System.out.println(checking.toString());
                        checking.withdraw(amount);
                        break;
                    case 3:
                        System.out.print("Enter amount to deposit: $");
                        amount = input.nextDouble();
                        checking.deposit(amount);
                        break;
                    case 4:
                        System.out.println("Exiting program...");
                        break;
                    default:
                        System.out.println("Error - invalid choice");
                        break;
                }
            }else if (account_choice==2){
                switch(menu_choice){
                    case 1:
                        System.out.println("Current balance: $"+savings.get_balance());
                        break;
                    case 2:
                        System.out.print("Enter amount to withdraw: $");
                        amount = input.nextDouble();
                        System.out.println(savings.toString());
                        savings.withdraw(amount);
                        break;
                    case 3:
                        System.out.print("Enter amount to deposit: $");
                        amount = input.nextDouble();
                        savings.deposit(amount);
                        break;
                    case 4:
                        System.out.println("Exiting program...");
                        break;
                    default:
                        System.out.println("Error - invalid choice");
                        break;
                }
            }
            System.out.println("---------------------------------");
        }while(account_choice!=3 && menu_choice!=4);
    }
}

// CheckingAccount subclass - overrides withdraw method with overdraft limit
class CheckingAccount extends Account{
    // override withdraw method
    public void withdraw(double amount){
        if((this.get_balance()-amount)<0){
            System.out.println("Error - overdraft limit");
        }
        else{
            this.set_balance(this.get_balance()-amount);
            System.out.println("Withdrawal successful");
        }
    }

    public String toString(){
        return "\nWithdrawing from checking...";
    }
}

// SavingsAccount subclass - overrides withdraw method with overdrawn limit
class SavingsAccount extends Account{
    // override withdraw method
    public void withdraw(double amount){
        if((this.get_balance()-amount)<0){
            System.out.println("Error - overdrawn limit");
        }
        else{
            this.set_balance(this.get_balance()-amount);
            System.out.println("Withdrawal successful");
        }
    }
    public String toString(){
        return "\nWithdrawing from savings...";
    }
}
