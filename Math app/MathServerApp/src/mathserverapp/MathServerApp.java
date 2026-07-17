
package mathserverapp;
import java.net.*;
import java.io.*;


public class MathServerApp {

   
    public static void main(String[] args) throws IOException {
      
      ServerSocket s=null;
      Socket socket=null;
      BufferedReader in=null;
      PrintWriter out=null;
      String data;
      int num1, num2;
      //instantiate
      s=new ServerSocket(8080);
      System.out.println("Server started :"+s);
      
      socket=s.accept();
      System.out.println("Connection established");
      
      in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
      out=new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())),true);
      
      while(true){
         data=in.readLine();
         String[] tokens=data.split("#");
         int outcome=0;
         
         num1=Integer.parseInt(tokens[0]);
         num2=Integer.parseInt(tokens[1]);
         char op=tokens[2].charAt(0);
         
         if(op=='+'){
             outcome=num1+num2;
         }else if(op=='-'){
             outcome=num1-num2;
         }else if(op=='*'){
             outcome=num1*num2;
         }
         
         out.println(outcome);
         out.close();
         in.close();
         socket.close();
         s.close();
      }
      
    }
    
}
