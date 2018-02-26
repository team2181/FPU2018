/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc2181.FPU2018;

import java.io.*;

/**
 *
 * @author Justin
 */
public class saveEncoder {
    
    double distance, velocity, timestamp;
    
    FileOutputStream os;
    
    DataOutputStream dos;
    
    public saveEncoder(){
        
        
        
        }
    
    public void startWrite(String fileName){
        
        try{
    
            os = new FileOutputStream(fileName);
            dos = new DataOutputStream(os);
        
            dos.writeBytes("Dist");  
            dos.writeBytes(", ");  
            dos.writeBytes("Vel");
            dos.writeBytes(", ");  
            dos.writeBytes("Time");
            os.write(System.getProperty("line.separator").getBytes());
    
        }catch(IOException e) {
    
            System.out.println("Exception: Javas shouldn't quit but yours did (Close the file)");
        }
        
        
    }
    
    public void writeInfo(double distance, double velocity, double timestamp){
        
        
         try{
    
            dos.writeBytes(String.valueOf(distance));  
            dos.writeBytes(", ");  
            dos.writeBytes(String.valueOf(velocity));
            dos.writeBytes(", ");  
            dos.writeBytes(String.valueOf(timestamp));
            
            os.write(System.getProperty("line.separator").getBytes());
            //os.write('\n');
            
            
    
        }catch(IOException e) {
    
            System.out.println("Exception: Javas shouldn't quit but yours did (Close the file)");
        }
        
    }
    
    public void endWrite(){
        
        
        
        try{
    
            dos.close();
            os.close();
    
        }catch(IOException e) {
    
            System.out.println("Exception: Javas shouldn't quit but yours did (Close the file)");
        }
        
        
        
    }
    
}
