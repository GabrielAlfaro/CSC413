
package interpreter.bytecode;

import java.util.ArrayList;
import java.util.Stack;

/**
 *
 * @author Gabriel
 */
public class CallCode {
/*Call <funcname>-    
*transfer control to the 
*indicated function
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
    
    public CallCode(){
    //framePointer(0);    
        
    }
    
    public CallCode(String str){
        //create an instance of the function name
        ByteCode str = new ByteCode(str);
        //Interpreter str = new Program();
    }

}
