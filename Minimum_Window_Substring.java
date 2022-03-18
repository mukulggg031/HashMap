// Leetcode 76
// Given two strings s and t of lengths m and n respectively, 
// return the minimum window substring of s such that every character in t 
// (including duplicates) is included in the window. If there is no such substring, 
// return the empty string "".

// The testcases will be generated such that the answer is unique.

// A substring is a contiguous sequence of characters within the string.

// TestCase:
// Input: s = "ADOBECODEBANC", t = "ABC"
// Output: "BANC"
// Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.

import java.util.*;
public class Minimum_Window_Substring {
    public String minWindow(String s1, String s2) {
        String ans = "";
        
        HashMap<Character, Integer> map2 = new HashMap<>();
        for(int i = 0 ; i < s2.length() ; i++){
            char ch = s2.charAt(i);
            map2.put(ch, map2.getOrDefault(ch, 0) + 1);
        }
        
        int mct = 0;
        int dmct = s2.length();
        HashMap<Character, Integer> map1 = new HashMap<>();
        int i = -1;
        int j = -1;
        
        while(true){
            boolean f1 = false;
            boolean f2 = false;
            
            //aquire
            while(i < s1.length() - 1 && mct < dmct){
                i++;
                char ch = s1.charAt(i);
                map1.put(ch, map1.getOrDefault(ch, 0) + 1);
                
                if(map1.getOrDefault(ch, 0) <= map2.getOrDefault(ch, 0)){
                    mct++;
                }
                f1 = true;
            }
            
            //collect answer and release
            while(j < i && mct == dmct){
                String pans = s1.substring(j + 1, i + 1);
                if(ans.length() == 0 || pans.length() < ans.length()){
                    ans = pans;
                }
                j++;
                char ch = s1.charAt(j);
                if(map1.get(ch) == 1){
                    map1.remove(ch);
                }
                else{
                    map1.put(ch, map1.get(ch) - 1);
                }
                if(map1.getOrDefault(ch, 0) < map2.getOrDefault(ch, 0)){
                    mct--;
                }
                f2 = true;
            }
            if(f1 == false && f2 == false){
                break;
            }
        }  
        return ans;
    }
}
