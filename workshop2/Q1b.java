/**********************************************
Workshop 2 - Question 1 Part B
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
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Q1b{
    static ArrayList<String> words = new ArrayList<>();
    // main method
    public static void main(String[] args){
        File file = new File("hangman.txt");

        if (!file.exists()) {
            System.out.println(file.getAbsolutePath());
            System.out.println(file + " does not exist.");
            System.exit(1);
        }

        try {
            Scanner input = new Scanner(file);
            while (input.hasNext()) {
                words.add(input.next());}
        } catch (FileNotFoundException ex) {ex.printStackTrace();}

        Scanner input = new Scanner(System.in);
        boolean keepPlaying = true;

        do{
            boolean solved=false, foundLetter=false, missed=true;
            int misses=0;
            String chosenWord = words.get((int)(Math.random() * words.size()));
            boolean[] solvedLetters = new boolean[chosenWord.length()];

            do{
                System.out.print("(Guess) Enter a letter in word ");
                printWord(chosenWord, solvedLetters);
                char letter = input.next().charAt(0);

                // determine if input is valid
                if(letter >= '0' && letter <= '9'){
                    System.out.println("Error: integers are not allowed");
                }else if(letter >= 'A' && letter <= 'Z'){
                    System.out.println("Error: lowercase letters only");
                }else{

                    // determines if letter is contained in the word and
                    // if letter was already solved then tell player
                    for(int i=0; i<chosenWord.length(); i++){
                        if(chosenWord.charAt(i)==letter && solvedLetters[i]==false){
                            solvedLetters[i]=true;
                            foundLetter=true;
                            missed=false;
                        }else if(chosenWord.charAt(i)==letter && solvedLetters[i]==true){
                            System.out.println("          "+letter+" is already in the word");
                            missed=false;
                            break;
                        }
                    }

                    if(foundLetter==false && missed==true){
                        System.out.println("          "+letter+" is not in the word         ");
                        misses+=1;
                    }

                    // reset values for next iteration
                    missed=true;
                    foundLetter=false;

                    // determines if the word has been solved
                    for(int i=0; i<solvedLetters.length; i++){
                        solved=true;
                        if(solvedLetters[i]==false){
                            solved=false;
                            break;
                        }
                    }
                }
            }while(solved==false);

            System.out.printf("The word is %s. You missed %d time(s)\n", chosenWord, misses);

            // ask user if they want to play again
            System.out.print("Do you want to guess another word? Enter y or n> ");
            if(input.next().charAt(0)=='n'){
                keepPlaying=false;
            }

        }while(keepPlaying==true);
    }

    // printWord method - takes the word and solvedLetters args to print to screen
    public static void printWord(String chosenWord, boolean[] solvedLetters){
        for(int i=0; i<chosenWord.length(); i++){
            if(solvedLetters[i]==false){
                System.out.print('*');
            }else{
                System.out.print(chosenWord.charAt(i));
            }
        }
        System.out.print(" > ");
    }
}
