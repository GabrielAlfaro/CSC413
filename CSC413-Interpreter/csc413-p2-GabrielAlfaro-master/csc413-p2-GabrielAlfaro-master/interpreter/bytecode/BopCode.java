
package interpreter.bytecode;

import java.util.ArrayList;
import java.util.Stack;

/**
 *
 * @author Gabriel
 */
public class BopCode {
//Stack changes: -1   
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
    
    
    public BopCode(String op){
    //pop top 2 levels of Stack
    
    int val1=(int)runTimeStack.get(runTimeStack.size()-1);
    int val2=(int)runTimeStack.get(runTimeStack.size()-2);
    int result;
    switch(op){
        case "+":
            result=val1+val2;
        case "-":
            result=val1-val2;
        case "/":
            result=val1/val2;
        case "*":
            result=val1*val2;
        case "==":
            result=val1;
        case "!=":
            result=val2;
//how to perform <= and ==?            
            
//second-level + top-level            
           
    }
    
   
    
        
        
    }
    
    
}
