/*
 * Suppose Andy and Doris want to choose a restaurant for dinner, and they both have a list of favorite restaurants represented by strings.
 * You need to help them find out their common interest with the least list index sum. 
 * If there is a choice tie between answers, output all of them with no order requirement. You could assume there always exists an answer
 * 
 * Example - 
 * Input:
	["Shogun", "Tapioca Express", "Burger King", "KFC"]
	["KFC", "Shogun", "Burger King"]
	Output: ["Shogun"]
	Explanation: The restaurant they both like and have the least index sum is "Shogun" with index sum 1 (0+1)
 */


package test;
import java.util.*;
public class Minimum_Index_of_Two_Lists {
	public static void main(String[] args) {
		String[] list1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
		String[] list2 = {"KFC", "Shogun", "Burger King"};
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
	    for(int i =0; i< list1.length; i++){
	        hm.put(list1[i],i);
	    }
	    ArrayList<String> out = new ArrayList<String>();
	    int sum = Integer.MAX_VALUE;
	    for(int i =0; i< list2.length; i++){
			Integer index = hm.get(list2[i]);
			if(index != null && index + i <= sum){
			   if(index+i < sum){
				   out = new ArrayList<String>();
			   }
			   out.add(list2[i]);
			   sum = index+i;
			}
	    }
	    //return out.toArray(new String[out.size()]);
	    System.out.println(out);
	  }
}
