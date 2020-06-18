package com.tzg.algorithm2;

public class HanoiTower {
    public static void main(String[] args) {
        hanoiTower(5,'A','B','C');
    }

    public static void hanoiTower(int num,char a, char b, char c){
        if (num<=0){
            System.out.println("��������");
        }else if (num==1){
            System.out.println("��1�����Ӵ�"+a+"->"+c);
        } else {//num>1
            //���ǿ��Կ����������� 1.���±ߵ�һ���� 2. �����������
            //1. �Ȱ� ������������� A->B�� �ƶ����̻�ʹ�õ� c
            hanoiTower(num-1,a,c,b);
            //2. �����±ߵ��� A->C
            System.out.println("��" + num + "���̴� " + a + "->" + c);
            //3. ��B���������� �� B->C , �ƶ�����ʹ�õ� a��
            hanoiTower(num-1,b,a,c);
        }
    }
}
