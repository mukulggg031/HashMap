//https://practice.geeksforgeeks.org/problems/count-pairs-in-array-divisible-by-k/1/

// Given an array A[] and positive integer K, 
// the task is to count total number of pairs in the array 
// whose sum is divisible by K.

// Test Case:
// Input : 
// A[] = {2, 2, 1, 7, 5, 3}, K = 4
// Output : 5

import java.util.*;
public class Count_pairs_in_array_whose_sum_divisible_by_K {
    public static int countKdivPairs(int arr[], int n, int k){
        //code here
        if(arr.length == 1){
            return 1;
        }
        int[] freq = new int[k];
        for(int i = 0 ; i < n ; i++){
            int rem = arr[i] % k;
            freq[rem]++;
        }
        int sum = freq[0] * (freq[0] - 1) / 2;
        
        for (int i = 1; i <= k / 2 && i != (k - i); i++){
            sum += freq[i] * freq[k - i];
        }
            
        if (k % 2 == 0){
            sum += (freq[k / 2] * (freq[k / 2] - 1) / 2);
        }
        return sum;
    }
}
