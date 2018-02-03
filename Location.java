import java.util.Scanner;
public class Location{
    // data members
    public int row, column;
    public double maxValue;

    // constructor
    public Location(){
        this.row=0;
        this.column=0;
        this.maxValue=0;
    }

    public static Location locateLargest(double[][] a){
        Location ret = new Location();
        int row, column;
        for(int i=0; i<a.length; i++){
            for(int j=0; j<a[i].length; j++){
                if(ret.maxValue < a[i][j]){
                    ret.maxValue = a[i][j];
                    ret.row=i;
                    ret.column=j;
                }
            }
        }
        return ret;
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of rows and columns in the array: ");
        int rows = input.nextInt();
        int columns = input.nextInt();

        double[][] array = new double[rows][columns];

        System.out.println("Enter the array:");

        for(int i=0; i<rows; i++){
            for(int j=0; j<columns; j++){
                array[i][j]=input.nextDouble();
            }
        }
        System.out.print("The location of the largest element is ");
        System.out.print(locateLargest(array).maxValue+" at (");
        System.out.print(locateLargest(array).row+", ");
        System.out.println(locateLargest(array).column+")");
    }
}
