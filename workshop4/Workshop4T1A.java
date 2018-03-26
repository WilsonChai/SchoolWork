/**********************************************
   Workshop 4 - Task 1A
   Course:JAC444 - Semester 4
   Last Name: Chai
   First Name: Wilson
   ID: 030-918-114
   Section: DD
   This assignment represents my own work in accordance with Seneca Academic Policy.
   Signed by Wilson Chai
   Date: April 3, 2018
**********************************************/
import java.util.List;
import java.util.Arrays;

public class Workshop4T1A {
    public static void main(String[] args){
        List<String>topNames2017 = Arrays.asList(
            "Amelia",
            "Olivia",
            "emily",
            "Isla",
            "Ava",
            "oliver",
            "Jack",
            "Charlie",
            "harry",
            "Jacob"
        );

        topNames2017
            .stream()
            .map(name->{return Character.toUpperCase(name.charAt(0))+name.substring(1);})
            .sorted()
            .forEach(System.out::println);
    }
}
