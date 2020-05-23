package com.tzg.linkedList;

import java.util.Stack;

public class SingleLinkedList {
	public static void main(String[] args) {
		//测试
		//先创建节点
		HeroNode hero1 = new HeroNode(1,"宋江","及时雨");
		HeroNode hero2 = new HeroNode(2,"卢俊义","玉麒麟");
		HeroNode hero3 = new HeroNode(3,"吴用","智多星");
		HeroNode hero4 = new HeroNode(4,"林冲","豹子头");
		HeroNode hero6 = new HeroNode(6,"鲁智深","花和尚");
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
		HeroNode hero2new = new HeroNode(2,"陆军已","与其临");
		sll.update(hero2new);
		System.out.println("修改后的情况");
		sll.list();
//		System.out.println("反转单链表");
//		reverseList(sll.getHead());
//		sll.list();
		System.out.println("逆序打印链表");
		reversePrint(sll.getHead());
		
		
//		sll.list();
//		sll.delete(4);
//		System.out.println("删除后的情况");
//		sll.list();
//		System.out.println(getLength(sll.getHead()));
//		
//		HeroNode res = findLastIndexNode(sll.getHead(), 2);
//		System.out.println(res);
		
		SingleLinkedListReal sll2 = new SingleLinkedListReal();
		HeroNode hero5 = new HeroNode(5,"童祖光","大帅哥");
		HeroNode hero7 = new HeroNode(7,"罗骊","大美女");
		HeroNode hero8 = new HeroNode(8,"吴彦祖","一般般");
		sll2.addByOrder(hero7);
		sll2.addByOrder(hero5);
		sll2.addByOrder(hero8);
		System.out.println("测试一把合并");
		HeroNode mergeNode = mergeTwoList(sll.getHead(), sll2.getHead());
 		while(mergeNode != null) {
 			System.out.println(mergeNode);
 			mergeNode = mergeNode.next;
 		}
		
		
	}
	
	
	//逆序打印单链表 用栈
	public static void reversePrint(HeroNode head) {
		if (head.next == null) {
			return;
		}
		//创建一个栈，将各个节点压入
		Stack<HeroNode> stack = new Stack<HeroNode>();
		HeroNode cur = head.next;
		//将链表的所有节点压入
		while (cur!=null) {
			stack.push(cur);
			cur = cur.next;//cur 后移
		}
		//将栈中的节点进行打印，pop
		while (stack.size()>0) {
			System.out.println(stack.pop());
			
		}
	}
	
	
	//合并两个有序链表
	public static HeroNode mergeTwoList(HeroNode head1, HeroNode head2) {
		HeroNode mergeLinkHead = new HeroNode(0, "", ""); 
		//如果当前链表为空，无需反转直接返回
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
	
	
	//将链表反转
	public static void reverseList(HeroNode head) {
		//如果当前链表为空，或只有一个节点，无需反转直接返回
		if (head.next == null || head.next.next==null) {
			return;
		}
		// 定义一个辅助的变量，帮助我们遍历原来的链表
		HeroNode cur = head.next;
		HeroNode next = null; //指向当前节点（cur）的下一个节点
		HeroNode reverseHead = new HeroNode(0, "", "");
		//遍历原来的链表
		//每遍历一个节点，将其取出放在新的链表reverseHead的最前端
		while(cur!=null) {
			next = cur.next;//暂存当前节点的下一个节点
			cur.next = reverseHead.next;//将cur的下一个节点指向reverseHead链表的最前端；
			reverseHead.next = cur;// 将cur连接到新的链表上
			cur = next;//让cur后移
		}
		//将head.next指向reverseHead.next, 实现单链表的反转
		head.next = reverseHead.next;
	}
	
	//查看单链表中倒数第K个节点
	//思路：
	//1、编写一个方法，接受head，同时接收一个index
	//2、index表示是倒数第index个节点
	//3、先把链表从头到尾遍历，得到链表的总的长度getLength
	//4、得到size后，从链表的第一个开始遍历（size-index）个
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
	
	
	
	//方法 获取到单链表的节点的个数（如果是带头结点的链表，需要不统计头结点）
	/*
	 * 
	 * @param head 链表的头结点
	 * @return 返回有效节点的个数
	 *
	 * 
	 * */
	public static int getLength(HeroNode head) {
		if (head.next==null) {
			return 0;
		}
		int length = 0;
		//定义一个辅助的变量
		HeroNode cur = head.next;
		while(cur!=null) {
			length++;
			cur = cur.next;//遍历
		}
		return length;
	}
}

//定义SingleLinkedList 管理英雄
class SingleLinkedListReal{
	//初始化一个头节点,头结点不要动
	private HeroNode head = new HeroNode(0, "", "");
	//返回头节点
	public HeroNode getHead() {
		return head;
	}

	//添加节点到单向链表
	//当不考虑链表顺序时
	//找到当前链表最后节点，将next 指向新的节点
	public void add(HeroNode heroNode) {
		//因为头结点不能动，因此需要一个辅助遍历
		HeroNode temp  = head;
		//遍历链表，找到最后
		while(true) {
			//找到链表的最后
			if(temp.next==null) {
				break;
			}
			//没有找到将temp后移
			temp = temp.next;
		}
		//当退出循环时，temp就指向链表的最后
		//将最后这个节点的next指向新的节点
		temp.next = heroNode;
		
	}
	
	//当考虑链表顺序时
	//找到新添加的节点的位置，通过遍历
	public void addByOrder(HeroNode heroNode) {
		//因为头结点不能动，因此需要一个辅助遍历
		//temp是添加位置的前一个节点，否者插入不了
		HeroNode temp  = head;
		boolean flag = false; //标志添加的编号是否存在，默认为false
		//遍历链表，找到最后
		while(true) {
			//找到链表的最后
			if(temp.next==null) {
				break;
			}
			if (temp.next.no>heroNode.no) { //位置找到，就在temp的后面插入
				break;
			}else if(temp.next.no==heroNode.no) { //编号已经存在
				flag = true; 
				break;
				
			}
			//没有找到将temp后移
			temp = temp.next;
		}
		//判断flag的值
		if (flag) { //编号已存在
			System.out.printf("编号已存在，不能加入\n", heroNode.no);
		}else {
			heroNode.next = temp.next;
			temp.next = heroNode;
		}
		
		
	}
	
	public void update(HeroNode newHeroNode) {
		if (head.next == null) {
			System.out.println("链表为空");
			return;
		}
		
		//找到需要修改的节点，根据no编号
		//定义一个辅助变量
		HeroNode temp = head.next;
		boolean flag = false;
		while(true) {
			if (temp==null) {
				break; //已经遍历完链表
			}
			if (temp.no==newHeroNode.no) {
				flag = true; //找到了
				break;
			}
			temp=temp.next;
		}
		//根据flag判断是否找到要修改的节点
		if (flag) {
			temp.name = newHeroNode.name;
			temp.nickname = newHeroNode.nickname;
		}else {
			System.out.printf("没有找到编号%d的节点，不能修改\n",newHeroNode.no);;
			
		}
	}
	
	//删除节点
	//temp辅助节点找到待删除节点的前一个
	//比较temp.next.no和需要删除的节点no
	public void delete(int no) {
		
		//找到需要修改的节点，根据no编号
		//定义一个辅助变量
		HeroNode temp = head;
		boolean flag = false;
		while(true) {
			if (temp.next==null) {
				break; //已经遍历完链表
			}
			if (temp.next.no==no) {
				flag = true; //找到了
				break;
			}
			temp=temp.next;
		}
		//根据flag判断是否找到要删除的节点
		if (flag) {
			temp.next = temp.next.next;
		}else {
			System.out.printf("要删除%d的节点，不存在\n",no);
			
		}
	}	
	
	public void list() {
		//判断链表是否为空
		if(head.next == null) {
			System.out.println("链表为空");
			return;
		}
		//
		HeroNode temp  = head.next;
		while(true) {
			if(temp==null) {
				break;
			}
			//输出节点信息
			System.out.println(temp);
			//temp 后移
			temp = temp.next;
		}
	}
}

//每个对象就是一个节点
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
