import java.util.HashMap;

/**
 * A class to contain the information needed for a print statement.
 *
 */
public class PrintStatement extends Statement{

  private Expression data;
  private String temp;

  /**
   * Checks the type of print statement, and assigns information to either temp or data
   * (Print a string, Print an empty line, Print a variable, Print a long)
   * @param s Line containing the Print statement
   */
  public PrintStatement(String s) {
    char quote='"';
    if (s.substring(s.indexOf("Print")+5,s.length()).equals("")){
      this.data=null;
      temp="";
    }
    else if (s.charAt(s.length()-1)==quote){
      this.data=null;
      temp=s.substring(s.indexOf("Print")+6,s.length());
    }
    else{
      s=s.replaceAll(" ","");
      try{
        this.data = new Const(s.substring(s.indexOf("Print")+5,s.length()));
      }
      catch (NumberFormatException e){ //= new Var
        this.data = new Variable(s.substring(s.indexOf("Print")+5,s.length()));
        //substring holds a variable name
      }
    }
  }

  /**
   * Prints out a string or a long or an empty line
   * @param namespace HashMap of variable names of String, matched to it's long value
   */
  @Override
  public void execute(HashMap<String,Long> namespace) {
    if (data!=null){
      System.out.println(data.eval(namespace));
    }
    else{
      System.out.println(temp);
    }
  }
}
