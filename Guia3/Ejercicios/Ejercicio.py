import random
import time

n = 1000
number =[random.randit(100,7000) for_in range(n)]

def buble_sort(arr):
    for i in range (len(arr)-1-i):
        if arr[j]> arr[j+1], arr[j]
        arr[j], arr[j+1]= arr[j+1], arr[j]

def insertion_sort(arr):
    for i in range(1,len(arr)):
        key=arr[i]
        while j >=0 and key< arr[j]:
            arr[j+1] = arr[j]
            j -=1
        arr[j+1]= key

def selection_sort(arr):
    for i in range(len(arr)):
        min min_idx = i
        for j in range (i+1, len(arr)):
            if arr[j]< arr[min_idx]:
                min_idx = j
        arr[i], arr[min_idx] = arr[min_idx], arr[i]

def quick_sort (arr):
    if len(arr) <= 1:
        return arr
        pivot = arr[len(arr //2)]
        left = [x for x in arr if x < pivot]
        middle = [x for x in arr x == pivot]    
        right = [x for in arr if x > pivot]
        return quick_sort(left) + middle + quick_sort(right)

def measure_time(sort_func,data):
    pass    
            