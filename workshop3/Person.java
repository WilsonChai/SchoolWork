/**********************************************
   Workshop 3
   Course:JAC444 - Semester 4
   Last Name: Chai
   First Name: Wilson
   ID: 030-918-114
   Section: DD
   This assignment represents my own work in accordance with Seneca Academic Policy.
   Signed by Wilson Chai
   Date: March 21, 2018
**********************************************/
public class Person implements java.io.Serializable {
    private String name;
    private String street;
    private String city;
    private String state;
    private String zip;

    Person(){
        this.name = "";
        this.street = "";
        this.city = "";
        this.state = "";
        this.zip = "";
    }

    Person(String name, String street, String city, String state, String zip){
        this.name = name;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    public String get_name(){return this.name;}
    public String get_street(){return this.street;}
    public String get_city(){return this.city;}
    public String get_state(){return this.state;}
    public String get_zip(){return this.zip;}
}
