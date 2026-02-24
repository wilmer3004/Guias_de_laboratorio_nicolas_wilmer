import java.util.Scanner;

public class ClimateStation {

    private int n;
    private String[] days;
    private double[] maxTemp;
    private double[] minTemp;

    public ClimateStation(int n) {
        this.n = n;
        days = new String[n];
        maxTemp = new double[n];
        minTemp = new double[n];
    }

    // Store data
    public void readData() {

        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < n; i++) {

            System.out.println("\nDay " + (i + 1));
            System.out.print("Day name: ");
            days[i] = sc.nextLine();

            maxTemp[i] = readValidTemperature(sc, "Maximum temperature: ");
            minTemp[i] = readValidTemperature(sc, "Minimum temperature: ");
        }
    }

    private double readValidTemperature(Scanner sc, String message) {

        double temp;

        do {
            System.out.print(message);
            temp = sc.nextDouble();

            if (temp < -40 || temp > 40) {
                System.out.println("Temperature must be between -40 and 40.");
            }

        } while (temp < -40 || temp > 40);

        sc.nextLine(); // clear buffer
        return temp;
    }

    // Maximum temperatures between 15 and 20
    public void showMaxBetween15And20() {

        System.out.println("\nDays with maximum temperature between 15 and 20:");

        for (int i = 0; i < n; i++) {
            if (maxTemp[i] >= 15 && maxTemp[i] <= 20) {
                System.out.println(days[i] + " -> " + maxTemp[i]);
            }
        }
    }

    // Minimum temperatures below 0
    public void showMinBelowZero() {

        System.out.println("\nDays with minimum temperature below 0:");

        for (int i = 0; i < n; i++) {
            if (minTemp[i] < 0) {
                System.out.println(days[i] + " -> " + minTemp[i]);
            }
        }
    }

    // Calculate averages
    public void showAverages() {

        double sumMax = 0;
        double sumMin = 0;

        for (int i = 0; i < n; i++) {
            sumMax += maxTemp[i];
            sumMin += minTemp[i];
        }

        double avgMax = sumMax / n;
        double avgMin = sumMin / n;

        System.out.println("\nAverage maximum temperature: " + avgMax);
        System.out.println("Average minimum temperature: " + avgMin);
    }

    // Show final list
    public void showAllData() {

        System.out.println("\nFinal list of temperatures:");

        for (int i = 0; i < n; i++) {
            System.out.println(days[i]
                    + " -> Max: " + maxTemp[i]
                    + " | Min: " + minTemp[i]);
        }
    }
}
