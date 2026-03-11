#include <iostream>
#include <vector>
#include <cstdlib>
#include <ctime>
#include <chrono>

using namespace std;
using namespace chrono;

void bubbleSort(vector<int>& arr){
    for(int i=0;i<arr.size();i++){
        for(int j=0;j<arr.size()-1-i;j++){
            if(arr[j] > arr[j+1]){
                swap(arr[j], arr[j+1]);
            }
        }
    }
}


void insertionSort(vector<int>& arr){
    for(int i=1;i<arr.size();i++){
        int key = arr[i];
        int j = i-1;

        while(j >= 0 && arr[j] > key){
            arr[j+1] = arr[j];
            j--;
        }

        arr[j+1] = key;
    }
}

void selectionSort(vector<int>& arr){
    for(int i=0;i<arr.size();i++){
        int minIndex = i;

        for(int j=i+1;j<arr.size();j++){
            if(arr[j] < arr[minIndex]){
                minIndex = j;
            }
        }

        swap(arr[i], arr[minIndex]);
    }
}

void shellSort(vector<int>& arr){
    int n = arr.size();

    for(int gap = n/2; gap > 0; gap /= 2){

        for(int i = gap; i < n; i++){

            int temp = arr[i];
            int j;

            for(j = i; j >= gap && arr[j-gap] > temp; j -= gap){
                arr[j] = arr[j-gap];
            }

            arr[j] = temp;
        }
    }
}


int main(){

    int n = 1000;

    vector<int> numbers;

    srand(time(0));

    for(int i=0;i<n;i++){
        numbers.push_back(rand()%6901 + 100);
    }

    vector<int> data;

    cout << "C++ sorting times (n=1000):" << endl;

    data = numbers;
    auto start = high_resolution_clock::now();
    bubbleSort(data);
    auto end = high_resolution_clock::now();
    cout << "Bubble Sort: "
         << duration<double, milli>(end-start).count()
         << " ms" << endl;


    data = numbers;
    start = high_resolution_clock::now();
    insertionSort(data);
    end = high_resolution_clock::now();
    cout << "Insertion Sort: "
         << duration<double, milli>(end-start).count()
         << " ms" << endl;


    data = numbers;
    start = high_resolution_clock::now();
    selectionSort(data);
    end = high_resolution_clock::now();
    cout << "Selection Sort: "
         << duration<double, milli>(end-start).count()
         << " ms" << endl;


    data = numbers;
    start = high_resolution_clock::now();
    shellSort(data);
    end = high_resolution_clock::now();
    cout << "Shell Sort: "
         << duration<double, milli>(end-start).count()
         << " ms" << endl;


    return 0;
}