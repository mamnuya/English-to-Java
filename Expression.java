import java.util.HashMap;

/**
 * This abstract class contains the ADT for an expression - a piece of code
 * that evaluates to an integer.
 */
public abstract class Expression {

  public abstract long eval(HashMap<String,Long> namespace);

}
