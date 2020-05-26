package com.tzg.Stack;


import java.util.Scanner;

public class ArrayStackDemo {
    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(4);
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        String key = "";
        while(flag){
            System.out.println("show 表示显示栈");
            System.out.println("push 入栈");
            System.out.println("pop 出栈");
            System.out.println("exit 退出程序");
            System.out.println("请输入你的选择：");
            key = scanner.next();
            switch (key){
                case "show":
                    stack.lishStack();
                    break;
                case "push":
                    System.out.println("请输入一个数据");
                    int value = scanner.nextInt();
                    stack.push(value);
                    break;
                case "pop":
                    int res = stack.pop();
                    System.out.println(res);
                    break;
                case "exit":
                    scanner.close();
                    flag = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序已经结束");
    }
}

class ArrayStack {
    private int maxSize;
    private int[] stack;
    private int top = -1;

    public ArrayStack(int maxNum){
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

}