public class PracticaPreExamen {
    public static void main(String[] args) {

    }

    public static int buscar(String[] arr, String m) {
        if (arr == null || m == null || arr.length < 1 || m.length() < 1) {
            return -1;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(m))
                return i;
        }
        return -1;
    }

    public static String[] losAlquilados(int[] r, String[] m) {
        String[] result = new String[m.length];
        for (int i = 0; i < m.length; i++) {
            result[i] = m[i] + " : " + r[i];
        }
        return result;
    }

    public static int[] actualizar(int[] r, String[] m, String matricula, int v) {
        if (buscar(m, matricula) == -1) {
            return r;
        }else {
            r[buscar(m, matricula)] += v;
        }

        return r;
    }
   public static String[] losAlquiladosOrden(String[] m, int[] r) {
    for (int i = 0; i < m.length; i++) {
        for (int j = 0; j < m.length - i - 1; j++) {
            if (r[j] < r[j + 1]) {

                int tempR = r[j];
                r[j] = r[j + 1];
                r[j + 1] = tempR;

                String tempM = m[j];
                m[j] = m[j + 1];
                m[j + 1] = tempM;
            }
        }
    }

    return losAlquilados(r, m); 
}

    
}
