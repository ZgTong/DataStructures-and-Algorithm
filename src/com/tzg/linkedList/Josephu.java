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
	//first�ڵ�
	private ChildNode firstNode = null;

	/**
	 * ����ӽڵ㣬����һ����������
	 * @param num ��ӵ��ӽڵ�����
	 */
	public void addNode(int num){
		if(num<1){
			System.out.println("�������ֵ����ȷ");
			return;
		}
		//����ָ��
		ChildNode curNode = null;
		for (int i = 1; i <=num ; i++) {
			//���ݱ�Ŵ����ӽڵ�
			ChildNode childNode = new ChildNode(i);
			if (i==1){
				firstNode = childNode;
				//���ɻ�
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
	 * չʾ�����ӽڵ�
	 */
	public void listNode(){
		//�ǿ�У��
		if (firstNode==null){
			System.out.println("������Ϊ��");
			return;
		}
		ChildNode curNode = firstNode;
		while (true){
			System.out.printf("�ӽڵ�ı��Ϊ%d\n",curNode.getNo());
			if (curNode.getNext()==firstNode){
				break;
			}
			curNode = curNode.getNext();
		}
	}


	/**
	 * ��������Ĳ�����չʾԼɪ������ĳ�Ȧ˳��
	 * @param startNum ��ʼλ��
	 * @param countNum �����ٸ�
	 * @param num ����ж��ٸ��ӽڵ�
	 */
	public void countOutNode(int startNum, int countNum, int num){
		if (firstNode == null || startNum>num || startNum<1){
			System.out.println("���������������������");
		}
		//�����ڵ�
		ChildNode helper = firstNode;
		//��ѭ����Ϊ�˽�helperָ���ε�����������һ��������һ���ڵ��ǰһ��
		while(true){
			if (helper.getNext() == firstNode){
				break;
			}
			helper = helper.getNext();
		}
		//�ڱ���֮ǰ��helper��firstNodeǰ��startNum-1λ
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
			System.out.printf("�ӽڵ�%d��Ȧ\n",firstNode.getNo());
			firstNode = firstNode.getNext();
			helper.setNext(firstNode);
		}
		System.out.printf("���һ���ӽڵ�%d��Ȧ\n",firstNode.getNo());
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