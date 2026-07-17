
package servermessage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ServerMessage {

    
    public static void main(String[] args) {
        ServerSocket s=null;
        Socket socket=null;
        BufferedReader in;
        String data;
        try {
            s=new ServerSocket(8080);
            
            socket=s.accept();
            System.out.println("Connection established");
            in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            data=in.readLine();
            System.out.println("Message received "+data);
        } catch (IOException ex) {
            Logger.getLogger(ServerMessage.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                System.out.println("Closing communication...");
                socket.close();
            } catch (IOException ex) {
                Logger.getLogger(ServerMessage.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
