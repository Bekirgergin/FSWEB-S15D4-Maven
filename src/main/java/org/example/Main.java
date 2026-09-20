package org.example;

import java.util.Locale;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        // Palindrom Testleri
        System.out.println("--- Palindrom Testleri ---");
        System.out.println(checkForPalindrome("I did, did I?")); // true
        System.out.println(checkForPalindrome("Racecar")); // true
        System.out.println(checkForPalindrome("hello")); // false
        System.out.println(checkForPalindrome("Was it a car or a cat I saw ?")); // true
        System.out.println(checkForPalindrome("1001")); // true

        // Decimal -> Binary Testleri
        System.out.println("\n--- Binary Dönüştürme Testleri ---");
        System.out.println(convertDecimalToBinary(5));  // 101
        System.out.println(convertDecimalToBinary(6));  // 110
        System.out.println(convertDecimalToBinary(13)); // 1101
        System.out.println(convertDecimalToBinary(0));  // 0
    }

    /**
     * Verilen metnin palindrom olup olmadığını kontrol eder.
     * Sadece harfleri ve sayıları dikkate alır; noktalama, sembol ve boşlukları temizler.
     * Türkçe karakter sorunlarını önlemek için Locale.ENGLISH kullanır.
     */
    public static boolean checkForPalindrome(String text) {
        if (text == null) {
            return false;
        }

        // Sadece harf ve rakamları tut, noktalama ve boşlukları sil
        String cleaned = text.replaceAll("[^a-zA-Z0-9]", "").toLowerCase(Locale.ENGLISH);

        if (cleaned.isEmpty()) {
            return true;
        }

        Stack<Character> stack = new Stack<>();

        // Karakterleri Stack yapısına ekle (LIFO)
        for (char c : cleaned.toCharArray()) {
            stack.push(c);
        }

        // Stack'ten tersten çıkararak kıyasla
        for (char c : cleaned.toCharArray()) {
            if (c != stack.pop()) {
                return false;
            }
        }

        return true;
    }

    /**
     * 10'luk tabandaki (Decimal) tam sayıyı 2'lik tabana (Binary) dönüştürür.
     * Kalanları Stack (LIFO) veri yapısına push ederek ters sırada birleştirir.
     */
    public static String convertDecimalToBinary(int number) {
        if (number == 0) {
            return "0";
        }

        Stack<Integer> remainderStack = new Stack<>();
        int num = Math.abs(number);

        while (num > 0) {
            int remainder = num % 2;
            remainderStack.push(remainder);
            num = num / 2;
        }

        StringBuilder binaryBuilder = new StringBuilder();
        while (!remainderStack.isEmpty()) {
            binaryBuilder.append(remainderStack.pop());
        }

        return binaryBuilder.toString();
    }
}