/*Given an integer array with even length, where different numbers in this array represent different kinds of candies. 
 * Each number means one candy of the corresponding kind. 
 * You need to distribute these candies equally in number to brother and sister. 
 * Return the maximum number of kinds of candies the sister could gain.
 * 
 * Input: candies = [1,1,2,2,3,3]
Output: 3
Explanation:
There are three different kinds of candies (1, 2 and 3), and two candies for each kind.
Optimal distribution: The sister has candies [1,2,3] and the brother has candies [1,2,3], too. 
The sister has three different kinds of candies. 

 */


package test;
import java.util.*;
public class hashmap {

	static HashMap<Integer, Integer> createHM(int a[]){
		HashMap<Integer, Integer> hm1 = new HashMap<Integer, Integer>();
		for(int i :a){
			if(hm1.get(i) == null)
				hm1.put(i, 1);
			else
				hm1.put(i, hm1.get(i)+1);
		}
		return hm1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int candies[] = {1,1,1,1,1,1,1,2,2,3,3,3,4,4,4,5};
		HashMap<Integer, Integer> totalCandy = createHM(candies);
		int total = candies.length;
		ArrayList<Integer> brother = new ArrayList<Integer>();
		ArrayList<Integer> sister = new ArrayList<Integer>();
		int index=0;
		Iterator it = totalCandy.entrySet().iterator();
		/*while(it.hasNext()){
			Map.Entry pair = (Map.Entry)it.next();
			System.out.println(pair.getKey()+" --"+pair.getValue());
		}*/
		
		while(brother.size() < total/2){
			if(it.hasNext()){
			Map.Entry pair = (Map.Entry)it.next();
			int val = (Integer)pair.getValue();
			while(val>1){
				if(brother.size() == total/2)
					break;
				brother.add((Integer)pair.getKey());
				val--;
			}
			while(val-- > 0) sister.add((Integer)pair.getKey());
			}
		}
		while(it.hasNext()){
			Map.Entry pair = (Map.Entry)it.next();
			int val = (Integer)pair.getValue();
			while(val>0){
				sister.add((Integer)pair.getKey());
				val--;
			}
		}
		System.out.println(brother);
		System.out.println(sister); 
		Set<Integer> hs = new HashSet<Integer>();
		for(int a: sister){
			hs.add(a);
		}
		System.out.println(hs.size());
	}

}
