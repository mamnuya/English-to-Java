import java.util.ArrayList;
import java.util.HashMap;

public class ForLoop extends Statement{
  private ArrayList<Statement> forBlock = new ArrayList<Statement>();
  private Long start;
  private Long stop;
  private Long step;
  private Long i;
  private String var;


  /**
   * Constructor that assigns the stop, start, step value of a new variable
   * for the for-loops condition
   * @param forLine Line containing the for-loop's start, stop, step condition
   * @param fBlock  Block of code to be run in the for-loop
   */
  public ForLoop(String forLine, ArrayList<Statement> fBlock){
    this.forBlock=fBlock;
    forLine=forLine.replaceAll(" ","");
    start = Long.parseLong(forLine.substring(forLine.indexOf("startingfrom")+12,forLine.indexOf(",stopping")));
    stop = Long.parseLong(forLine.substring(forLine.indexOf("stoppingat")+10,forLine.indexOf(",with")));
    step = Long.parseLong(forLine.substring(forLine.indexOf("withstepof")+10,forLine.indexOf(",and")));


    var= forLine.substring(forLine.indexOf("variable")+8, forLine.indexOf("starting"));
  }

  /**
   * Increments the start by step each time the for-loop block is executed, until the stop condition
   * @param namespace HashMap of variable names of String, matched to it's long value
   */
  public void execute(HashMap<String,Long> namespace){
    i = start;
    while (i<stop){
      namespace.put(var,i);
      for(Statement s: forBlock) {
        s.execute(namespace);
      }
      i+=step;
    }

  }


}
