import java.util.ArrayList;
import java.util.HashMap;

public class FunctionDef extends Statement{
  private String methodHeader;
  private String[] parameters;
  private ArrayList<Statement> methodBlock = new ArrayList<Statement>();
  private static HashMap<String,FunctionDef> sharedMap= new HashMap<String,FunctionDef>(); //method name, method block
  private Expression returning;

  /**
   * Constructor that separates information in a method definition
   * @param methodName  Name of a method including it's parameters
   * @param methodLines block of code in method definition, without the return line
   * @param r           return line in the method block
   */
  public FunctionDef(String methodName, ArrayList<Statement> methodLines, String r){

    methodName=methodName.replaceAll(" ","");
    this.methodHeader=methodName.substring(methodName.indexOf("methodcalled")+12,methodName.indexOf("withparameter"));//methodName (p1, p2, p3...)
    this.methodBlock=methodLines;
    String methodParams=methodName.substring(methodName.indexOf("(")+1, methodName.indexOf(")"));
    if (!methodParams.equals("")){
      this.parameters=methodParams.split(",");
    }
    else{
      this.parameters=new String[0];
    }

    try {
      returning = new Const(r.substring(r.indexOf("return")+6).replaceAll(" ",""));
    }
    catch(Exception e){
      returning = new Variable(r.substring(r.indexOf("return")+6).replaceAll(" ",""));
    }

  }

  public String[] getStringArr(){
    return this.parameters;
  }

  public static FunctionDef getFunction(String s){
    return sharedMap.get(s);
  }

  public ArrayList<Statement> getMethodStatements(){
    return this.methodBlock;
  }

  public Expression getReturnVal(){
    return this.returning;
  }

  /**
   * Puts the method name from the method definition, paired to it's FunctionDef instance
   * The FunctionDef instance contains a method name, method block, and return line
   * @param namespace HashMap of variable names of String, matched to it's long value
   */
  public void execute(HashMap<String,Long> namespace){
    sharedMap.put(methodHeader,this);
  }

}
