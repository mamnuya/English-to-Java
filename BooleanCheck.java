import java.util.ArrayList;
import java.util.HashMap;

public class BooleanCheck extends Expression {

  private String[] operatorOptions= new String[] {" < "," <= "," == "," >= "," > ", " != "};
  private String operator=null;
  private Expression leftExp;
  private Expression rightExp;
  private long data;

  /**
   * Constructor separating the operator of a condition and the left/right values
   * @param s [description]
   */
  public BooleanCheck(String s){
    for (int i=0; i<operatorOptions.length;i++){
      if (s.contains(operatorOptions[i])){
        operator=operatorOptions[i];
    }
  }

    try {
      leftExp = new Const(s.substring(s.indexOf("(")+1,s.indexOf(operator)).replaceAll(" ",""));
    }
    catch(NumberFormatException e){
      leftExp= new Variable(s.substring(s.indexOf("(")+1,s.indexOf(operator)).replaceAll(" ",""));
    }
    try {
      rightExp = new Const(s.substring(s.indexOf(operator)+operator.length(),s.indexOf(")")).replaceAll(" ",""));
    }
    catch (NumberFormatException e){
      rightExp= new Variable(s.substring(s.indexOf(operator)+operator.length(),s.indexOf(")")).replaceAll(" ",""));
    }
  }


  /**
   * Evaluates if the condition is true based on the operator
   * @param  namespace HashMap of variable names of String, matched to it's long value
   * @return long         1 if the condition is true, 0 if the condition is false
   */
  @Override
  public long eval(HashMap<String,Long> namespace) { //return 1 if left op right is true else 0
    this.data=0;
    if (operator.equals(" < ")){
      if (leftExp.eval(namespace)<rightExp.eval(namespace)){
        data=1;
      }
    }
    if (operator.equals(" <= ")){
      if (leftExp.eval(namespace)<=rightExp.eval(namespace)){
        data=1;
      }
    }
    if (operator.equals(" == ")){
      if (leftExp.eval(namespace)==rightExp.eval(namespace)){
        data=1;
      }
    }
    if (operator.equals(" >= ")){
      if (leftExp.eval(namespace)>=rightExp.eval(namespace)){
        data=1;
      }
    }
    if (operator.equals(" > ")){
      if (leftExp.eval(namespace)>rightExp.eval(namespace)){
        data=1;
      }
    }
    if (operator.equals(" != ")){
      if (leftExp.eval(namespace)!=rightExp.eval(namespace)){
        data=1;
      }
    }
    return data;
  }

}
