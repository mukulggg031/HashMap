//https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/hashmap-and-heaps/number-of-employees-under-every-manager-official/ojquestion

// 1. You are given number N and 2*N number of strings that contains mapping of the employee and his manager.
// 2. An employee directly reports to only one manager. 
// 3. All managers are employees but the reverse is not true.
// 4. An employee reporting to himself is the CEO of the company.
// 5. You have to find the number of employees under each manager in the hierarchy not just their direct reports.

// Test Case:
// input:
// 6
// A C
// B C
// C F
// D E
// E F
// F F

// output:
// A 0
// B 0
// C 2
// D 0
// E 1
// F 5

import java.io.*;
import java.util.*;

public class Number_Of_Employee_Under_Every_Manager {

  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int n = Integer.parseInt(scn.nextLine());
    
    //write your code here
    HashMap<String, ArrayList<String>> tree = new HashMap<>();
    String root = "";
    
    for(int i = 0 ; i < n ; i++){
        String[] parts = scn.nextLine().split(" ");
        
        if(parts[0].equals(parts[1])){
            root = parts[0];
        }
        
        else if(tree.containsKey(parts[1])){
            tree.get(parts[1]).add(parts[0]);
        }
        else{
            tree.put(parts[1], new ArrayList<>());
            tree.get(parts[1]).add(parts[0]);
        }
    }
    
    HashMap<String, Integer> res = new HashMap<>();
    size(root, tree, res);
    
    for(String key: res.keySet()){
        System.out.println(key + " " + res.get(key));
    }
  }
  
  public static int size(String root, HashMap<String, ArrayList<String>> tree, HashMap<String, Integer> res){
      if(tree.containsKey(root) == false){
          res.put(root, 0);
          return 1;
      }
      
      int sz = 0;
      for(String child: tree.get(root)){
          int cs = size(child, tree, res);
          sz += cs;
      }
      
      res.put(root, sz);
      return sz + 1;
  }
}