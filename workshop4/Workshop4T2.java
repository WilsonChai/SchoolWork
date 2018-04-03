/*
 *  Workshop 4 - Task 2
 *  Course:JAC444 - Semester 4
 *  Last Name: Chai
 *  First Name: Wilson
 *  ID: 030-918-114
 *  Section: DD
 *  This assignment represents my own work in accordance with Seneca Academic Policy.
 *  Signed by Wilson Chai
 *  Date: April 3, 2018
 */
//package workshop4;

import java.util.*;
import java.util.regex.*;
import java.io.*;

public class Workshop4T2 {

    // main method
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean menu_continue = true;
        int year;
        int rank = 0;
        char gender;
        String name;

        // main menu
        do {
            year = getYear(input);
            gender = getGender(input);
            name = getName(input);

            rank = findName(year, gender, name); // returns 0 if name not found

            if (rank > 0) { // name found
                System.out.println(((gender=='M') ? "Boy" : "Girl") + " name " + name + " is ranked #" + rank + " in year " + year);
            } else { // name not found
                System.out.println("The " + ((gender=='M') ? "boy" : "girl") + " name " + name + " is not on the list.");
            }

            menu_continue = getMenuLoop(input);

        } while (menu_continue);
    }

    /** find the name in the file and returns the rank (returns -1 if not found) */
    public static int findName(int year, char gender, String name) {
        String fileName = "babynamesranking/babynamesranking"
                        + Integer.toString(year)
                        + ".txt";
        String line = null;
        int nameRank = 1; // keep track of ranking in file, start at 1

        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            // reads each line and check for name
            while ((line = bufferedReader.readLine()) != null) {
                String columns[] = line.split("[ \\t].");   // sort into columns by space and tab

                /* find name with its corresponding gender */
                if (gender=='M' && name.equals(columns[1])
                        || (gender=='F' && name.equals(columns[3]))) {
                    break;
                }
                nameRank++;
            }
            fileReader.close();

            // if name was not found, return -1
            if (line == null) {
                nameRank = -1;
            }

        } catch (FileNotFoundException ex) {
            System.out.println("File not found: " + ex);
        } catch (IOException x) {
            System.out.println("I/O Exception: " + x);
        }

        return nameRank; // returns the found name's rank
    }

    // input validation methods for year, gender, name, and inquiry
    public static int getYear(Scanner input) {
        int year;

        do {
            System.out.print("Enter the year: ");

            while (!input.hasNextInt()) {
                System.out.println("ERROR: Year must be an integer from 2001 to 2010!");
                System.out.println("Enter the year: ");
                input.next();
            }
            year = input.nextInt();

            if (year < 2001 || year > 2010) {
                System.out.println("ERROR: Year must be from 2001 to 2010!");
            }
        } while (year < 2001 || year > 2010);

        return year;
    }

    public static char getGender(Scanner input) {
        String gender;

        do {
            System.out.print("Enter the gender: ");
            gender = input.next();

            if (!Pattern.matches("[MF]{1}", gender)) {
                System.out.println("ERROR: Only M or F accepted!");
            }
        } while (!Pattern.matches("[MF]{1}", gender));

        return gender.charAt(0);
    }

    public static String getName(Scanner input) {
        String name;

        do {
            System.out.print("Enter the name: ");
            name = input.next();

            if (!Pattern.matches("[a-zA-Z]*", name)) {
                System.out.println("ERROR: Invalid name");
            }
        } while (!Pattern.matches("[a-zA-Z]*", name));

        return name;
    }

    public static boolean getMenuLoop(Scanner input) {
        String inquiry;

        do {
            System.out.print("Enter another inquiry? ");
            inquiry = input.next();

            if (!Pattern.matches("[nNyY]{1}", inquiry)) {
                System.out.println("ERROR: Only Y or N accepted!");
            }
        } while (!Pattern.matches("[nNyY]{1}", inquiry));

        return Pattern.matches("[yY]", inquiry);
    }
}
