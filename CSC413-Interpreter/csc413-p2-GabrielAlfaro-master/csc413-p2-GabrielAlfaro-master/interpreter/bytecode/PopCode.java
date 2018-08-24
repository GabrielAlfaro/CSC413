
package interpreter.bytecode;

import interpreter.RunTimeStack;
import java.util.ArrayList;
//importing RunTimeStack

import java.util.Stack;

/**
 *
 * @author Gabriel
 */
public class PopCode {
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

    public int popRunStack(){
      return runStack.pop();  
    }
    
}
