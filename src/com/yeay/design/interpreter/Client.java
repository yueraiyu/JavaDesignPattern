package com.yeay.design.interpreter;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

abstract class Expression{
    public Expression(){}

    public abstract int interpreter(Map<Character, Integer> var);
}

//变量表达式
class VarExpression extends Expression{
    private char key;

    public VarExpression(char key){
        this.key = key;
    }

    @Override
    public int interpreter(Map<Character, Integer> var){
        return var.get(key);
    }
}

//符号表达式
abstract class SymbolExpression extends Expression{
    protected Expression left;
    protected Expression right;

    public SymbolExpression(Expression left, Expression right){
        this.left = left;
        this.right = right;
    }
}

//加法运算
class AddExpression extends SymbolExpression{
    public AddExpression(Expression left, Expression right){
        super(left, right);
    }

    @Override
    public int interpreter(Map<Character, Integer> var){
        return left.interpreter(var) + right.interpreter(var);
    }
}

//减法运算
class SubExpression extends SymbolExpression{
    public SubExpression(Expression left, Expression right){
        super(left, right);
    }

    @Override
    public int interpreter(Map<Character, Integer> var){
        return left.interpreter(var) - right.interpreter(var);
    }
}

class ExpressionAnalyse{
    public static Expression analyse(String expStr){
        Stack<Expression> expStack = new Stack();

        Expression left = null;
        Expression right = null;

        for(int i = 0; i < expStr.length(); i ++){
            char[] exps = expStr.toCharArray();
            switch(exps[i]){
                case '+' :
                    left = expStack.peek();
                    right = new VarExpression(exps[++i]);
                    expStack.push(new AddExpression(left, right));
                    break;
                case '-' :
                    left = expStack.peek();
                    right = new VarExpression(exps[++i]);
                    expStack.push(new SubExpression(left, right));
                    break;
                default:
                    expStack.push(new VarExpression(exps[i]));
            }
        }

        Expression expression = expStack.peek();
        return expression;
    }
}

public class Client{
    public static void main(String[] args){
        String expStr = "a+b-c+d";
        Map<Character, Integer> var = new HashMap();
        var.put('a', 5);
        var.put('b', 2);
        var.put('c', 1);
        var.put('d', 8);

        Expression expression = ExpressionAnalyse.analyse(expStr);
        int result = expression.interpreter(var);
        System.out.println(result);
    }
}
