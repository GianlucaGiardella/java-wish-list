package org.lessons.java.bonus;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Inserire una stringa: ");

        String word = scanner.nextLine();

        String[] wordList = word.split("");

        Map<String, Integer> wordMap = new HashMap<>();

        for (String letter : wordList) {
            wordMap.put(letter, 1 + (wordMap.get(letter) != null ? wordMap.get(letter) : 0));
        }

        System.out.println("La parola " + word + " è composta da: ");

        wordMap.forEach((k, v) -> System.out.println(k + ":" + v));

        scanner.close();
    }
}
