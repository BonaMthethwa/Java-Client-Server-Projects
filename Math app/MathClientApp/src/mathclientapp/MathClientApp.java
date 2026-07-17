
package mathclientapp;
import java.net.*;
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class MathClientApp {

    public static void main(String[] args) throws UnknownHostException, IOException  {
        
            InetAddress addr=null;
            Socket socket=null;
            PrintWriter out=null;
            BufferedReader in=null;
            int option, num1, num2;
            Scanner sc=new Scanner(System.in);
            
            
            addr=InetAddress.getByName("127.0.0.1");
            System.out.println("IP Adress: "+ addr);
            
            socket=new Socket(addr, 8080);
            System.out.println("Socket: "+ socket);
            
            out=new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
            in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            
            //where the real wiork start
            option=displayOption();
            String op=null;
            
            while(option !=4){
                
                System.out.println("Enter first number");
                num1=sc.nextInt();
                
                System.out.println("Enter second number");
                num2=sc.nextInt();
                
                String data= num1+ "#" + num2;
                
                switch(option){
                    case 1:
                        data=data+ "#"+ "+";
                        op="+";
                        break;
                    
                    case 2:
                        data=data+ "#"+ "-";
                        op="-";
                        break;
                        
                    case 3:
                        data=data+ "#"+ "*";
                        op="*";
                        break;
                        
                    case 4:
                        out.println("END");
                        System.exit(0);
                        break; 
                        
                    default:
                        System.out.println("Invalid option");
                }
                out.println(data);
                String serverR=in.readLine();
                System.out.println(num1 + op + num2+ "="+ serverR);
                option=displayOption();
            }
            out.close();
            in.close();
            socket.close();
            
            
  }
        public static int displayOption(){
        Scanner sc=new Scanner(System.in);
        
        System.out.println("Select one of the following options : \n"
                + "1- Add numbers \n"
                + "2-Subtract numbers \n"
                + "3-Multiply numbers \n"
                + "4- Exit program \n"
                + "Your choice :" 
                        );
        int choice=sc.nextInt();
        
        return choice;
    }
}
