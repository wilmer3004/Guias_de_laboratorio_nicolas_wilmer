package Guia3.MetodosOrdenamiento;

public class HeapSort {

    // Variables
    private int[] arreglo;

    // Constructor vacío
    public HeapSort(){}

    // Constructor con parámetros
    public HeapSort(int[] arreglo){
        this.arreglo = arreglo;
    }

    // Getters y setters
    public int[] getArreglo() {
        return arreglo;
    }

    public void setArreglo(int[] arreglo) {
        this.arreglo = arreglo;
    }

    // Método HeapSort
    public void ordenarHeapSort(){
        int n = arreglo.length;
        long inicio = System.nanoTime(); // iniciar tiempo

        // Construir el heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arreglo, n, i);
        }

        // Extraer elementos uno por uno
        for (int i = n - 1; i > 0; i--) {

            // Mover la raíz al final
            int temp = arreglo[0];
            arreglo[0] = arreglo[i];
            arreglo[i] = temp;

            // Llamar heapify en el heap reducido
            heapify(arreglo, i, 0);
        }

        long fin = System.nanoTime(); // terminar tiempo
        long tiempo = fin - inicio;

        // Mostrar arreglo ordenado
        for (int num : arreglo) {
            System.out.print(num + " ");
        }

        System.out.println();
        System.out.println("\n --------------Tiempo de ejecución: " + (tiempo / 1_000_000.0) + " ms---------------- \n");
    }

    // Método para mantener la propiedad del heap
    private void heapify(int[] arr, int n, int i) {
        int mayor = i;       // raíz
        int izquierda = 2 * i + 1;
        int derecha = 2 * i + 2;

        // Si el hijo izquierdo es mayor que la raíz
        if (izquierda < n && arr[izquierda] > arr[mayor]) {
            mayor = izquierda;
        }

        // Si el hijo derecho es mayor que el mayor actual
        if (derecha < n && arr[derecha] > arr[mayor]) {
            mayor = derecha;
        }

        // Si el mayor no es la raíz
        if (mayor != i) {
            int swap = arr[i];
            arr[i] = arr[mayor];
            arr[mayor] = swap;

            // Aplicar heapify recursivamente
            heapify(arr, n, mayor);
        }
    }
}