/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.bl;

/**
 *
 * @author MemaniV
 */
public class IDHandlerManager implements IDHandler {
    public IDHandlerManager(){
    }
    
	//create a safe method for verifying an id
    public synchronized String verifyID(String id) {
        String outcome = "Invalid";
        //determine the size of the id
        int size = id.length();
        
        //check if the length of the id is 13
        if(size == 13){
            //extra digit seven to ten 
            int range = Integer.parseInt(id.substring(6,10));
            //check the range
            if((range >= 0 && range <=9999)){
                outcome = "Valid";
            }
        }
        //return the outcome
        return outcome;
    }
}
