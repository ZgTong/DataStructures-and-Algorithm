package com.tzg.linkedList;

public class Josephu {
	public static void main(String[] args) {
		CircleSingleLinkedList csll = new CircleSingleLinkedList();
		csll.addNode(5);
		csll.listNode();
		csll.countOutNode(1,2,5);
	}
}

class CircleSingleLinkedList {
	//first节点
	private ChildNode firstNode = null;

	/**
	 * 添加子节点，构建一个环形链表
	 * @param num 添加的子节点数量
	 */
	public void addNode(int num){
		if(num<1){
			System.out.println("输入的数值不正确");
			return;
		}
		//辅助指针
		ChildNode curNode = null;
		for (int i = 1; i <=num ; i++) {
			//根据编号创建子节点
			ChildNode childNode = new ChildNode(i);
			if (i==1){
				firstNode = childNode;
				//构成换
				firstNode.setNext(firstNode);
				curNode = firstNode;
			}else{
				curNode.setNext(childNode);
				childNode.setNext(firstNode);
				curNode = childNode;
			}
		}
	}

	/**
	 * 展示所有子节点
	 */
	public void listNode(){
		//非空校验
		if (firstNode==null){
			System.out.println("该链表为空");
			return;
		}
		ChildNode curNode = firstNode;
		while (true){
			System.out.printf("子节点的编号为%d\n",curNode.getNo());
			if (curNode.getNext()==firstNode){
				break;
			}
			curNode = curNode.getNext();
		}
	}


	/**
	 * 根据输入的参数，展示约瑟夫链表的出圈顺序
	 * @param startNum 起始位置
	 * @param countNum 数多少个
	 * @param num 最初有多少个子节点
	 */
	public void countOutNode(int startNum, int countNum, int num){
		if (firstNode == null || startNum>num || startNum<1){
			System.out.println("输入参数有误，请重新输入");
		}
		//辅助节点
		ChildNode helper = firstNode;
		//该循环是为了将helper指向环形单向链表的最后一个，即第一个节点的前一个
		while(true){
			if (helper.getNext() == firstNode){
				break;
			}
			helper = helper.getNext();
		}
		//在报数之前将helper和firstNode前进startNum-1位
		for (int i = 0; i < startNum-1; i++) {
			helper = helper.getNext();
			firstNode = firstNode.getNext();
		}

		while (true){
			if (helper==firstNode){
				break;
			}
			for (int j = 0; j < countNum-1; j++) {
				helper = helper.getNext();
				firstNode = firstNode.getNext();
			}
			System.out.printf("子节点%d出圈\n",firstNode.getNo());
			firstNode = firstNode.getNext();
			helper.setNext(firstNode);
		}
		System.out.printf("最后一个子节点%d出圈\n",firstNode.getNo());
	}
}


class ChildNode{
	private  int no;
	private  ChildNode next;

	public ChildNode(int i){
		this.no = i;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public void setNext(ChildNode next) {
		this.next = next;
	}

	public ChildNode getNext() {
		return next;
	}
}