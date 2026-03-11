package Guia3.PreguntasOrientadoras;

import java.util.Scanner;

public class ArregloNombres {
 public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] nombres = new String[10]; // arreglo de tamaño 10

        for (int i = 0; i < nombres.length; i++) {

            System.out.print("Ingrese el nombre " + (i + 1) + ": ");
            nombres[i] = sc.nextLine(); // se guarda el dato en el arreglo

        }

        System.out.println("\nNombres almacenados:");

     for (String nombre : nombres) {
         System.out.println(nombre);
     }
    }
}
