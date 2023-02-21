package com.company.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//使用逆波兰式进行数学表达式计算
public class Calculator {
    public static void main(String[] args) {
        String expression = "181+((21+3)*4)-5";
        System.out.println(toInfixExpressionList(expression).toString());
        List<String> suffixExpression = infixToSuffixExpression(toInfixExpressionList(expression));
        System.out.println(suffixExpression.toString());
        int i = calBySuffixExpression(suffixExpression);
        System.out.println(i + "《《《《==============最终结果");
    }

    /**
     * 把数学表达式字符串转换为  中缀list（方便使用）
     * @param expression
     * @return
     */
    public static List<String> toInfixExpressionList(String expression){
        ArrayList<String> list = new ArrayList<>();
        int i = 0;
        char ch;
        String str = "";
        do{
            if ((ch = expression.charAt(i)) < 48 || (ch = expression.charAt(i)) > 57){
                //如果字符不是一个数字，直接加入
                list.add(ch + "");
                i ++;
            }else {
                //是数字就要考虑   是不是多位数
                str = "";
                while (i < expression.length() && 48 <= (ch = expression.charAt(i))
                        && (ch = expression.charAt(i)) <= 57){
                    i ++;
                    str += ch;
                }
                list.add(str);
            }
        }while (i < expression.length());
        return list;
    }

    /**
     * 中缀表达式 转 后缀表达式
     * @param infixExpression
     * @return
     */
    public static List<String> infixToSuffixExpression(List<String> infixExpression){
        //定义两个栈  符号栈 数字栈
        //数字栈不需要出栈操作   因此使用list代替
        Stack<String> s1 = new Stack<>();
        ArrayList<String> s2 = new ArrayList<>();
        for (String item :
                infixExpression) {
            if (item.matches("\\d+")){  //数字直接入s2
                s2.add(item);
            }else {
                if (item.equals("(")){
                    //左括号直接入栈
                    s1.push(item);
                }else if (item.equals(")")){         //依次从s1出栈到s2   直到s1栈顶为“（”   然后s1出栈
                    while (s1.size() != 0 && !s1.peek().equals("(")){
                        s2.add(s1.pop());
                    }
                    //舍弃s1左括号
                    s1.pop();
                }else {
                    //如果当前操作符的优先级小于等于栈顶操作符优先级   将s1栈顶符号出栈入栈s2
                    // 继续判断
                    while (s1.size() != 0 && Operation.getValue(item) <= Operation.getValue(s1.peek())){
                        s2.add(s1.pop());
                    }
                    s1.push(item);
                }
            }
        }

        //将s1剩余元素全部入栈
        while (s1.size() != 0){
            s2.add(s1.pop());
        }
        return s2;
    }

    /**
     * 根据后缀表达式计算 数学表达式
     * @param suffixExpression
     * @return
     */
    public static int calBySuffixExpression(List<String> suffixExpression){
        Stack<String> stack = new Stack<>();
        for (String item : suffixExpression) {
            if (item.matches("\\d+")){
                stack.push(item);
            }else {
                int num1 = Integer.parseInt(stack.pop());
                int num2 = Integer.parseInt(stack.pop());
                int res = 0;
                if (item.equals("+")){
                    res = num2 + num1;
                }else if (item.equals("-")){
                    res = num2 - num1;
                }else if (item.equals("*")){
                    res = num2 * num1;
                }else if (item.equals("/")){
                    res = num2 / num1;
                }else {
                    throw new RuntimeException("操作符有误，请检查");
                }
                stack.push(res + "");
            }
        }
        return Integer.parseInt(stack.pop());
    }
}

//工具类  判断字符优先级
class Operation{
    private static int ADD = 1;
    private static int SUB = 1;
    private static int MUL = 2;
    private static int DIV = 2;

    /**
     * 返回某个操作符的优先级
     * @param operation
     * @return
     */
    public static int getValue(String operation){
        int res = 0;
        switch (operation){
            case "+":
                res = ADD;
                break;
            case "-":
                res = SUB;
                break;
            case "*":
                res = MUL;
                break;
            case "/":
                res = DIV;
                break;
            default:
                break;
        }
        return res;
    }
}

