package com.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
public class Client {
    public static void main(String[] args) {
        try {
            Socket s = new Socket("localhost", 8080);
            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            PrintWriter out = new PrintWriter(s.getOutputStream(), true);
            Scanner scanner = new Scanner(System.in);
            boolean acceso = true;
            do{
                System.out.println("Scrivi qui sotto la tua scelta:...");
                String scelta = scanner.nextLine();
                out.println(scelta);
                if("EXIT".equalsIgnoreCase(scelta)){
                    System.out.println("Uscendo...");
                    acceso = false;
                }else if("NEXT".equalsIgnoreCase(scelta)){
                    System.out.println("Qua sotto scrivi la frase da modificare:...");
                    String frase = scanner.nextLine();
                    out.println(frase);
                    String risposta = in.readLine();
                    System.out.println("La frase: " + frase + " in maiuscolo è: " + risposta + ".");
                }else{
                    System.out.println("Comando non riconosciuto...riprova.");
                }
            }while(acceso);
            scanner.close();
            s.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
