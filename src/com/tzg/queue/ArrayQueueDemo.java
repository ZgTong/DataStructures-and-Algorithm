package com.tzg.queue;

import java.util.Scanner;

public class ArrayQueueDemo {
	public static void main(String[] args) {
		//����һ������
		ArrayQueue arrayQueue = new ArrayQueue(3);
		char key= ' ';
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
				arrayQueue.showQueue();
				break;
			case 'e':
				scanner.close();
				loop = false;
				break;
			case 'a':
				System.out.println("���һ����");
				int value = scanner.nextInt();
				arrayQueue.addQueue(value);
				break;
			case 'g':
				try {
					int res = arrayQueue.getQueue();
					System.out.printf("ȡ����������%d\n",res);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e.getMessage());
				}
				
				break;
			case 'h':
				try {
					int res = arrayQueue.headQueue();
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
		System.out.println("�����˳�");
	}
}

//ʹ������ģ�����
class ArrayQueue{
	private int maxSize; //�����������
	private int front; // ����ͷ
	private int rear; // ����β
	private int[] arr; //���������ڴ������,ģ�����
	public ArrayQueue(int arrMaxSize) {
		maxSize = arrMaxSize;
		arr = new int[maxSize];
		front = -1; //��һ�����ݵ�ǰһ��λ��
		rear = -1; //ָ�����β�����ݣ������Ƕ������һ�����ݣ�
		
	}
	//�ж϶����Ƿ�����
	public boolean isFull() {
		return rear == maxSize - 1;
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
		rear++; //rear����
		arr[rear] = n;
		
	}
	
	//��ȡ���е����ݣ�������
	public int getQueue() {
		//�ж϶����Ƿ�Ϊ��
		if (isEmpty()) {
			//ͨ���׳��쳣
			throw new RuntimeException("���п� ����ȡ����");
		}
		front++; //front ����
		return arr[front];
	}
	
	//��ʾ���е���������
	public void showQueue() {
		if (isEmpty()) {
			System.out.println("����Ϊ��");
		}
		
		for (int i = 0; i < arr.length; i++) {
			System.out.printf("arr[%d]=%d\n",i,arr[i]);
		}
	}
	
	
	//��ʾ���е�ͷ����
		public int headQueue() {
			if (isEmpty()) {
				throw new RuntimeException("����Ϊ��");
			}
			
			return arr[front+1];
		}
	
	
	
}
