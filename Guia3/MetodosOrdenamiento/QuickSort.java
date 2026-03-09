package Guia3.MetodosOrdenamiento;

public class QuickSort {

    //variables
    private int[] arreglo;
    final ImprimirTabla imprimir1 = new ImprimirTabla();


    // Metodo constructor vacío
    public QuickSort(){}
    
    // Metodo constructor con parámetros
    public QuickSort(int[] arreglo){
        this.arreglo = arreglo;}
    
    // getters y setters

    public int[] getArreglo() {
        return arreglo;
    }

    public void setArreglo(int[] arreglo) {
        this.arreglo = arreglo;
    }

    // Método para ordenar el arreglo utilizando el método de Quick Sort

    public double ordenarQuickSort(){
        long inicio = System.nanoTime(); // iniciar tiempo
        quickSort(arreglo, 0, arreglo.length - 1);
        long fin = System.nanoTime(); // finalizar tiempo
        long tiempo = fin - inicio;
        imprimir1.imprimir(arreglo);
        System.out.println();
        System.out.println("\n --------------Tiempo de ejecución: " + (tiempo / 1_000_000.0) + " ms---------------- \n");
        return (double) tiempo / 1_000_000.0;
    }

    // Método Quick Sort
    private void quickSort(int[] arr, int bajo, int alto) {
        if (bajo < alto) {
            int pi = partition(arr, bajo, alto);

            quickSort(arr, bajo, pi - 1);
            quickSort(arr, pi + 1, alto);
        }
    }

    // Método para particionar el arreglo
    private int partition(int[] arr, int bajo, int alto) {
        int pivot = arr[alto];
        int i = (bajo - 1);

        for (int j = bajo; j < alto; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[alto];
        arr[alto] = temp;

        return i + 1;
    }

}