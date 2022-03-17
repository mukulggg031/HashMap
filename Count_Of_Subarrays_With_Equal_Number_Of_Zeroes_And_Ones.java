//https://www.geeksforgeeks.org/count-subarrays-equal-number-1s-0s/

// 1. You are given an array that contains only 0s and 1s.
// 2. You have to find the count of subarrays with equal number of 0s and 1s.

// Test Case:
// input:
// 6
// 0 1 1 0 1 1
// output:
// 4

import java.util.*;
public class Count_Of_Subarrays_With_Equal_Number_Of_Zeroes_And_Ones{
    public static int solution(int[] arr) {
        // write your code here
        int ans = 0;
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for(int i = 0 ; i < arr.length ; i++){
            sum += (arr[i] == 0? -1 : 1);
            
            if(map.containsKey(sum)){
                ans += map.get(sum);
                map.put(sum, map.get(sum) + 1);
            }
            else{
                map.put(sum, 1);
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