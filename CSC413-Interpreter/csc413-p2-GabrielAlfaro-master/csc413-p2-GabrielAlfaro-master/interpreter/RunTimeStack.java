package interpreter;

import java.util.ArrayList;
import java.util.Stack;
import java.util.*;

public class RunTimeStack {

    private ArrayList runTimeStack;
    //ArrayList implements Vector
    //frame pointer points to the runTime stack
    private Stack<Integer> framePointer;
    //LIFO
    //this stack is used to record the beginining
    //of each activation record(frame) when calling functions
    //framePointer stack will hold the values 
    
    public RunTimeStack() 
    {
        runTimeStack = new ArrayList<>();
        framePointer = new Stack<>();
        //Add initial Frame Pointer, main is the entry
        // point of our language, so its frame pointer is 0.
        framePointer.add(0);
    }

//focus on implementing what the runtime stack will have
    public void dump(){
     //could not implement   
    }
    
    public int peek(){
        return (int) runTimeStack.get(runTimeStack.size()-1);
    //return top of the runTimeStack but don't remove
    
    }
    public int pop(){  
    //removes an item from the top of the stack and 
    //returns it
    int temp=0;
    temp=(int)runTimeStack.get(0);
    runTimeStack.remove(0);
   //removes the top of runTimeStack    
        return temp;
    }
    public int push(int i){
    //item added is also returned    //add an item to the top of runTimeStack

    runTimeStack.add(i);    
        return i;    
    }
    public void NewFrameAt(int offset){
    //creates a new frame in runTimeStack class
    //offset used to denote how many slots down from the TOP
    //of the runStack for starting a new frame
    int AListSize=runTimeStack.size();
    framePointer.push(AListSize-offset);
    //push the new framePointer into the size-offset    
    }
    public void popFrame(){
    //pop the top frame when returning from a function
    //before popping, functions return value is at top of stack
    //save value, pop the top frame, push return value back to the stack
    int value=framePointer.peek();
    framePointer.pop();//popping from framePointer    
    //taking top of framePointer and saving the value
    framePointer.push(value);
    //push the value back into the framePointer stack 
    }
    public int store(int offset){
    //frame pointer = stack
    //store values into variables
    //pop the top value of the stack
    //replace the value at the given offset in
    //the current frame, value is returned
    int value=framePointer.peek();
    framePointer.pop();
    framePointer.add(offset, value);
    //replace the value at offset in the current frame with int variables
    //pop the current frame Pointer 
        return value;   
        //return the value
    }
    public int load(int offset){
       //given offset in current frame
       int value=framePointer.elementAt(offset);
       //getting the element at the offset
       runTimeStack.add(value);
       framePointer.push(value);
       //push back onto top of stack
        return 0;  
    }
    public Integer push(Integer val){
    //used to load LITers onto the runtimeStack
    //example LIT 5 will call push with
    //val being 5
    runTimeStack.add(val);
    //or
    framePointer.push(val);
        return val;  
    }
    
    
}
