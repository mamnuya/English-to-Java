# English-to-Java

Program that translates code instructions written in U.S. English into java code to run. The written instructions follow particular syntax and rules.

See examples of wirrten English instructions in files with .txt extension. 


Rules for written English instructions (Case Sensitive) :

PRINTING
- Printing an empty line
  *Type "Print" (ie. Print)
- Printing a string
  *Type "Print -"exampleString"-" and the string within double quotes. (ie. Print "example string.")
- Printing a long
  *Type "Print -exampleLongValue-" (ie. Print 101)
  
ASSIGNING VARIABLES
- Setting a variable to a long
  *Type "Set -exampleVariableName to -exampleLongValue-" (ie. Set exampleVariableName to 800)
- Setting a variable to another variable's value
  *Type "Set -exampleVariableName to -existingVariableName-" (ie. Set exampleVariableName to otherVariableName)
- Setting a variable to a method call (See DEFINING METHODS below)
  *Type "Set -exampleVariableName to methodName(exampleAnyNeededParameters)". (ie. Set exampleVariableName to methodName() OR  Set exampleVariableName to methodName(80) )
- Setting a variable to an arithmetic expression
  *Type "Set -exampleVariableName- to -exampleLeftValue- -exampleOperator- -exampleRightValue". The values in the expression may be either variables or longs, and only 2 values are acceptable in the expression. Operators supported include: +, -, /, *, and %. (ie. Set exampleVariableName to variableName + 800)
- Setting a variable to a user input
  *Type "Set -exampleVariableName- to input" When running the code, enter a long when asked to type a value for the variable assignment.
  
MAKING COMMENTS
- Making single line comments with no code instructions to interpret prior to the comment
 *Type "Comment" and the desired comment, which may also be left blank (ie. Comment OR Comment exampleCommentLine)
- Making single line comments with code instructions to interpret prior to the comment
 *Type a line of code instructions to interpret. Followed this with "Comment" and the desired comment, which may be left blank. (ie. Print "hi" Comment exampleCommentLine)
- Making multiline comments
 *Type "Multiline Comment" and indent any lines following this line to in the multiline comment. (ie. Multiline Comment indentedCommentOnNextLine).
 
The following sections support nested-blocks.

DEFINING METHODS
- Making a method header
  *Type "Define a method called -exampleMethodName- with parameter (-exampleParameter-)" and enclose parameters in parentheses. (ie. Define a method called exampleMethod with parameter (a) OR with parameter () OR with parameter (a,b,c) )
- Making a method block
  *Indent any code instructions in the lines following the method header. The block may include other indented/nested instructions.
- Making a return statement
  *On the last line of the indented method block, type "return " followed by a single variable or a single long.
--- Method calls are only allowed in assignment instructions.

FOR-LOOPS
- Making a for-loop condition (start, stop, step)
  *Type "Create for-loop with variable " and the name of a new variable. Following this, type "starting from -exampleStartValue-, stopping at -exampleStopValue-, with step of -exampleStepValue-, and the following for-block:
- Making a for-loop block
  *Indent any code instructions in the lines following the for-loop condition. The block may include other indented/nested instructions.

WHILE-LOOPS
- Making a while-loop header 
  *Type "Create a while-loop with condition -insertCondition- and the following while-block:"
- Making a condition for a while-loop header
  *Type "(" followed by a long/existing variable name. Then, type a boolean operator: < , > , <= , >= , == , !=, with a space before and after the operator. Next, type a long/existing variable name and a ")" (ie. ( existingVariableName >= 500 )
- Making a while-block
  *Indent any code instructions in the lines following the while-loop condition. The block may include other indented/nested instructions.


IF-STATEMENTS
- Making an if-statement condition
  *Type "Create an if-statement with condition -insertCondition- and the following if-block:"
- Making a condition for a while-loop header
  *Type "(" followed by a long/existing variable name. Then, type a boolean operator: < , > , <= , >= , == , !=, with a space before and after the operator. Next, type a long/existing variable name and a ")" (ie. ( existingVariableName >= 500 )
- Making an if-block
  *Indent any code instructions in the lines following the if-statement condition. The block may include other indented/nested instructions.

 
 
 
 
  
  
  
 
  
 


