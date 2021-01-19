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

/**
 * ArrayQueue
 */	
class ArrayQueue {
	private int maxSize;
	private int front; //ָ���һ��
	private int rear; //ָ�����һ��
	private int[] arr;
	public ArrayQueue (int arrMaxSize) {
		maxSize = arrMaxSize;
		arr = new int[maxSize];
		front = 0;
		rear = 0;
	}
	public boolean isFull() {
		return (rear + 1) % maxSize == front;
	}
	
	public boolean isEmpty() {
		return rear == front;
	}
	
	public void addQueue(int n) {
		// �ж϶����Ƿ���
		if (isFull()) {
			System.out.println("�����������ܼ�������~");
			return;
		}
		arr[rear] = n;
		rear = (rear + 1) % maxSize;
	}

	public int getQueue() {
		// �ж϶����Ƿ���
		if (isEmpty()) {
			throw new RuntimeException("���пգ�����ȡ����");
		}
		int value = arr[front];
		front = (front+1) % maxSize;
		return value;
	}

	public void showQueue() {
		// ����
		if (isEmpty()) {
			System.out.println("���пյģ�û������~~");
			return;
		}
		for (int i = front; i < front+size(); i++) {
			System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
		}
	}

	public int size() {
		return (rear-front+maxSize)%maxSize;
	}

	// ��ʾ���е�ͷ���ݣ� ע�ⲻ��ȡ������
	public int headQueue() {
		// �ж�
		if (isEmpty()) {
			throw new RuntimeException("���пյģ�û������~~");
		}
		return arr[front];
	}
}