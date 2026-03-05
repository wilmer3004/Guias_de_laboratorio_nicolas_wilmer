package Guia3.MetodosOrdenamiento;

public class Seleccion {

    // variables
    private int[] arreglo1;

    // Metodo constructor vacío
    public Seleccion(){}

    // Metodo constructor con arreglo
    public Seleccion(int[] arreglo){
        this.arreglo1 = arreglo;
    }

    // Metodos getters y setters
    public int[] getArreglo() {
        return arreglo1;}
    
    public void setArreglo(int[] arreglo) {
        this.arreglo1 = arreglo;}

    // Metodo de ordenamiento por selección
    public void ordenarSeleccion(){
        int n = arreglo1.length;
        long inicio = System.nanoTime(); // iniciar tiempo
        for (int i = 0; i < n-1; i++){
            int min_idx = i;
            for (int j = i+1; j < n; j++){
                if (arreglo1[j] < arreglo1[min_idx]){
                    min_idx = j;
                }
            }
            // Intercambiar el elemento mínimo encontrado con el primer elemento
            int temp = arreglo1[min_idx];
            arreglo1[min_idx] = arreglo1[i];
            arreglo1[i] = temp;
        }
        long fin = System.nanoTime(); // terminar tiempo
        long tiempo = fin - inicio;
        for (int num : arreglo1) {
            System.out.print(num + " ");
        }
        System.out.println();
        System.out.println("\n --------------Tiempo de ejecución: " + (tiempo / 1_000_000.0) + " ms---------------- \n");}

}