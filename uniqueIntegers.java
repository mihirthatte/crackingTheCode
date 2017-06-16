/* In this problem, you are given N integers. You need to find the maximum number of unique integers among all the possible contiguous sub arrays of size M */

package test;
import java.util.*;

public class uniqueIntegers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
        Deque<Integer> deque = new ArrayDeque<Integer>();
        Set<Integer> mySet = new HashSet<Integer>();
        int n = 6;
        int m = 3;
        int maxCount=-1;
        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            deque.add(num);
            mySet.add(num);
            if(deque.size()==m){
                int count = mySet.size();
                if(count > maxCount) maxCount = count;
                int first = deque.remove();
                if(!deque.contains(first)) mySet.remove(first); //If the removed value is not present in queue anymore, remove that value from Set as well.                
            }
        }
        System.out.println(maxCount);
    }

	}

