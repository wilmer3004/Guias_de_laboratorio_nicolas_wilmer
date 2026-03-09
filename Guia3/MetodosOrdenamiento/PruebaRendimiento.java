package Guia3.MetodosOrdenamiento;

import java.util.Random;

public class PruebaRendimiento {

    public static void pruebaRendimiento(){

        int[] tamanos = {10, 50, 100, 1000};
        Random r = new Random();

        // matriz para guardar los resultados
        double[][] resultados = new double[tamanos.length][6];

        for(int i = 0; i < tamanos.length; i++){

            int n = tamanos[i];
            int[] base = new int[n];

            for(int j = 0; j < n; j++){
                base[j] = r.nextInt(1000000);
            }

            int[] copia;

            copia = base.clone();
            resultados[i][0] = new Burbuja(copia).ordenarBurbuja();

            copia = base.clone();
            resultados[i][1] = new Insercion(copia).ordenarInsercion();

            copia = base.clone();
            resultados[i][2] = new Seleccion(copia).ordenarSeleccion();

            copia = base.clone();
            resultados[i][3] = new Shell(copia).ordenarShell();

            copia = base.clone();
            resultados[i][4] = new HeapSort(copia).ordenarHeapSort();

            copia = base.clone();
            resultados[i][5] = new QuickSort(copia).ordenarQuickSort();
        }

        // imprimir tabla después de ejecutar todo
        System.out.println("\nTABLA DE RENDIMIENTO (Tiempo en ms)");
        System.out.println("-------------------------------------------------------------------------------------------");
        System.out.printf("%12s %12s %12s %12s %12s %12s %12s\n",
                "N", "Burbuja", "Insercion", "Seleccion", "Shell", "HeapSort", "QuickSort");
        System.out.println("-------------------------------------------------------------------------------------------");

        for(int i = 0; i < tamanos.length; i++){
            System.out.printf("%12d %12.2f %12.2f %12.2f %12.2f %12.2f %12.2f\n",
                    tamanos[i],
                    resultados[i][0],
                    resultados[i][1],
                    resultados[i][2],
                    resultados[i][3],
                    resultados[i][4],
                    resultados[i][5]);
        }

        System.out.println("-------------------------------------------------------------------------------------------");
    }
}