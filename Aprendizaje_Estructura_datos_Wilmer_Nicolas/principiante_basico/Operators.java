package principiante_basico;

public class Operators {
    public static void main(String[] args) {
        
        //operadores
        
        //Aritmeticos
        float a = 5;
        var b = 4;

        System.out.println(a+b);
        System.out.println(a-b);
        System.out.println(a*b);
        System.out.println(a/b);
        System.out.println(a%b);

        //asignación 
        a = b;
        System.out.println(a);

        a = b *2;
        System.out.println(a);

        a += 1;
        a*=10;
        System.out.println(a);

    // Comparación (relacioanles)

    System.out.println(a==b);
    System.out.println(a==90);

    System.out.println(a != b);

    // logicos

    System.out.println(true && true);
    System.out.println(true && false);
    System.out.println(true && true);

    // System.out.println(3 > 2 && 5 == 2);

    System.out.println(true || true);
    System.out.println(true || false);
    System.out.println(false || true);
    System.out.println(true || true);



    }
}
