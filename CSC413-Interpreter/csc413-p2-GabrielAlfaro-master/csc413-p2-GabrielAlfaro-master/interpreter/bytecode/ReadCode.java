
package interpreter.bytecode;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;
/**
 *
 * @author Gabriel
 */
public class ReadCode {
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


public ReadCode(){
//Stack Changes: 0

    
     try{
   Scanner userInput = new Scanner(System.in);
   System.out.println("Enter an integer:");
   int number=userInput.nextInt();
    }catch(NumberFormatException e){
     System.out.println("--Not a valid Number--");          
    }
    
}    
    
}
