package com.tzg.queue;

import java.util.Scanner;

public class ArrayQueueTest {
    public static void main(String[] args) {
        ArrayQueue1 AQ1 =new ArrayQueue1(3);
        Scanner scanner = new Scanner(System.in);
        char key = ' ';
        boolean loop = true;
        while(loop){
            System.out.println("s(show):显示队列");
            System.out.println("e(exit):退出程序");
            System.out.println("a(add):添加数据");
            System.out.println("g(get):取出数据");
            System.out.println("h(head):查看队列头");
            key = scanner.next().charAt(0);
            switch (key){
                case 's':
                    AQ1.showQueue();
                    break;
                case 'a':
                    System.out.println("输入要添加的数");
                    int value = scanner.nextInt();
                    AQ1.addQueue(value);
                    break;
                case 'g':
                    try {
                        int res = AQ1.getQueue();
                        System.out.printf("取出的数据是%d\n",res);
                    } catch (Exception e){
                        System.out.println(e.getMessage());
                    }

                    break;
                case 'h':
                    try {
                        int res = AQ1.headQueue();
                        System.out.printf("取出的数据是%d\n",res);
                    } catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                default:
                    break;
            }
        }
        System.out.println("程序退出");
    }

}

class ArrayQueue1 {
    private int maxSize;
    private int rear;
    private int front;
    private int[] arr;
    public ArrayQueue1(int maxArrSize){
        maxSize= maxArrSize;
        rear = -1;
        front = -1;
        arr = new int[maxSize];
    }

    public boolean isFull(){
        return rear == maxSize-1;
    }

    public boolean isEmpty(){
        return rear == front;
    }

    public void addQueue(int node){
        if (isFull()){
            System.out.println("队列已满");
            return;
        }
        rear++;
        arr[rear] = node;
    }

    public int getQueue(){
        if (isEmpty()){
            System.out.println("空队列");
            throw new RuntimeException("队列空 不能取数据");
        }
        front++;
        return arr[front];
    }

    public void showQueue(){
        if (isEmpty()){
            System.out.println("空数列");
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\n",i,arr[i]);
        }

    }

    public int headQueue(){
        if(isEmpty()){
            System.out.println("空队列，无法取出队列头");
        }
        return arr[front+1];
    }
}