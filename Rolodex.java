import java.io.*;
import java.util.Scanner;
 

public class Rolodex {

    private static final String DIRECTORY = "writable";
    private static final String FILE_PATH = DIRECTORY + "/contacts.csv";

    public static void main(String[] args) {
        initializeCsvFile();

        Scanner scanner = new Scanner(System.in);
         System.out.println("░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");
        System.out.println("█▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀█");
        System.out.println("█░██░██░██░██░██░██░██░██░██░░░░░░░░░░█");
        System.out.println("█▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄█");
        System.out.println("░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");
        System.out.println("░░█░░░░█▀▀▀█░█▀▀█░█▀▀▄░▀█▀░█▄░░█░█▀▀█░░");
        System.out.println("░░█░░░░█░░░█░█▄▄█░█░░█░░█░░█░█░█░█░▄▄░░");
        System.out.println("░░█▄▄█░█▄▄▄█░█░░█░█▄▄▀░▄█▄░█░░▀█░█▄▄█░░");
        System.out.println("░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");
        System.out.println("Bienvenido al importador Rolodex a CSV");
        System.out.println("Escribe 'exit' en cualquier momento para salir.");

        while (true) {
            System.out.print("Nombre completo: ");
            String name = scanner.nextLine().trim();
            if (name.equalsIgnoreCase("exit")) break;
            if (name.isEmpty()) {
                System.out.println("El nombre no puede estar vacío.");
                continue;
            }

            System.out.print("Número de teléfono: ");
            String phone = scanner.nextLine().trim();
            if (phone.equalsIgnoreCase("exit")) break;

            System.out.print("Email: ");
            String email = scanner.nextLine().trim();
            if (email.equalsIgnoreCase("exit")) break;

             if (validateEmail(email)) {
                 appendToCSV(name, phone, email);
            System.out.println("✅ Contacto añadido correctamente.");
            } else {
                System.out.println("Email inválido. No se guardó el contacto.");
            }
        }

        System.out.println("👋 Programa finalizado. ¡Hasta pronto!");
        scanner.close();
    }

    // Método 1: Inicializa el CSV (crea si no existe y añade encabezados)
    private static void initializeCsvFile() {
        try {
            File dir = new File(DIRECTORY);
            if (!dir.exists()) dir.mkdirs();

            File file = new File(FILE_PATH);
            if (!file.exists()) {
                FileWriter writer = new FileWriter(file);
                writer.write("Nombre,Telefono,Email\n");
                writer.close();
                System.out.println("Archivo CSV creado en: " + FILE_PATH);
            }
        } catch (IOException e) {
            System.out.println("❌ Error al inicializar el archivo CSV: " + e.getMessage());
        }
    }

    // Método 2: Añade una nueva línea con los datos del contacto
    private static void appendToCSV(String name, String phone, String email) {
        try (FileWriter fw = new FileWriter(FILE_PATH, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {

            out.println(escapeCsvField(name) + "," +
                        escapeCsvField(phone) + "," +
                        escapeCsvField(email));

        } catch (IOException e) {
            System.out.println("❌ Error al escribir en el archivo: " + e.getMessage());
        }
    }

    // Método 3: Escapa campos que contengan comas o comillas
    private static String escapeCsvField(String field) {
        if (field.contains(",") || field.contains("\"") || field.contains("\n")) {
            field = field.replace("\"", "\"\""); // escapa comillas internas
            return "\"" + field + "\""; // envuelve el campo entre comillas
        }
        return field;
    }
    //Método 4: valida que el email contenta @ . y no contenta espacios
    private static boolean validateEmail(String email) {
        return email.contains("@") && email.contains(".") && !email.contains(" ");
    }
}
