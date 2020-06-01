package com.tzg.recursion;

public class Queens8 {
    private int queensNum = 8;
    private int[] queenMap = new int[queensNum];
    static int count = 0;
    public static void main(String[] args) {
        Queens8 q8 = new Queens8();
        q8.check(0);
        System.out.printf("一共有%d解法", count);
    }
    private void check(int n){
        if (n==queensNum){
            printMap();
            return;
        }
        for (int i = 0; i < queensNum; i++) {
            queenMap[n]=i;
            if (valid(n)){
                check(n+1);
            }
        }
    }

    private boolean valid(int n){
        for (int i = 0; i < n; i++) {
            if (queenMap[i]==queenMap[n]||Math.abs(n-i) == Math.abs(queenMap[n]-queenMap[i])){
                return false;
            }
        }
        return true;
    }

    private void printMap(){
        count++;
        for (int i = 0; i < queenMap.length; i++) {
            System.out.print(queenMap[i]+"");
        }
        System.out.println();
    }
}
