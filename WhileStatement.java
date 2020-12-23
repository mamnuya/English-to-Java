import java.util.ArrayList;
import java.util.HashMap;

public class WhileStatement extends Statement{
  private BooleanCheck condition;
  private ArrayList<Statement> whileBlock = new ArrayList<Statement>();

  /**
   * Constructor assigning a condition and the block in a while-loop
   * @param whileCondition Line of while-loop containing a boolean condition
   * @param wBlock         Block of code to be run in a while-loop, including updation line
   */
  public WhileStatement(String whileCondition, ArrayList<Statement> wBlock){
    this.whileBlock=wBlock;
    condition= new BooleanCheck(whileCondition);
  }

  /**
   * Executes the while-block
   * Checks if the boolean condition is true after each execution of the while block
   * @param namespace HashMap of variable names of String, matched to it's long value
   */
  public void execute(HashMap<String,Long> namespace){
    if (condition.eval(namespace)==1){
      while (condition.eval(namespace)==1){
        for(Statement s : whileBlock) {
          s.execute(namespace);
        }
      }
    }
    else if (condition.eval(namespace)==0){
      return;
    }
  }

}
