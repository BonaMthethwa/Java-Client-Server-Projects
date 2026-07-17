
package clientmessage;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ClientMessage {

   
    public static void main(String[] args) {
        InetAddress addr=null;
        Socket socket=null;
        PrintWriter out;
        
        try {
            addr=InetAddress.getByName("127.0.0.1");
            socket=new Socket(addr, 8080);
            out=new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())),true);
            
            out.println("Hello");
            
        } catch (UnknownHostException ex) {
            Logger.getLogger(ClientMessage.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ClientMessage.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                System.out.println("Closing communication socket...");
                socket.close();
            } catch (IOException ex) {
                Logger.getLogger(ClientMessage.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
