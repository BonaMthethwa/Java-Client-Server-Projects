
package idverifierclientdb;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MemaniV
 */
public class IDVerifierClientDB {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        InetAddress addr;
        Socket socket;
        BufferedReader in;
        PrintWriter out;
        int option;
        Scanner sc = new Scanner(System.in);
        String idNo, outcome;
        
        try {
            //state the IP address of the computer you want to communicate with
            addr = InetAddress.getByName("127.0.0.1");
            
            //create the communication socket at port 9191
            socket = new Socket(addr, 9191);//1 &2
            
            //create a reading stream
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));//3
            
            //create a writing stream
            out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
            
            //get a user option
            option = getOption();
            
            while(option != 2){
                if(option == 1){
                    //get an ID number
                    System.out.println("\nPlease enter an ID number: ");
                    idNo = sc.nextLine();
                    
                    //send the ID number to the server
                    out.println(idNo);//5
                    
                    //wait for server outcome
                    outcome = in.readLine();//6
                    
                    //display outcome
                    System.err.println("Outcome: " + outcome);//
                } else {
                    System.err.println(option + " is invalid.");
                }
                //display the options again
                option = getOption();//8
            }
			
            out.println("STOP");
        } catch (UnknownHostException ex) {
            Logger.getLogger(IDVerifierClientDB.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(IDVerifierClientDB.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private static int getOption() {
        int option;
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Please select one of the following options: " + "\n" +
                "1 - send an ID number to the server" + "\n" +
                "2 - exit");
        option = sc.nextInt();
        return option;
    }
    
}
