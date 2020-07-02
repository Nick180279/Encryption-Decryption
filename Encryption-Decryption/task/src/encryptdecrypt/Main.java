package encryptdecrypt;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String direction = "enc";
        int key = 0;
        String data = "";
        String inputSourceFile = "";
        String outputSourceFile = "";
        boolean dir;
        if (args.length > 0) {
            for (int i = 0; i < args.length; i+=2) {
                switch (args[i]) {
                    case "-key":
                        key = Integer.parseInt(args[i+1]);
                        break;
                    case "-data":
                        data = args[i+1];
                        break;
                    case "-mode":
                        direction = args[i+1];
                        break;
                    case "-in":
                        inputSourceFile = args[i+1];
                        break;
                    case "-out":
                        outputSourceFile = args[i+1];
                        break;
                }
            }
        }

        File inputFile = new File(inputSourceFile);
        File outputFile = new File(outputSourceFile);
        dir = "enc".equals(direction);
        System.out.println(deEncryption(data, key, dir));
        if (!"".equals(inputSourceFile) && "".equals(data)) {
            if ("".equals(outputSourceFile)) {
                try (Scanner scanner = new Scanner(inputFile)) {
                    while (scanner.hasNext()) {
                        System.out.println(deEncryption(scanner.nextLine(), key, dir));
                    }
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
            } else {
                try (Scanner scanner = new Scanner(inputFile);
                PrintWriter printWriter = new PrintWriter(outputFile)) {
                    while (scanner.hasNext()) {
                        printWriter.println(deEncryption(scanner.nextLine(), key, dir));
                    }
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }

            }
        } else {
            if ("".equals(outputSourceFile)) {
                System.out.println(deEncryption(data, key, dir));
            } else {
                try (PrintWriter printWriter = new PrintWriter(outputFile)) {
                    printWriter.println(deEncryption(data, key, dir));
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }


    }




    public static char charEncryption(char iChar, int shift) {
          return  (char)(iChar + shift);
    }
    public static char charDecryption(char iChar, int shift) {
        return (char)(iChar - shift);
    }

    public static String deEncryption(String input, int key, boolean direction) {
        key = direction ? key : -key;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            result.append(charEncryption(input.charAt(i),key));
        }
        return result.toString();
    }


}
