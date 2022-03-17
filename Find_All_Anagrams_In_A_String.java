//https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/hashmap-and-heaps/find-all-anagrams-in-a-string-official/ojquestion

// 1. You are given two strings s1 and s2.
// 2. You have to find the count of s2's anagrams that are present in s1.
// 3. Also, you have to print the start indices of such anagrams in s1.

// Note -> Both s1 ad s2 consist of lowercase English letters only.
// Test Case:
// cbaebabacd
// abc
// output:
// 2
// 0 6 

import java.util.*;
public class Find_All_Anagrams_In_A_String {
    public static void findAnagrams(String s, String p) {
        // write your code here
        HashMap<Character, Integer> map2 = new HashMap<>();
        for(int i = 0 ; i < p.length() ; i++){
            char ch = p.charAt(i);
            map2.put(ch, map2.getOrDefault(ch, 0) + 1);
        }
        
        HashMap<Character, Integer> map1 = new HashMap<>();
        for(int i = 0 ; i < p.length() ; i++){
            char ch = s.charAt(i);
            map1.put(ch, map1.getOrDefault(ch, 0) + 1);
        }
        
        ArrayList<Integer> res = new ArrayList<>();
        if(map1.equals(map2)){
            res.add(0);
        }
        
        int i = p.length();
        int j = 0;
        
        while(i < s.length()){
            char chi = s.charAt(i);
            map1.put(chi, map1.getOrDefault(chi, 0) + 1);
            
            char chj = s.charAt(j);
            if(map1.get(chj) == 1){
                map1.remove(chj);
            }
            else{
                map1.put(chj, map1.get(chj) - 1);
            }
            
            if(map1.equals(map2)){
                res.add(j + 1);
            }
            i++;
            j++;
            
        }
        System.out.println(res.size());
        for(int val: res){
            System.out.print(val + " ");
        }
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String s = scn.next();
		String p = scn.next();
		findAnagrams(s, p);
	}
}
