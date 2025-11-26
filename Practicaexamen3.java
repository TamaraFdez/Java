import java.util.Arrays;
public class Practicaexamen3 {
    public static void main(String[] args) {
        int[][] original = {
            {1, 2, 3, 9},
            {4, 5, 6, 3},
        };
        int[][] transpuesta = transpaso(original);
        printMatrix(transpuesta);
        printMatrix(tablaMultiplicacion(9));
        System.out.println(localizarMatricula("5555-LLL", new String[]{"1112-AAA","4444-LLL","5555-LLL","9999-ZZZ"}));
        System.out.println(Arrays.toString(resumenAlquileres(new int[]{0, 120, 0, 90},new String[]{"1111-AAA","2222-BBB","3333-CCC","4444-DDD"})));
    }

    public static int[][] tablaMultiplicacion(int n){
        int[][] result = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j <n ; j++){
                result[i][j]= (i+1)*(j+1);
            }
        }
        return result;
    }
    public static int [][] transpaso(int[][] matrix){
        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] result = new int[cols][rows];

        for(int i = 0 ; i < rows ; i++){
            for(int j = 0 ; j < cols ; j++){
                result[j][i] = matrix[i][j];
            }
        }
        return result;
    }
     
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }  
    public static int localizarMatricula( String s, String[] arr){
     if (s == null || arr == null || s.length() != 8) {
        return -1;
    }
    for (int i = 0; i < arr.length; i++) {
        if (s.equals(arr[i])) {
            return i;
        }
    }
    return -1;
    }
    public static String[] resumenAlquileres(int[] money, String[] matriculas){
        int l = 0;
        for(int val : money){
            if(val > 0){
                l++;
            }
        }
        String[] result = new String[l];
        for(int i = 0, j = 0; i < money.length; i++){
            if(money[i] > 0){
            result[j] = matriculas[i] + ":" + money[i];
            j++;}
        }
        return result;
    }
    public static int[] sumarIngreso (int[] recaudacion, String[] matriculas, String m, int n){
        for(int i = 0; i < matriculas.length; i++){
            if(matriculas[i].equals(m)){
                recaudacion[i] += n;
            }
        }
        return recaudacion;
    }
    public static int[] ordenarDescIngresos (int[]n){
        int l = 0;
        for(int num : n){
            if(num > 0){
                l++;
            }
        }
        int[] result = new int[l];
        Arrays.sort(n);
        for(int i = n.length-1, x=0; i >= 0; i--){
            if(n[i] > 0){
                result[x]= n[i];
                x++;
            }
        }
        return result;
    }
    public static int[][] transpuesta(int[][] matrix){
          int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] result = new int[cols][rows];

        for(int i = 0 ; i < rows ; i++){
            for(int j = 0 ; j < cols ; j++){
                result[j][i] = matrix[i][j];
            }
        }
        return result;
    }
    public static int[][] multiplicarEscalar(int[][] n, int m){
        int[][] result = new int[n.length][n[0].length];
        for(int i = 0; i < n.length;i++){
            for(int j = 0; j < n[0].length; j++){
                result[i][j] = n[i][j]*m;
            }
        }
        return result;
    }
    public static int filaMasGrande (int[][] n){
        int count = 0;
        int indice = -1;
        for(int i = 0; i < n.length; i++){
            int x = 0;
            for(int j = 0; j < n[0].length;j++){
                x += n[i][j];
            }
            if(count < x){
                count = x;
                indice = i;
            }
        }
        return indice;
    }
    public static int[][] multiplicarMatrices(int[][] A, int[][]B){
        int filaA= A.length;
        int colsA = A[0].length;
        int filasB = B.length;
        int colsB = B[0].length;

        if(colsA != filasB){
            return null;
        }

        int[][] result = new int[filaA][colsB];
        for(int i = 0; i < filaA; i++){
            for(int j = 0; j < colsB; j++){
                int suma= 0;
                for(int k = 0; k < colsA; k++){
                    suma += A[i][k] * B[k][j];
                }
                result[i][j]= suma;
            }
        }
        return result;
    }
}
