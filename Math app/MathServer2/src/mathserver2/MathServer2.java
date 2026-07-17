
package mathserver2;
import java.net.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class MathServer2 {

    
    public static void main(String[] args) throws IOException {
       ServerSocket s=null;
       Socket socket=null;
       BufferedReader in=null;
       PrintWriter out;
       String data;
       
       s=new ServerSocket(9191);
       System.out.println("Server started:"+s);
       while(true){
       socket=s.accept();
       System.out.println("Connection establishedd..."+ socket);
      
         new RequestHandler(socket); 
       } 
       
               
    }
        
    }
    
    

