// 🔹 Variables globales para evitar errores destroy
let graficaQuick = null;
let graficaBinaria = null;

// 🔹 QuickSort
function quickSort(arr) {
    if (arr.length <= 1) return arr;

    let pivot = arr[arr.length - 1];
    let left = [];
    let right = [];

    for (let i = 0; i < arr.length - 1; i++) {
        if (arr[i] < pivot) left.push(arr[i]);
        else right.push(arr[i]);
    }

    return [...quickSort(left), pivot, ...quickSort(right)];
}

// 🔹 Búsqueda Binaria
function binarySearch(arr, target) {
    let left = 0;
    let right = arr.length - 1;

    while (left <= right) {
        let mid = Math.floor((left + right) / 2);

        if (arr[mid] === target) return mid;
        else if (arr[mid] < target) left = mid + 1;
        else right = mid - 1;
    }

    return -1;
}

// 🔹 Generar arreglo
function generarArreglo(size) {
    let arr = [];
    for (let i = 0; i < size; i++) {
        arr.push(Math.floor(Math.random() * size));
    }
    return arr;
}

// 🔹 Ejecutar pruebas
function ejecutarPruebas() {
    let tamaños = [100, 1000, 5000, 10000, 100000,1000000];
    let resultados = [];

    tamaños.forEach(size => {

        let arr = generarArreglo(size);

        // QuickSort
        let inicioQS = performance.now();
        let arrOrdenado = quickSort(arr);
        let finQS = performance.now();
        let tiempoQS = finQS - inicioQS;

        // Búsqueda Binaria
        let objetivo = arrOrdenado[Math.floor(Math.random() * size)];

        let repeticiones = 1000;
        let inicioBS = performance.now();

        for (let i = 0; i < repeticiones; i++) {
            binarySearch(arrOrdenado, objetivo);
        }

        let finBS = performance.now();
        let tiempoBS = (finBS - inicioBS) / repeticiones;

        resultados.push({ size, tiempoQS, tiempoBS });

        // 🔥 ACTUALIZAR CELDAS EXISTENTES
        actualizarCelda(`qs-${size}`, tiempoQS.toFixed(4));
        actualizarCelda(`bs-${size}`, tiempoBS.toFixed(8));
    });

    crearGraficas(resultados);
}

// 🔹 Crear gráficas
function crearGraficas(datos) {

    let variacionQS = [];
    let variacionBS = [];

    for (let i = 1; i < datos.length; i++) {
        variacionQS.push(datos[i].tiempoQS - datos[i - 1].tiempoQS);
        variacionBS.push(datos[i].tiempoBS - datos[i - 1].tiempoBS);
    }

    let labels = datos.map(d => d.size);

    // 🔸 QuickSort
    const ctx1 = document.getElementById('graficaQuick').getContext('2d');

    if (graficaQuick) graficaQuick.destroy();

    graficaQuick = new Chart(ctx1, {
        type: 'line',
        data: {
            labels: labels,
            datasets: [
                {
                    label: 'Tiempo QuickSort (ms)',
                    data: datos.map(d => d.tiempoQS),
                    borderColor: 'blue',
                    backgroundColor: 'blue',
                    borderWidth: 2,
                    pointRadius: 5,
                    tension: 0.3
                },
                {
                    label: 'Variación QuickSort',
                    data: [0, ...variacionQS],
                    borderColor: 'red',
                    backgroundColor: 'red',
                    borderDash: [5, 5],
                    borderWidth: 2,
                    pointRadius: 5,
                    tension: 0.3
                }
            ]
        },
        options: {
            responsive: true,
            maintainAspectRatio: false,
            scales: {
                x: {
                    title: {
                        display: true,
                        text: 'Tamaño del arreglo'
                    }
                },
                y: {
                    title: {
                        display: true,
                        text: 'Tiempo (ms)'
                    },
                    beginAtZero: true
                }
            }
        }
    });

    // 🔸 Búsqueda Binaria
    const ctx2 = document.getElementById('graficaBinaria').getContext('2d');

    if (graficaBinaria) graficaBinaria.destroy();

    graficaBinaria = new Chart(ctx2, {
        type: 'line',
        data: {
            labels: labels,
            datasets: [
                {
                    label: 'Tiempo Búsqueda Binaria (ms)',
                    data: datos.map(d => d.tiempoBS),
                    borderColor: 'green',
                    backgroundColor: 'green',
                    borderWidth: 2,
                    pointRadius: 5,
                    tension: 0.3
                },
                {
                    label: 'Variación Búsqueda Binaria',
                    data: [0, ...variacionBS],
                    borderColor: 'orange',
                    backgroundColor: 'orange',
                    borderDash: [5, 5],
                    borderWidth: 2,
                    pointRadius: 5,
                    tension: 0.3
                }
            ]
        },
        options: {
            responsive: true,
            maintainAspectRatio: false,
            scales: {
                x: {
                    title: {
                        display: true,
                        text: 'Tamaño del arreglo'
                    }
                },
                y: {
                    title: {
                        display: true,
                        text: 'Tiempo (ms)'
                    },
                    beginAtZero: true
                }
            }
        }
    });
}

function actualizarCelda(id, valor) {
    let celda = document.getElementById(id);
    
    celda.textContent = valor;

    // Animación
    celda.classList.add("actualizado");

    setTimeout(() => {
        celda.classList.remove("actualizado");
    }, 1000);
}