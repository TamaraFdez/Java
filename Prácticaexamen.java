import java.util.Arrays;

public class Prácticaexamen {
    public static void main(String[] args) {
        char[] arr = { '9', '4', '5', '3', '4', '2', '3', '4', '5' };
        System.out.println(tieneFormatoTelefono(arr));
        System.out.println(Arrays.toString(sumaVecinos(new int[] { 3, 4, 5, 6, 7, 1 })));
        System.out.println(esColeccionAlternate(new int[] { 3, 4, 5, 6, 7, 8 }));
        System.out.println(Arrays.toString(invertirMitades(new int[] { 4, 5, 6, 7, 1 })));
        System.out.println(esPalindromo(new int[] { 1, 2, 3, 1 }));
        System.out.println(convertirEnCadena(new int[]{1,2,3,4}));
        System.out.println(esTriangular(new int[]{0,1,0}));
        System.out.println(Arrays.toString(insertarEnMedio(new int[]{1,2,3,5}, 5)));
    }

    // helpers
    static boolean isNum(char c) {
        return '0' <= c && c <= '9';
    }

    // ejercicio uno funcion tiene formato telefono
    public static boolean tieneFormatoTelefono(char[] telefono) {
        if (telefono == null || telefono.length != 9)
            return false;
        for (int i = 0; i < telefono.length; i++) {
            if (!isNum(telefono[i]))
                return false;
        }
        if (telefono[0] == '6' || telefono[0] == '9' || telefono[0] == '7')
            return true;
        return false;
    }

    // ejercicio suma vecinos
    public static int[] sumaVecinos(int[] n) {
        if (n == null || n.length < 1) {
            throw new IllegalArgumentException("Array no valido");
        }
        int[] suma = new int[n.length];

        for (int i = 0; i < n.length; i++) {
            if (i == 0) {
                suma[i] = n[0] + n[1];
            } else if (i == n.length - 1) {
                suma[i] = n[i] + n[i - 1];
            } else {
                suma[i] = n[i - 1] + n[i] + n[i + 1];
            }

        }
        return suma;
    }

    public static boolean esColeccionAlternate(int[] numeros) {
        if (numeros == null || numeros.length < 1) {
            throw new IllegalArgumentException("Array no valido");
        }
        if (numeros.length == 1) {
            return true;
        }
        for (int i = 0; i < numeros.length - 1; i += 2) {
            if (numeros[i] % 2 == 0 && numeros[i + 1] % 2 == 0 || numeros[i] % 2 != 0 && numeros[i + 1] % 2 != 0)
                return false;
        }
        return true;
    }

    public static int[] invertirMitades(int[] num) {
        if (num == null || num.length == 0) {
            throw new IllegalArgumentException("Array no válido");
        }

        int[] newArray = new int[num.length];
        int mitad = num.length / 2; // división entera: sirve para ambos casos

        if (num.length % 2 == 0) {
            // Caso par: simplemente intercambio las mitades
            for (int i = 0; i < mitad; i++) {
                newArray[i] = num[i + mitad];
                newArray[i + mitad] = num[i];
            }
        } else {
            // Caso impar: dejo el del medio en su lugar
            int medio = mitad; // índice del elemento central

            // Segunda mitad -> al principio
            for (int i = medio + 1, j = 0; i < num.length; i++, j++) {
                newArray[j] = num[i];
            }

            // Elemento del medio se queda igual
            newArray[medio] = num[medio];

            // Primera mitad -> al final
            for (int i = 0; i < medio; i++) {
                newArray[i + medio + 1] = num[i];
            }
        }

        return newArray;
    }

    public static boolean contieneSecuencia(int[] array, int[] secuencia) {
        if (array == null || secuencia == null || secuencia.length == 0 || secuencia.length > array.length) {
            return false;
        }

        // Recorremos cada posición posible del array
        for (int i = 0; i <= array.length - secuencia.length; i++) {
            boolean coincide = true;

            // Verificamos si desde esta posición empieza la secuencia
            for (int j = 0; j < secuencia.length; j++) {
                if (array[i + j] != secuencia[j]) {
                    coincide = false;
                    break;
                }
            }

            // Si todos los elementos coinciden, la encontramos
            if (coincide) {
                return true;
            }
        }

        // Si no encontramos coincidencia, devolvemos false
        return false;
    }

    public static boolean esPalindromo(int[] n) {
        if (n == null || n.length < 2) {
            throw new IllegalArgumentException("Array no válido");
        }
        int media = n.length / 2;
        for (int i = 0, j = n.length - 1; i < media; i++, j--) {
            if (n[i] != n[j]) {
                return false;
            }
        }
        return true;
    }
    public static String convertirEnCadena (int[] n){
        if(n == null || n.length == 0){
            throw new IllegalArgumentException("Array no válido");
        }
        String result = "";
        for(int i = 0;i< n.length; i++){
            if(i == n.length-1){
                result += n[i];
            }else if(i == 0){
                result = result + n[i] + "-";
            }else{
            result =result +n[i]+ "-" ;}
        }
        return result;
    }
     public static boolean esTriangular(int [] n){
        if(n == null || n.length < 3 || n.length%2 == 0){
            throw new IllegalArgumentException("Array inválido");
        }
        for(int i = 1; i <= n.length/2; i++){
            if(n[i-1] >= n[i])return false;
        }

        for(int i = n.length/2+1; i < n.length;i++){
            if(n[i-1] <= n[i])return false;
        }
        return true;
     }
     public static int[] insertarEnMedio(int[] num, int valor){
        int[] newNum = new int[num.length+1];
        int mitad = num.length/2;
        for(int i = 0, j= 0; i < newNum.length;i++){
            if(num.length%2 == 0){
                if (i < mitad || i > mitad) {  
                    newNum[i] = num[j];
                    j++;   
                }else {
                    newNum[i] = valor;
                }
            }else{
                if(i == mitad){
                    newNum[i] = valor;
                }else{
                  newNum[i] = num[j];
                    j++;  
                }

            }
        }
        return newNum;

     }

}
