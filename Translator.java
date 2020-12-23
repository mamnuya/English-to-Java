import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Iterator;
import java.util.HashMap;
/**
 * This class implements an interpreter for English instructions,
 * with specific writing requirements.
 * @author Mamnuya Rinki
 */

public class Translator{

  /**
   * Usage:
   * java Translator filename.txt
   * will run the interpreter on the code contained in filename.txt
   *
   */
   public static void main(String[] args) throws FileNotFoundException {
     Scanner inp = new Scanner(new File(args[0]));

     ArrayList<String> rawCode = new ArrayList<String>();

     while(inp.hasNext()) {
       rawCode.add(inp.nextLine());
     }
     ArrayList<Statement> mainStatements = parse(rawCode, 0,rawCode.size());
     HashMap<String,Long> namespace = new HashMap<String,Long>();
     for(Statement s : mainStatements) {
       s.execute(namespace);
     }
   }


   /**
    * A function that parses an arrayList of rawCodeStatements and turns it
    * into CodeElement objects.
    *
    * @param rawCode the list of all code statements
    * @param start the first index to parse into code
    * @param end one more than the last index to parse into code
    *
    * @return An arraylist of statement objects, one for each main statement
    * at the current level
    */
   public static ArrayList<Statement> parse(ArrayList<String> rawCode, int start, int end) {
     ArrayList<Statement> statements = new ArrayList<Statement>();
     int lineNo = start;
     while(lineNo < end) {
       String s = rawCode.get(lineNo);
       //bonus skips over comments
       if (s.contains("Comment")){
         if (!s.contains("Multiline")){
           s=s.substring(0,s.indexOf("Comment"));
           if (s.equals("")){
             lineNo++;
           }
           else{
             rawCode.set(lineNo,s);
             parse(rawCode, lineNo, lineNo+1);
           }
         }
         else{ //s contains Multiline
           int count=0;
           for (int i=lineNo+1; i<rawCode.size();i++){
             if (calculateIndentLevel(rawCode.get(i))>calculateIndentLevel(s)){
               count++;
             }
             else{
               break;
             }
           }
           lineNo=lineNo+1+count;
         }

       }
       //Checks for types of statements by line
       else if(s.contains("Print")){
         statements.add(new PrintStatement(s.trim()));
         lineNo++;
       }
       else if (s.contains("Set") && !s.contains("if") && !s.contains("while")){
         statements.add(new AssignmentStatement(s.trim().replaceAll(" ","")));
         lineNo++;
       }
       else if (s.contains("if")){ //s is the line with if-condition
         int count=0;
         for (int i=lineNo+1; i<rawCode.size();i++){
           if (calculateIndentLevel(rawCode.get(i))>calculateIndentLevel(s)){
             count++;
           }
           else{
             break;
           }
         }
         statements.add(new IfStatement(s, parse(rawCode, lineNo+1, lineNo+1+count)));
         lineNo=lineNo+1+count;
       }
       else if (s.contains("while")){
         int count=0;
         for (int i=lineNo+1; i<rawCode.size();i++){
           if (calculateIndentLevel(rawCode.get(i))>calculateIndentLevel(s)){
             count++;
           }
           else{
             break;
           }
         }
         statements.add(new WhileStatement(s, parse(rawCode, lineNo+1, lineNo+count+1)));
         lineNo=lineNo+1+count;
       }
       else if (s.contains("for")){
         int count=0;
         for (int i=lineNo+1; i<rawCode.size();i++){
           if (calculateIndentLevel(rawCode.get(i))>calculateIndentLevel(s)){
             count++;
           }
           else{
             break;
           }
         }
         statements.add(new ForLoop(s, parse(rawCode, lineNo+1, lineNo+count+1)));
         lineNo=lineNo+1+count;
       }
       else if (s.contains("method")){
         //method definition
         // def functionName(param1, param2, param3 ...)
         int count=0;
         for (int i=lineNo+1; i<rawCode.size();i++){
           if (calculateIndentLevel(rawCode.get(i))>calculateIndentLevel(s)){
             count++;
           }
           else{
             break;
           }
         }
         statements.add(new FunctionDef(s, parse(rawCode, lineNo+1, lineNo+count), rawCode.get(lineNo+count)));// rawCode.get(lineNo+count+1)); //  statements.add(new FunctionDef(s, parse(rawCode, lineNo+1, lineNo+count+1)
         lineNo=lineNo+1+count;
       }
       //bonus skips over empty lines
       else if ( s.replaceAll(" ","").equals("") || !(s.contains(".*[a-z].*"))  && !(s.contains("#")) ){ //s doesnt contain any letters
         lineNo++;
       }

     }
     return statements;
   }

   /**
    * Useful method when dealing with if/while/function statements and multiline comments.
    *
    * Checks the level of indentation of a line of code.
    *
    * @param  line Line to calculate indent level
    * @return int  Number representing the number of indents on the given line
    */
   protected static int calculateIndentLevel(String line) {
     int x = 0;
     while(true) {
       char c = line.charAt(x);
       if(c == ' ' || c == '\t') {
         x++;
       } else {
         return x;
       }
     }
   }

}
