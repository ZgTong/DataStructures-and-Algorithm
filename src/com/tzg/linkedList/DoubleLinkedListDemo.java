package com.tzg.linkedList;

public class DoubleLinkedListDemo {
	public static void main(String[] args) {
		//˫�������
		HeroDoubleNode hero1 = new HeroDoubleNode(1,"�ν�","��ʱ��");
		HeroDoubleNode hero2 = new HeroDoubleNode(2,"¬����","������");
		HeroDoubleNode hero3 = new HeroDoubleNode(3,"����","�Ƕ���");
		HeroDoubleNode hero4 = new HeroDoubleNode(4,"�ֳ�","����ͷ");
		
		DoubleLinkedList dll = new DoubleLinkedList();
		dll.add(hero1);
		dll.add(hero2);
		dll.add(hero3);
		dll.add(hero4);
		dll.list();
		System.out.println("�޸ĺ�");
		HeroDoubleNode hero5 = new HeroDoubleNode(4,"����ʤ","������");
		dll.update(hero5);
		dll.list();
		System.out.println("ɾ����");
		dll.delete(3);
		dll.list();
	}
}

class DoubleLinkedList{
	//��ʼ��һ��ͷ�ڵ�,ͷ��㲻Ҫ��
	private HeroDoubleNode head = new HeroDoubleNode(0, "", "");
	//����ͷ�ڵ�
	public HeroDoubleNode getHead() {
		return head;
	}
	
	//����˫������
	public void list() {
		//�ж������Ƿ�Ϊ��
		if(head.next == null) {
			System.out.println("����Ϊ��");
			return;
		}
		//
		HeroDoubleNode temp  = head.next;
		while(true) {
			if(temp==null) {
				break;
			}
			//����ڵ���Ϣ
			System.out.println(temp);
			// ����
			temp = temp.next;
		}
	}
	
	
	
	//��ӽڵ㵽˫���������
	public void add(HeroDoubleNode heroNode) {
		//��Ϊͷ��㲻�ܶ��������Ҫһ����������
		HeroDoubleNode temp  = head;
		//���������ҵ����
		while(true) {
			//�ҵ���������
			if(temp.next==null) {
				break;
			}
			//û���ҵ���temp����
			temp = temp.next;
		}
		//���˳�ѭ��ʱ��temp��ָ����������
		//���������ڵ��nextָ���µĽڵ�
		temp.next = heroNode;
		heroNode.pre = temp;
		
	}




	
	public void update(HeroDoubleNode newHeroNode) {
		if (head.next == null) {
			System.out.println("����Ϊ��");
			return;
		}
		
		//�ҵ���Ҫ�޸ĵĽڵ㣬����no���
		//����һ����������
		HeroDoubleNode temp = head.next;
		boolean flag = false;
		while(true) {
			if (temp==null) {
				break; //�Ѿ�����������
			}
			if (temp.no==newHeroNode.no) {
				flag = true; //�ҵ���
				break;
			}
			temp=temp.next;
		}
		//����flag�ж��Ƿ��ҵ�Ҫ�޸ĵĽڵ�
		if (flag) {
			temp.name = newHeroNode.name;
			temp.nickname = newHeroNode.nickname;
		}else {
			System.out.printf("û���ҵ����%d�Ľڵ㣬�����޸�\n",newHeroNode.no);;
			
		}
	}
	

	//ɾ���ڵ�
	//˫���������ֱ���ҵ�Ҫɾ���Ľڵ�
	//�ҵ�������ɾ��
	public void delete(int no) {
		if (head.next==null) {
			System.out.println("����Ϊ��");
			return;
		}
		//�ҵ���Ҫ�޸ĵĽڵ㣬����no���
		//����һ����������
		HeroDoubleNode temp = head.next;//���Լ� �ӵ�һ����������ǰһ��
		boolean flag = false;
		while(true) {
			if (temp==null) {
				break; //�Ѿ�����������
			}
			if (temp.no==no) {
				flag = true; //�ҵ���
				break;
			}
			temp=temp.next;
		}
		//����flag�ж��Ƿ��ҵ�Ҫɾ���Ľڵ�
		if (flag) {
			temp.pre.next = temp.next;
			// ���һ���ڵ�ɾ�������⣬��ָ���쳣
			if (temp.next!=null) {
				temp.next.pre = temp.pre;
			}
			
		}else {
			System.out.printf("Ҫɾ��%d�Ľڵ㣬������\n",no);;
			
		}
	}		
	
}

//ÿ���������һ���ڵ�
class HeroDoubleNode{
	public int no;
	public String name;
	public String nickname;
	public HeroDoubleNode next;
	public HeroDoubleNode pre;
	public HeroDoubleNode(int hNo, String hName, String hNickname) {
		this.no = hNo;
		this.name = hName;
		this.nickname = hNickname;
	}
	
	@Override
	public String toString() {
		return "HeroNode [no=" + no +", name="+ name+ ", nickName="+nickname+"]";
	}
	
}