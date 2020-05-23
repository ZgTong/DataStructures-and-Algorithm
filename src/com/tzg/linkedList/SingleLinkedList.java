package com.tzg.linkedList;

import java.util.Stack;

public class SingleLinkedList {
	public static void main(String[] args) {
		//����
		//�ȴ����ڵ�
		HeroNode hero1 = new HeroNode(1,"�ν�","��ʱ��");
		HeroNode hero2 = new HeroNode(2,"¬����","������");
		HeroNode hero3 = new HeroNode(3,"����","�Ƕ���");
		HeroNode hero4 = new HeroNode(4,"�ֳ�","����ͷ");
		HeroNode hero6 = new HeroNode(6,"³����","������");
		SingleLinkedListReal sll = new SingleLinkedListReal();
//		sll.add(hero1);
//		sll.add(hero2);
//		sll.add(hero3);
//		sll.add(hero4);
//		sll.list();
		sll.addByOrder(hero1);
		sll.addByOrder(hero4);
		sll.addByOrder(hero2);
		sll.addByOrder(hero3);
		sll.addByOrder(hero6);
		sll.list();
		HeroNode hero2new = new HeroNode(2,"½����","������");
		sll.update(hero2new);
		System.out.println("�޸ĺ�����");
		sll.list();
//		System.out.println("��ת������");
//		reverseList(sll.getHead());
//		sll.list();
		System.out.println("�����ӡ����");
		reversePrint(sll.getHead());
		
		
//		sll.list();
//		sll.delete(4);
//		System.out.println("ɾ��������");
//		sll.list();
//		System.out.println(getLength(sll.getHead()));
//		
//		HeroNode res = findLastIndexNode(sll.getHead(), 2);
//		System.out.println(res);
		
		SingleLinkedListReal sll2 = new SingleLinkedListReal();
		HeroNode hero5 = new HeroNode(5,"ͯ���","��˧��");
		HeroNode hero7 = new HeroNode(7,"����","����Ů");
		HeroNode hero8 = new HeroNode(8,"������","һ���");
		sll2.addByOrder(hero7);
		sll2.addByOrder(hero5);
		sll2.addByOrder(hero8);
		System.out.println("����һ�Ѻϲ�");
		HeroNode mergeNode = mergeTwoList(sll.getHead(), sll2.getHead());
 		while(mergeNode != null) {
 			System.out.println(mergeNode);
 			mergeNode = mergeNode.next;
 		}
		
		
	}
	
	
	//�����ӡ������ ��ջ
	public static void reversePrint(HeroNode head) {
		if (head.next == null) {
			return;
		}
		//����һ��ջ���������ڵ�ѹ��
		Stack<HeroNode> stack = new Stack<HeroNode>();
		HeroNode cur = head.next;
		//����������нڵ�ѹ��
		while (cur!=null) {
			stack.push(cur);
			cur = cur.next;//cur ����
		}
		//��ջ�еĽڵ���д�ӡ��pop
		while (stack.size()>0) {
			System.out.println(stack.pop());
			
		}
	}
	
	
	//�ϲ�������������
	public static HeroNode mergeTwoList(HeroNode head1, HeroNode head2) {
		HeroNode mergeLinkHead = new HeroNode(0, "", ""); 
		//�����ǰ����Ϊ�գ����跴תֱ�ӷ���
		if (head1 == null && head2 == null) {
			return null;
		}
		if (head1 ==null) {
			return head2;
		}
		if (head2 ==null) {
			return head1;
		}
		HeroNode mergeHead = null;
		if (head1.no>head2.no) {
			mergeHead=head2;
			mergeHead.next = mergeTwoList(head1, head2.next);
		} else {
			mergeHead=head1;
			mergeHead.next = mergeTwoList(head1.next, head2);
		}
		return mergeHead;
	}
	
	
	//������ת
	public static void reverseList(HeroNode head) {
		//�����ǰ����Ϊ�գ���ֻ��һ���ڵ㣬���跴תֱ�ӷ���
		if (head.next == null || head.next.next==null) {
			return;
		}
		// ����һ�������ı������������Ǳ���ԭ��������
		HeroNode cur = head.next;
		HeroNode next = null; //ָ��ǰ�ڵ㣨cur������һ���ڵ�
		HeroNode reverseHead = new HeroNode(0, "", "");
		//����ԭ��������
		//ÿ����һ���ڵ㣬����ȡ�������µ�����reverseHead����ǰ��
		while(cur!=null) {
			next = cur.next;//�ݴ浱ǰ�ڵ����һ���ڵ�
			cur.next = reverseHead.next;//��cur����һ���ڵ�ָ��reverseHead�������ǰ�ˣ�
			reverseHead.next = cur;// ��cur���ӵ��µ�������
			cur = next;//��cur����
		}
		//��head.nextָ��reverseHead.next, ʵ�ֵ�����ķ�ת
		head.next = reverseHead.next;
	}
	
	//�鿴�������е�����K���ڵ�
	//˼·��
	//1����дһ������������head��ͬʱ����һ��index
	//2��index��ʾ�ǵ�����index���ڵ�
	//3���Ȱ������ͷ��β�������õ�������ܵĳ���getLength
	//4���õ�size�󣬴�����ĵ�һ����ʼ������size-index����
	public static HeroNode findLastIndexNode(HeroNode head, int index) {
		if(head.next==null) {
			return null;
		}
		
		int size = getLength(head);
		if (index<=0||index>size) {
			return null;
		}
		HeroNode cur = head.next;
		for (int i = 0; i < size-index; i++) {
			cur = cur.next;
		}
		return cur;
		
	}
	
	
	
	//���� ��ȡ��������Ľڵ�ĸ���������Ǵ�ͷ����������Ҫ��ͳ��ͷ��㣩
	/*
	 * 
	 * @param head �����ͷ���
	 * @return ������Ч�ڵ�ĸ���
	 *
	 * 
	 * */
	public static int getLength(HeroNode head) {
		if (head.next==null) {
			return 0;
		}
		int length = 0;
		//����һ�������ı���
		HeroNode cur = head.next;
		while(cur!=null) {
			length++;
			cur = cur.next;//����
		}
		return length;
	}
}

//����SingleLinkedList ����Ӣ��
class SingleLinkedListReal{
	//��ʼ��һ��ͷ�ڵ�,ͷ��㲻Ҫ��
	private HeroNode head = new HeroNode(0, "", "");
	//����ͷ�ڵ�
	public HeroNode getHead() {
		return head;
	}

	//��ӽڵ㵽��������
	//������������˳��ʱ
	//�ҵ���ǰ�������ڵ㣬��next ָ���µĽڵ�
	public void add(HeroNode heroNode) {
		//��Ϊͷ��㲻�ܶ��������Ҫһ����������
		HeroNode temp  = head;
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
		
	}
	
	//����������˳��ʱ
	//�ҵ�����ӵĽڵ��λ�ã�ͨ������
	public void addByOrder(HeroNode heroNode) {
		//��Ϊͷ��㲻�ܶ��������Ҫһ����������
		//temp�����λ�õ�ǰһ���ڵ㣬���߲��벻��
		HeroNode temp  = head;
		boolean flag = false; //��־��ӵı���Ƿ���ڣ�Ĭ��Ϊfalse
		//���������ҵ����
		while(true) {
			//�ҵ���������
			if(temp.next==null) {
				break;
			}
			if (temp.next.no>heroNode.no) { //λ���ҵ�������temp�ĺ������
				break;
			}else if(temp.next.no==heroNode.no) { //����Ѿ�����
				flag = true; 
				break;
				
			}
			//û���ҵ���temp����
			temp = temp.next;
		}
		//�ж�flag��ֵ
		if (flag) { //����Ѵ���
			System.out.printf("����Ѵ��ڣ����ܼ���\n", heroNode.no);
		}else {
			heroNode.next = temp.next;
			temp.next = heroNode;
		}
		
		
	}
	
	public void update(HeroNode newHeroNode) {
		if (head.next == null) {
			System.out.println("����Ϊ��");
			return;
		}
		
		//�ҵ���Ҫ�޸ĵĽڵ㣬����no���
		//����һ����������
		HeroNode temp = head.next;
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
	//temp�����ڵ��ҵ���ɾ���ڵ��ǰһ��
	//�Ƚ�temp.next.no����Ҫɾ���Ľڵ�no
	public void delete(int no) {
		
		//�ҵ���Ҫ�޸ĵĽڵ㣬����no���
		//����һ����������
		HeroNode temp = head;
		boolean flag = false;
		while(true) {
			if (temp.next==null) {
				break; //�Ѿ�����������
			}
			if (temp.next.no==no) {
				flag = true; //�ҵ���
				break;
			}
			temp=temp.next;
		}
		//����flag�ж��Ƿ��ҵ�Ҫɾ���Ľڵ�
		if (flag) {
			temp.next = temp.next.next;
		}else {
			System.out.printf("Ҫɾ��%d�Ľڵ㣬������\n",no);
			
		}
	}	
	
	public void list() {
		//�ж������Ƿ�Ϊ��
		if(head.next == null) {
			System.out.println("����Ϊ��");
			return;
		}
		//
		HeroNode temp  = head.next;
		while(true) {
			if(temp==null) {
				break;
			}
			//����ڵ���Ϣ
			System.out.println(temp);
			//temp ����
			temp = temp.next;
		}
	}
}

//ÿ���������һ���ڵ�
class HeroNode{
	public int no;
	public String name;
	public String nickname;
	public HeroNode next;
	public HeroNode(int hNo, String hName, String hNickname) {
		this.no = hNo;
		this.name = hName;
		this.nickname = hNickname;
	}
	
	@Override
	public String toString() {
		return "HeroNode [no=" + no +", name="+ name+ ", nickName="+nickname;
	}
	
}
