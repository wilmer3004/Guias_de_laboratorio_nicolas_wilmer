class CompanySales:
    def __init__(self):
        self.sites = 6
        self.days = 7
        self.day_names = ["Monday", "Tuesday", "Wednesday", "Thursday",
                          "Friday", "Saturday", "Sunday"]

        # Matrix: rows = sites, columns = days
        self.sales = [[0.0 for _ in range(self.days)] for _ in range(self.sites)]

    # ---------------------------------------------
    # Fill the matrix with sales
    def fill_sales(self):
        for i in range(self.sites):
            print(f"\nEnter sales for site {i + 1}")
            for j in range(self.days):
                value = float(input(f"  {self.day_names[j]}: "))
                self.sales[i][j] = value

    # ---------------------------------------------
    # Weekly average of the whole company
    def company_week_average(self):
        total = 0
        count = self.sites * self.days

        for i in range(self.sites):
            for j in range(self.days):
                total += self.sales[i][j]

        return total / count

    # ---------------------------------------------
    # Weekly average for one site
    def site_week_average(self, site_index):
        total = 0

        for j in range(self.days):
            total += self.sales[site_index][j]

        return total / self.days

    # ---------------------------------------------
    # Show days above the weekly average of each site
    def show_days_above_site_average(self):
        for i in range(self.sites):
            avg = self.site_week_average(i)
            print(f"\nSite {i + 1} - weekly average: {avg:.2f}")
            print("Days above the average:")

            found = False
            for j in range(self.days):
                if self.sales[i][j] > avg:
                    print(f"  {self.day_names[j]} -> {self.sales[i][j]}")
                    found = True

            if not found:
                print("  None")

    # ---------------------------------------------
    # Show weekly average for all sites
    def show_site_averages(self):
        print("\nWeekly average per site:")
        for i in range(self.sites):
            avg = self.site_week_average(i)
            print(f"Site {i + 1}: {avg:.2f}")

    # ---------------------------------------------
    # Increase by 15% the daily sales below
    # the weekly average of each site
    def increase_below_site_average(self):
        for i in range(self.sites):
            avg = self.site_week_average(i)

            for j in range(self.days):
                if self.sales[i][j] < avg:
                    self.sales[i][j] = self.sales[i][j] * 1.15

    # ---------------------------------------------
    # Show the sales matrix
    def show_sales(self):
        print("\nSales matrix (sites x days)")
        for i in range(self.sites):
            print(f"Site {i + 1}: ", end="")
            for j in range(self.days):
                print(f"{self.sales[i][j]:.2f}", end="  ")
            print()


# -------------------------------------------------
# Main program

# -------------------------------------------------
# Main program with menu

company = CompanySales()

option = 0  

while option != 6:
    print("\n------ MENU ------")
    print("1. Fill sales matrix")
    print("2. Show sales matrix")
    print("3. Show company weekly average")
    print("4. Show weekly average per site and days above site average")
    print("5. Increase by 15% sales below site average")
    print("6. Exit")

    option = int(input("Select an option: "))

    if option == 1:
        company.fill_sales()

    elif option == 2:
        company.show_sales()

    elif option == 3:
        print("\nCompany weekly average:")
        print(f"{company.company_week_average():.2f}")

    elif option == 4:
        company.show_site_averages()
        company.show_days_above_site_average()

    elif option == 5:
        company.increase_below_site_average()
        print("\nSales updated.")

    elif option == 6:
        print("Good bye.")

    else:
        print("Invalid option.")

