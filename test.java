public class test{
    public static void m(Object x){
        System.out.println(x.toString());
    }

    public class Checking extends Account{
        public String toString(){
            return "success!";
        }
    }

    public static void main(String[] args){
        m(new Checking());
    }
}
