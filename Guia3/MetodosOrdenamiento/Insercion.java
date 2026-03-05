package Guia3.MetodosOrdenamiento;

public class Insercion {

    //Variables
    private int[] arreglo1;
    
    // Metodo constructor vacío
    public Insercion(){}

    public Insercion(int[] arreglo){
        this.arreglo1 = arreglo;
    }

    // Metodos getters y setters
    public int[] getArreglo() {
        return arreglo1;
    }

    public void setArreglo(int[] arreglo) {
        this.arreglo1 = arreglo;
    }

    // Metodo de ordenamiento por inserción
    public void ordenarInsercion(){
        int n = arreglo1.length;
        long inicio = System.nanoTime(); // iniciar tiempo
        
        for (int i = 1; i < n; i++) {
            int key = arreglo1[i];
            int j = i - 1;

            // Mover los elementos del arreglo que son mayores que la clave
            // a una posición adelante de su posición actual
            while (j >= 0 && arreglo1[j] > key) {
                arreglo1[j + 1] = arreglo1[j];
                j = j - 1;
            }
            arreglo1[j + 1] = key;
        }
        long fin = System.nanoTime(); // terminar tiempo
        long tiempo = fin - inicio;


        for (int num : arreglo1) {
            System.out.print(num + " ");
        }
        System.out.println();
        System.out.println("\n --------------Tiempo de ejecución: " + (tiempo / 1_000_000.0) + " ms---------------- \n");
    }

    
}