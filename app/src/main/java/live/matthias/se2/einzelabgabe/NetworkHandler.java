package live.matthias.se2.einzelabgabe;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class NetworkHandler {
    public String handleNetwork(String s) throws IOException {
        Socket socket = new Socket("se2-isys.aau.at", 53212);
        DataOutputStream outToServer = new DataOutputStream(socket.getOutputStream());
        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        outToServer.writeBytes(s);
        String fromServer = inFromServer.readLine();
        socket.close();
        return fromServer;
    }
}
