import java.util.Scanner;

public class OneDimensionalArrays {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n;

        // Number of elements
        System.out.print("Enter the number of values: ");
        n = scanner.nextInt();

        // One-dimensional arrays
        int[] integers = new int[n];
        double[] decimals = new double[n];

        // Read integers
        System.out.println("\nEnter the integer numbers:");
        for (int i = 0; i < n; i++) {
            System.out.print("Integer [" + i + "]: ");
            integers[i] = scanner.nextInt();
        }

        // Read decimals
        System.out.println("\nEnter the decimal numbers:");
        for (int i = 0; i < n; i++) {
            System.out.print("Decimal [" + i + "]: ");
            decimals[i] = scanner.nextDouble();
        }

        // Display integers
        System.out.println("\nIntegers entered:");
        for (int i = 0; i < n; i++) {
            System.out.println("integers[" + i + "] = " + integers[i]);
        }

        // Display decimals
        System.out.println("\nDecimals entered:");
        for (int i = 0; i < n; i++) {
            System.out.println("decimals[" + i + "] = " + decimals[i]);
        }

        scanner.close();
    }
}