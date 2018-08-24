
package interpreter.bytecode;

import java.util.ArrayList;
import java.util.Stack;

/**
 *
 * @author Gabriel
 */
public class StoreCode {
    private Stack<Integer> framePointer;
    private ArrayList runTimeStack;
   
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
    
    
//Stack changes: -1    
//pop the top of the stack
//store the value into the offset n from the start of the frame
//<id> used as variable name where data is stored    
public StoreCode(int n, int offset){
   int val;
   int total=offset-n;
    val=(int)framePointer.pop();
    framePointer.push(total);
}
 
}
