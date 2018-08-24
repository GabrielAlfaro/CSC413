package interpreter;

import java.util.Stack;

public class VirtualMachine {

    private RunTimeStack runStack;//runStack object
    private Stack<Integer> returnAddrs;
    private Program program;
    //program^ is where the bytecodes are stored
    private int pc;
    //^the program counter(current bytecode being executed)
    private boolean isRunning;

    protected VirtualMachine(Program program) {
        //setting the program 
        this.program = program;
    }
    
    
    public void executeProgram(){
    pc=0;
    runStack=new RunTimeStack();
    returnAddrs=new Stack<Integer>();
    isRunning=true;
    while(isRunning){
        ByteCode code=program.getCode(pc);
        code.execute(this);
        //runStack.dump(); //used to dump runstack state
        pc++;  
    }
}
  
    public int popRunStack(){
      return runStack.pop();
 
      
    } 
    public int returnCode(){
        //could not finish implementing
     return 0;   
    }
    
        
    }
