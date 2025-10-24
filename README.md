# 📝 Task 4: Java File I/O – Notes App

This repository contains the solution for the **Java Developer Internship** task from Elevate Labs.

## 🎯 Task Objective

The objective of this task was to create a text-based notes manager using Java. The application needed to support writing new notes and reading existing notes from a file, demonstrating an understanding of Java File I/O and exception handling.

## ✨ Features

* **Add Note:** Prompts the user to enter a text note. This note is then **appended** to the `notes.txt` file.
* **View Notes:** Reads all lines from `notes.txt` and displays them on the console.
* **Clear Notes:** **Overwrites** the `notes.txt` file, effectively clearing all saved notes.
* **Exit:** Terminates the application.

## 🔑 Key Java Concepts Implemented

* **`FileWriter`:** Used for writing notes to the file. It is used in:
    * **Append Mode** (`new FileWriter(FILENAME, true)`) for adding new notes without deleting old ones.
    * **Overwrite Mode** (`new FileWriter(FILENAME, false)`) for the "Clear Notes" functionality.
* **`FileReader` & `BufferedReader`:** Used for reading notes. `BufferedReader` is wrapped around `FileReader` to read the file efficiently, line-by-line (`readLine()`).
* **`try-with-resources`:** All file I/O operations are enclosed in `try-with-resources` blocks. This ensures that resources like `FileWriter` and `BufferedReader` are automatically closed, preventing resource leaks.
* **Exception Handling:** The code includes `try-catch` blocks to handle potential `IOException` and `FileNotFoundException`, printing user-friendly error messages to the console.

## 🚀 How to Run

1.  Clone this repository.
2.  Open a terminal and navigate to the main Java source directory:
    ```sh
    cd Notes_App/src/main/java
    ```
3.  Compile the Java file (including the package folder):
    ```sh
    javac com/Notes/App.java
    ```
4.  Run the compiled class (using the full package name with a dot):
    ```sh
    java com.Notes.App
    ```
