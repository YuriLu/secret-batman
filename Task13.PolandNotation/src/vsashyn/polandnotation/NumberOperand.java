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
public class NumberOperand implements Component{
    Expression expression;
    Integer number;
    
    
    public NumberOperand(Expression expression){
        this.expression = expression;
    }
    
    /**
     * Count value according to component type.
     * @return this.number
     */
    @Override
    public Integer count() {
        return number;
    }
    
    /**
     * Create number object from parsing last token of string 
     * in Poland notation.
     */
    @Override
    public void assign() {
        String str = expression.getLastToken();
        number = Integer.parseInt(str);
    }
    
}
