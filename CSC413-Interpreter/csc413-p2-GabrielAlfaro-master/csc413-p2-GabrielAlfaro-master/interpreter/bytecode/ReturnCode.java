
package interpreter.bytecode;
import interpreter.CodeTable;
import java.util.ArrayList;
import java.util.Stack;
/**
 *
 * @author Gabriel
 */
public class ReturnCode {
    private Stack runStack= new Stack<>();
 /**
  * RETURN <funcname>; Return from the current function; <funcname> is
  * used as a comment to indicate the current function,
   RETURN is generated for intrinsic functions.
     * @param oldStack
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
      
    public ReturnCode(String funcName) throws ClassNotFoundException{//return from the current function
        String str=funcName;
        String className=CodeTable.getClassName(str);
        Class c = Class.forName(funcName+className);
        //instantiates the code to return to 
}
        }

