
package principiante_basico;
public class Strings{
    public static void main(String[] args) {
       
        // Cadenas de texto
        String name = "Wilmer";
        var surname = new String("Capera");
        // Operaciones básicas 
        // Concatenación
        System.out.println(name + " " +surname); 
       
        // Length
        System.out.println(name.length());

        // CharAt
        System.out.println(name.charAt(name.length()-1));

        //Subcadena 
        System.out.println(name.substring(2,4));

        // toUpperCasse and toLowerCase
        System.out.println(name.toUpperCase());
        System.out.println(name.toLowerCase());


    }     
}