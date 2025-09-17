package LearnJava;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static Scanner in = new Scanner(System.in);
    private static ArrayList<Integer> sumNumbers = new ArrayList<>();


    public static void main(String[] args) {

        runPersonalNumberCheck();


    }
    
    // Funktion till personnummer

    private static void runPersonalNumberCheck() {
        System.out.println("Skriv ett personnummer, 10 siffror. Inget bindestreck");
        String personalNumber = in.nextLine();

        char[] splitNumbers = personalNumber.toCharArray();
        int[] mathNumbers = new int[10];
        for (int i = 0; i < personalNumber.length(); i++) { // Ändrar från teckenkod till siffra. Lång väg men den funkar
            if (splitNumbers[i] == 48) {
                mathNumbers[i] = 0;
            } else if (splitNumbers[i] == 49) {
                mathNumbers[i] = 1;
            } else if (splitNumbers[i] == 50) {
                mathNumbers[i] = 2;
            } else if (splitNumbers[i] == 51) {
                mathNumbers[i] = 3;
            } else if (splitNumbers[i] == 52) {
                mathNumbers[i] = 4;
            } else if (splitNumbers[i] == 53) {
                mathNumbers[i] = 5;
            } else if (splitNumbers[i] == 54) {
                mathNumbers[i] = 6;
            } else if (splitNumbers[i] == 55) {
                mathNumbers[i] = 7;
            } else if (splitNumbers[i] == 56) {
                mathNumbers[i] = 8;
            } else if (splitNumbers[i] == 57) {
                mathNumbers[i] = 9;
            }
        }

        for (int i = 0; i < personalNumber.length(); i += 2) {
            int even = mathNumbers[i] * 2;
            if (even > 9) {
                int num1 = even - 9;
                sumNumbers.add(num1);
            } else {
                sumNumbers.add(even);
            }
        }
        for (int j = 1; j < personalNumber.length(); j += 2) {
            int odd = mathNumbers[j];
            sumNumbers.add(odd);
        }
        int sum = 0; // Räknar ut summan av listan
        for (int num : sumNumbers) {
            sum += num; // varje siffra för sig i listan + varandra
        }
        if (sum % 10 == 0) {
            System.out.println("Det är ett äkta personnummer");
        } else {
            System.out.println("Det är INTE ett äkta personnummer");
        }
    }
}