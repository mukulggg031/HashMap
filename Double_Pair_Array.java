//https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/hashmap-and-heaps/double-pair-array-official/ojquestion

// 1. You are given an array(arr) of integers with even length N.
// 2. You have to tell if it is possible to re-order the given array such that for every i in range [0,N/2)
//    arr[2*i + 1] = 2 * arr[2*i], this condition holds true.

// Test Case:
// 4
// 3 1 3 6
// output:
// false

import java.util.*;
public class Double_Pair_Array {
    public static boolean solution(int[] arr) {
        // write your code here
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int val:arr){
            map.put(val, map.getOrDefault(val, 0) + 1);
        }
        Arrays.sort(arr);
        
        for(int val : arr){
            if(val != 0 && map.containsKey(val) && map.containsKey(2 * val)){
                if(map.getOrDefault(val, 0) > 1){
                    map.put(val, map.getOrDefault(val, 0) - 1);
                }
                else{
                    map.remove(val);
                }
                if(map.getOrDefault(2 * val, 0) > 1){
                    map.put(2 * val, map.getOrDefault(2 * val, 0) - 1);
                }
                else{
                    map.remove(2 * val);
                }
            }
        }
        if(map.size() == 0){
            return true;
        }
        else if(map.size() == 1 && map.containsKey(0)){
            return true;
        }
        else{
            return false;
        }
    }
    
    public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for(int i = 0 ; i < n; i++){
			arr[i] = scn.nextInt();
		}
		System.out.println(solution(arr));
	}
}
