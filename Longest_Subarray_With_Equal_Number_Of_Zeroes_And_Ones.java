//https://www.geeksforgeeks.org/count-subarrays-equal-number-1s-0s/

// 1. You are given an array that contains only 0s and 1s.
// 2. You have to find length of the longest subarray with equal number of 0s and 1s.

// Input:
// 6
// 0 1 1 0 1 1
// output:
// 4

import java.util.*;
public class Longest_Subarray_With_Equal_Number_Of_Zeroes_And_Ones {
    public static int solution(int[] arr) {
        // write your code here
        int ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        
        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i] == 0){
                sum -= 1;
            }
            else if(arr[i] == 1){
                sum += 1;
            }
            if(map.containsKey(sum)){
                int len = 0;
                len = i - map.get(sum);
                if(len > ans){
                    ans = len;
                }
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
        System.out.println(solution(arr));
    }
}
