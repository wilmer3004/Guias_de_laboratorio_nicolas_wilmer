package Guia3.MetodosOrdenamiento;

public class ImprimirTabla {
    public ImprimirTabla(int[] arreglo) {
        imprimir(arreglo);
    }
    public ImprimirTabla() {
      
    }
    public void imprimir(int[] arreglo){

        int columnas = 10;

        System.out.println("------------------------------------------------------------");

        for(int i = 0; i < arreglo.length; i++){

            if(i % columnas == 0){
                System.out.print("| ");
            }

            System.out.printf("%5d ", arreglo[i]);

            if((i + 1) % columnas == 0){
                System.out.println("|");
            }
        }

        if(arreglo.length % columnas != 0){
            System.out.println("|");
        }

        System.out.println("------------------------------------------------------------");
    }
}
