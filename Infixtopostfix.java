package dsa;

class Stack
{
private int maxSize;
private char[ ] S;
private int top;  // points the current top of the stack
public Stack()
	{
	maxSize = 10;
	S = new char[maxSize]; 
	top = -1;
	}
	public void push(char j)
	{
	if(isFull())
	{
	  System.out.println("Stack is full");
	}
	else
	S[++top] = j;
	}
	public char pop()
	{
	if(isEmpty())
	{
	System.out.println("Stack is Empty"); 
	return '0';
	}
	else
	return S[top--]; 
	}

	public char topelement()
	{
		if (!isEmpty())
		return S[top];
		else return '0';
	}
	public boolean isEmpty()
	{
	return (top == -1);
	}
	public boolean isFull()
	{
	return (top == maxSize-1);
	}
} 

public class Infixtopostfix
{

  // A utility function to check if the given character is operand
  static boolean isAlpha(char ch)
	{
	    if((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') )
	    return true;
	    else 
		return false;
	}
 // A utility function to return precedence of a given operator
// Higher returned value means higher precedence
static int Prec(char ch)
{
    switch (ch)
    {
     case '(':
     case '#':
	    return 0;
    case '+':
    case '-':
        return 1;
 
    case '*':
    case '/':
        return 2;
 
    case '^':
        return 3;
    }
	return ch;
   
}
 // The main function that converts given infix expression
// to postfix expression. 
static void infixToPostfix(String infix)
{
    int  i, k=0;
     // Create a stack of capacity 
    Stack St= new Stack();    
    St.push('#');
    System.out.println(infix.length());
     for (i = 0;i<infix.length();i++)
    {
	  char infi=infix.charAt(i);
	  System.out.println("infi"+infi);
	// If the scanned character is an operand, add it to          output.
        if (isAlpha(infi))
             System.out.print(infi);
         
        // If the scanned character is an ‘(‘, push it to the stack.
        else if (infi == '(')
            St.push(infi);
         
        // If the scanned character is an ‘)’, pop and output from the stack  until an ‘(‘ is encountered.
        else if (infi==')')
        {
            while (St.topelement() != '(')
                System.out.print(St.pop());
                              
               char m= St.pop();
        }
else if (infi=='#')
        {
            while (St.topelement() != '#')
                System.out.print(St.pop());
        }

        else // an operator is encountered
        {     while ( (Prec(infi) <= Prec(St.topelement())))
                {
System.out.print(St.pop());
                }
            St.push(infi);
        }
 
    }
}
 
// Driver program to test above functions
public static void  main(String args[])
{
    String  exp = "a+b*(c+d)#";
    infixToPostfix(exp);
   // return 0;
     }
}
