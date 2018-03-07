/**********************************************
Workshop 2 - Question 2 - uses the Bank class
Course:JAC444 - Semester 4
Last Name: Chai
First Name: Wilson
ID: 030-918-114
Section: DD
This assignment represents my own work in accordance with Seneca Academic Policy.
Signed by Wilson Chai
Date: March 6, 2018
**********************************************/
import java.util.Scanner;

public class Q2{
    // main method
    public static void main(String[] args){
        double minAssetLimit=0;

        // prompts user for number of banks and initializes them
        System.out.print("Number of banks: ");
        int numOfBanks = getInt();
        Bank[] bank = new Bank[numOfBanks];
        boolean[] unsafeBanks = new boolean[numOfBanks]; // true means bank is not safe
        for(int i=0; i<numOfBanks; i++){
            bank[i] = new Bank(i);
        }

        System.out.print("Minimum asset limit: ");
        minAssetLimit = getDouble();

        // gets user input for all banks
        getBankInfo(bank, numOfBanks);

        // determine which banks are unsafe
        unsafeBanks = isSafe(bank, minAssetLimit);

        // prints all unsafe banks
        System.out.print("Unsafe banks are: ");
        for(int i=0; i<numOfBanks; i++){
            if(unsafeBanks[i]==true){
                System.out.print(i+" ");
            }
        }
        System.out.println();
    }

    // getBankInfo method - prompts bank information from user
    public static void getBankInfo(Bank[] bank, int numOfBanks){
        int loanID=0, numOfLoans=0;
        double loanAmount=0;

        for(int i=0; i<numOfBanks; i++){
            System.out.printf("\nBank #%d > \nBalance: ", bank[i].get_id());
            bank[i].set_balance(getDouble());
            System.out.printf("Number of banks Loaned: ");
            numOfLoans = getInt();

            for(int j=0; j<numOfLoans; j++){
                System.out.print("  Bank ID: ");
                loanID = getInt();
                System.out.print("  Amount: ");
                loanAmount = getDouble();

                bank[i].add_Loan(loanID, loanAmount);
            }
        }
    }

    // isSafe method - checks for all safe banks and returns it in a boolean array
    public static boolean[] isSafe(Bank[] bank, double minAssetLimit){
        boolean[] unsafeBanks = new boolean[bank.length]; // true means unsafe bank
        boolean check = true; // keep checking for unsafe banks until no more change

        do{
            check = false;

            for(int i=0; i<bank.length; i++){
                if(bank[i].total_assets(unsafeBanks)<minAssetLimit){ // not safe
                    if(unsafeBanks[i]==false){
                        check = true;
                    }
                    unsafeBanks[i] = true;
                }else { // safe
                    unsafeBanks[i] = false;
                }
            }
        }while(check==true);

        return unsafeBanks;
    }

    // getInt method - checks if input is int type and returns it
    public static int getInt(){
        Scanner input = new Scanner(System.in);
        int number;
        do{
            while(!input.hasNextInt()){
                System.out.println("Invalid input!");
                input.next();
            }
            number = input.nextInt();
        } while (number < 0); // do not allow negative values

        return number;
    }

    // getDouble method - checks if input is double type and returns it
    public static double getDouble(){
        Scanner input = new Scanner(System.in);
        double number;
        while(!input.hasNextDouble()){
            System.out.println("Invalid input!");
            input.next();
        }
        number = input.nextDouble();

        return number;
    }
}
