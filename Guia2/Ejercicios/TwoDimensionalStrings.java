import java.util.Scanner;

public class TwoDimensionalStrings {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int rows, columns;

        System.out.print("Enter the number of rows: ");
        rows = scanner.nextInt();

        System.out.print("Enter the number of columns: ");
        columns = scanner.nextInt();

        scanner.nextLine(); // clear buffer

        // Two-dimensional array of strings
        String[][] strings = new String[rows][columns];

        // Read strings
        System.out.println("\nEnter the strings:");

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print("String [" + i + "][" + j + "]: ");
                strings[i][j] = scanner.nextLine();
            }
        }

        // Display strings
        System.out.println("\nStored strings in the matrix:");

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(strings[i][j] + "\t");
            }
            System.out.println();
        }

        scanner.close();
    }
}