/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aina.code;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Random;
import java.util.Scanner;


public class AinaCode {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        String [] code = {"WXES1116","WXES1115","WXES1110","WXES1112"};
        String [] name = {"Programming I","Data Structure","Operating System","Computing Mathematics I"};
    
        try{
            
            ObjectOutputStream os = new ObjectOutputStream (new FileOutputStream("course.dat"));
            for(int i=0;i<code.length;i++){
                os.writeUTF(code[i]);
                os.writeUTF(name[i]);
                
            }
             os.close();
        }catch(IOException e){
            System.out.println("IO error occured");
        }
        
        
        // search from the file
        String searchCode;
        boolean flag_status = false;
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter a code : ");
        searchCode = input.nextLine();
        
        try{
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("course.dat"));
            
            try{
                while(true){
                    if(searchCode.equalsIgnoreCase(in.readUTF())){
                        System.out.println("Course Code :" + searchCode);
                        System.out.println("Course Name :" + in.readUTF());
                        flag_status = true;
                        break;
                    }else
                        in.readUTF();
                }
                in.close();
            }catch(IOException e){}
        }catch(IOException e){}
       
        if(!flag_status)
            System.out.println("Code Not Found");
        
    }
    
}