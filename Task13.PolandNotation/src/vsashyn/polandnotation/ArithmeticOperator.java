/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vsashyn.polandnotation;

/**
 *
 * @author vsa
 */
public class ArithmeticOperator implements Component {
    
    public static final String WITH_DELIMITERS="(?=[-+/*)(])|(?<=[-+/*)(])";
    Operators operator;
    Expression expression;
    Component leftComponent;
    Component rightComponent;

    public enum Operators{
        
        L_PARENTHESIS("(",8),
        R_PARENTHESIS(")",1),
        INVOLUTION("^",2),
        MULTIPLICATION("*",3), 
        DIVISION("/",3),
        ADDITION ("+",4), 
        SUBSTRACTION("-",4); 
        
        final private String sign;
        final private Integer priority;
        
        Operators(String str, Integer priority){
            this.sign = str;
            this.priority = priority;
        }
        
        public String getSign(){
            return sign;
        }
        public Integer getPriority(){
            return priority;
        }
        
        @Override
        public String toString(){
            return sign;
        }
    }   
    
    ArithmeticOperator(Expression expression){
        this.expression = expression;
    }
    
    /**
     * Recursive count value
     * @return 
     */
    @Override
    public Integer count() {
        return  makeArithmeticOperation();
    }
    
    /**
     * Create object. 
     */
    @Override
    public void assign(){
        String str = expression.getLastToken();
        for(Operators o: Operators.values()){
            if(o.getSign().equals(str)){
                operator = o;
                break;
            }
        }
        if(operator==null){
            System.err.println("Wrond record of poland notation"
                    + "(Sign must be last)");
        }
        //Right childs
        str = expression.readLastToken();
        if (isSign(str)){
            rightComponent = new ArithmeticOperator(expression);
            rightComponent.assign();
        } else{
            rightComponent = new NumberOperand(expression);
            rightComponent.assign();
        }
        //Left child
        str = expression.readLastToken();
        if (isSign(str)){
            leftComponent = new ArithmeticOperator(expression);
            leftComponent.assign();
        } else{
            leftComponent = new NumberOperand(expression);
            leftComponent.assign();
        }
        
    }
    
    /**
     * Check, if String is a Sign from Enumeration 
     * @param str
     * @return 
     */
    public static boolean isSign(String str){
            for(Operators o: Operators.values()){
                if(o.getSign().equals(str)){
                    return true;
                }
            }
            return false;
        }
    
    /**
     * If you have String , you can return Operator(enum) of this sign.
     * @param str
     * @return 
     */
    public static Operators getOperator(String str){
        switch(str){
                        case ")":    return Operators.R_PARENTHESIS;
            case "-":    return Operators.SUBSTRACTION;
            case "+":    return Operators.ADDITION;
            case "*":    return Operators.DIVISION;
            case "/":    return Operators.MULTIPLICATION;
            case "(":    return Operators.L_PARENTHESIS;
            case "^":    return Operators.INVOLUTION;
            default:    {
                System.err.println(" In getOperator isn't a sign!");
                break;
            }
        }   
        System.err.println(str + "Ruturn null");
        return null;
        }
    
    
    public Integer makeArithmeticOperation(){
        switch(operator.getSign()){
            case "+": return leftComponent.count() + rightComponent.count();
            case "-": return leftComponent.count() - rightComponent.count();
            case "*": return leftComponent.count() * rightComponent.count();
            case "/": return leftComponent.count() / rightComponent.count();
        }
        return null;
    }
}
