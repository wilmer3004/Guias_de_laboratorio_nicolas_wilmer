package principiante_basico;

class DataTypes {

    // Tipos de datos primitivos
    public static void main(String[] args) {
        
        int myInt = 18;
        System.out.println(myInt);
        
        double myDouble = 1.70;
        System.out.println(myDouble);

        char myChar = 'f';
        System.out.println(myChar);

        boolean myBoolean = true;
        myBoolean = false;
        System.out.println(myBoolean);
        
        String myString = "Hola, java";
        System.out.println(myString);

        // Tipo de dato en tiempo de compilación 

        System.out.println(myString.getClass().getSimpleName());

        


    }
}