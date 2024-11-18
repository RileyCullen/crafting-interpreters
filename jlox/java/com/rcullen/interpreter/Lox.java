package com.rcullen.interpreter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Lox {
    public static void main(String[] args) throws IOException{
        Lox.handleStartup(args);
    }

    /**
     * Handles start up of jlox interpreter.
     */
    private static void handleStartup(String[] args) throws IOException {
        if (args.length > 1) {
            System.out.println("Usage: jlox [script]");
            System.exit(64);
        } else if (args.length == 1) {
            runFile(args[0]);
        } else {
            System.out.println("Enabling jlox intepreter. Press ctrl + D to exit");
            runPrompt();
        }
    }

    /**
     * Executes contents of file at path.
     */
    private static void runFile(String path) throws IOException {
        byte[] bytes = Files.readAllBytes(Paths.get(path));
        run(new String(bytes, Charset.defaultCharset()));
    }

    /**
     * Spin up jlox interpreter.
     */
    private static void runPrompt() throws IOException {
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(input);

        while(true) {
            System.out.print("> ");
            String line = reader.readLine();
            if (line == null) {
                break;
            }
            run(line);
        }
    }

    private static void run(String source) {
        System.out.println("Testing Java");
        // Scanner scanner = new Scanner(source);
        // List<Token> tokens = scanner.scanTokens();

        // Print tokens
        // for (Token token : tokens) {
            // System.out.println(token);
        // }
    } 
}

