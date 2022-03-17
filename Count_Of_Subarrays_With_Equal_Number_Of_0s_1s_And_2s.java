//https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/hashmap-and-heaps/count-of-subarrays-with-equal-number-of-0s-1s-and-2s-official/ojquestion

// 1. You are given an array that contains only 0s, 1s, and 2s.
// 2. You have to find the count of subarrays with equal number of 0s, 1s, and 2s.

// Test Case:
// 7
// 0 1 0 2 0 1 0
// output:
// 2


import java.util.*;
public class Count_Of_Subarrays_With_Equal_Number_Of_0s_1s_And_2s {
    public static int solution(int[] arr) {
        // write your code here
        int ans = 0;
        int c0 = 0;
        int c1 = 0;
        int c2 = 0;
        String key = (c1 - c0) + "#" + (c2 - c1);
        HashMap<String, Integer> map = new HashMap<>();
        map.put(key, 1);
        
        for(int val: arr){
            if(val == 0){
                c0++;
            }
            else if(val == 1){
                c1++;
            }
            else{
                c2++;
            }
            key = (c1 - c0) + "#" + (c2 - c1);
            if(map.containsKey(key)){
                ans += map.get(key);
                map.put(key, map.get(key) + 1);
            }
            else{
                map.put(key, 1);
            }
        }
        return ans;
    }
    
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        System.out.println(solution(arr));
    }
}
