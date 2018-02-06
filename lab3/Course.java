import java.util.Arrays;
public class Course{
    private String courseName;
    private String[] students;
    private int numberOfStudents;

    // constructors
    public Course(){
        this.numberOfStudents=0;
    }
    public Course(String courseName){
        students = new String[10];
        this.courseName=courseName;
    }

    // accessor methods
    public String getCourseName(){
        return this.courseName;
    }
    public String[] getStudents(){
        return this.students;
    }
    public int getNumberOfStudents(){
        return this.numberOfStudents;
    }

    @Override
    public String toString(){
        String temp="";
        for(int i=0; i<this.numberOfStudents; i++){
            temp+=students[i];
            temp+=", ";
        }
        return (temp);
    }

    public void addStudent(String student){
        this.students[this.numberOfStudents]=student;
        this.numberOfStudents++;
    }
    public void dropStudent(String student){
        this.numberOfStudents--;
    }

    public static void main(String[] args){
        Course course1 = new Course("course1");
        Course course2 = new Course("course2");

        course1.addStudent("Peter Jones");
        course1.addStudent("Kim Smith");
        course1.addStudent("Anne Kennedy");

        course2.addStudent("Wilson");
        course2.addStudent("Chai");

        System.out.printf("Number of students in %s: %d\n",course1.courseName,course1.numberOfStudents);
        System.out.println(course1.toString());
        System.out.printf("Number of students in %s: %d\n",course2.courseName,course2.numberOfStudents);
    }
}
