// You are given an array 𝑎 of 𝑛 integers. 
// Count the number of pairs of indices (𝑖,𝑗) such that 𝑖<𝑗 and 𝑎𝑗−𝑎𝑖=𝑗−𝑖.

// Test Case:
// input:
// 6
// 3 5 1 4 6 6
// output: 3

import java.util.*;
public class Same_Difference_codeforces_1520 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < arr.length ; i++){
            arr[i] = sc.nextInt();
        }
              
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0 ; i < arr.length ; i++){
            int diff = arr[i] - i;
            map.put(diff, map.getOrDefault(diff, 0) + 1);
        }
              
        long ans = 0;
        for(int key: map.keySet()){
            long freq = (long)map.get(key);
            long val = (freq * (freq - 1) / 2);
            ans += val;
        }
        System.out.println(ans);      
    }
}
