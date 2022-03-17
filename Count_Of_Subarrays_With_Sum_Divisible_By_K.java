//https://www.geeksforgeeks.org/count-sub-arrays-sum-divisible-k/

// 1. You are given an array of integers(arr) and a number K.
// 2. You have to find the count of subarrays whose sum is divisible by K.

// Test Case:
// Input:
// 6
// 2 7 6 1 4 5
// 3
// output:
// 5

import java.util.*;
public class Count_Of_Subarrays_With_Sum_Divisible_By_K {
    public static int solution(int[] arr, int k) {
        // write your code here
        int ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        map.put(sum, 1);
        for(int i = 0 ; i < arr.length ; i++){
            sum += arr[i];
            int rem = sum % k;
            if(rem < 0){
                rem += k;
            }
            
            if(map.containsKey(rem)){
                ans += map.get(rem);
                map.put(rem, map.get(rem) + 1);
            }
            else{
                map.put(rem, 1);
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
        int k = scn.nextInt();
        System.out.println(solution(arr, k));
    }
}
