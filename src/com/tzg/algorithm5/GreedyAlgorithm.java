package com.tzg.algorithm5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class GreedyAlgorithm {
    public static void main(String[] args) {
        HashMap<String, HashSet<String>> broadcasts = new HashMap<>();
        HashSet<String> set1 = new HashSet<>();
        set1.add("����");
        set1.add("�Ϻ�");
        set1.add("���");
        HashSet<String> set2 = new HashSet<>();
        set2.add("����");
        set2.add("����");
        set2.add("����");
        HashSet<String> set3 = new HashSet<>();
        set3.add("�ɶ�");
        set3.add("�Ϻ�");
        set3.add("����");
        HashSet<String> set4 = new HashSet<>();
        set4.add("�Ϻ�");
        set4.add("���");
        HashSet<String> set5 = new HashSet<>();
        set5.add("����");
        set5.add("����");


        broadcasts.put("k1",set1);
        broadcasts.put("k2",set2);
        broadcasts.put("k3",set3);
        broadcasts.put("k4",set4);
        broadcasts.put("k5",set5);


        HashSet<String> allAreas = new HashSet<>();
        allAreas.add("����");
        allAreas.add("�Ϻ�");
        allAreas.add("���");
        allAreas.add("����");
        allAreas.add("����");
        allAreas.add("�ɶ�");
        allAreas.add("����");
        allAreas.add("����");

        ArrayList<String> selected = new ArrayList<>();
        HashSet<String> tempSet = new HashSet<>();
        String maxKey;

        while (allAreas.size()!=0){
            maxKey = null;
            for (String key : broadcasts.keySet()) {
                tempSet.clear();
                HashSet<String> areas = broadcasts.get(key);
                tempSet.addAll(areas);
                //���tempSet ��allAreas ���ϵĽ���, �����ḳ�� tempSet
                tempSet.retainAll(allAreas);
                if (tempSet.size()>0 && (maxKey == null || tempSet.size()>broadcasts.get(maxKey).size())){
                    maxKey = key;
                }
            }

            if (maxKey!=null){
                selected.add(maxKey);
                allAreas.removeAll(broadcasts.get(maxKey));
            }
        }

        System.out.println("�õ���ѡ������" + selected);
    }
}
