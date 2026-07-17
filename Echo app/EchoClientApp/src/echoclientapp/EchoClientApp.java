
package echoclientapp;
import java.net.*;
import java.io.*;

public class EchoClientApp {

   
    public static void main(String[] args) throws UnknownHostException, IOException {
      InetAddress addr=null;
      Socket socket=null;
      PrintWriter out=null;
      BufferedReader in=null;
      String msg="Hi";
      addr=InetAddress.getByName("127.0.0.1");
      System.out.println("Address: "+addr);
      
      socket=new Socket(addr, 8080);
      System.out.println("Socket: "+socket);
      
      in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
      out=new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())),true);
      
      for(int x=0; x<10; x++){
          //display message client
          System.out.println("Client "+msg);
          
          //send message to server
          out.println(msg);
          
          //read message from server
          String serverMsg=in.readLine();
          
          //display message rom the server
          System.out.println("Server :"+ serverMsg);
        
      }
        out.println("END");
        
    }
    
}
