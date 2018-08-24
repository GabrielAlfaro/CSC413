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
public class ArgsCode extends ByteCode {
    //add getters and setters to all byte code classes?
        private ArrayList runStack;
   
  public void setter(ArrayList oldStack){//setter
      this.runStack=oldStack;
  }  
  public ArrayList getter(){
      return runStack;
  }

    /**
     *
     * @param n
     */
    public ArgsCode(int n){
        int counter=0;
        int size;
        while(counter<=n){
            CallCode CallCode= new CallCode();
            //creating a CallCode object
        //interpreter to set up a new frame n down
        //from the top  of the runtime stack
            
          counter++;  
        }

  }    
}
