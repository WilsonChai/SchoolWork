import java.util.Date;
import java.util.Scanner;
public class Account{
    // data members
    private int id;
    private double balance;
    private double annualInterestRate;
    private Date dateCreated;

    // default constructors
    public Account(){
        this.id=0;
        this.balance=0;
        this.annualInterestRate=0;
        this.dateCreated=new Date();
    }

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

    // main method
    public static void main(String[] args){
        Account acc = new Account();

        acc.set_id(1122); acc.set_balance(20000);
        acc.set_annualInterestRate(0.045);
        acc.withdraw(2500); acc.deposit(3000);

        System.out.printf("The balance is $%.2f\n",acc.get_balance());
        System.out.printf("The monthly interest is $%.2f\n",acc.getMonthlyInterest());
        System.out.println("Date account was created: "+acc.get_dateCreated());
    }
}
