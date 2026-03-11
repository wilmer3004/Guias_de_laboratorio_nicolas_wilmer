package Guia3.PreguntasOrientadoras;

public class Intercambio {

    public static void main(String[] args) {

        int var1 = 2;
        int var2 = 600;

        int aux;

        aux = var1;
        var1 = var2;
        var2 = aux;

        System.out.println("var1 = " + var1);
        System.out.println("var2 = " + var2);

    }
}