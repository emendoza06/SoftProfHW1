import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //Go to function that prompts user for width
        int width = get_user_width();
        //Go to function that prompts user for length
        int length = get_user_length();

        System.out.println(width + " " + length);


    }

    /*This function prompts user for width, checks that input is a
    variable within bounds 2-50, then returns input back to width
    variable in the main function
     */
    public static int get_user_width()
    {
        System.out.println("Please enter an integer value for width between 2-50");
        Scanner sc = new Scanner(System.in);
        int width_A;
        try{
            width_A = sc.nextInt();
            if(width_A < 2 || width_A > 50)
            {
                System.out.println("Out of Bounds.");
                return get_user_width();
            }
            return width_A;
        } catch(InputMismatchException e){
            System.out.println("Input mismatch. Integers only.");
            sc.next();
            return get_user_width();
        }

    }

    /*This function prompts user for length, checks that input is a
    variable within bounds 2-50, then returns input back to length
    variable in the main function
     */
    public static int get_user_length()
    {
        System.out.println("Please enter an integer value for length between 2-50");
        Scanner sc = new Scanner(System.in);
        int length_B;
        try{
            length_B = sc.nextInt();
            if(length_B < 2 || length_B > 50)
            {
                System.out.println("Out of bounds.");
                return get_user_length();
            }
            return length_B;
        } catch(InputMismatchException e){
            System.out.println("Input mismatch. Integers only.");
            sc.next();
            return get_user_length();
        }

    }
}

