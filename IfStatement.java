import java.util.ArrayList;
import java.util.HashMap;

public class IfStatement extends Statement{
  private BooleanCheck condition;
  private ArrayList<Statement> ifBlock = new ArrayList<Statement>();

  /**
   * Constructor assigning a condition and the block of an if-statement
   * @param ifLine  Line containing the if-condition
   * @param ifBlock Block of code to run from the if-statement
   */
  public IfStatement(String ifLine, ArrayList<Statement> ifBlock){
    this.ifBlock=ifBlock;
    condition= new BooleanCheck(ifLine);
    //end of if statement is when indent level = same indent as if statement line end of block

  }

  /**
   * Checks if the boolean condition is true before running the if-block
   * @param namespace HashMap of variable names of String, matched to it's long value
   */
  public void execute(HashMap<String,Long> namespace){
    if (condition.eval(namespace)==1){
      //run the code in here
      for(Statement s : ifBlock) {
        s.execute(namespace);
      }
    }
  }

}
