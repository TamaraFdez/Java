public class strings {
    public static void main(String[] args) {
        String str = "Hello, World!";
        System.out.println("Original String: " + str);

        // Convert to uppercase
        String upperStr = str.toUpperCase();
        System.out.println("Uppercase String: " + upperStr);

        // Convert to lowercase
        String lowerStr = str.toLowerCase();
        System.out.println("Lowercase String: " + lowerStr);

        // Get substring
        String subStr = str.substring(7, 12);
        System.out.println("Substring (7-12): " + subStr);

        // Replace characters
        String replacedStr = str.replace("World", "Java");
        System.out.println("Replaced String: " + replacedStr);

        // Trim whitespace
        String strWithSpaces = "   Hello, World!   ";
        String trimmedStr = strWithSpaces.trim();
        System.out.println("Trimmed String: '" + trimmedStr + "'");

        // Split string
        String[] splitStr = str.split(", ");
        System.out.println("Split String: ");
        for (String s : splitStr) {
            System.out.println(s);
        }

        // String contains
        boolean containsHello = str.contains("Hello");
        System.out.println("Contains 'Hello': " + containsHello);

        // String equals
        boolean equalsTest = str.equals("Hello, World!");
        boolean equalsTestIgnoreCase = str.equalsIgnoreCase("hello, world!");
        System.out.println("Equals 'Hello, World!': " + equalsTest);
        System.out.println("Equals Ignore Case 'hello, world!': " + equalsTestIgnoreCase);

        // string reverse
        String reversedStr = new StringBuilder(str).reverse().toString();
        System.out.println("Reversed String: " + reversedStr);

        // String replace
        String replaceStr = str.replace("o", "0");
        System.out.println("Replace 'o' with '0': " + replaceStr);
        String replacedFirstStr = str.replaceFirst("l", "x");
        System.out.println("Replace First 'l' with 'x': " + replacedFirstStr);
        String replacedAllStr = str.replaceAll("l", "x");
        System.out.println("Replace All 'l' with 'x': " + replacedAllStr);

        // String parse int
        String age = "30";
        int ageInt = Integer.parseInt(age);
        System.out.println("Parsed Integer: " + ageInt);

        // Int parse string
        int number = 100;
        String numberStr = Integer.toString(number);
        System.out.println("Parsed String: " + numberStr);

        // string trim
        String stringWithSpaces = "   Java Programming   ";
        String trimmedString = stringWithSpaces.trim();
        System.out.println("Trimmed String: '" + trimmedString + "'");

        // String ValueOf
        int val = 50;
        String valStr = String.valueOf(val);
        System.out.println("String ValueOf int 50: " + valStr);

        // String charAt
        char charAtIndex = str.charAt(1);
        System.out.println("Character at index 1: " + charAtIndex);

        // string chararray
        char[] charArray = str.toCharArray();
        System.out.println("Character Array: ");
        for (char c : charArray) {
            System.out.println(c);
        }

        //string isEmpty
        String emptyStr = "";
        boolean isEmpty = emptyStr.isEmpty();
        System.out.println("Is the string empty? " + isEmpty);

        //string isBlank
        String blankStr = "   ";
        boolean isBlank = blankStr.isBlank();
        System.out.println("Is the string blank? " + isBlank);

        //stringbuilder append
        StringBuilder sb = new StringBuilder("Hello");
        sb.append(", Java!");
        System.out.println("StringBuilder after append: " + sb.toString());

        //stringbuilder insert
        sb.insert(5, " Beautiful");
        System.out.println("StringBuilder after insert: " + sb.toString());

        //stringbuilder delete
        sb.delete(5, 15);
        System.out.println("StringBuilder after delete: " + sb.toString());

        //stringbuilder reverse
        sb.reverse();
        System.out.println("StringBuilder after reverse: " + sb.toString());

        //stringbuilder replace
        sb.replace(0, 5, "Hi");
        System.out.println("StringBuilder after replace: " + sb.toString());

        //stringbuilder toString
        String finalStr = sb.toString();
        System.out.println("Final String from StringBuilder: " + finalStr);

        //stringbuilder charAt
        char sbCharAt = sb.charAt(1);
        System.out.println("Character at index 1 in StringBuilder: " + sbCharAt);

        //stringbuilder setCharAt
        sb.setCharAt(2, 'X');
        System.out.println("StringBuilder after setCharAt at index 2: " + sb.toString()); 
    }

}
