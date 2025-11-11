public class ExamenNoviembre {
    public static void main(String[] args) {
        System.out.println(aNum(new char[]{'0', '0','0','6', '9', '3', '5', '4', 'C'}));
        System.out.println(tieneFormatoNIF(new char[]{'2', '2','?','6', '9', '3', '5', '4', 'C'}));
        System.out.println(esNIFCorrecto(new char[]{'2', '2','5','6', '9', '3', '5', '4', 'C'}));
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
}
