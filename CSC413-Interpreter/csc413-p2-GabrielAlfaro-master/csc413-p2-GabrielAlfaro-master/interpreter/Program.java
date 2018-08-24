package interpreter;

import interpreter.bytecode.ByteCode;
//added the top line^

import java.util.ArrayList;

public class Program {

    private ArrayList<ByteCode> program;

    public Program() {
        program = new ArrayList<>();
        //program is a new ArrayList object
    }

    protected ByteCode getCode(int pc) {
        //pc = index
        return this.program.get(pc);
        //returns the bytecode at the given index
    }

    public int getSize() {
        return this.program.size();
        //return the size of the current arrayList
        //program
    }

    /**
     * This function should go through the program and resolve all addresses.
     * Currently all labels look like LABEL <<num>>>, these need to be converted into
     * correct addresses so the VirtualMachine knows what to set the Program Counter(PC)
     * HINT: make note what type of data-stucture bytecodes are stored in.
     *
     * @param program Program object that holds a list of ByteCodes
     */
    public void resolveAddrs() {
        //go through program object
        int counter=0;
        while(counter<=program.size()-1){
            while(counter<=program.size()){

        //
        //compare precedence?
        }
 
    }




}
