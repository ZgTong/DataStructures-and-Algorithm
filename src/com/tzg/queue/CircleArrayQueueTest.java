package com.tzg.queue;

import java.util.Scanner;

public class CircleArrayQueueTest {
    public static void main(String[] args) {
        CircleArraySelfWrite casw = new CircleArraySelfWrite(4);
        Scanner scanner = new Scanner(System.in);
        char key = ' ';
        boolean loop = true;
        while(loop){
            System.out.println("s(show):��ʾ����");
            System.out.println("e(exit):�˳�����");
            System.out.println("a(add):�������");
            System.out.println("g(get):ȡ������");
            System.out.println("h(head):�鿴����ͷ");
            key = scanner.next().charAt(0);
            switch (key){
                case 's':
                    casw.showQueue();
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                case 'a':
                    System.out.println("���һ����");
                    int value = scanner.nextInt();
                    casw.addQueue(value);
                    break;
                case 'g':
                    try {
                        int res = casw.getFromQueue();
                        System.out.println("ȡ��������:"+res);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }

                    break;
                case 'h':
                    try {
                        int res = casw.headQueue();
                        System.out.println("ȡ����ͷ����:"+res);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                default:
                    break;
            }
        }
    }
}

class CircleArraySelfWrite{
    private int rear;
    private int front;
    private int arr[];
    private int maxSize;
    public CircleArraySelfWrite(int maxArrSize){
        rear=0;
        front = 0;
        maxSize = maxArrSize;
        arr = new int[maxSize];
    }

    public boolean isFull(){
        return (rear+1)%maxSize==front;
    }

    public boolean isEmpty(){
        return rear==front;
    }

    public int getSize(){
        return (rear+maxSize-front) % maxSize;
    }

    public void addQueue(int node){
        if(isFull()){
            System.out.println("�����Ѿ�����");
            return;
        }
        arr[rear] = node;
        rear = (rear+1)%maxSize;
    }

    public void showQueue(){
        if (isEmpty()){
            System.out.println("�յģ�������");
            return;
        }
        for (int i = front; i < front+getSize(); i++) {
            System.out.printf("arr[%d]=%d\t\n",i%maxSize,arr[i%maxSize]);
        }
    }

    public int getFromQueue(){
        if (isEmpty()){
            throw new RuntimeException("�յģ�������");
        }
        int value = arr[front];
        front = (front+1) % maxSize;
        return value;
    }

    public int headQueue(){
        if (isEmpty()){
            throw new RuntimeException("�յģ�������");
        }
        return arr[front];
    }
}
