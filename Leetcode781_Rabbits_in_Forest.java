// There is a forest with an unknown number of rabbits. 
// We asked n rabbits "How many rabbits have the same color as you?" 
// and collected the answers in an integer array answers where answers[i] is 
// the answer of the ith rabbit.
// Given the array answers, return the minimum number of rabbits that could be in the forest.

// Test Case:
// Input: answers = [1,1,2]
// Output: 5

import java.util.*;
public class Leetcode781_Rabbits_in_Forest {
    public int numRabbits(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for(int val : arr){
            map.put(val, map.getOrDefault(val, 0) + 1);
        }
        
        for(int key : map.keySet()){
            int gSize = key + 1;
            int reportees = map.get(key);
            int noOfgroups = (int)Math.ceil(reportees * 1.0 /gSize * 1.0);
            ans += gSize * noOfgroups;
        }
        return ans;
    }
}
