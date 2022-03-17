//https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/hashmap-and-heaps/check-arithmetic-sequence-official/ojquestion

// 1. You are given an array(arr) of integers.
// 2. You have to find if the elements of the given array can be arranged to form an arithmetic progression.
// 3. Arithmetic progression is defined as a sequence of numbers where the difference between any two consecutive numbers is the same. 

// Note -> Try to solve this in linear time complexity.

// Test Case:
// 3
// 3 5 1
// output:
// true

import java.util.*;
public class Check_Arithmetic_Sequence {
    public static boolean solution(int[] arr) {
        // write your code here
        HashSet<Integer> set = new HashSet<>();
        int min = Integer.MAX_VALUE;
        int smin = Integer.MAX_VALUE;
        for(int val : arr){
            set.add(val);
            if(val < min){
                smin = min;
                min = val;
            }
            else if(val < smin){
                smin = val;
            }
        }
            
        int d = smin - min;
        for(int i = 0 ; i < arr.length ; i++){
            if(set.contains(min)){
                min = min + d;
            }
            else{
                return false;
            }
        }
        return true;
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
