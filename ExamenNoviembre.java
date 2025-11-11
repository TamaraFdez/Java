import java.util.Arrays;

public class ExamenNoviembre {
    public static void main(String[] args) {
        System.out.println(esPseudoDomino(new int[]{2,3,3,4,4,5,5}));
        System.out.println(aNum(new char[]{'0', '0','0','6', '9', '3', '5', '4', 'C'}));
        System.out.println(tieneFormatoNIF(new char[]{'2', '2','?','6', '9', '3', '5', '4', 'C'}));
        System.out.println(esNIFCorrecto(new char[]{'2', '2','5','6', '9', '3', '5', '4', 'C'}));
        int[] espejito = imagenEspejo(new int[]{2,4,5});
        System.out.println(Arrays.toString(espejito));
    }
    static boolean esLetraMayus(char c){
        return 'A' <= c && c <= 'Z' && c != 'Ñ';
    }
    static boolean esDigit(char c ){
        return '0' <= c && c <= '9';
     }
     public static boolean tieneFormatoNIF(char[] nif){
        if(nif.length != 9)return false;
        for(int i = 0; i <8; i++){
            if(!esDigit(nif[i]))return false;
        }
        if(!esLetraMayus(nif[8]))return false;

        return true;
     }

     static int aDigito(char c){
        return c - '0';
     }
     public static int aNum(char[] nif){
        int num = 0;
        for (int i = 0;i < 8; i ++){
            num = num * 10 + aDigito(nif[i]);
        }
        return num;
     }
     public static boolean esNIFCorrecto(char[] nif){
        if(!tieneFormatoNIF(nif))return false;

         int numero = aNum(nif);

         char[] letras = {
            'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H','L', 'C','K','E'
         };
         char letraEsperada = letras[numero % 23];
         return letraEsperada == nif[8];
     }
     public static boolean esPseudoDomino(int[] numeros){
        if(numeros.length == 0 || numeros.length ==2 )return true;
        for(int i = 1; i < numeros.length-1 ; i+=2){
            if(numeros[i] != numeros[i+1])return false;
        }
        return true;
     }
    public static int[] imagenEspejo(int[] n){
    if (n == null || n.length == 0) {
        throw new IllegalArgumentException("El Array debe contener al menos un número");
    }

    int[] espejo = new int[n.length * 2];

    for (int i = 0; i < n.length; i++) {
        espejo[i] = n[i];
        espejo[n.length + i] = n[n.length - 1 - i];
    }

    return espejo;
}

}
