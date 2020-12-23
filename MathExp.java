import java.util.HashMap;

/**
 * This abstract class evaluates arithmetic expression to an integer.
 */
 public class MathExp extends Expression {
   private String operatorOptions="+-*/%";
   private String operator=null;
   private Expression leftExp;
   private Expression rightExp;
   private long data;

   /**
    * Constructor separating the operator, left value, and right value, of an arithmetic expression
    * @param s Line containing the arithmetic expression
    */
   public MathExp(String s){
     for (int i=0; i<operatorOptions.length();i++){
       if (s.contains(operatorOptions.substring(i,i+1))){
         operator=operatorOptions.substring(i,i+1); //Finds which operator is in line of code;
       }
     }
     try {
       leftExp = new Const(s.substring(s.indexOf("to")+2,s.indexOf(operator)));
     }
     catch(NumberFormatException e){
       leftExp=new Variable(s.substring(s.indexOf("to")+2,s.indexOf(operator)));
     }
     try {
       rightExp = new Const(s.substring(s.indexOf(operator)+1,s.length()));
     }
     catch (NumberFormatException e){
       rightExp=new Variable(s.substring(s.indexOf(operator)+1,s.length()));
     }

   }

   /**
    * Method that performs the operation with the 2 variables/longs
    * @param  namespace HashMap of variable names of String, matched to it's long value
    * @return long      evaluated arithmetic expression
    */
   @Override
   public long eval(HashMap<String,Long> namespace){
     if (operator.equals("+")){
       data= leftExp.eval(namespace)+rightExp.eval(namespace);
     }
     if (operator.equals("-")){
       data= leftExp.eval(namespace)-rightExp.eval(namespace);
     }
     if (operator.equals("*")){
       data= leftExp.eval(namespace)*rightExp.eval(namespace);
     }
     if (operator.equals("/")){
       data= leftExp.eval(namespace)/rightExp.eval(namespace);
     }
     if (operator.equals("%")){
       data= leftExp.eval(namespace)%rightExp.eval(namespace);
     }
     return data;
   }
 }
