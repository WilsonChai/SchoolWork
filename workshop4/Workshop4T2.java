/**********************************************
   Workshop 4 - Task 2
   Course:JAC444 - Semester 4
   Last Name: Chai
   First Name: Wilson
   ID: 030-918-114
   Section: DD
   This assignment represents my own work in accordance with Seneca Academic Policy.
   Signed by Wilson Chai
   Date: April 3, 2018
**********************************************/
import java.util.Scanner;
import java.util.regex.*;

public class Workshop4T2{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        boolean menu_continue = true;
        int year, rank=0;
        char gender;
        String name;

        do{
            year = getYear(input);
            gender = getGender(input);
            name = getName(input);

            System.out.println("Boy name " + name + " is ranked " + rank + " in year " + year);

            menu_continue = getInquiry(input);

        }while(menu_continue);
    }

    public static int getYear(Scanner input){
        int year;
        do{
            System.out.print("Enter the year: ");
            while(!input.hasNextInt()){
                System.out.print("ERROR: Year must be an integer!\nEnter the year: ");
                input.next();
            }
            year = input.nextInt();
            if(year < 2001 || year > 2010){
                System.out.print("ERROR: Year must be from 2001 to 2010!\n");
            }
        }while(year < 2001 || year > 2010);
        return year;
    }

    public static char getGender(Scanner input){
        String gender;
        do{
            System.out.print("Enter the gender: ");
            gender = input.next();
            if(!Pattern.matches("[mMfF]{1}", gender)){
                System.out.println("ERROR: Only M or F accepted!");
            }
        }while(!Pattern.matches("[mMfF]{1}", gender));
        return gender.charAt(0);
    }

    public static String getName(Scanner input){
        String name;
        do{
            System.out.print("Enter the name: ");
            name = input.next();
            if(!Pattern.matches("[a-zA-Z]*", name)){
                System.out.println("ERROR: Invalid name");
            }
        }while(!Pattern.matches("[a-zA-Z]*", name));
        return name;
    }

    public static boolean getInquiry(Scanner input){
        String inquiry;
        do{
            System.out.print("Enter another inquiry? ");
            inquiry = input.next();
            if(!Pattern.matches("[nNyY]{1}", inquiry)){
                System.out.println("ERROR: Only Y or N accepted!");
            }
        }while(!Pattern.matches("[nNyY]{1}", inquiry));
        return Pattern.matches("[yY]", inquiry);
    }
}
