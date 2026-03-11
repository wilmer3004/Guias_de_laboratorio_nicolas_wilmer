import random
import time

# cantidad de números
n = 1000

# generar lista aleatoria entre 100 y 7000
numbers = [random.randint(100,7000) for i in range(n)]

def bubble_sort(arr):
    for i in range(len(arr)):
        for j in range(len(arr)-1-i):
            if arr[j] > arr[j+1]:
                arr[j], arr[j+1] = arr[j+1], arr[j]

def insertion_sort(arr):
    for i in range(1, len(arr)):
        key = arr[i]
        j = i - 1

        while j >= 0 and key < arr[j]:
            arr[j+1] = arr[j]
            j -= 1

        arr[j+1] = key

def selection_sort(arr):
    for i in range(len(arr)):
        min_idx = i

        for j in range(i+1, len(arr)):
            if arr[j] < arr[min_idx]:
                min_idx = j

        arr[i], arr[min_idx] = arr[min_idx], arr[i]

def shell_sort(arr):
    n = len(arr)
    gap = n // 2

    while gap > 0:
        for i in range(gap, n):
            temp = arr[i]
            j = i

            while j >= gap and arr[j-gap] > temp:
                arr[j] = arr[j-gap]
                j -= gap

            arr[j] = temp

        gap //= 2

def quick_sort(arr):
    if len(arr) <= 1:
        return arr

    pivot = arr[len(arr)//2]

    left = [x for x in arr if x < pivot]
    middle = [x for x in arr if x == pivot]
    right = [x for x in arr if x > pivot]

    return quick_sort(left) + middle + quick_sort(right)

def measure_time(sort_func, data):

    start = time.perf_counter()

    if sort_func == quick_sort:
        sort_func(data)
    else:
        sort_func(data)

    end = time.perf_counter()

    return (end - start) * 1000

algorithms = [
    ("Bubble", bubble_sort),
    ("Insertion", insertion_sort),
    ("Selection", selection_sort),
    ("Shell", shell_sort),
    ("Quick", quick_sort)
]

print(f"Python sorting times (n={n}):")

for name, func in algorithms:
    data_copy = numbers.copy()
    t = measure_time(func, data_copy)
    print(f"{name} Sort: {t:.6f} ms")