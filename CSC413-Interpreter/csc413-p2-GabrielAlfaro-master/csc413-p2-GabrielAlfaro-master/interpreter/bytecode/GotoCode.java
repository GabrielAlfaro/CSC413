
package interpreter.bytecode;

import java.util.ArrayList;
import java.util.Stack;

/**
 *
 * @author Gabriel
 */
public class GotoCode {
//Stack Changes: 0    
    private ArrayList runTimeStack;
    private Stack<Integer> framePointer;
   
    public void setter(ArrayList oldStack){//setter
      this.runTimeStack=oldStack;
  }  
    public ArrayList getter(){
      return runTimeStack;
  }    
    public void frameSetter(Stack frameStack){
      this.framePointer=frameStack;  
    }
    public Stack frameStackgetter(){
        return framePointer;
    } 
public GotoCode(String id, int value){
//go to the label     
    
    
    
}
    
    
}
