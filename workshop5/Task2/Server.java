/*
 * Workshop 4 - Task 2 Server
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
import java.lang.*;

class Server {

    public static void main(String args[]) throws Exception {

        ServerSocket ss = new ServerSocket(3333);
        System.out.println("Server is listening for the connections... ");
        Socket s = ss.accept();

        DataInputStream din = new DataInputStream(s.getInputStream());
        DataOutputStream dout = new DataOutputStream(s.getOutputStream());
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String height_input = "", weight_input = "";
        double result = 0;

        while (result == 0) {
            System.out.println("Waiting for height and weight from client...:");
            height_input = din.readUTF();
            weight_input = din.readUTF();

            System.out.println("Height is: " + height_input);
            System.out.println("Weight is: " + weight_input);
            System.out.println("Calculating BMI...:");

            result = Double.parseDouble(weight_input) / (double) Math.pow(Double.parseDouble(height_input), 2);

             if (result < 18.5) {
                 dout.writeUTF("Underweight");
             } else if (result >= 18.5 && result < 25) {
                 dout.writeUTF("Normal");
             } else if (result >= 25 && result < 30) {
                 dout.writeUTF("Overweight");
             } else {
                 dout.writeUTF("Obese");
             }
            dout.flush();
        }

        din.close();
        s.close();
        ss.close();
    }
}
