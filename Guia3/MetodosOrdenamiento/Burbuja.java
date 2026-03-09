package Guia3.MetodosOrdenamiento;
import Guia3.MetodosOrdenamiento.ImprimirTabla;

public class Burbuja {

    //Variables
    private int[] arreglo1;
    final ImprimirTabla imprimir1 = new ImprimirTabla();

    // Metodo constructor vacío
    public Burbuja(){

    }

    public Burbuja(int[] arreglo){
        this.arreglo1 = arreglo;
    }

    // Metodos getters y setters
    public int[] getArreglo() {
        return arreglo1;
    }

    public void setArreglo(int[] arreglo) {
        this.arreglo1 = arreglo;
    }

    // Metodo de ordenamiento burbuja
    public void ordenarBurbuja(){

        int n = arreglo1.length;
        long inicio = System.nanoTime(); // iniciar tiempo
        
        for (int i=0; i<n-1; i++){
            for (int j =0; j<n-1; j++){
                if (arreglo1[j] > arreglo1[j+1]){
                    // Intercambiar arreglo original por arreglo ordenado
                    int temp = arreglo1[j];
                    arreglo1[j] = arreglo1[j+1];
                    arreglo1[j+1]= temp;
                }
            }
        }

        long fin = System.nanoTime(); // terminar tiempo
        long tiempo = fin - inicio;

        imprimir1.imprimir(arreglo1);
        System.out.println();
        System.out.println("\n --------------Tiempo de ejecución: " + (tiempo / 1_000_000.0) + " ms---------------- \n");
        }   
    }