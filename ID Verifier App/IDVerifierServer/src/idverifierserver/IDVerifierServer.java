
package idverifierserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import za.ac.tut.bl.IDHandlerThread;


public class IDVerifierServer {

   
    public static void main(String[] args) {
        // 
        ServerSocket s;
        Socket socket;
        
        try {
            //create a socket that will listen for requests at port 9191
            s = new ServerSocket(9191);//9
            
            while(true){
                //wait for a client request
                socket = s.accept();//10
                //create a thread to ahandle the request
                IDHandlerThread handler = new IDHandlerThread(socket);//11
            }
        } catch (IOException ex) {
            Logger.getLogger(IDVerifierServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
