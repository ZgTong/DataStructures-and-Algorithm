package com.tzg.Stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InversePolishPxpressionCalc {
    public static void main(String[] args) {
        String infixExpression = "3+((20-4)*3)-2";
        List<String> iel =  toInfixExpressionList(infixExpression);
        System.out.println("�õ�����׺���ʽ����Ϊ:"+iel);
        List<String> sel = parseInfixToSuffixList(iel);
        System.out.println("�õ��ĺ�׺���ʽ����Ϊ:"+sel);
        int resultCalc = calc(sel);
        System.out.println("�õ��ļ�����Ϊ:"+resultCalc);
    }

    //
    /**
     * �÷�����һ����׺���ʽתΪ��׺���ʽ�����飬����3+((20-4)*3)-2 = 49 �� [3,+,(,(,20,-,4,),*,3,),-,2]
     * @param infixExpression �����ַ�����ʽ����׺���ʽ
     * @return ��׺���ʽ����
     */
    public static List<String> toInfixExpressionList(String infixExpression){
        //��ʼ��
        List<String> iel= new ArrayList<String>();
        //���ڱ������ʽ��ָ�룻
        int index = 0;
        //����ƴ�Ӷ�λ���֣�
        String str;
        //�������ĵ�ǰ�ַ������뵽c
        char c;
        do {
            if ((c = infixExpression.charAt(index))<48||(c = infixExpression.charAt(index))>57){
                //������
                iel.add(c+"");
                index++;
            }else {
                //��ʼ��
                str = "";
                //����,���Ƕ�λ��
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
     * �÷�����һ����׺���ʽ����תΪ��׺���ʽ�����飬����[3,+,(,(,20,-,4,),*,3,),-,2] �� [3, 20, 4, -, 3, *, +, 2, -]
     * @param iel ��׺���ʽ����
     * @return ��׺���ʽ������
     */
    public static List<String> parseInfixToSuffixList(List<String> iel){
        Stack<String> s1 = new Stack<String>();
        List<String> s2 = new ArrayList<String>();
        for (String item : iel) {
            if (item.matches("\\d+")){
                //���� ��ջ�������Ѿ����Ƕ�λ��
                s2.add(item);
            }else if (item.equals("(")){
                //������ֱ����ջ
                s1.push(item);
            }else if (item.equals(")")){
                //�����ε���s1ջ�������������ѹ��s2��ֱ������������Ϊֹ����ʱ����һ�����Ŷ���
                while (!s1.peek().equals("(")){
                    s2.add(s1.pop());
                }
                s1.pop();
            }else {
                //�����,����Ҫ��֤s1ջ�ǿգ�Ȼ��Ƚ����ȼ�
                //1.���s1Ϊ�ջ���ջ��Ϊ"("��ֱ�ӽ����������ջ
                //2.����ǰ�����������ȼ�����ջ����������ͬ��ѹ��
                //3.����ǰ�����������ȼ����ڻ��ߵ���ջ����������s1�������Ҽ���s2,Ȼ������ظ��Ƚϣ��������ô˴���whileѭ���������������д�����ȼ�classʵ��1.2��
                while (s1.size()>0 && OperationPrio.getPrioValue(item)<=OperationPrio.getPrioValue(s1.peek())){
                    s2.add(s1.pop());
                }
                s1.push(item);
            }
        }
        //��s1��ʣ�����������ε���������s2
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
                    throw new RuntimeException("���������");
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
                System.out.printf("�����ڸ������");
                break;
        }

        return res;
    }

}