import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
import java.util.function.Function;

public class Main {

    public static void main(String[] args) {
        //Go to function that prompts user for width
        int width = get_user_width();
        //Go to function that prompts user for length
        int length = get_user_length();

        System.out.println("You entered width " + width + " and length " + length);

        /*Call function to create grid and print grid with Pat in
        upper left and C in lower right corner and begin making
        random moves North, South, East, West, NorthEast,
        NorthWest, SouthEast, SouthWest*/
        createGrid(width, length);


    }

    /*This function prompts user for width, checks that input is a
    variable within bounds 2-50, then returns input back to width
    variable in the main function
     */
    public static int get_user_width() {
        System.out.println("Please enter an integer value for width between 2-50");
        Scanner sc = new Scanner(System.in);
        int width_A;
        try {
            width_A = sc.nextInt();
            if (width_A < 2 || width_A > 50) {
                System.out.println("Out of Bounds.");
                return get_user_width();
            }
            return width_A;
        } catch (InputMismatchException e) {
            System.out.println("Input mismatch. Integers only.");
            sc.next();
            return get_user_width();
        }

    }

    /*This function prompts user for length, checks that input is a
    variable within bounds 2-50, then returns input back to length
    variable in the main function
     */
    public static int get_user_length() {
        System.out.println("Please enter an integer value for length between 2-50");
        Scanner sc = new Scanner(System.in);
        int length_B;
        try {
            length_B = sc.nextInt();
            if (length_B < 2 || length_B > 50) {
                System.out.println("Out of bounds.");
                return get_user_length();
            }
            return length_B;
        } catch (InputMismatchException e) {
            System.out.println("Input mismatch. Integers only.");
            sc.next();
            return get_user_length();
        }

    }

    /*
    Function that creates grid based off of user width and length
    input*/
    public static void createGrid(int width_A, int length_B) {
        //Declare 2D String array of user length and width
        String[][] grid = new String[length_B][width_A];

        for (int r = 0; r < length_B; r++) {
            for (int c = 0; c < width_A; c++) {
                /*If at upper left corner, then
                [P]
                 */
                if (r == 0 && c == 0) {
                    grid[r][c] = "[P]";
                }
                /*If at lower right corner, then
                [C]
                 */
                else if (r == length_B - 1 && c == width_A - 1) {
                    grid[r][c] = "[C]";
                } else {
                    grid[r][c] = "[ ]";
                }
            }
        }

        printGrid(grid, width_A, length_B);

        //Call function to make grid moves
        makeGridMoves(grid, width_A, length_B);
    }

    public static void printGrid(String[][] grid, int width_A, int length_B) {
        //Print out grid
        for (int rows = 0; rows < length_B; rows++) {
            System.out.println();
            for (int cols = 0; cols < width_A; cols++) {
                System.out.print(grid[rows][cols]);
            }
        }
    }

    public static void makeGridMoves(String[][] grid, int width_A, int length_B) {
        /*Pick a random number between 1 and 8 where 1: North 2:South
        3: East 4: West 5: Northeast 6: Northwest 7:Southeast
        8:Southwest
         */
        Random r = new Random();


        int turns_took =0;
        boolean flag = false;

        System.out.println(" ");

        for(int turn = 0; turn < 1000000; turn++)
        {
            if(flag == true){
                break;
            }
            else{
                int pat_move = r.nextInt((8 - 1) + 1) + 1;
                int chris_move = r.nextInt((8 - 1) + 1) + 1;

                System.out.println(pat_move + "Pats move " + chris_move + " Chris Move");
            }


        }


//        System.out.println("Pat is on row " + current_row_Pat + " and col " + current_col_Pat);
//        System.out.println("Chris is on row " + current_row_Chris + " and col " + current_col_Chris);


//        Keep generating random moves until reached 1000000
//        for (int turn = 0; turn < 1000000; turn++) {
//            if (flag == true)
//            {
//                break;
//            }
//            try{
//                Thread.sleep(800);
//            }catch(Exception e)
//            {
//
//            }
//
//            int move = r.nextInt((8 - 1) + 1) + 1;
//            System.out.println();
//            System.out.println("Move is " + move);
//            int current_row_Pat = findCurrentPos(grid, width_A, length_B, "P", 'R');
//            int current_col_Pat = findCurrentPos(grid, width_A, length_B, "P", 'C');
//
//            int current_row_Chris = findCurrentPos(grid, width_A, length_B, "C", 'R');
//            int current_col_Chris = findCurrentPos(grid, width_A, length_B, "C", 'C');
//
//            /*Coorelate integer move with the direction using a switch
//            case
//             */
//            System.out.println("Current row Pat and current Col Pat: " + current_row_Pat + " " + current_col_Pat);
//            System.out.println("Current row Chris and current Col Chris: " + current_row_Chris + " " + current_col_Chris);
//            if(grid[current_row_Pat][current_col_Pat].contains("C"))
//            {
//                turns_took = turn;
//                break;
//            }
//            else{
//
//                System.out.println();
//                switch (move) {
//                    case 1: /*Move 1 cell NORTH which means to keep cols the same
//                        but to decrement rows by 1*/
//                        try{
//                                System.out.println("Case 1. Moving North...");
//                                if(grid[current_row_Pat - 1][current_col_Pat].contains("C"))
//                                {
//                                    System.out.println(" ");
//                                    System.out.println("FOUND!!");
//                                    grid[current_row_Pat - 1][current_col_Pat] = "[PC]";
//                                    grid[current_row_Pat][current_col_Pat] = "[ ]";
//                                    printGrid(grid, width_A, length_B);
//                                    flag = true;
//                                    break;
//                                }
//                                else {
//                                    grid[current_row_Pat - 1][current_col_Pat] = "[P]";
//                                    grid[current_row_Pat][current_col_Pat] = "[ ]";
//                                    printGrid(grid, width_A, length_B);
//
//                                }
//
//
//                        }catch(ArrayIndexOutOfBoundsException ex)
//                        {
//                            System.out.println("Out of bounds");
//                            break;
//                        }
//                        break;
//                    case 2: /*Move 1 cell South which means to keep cols the same
//                        but to increment rows by 1*/
//
//                        try{
//                            if(grid[current_row_Pat +1][current_col_Pat].contains("C"))
//                            {
//                                System.out.println(" ");
//                                System.out.println("FOUND!!");
//                                grid[current_row_Pat + 1][current_col_Pat] = "[PC]";
//                                grid[current_row_Pat][current_col_Pat] = "[ ]";
//                                printGrid(grid, width_A, length_B);
//                                flag = true;
//                                break;
//                            }
//                            else {
//                                System.out.println("Case 2. Moving South...");
//                                grid[current_row_Pat + 1][current_col_Pat] = "[P]";
//                                grid[current_row_Pat][current_col_Pat] = "[ ]";
//                                printGrid(grid, width_A, length_B);
//                            }
//
//                        }catch(ArrayIndexOutOfBoundsException ex)
//                        {
//                            System.out.println("Out of bounds");
//                            break;
//                        }
//                        break;
//                    case 3: /*Move 1 cell East which means to keep rows the same
//                        but increment cols by 1*/
//
//                        try{
//                            if(grid[current_row_Pat][current_col_Pat +1].contains("C"))
//                            {
//                                System.out.println(" ");
//                                System.out.println("FOUND!!");
//                                grid[current_row_Pat][current_col_Pat +1] = "[PC]";
//                                grid[current_row_Pat][current_col_Pat] = "[ ]";
//                                printGrid(grid, width_A, length_B);
//                                flag = true;
//                                break;
//                            }
//                            else {
//                                System.out.println("Case 3. Moving East...");
//                                grid[current_row_Pat][current_col_Pat + 1] = "[P]";
//                                grid[current_row_Pat][current_col_Pat] = "[ ]";
//                                printGrid(grid, width_A, length_B);
//                            }
//
//                        }catch(ArrayIndexOutOfBoundsException ex)
//                        {
//                            System.out.println("Out of bounds");
//                            break;
//                        }
//                        break;
//                    case 4: /*Move 1 cell West which means to keep rows the same
//                        but to decrement cols by 1*/
//
//                        try{
//                            if(grid[current_row_Pat][current_col_Pat-1].contains("C"))
//                            {
//                                System.out.println(" ");
//                                System.out.println("FOUND!!");
//                                grid[current_row_Pat][current_col_Pat-1] = "[PC]";
//                                grid[current_row_Pat][current_col_Pat] = "[ ]";
//                                printGrid(grid, width_A, length_B);
//                                flag = true;
//                                break;
//                            }
//                            else {
//                                System.out.println("Case 4. Moving West...");
//                                grid[current_row_Pat][current_col_Pat - 1] = "[P]";
//                                grid[current_row_Pat][current_col_Pat] = "[ ]";
//                                printGrid(grid, width_A, length_B);
//                            }
//
//                        }catch(ArrayIndexOutOfBoundsException ex)
//                        {
//                            System.out.println("Out of bounds");
//                            break;
//                        }
//                        break;
//                    case 5: /*Move 1 cell NorthEast which means to decrement rows
//                        by 1 and to increment cols by 1*/
//
//                        try{
//                            if(grid[current_row_Pat - 1][current_col_Pat+1].contains("C"))
//                            {
//                                System.out.println(" ");
//                                System.out.println("FOUND!!");
//                                grid[current_row_Pat - 1][current_col_Pat+1] = "[PC]";
//                                grid[current_row_Pat][current_col_Pat] = "[ ]";
//                                printGrid(grid, width_A, length_B);
//                                flag = true;
//                                break;
//                            }
//                            else {
//                                System.out.println("Case 5. Moving NorthEast...");
//                                grid[current_row_Pat - 1][current_col_Pat + 1] = "[P]";
//                                grid[current_row_Pat][current_col_Pat] = "[ ]";
//                                printGrid(grid, width_A, length_B);
//                            }
//
//                        }catch(ArrayIndexOutOfBoundsException ex)
//                        {
//                            System.out.println("Out of bounds");
//                            break;
//                        }
//                        break;
//                    case 6: /*Move 1 cell NorthWest which means to decrement rows
//                        by 1 and to decrement cols by 1*/
//
//                        try{
//                            if(grid[current_row_Pat - 1][current_col_Pat-1].contains("C"))
//                            {
//                                System.out.println(" ");
//                                System.out.println("FOUND!!");
//                                grid[current_row_Pat - 1][current_col_Pat-1] = "[PC]";
//                                grid[current_row_Pat][current_col_Pat] = "[ ]";
//                                printGrid(grid, width_A, length_B);
//                                flag = true;
//                                break;
//                            }
//                            else {
//                                System.out.println("Case 6. Moving NorthWest...");
//                                grid[current_row_Pat - 1][current_col_Pat - 1] = "[P]";
//                                grid[current_row_Pat][current_col_Pat] = "[ ]";
//                                printGrid(grid, width_A, length_B);
//                            }
//
//                        }catch(ArrayIndexOutOfBoundsException ex)
//                        {
//                            System.out.println("Out of bounds");
//                            break;
//                        }
//                        break;
//                    case 7: /*Move 1 cell SouthWest which means to increment rows
//                        by 1 and to decrement cols by 1*/
//
//                        try{
//                            if(grid[current_row_Pat + 1][current_col_Pat -1].contains("C"))
//                            {
//                                System.out.println(" ");
//                                System.out.println("FOUND!!");
//                                grid[current_row_Pat +1][current_col_Pat -1] = "[PC]";
//                                grid[current_row_Pat][current_col_Pat] = "[ ]";
//                                printGrid(grid, width_A, length_B);
//                                flag = true;
//                                break;
//                            }
//                            else {
//                                System.out.println("Case 7. Moving SouthWest...");
//                                grid[current_row_Pat + 1][current_col_Pat - 1] = "[P]";
//                                grid[current_row_Pat][current_col_Pat] = "[ ]";
//                                printGrid(grid, width_A, length_B);
//                            }
//
//                        }catch(ArrayIndexOutOfBoundsException ex)
//                        {
//                            System.out.println("Out of bounds");
//                            break;
//                        }
//                        break;
//                    case 8: /*Move 1 cell SouthEast which means to increment rows
//                        by 1 and to increment cols by 1*/
//
//                        try{
//                            if(grid[current_row_Pat + 1][current_col_Pat+1].contains("C"))
//                            {
//                                System.out.println(" ");
//                                System.out.println("FOUND!!");
//                                grid[current_row_Pat + 1][current_col_Pat+1] = "[PC]";
//                                grid[current_row_Pat][current_col_Pat] = "[ ]";
//                                printGrid(grid, width_A, length_B);
//                                flag = true;
//                                break;
//                            }
//                            else {
//                                System.out.println("Case 8. Moving SouthEast...");
//                                grid[current_row_Pat + 1][current_col_Pat + 1] = "[P]";
//                                grid[current_row_Pat][current_col_Pat] = "[ ]";
//                                printGrid(grid, width_A, length_B);
//                            }
//
//                        }catch(ArrayIndexOutOfBoundsException ex)
//                        {
//                            System.out.println("Out of bounds");
//                            break;
//                        }
//                        break;
//                    default: break;
//                }
//                }

            }




        /*Function that finds the current position of either Chris or Pat. If looking for Chris, then use C
        if looing for Pat then use P. Function returns either row or column location depending on if position
        you are looking for is either 'R' for row or 'C' for col
         */
        public static int findCurrentPos (String[][]grid,int width_A, int length_B, String person,char pos ){

            for (int rows = 0; rows < length_B; rows++) {
                for (int cols = 0; cols < width_A; cols++) {
                    if (pos == 'R' && grid[rows][cols].contains(person)) {
                        return rows;
                    } else if (pos == 'C' && grid[rows][cols].contains(person)) {
                        return cols;
                    }

                }
            }

            return -1;
        }

    }





