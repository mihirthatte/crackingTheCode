/* You are given N sticks, where the length of each stick is a positive integer. 
 * A cut operation is performed on the sticks such that all of them are reduced by the length of the smallest stick 
 * Suppose we have six sticks of the following lengths:
	5 4 4 2 2 8
	Then, in one cut operation we make a cut of length 2 from each of the six sticks. For the next cut operation four sticks are left (of non-zero length), whose lengths are the following: 
	3 2 2 6
 * The above step is repeated until no sticks are left.
 * Given the length of N sticks, print the number of sticks that are left before each subsequent cut operations.
 */




//Solution -- 
/* Brute force approach - 
	Find min length of a stcik from given array, reduce each of the array element by 'min' value and print number of sticks which have been cut down in the process. 
	Algorithm - 
	while(sticksleft(arr){
		find min from arr;
		for(i = 0 ; i<n; i++){
			count = 0;
			if(arr[i] != 0){
				arr[i] = arr[i] - min;
				count++;
			}
		}
		print "count";
	}
	Time complexity - n^2. 

 * Improved version - 
  	Sort the array in non-decreasing order.
 	from left to right, if element at i is not equal to element at i+1, then print n - (i+1);
 	Time complexity - nlogn
*/
package test;
import java.util.*;

public class Cut_the_Sticks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int a[] = new int[n];
		for(int i =0; i<n; i++)
			a[i] = scan.nextInt();
		Arrays.sort(a);
		
		System.out.println(n);
		for(int i = 0 ; i<n-1; i++)
			if(a[i] != a[i+1]) System.out.println(n-(i+1));
		
		scan.close();
	}

}
