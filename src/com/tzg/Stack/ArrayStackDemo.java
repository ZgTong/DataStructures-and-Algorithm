package com.tzg.Stack;


import java.util.Scanner;

public class ArrayStackDemo {
    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(4);
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        String key = "";
        while(flag){
            System.out.println("show ��ʾ��ʾջ");
            System.out.println("push ��ջ");
            System.out.println("pop ��ջ");
            System.out.println("exit �˳�����");
            System.out.println("���������ѡ��");
            key = scanner.next();
            switch (key){
                case "show":
                    stack.lishStack();
                    break;
                case "push":
                    System.out.println("������һ������");
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
        System.out.println("�����Ѿ�����");
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
            System.out.println("ջ�Ѿ����ˣ�");
            return;
        }
        top++;
        stack[top] = newOne;
    }

    public int pop() {
        if (isEmpty()){
            throw new RuntimeException("ջ�Ѿ����ˣ�");
        }
        int value = stack[top];
        top--;
        return value;
    }

    public void lishStack(){
        if (isEmpty()){
            System.out.println("ջ�Ѿ����ˣ�");
            return;
        }
        //��ջ����ʼ
        for (int i = top; i >= 0 ; i--) {
            System.out.printf("stack[%d]=%d\n",i,stack[i]);
        }
    }

}