

public class EjemplosExamenOctubre {
    public static void main( String[] args){
        System.out.println(potencia(4));
        System.out.println(clasificarNumero(-1));
        System.out.println(contarVocales("hola como estamos"));
        System.out.println("Dando la vuelta al numero 3456 es = " + invetirNumero(3456) );
        System.out.println("MCD de 99 y 33 = " + mcd(99, 33));
    }
    public static String potencia(int n){
        if(n < 0){
          throw new IllegalArgumentException("No se permiten valores negativos!");
        }
        String a = String.valueOf((int)Math.pow(n,2));
        String b = String.valueOf((int)Math.sqrt(n));
        return a +" "+ b ;
    }

    public static String clasificarNumero(int n){
        if(n < 0) return "negativo";
        if(n== 0) return "cero";
        if(n%2 == 0) return "Par";
        return "impar";
    }
    public static int contarVocales(String a){
        int count = 0;
        String vocales = "aeiouAEIOU";
       for(char c : a.toCharArray()){
        if(vocales.indexOf(c)!= -1){
            count++;
        }
       }
       return count;
    }
    public static int invetirNumero( int n){
        String str = String.valueOf(n);
        StringBuilder sb = new StringBuilder(str).reverse();
        int newN = Integer.parseInt(sb.toString());
        return newN;

    }
    public static int mcd(int a, int b){
     int temporal;
     while(b!= 0){
        temporal = b;
        b= a%b;
        a = temporal;
     } 
        return a;
    }

}
