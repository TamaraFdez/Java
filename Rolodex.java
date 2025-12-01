import java.io.*;
import java.util.*;

public class Rolodex {

    private static final String DIRECTORY = "writable";
    private static final String FILE_PATH = DIRECTORY + "/contacts.csv";

    public static void main(String[] args) {
        initializeCsvFile();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bienvenido al Rolodex CSV mejorado!");
        
        while (true) {
            System.out.println("\n===== MENÚ PRINCIPAL =====");
            System.out.println("1. Añadir contacto");
            System.out.println("2. Mostrar contactos");
            System.out.println("3. Editar contacto");
            System.out.println("4. Borrar contacto");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");

            String option = scanner.nextLine();

            switch (option) {
                case "1":
                    addContact(scanner);
                    break;
                case "2":
                    showContacts();
                    break;
                case "3":
                    editContact(scanner);
                    break;
                case "4":
                    deleteContact(scanner);
                    break;
                case "5":
                    System.out.println("👋 Saliendo... ¡Hasta pronto!");
                    return;

                default:
                    System.out.println("Opción inválida.");
            }
        }
    }

    // ------------------ OPCIÓN 1: AÑADIR CONTACTO ------------------
    private static void addContact(Scanner scanner) {
        System.out.print("Nombre completo: ");
        String name = scanner.nextLine().trim();

        System.out.print("Teléfono: ");
        String phone = scanner.nextLine().trim();

        System.out.print("Email: ");
        String email = scanner.nextLine().trim();

        if (!validateEmail(email)) {
            System.out.println("❌ Email inválido.");
            return;
        }

        appendToCSV(name, phone, email);
        System.out.println("✅ Contacto añadido.");
    }

    // ------------------ OPCIÓN 2: MOSTRAR CONTACTOS ------------------
    private static void showContacts() {
        System.out.println("\n===== LISTA DE CONTACTOS =====");

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            br.readLine(); // Saltar encabezado

            boolean empty = true;
            while ((line = br.readLine()) != null) {
                String[] data = parseCsvLine(line);
                System.out.println("Nombre: " + data[0]);
                System.out.println("Teléfono: " + data[1]);
                System.out.println("Email: " + data[2]);
                System.out.println("-------------------------");
                empty = false;
            }

            if (empty) System.out.println("No hay contactos guardados.");

        } catch (IOException e) {
            System.out.println("❌ Error al leer el archivo.");
        }
    }

    // ------------------ OPCIÓN 3: EDITAR CONTACTO ------------------
    private static void editContact(Scanner scanner) {
        List<String[]> contacts = loadContacts();
        if (contacts.isEmpty()) {
            System.out.println("No hay contactos para editar.");
            return;
        }

        System.out.print("Nombre del contacto a editar: ");
        String name = scanner.nextLine().trim();

        boolean found = false;

        for (String[] c : contacts) {
            if (c[0].equalsIgnoreCase(name)) {
                found = true;

                System.out.println("Editando contacto (deja en blanco para no cambiar):");

                System.out.print("Nuevo nombre (" + c[0] + "): ");
                String newName = scanner.nextLine().trim();
                if (!newName.isEmpty()) c[0] = newName;

                System.out.print("Nuevo teléfono (" + c[1] + "): ");
                String newPhone = scanner.nextLine().trim();
                if (!newPhone.isEmpty()) c[1] = newPhone;

                System.out.print("Nuevo email (" + c[2] + "): ");
                String newEmail = scanner.nextLine().trim();
                if (!newEmail.isEmpty()) {
                    if (validateEmail(newEmail)) {
                        c[2] = newEmail;
                    } else {
                        System.out.println("❌ Email inválido, no se cambió.");
                    }
                }

                break;
            }
        }

        if (!found) {
            System.out.println("❌ No se encontró ese nombre.");
            return;
        }

        saveContacts(contacts);
        System.out.println("✅ Contacto editado correctamente.");
    }

    // ------------------ OPCIÓN 4: BORRAR CONTACTO ------------------
    private static void deleteContact(Scanner scanner) {
        List<String[]> contacts = loadContacts();

        System.out.print("Nombre del contacto a borrar: ");
        String name = scanner.nextLine().trim();

        boolean removed = contacts.removeIf(c -> c[0].equalsIgnoreCase(name));

        if (!removed) {
            System.out.println("❌ Contacto no encontrado.");
            return;
        }

        saveContacts(contacts);
        System.out.println("🗑️ Contacto eliminado.");
    }

    // ------------------ UTILIDADES ------------------

    private static List<String[]> loadContacts() {
        List<String[]> list = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            br.readLine(); // saltar encabezado

            while ((line = br.readLine()) != null) {
                list.add(parseCsvLine(line));
            }

        } catch (IOException e) {
            System.out.println("❌ Error al cargar contactos.");
        }

        return list;
    }

    private static void saveContacts(List<String[]> contacts) {
        try (PrintWriter out = new PrintWriter(new FileWriter(FILE_PATH))) {
            out.println("Nombre,Telefono,Email"); // encabezado

            for (String[] c : contacts) {
                out.println(
                    escapeCsvField(c[0]) + "," +
                    escapeCsvField(c[1]) + "," +
                    escapeCsvField(c[2])
                );
            }

        } catch (IOException e) {
            System.out.println("❌ Error al guardar contactos.");
        }
    }

    private static String[] parseCsvLine(String line) {
        return line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
    }

    private static void initializeCsvFile() {
        try {
            File dir = new File(DIRECTORY);
            if (!dir.exists()) dir.mkdirs();

            File file = new File(FILE_PATH);
            if (!file.exists()) {
                PrintWriter out = new PrintWriter(new FileWriter(file));
                out.println("Nombre,Telefono,Email");
                out.close();
            }

        } catch (IOException e) {
            System.out.println("❌ Error al inicializar archivo CSV.");
        }
    }

    private static void appendToCSV(String name, String phone, String email) {
        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(FILE_PATH, true)))) {
            out.println(
                escapeCsvField(name) + "," +
                escapeCsvField(phone) + "," +
                escapeCsvField(email)
            );

        } catch (IOException e) {
            System.out.println("❌ Error al guardar contacto.");
        }
    }

    private static String escapeCsvField(String field) {
        if (field.contains(",") || field.contains("\"") || field.contains("\n")) {
            field = field.replace("\"", "\"\"");
            return "\"" + field + "\"";
        }
        return field;
    }

    private static boolean validateEmail(String email) {
        return email.contains("@") && email.contains(".") && !email.contains(" ");
    }
}
