package MetodosOrdenamiento;
/*
Elabore un programa, en el ambiente de desarrollo NetBeans (Seguimos utilizando interfaz
gráfica de usuario GUI y POO), que permita leer un arreglo de n números ingresados por teclado o
generados aleatoriamente, ordenarlo y mostrarlo, haciendo uso de los algoritmos de ordenamiento:
Burbuja, Inserción, Selección, Shell, HeapSort y Quick Sort. (investigar los códigos en internet y en el
material que se compartió en sesiones anteriores de cada ordenamiento)
*/

import java.util.Scanner;
import java.util.Random;

public class MainMetodosOrdenamiento {
        
    static Scanner sc = new Scanner(System.in);
    
    public static void menuDosOrdenamiento(int[] arreglo){
        int opcionMenuDos;
        do{
            System.out.println("Menu de opciones de ordenamiento:");
            System.out.println("1. Burbuja");
            System.out.println("2. Inserción");
            System.out.println("3. Selección");
            System.out.println("4. Shell");
            System.out.println("5. HeapSort");
            System.out.println("6. Quick Sort");
            System.out.println("7. Salir");
            System.out.println("Ingrese su opción: ");
            opcionMenuDos = sc.nextInt();
            switch(opcionMenuDos){
            case 1:
                System.out.println("Ordenando con el método de Burbuja...");
                // Llamar al método de ordenamiento Burbuja
                break;
            case 2:
                System.out.println("Ordenando con el método de Inserción...");
                // Llamar al método de ordenamiento Inserción
                break;
            case 3:
                System.out.println("Ordenando con el método de Selección...");
                // Llamar al método de ordenamiento Selección
                break;
            case 4:
                System.out.println("Ordenando con el método de Shell...");
                // Llamar al método de ordenamiento Shell
                break;
            case 5:
                System.out.println("Ordenando con el método de HeapSort...");
                // Llamar al método de ordenamiento HeapSort
                break;
            case 6:
                System.out.println("Ordenando con el método de Quick Sort...");
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
        int opcionMenuUno;

        // Menu para ingresar el tamaño del arreglo y la forma de llenarlo
        do{
            System.out.println("-------------- Bienvenido al programa de ordenamiento --------------");
            System.out.println("Ingrese el tamaño del arreglo: ");
            n = sc.nextInt();
            arreglo = new int[n];

            System.out.println("Menu de opciones:");
            System.out.println("1. Ingresar los números por teclado");
            System.out.println("2. Generar números aleatorios");
            System.out.println("3. Salir");
            System.out.println("Ingrese su opción: ");
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
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, ingrese una opción del 1 al 3.");
            }

            
            
        }while(opcionMenuUno != 3);



        sc.close();

    }

    
    
}

