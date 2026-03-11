
let n = 1000;

let numbers = [];
for (let i = 0; i < n; i++) {
    numbers.push(Math.floor(Math.random() * (7000 - 100 + 1)) + 100);
}

function bubbleSort(arr) {
    for (let i = 0; i < arr.length; i++) {
        for (let j = 0; j < arr.length - 1 - i; j++) {
            if (arr[j] > arr[j + 1]) {
                let temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
    }
}

function insertionSort(arr) {
    for (let i = 1; i < arr.length; i++) {
        let key = arr[i];
        let j = i - 1;

        while (j >= 0 && arr[j] > key) {
            arr[j + 1] = arr[j];
            j--;
        }

        arr[j + 1] = key;
    }
}

function selectionSort(arr) {
    for (let i = 0; i < arr.length; i++) {
        let minIndex = i;

        for (let j = i + 1; j < arr.length; j++) {
            if (arr[j] < arr[minIndex]) {
                minIndex = j;
            }
        }

        let temp = arr[i];
        arr[i] = arr[minIndex];
        arr[minIndex] = temp;
    }
}

function shellSort(arr) {
    let n = arr.length;

    for (let gap = Math.floor(n / 2); gap > 0; gap = Math.floor(gap / 2)) {

        for (let i = gap; i < n; i++) {

            let temp = arr[i];
            let j = i;

            while (j >= gap && arr[j - gap] > temp) {
                arr[j] = arr[j - gap];
                j -= gap;
            }

            arr[j] = temp;
        }
    }
}

function quickSort(arr) {
    if (arr.length <= 1) return arr;

    let pivot = arr[Math.floor(arr.length / 2)];

    let left = arr.filter(x => x < pivot);
    let middle = arr.filter(x => x === pivot);
    let right = arr.filter(x => x > pivot);

    return [...quickSort(left), ...middle, ...quickSort(right)];
}

function measureTime(sortFunc, data) {

    let start = performance.now();

    if (sortFunc === quickSort) {
        sortFunc(data);
    } else {
        sortFunc(data);
    }

    let end = performance.now();

    return end - start;
}
let algorithms = [
    ["Bubble", bubbleSort],
    ["Insertion", insertionSort],
    ["Selection", selectionSort],
    ["Shell", shellSort],
    ["Quick", quickSort]
];

console.log("JavaScript sorting times (n=1000):");

for (let [name, func] of algorithms) {

    let dataCopy = [...numbers];

    let t = measureTime(func, dataCopy);

    console.log(`${name} Sort: ${t.toFixed(6)} ms`);
}