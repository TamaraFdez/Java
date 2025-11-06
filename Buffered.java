import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Buffered {
    public static void main(String[] args) {
        //Creando archivo y escribiendo
        // try{
        //     FileWriter fw = new FileWriter("Archivo.txt");

        //     fw.write("Hola, este archivo fue creado con FileWriter");
        //     fw.write("Cada wriite escribe");

        //     fw.close();
        //     System.out.println("Archivo creado");
        // } catch (IOException e){
        //     System.out.println("Error al escribir " + e.getMessage());
        // }


        // Escribiendo en el archivo
        // try{
        //     FileWriter fw = new FileWriter("Archivo.txt", true);
        //     fw.write("\n se añadió al final");
        //     fw.write("testeando, necesitas la \n para saltar de carro");
        //     System.out.println("texto añadido correctamente!");
        //     fw.close();
        // }catch(IOException e){
        //     System.err.println("error "+ e.getMessage());
        // }

        //Probando bufferedWrite
        // try{
        //     BufferedWriter bw = new BufferedWriter(new FileWriter("archivo2.txt", true));

        //     bw.write("Linea 1 con buffered");
        //     bw.newLine();//salto de linea
        //     bw.write("Linea 2 con bufferes");
        //     bw.newLine();
        //     bw.close();

        //     System.out.println("Archivo creado correctamente");
        // }catch(IOException e){
        //     System.err.println("Error: "+ e.getMessage());
        // }

        //Combinando las 3
        try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("Archivo.txt", true)))){
            out.println("Esto fue escrito con PrintWriter.");
            out.println("Se puede usar println(), print(), y printf() como en system out");
            out.print("Print");
            out.printf("Numero ejemplo %d%n", 42);

            System.out.println("Archivo creado correctamente");

        }catch(IOException e){
            System.err.println("Error: "+ e.getMessage());
         }
    }
    
}
