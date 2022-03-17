//no explanation understand on your own;

import java.util.*;
public class Longest_Substring_with_sum_equalsTo_k {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < arr.length ; i++){
            arr[i] = sc.nextInt();
        }
        int target = sc.nextInt();
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
            }
            map.put(sum, i);
        }
    }
}
