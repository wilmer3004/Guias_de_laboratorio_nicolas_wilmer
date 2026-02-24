import java.util.Scanner;

public class MainClimateStation  {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of days: ");
        int n = sc.nextInt();
        sc.nextLine();

        ClimateStation station = new ClimateStation(n);

        int option;

        do {

            System.out.println("\n--- MENU ---");
            System.out.println("1. Enter temperatures");
            System.out.println("2. Days with maximum temperature between 15 and 20");
            System.out.println("3. Days with minimum temperature below 0");
            System.out.println("4. Show average temperatures");
            System.out.println("5. Show final list");
            System.out.println("0. Exit");
            System.out.print("Option: ");
            option = sc.nextInt();
            sc.nextLine();

            switch (option) {

                case 1 -> station.readData();

                case 2 -> station.showMaxBetween15And20();

                case 3 -> station.showMinBelowZero();

                case 4 -> station.showAverages();

                case 5 -> station.showAllData();
            }
            

        } while (option != 0);
    }
}