package com.tzg.queue;

import java.util.Scanner;

public class ArrayQueueDemo {
	public static void main(String[] args) {
		//创建一个队列
		ArrayQueue arrayQueue = new ArrayQueue(3);
		char key= ' ';
		Scanner scanner = new Scanner(System.in);
		boolean loop = true;
		while(loop) {
			System.out.println("s(show):显示队列");
			System.out.println("e(exit):退出程序");
			System.out.println("a(add):添加数据");
			System.out.println("g(get):取出数据");
			System.out.println("h(head):查看队列头");
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
				System.out.println("输出一个数");
				int value = scanner.nextInt();
				arrayQueue.addQueue(value);
				break;
			case 'g':
				try {
					int res = arrayQueue.getQueue();
					System.out.printf("取出的数据是%d\n",res);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e.getMessage());
				}
				
				break;
			case 'h':
				try {
					int res = arrayQueue.headQueue();
					System.out.printf("队列头的数据是%d\n",res);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e.getMessage());
				}
				
				break;
			default:
				break;
			}
		}
		System.out.println("程序退出");
	}
}

//使用数组模拟队列
class ArrayQueue{
	private int maxSize; //数组最大容量
	private int front; // 队列头
	private int rear; // 队列尾
	private int[] arr; //该数组用于存放数据,模拟队列
	public ArrayQueue(int arrMaxSize) {
		maxSize = arrMaxSize;
		arr = new int[maxSize];
		front = -1; //第一个数据的前一个位置
		rear = -1; //指向队列尾的数据（即就是队列最后一个数据）
		
	}
	//判断队列是否已满
	public boolean isFull() {
		return rear == maxSize - 1;
	}
	
	//判断队列是否为空
	public boolean isEmpty() {
		return rear==front;
	}
	
	public void addQueue(int n){
		//判断队列是否已满
		if (isFull()) {
			System.out.println("队列已满，不能加入数据");
			return;
		}
		rear++; //rear后移
		arr[rear] = n;
		
	}
	
	//获取队列的数据，出队列
	public int getQueue() {
		//判断队列是否为空
		if (isEmpty()) {
			//通过抛出异常
			throw new RuntimeException("队列空 不能取数据");
		}
		front++; //front 后移
		return arr[front];
	}
	
	//显示队列的所有数据
	public void showQueue() {
		if (isEmpty()) {
			System.out.println("数列为空");
		}
		
		for (int i = 0; i < arr.length; i++) {
			System.out.printf("arr[%d]=%d\n",i,arr[i]);
		}
	}
	
	
	//显示队列的头数据
		public int headQueue() {
			if (isEmpty()) {
				throw new RuntimeException("数列为空");
			}
			
			return arr[front+1];
		}
	
	
	
}
