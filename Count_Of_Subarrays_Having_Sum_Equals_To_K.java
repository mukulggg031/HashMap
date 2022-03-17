// 1. You are given an array of integers(arr) and a number K.
// 2. You have to find the count of subarrays whose sum equals k.

// Test Case:
// input:
// 3
// 1 1 1
// 2
// output:
// 2

import java.util.*;
public class Count_Of_Subarrays_Having_Sum_Equals_To_K {
    public static int solution(int[] arr, int target){
		// write your code here
		int ans = 0;
		HashMap<Integer, Integer> map = new HashMap<>();
		int sum = 0;
		map.put(sum, 1);
		for(int i = 0 ; i < arr.length ; i++){
		    sum += arr[i];
		    if(map.containsKey(sum - target)){
		        ans += map.get(sum - target);
		    }
		    
		    if(map.containsKey(sum)){
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
        for(int i = 0 ; i < n; i++){
            arr[i] = scn.nextInt();
        }
        int target = scn.nextInt();
        System.out.println(solution(arr,target));
	}
}
