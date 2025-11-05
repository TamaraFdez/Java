import java.io.*;
import java.util.Scanner;

public class Rolodex {

    private static final String CSV_PATH = "writable/contacts.csv";
    private static final String CSV_HEADER = "Nombre,Telefono,Email";

    public static void main(String[] args) {
        ensureCSVExists();

        Scanner scanner = new Scanner(System.in);
        String continuar;

        do {
            System.out.println("Introduce el nombre completo:");
            String nombre = scanner.nextLine();

            System.out.println("Introduce el número de teléfono:");
            String telefono = scanner.nextLine();

            System.out.println("Introduce la dirección de email:");
            String email = scanner.nextLine();

            if (validateEmail(email)) {
                writeContact(nombre, telefono, email);
                System.out.println("Contacto agregado correctamente.");
            } else {
                System.out.println("Email inválido. No se guardó el contacto.");
            }

            System.out.println("¿Deseas agregar otro contacto? (s/n)");
            continuar = scanner.nextLine().trim().toLowerCase();
        } while (continuar.equals("s"));
        scanner.close();

        System.out.println("Sesión finalizada. Todos los contactos guardados en " + CSV_PATH);
    }

    // Asegura que el archivo CSV exista y tenga encabezado correcto
    private static void ensureCSVExists() {
        File csvFile = new File(CSV_PATH);
        File writableDir = new File("writable");

        if (!writableDir.exists()) {
            writableDir.mkdir();
        }

        try {
            if (!csvFile.exists()) {
                FileWriter fw = new FileWriter(csvFile, true);
                fw.append(CSV_HEADER).append("\n");
                fw.close();
            } else {
                // Verificar encabezado
                BufferedReader br = new BufferedReader(new FileReader(csvFile));
                String firstLine = br.readLine();
                br.close();
                if (firstLine == null || !firstLine.equals(CSV_HEADER)) {
                    prependHeader(csvFile);
                }
            }
        } catch (IOException e) {
            System.err.println("Error al inicializar el CSV: " + e.getMessage());
            System.exit(1);
        }
    }

    private static void prependHeader(File csvFile) throws IOException {
        File tempFile = new File("writable/temp.csv");
        BufferedWriter bw = new BufferedWriter(new FileWriter(tempFile));
        bw.write(CSV_HEADER);
        bw.newLine();

        BufferedReader br = new BufferedReader(new FileReader(csvFile));
        String line;
        while ((line = br.readLine()) != null) {
            bw.write(line);
            bw.newLine();
        }
        br.close();
        bw.close();

        csvFile.delete();
        tempFile.renameTo(csvFile);
    }

    private static void writeContact(String nombre, String telefono, String email) {
        try (FileWriter fw = new FileWriter(CSV_PATH, true);
             BufferedWriter bw = new BufferedWriter(fw)) {

            bw.write(escapeCSV(nombre) + "," + escapeCSV(telefono) + "," + escapeCSV(email));
            bw.newLine();
        } catch (IOException e) {
            System.err.println("Error al escribir en CSV: " + e.getMessage());
        }
    }

    // Escapa comas y comillas en los campos CSV
    private static String escapeCSV(String field) {
        if (field.contains(",") || field.contains("\"")) {
            field = field.replace("\"", "\"\"");
            field = "\"" + field + "\"";
        }
        return field;
    }

    // Validación simple de email
    private static boolean validateEmail(String email) {
        return email.contains("@") && email.contains(".") && !email.contains(" ");
    }
}

