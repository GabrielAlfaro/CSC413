package interpreter.bytecode;

import interpreter.RunTimeStack;
import java.util.ArrayList;
import java.util.Stack;

/**
 *
 * @author Gabriel
 */
public class LoadCode {
//Stack changes: +1
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

    public LoadCode(int n, String id, int offset) {
        //framePointer.pop()=start of frame
        int values=n-offset;
        if(values<=0){
          values=0;  
        }
        framePointer.push(values);
        runTimeStack.add(values, id);

    }

}
