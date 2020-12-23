import java.util.HashMap;
import java.util.Scanner;

/**
 * A class to contain the information needed for assigning values to variables.
 *
 */

public class AssignmentStatement extends Statement{
  private Expression data;
  private String var;
  String operatorOptions="+-*/%";
  String operator=null;


  /**
   * Checks the type of assignment statement, and assigns a long to data to be associated with a variable
   * Assigning a variable to:
   * (another variable, a long, an arithmetic expression, a function call)
   * @param s Line containing the name of variable and it's assignment value
   */
  public AssignmentStatement(String s){
    this.var=s.substring(s.indexOf("Set")+3, s.indexOf("to"));
    for (int i=0; i<operatorOptions.length();i++){
      if (s.contains(operatorOptions.substring(i,i+1))){
        operator=operatorOptions.substring(i,i+1); //Finds which operator is in line of code;
      }
    }

    if (!s.contains("+") && !s.contains("-") && !s.contains("*") && !s.contains("/") && !s.contains("%") && !s.contains("input") && !s.contains("(")){
      try {
        this.data=new Const(s.substring(s.indexOf("to")+2,s.length()));
      }
      catch (NumberFormatException exc){
        this.data= new Variable(s.substring(s.indexOf("to")+2,s.length()));
      }
    }
    else if ((s.contains("+") || s.contains("-") || s.contains("*") || s.contains("/") || s.contains("%")) && !s.contains("input") && !s.contains("(")){
      this.data=new MathExp(s);
    }
    else if (s.contains("input")){
      Scanner scan=new Scanner(System.in);
      System.out.println("Type in an int value for the variable named: "+ var);
      this.data= new Const (scan.nextLong());
      System.out.println();
    }
    else if (s.contains("(")&& s.contains(")")){ // parameters () in every method call
      //function call
      this.data=new FunctionCall(s); //s holds a=functionCall(param1, param2, etc);
    }
  }

  /**
   * Stores the variable with the assignment value evaluated into a long
   * @param namespace HashMap of variable names of String, matched to it's long value
   */
  @Override
  public void execute(HashMap<String,Long> namespace){ //evaluate right hand side, store in namespace
    if (data!=null){
      namespace.put(var, data.eval(namespace));
    }
  }

}
