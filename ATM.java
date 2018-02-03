import java.util.Scanner;
public class ATM{
    public static void main(String[] args){
        Account[] acc = new Account[10];

        for(int i=0; i<10; i++){
            acc[i] = new Account(i,100);
        }

        while(true){
            Scanner input = new Scanner(System.in);
            System.out.print("Enter an id: ");
            int select_id = input.nextInt();
            if(select_id<0 || select_id>9){
                System.out.println("Incorrect ID");
            }
            else{
                int choice;
                do{
                    System.out.println("Main menu");
                    System.out.println("1: check balance");
                    System.out.println("2: withdraw");
                    System.out.println("3: deposit");
                    System.out.println("4: exit");

                    System.out.print("Enter a choice: ");
                    choice = input.nextInt();

                    switch(choice){
                        case 1:
                            System.out.println("The balance is "+acc[select_id].get_balance());
                            break;
                        case 2:
                            System.out.print("Enter an amount to withdraw: ");
                            double withdraw_amount = input.nextDouble();
                            acc[select_id].withdraw(withdraw_amount);
                            break;
                        case 3:
                            System.out.print("Enter an amount to deposit: ");
                            double deposit_amount = input.nextDouble();
                            acc[select_id].deposit(deposit_amount);
                            break;
                        case 4:
                            break;
                        default:
                            System.out.println("Error: not a valid choice");
                    }
                    System.out.println();
                }while(choice!=4);
            }
        }
    }
}
