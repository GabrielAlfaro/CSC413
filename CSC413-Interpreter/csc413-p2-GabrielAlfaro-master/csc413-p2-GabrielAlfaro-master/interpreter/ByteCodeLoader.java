
package interpreter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.HashMap;


public class ByteCodeLoader extends Object {

    private BufferedReader byteSource;
    private Program program;
    private HashMap<String, String> byteCodeHash;
    
    public void setter(HashMap codeHash){
        this.byteCodeHash=codeHash;
    }
    public HashMap getter(){
        return byteCodeHash;
    }
    //Passing in the Hashmap to compare
    
    

    public ByteCodeLoader(String file) throws IOException {
        this.byteSource = new BufferedReader(new FileReader(file));
        //DONT FORGET TO CATCH EXCEPTION    
        
        //byteSource holds the file witht the byte code instructions
}
    /**
     * This function should read one line of source code at a time.
     * For each line it should:
     *      Tokenize string to break it into parts.
     *      Grab correct class name for the given ByteCode from CodeTable
     *      Create an instance of the ByteCode class name returned from code table.
     *      Parse any additional arguments for the given ByteCode and send them to
     *      the newly created ByteCode instance via the init function.
     * @return 
     */
    public Program loadCodes() {
        String tokenizer;
        //^used to keep track of function label
        String line;
        
        char indicator;
        String value;
        //^used to keep the int value of read Addrs
        String id;
        //^used to keep the variable name
        try {
            while((line=byteSource.readLine())!=null){
                String [] tokens;
                tokens=line.split(" ");
               int tokenSize=tokens.length;
               int i=0;
               tokenizer=tokens[i];
                while(tokenizer){
                 String key=codeTable.getClassName();
                    
                }
                 String className=CodeTable.getClassName(code);
                 Class c = Class.forName("packagename."+className);
                 //when using forName function
                 //need to specifiy the fully qualified class name
                //names seperated by .
                
                //Create an instance for the givne class blueprint
                ByteCode bc=(ByteCode) c.getDeclaredConstructor().newInstance();
              
                }
          } catch (IOException ex) {
            Logger.getLogger(ByteCodeLoader.class.getName()).log(Level.SEVERE, null, ex);
        }
         
     
       //return loadCodes();
       return loadCodes();
    }
}
