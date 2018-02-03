// File: lab1.java
// Name: Wilson Chai
// Date: 01/24/18
// Course: JAC444SDD - Introduction to Java
// Description: Includes all seven solutions to the lab1 exercises.
// Usage: Choose an option from the menu to see what each program does.

import java.util.Scanner;

public class lab1{
  public static void main(String[] args){
    int exit = 0, selection = 0;
    System.out.println("*******************************************");
    System.out.println("Here are the solutions to lab1 exercises.");
    System.out.println("   1) U.S. Census Bureau");
    System.out.println("   2) Sum of All Digits");
    System.out.println("   3) Six Months Saving Calculator");
    System.out.println("   4) Random Month Generator");
    System.out.println("   5) Random Playing Card Generator");
    System.out.println("   6) School Tuition");
    System.out.println("   7) Number Triangle");
    System.out.println("*******************************************");

    do {
      System.out.print("Please select an option(select 0 to exit): ");
      Scanner input = new Scanner(System.in);
      selection = input.nextInt();
      if (!((selection >= 0) || (selection < 7))) {
        System.out.println("Selection is not valid.");
      }
      else {
        exit=1;
      }
    } while(exit==0);

    if (selection==1){ // U.S. Census Bureau
      float currentPopulation = 312032486;
      System.out.println("\nPopulation of US: \n");
      for(int i = 0; i < 5; i++){
        currentPopulation += 365 * 24 * 60 * 60 / 7;
        currentPopulation -= 365 * 24 * 60 * 60 / 13;
        currentPopulation += 365 * 24 * 60 * 60 / 45;
        System.out.println("Year " + (i+1) + ": " + (int)currentPopulation);
      }
    }
    else if (selection==2){ // Sum of All Digits
      exit = 0;
      do {
        int sum = 0;
        System.out.print("Enter an integer between 0 and 1000: ");
        Scanner input = new Scanner(System.in);
        int value = input.nextInt();

        if (value > 0 && value < 1000){
          for(int i = 0; i < 3; i++){
            sum += value%10;
            value = value/10;
          }
          System.out.print("The sum of all its digits is " + sum);
          exit = 1;
        }
        else {
          System.out.println("Input not within parameters.");
        }
      } while(exit==0);
    }
    else if (selection==3){ // Six months saving calculator
      System.out.print("\nEnter the monthly saving amount: ");
      Scanner input = new Scanner(System.in);

      float monthlySaving = input.nextInt();
      float value = 0;

      for (int i = 0; i < 6; i++) {
        value = (float)((monthlySaving + value) * (1.00417));
      }

      System.out.printf("After the sixth month, the account value is $%.2d", value);
    }
    else if (selection==4){ // Random month generator
      String[] month = {"January", "February", "March", "April", "May", "June",
      "July", "August", "September", "October", "November", "December"};

      System.out.println("A random month: " + month[(int)(Math.random() * 12)]);
    }
    else if (selection==5){ // Random Playing Card Generator
      String[] suits = {"Spades", "Hearts", "Clubs", "Diamonds"};
      String[] ranks = {"Ace", "2", "3", "4",
                        "5", "6", "7", "8", "9",
                        "10", "Jack", "Queen", "King"};

      System.out.println("The card you picked is " +
                          ranks[(int)(Math.random()*13)] + " of " +
                          suits[(int)(Math.random()*4)]);
    }
    else if (selection==6){ // School Tuition
      double tuition_year1 = 10000;
      double interest = 0;

      interest = tuition_year1*(Math.pow(1.05, 10)-1);
      System.out.printf("Cost of tuition in 10 years: %.2f\n", interest + tuition_year1);
      //System.out.printf("Debt after 10 years(4 years of tuition): %.2f", debt);
    }
    else if (selection==7){ // Number Triangle
      int count = 1;
      while(count<=8){
        for(int i = 8; i >= 0; i--){
          if(i==count){
            for (int j = 0; j < count; j++){
              System.out.printf("%3d",(int)(Math.pow(2,j)));
            }
            for (int j = count - 2; j >= 0; j--){
              System.out.printf("%3d",(int)(Math.pow(2,j)));
            }
            System.out.print("\n");
            count++;
            break;
          }
          else {
            System.out.print("   ");
          }
        }
      }
    }
  }

}
