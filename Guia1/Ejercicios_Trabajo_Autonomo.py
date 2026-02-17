import random as r

def number_count():
    matrix = []
    for i in range(10):
        matrix_number = []
        for j in range(10):
            matrix_number.append(r.randint(0,999))
        matrix.append(matrix_number)
    
    for i in range(9,0,-1):
        for j in range(9,0,-1):
            print(f"{matrix[i][j]}, ",end="")
        print(f"\nVa en la posición (x={i},y={j})")

number_count()