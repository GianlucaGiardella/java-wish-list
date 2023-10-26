package org.lessons.java;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Gift> gifts = new ArrayList<>();

        boolean exit = false;

        try (Scanner fileReader = new Scanner(new File("./resources/gifts.txt"))) {
            System.out.println("\n- Regali aggiunti precedentemente: ");
            while (fileReader.hasNextLine()) {
                String line = fileReader.nextLine();
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("\n- File non trovato");
        }

        while (!exit) {
            if (!gifts.isEmpty()) {
                System.out.println("\n- Lunghezza lista: " + gifts.size());

                System.out.println("Vuoi continuare ad aggiungere regali?");
                exit = scan.nextLine().equals("n");
            }

            if (!exit) {
                System.out.println("\n- Nuovo reaglo");

                try {
                    System.out.println("Inserire la descrizione del regalo: ");
                    String description = scan.nextLine();

                    System.out.println("Inserire il destinatario del regalo: ");
                    String recipient = scan.nextLine();

                    gifts.add(new Gift(description, recipient));

                } catch (IllegalArgumentException e) {
                    System.out.println("- Errore: " + e.getMessage());
                }
            }
        }

        System.out.println("\n- Lista attuale dei regali: ");
        System.out.println(gifts);

        try (FileWriter fileWriter = new FileWriter("./resources/gifts.txt", true)) {
            for (Gift gift : gifts) {
                fileWriter.write(gift.toString() + "\n");
            }
            System.out.println("\n- Scrittura dei regali con successo!");
        } catch (IOException e) {
            System.out.println("\n- Impossibile scrivere nel file");
        }

        scan.close();
    }
}
