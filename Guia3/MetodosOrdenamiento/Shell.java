package Guia3.MetodosOrdenamiento;

public class Shell {

    //variables
    private int[] arreglo;
    final ImprimirTabla imprimir1 = new ImprimirTabla();

    
    // Metodo constructor vacío
    public Shell(){}
    
    // Metodo constructor con parámetros
    public Shell(int[] arreglo){
        this.arreglo = arreglo;
    }

    // getters y setters

    public int[] getArreglo() {
        return arreglo;
    }

    public void setArreglo(int[] arreglo) {
        this.arreglo = arreglo;
    }

    // Método para ordenar el arreglo utilizando el método de Shell
    public void ordenarShell(){
        int n = arreglo.length;
        long inicio = System.nanoTime(); // iniciar tiempo
        // Comenzar con un intervalo grande, luego reducirlo
        for (int gap = n / 2; gap > 0; gap /= 2) {
            // Realizar un insertion sort para este intervalo
            for (int i = gap; i < n; i++) {
                int temp = arreglo[i];
                int j;
                for (j = i; j >= gap && arreglo[j - gap] > temp; j -= gap) {
                    arreglo[j] = arreglo[j - gap];
                }
                arreglo[j] = temp;
            }
        }
        long fin = System.nanoTime(); // finalizar tiempo
        
        imprimir1.imprimir(arreglo);
        long tiempo = fin - inicio;
        System.out.println();
        System.out.println("\n --------------Tiempo de ejecución: " + (tiempo / 1_000_000.0) + " ms---------------- \n");
    }
}