import java.util.HashMap;

public class Variable extends Expression {

  private String variableName;

  /**
   * Constructor for assigning the variable's name
   * @param s Name of a variable
   */
  public Variable(String s) {
    this.variableName = s;
  }

  /**
   * Finds the long value associated with the variableName
   * @param  namespace HashMap of variable names of String, matched to it's long value
   * @return long      Value assigned to the variable
   */
  @Override
  public long eval(HashMap<String,Long> namespace) {
    //returns number associated with variable name
    return namespace.get(variableName);
  }
}
