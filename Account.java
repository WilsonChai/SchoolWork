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

    // main method
    public static void main(String[] args){
        Account account = new Account();
        CheckingAccount checking = new CheckingAccount();
        SavingsAccount savings = new SavingsAccount();

        account.set_id(1122); account.set_balance(20000);
        account.set_annualInterestRate(0.045);
        account.withdraw(2500); account.deposit(3000);

        System.out.printf("The balance is $%.2f\n",account.get_balance());
        System.out.printf("The monthly interest is $%.2f\n",account.getMonthlyInterest());
        System.out.println("Date account was created: "+account.get_dateCreated());

        checking.withdraw(100);
        System.out.println(checking.toString());
    }
}

// CheckingAccount subclass - overrides withdraw method with overdraft limit
class CheckingAccount extends Account{
    public void withdraw(double amount){
        if((this.get_balance()-amount)<0){
            System.out.println("Overdraft limit");
        }
        else{
            this.set_balance(this.get_balance()-amount);
        }
    }

    public String toString(){
        return "Success!";
    }
}

// SavingsAccount subclass - overrides withdraw method with overdrawn limit
class SavingsAccount extends Account{
    public void withdraw(double amount){
          if((this.get_balance()-amount)<0){
              System.out.println("Overdrawn Limit");
          }
          else{
              this.set_balance(this.get_balance()-amount);
          }
      }
    public String toString(){
        return "Greater Good!";
    }
}
