package com.tzg.linkedList;

public class DoubleLinkedListDemo {
	public static void main(String[] args) {
		//双链表测试
		HeroDoubleNode hero1 = new HeroDoubleNode(1,"宋江","及时雨");
		HeroDoubleNode hero2 = new HeroDoubleNode(2,"卢俊义","玉麒麟");
		HeroDoubleNode hero3 = new HeroDoubleNode(3,"吴用","智多星");
		HeroDoubleNode hero4 = new HeroDoubleNode(4,"林冲","豹子头");
		
		DoubleLinkedList dll = new DoubleLinkedList();
		dll.add(hero1);
		dll.add(hero2);
		dll.add(hero3);
		dll.add(hero4);
		dll.list();
		System.out.println("修改后");
		HeroDoubleNode hero5 = new HeroDoubleNode(4,"公孙胜","入云龙");
		dll.update(hero5);
		dll.list();
		System.out.println("删除后");
		dll.delete(3);
		dll.list();
	}
}

class DoubleLinkedList{
	//初始化一个头节点,头结点不要动
	private HeroDoubleNode head = new HeroDoubleNode(0, "", "");
	//返回头节点
	public HeroDoubleNode getHead() {
		return head;
	}
	
	//遍历双向链表
	public void list() {
		//判断链表是否为空
		if(head.next == null) {
			System.out.println("链表为空");
			return;
		}
		//
		HeroDoubleNode temp  = head.next;
		while(true) {
			if(temp==null) {
				break;
			}
			//输出节点信息
			System.out.println(temp);
			// 后移
			temp = temp.next;
		}
	}
	
	
	
	//添加节点到双向链表最后
	public void add(HeroDoubleNode heroNode) {
		//因为头结点不能动，因此需要一个辅助遍历
		HeroDoubleNode temp  = head;
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
		heroNode.pre = temp;
		
	}




	
	public void update(HeroDoubleNode newHeroNode) {
		if (head.next == null) {
			System.out.println("链表为空");
			return;
		}
		
		//找到需要修改的节点，根据no编号
		//定义一个辅助变量
		HeroDoubleNode temp = head.next;
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
			System.out.printf("没有找到编号%d的节点，不能修改\n",newHeroNode.no);			
		}
	}

	//删除节点
	//双向链表可以直接找到要删除的节点
	//找到后自我删除
	public void delete(int no) {
		if (head.next==null) {
			System.out.println("链表为空");
			return;
		}
		//找到需要修改的节点，根据no编号
		//定义一个辅助变量
		HeroDoubleNode temp = head.next;//找自己 从第一个，不用找前一个
		boolean flag = false;
		while(true){
			if (temp==null) {
				break; //已经遍历完链表
			}
			if (temp.no==no) {
				flag = true; //找到了
				break;
			}
			temp=temp.next;
		}
		//根据flag判断是否找到要删除的节点
		if (flag) {
			temp.pre.next = temp.next;
			// 最后一个节点删除有问题，空指针异常
			if (temp.next!=null) {
				temp.next.pre = temp.pre;
			}
			
		}else {
			System.out.printf("要删除%d的节点，不存在\n",no);
			
		}
	}		
	
}

//每个对象就是一个节点
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