//https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/hashmap-and-heaps/longest-subarray-with-equal-number-of-0s-1s-and-2s-official/ojquestion

// 1. You are given an array that contains only 0s, 1s, and 2s.
// 2. You have to find length of the longest subarray with equal number of 0s, 1s, and 2s.

// import:
// 7
// 0 1 0 2 0 1 0
// output:
// 3

import java.util.*;
public class Longest_Subarray_With_Equal_Number_Of_0s_1s_And_2s {
    public static int solution(int[] arr, int target) {
        // write your code here
        int ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        for(int i = 0 ; i < arr.length ; i++){
            sum += arr[i];
            if(map.containsKey(sum - target)){
                int idx = map.get(sum - target);
                int len = i - idx;
                if(len > ans){
                    ans = len;
                }
                map.put(sum, i);
            }
            else{
                map.put(sum, i);
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
        int target = scn.nextInt();
        System.out.println(solution(arr, target));
    }
}
