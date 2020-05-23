package com.tzg.queue;

import java.util.Scanner;

public class CircleArrayQueue {
	public static void main(String[] args) {
		System.out.println("���Ի��ζ���");
		CircleArray caQueue = new CircleArray(4);//�������Ч���������3������һ���ռ���ΪԼ��
		char key = ' ';
		Scanner scanner = new Scanner(System.in);
		boolean loop = true;
		while(loop) {
			System.out.println("s(show):��ʾ����");
			System.out.println("e(exit):�˳�����");
			System.out.println("a(add):�������");
			System.out.println("g(get):ȡ������");
			System.out.println("h(head):�鿴����ͷ");
			key = scanner.next().charAt(0);
			switch (key) {
			case 's':
				caQueue.showQueue();
				break;
			case 'e':
				scanner.close();
				loop = false;
				break;
			case 'a':
				System.out.println("���һ����");
				int value = scanner.nextInt();
				caQueue.addQueue(value);
				break;
			case 'g':
				try {
					int res = caQueue.getQueue();
					System.out.printf("ȡ����������%d\n",res);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e.getMessage());
				}
				
				break;
			case 'h':
				try {
					int res = caQueue.headQueue();
					System.out.printf("����ͷ��������%d\n",res);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e.getMessage());
				}
				
				break;
			default:
				break;
			}			
		}
	}
}


class CircleArray {
	private int maxSize;
	private int front;
	private int rear;
	private int[] arr;
	public CircleArray(int arrMaxSize) {
		maxSize = arrMaxSize;
		arr = new int[maxSize]; 
		front = 0;
		rear = 0;
	}
	
	//�ж϶����Ƿ�����
	public boolean isFull() {
		return (rear+1) % maxSize == front;
	}
	
	//�ж϶����Ƿ�Ϊ��
	public boolean isEmpty() {
		return rear==front;
	}
	
	public void addQueue(int n){
		//�ж϶����Ƿ�����
		if (isFull()) {
			System.out.println("�������������ܼ�������");
			return;
		}
		//ֱ�Ӽ�������
		arr[rear] = n;
		//��rear���ƣ����뿼��ȡģ
		rear = (rear+1) % maxSize;
		
	}
	
	//��ȡ���е����ݣ�������
	public int getQueue() {
		//�ж϶����Ƿ�Ϊ��
		if (isEmpty()) {
			//ͨ���׳��쳣
			throw new RuntimeException("���п� ����ȡ����");
		}
		//front ��ָ����е�һ��Ԫ��
		//1.�Ȱ�front ��Ӧ��ֵ���浽һ����ʱ����
		//2.��front����
		//3������ʱ����ı�������
		int value = arr[front];
		front = (front + 1)%maxSize;
		return value;
	}
	
	//��ʾ���е���������
	public void showQueue() {
		if (isEmpty()) {
			System.out.println("����Ϊ��");
		}
		//˼· ����front��ʼ�������������ٸ�Ԫ��
		for (int i = front; i < front+size(); i++) {
			System.out.printf("arr[%d]=%d\n",i%maxSize,arr[i%maxSize]);
		}
	}
	//�����ǰ������Ч���ݵĸ���
	public int size() {
		return (rear+maxSize-front)%maxSize;
	}
	
	
	//��ʾ���е�ͷ����
	public int headQueue() {
		if (isEmpty()) {
			throw new RuntimeException("����Ϊ��");
		}
		
		return arr[front];
	}	
}