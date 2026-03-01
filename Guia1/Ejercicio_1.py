# Vectores y matriz (estructuras estáticas)
brands = []
names = []
prices_matrix = []   # Matriz Nx5


class project_1:

    def __init__(self):
        print("---------------------------------------------------")
        print("-------------Welcome to our program----------------")
        print("---------------------------------------------------")

    # ---------------------------------------------
    def request_cell_phone_information(self):

        brands.clear()
        names.clear()
        prices_matrix.clear()

        n = int(input("Enter the number of cell phones you wish to register: "))

        for i in range(n):

            brand = input("* Enter the cell phone brand: ")
            name = input("* Enter the cell phone name: ")

            brands.append(brand)
            names.append(name)

            print("--------------------------------")
            print("Enter prices for years 2021 to 2025")

            row = []

            for j in range(5):
                year = 2021 + j

                while True:
                    price = int(input(f"* Enter the price for {year}: "))

                    if price <= 0:
                        print("Only positive values are allowed.")
                    else:
                        row.append(price)
                        break

            prices_matrix.append(row)

        print("\nData registered successfully.\n")

    # ---------------------------------------------
    def show_information(self):

        if len(brands) == 0:
            print("No data registered yet.")
            return

        print("\nLIST OF CELL PHONES\n")

        for i in range(len(brands)):
            print("Brand:", brands[i])
            print("Name :", names[i])

            for j in range(5):
                print(f"Year {2021 + j}: ${prices_matrix[i][j]}")

            print("-------------------------------------")

    # ---------------------------------------------
    def show_cheapest_each_year(self):

        if len(brands) == 0:
            print("No data registered yet.")
            return

        print("\nCHEAPEST CELL PHONES BY YEAR\n")

        for j in range(5):

            min_price = prices_matrix[0][j]

            for i in range(1, len(prices_matrix)):
                if prices_matrix[i][j] < min_price:
                    min_price = prices_matrix[i][j]

            print(f"Year {2021 + j} - Cheapest price: ${min_price}")

            for i in range(len(prices_matrix)):
                if prices_matrix[i][j] == min_price:
                    print(f"   {brands[i]} {names[i]}")

    # ---------------------------------------------
    def show_most_expensive_each_year(self):

        if len(brands) == 0:
            print("No data registered yet.")
            return

        print("\nMOST EXPENSIVE CELL PHONES BY YEAR\n")

        for j in range(5):

            max_price = prices_matrix[0][j]

            for i in range(1, len(prices_matrix)):
                if prices_matrix[i][j] > max_price:
                    max_price = prices_matrix[i][j]

            print(f"Year {2021 + j} - Highest price: ${max_price}")

            for i in range(len(prices_matrix)):
                if prices_matrix[i][j] == max_price:
                    print(f"   {brands[i]} {names[i]}")

    # ---------------------------------------------
    def average_between_range(self):

        if len(brands) == 0:
            print("No data registered yet.")
            return

        year = int(input("Enter the year (2021 - 2025): "))

        if year < 2021 or year > 2025:
            print("Invalid year.")
            return

        column = year - 2021

        total = 0
        count = 0

        for i in range(len(prices_matrix)):

            value = prices_matrix[i][column]

            if value >= 1500000 and value <= 3000000:
                total += value
                count += 1

        if count == 0:
            print("There are no phones in that price range for this year.")
        else:
            average = total / count
            print(f"Average price for {year}: {average}")

    # ---------------------------------------------
    def menu(self):

        while True:

            print("\n------------ MENU ------------")
            print("1. Register cell phones")
            print("2. Show list of cell phones and prices")
            print("3. Show cheapest cell phones by year")
            print("4. Show most expensive cell phones by year")
            print("5. Show average price (1,500,000 - 3,000,000) by year")
            print("6. Exit")
            print("------------------------------")

            option = input("Choose an option: ")

            if option == "1":
                self.request_cell_phone_information()

            elif option == "2":
                self.show_information()

            elif option == "3":
                self.show_cheapest_each_year()

            elif option == "4":
                self.show_most_expensive_each_year()

            elif option == "5":
                self.average_between_range()

            elif option == "6":
                print("Goodbye.")
                break

            else:
                print("Invalid option.")


# -----------------------------
# Main
# project = project_1()
# project.menu()
foo = (1, 2, 3)
foo.index(0)

