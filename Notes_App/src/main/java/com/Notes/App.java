package com.Notes;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


// Task 4: Java File I/O – Notes App

public class App {

    // Define a constant for the filename
    private static final String FILENAME = "notes.txt";

    public static void main(String[] args) {


        try (Scanner scanner = new Scanner(System.in)) {
            boolean running = true;

            while (running) {
                printMenu();
                int choice = -1;

                // Read the full line and parse it as an integer

                try {
                    choice = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a number.");
                    continue; // Skip the rest of the loop and show the menu again
                }

                switch (choice) {
                    case 1:
                        addNote(scanner);
                        break;
                    case 2:
                        viewNotes();
                        break;
                    case 3:
                        clearNotes();
                        break;
                    case 4:
                        running = false;
                        System.out.println("Exiting the application. Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid option. Please choose between 1 and 4.");
                }
            }
        }
    }


    private static void printMenu() {
        System.out.println("\n--- Java Notes Manager ---");
        System.out.println("1. Add a new note");
        System.out.println("2. View all notes");
        System.out.println("3. Clear all notes");
        System.out.println("4. Exit");
        System.out.print("Please select an option: ");
    }

    /**
     * Prompts the user for a note and appends it to the file.
     */
    private static void addNote(Scanner scanner) {
        System.out.print("Enter your note and press Enter: ");
        String note = scanner.nextLine();



        try (FileWriter writer = new FileWriter(FILENAME, true)) {
            writer.write(note + "\n"); // Add a newline for better readability
            System.out.println("Note added successfully!");
        } catch (IOException e) { // Handles IOException [cite: 15]
            System.err.println("Error: Could not write to file. " + e.getMessage());
        }
    }

    /**
     * Reads and displays all notes from the file.
     */
    private static void viewNotes() {
        System.out.println("\n--- Your Notes ---");


        try (BufferedReader reader = new BufferedReader(new FileReader(FILENAME))) {
            String line;
            boolean notesExist = false;

            // Read the file line by line
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                notesExist = true;
            }

            if (!notesExist) {
                System.out.println("(No notes found)");
            }
        } catch (FileNotFoundException e) {

            System.out.println("(No notes file found. Add a note to create one.)");
        } catch (IOException e) { // Handles other IOExceptions [cite: 15]
            System.err.println("Error: Could not read from file. " + e.getMessage());
        }
        System.out.println("------------------");
    }

    /**
     * Clears all notes by overwriting the file.
     */
    private static void clearNotes() {
        // Use try-with-resources  with FileWriter
        try (FileWriter writer = new FileWriter(FILENAME, false)) {

            System.out.println("All notes cleared successfully!");
        } catch (IOException e) { // Handles IOException [cite: 15]
            System.err.println("Error: Could not clear file. " + e.getMessage());
        }
    }
}