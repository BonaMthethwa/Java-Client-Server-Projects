
package serveraddition;
import java.net.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServerAddition {

    
    public static void main(String[] args) {
        ServerSocket s=null;
        Socket socket=null;
        BufferedReader in=null;
        int num1, num2;
        
        try {
            s=new ServerSocket(8080);
            socket=s.accept();
            System.out.println("Connection established");
            
            //read data throu a reading stream
            in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            
            
            num1=Integer.parseInt(in.readLine());
            num2=Integer.parseInt(in.readLine());
            
            //sum
            int sum=num1+num2;
            System.out.println("The sum of "+ num1+" +" +num2 +"="+ sum);
        } catch (IOException ex) {
            ex.printStackTrace();
        }finally{
            try {
                System.out.println("Closing connection..");
                socket.close();
            } catch (IOException ex) {
                Logger.getLogger(ServerAddition.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
}
