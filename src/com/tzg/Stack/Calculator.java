package com.tzg.Stack;

public class Calculator {
    public static void main(String[] args) {
        String expression = "20+2*6-9";
        ArrayStackCalc numStack = new ArrayStackCalc(10);
        ArrayStackCalc operStack = new ArrayStackCalc(10);
        int index = 0;
        int num1 = 0;
        int num2 =0;
        int res =0;
        char ch =' ';
        int oper =0;
        String keepNum = "";
        while (true){
            ch = expression.substring(index,index+1).charAt(0);
            if (operStack.isOper(ch)){
                //符号
                if (operStack.isEmpty()){
                    operStack.push(ch);
                }else{
                    if (operStack.priority(ch)<=operStack.priority(operStack.peek())){
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = operStack.pop();
                        res = numStack.calc(num1,num2,oper);
                        numStack.push(res);
                        operStack.push(ch);
                    }else {
                        operStack.push(ch);
                    }

                }
            }else {
                //数字
//                numStack.push(ch-48);
                keepNum+=ch;
                if (index == expression.length()-1){
                    numStack.push(Integer.parseInt(keepNum));
                }else{
                    if (operStack.isOper(expression.substring(index+1,index+2).charAt(0))){
                        numStack.push(Integer.parseInt(keepNum));
                        keepNum = "";
                    }
                }


            }
            index++;
            if (index>=expression.length()){
                break;
            }

        }

        while(true){
            if (operStack.isEmpty()){
                break;
            }
            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = operStack.pop();
            res = numStack.calc(num1,num2,oper);
            numStack.push(res);
        }
        int finalRes = numStack.pop();
        System.out.printf("表达式%s = %d",expression,finalRes);
    }
}

class ArrayStackCalc {
    private int maxSize;
    private int[] stack;
    private int top = -1;

    public ArrayStackCalc(int maxNum){
        this.maxSize = maxNum;
        stack = new int[maxSize];
    }

    public boolean isFull(){
        return top == maxSize-1;
    }

    public boolean isEmpty(){
        return top ==-1;
    }

    public void push(int newOne){
        if (isFull()){
            System.out.println("栈已经满了！");
            return;
        }
        top++;
        stack[top] = newOne;
    }

    public int pop() {
        if (isEmpty()){
            throw new RuntimeException("栈已经空了！");
        }
        int value = stack[top];
        top--;
        return value;
    }

    public void lishStack(){
        if (isEmpty()){
            System.out.println("栈已经空了！");
            return;
        }
        //从栈顶开始
        for (int i = top; i >= 0 ; i--) {
            System.out.printf("stack[%d]=%d\n",i,stack[i]);
        }
    }

    public int priority(int oper){
        if (oper=='*'||oper=='/'){
            return 1;
        }else if (oper=='+'||oper=='-'){
            return 0;
        }else {
            return -1;
        }
    }

    public boolean isOper(char val){
        return val == '+'|| val == '*'||val == '/'||val == '-';
    }

    public int calc(int num1,int num2, int oper){
        int res = 0;
        switch (oper){
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num2 - num1;
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num2 / num2;
                break;
            default:
                break;
        }
        return res;
    }

    //查看当前栈顶
    public int peek(){
        return stack[top];
    }
}
