package live.matthias.se2.einzelabgabe;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class NetworkThread extends Thread{
    String input;
    String output;

    public void run() {
        try {

            //Erstelle ein neues Socket mit dem gegebenen Host und Port.
            Socket clientSocket = new Socket("se2-isys.aau.at", 53212);

            //Erstelle einen OutputStream mit dem die Daten an den Server gesendet werden.
            DataOutputStream toServer = new DataOutputStream(clientSocket.getOutputStream());

            //Erstelle einen BufferedReader um Daten vom Server empfangen zu können.
            BufferedReader fromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            //Sende den Eingabe-String an den Server und erhalte Antwort vom Server.
            toServer.writeBytes(input + '\n');
            output = "Ausgabe: " + fromServer.readLine();

        } catch (IOException e) {
            output = "Fehler!";
        }
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getOutput() {
        return output;
    }
}
