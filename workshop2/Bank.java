/**********************************************
Workshop 2 - Question 2: Contains the Bank object
Course:JAC444 - Semester 4
Last Name: Chai
First Name: Wilson
ID: 030-918-114
Section: DD
This assignment represents my own work in accordance with Seneca Academic Policy.
Signed by Wilson Chai
Date: March 6, 2018
**********************************************/
import java.util.ArrayList;

// Bank object for use in Q2
public class Bank{
    private int id;
    private double balance;
    private ArrayList<Loan> loan = new ArrayList<Loan>();

    // default constructor
    public Bank(int id){
        this.id=id;
        this.balance=0;
    }

    // accessor methods
    public int get_id(){return this.id;}
    public double get_balance(){return this.balance;}
    public int get_loanID(int index){
        return this.loan.get(index).loanID();
    }
    public double get_loanAmount(int index){
        return this.loan.get(index).loanAmount();
    }

    // mutator methods
    public void set_balance(double balance){this.balance=balance;}
    public void add_Loan(int loanID, double loanAmount){
        this.loan.add(new Loan(loanID, loanAmount));
    }

    // calculates the total assets - also checks if loan bank is safe
    public double total_assets(boolean[] unsafeBanks){
        double totalAssets=this.get_balance();
        for(int i=0; i<this.loan.size(); i++){
            if(unsafeBanks[this.get_loanID(i)]==false){
                totalAssets+=this.get_loanAmount(i);
            }
        }
        return totalAssets;
    }

    // this class declares the Loan object for Bank
    class Loan{
        private int loan_id;
        private double loan_amount;

        public Loan(int loanID, double loanAmount){
            this.loan_id=loanID;
            this.loan_amount=loanAmount;
        }

        // accessors
        public int loanID(){return this.loan_id;}
        public double loanAmount(){return this.loan_amount;}
    }
}
