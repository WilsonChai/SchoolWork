import java.util.Scanner;
public class CheckingSavingsAccount{
    public static void main(String[] args){
        CheckingAccount checkingAccount = new CheckingAccount();
        SavingsAccount savingsAccount = new SavingsAccount();
        int account_choice;
        Scanner input = new Scanner(System.in);
        do {
            System.out.println("1: checking");
            System.out.println("2: savings");
            System.out.println("3: exit");
            System.out.print("Enter a choice: ");
            choice = input.nextInt();
            if(account_choice==1 || account_choice==2){
                menu(account_choice);
            }
            else if(account_choice==3){
                System.out.println("End program");
            }
            else{
                System.out.println("Error: invalid choice");
            }
        }while(account_choice!=3);
    }

    public static void menu(int account_choice){
        int menu_choice;
        if(account_choice==1){
            do{
                System.out.println("Checking account menu");
                System.out.println("1: check balance");
                System.out.println("2: withdraw");
                System.out.println("3: deposit");
                System.out.println("4: exit");
                System.out.print("Enter a choice: ");
            }while(menu_choice!=4);
        }
        else if(account_choice==2){
            System.out.println("Savings account menu");
            System.out.println("1: check balance");
            System.out.println("2: withdraw");
            System.out.println("3: deposit");
            System.out.println("4: exit");
        }
    }
}
