// In a deck of cards, each card has an integer written on it.

// Return true if and only if you can choose X >= 2 such that it is possible to split the entire deck into 1 or more groups of cards, where:

// Each group has exactly X cards.
// All the cards in each group have the same integer.

// Test Case:
// Input: deck = [1,2,3,4,4,3,2,1]
// Output: true
// Explanation: Possible partition [1,1],[2,2],[3,3],[4,4].


import java.util.*;
public class Leetcode914_X_of_a_Kind_in_a_Deck_of_Cards {
    public boolean hasGroupsSizeX(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int val : arr){
            map.put(val, map.getOrDefault(val, 0) + 1);
        }
        int gcd = 1;
        int counter = 0;
        for(int key : map.keySet()){
           if(counter == 0){
               gcd = map.get(key);
           } 
            else{
                int num = map.get(key);
                gcd = getGCD(num, gcd);
            }
            counter++;
        }
        return gcd >= 2;
    }
    
    public int getGCD(int n1, int n2){
        while(n1 % n2 != 0){
            int rem = n1 % n2;
            n1 = n2;
            n2 = rem;
        }
        return n2;
    }
}
