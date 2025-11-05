import java.util.Arrays;
public class arrays {
    public static void main(String[] args){
        //Declarar un array
        String[] cars = {"Volvo","BMW", "Ford", "Mazda"};
        String[] cars2 = {"Volvo","BMW", "Ford", "Mercedes"};
        System.out.println(cars[0]);

        //For-each
        for(String car : cars){
        System.out.println(car);
        }

        int ages[] = {20, 40,50,23,14};
        float avg, sum = 0;
        int length = ages.length;
        
        for (int age : ages){
            sum+= age;
        }
        avg = sum / length;

        System.out.println("La media de años es: " + avg);
        //static significa que el metodo pertenece a la clase principal y no un objeto de la clase principal

        //Array methods
        // Método comparar
        System.out.println(Arrays.compare(cars, cars2)); // -4
        //Método equals
        System.out.println(Arrays.equals(cars, cars2)); // false
        //Método ordenar
        Arrays.sort(ages);
        for(int age : ages){
        System.out.println(age); 
        } 
        //Método llenar
        Arrays.fill(cars2, 3,4, "VVolvo");
        for(String car : cars2){
        System.out.println(car);
        }

        

    }
    
}
