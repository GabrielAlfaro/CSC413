
package interpreter.bytecode;

import java.util.ArrayList;
import java.util.Stack;

/**
 *
 * @author Gabriel
 */
public class WriteCode {
    /**
     * WRITE; Write the value of the top of
     * the stack to output. Leave the value 
     * on the top of the stack
     */
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
    
    public WriteCode(){
        print(runTimeStack);
        //call a method to print the stack once called 
 
        
    }
    public static void print(ArrayList e){      
        System.out.println(e.get(e.size()-1));
        
        System.out.println(e.get(0));
        
        //print the top of the stack and don't .pop
        //since runTimeStack is an arrayList
    }
    
    
}
