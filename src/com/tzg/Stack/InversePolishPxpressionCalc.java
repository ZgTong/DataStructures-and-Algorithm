package com.tzg.Stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InversePolishPxpressionCalc {
    public static void main(String[] args) {
        String infixExpression = "3+((20-4)*3)-2";
        List<String> iel =  toInfixExpressionList(infixExpression);
        System.out.println("得到的中缀表达式数组为:"+iel);
        List<String> sel = parseInfixToSuffixList(iel);
        System.out.println("得到的后缀表达式数组为:"+sel);
        int resultCalc = calc(sel);
        System.out.println("得到的计算结果为:"+resultCalc);
    }

    //
    /**
     * 该方法将一个中缀表达式转为中缀表达式的数组，例：3+((20-4)*3)-2 = 49 → [3,+,(,(,20,-,4,),*,3,),-,2]
     * @param infixExpression 传入字符串形式的中缀表达式
     * @return 中缀表达式数组
     */
    public static List<String> toInfixExpressionList(String infixExpression){
        //初始化
        List<String> iel= new ArrayList<String>();
        //用于遍历表达式的指针；
        int index = 0;
        //用于拼接多位数字；
        String str;
        //遍历到的当前字符，放入到c
        char c;
        do {
            if ((c = infixExpression.charAt(index))<48||(c = infixExpression.charAt(index))>57){
                //非数字
                iel.add(c+"");
                index++;
            }else {
                //初始化
                str = "";
                //数字,考虑多位数
                while (index<infixExpression.length()&&(c = infixExpression.charAt(index))>=48&&(c = infixExpression.charAt(index))<=57) {
                    str+=c;
                    index++;
                }
                iel.add(str);
            }
        }while (index<infixExpression.length());

        return iel;
    }

    /**
     * 该方法将一个中缀表达式数组转为后缀表达式的数组，例：[3,+,(,(,20,-,4,),*,3,),-,2] → [3, 20, 4, -, 3, *, +, 2, -]
     * @param iel 中缀表达式数组
     * @return 后缀表达式的数组
     */
    public static List<String> parseInfixToSuffixList(List<String> iel){
        Stack<String> s1 = new Stack<String>();
        List<String> s2 = new ArrayList<String>();
        for (String item : iel) {
            if (item.matches("\\d+")){
                //数字 入栈，正则已经考虑多位数
                s2.add(item);
            }else if (item.equals("(")){
                //左括号直接入栈
                s1.push(item);
            }else if (item.equals(")")){
                //则依次弹出s1栈顶的运算符，并压入s2，直到遇到左括号为止，此时将这一对括号丢弃
                while (!s1.peek().equals("(")){
                    s2.add(s1.pop());
                }
                s1.pop();
            }else {
                //运算符,首先要保证s1栈非空，然后比较优先级
                //1.如果s1为空或者栈顶为"("，直接将此运算符入栈
                //2.若当前操作符的优先级高于栈顶操作符，同样压入
                //3.若当前操作符的优先级低于或者等于栈顶操作符，s1弹出并且加入s2,然后继续重复比较！！（利用此处做while循环条件，并搭配编写的优先级class实现1.2）
                while (s1.size()>0 && OperationPrio.getPrioValue(item)<=OperationPrio.getPrioValue(s1.peek())){
                    s2.add(s1.pop());
                }
                s1.push(item);
            }
        }
        //将s1中剩余的运算符依次弹出并加入s2
        while (s1.size()!=0){
            s2.add(s1.pop());
        }
        return s2;

    }

    public static int calc(List<String> sl){
        Stack<String> stack = new Stack<>();
        for (String item: sl) {
            if (item.matches("\\d+")) {
                stack.push(item);
            }else {
                int num1 = Integer.parseInt(stack.pop());
                int num2 = Integer.parseInt(stack.pop());
                int res = 0;
                if (item.equals("+")){
                    res = num1+num2;
                } else if (item.equals("-")){
                    res = num2-num1;
                } else if (item.equals("*")){
                    res = num1*num2;
                } else if (item.equals("/")){
                    res = num2/num1;
                } else {
                    throw new RuntimeException("运算符有误");
                }
                stack.push(res+"");
            }
        }
        int result = Integer.parseInt(stack.pop());
        return result;
    }
}

class OperationPrio{

    private  static int PLUS =1;
    private  static int MINUS =1;
    private  static int MULTI =2;
    private  static int DIV =2;

    public static int getPrioValue(String operation){
        int res = 0;
        switch (operation){
            case "+":
                res = PLUS;
                break;
            case "-":
                res = MINUS;
                break;
            case "*":
                res = MULTI;
                break;
            case "/":
                res = DIV;
                break;
            default:
                System.out.printf("不存在该运算符");
                break;
        }

        return res;
    }

}