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
            System.out.println("6. Increase by 20% sales below daily average");
            System.out.println("0. Exit");
            System.out.print("Option: ");
            option = sc.nextInt();

            switch (option) {
                case 1:
                    system.readSales();
                    break;
                case 2:
                    system.showMatrix();
                    break;
                case 3:
                    system.airplaneWithHighestSales();
                    break;
                case 4:
                    system.airplaneWithLowestSales();
                    break;
                case 5:
                    system.bestDayPerAirplane();
                    break;
                case 6:
                    system.increaseBelowDailyAverage();
                    break;
            }

        } while (option != 0);
    }
}