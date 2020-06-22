package com.tzg.algorithm5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class GreedyAlgorithm {
    public static void main(String[] args) {
        HashMap<String, HashSet<String>> broadcasts = new HashMap<>();
        HashSet<String> set1 = new HashSet<>();
        set1.add("北京");
        set1.add("上海");
        set1.add("天津");
        HashSet<String> set2 = new HashSet<>();
        set2.add("广州");
        set2.add("北京");
        set2.add("深圳");
        HashSet<String> set3 = new HashSet<>();
        set3.add("成都");
        set3.add("上海");
        set3.add("杭州");
        HashSet<String> set4 = new HashSet<>();
        set4.add("上海");
        set4.add("天津");
        HashSet<String> set5 = new HashSet<>();
        set5.add("杭州");
        set5.add("大连");


        broadcasts.put("k1",set1);
        broadcasts.put("k2",set2);
        broadcasts.put("k3",set3);
        broadcasts.put("k4",set4);
        broadcasts.put("k5",set5);


        HashSet<String> allAreas = new HashSet<>();
        allAreas.add("北京");
        allAreas.add("上海");
        allAreas.add("天津");
        allAreas.add("广州");
        allAreas.add("深圳");
        allAreas.add("成都");
        allAreas.add("杭州");
        allAreas.add("大连");

        ArrayList<String> selected = new ArrayList<>();
        HashSet<String> tempSet = new HashSet<>();
        String maxKey;

        while (allAreas.size()!=0){
            maxKey = null;
            for (String key : broadcasts.keySet()) {
                tempSet.clear();
                HashSet<String> areas = broadcasts.get(key);
                tempSet.addAll(areas);
                //求出tempSet 和allAreas 集合的交集, 交集会赋给 tempSet
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

        System.out.println("得到的选择结果是" + selected);
    }
}
