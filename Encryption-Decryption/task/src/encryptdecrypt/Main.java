package encryptdecrypt;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String direction = scanner.nextLine();
        String inputStr = scanner.nextLine();
        int shiftKey = scanner.nextInt();

        switch (direction) {
            case "enc":
                System.out.println(encryption(inputStr, shiftKey));
                break;
            case "dec":
                System.out.println(decryption(inputStr, shiftKey));
                break;
            default:
                System.out.println("Unknown operation!");


        }


    }

    public static char charEncryption(char iChar, int shift) {
        //return (char)((iChar + shift - 97) % 26 + 97);
        return  (char)(iChar + shift);
    }
    public static char charDecryption(char iChar, int shift) {
        return (char)(iChar - shift);
    }
    public static String encryption(String input, int key) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            result.append(charEncryption(input.charAt(i),key));
        }
        return result.toString();
    }

    public static String decryption(String input, int key) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            result.append(charDecryption(input.charAt(i),key));
        }
        return result.toString();
    }
}
