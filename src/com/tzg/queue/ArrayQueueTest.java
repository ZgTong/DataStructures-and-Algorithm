package com.tzg.queue;

import java.util.Scanner;

public class ArrayQueueTest {
    public static void main(String[] args) {
        ArrayQueue1 AQ1 =new ArrayQueue1(3);
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
                    AQ1.showQueue();
                    break;
                case 'a':
                    System.out.println("����Ҫ��ӵ���");
                    int value = scanner.nextInt();
                    AQ1.addQueue(value);
                    break;
                case 'g':
                    try {
                        int res = AQ1.getQueue();
                        System.out.printf("ȡ����������%d\n",res);
                    } catch (Exception e){
                        System.out.println(e.getMessage());
                    }

                    break;
                case 'h':
                    try {
                        int res = AQ1.headQueue();
                        System.out.printf("ȡ����������%d\n",res);
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
        System.out.println("�����˳�");
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
            System.out.println("��������");
            return;
        }
        rear++;
        arr[rear] = node;
    }

    public int getQueue(){
        if (isEmpty()){
            System.out.println("�ն���");
            throw new RuntimeException("���п� ����ȡ����");
        }
        front++;
        return arr[front];
    }

    public void showQueue(){
        if (isEmpty()){
            System.out.println("������");
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\n",i,arr[i]);
        }

    }

    public int headQueue(){
        if(isEmpty()){
            System.out.println("�ն��У��޷�ȡ������ͷ");
        }
        return arr[front+1];
    }
}