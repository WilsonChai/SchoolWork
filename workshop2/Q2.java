/**********************************************
Workshop 2 - Question 2
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
        Scanner input = new Scanner(System.in);

        // prompts user for number of banks and initializes them
        System.out.print("Number of banks: ");
        int numOfBanks = input.nextInt();
        Bank[] bank = new Bank[numOfBanks];
        boolean[] unsafeBanks = new boolean[numOfBanks]; // true means bank is not safe
        for(int i=0; i<numOfBanks; i++){
            bank[i] = new Bank(i);
        }

        System.out.print("Minimum asset limit: ");
        double minAssetLimit = input.nextDouble();

        getBankInfo(bank, numOfBanks);

        unsafeBanks = isSafe(bank, minAssetLimit);

        // prints all unsafe banks
        System.out.print("Unsafe banks are ");
        for(int i=0; i<numOfBanks; i++){
            if(unsafeBanks[i]==true){
                System.out.print(i+" ");
            }
        }
    }

    // getBankInfo method - prompts bank information from user
    public static void getBankInfo(Bank[] bank, int numOfBanks){
        Scanner input = new Scanner(System.in);
        int loanID, numOfLoans;
        double loanAmount;

        for(int i=0; i<numOfBanks; i++){
            System.out.printf("\nBank #%d > \nBalance: ", bank[i].get_id());
            bank[i].set_balance(input.nextDouble());
            System.out.printf("Number of banks Loaned: ");
            numOfLoans = input.nextInt();

            for(int j=0; j<numOfLoans; j++){
                System.out.print("  Bank ID: ");
                loanID = input.nextInt();
                System.out.print("  Amount: ");
                loanAmount = input.nextDouble();

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
}
