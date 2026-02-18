import random
from student import Student


# --------------------------------------------------
# 1. 10x10 matrix, random numbers, inverse traversal
# --------------------------------------------------

def matrix_10x10_inverse():

    matrix = []

    for i in range(10):
        row = []
        for j in range(10):
            row.append(random.randint(1, 100))
        matrix.append(row)

    print("\nMatrix:")
    for row in matrix:
        print(row)

    print("\nInverse traversal:")

    count = 0

    for i in range(9, -1, -1):
        for j in range(9, -1, -1):

            print(matrix[i][j], end=" ")
            count += 1

            if count % 10 == 0:
                print("\nCount goes at:", count)


# --------------------------------------------------
# 2. Generate even numbers between p and q
# --------------------------------------------------

def generate_even_numbers(p, q):

    print("\nEven numbers:")

    for i in range(p, q + 1):
        if i % 2 == 0:
            print(i)


# --------------------------------------------------
# 3. Generate first z multiples of 7
# --------------------------------------------------

def first_multiples_of_7(z):

    print("\nFirst multiples of 7:")

    for i in range(1, z + 1):
        print(7 * i)


# --------------------------------------------------
# 4. Sum of first m multiples of 5 and
#    first n multiples of 8
# --------------------------------------------------

def sum_multiples_5_and_8(m, n):

    sum5 = 0
    sum8 = 0

    print("\nMultiples of 5:")
    for i in range(1, m + 1):
        value = 5 * i
        sum5 += value
        print(value)

    print("\nMultiples of 8:")
    for i in range(1, n + 1):
        value = 8 * i
        sum8 += value
        print(value)

    print("\nSum of multiples of 5:", sum5)
    print("Sum of multiples of 8:", sum8)
    print("Total sum:", sum5 + sum8)


# --------------------------------------------------
# 5. Print any array (list)
# --------------------------------------------------

def print_array(array):

    print("\nArray content:")
    for value in array:
        print(value)


# --------------------------------------------------
# MAIN MENU
# --------------------------------------------------

def main_menu():

    student = None
    option = 0

    while option != 8:

        print("\n-----------------------------")
        print("MAIN MENU")
        print("1. 10x10 matrix inverse")
        print("2. Even numbers between p and q")
        print("3. First z multiples of 7")
        print("4. Sum of multiples of 5 and 8")
        print("5. Create student (abstract class test)")
        print("6. Show student")
        print("7. Print any array")
        print("8. Exit")
        print("-----------------------------")

        option = int(input("Option: "))

        if option == 1:

            matrix_10x10_inverse()

        elif option == 2:

            p = int(input("Enter p: "))
            q = int(input("Enter q: "))
            generate_even_numbers(p, q)

        elif option == 3:

            z = int(input("Enter z: "))
            first_multiples_of_7(z)

        elif option == 4:

            m = int(input("Enter m: "))
            n = int(input("Enter n: "))
            sum_multiples_5_and_8(m, n)

        elif option == 5:

            name = input("Enter name: ")
            age = int(input("Enter age: "))
            code = input("Enter code: ")

            student = Student(name, age, code)
            print("Student created")

        elif option == 6:

            if student is not None:
                student.show_info()
            else:
                print("No student created")

        elif option == 7:

            size = int(input("How many elements: "))
            array = []

            for i in range(size):
                value = input("Enter value: ")
                array.append(value)

            print_array(array)

        elif option == 8:

            print("Good bye")

        else:

            print("Invalid option")


# --------------------------------------------------
# Program start
# --------------------------------------------------

main_menu()
