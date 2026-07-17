
package echoserverapp;
import java.net.*;
import java.io.*;

public class EchoServerApp {

    public static void main(String[] args) throws IOException {
        ServerSocket s=null;
        Socket socket=null;
        BufferedReader in=null;
        PrintWriter out=null;
        
        s=new ServerSocket(8080);
        System.out.println();
        System.out.println("Server starting :"+ s);
        
        socket=s.accept();
        System.out.println("Connection established..");
        
        in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out=new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
        
        
        //read data
        while(true){
            String data=in.readLine();
            
            if(data.equals("END")){
                break;
            }else{
                System.out.println(data);
                out.print(data);
            }
        }
        
        
    }
    
}
