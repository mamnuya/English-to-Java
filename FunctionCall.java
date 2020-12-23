import java.util.ArrayList;
import java.util.HashMap;

public class FunctionCall extends Expression{
  private Expression[] paramExp;
  //sharedMap has Methodname, functiondef(MethodName, ArrayList of Statements)
  private String currentMethodName;

  //currentMethodName----> functionName(x, y, z)

  /**
   * Constructor that separates the method name and it's parameters
   * The separated parameters are evaluted into numbers
   * @param s String containing the method name and parameters from the function call
   */
  public FunctionCall(String s){ //String s----> a=functionName(a, 45, 89)
    currentMethodName=s.substring(s.indexOf("to")+2, s.indexOf("("));
    s=s.substring(s.indexOf("to")+2);
      String[] temp=s.substring(s.indexOf("(")+1,s.indexOf(")")).split(","); //parameter values from assignment statement
      System.out.println("temp first val "+temp[0]);
      paramExp= new Expression[temp.length];
      for (int i=0; i<temp.length;i++){
        try {
          this.paramExp[i]=new Const(temp[i]);
        }
        catch (Exception e){
          this.paramExp[i]=new Variable(temp[i]);
        }
      }
  }


  /**
   * Retrieves information on the method block, parameters, and return line
   * using the method name used in the method call
   *
   * Uses a HashMap duplicating namespace to keep variables inside the method
   * separate from variables outside of the method
   * 
   * @param  namespace HashMap of variable names of String, matched to it's long value
   * @return long      Returns the evaluated long/variable in the method definition's return line
   */
  @Override
  public long eval(HashMap<String,Long> namespace){
    //Make new namespace here
    FunctionDef function= FunctionDef.getFunction(currentMethodName);
    String[] paramString= function.getStringArr();
    ArrayList<Statement> currentMethodBlock = function.getMethodStatements();
    Expression returning= function.getReturnVal();


    HashMap<String,Long> newNameSpace=new HashMap<String,Long>();
    for (int i=0; i<paramString.length;i++){
      newNameSpace.put(paramString[i], paramExp[i].eval(namespace));
    }

    for(int i=0; i<currentMethodBlock.size();i++) {
      currentMethodBlock.get(i).execute(newNameSpace);
    }

    return returning.eval(newNameSpace);

  }
}
