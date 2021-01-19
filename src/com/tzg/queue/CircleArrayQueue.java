package com.tzg.queue;

import java.util.Scanner;

public class CircleArrayQueue {
	public static void main(String[] args) {
		System.out.println("测试环形队列");
		CircleArray caQueue = new CircleArray(4);//其队列有效数据最多是3，留出一个空间作为约定
		char key = ' ';
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
				caQueue.showQueue();
				break;
			case 'e':
				scanner.close();
				loop = false;
				break;
			case 'a':
				System.out.println("输出一个数");
				int value = scanner.nextInt();
				caQueue.addQueue(value);
				break;
			case 'g':
				try {
					int res = caQueue.getQueue();
					System.out.printf("取出的数据是%d\n",res);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e.getMessage());
				}
				
				break;
			case 'h':
				try {
					int res = caQueue.headQueue();
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
	}
	
	//判断队列是否已满
	public boolean isFull() {
		return (rear+1) % maxSize == front;
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
		//直接加入数据
		arr[rear] = n;
		//将rear后移，必须考虑取模
		rear = (rear+1) % maxSize;
		
	}
	
	//获取队列的数据，出队列
	public int getQueue() {
		//判断队列是否为空
		if (isEmpty()) {
			//通过抛出异常
			throw new RuntimeException("队列空 不能取数据");
		}
		//front 是指向队列第一个元素
		//1.先把front 对应的值保存到一个临时变量
		//2.将front后移
		//3、将临时保存的变量返回
		int value = arr[front];
		front = (front + 1)%maxSize;
		return value;
	}
	
	//显示队列的所有数据
	public void showQueue() {
		if (isEmpty()) {
			System.out.println("数列为空");
		}
		//思路 ：从front开始遍历，遍历多少个元素
		for (int i = front; i < front+size(); i++) {
			System.out.printf("arr[%d]=%d\n",i%maxSize,arr[i%maxSize]);
		}
	}
	//求出当前数列有效数据的个数
	public int size() {
		return (rear + maxSize - front) % maxSize;
	}
	
	
	//显示队列的头数据
	public int headQueue() {
		if (isEmpty()) {
			throw new RuntimeException("数列为空");
		}
		return arr[front];
	}	
}