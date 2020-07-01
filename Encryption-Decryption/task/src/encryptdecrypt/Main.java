package encryptdecrypt;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String direction = "enc";
        int key = 0;
        String data = "";
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
                }
            }
        }

        switch (direction) {
            case "enc":
                System.out.println(encryption(data, key));
                break;
            case "dec":
                System.out.println(decryption(data, key));
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
