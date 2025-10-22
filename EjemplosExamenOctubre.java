

public class EjemplosExamenOctubre {
    public static void main( String[] args){
        System.out.println(potencia(4));
        System.out.println(clasificarNumero(-1));
        System.out.println(contarVocales("hola como estamos"));
        System.out.println("Dando la vuelta al numero 3456 es = " + invetirNumero(3456) );
        System.out.println("MCD de 99 y 33 = " + mcd(99, 33));
        System.out.println("Precio sesiones = " + calcularPrecio(1,5 ));
        System.out.println("Nota = " + calificacion(10 ));
        System.out.println("El total a pagar es "+  calcularInteres(75892, 30, 3.5));
        System.out.println("Es palindromo" + esPalindromo("Anita lava la tina"));
        System.out.println("Mike paga = "+ pagarPizza(29.95));
        System.out.println("Numero cuya raiz es más cercana" + raizCuadrada(111));
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
    public static int calcularPrecio(int numeroSesion, int n){
        int totalSesion = n+numeroSesion;
        int precio = 0;
        for(int i = numeroSesion; i < totalSesion;i++){
            if(i < 4){
                precio+= 150;
            }else if(i > 3 && i < 7){
                precio+=120;
            }else{
                precio+=100;
            }
        }
        return precio;
    }
    public static String calificacion(int nota){
        if(nota < 0 || nota > 10){
            throw new IllegalArgumentException("Nota no valida");
        }
        switch (nota) {
            case 0:   
            case 1:
            case 2:
            case 3:
            case 4: 
                return (String)"Suspenso";
            case 5:
                return (String)"Aprobado";
            case 6:
            case 7:
                return (String)"Bien";
            case 8:
            case 9:
                return (String)"Notable";
            case 10:
            return (String)"Sobresaliente";
            default:
          
            throw new IllegalStateException("Error inesperado en la nota: " + nota);
        }
    }
    public static double calcularInteres(double c, int a, double i){
        double total = c + (c * (i/100)*a);
        return total;

    }
    public static boolean esPalindromo(String texto){
        String text = texto.replace(" ", "").toLowerCase();
        String invertText = new StringBuilder(text).reverse().toString();
        return text.equals(invertText);
         
    }

    public static double pagarPizza(double p){
        // double tercio = Math.round((p/3)*100.0)/100.0;
        // if(p < 5){
        //     return p;
        // }
        // if(tercio >= 10){
        //     return (double)p-10;
        // }else{
        //     return p-tercio;
        // }
        return Math.round((p < 5 ? p : p - Math.min(p/3, 10))*100.0)/100.0;
    }
    public static int raizCuadrada(int n){
            return (int)Math.round(Math.sqrt(n));
            
    }

}
