/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.bl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MemaniV
 */
public class IDHandlerThread extends Thread {
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    
    public IDHandlerThread(Socket socket) throws IOException{
        //initialize the socket
        this.socket = socket;
        //create a reading stream
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        //create a writing stream
        out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
        //start the thread
        start();
    }
    
    @Override
    public void run(){
        String id, outcome;
        IDHandlerManager manager;
        
        try {   
            //read the data 
            id = in.readLine();
            //check if its not null
            while(!id.equals("STOP")){    
                //create a handler
                manager = new IDHandlerManager();    
                //verify the id
                outcome = manager.verifyID(id);
                //send the outcome to the client
                out.println(outcome);
                //read the data again
                 id = in.readLine();
            }
            
            System.out.println("GoodBye!!!!");
        } catch (IOException ex) {
            Logger.getLogger(IDHandlerThread.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(IDHandlerThread.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            try {
                in.close();
                out.close();
                socket.close();
            } catch (IOException ex) {
                Logger.getLogger(IDHandlerThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
