import java.util.Arrays;
public class RevisedCourse{
    private String courseName;
    private String[] students;
    private int numberOfStudents;

    // constructors
    public RevisedCourse(){
        this.numberOfStudents=0;
    }
    public RevisedCourse(String courseName){
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
        for(int i=0; i<this.getNumberOfStudents(); i++){
            temp+=students[i];
            temp+=", ";
        }
        return (temp);
    }

    public void addStudent(String student){
        this.students[this.getNumberOfStudents()]=student;
        this.numberOfStudents++;
    }
    public void dropStudent(String student){
        this.numberOfStudents--;
    }

    public static void main(String[] args){
        RevisedCourse course1 = new RevisedCourse("course1");
        RevisedCourse course2 = new RevisedCourse("course2");

        course1.addStudent("Peter Jones");
        course1.addStudent("Kim Smith");
        course1.addStudent("Anne Kennedy");

        course2.addStudent("Wilson");
        course2.addStudent("Chai");

        System.out.printf("Number of students in %s: %d\n",course1.getCourseName(),course1.getNumberOfStudents());
        System.out.println(course1.toString());
        System.out.printf("Number of students in %s: %d\n",course2.getCourseName(),course2.getNumberOfStudents());
    }
}
