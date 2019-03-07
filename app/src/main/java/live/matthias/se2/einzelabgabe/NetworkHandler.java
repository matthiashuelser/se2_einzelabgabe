package live.matthias.se2.einzelabgabe;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class NetworkHandler {
    public String handleNetwork(String input) throws IOException {
        Socket clientSocket = new Socket("se2-isys.aau.at", 53212);
        DataOutputStream toServer = new DataOutputStream(clientSocket.getOutputStream());
        BufferedReader fromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        toServer.writeBytes(input + '\n');
        String output;
        output = fromServer.readLine();
        return output;
    }
}
