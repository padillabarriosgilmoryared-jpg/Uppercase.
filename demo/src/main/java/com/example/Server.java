package com.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) {
        try{
            ServerSocket ss = new ServerSocket(8080);
            System.out.println("Connessione aperta in locale...");
            Socket s = ss.accept();
            System.out.println("Client connesso al Server locale");
            boolean finito = false;
            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            PrintWriter out = new PrintWriter(s.getOutputStream(), true);
            do{
                System.out.println("Scrivi la tua scelta: continuare (NEXT) o uscire (EXIT)");
                String scelta = in.readLine();
                scelta = scelta.toUpperCase();
                switch(scelta){
                    case "NEXT":
                        System.out.println("TRASFORMO QUALUNQUE COSA TU ABBIA IN UPPERCASE...");
                        System.out.println("Scegli cosa scrivere:");
                        String fraseRicevuta = in.readLine();
                        System.out.println("Frase ricevuta...");
                        fraseRicevuta = fraseRicevuta.toUpperCase();
                        System.out.println("frase in elaborazione... frase portata in UPPERCASE.");
                        out.println(fraseRicevuta);
                    break;
                    case "EXIT":
                        System.out.println("Uscita in corso...");
                        finito= true;
                    break;
                    default:
                        System.out.println("ERRORE,SCELTA NON VALIDA.");
                    break;
                }
                System.out.println("COSA VUOI FARE?... CONTINUARE (NEXT) o USCIRE (EXIT)).");

            }while(!finito);
            s.close();
            ss.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
}