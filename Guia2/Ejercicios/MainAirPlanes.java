import java.util.Scanner;

public class MainAirPlanes {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of airplanes: ");
        int m = sc.nextInt();

        AirplaneSales system = new AirplaneSales(m);

        int option;

        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Enter sales");
            System.out.println("2. Show sales matrix");
            System.out.println("3. Airplane with highest weekly sales");
            System.out.println("4. Airplane with lowest weekly sales");
            System.out.println("5. Best day for each airplane");
            System.out.println("6. 4");
            System.out.println("0. Exit");
            System.out.print("Option: ");
            option = sc.nextInt();

            switch (option) {
                case 1 -> system.readSales();
                case 2 -> system.showMatrix();
                case 3 -> system.airplaneWithHighestSales();
                case 4 -> system.airplaneWithLowestSales();
                case 5 -> system.bestDayPerAirplane();
                case 6 -> system.increaseBelowDailyAverage();
            }

        } while (option != 0);
    }
}