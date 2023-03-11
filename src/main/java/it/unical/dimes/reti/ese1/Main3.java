package it.unical.dimes.reti.ese1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Main3 {

  //DOWNLOAD DI UNA PAGINA HTML CON JAVA
  public static void main(String[] args) {
    try {

      //connessione tramite socket al server web di Google sulla porta 80 (la porta standard per le richieste HTTP)
      Socket s = new Socket("google.com",80);

      // scrivere dati nella connessione di output del socket
      PrintWriter out = new PrintWriter (s.getOutputStream(),true);

      //leggere i dati di input dalla connessione di input del socket
      BufferedReader in = 
         new BufferedReader (new InputStreamReader(s.getInputStream()));

      //Si invia una richiesta HTTP a un server web tramite il socket
      out.print ("GET / HTTP/1.1");
      out.println ();
      out.println ();
      boolean more = true;

      //si leggono le risposte del server web
      while (more) {
         String line = in.readLine();
         if (line == null) more = false;
         else System.out.println(line);
      }
    } catch (IOException e) { System.out.println("Error"+e); }
  }
}

