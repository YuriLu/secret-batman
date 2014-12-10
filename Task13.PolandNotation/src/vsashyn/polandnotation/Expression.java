/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vsashyn.polandnotation;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import vsashyn.polandnotation.ArithmeticOperator.Operators;

/**
 *
 * @author vsa
 */
public class Expression {
    
    Component first;
    String expressionString;
    Deque<String> stackPolNot;
    
    Expression(){
        stackPolNot = new ArrayDeque<>();
    }
    
    Expression(String str){
        this.expressionString = str;
        stackPolNot = new ArrayDeque<>();

    }
    
    /**
     * Create Poland notation, using raw string represent of expression.
     */
    public void createPolNot(){
        //Create operator stack to help parse string to Poland notation
        Deque<String> stack = new ArrayDeque<>();
        //Create massive tokens with splitted delimiters
        String[] tokens 
                = expressionString.split(ArithmeticOperator.WITH_DELIMITERS);
        for(String tok:tokens){
            System.out.print(tok + ", ");
        }
                      
        for(int i=0;i<tokens.length;i++){                   /* Loop over tokens  */
            
            if(!ArithmeticOperator.isSign(tokens[i])){      /* If number - push to out stack */
                //System.out.println("no sign");
                stackPolNot.push(tokens[i]);
                continue;
            }
            
            if(ArithmeticOperator.getOperator(tokens[i])    /* If left parenthesis - push to out stack*/
                    ==Operators.L_PARENTHESIS){
                System.out.println("l_parenthesis");
                stack.push(tokens[i]);
                continue;
            }
            
            if(ArithmeticOperator.getOperator(tokens[i])         /* IF right parenthesis - push all signs to out stack*/
                    ==Operators.R_PARENTHESIS){                  /* , while sign != left parenthesis */
                while(ArithmeticOperator.getOperator(stack.element())
                        !=Operators.L_PARENTHESIS){
                    stackPolNot.push(stack.poll());
                }
                //Remove L_PARENTHESIS from stack
                stack.poll();
                continue;
            }
            
            while((!stack.isEmpty())                            /* Check, while the item from String tokens has */
                    &&                                          /* low or equel priority  of first element from stack, */
                    (ArithmeticOperator                         /* push  them to out stack*/
                    .getOperator(stack.peek())
                    .getPriority() <= ArithmeticOperator
                            .getOperator(tokens[i])
                            .getPriority())){
                stackPolNot.push(stack.poll());
            }
            stack.push(tokens[i]);
            
        }
        while (!stack.isEmpty()) {
            stackPolNot.push(stack.poll());
        }
        System.out.println("Stack PolNot");
            for(String str:stackPolNot){
                System.out.println(str);
            }
    }
    
    /**
     * Run assign method for first component. 
     * This method will running on all components recursively.
     */
    public void createTree(){
       // Component first 
        String str = readLastToken();
        if(ArithmeticOperator.isSign(str)){
                first = new ArithmeticOperator(this);
                first.assign();
        } else {
            System.err.println("Last item not a sign!");
        }
    }       
    
    /**
     * Get the last token from Poland notation stack. 
     * @return 
     */
    public String getLastToken(){
        String str = null;
        if(stackPolNot.isEmpty()){
            System.err.println("Stack Is empty!");
        } else {      
        return  stackPolNot.pop();
        }
        return str;
    }
    
    /**
     * Read the last token from Poland notation stack.
     * @return 
     */
    public String readLastToken(){
        String str = null;
        if (stackPolNot.isEmpty()){
            System.err.println("Stack is empty while reading last token!");
        } else {
            return stackPolNot.peek();
        }
        return str;
    }
    
    /**
     * Count expression recursively, invoke .count() from ArithmeticOperators
     * and NumberOperands.
     * @return 
     */
    public Integer countExpression(){
        return first.count();
    }
}
