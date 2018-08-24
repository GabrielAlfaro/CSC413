/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpreter.bytecode;

import java.util.ArrayList;
import java.util.Stack;

/**
 *
 * @author Gabriel
 */
public abstract class ByteCode {
//Stack Changes: 0    
    public void execute(){
      int temp=VM.popRunStack();  
      //take the int from calling Virtual Machines popRunStack function
        
    } 
    public ByteCode(int i){
    //POP method call
    //pass the integer to PopCode
    //ByteCode PopCode   
    }   
//pass the tokens through ByteCode to the bytecodes in the file
    public ByteCode(String labelId){
   //if the bytecode being called is HALT, RETURN, READ or WRTIE    
    }
    
    public ByteCode(){
        //default constructor
    }
    
}

    
    
    
    

