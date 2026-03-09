package Guia3.MetodosOrdenamiento;
/*
Elabore un programa, en el ambiente de desarrollo NetBeans (Seguimos utilizando interfaz
gráfica de usuario GUI y POO), que permita leer un arreglo de n números ingresados por teclado o
generados aleatoriamente, ordenarlo y mostrarlo, haciendo uso de los algoritmos de ordenamiento:
Burbuja, Inserción, Selección, Shell, HeapSort y Quick Sort. (investigar los códigos en internet y en el
material que se compartió en sesiones anteriores de cada ordenamiento)
*/

import java.util.Scanner;
import java.util.Random;
import Guia3.MetodosOrdenamiento.Burbuja;
import Guia3.MetodosOrdenamiento.Insercion;
import Guia3.MetodosOrdenamiento.Seleccion;
import Guia3.MetodosOrdenamiento.Shell;
import Guia3.MetodosOrdenamiento.HeapSort;
import Guia3.MetodosOrdenamiento.QuickSort;
import Guia3.MetodosOrdenamiento.ImprimirTabla;

public class MainMetodosOrdenamiento {
        
    static Scanner sc = new Scanner(System.in);
    static final ImprimirTabla imprimir = new ImprimirTabla();
    
    public static void menuDosOrdenamiento(int[] arreglo){
        int opcionMenuDos;
        int [] arregloOriginal = arreglo.clone(); // Clonar el arreglo original para mantenerlo sin modificar
        do{

        System.out.println("\n\n---------------------------------------------------------------");
        System.out.println("               MENU DE OPCIONES DE ORDENAMIENTO");
        System.out.println("---------------------------------------------------------------");

        System.out.println("Arreglo original:");
        imprimir.imprimir(arregloOriginal);

        System.out.println("---------------------------------------------------------------");
        System.out.println("| Opción | Algoritmo de Ordenamiento                         |");
        System.out.println("---------------------------------------------------------------");
        System.out.println("|   1    | Burbuja                                           |");
        System.out.println("|   2    | Inserción                                         |");
        System.out.println("|   3    | Selección                                         |");
        System.out.println("|   4    | Shell                                             |");
        System.out.println("|   5    | HeapSort                                          |");
        System.out.println("|   6    | Quick Sort                                        |");
        System.out.println("|   7    | Salir                                             |");
        System.out.println("---------------------------------------------------------------");
        System.out.print("Ingrese su opción: ");



            opcionMenuDos = sc.nextInt();
            switch(opcionMenuDos){
            case 1:
                System.out.println("\n-------------Ordenando con el método de Burbuja-----------------");
                    Burbuja burbuja = new Burbuja(arreglo);
                    burbuja.ordenarBurbuja();
                // Llamar al método de ordenamiento Burbuja
                break;
            case 2:
                System.out.println("\n-------------Ordenando con el método de Inserción-----------------");
                Insercion insercion = new Insercion(arreglo);
                insercion.ordenarInsercion();
                // Llamar al método de ordenamiento Inserción
                break;
            case 3:
                System.out.println("\n-------------Ordenando con el método de Selección-----------------");
                Seleccion seleccion = new Seleccion(arreglo);
                seleccion.ordenarSeleccion();
                // Llamar al método de ordenamiento Selección
                break;
            case 4:
                System.out.println("\n-------------Ordenando con el método de Shell-----------------");
                Shell shell = new Shell(arreglo);
                shell.ordenarShell();
                // Llamar al método de ordenamiento Shell
                break;
            case 5:
                System.out.println("\n-------------Ordenando con el método de HeapSort-----------------");
                HeapSort heapSort = new HeapSort(arreglo);
                heapSort.ordenarHeapSort();
                // Llamar al método de ordenamiento HeapSort
                break;
            case 6:
                System.out.println("\n-------------Ordenando con el método de Quick Sort-----------------1");
                QuickSort quickSort = new QuickSort(arreglo);
                quickSort.ordenarQuickSort();
                // Llamar al método de ordenamiento Quick Sort
                break;
            case 7:
                System.out.println("Saliendo del menu 2...");
                break;
            default:
                System.out.println("Opción no válida. Por favor, ingrese una opción del 1 al 7.");
        }
        }while(opcionMenuDos != 7);
        
    }

    public static void main(String[] args) {
        Random r = new Random();
        int n;
        int[] arreglo ;
        int opcionMenuUno = 0;

        // Menu para ingresar el tamaño del arreglo y la forma de llenarlo
        do{
            System.out.println("-------------- Bienvenido al programa de ordenamiento --------------");
            System.out.println("Ingrese el tamaño del arreglo: ");
            n = sc.nextInt();
            if(n >0){
                arreglo = new int[n];
                System.out.println("\n\n---------------------------------------------\n" +
                "                    MENU DE OPCIONES\n" +
                "---------------------------------------------\n" +
                "| Opción | Acción                           |\n" +
                "---------------------------------------------\n" +
                "|   1    | Ingresar los números por teclado |\n" +
                "|   2    | Generar números aleatorios       |\n" +
                "|   3    | Prueba de rendimiento            |\n" +
                "|   4    | Salir                            |\n" +
                "---------------------------------------------\n" +
                "Ingrese su opción:");
                opcionMenuUno = sc.nextInt();

                switch(opcionMenuUno){
                    case 1:
                        System.out.println("Ingrese manualmente los numeros del arreglo;");
                        for(int i = 0; i<n; i++){
                            System.out.println("Ingrese el numero " + (i+1) + ": ");
                            arreglo[i] = sc.nextInt();
                        }
                        menuDosOrdenamiento(arreglo);
                        break;

                    case 2:
                        System.out.println("Generando numeros aleatorios...");
                        for(int i = 0; i<n; i++){
                            arreglo[i] = r.nextInt(100); // Genera números aleatorios entre 0 y 99
                        }
                        System.out.println("Numeros generados: ");
                        for(int num : arreglo){
                            System.out.print(num + " ");
                        }
                        System.out.println();
                        menuDosOrdenamiento(arreglo);
                        break;
                    case 3:
                        System.out.println("Realizando prueba de rendimiento...");
                        // Generar un arreglo grande para la prueba de rendimiento
                        PruebaRendimiento.pruebaRendimiento();
                        break;

                    case 4:
                        System.out.println("Saliendo del programa...");
                        break;
                    default:
                        System.out.println("Opción no válida. Por favor, ingrese una opción del 1 al 3.");
                }
            }
                else{
                    System.out.println("El tamaño del arreglo debe ser mayor a 0. Por favor, ingrese un número válido.");
                }
                
                
        }while(opcionMenuUno != 4);



        sc.close();

    }
    

    
    
}

