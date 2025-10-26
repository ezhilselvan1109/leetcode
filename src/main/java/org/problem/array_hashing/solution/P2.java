package org.problem.array_hashing.solution;

public class P2 {
    public boolean isAnagram(String s, String t) {
        if(s.length() !=t.length()) return false;
        int[] count = new int[26];
        for(int i=0;i<s.length();i++){
            count[s.charAt(i)-'a']++;
            count[t.charAt(i)-'a']--;
        }
        for(int c:count){
            if(c!=0) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        String s = "anagram", t = "nagaram";
        System.out.println(new P2().isAnagram(s, t));
    }
}
