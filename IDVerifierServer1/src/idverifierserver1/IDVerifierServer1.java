
package idverifierserver1;
import java.net.*;
import java.io.*;
import za.ac.tut.bl.IDHandlerThread;
public class IDVerifierServer1 {

    
    public static void main(String[] args) {
        // TODO code application logic here
        ServerSocket s;
        Socket socket;
        
        try {
            //create a socket that will listen for requests at port 9191
            s = new ServerSocket(9191);
            
            while(true){
                //wait for a client request
                socket = s.accept();
                //create a thread to ahandle the request
                IDHandlerThread handler = new IDHandlerThread(socket);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    
}

    
    

