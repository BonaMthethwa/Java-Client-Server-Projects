/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package idapp;
import java.net.*;
import java.util.*;
import java.io.*;
/**
 *
 * @author User
 */
public class IDVerifierClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
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
            socket = new Socket(addr, 9191);
            
            //create a reading stream
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            
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
                    out.println(idNo);
                    
                    //wait for server outcome
                    outcome = in.readLine();
                    
                    //display outcome
                    System.err.println("Outcome: " + outcome);
                } else {
                    System.err.println(option + " is invalid.");
                }
                //display the options again
                option = getOption();
            }
			
            out.println("STOP");
        } catch (UnknownHostException ex) {
            ex.printStackTrace();
        }catch (IOException ex) {
            ex.printStackTrace();
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
    
