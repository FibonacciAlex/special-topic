/**
 * Testing Java input and Output
 */

import java.io.*;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //testByteStream();
        //testCharacterStream();
        //copyLine();

        //testScannerReadString();
        //testScannerReadNumber();
        //testScannerReadNLine();
    	//testScannerReadItem();

        writeSerialize();
        readSerialize();
    }

    public static void testByteStream() {

        try {
            FileInputStream  inputStream = new FileInputStream("simple.txt");
            FileOutputStream  outputStream = new FileOutputStream("stream_out.txt");

            try {
                int byteNumber = 0;
                int c;
                while ((c = inputStream.read()) != -1) {
                    outputStream.write(c);

                    char charValue = (char) c;
                    System.out.println("integer: " + c + "; Character: " + charValue);
                    byteNumber++;
                }

                System.out.println("Byte number: " + byteNumber + "\n\n");
            } finally {
                inputStream.close();
                outputStream.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void testCharacterStream() {

        try {
            FileReader inputStream = new FileReader("simple.txt");
            FileWriter outputStream = new FileWriter("character_out.txt");

            try {
                int characterNumber = 0;
                int c;
                while ((c = inputStream.read()) != -1) {
                    outputStream.write(c);

                    char charValue = (char) c;
                    System.out.println("integer: " + c + "; Character: " + charValue);
                    characterNumber++;
                }

                System.out.println("Character number: " + characterNumber + "\n\n");
            } finally {
                inputStream.close();
                outputStream.close();
            }
        }  catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void copyLine() {

        try {
            BufferedReader inputStream = new BufferedReader(new FileReader("simple.txt"));
            PrintWriter outputStream = new PrintWriter(new FileWriter("line_out.txt"));

            try{
                String line;
                while ((line = inputStream.readLine()) != null) {
                    outputStream.println(line);
                    System.out.println(line);
                }
            } finally {
                inputStream.close();
                outputStream.close();
            }
        }  catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void testScannerReadString() {

        Scanner scanner = null;
        try {
            scanner = new Scanner(new BufferedReader(new FileReader("simple.txt")));
            String item;
            try {

                while (scanner.hasNext()) {
                    item = scanner.next();
                    System.out.println(item);

                }
            } finally {
                if (scanner != null) {
                    scanner.close();
                }
            }
        }  catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void testScannerReadNumber() {

        Scanner scanner = null;
        try {
            scanner = new Scanner(new BufferedReader(new FileReader("usnumbers.txt")));
            scanner.useLocale(Locale.US);

            try {
                while (scanner.hasNext()) {
                    if (scanner.hasNextDouble()) {
                        double d = scanner.nextDouble();
                        System.out.println(d);
                    } else {
                        scanner.next();
                    }
                }
            } finally {
                if (scanner != null) {
                    scanner.close();
                }
            }
        }  catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void testScannerReadNLine() {

        Scanner scanner = null;
        try {
            scanner = new Scanner(System.in);

            String line;
            System.out.println("Enter a new line: ");
            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                if (line.startsWith("n")) {
                    break;
                }
                System.out.println(line);
                System.out.println("Enter a new line: ");
            }
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }

    public static void testScannerReadItem() {

        Scanner scanner = null;

        try {
            scanner = new Scanner(System.in);
            String item;
            System.out.println("Enter: ");
            while (scanner.hasNext()) {
                item = scanner.next();
                if (item.startsWith("n")) {
                    break;
                }
                System.out.println(item);
            }
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }

    public static void writeSerialize() {
        Example example = new Example(1, 55.23f);
        try {
            FileOutputStream output = new FileOutputStream("object.ser");
            ObjectOutputStream objectOutput = new ObjectOutputStream(output);

            objectOutput.writeObject(example);
            objectOutput.close();
            output.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public static void readSerialize() {
        Example example = new Example(1, 55.23f);
        try {
            FileInputStream input = new FileInputStream("object.ser");
            ObjectInputStream objectInput = new ObjectInputStream(input);

            example = (Example)objectInput.readObject();
            objectInput.close();
            input.close();

            System.out.print(example);
        } catch(IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
