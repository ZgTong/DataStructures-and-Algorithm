package com.tzg.recursion;

public class Maze {
    public static void main(String[] args) {
        int[][] map = new int[8][7];
        //����ͼ  ������������ǽ
        for (int i = 0; i < 7; i++) {
            map[0][i]=1;
            map[7][i]=1;
        }

        for (int i = 0; i < 8; i++) {
            map[i][0]=1;
            map[i][6]=1;
        }
        map[3][1] = 1;
        map[3][2] = 1;
        //��·
//        map[1][2] = 1;
//        map[2][2] = 1;
        System.out.println("��ͼ�����:");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j]+"  ");
            }
            System.out.println();
        }
        //����һ��
        findWay(map,1,1);
        System.out.println();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j]+"  ");
            }
            System.out.println();
        }
    }

    /**
     * ʹ�õݹ��������С����·,Լ��0λδ�߹���1��ǽ��2��·ͨ�����ߣ�3�Ǳ�ʾ�õ��Ѿ��߹� �����߲�ͨ
     * @param map �����Թ�
     * @param i ���ĸ�λ�ÿ�ʼ
     * @param j
     * @return
     */
    public static boolean findWay(int[][] map , int i, int j ){
        if (map[6][5]==2){
            //�����յ�
            return true;
        }else {
            if (map[i][j]==0){ //��ǰ�ĵ㻹û���߹�
                //�ô�������
                map[i][j] = 2;
                //���Զ�λ�¡��ҡ��ϡ���
                if (findWay(map,i+1,j)){
                    return  true;
                }else if (findWay(map,i,j+1)) {
                    return true;
                }else if (findWay(map,i-1,j)) {
                    return true;
                }else if (findWay(map,i,j-1)) {
                    return true;
                }else{
                    map[i][j] = 3;
                    return  false;
                }
            }else { // ���map[i][j] != 0 , ������ 1�� 2�� 3,��������
                return false;
            }
        }
    }
}
