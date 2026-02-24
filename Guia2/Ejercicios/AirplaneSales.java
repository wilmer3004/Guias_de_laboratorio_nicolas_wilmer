import java.util.Scanner;

public class AirplaneSales {

    private int airplanes;
    private final int DAYS = 7;
    private double[][] sales;
    private String[] dayNames = {
            "Monday", "Tuesday", "Wednesday",
            "Thursday", "Friday", "Saturday", "Sunday"
    };

    public AirplaneSales(int airplanes) {
        this.airplanes = airplanes;
        sales = new double[airplanes][DAYS];
    }

    // Store sales
    public void readSales() {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < airplanes; i++) {
            System.out.println("\nAirplane " + (i + 1));
            for (int j = 0; j < DAYS; j++) {
                System.out.print("Sales on " + dayNames[j] + ": ");
                sales[i][j] = sc.nextDouble();
            }
        }
    }

    // Airplane with highest weekly sales
    public void airplaneWithHighestSales() {

        double max = -1;
        int airplane = -1;

        for (int i = 0; i < airplanes; i++) {
            double total = 0;
            for (int j = 0; j < DAYS; j++) {
                total += sales[i][j];
            }

            if (total > max) {
                max = total;
                airplane = i;
            }
        }

        System.out.println("Airplane with highest weekly sales: " +
                (airplane + 1) + " -> " + max);
    }

    // Airplane with lowest weekly sales
    public void airplaneWithLowestSales() {

        double min = Double.MAX_VALUE;
        int airplane = -1;

        for (int i = 0; i < airplanes; i++) {
            double total = 0;
            for (int j = 0; j < DAYS; j++) {
                total += sales[i][j];
            }

            if (total < min) {
                min = total;
                airplane = i;
            }
        }

        System.out.println("Airplane with lowest weekly sales: " +
                (airplane + 1) + " -> " + min);
    }

    // Best day for each airplane
    public void bestDayPerAirplane() {

        for (int i = 0; i < airplanes; i++) {

            double max = sales[i][0];
            int day = 0;

            for (int j = 1; j < DAYS; j++) {
                if (sales[i][j] > max) {
                    max = sales[i][j];
                    day = j;
                }
            }

            System.out.println("Airplane " + (i + 1)
                    + " best day: " + dayNames[day]
                    + " -> " + max);
        }
    }

    // Increase by 20% the sales that are below the daily average
    public void increaseBelowDailyAverage() {

        for (int j = 0; j < DAYS; j++) {

            double sum = 0;

            for (int i = 0; i < airplanes; i++) {
                sum += sales[i][j];
            }

            double average = sum / airplanes;

            for (int i = 0; i < airplanes; i++) {
                if (sales[i][j] < average) {
                    sales[i][j] = sales[i][j] * 1.20;
                }
            }
        }

        System.out.println("Sales below the daily average were increased by 20%.");
    }

    public void showMatrix() {

        System.out.println("\nSales matrix:");

        for (int i = 0; i < airplanes; i++) {
            System.out.print("Airplane " + (i + 1) + ": ");
            for (int j = 0; j < DAYS; j++) {
                System.out.print(sales[i][j] + "\t");
            }
            System.out.println();
        }
    }
}