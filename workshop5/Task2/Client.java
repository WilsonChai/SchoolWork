/*
 * Workshop 4 - Task 2 Client
 * Course:JAC444 - Semester 4
 * Last Name: Chai
 * First Name: Wilson
 * ID: 030-918-114
 * Section: DD
 * This assignment represents my own work in accordance with Seneca Academic Policy.
 * Signed by Wilson Chai
 * Date: April 17, 2018
 */
import java.net.*;
import java.io.*;
import java.util.*;

class Client {

    public static void main(String args[]) throws Exception {

        Socket s = new Socket("localhost", 3333);

        DataInputStream din = new DataInputStream(s.getInputStream());
        DataOutputStream dout = new DataOutputStream(s.getOutputStream());
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String height = "", weight = "", result = "";

        while (result.equals("")) {
            System.out.print("Write your height in meters (ex 1.80): ");
            height = br.readLine();
            System.out.print("Write your weight in kilograms (ex 70.5): ");
            weight = br.readLine();

            dout.writeUTF(height);
            dout.writeUTF(weight);

            dout.flush();

            System.out.println("Waiting for BMI from server...");
            result = din.readUTF();
            System.out.println("Your BMI is: " + result);
        }

        dout.close();
        s.close();
    }
}
