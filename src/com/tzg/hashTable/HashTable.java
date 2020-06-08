package com.tzg.hashTable;

import java.util.Scanner;

public class HashTable {
    public static void main(String[] args) {
        HashTab hashTab = new HashTab(7);
        Scanner scanner = new Scanner(System.in);
        String key = "";
        while (true){
            System.out.println("add:  ��ӹ�Ա");
            System.out.println("list: ��ʾ��Ա");
            System.out.println("find: ���ҹ�Ա");
            System.out.println("exit: �˳�ϵͳ");
            key = scanner.next();
            switch (key){
                case "add":
                    System.out.println("����id");
                    int id = scanner.nextInt();
                    System.out.println("��������");
                    String name = scanner.next();
                    Emp emp = new Emp(id,name);
                    hashTab.add(emp);
                    break;
                case "list":
                    hashTab.list();
                    break;
                case "find":
                    System.out.println("����id");
                    id = scanner.nextInt();
                    hashTab.findEmpById(id);
                    break;
                case "exit":
                    scanner.close();
                    System.exit(0);
                    break;
            }
        }
    }
}

class HashTab{
    private EmpLinkedList[] empLinkedListsArray;
    private int size;
    public HashTab(int size){
        this.size = size;
        empLinkedListsArray = new EmpLinkedList[size];
        for (int i = 0; i < size; i++) {
            empLinkedListsArray[i] = new EmpLinkedList();
        }
    }

    public int hashFunction(int id){
        return id % size;
    }


    public void add(Emp emp){
        int empLinkedListPlace = hashFunction(emp.id);
        empLinkedListsArray[empLinkedListPlace].add(emp);
    }

    public void list(){
        for (int i = 0; i < size; i++) {
            empLinkedListsArray[i].list(i);
        }
    }

    public void findEmpById(int id) {
        int empLinkedListPlace = hashFunction(id);
        Emp emp = empLinkedListsArray[empLinkedListPlace].findEmpById(id);
        if (emp!=null){
            System.out.printf("�ڵ�%d���������ҵ� ��Ա id = %d\n", (empLinkedListPlace + 1), id);
        }else{
            System.out.println("�ڹ�ϣ���У�û���ҵ��ù�Ա~");
        }
    }
}


class Emp{
    public int id;
    public String name;
    public Emp next;
    public Emp(int id,String name){
        super();
        this.id = id ;
        this.name = name;
    }
}

class EmpLinkedList{
    private Emp head;
    public void add(Emp emp){
        if (head==null){
            head=emp;
            return;
        }
        Emp curEmp = head;
        while (true){
            if (curEmp.next==null){
                break;
            }
            curEmp = curEmp.next;
        }
        curEmp.next = emp;
    }
    public void list(int no){
        if (head==null){
            System.out.println("��"+(no+1)+"������Ϊ��");
            return;
        }

        Emp curEmp = head;
        while (true){
            System.out.printf(" => id=%d name=%s\t", curEmp.id, curEmp.name);
            if (curEmp.next==null){
                break;
            }
            curEmp = curEmp.next;
        }
        System.out.println();
    }
    public Emp findEmpById(int id){
        if (head==null){
            System.out.println("����Ϊ��");
            return null;
        }
        Emp curEmp = head;
        while (true){
            if (curEmp.id==id){
                break;
            }
            if (curEmp.next==null){
                curEmp =null;
                break;
            }
            curEmp = curEmp.next;
        }
        return curEmp;
    }
}
