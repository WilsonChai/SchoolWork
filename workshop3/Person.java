public class Person implements java.io.Serializable {
    private String name;

    Person(){
        this.name = "";
    }

    Person(String name){
        this.name = name;
    }

    public String get_name(){return name;}
}
