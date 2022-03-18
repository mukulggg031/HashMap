//https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/hashmap-and-heaps/find-anagram-mappings-official/ojquestion
// 1. You are given two integer arrays(A and B), where B is an anagram of A.
// 2. B is an anagram of A means B is made by randomizing the order of the elements in A.
// 3. For every element in A, you have to print the index of that element in B.

// Note -> Both arrays(A and B) are of the same length.

// TestCase:
// 6
// 1 2 3 4 5 2
// 4 3 2 1 5 2
// output:
// 3 2 1 0 4 5 


import java.util.*;
public class Find_Anagram_Mappings {
    public static class Pair{
        int idx = 0;
        ArrayList<Integer> list = new ArrayList<>();
    }
    
	public static int[] anagramMappings(int[] arr1, int[] arr2) {
		// write your code here
        HashMap<Integer, Pair> map = new HashMap<>();
        int[] ans = new int[arr1.length];
        for(int i = 0 ; i < arr2.length ; i++){
            if(map.containsKey(arr2[i])){
                Pair p = map.get(arr2[i]);
                p.list.add(i);
            }
            else{
                Pair p = new Pair();
                p.list.add(i);
                map.put(arr2[i], p);
            }
        }
        for(int i = 0 ; i < arr1.length ; i++){
            Pair p = map.get(arr1[i]);
            ans[i] = p.list.get(p.idx);
            p.idx++;
        }
        return ans;
		
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] a = new int[n];
		int[] b = new int[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = s.nextInt();
		}
		for (int j = 0; j < b.length; j++) {
			b[j] = s.nextInt();
		}
		int[] res = anagramMappings(a, b);
		for (int j = 0; j < res.length; j++) {
			System.out.print(res[j] + " ");
		}
	}
}
