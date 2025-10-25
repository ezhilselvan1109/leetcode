package org.problem.trees.solution;

import java.util.HashMap;
import java.util.Map;

public class P3 {
}
class Solution {
    public int nextBeautifulNumber(int n) {
        n+=1;
        while(true){
            HashMap<Integer,Integer> map=new HashMap<>();
            int num=n;
            while(n>0){
                int temp=n%10;
                map.put(temp,map.getOrDefault(temp,0)+1);
                n/=10;
            }
            boolean notFound=false;
            for(Map.Entry<Integer,Integer> e:map.entrySet()){
                if(e.getKey()!=e.getValue()){
                    notFound=true;
                    break;
                }
            }
            n=num+1;
            if(!notFound)break;
        }
        return n;
    }
    public static void main(String[] args) {
        Solution s=new Solution();
        System.out.println(s.nextBeautifulNumber(1000));
    }
}