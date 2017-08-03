/* We define a harmonious array is an array where the difference between its maximum value and its minimum value is exactly 1.
 * Now, given an integer array, you need to find the length of its longest harmonious subsequence among all its possible subsequences.
 * 
 * Example - 
 * 	Input: [1,3,2,2,5,2,3,7]
	Output: 5
	Explanation: The longest harmonious subsequence is [3,2,2,2,3].
 */



package test;
import java.util.*;
public class Longest_Harmonious_Seq {
	public static int findLHS(int[] nums) {
        ArrayList<Integer> out = new ArrayList<Integer>();
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for(int n : nums){
           hm.put(n, hm.getOrDefault(n,0)+1);
        }
        int maxLength =0;
        for(int key : hm.keySet()){
            if(hm.containsKey(key+1)){
                maxLength = Math.max(maxLength, (hm.get(key) + hm.get(key+1)) );
            }
        }
        return maxLength;       
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,3,2,2,5,2,3,7};
		System.out.println(findLHS(nums));
	}

}
