
package clientaddition;
import java.net.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClientAddition {

    
    public static void main(String[] args) {
      InetAddress addr=null;
      Socket socket=null;
      PrintWriter out = null;
      int num1=1, num2=2;
      
        try {
            addr=InetAddress.getByName("127.0.0.1");
            System.out.println("addr: "+addr);
            socket=new Socket(addr, 8080);
            System.out.println("Socket :"+ socket);
            out=new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
            out.println(num1);
            out.println(num2);
            
           
        } catch (UnknownHostException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }finally{
          try {
              System.out.println("Communication closed....");
              
              if(out != null){
                  out.close();
              }
              if(socket != null){
              socket.close();}
          } catch (IOException ex) {
              ex.printStackTrace();
          }
        }
      
    }
    
}
