
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import mathserver2.MathServer2;


public class RequestHandler extends Thread{
        private Socket socket;
        private BufferedReader in;
        private PrintWriter out;

        public RequestHandler(Socket socket) throws IOException {
            this.socket = socket;
            in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out=new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
            
            start();
        }
        @Override
        public void run() {
          String data = null;
          int outcome=0;
          char op;
          int num1, num2;
      
          
              
              try {
                  System.out.println("Servicing request from IP address: "+ socket+ "\n");
                  while(true){
                  data=in.readLine();
                  
                  if(data !=null){
                      String[] tokens=data.split("#");
       
         
                    num1=Integer.parseInt(tokens[0]);
                    num2=Integer.parseInt(tokens[1]);
                    op=tokens[2].charAt(0);
                    
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
        
      }
      
                  }
               
              } catch (IOException ex) {
                  Logger.getLogger(MathServer2.class.getName()).log(Level.SEVERE, null, ex);
              }
          
      }
}
