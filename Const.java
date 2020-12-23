import java.util.HashMap;

public class Const extends Expression {

  private long data;

  /**
   * Constructor assigning a String representation of a number to data
   * @param s String representation of a long
   */
  public Const(String s) {
    this.data = Long.parseLong(s);
  }

  /**
   * Constructor assigning a number to data
   * @param data long
   */
  public Const(long data) {
    this.data = data;
  }

  /**
   * Returns a numerical value from it's long/String representation
   * @param  namespace HashMap of variable names of String, matched to it's long value
   * @return long      Numerical value
   */
  @Override
  public long eval(HashMap<String,Long> namespace) {
    return data;
  }

}
