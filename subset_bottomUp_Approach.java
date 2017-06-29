package test;
import java.util.*;
/* Cre­ate an binary array of the same size as the given array.
 * Now for every inte­ger we have two options, whether to select it or ignore it.
 * Now if we select it, we will put 1 in the boolean array at the cor­re­spond­ing index or if we ignore it, put 0 at that index. */

class subset_bottomUp_Approach{

	static void subsets(int set[], int b[], int index){
		if(index == set.length-1){ //base condition
			b[index] = 0; //either you do not select this digit
			display(set,b);
			b[index] = 1; //or you select this digit
			display(set,b);
			return;
		}
		else{
			b[index] = 0; //either you do not select this digit
			subsets(set,b,index+1);
			b[index] = 1; //or you select this digit
			subsets(set,b,index+1);
		}	
		
	}
	static void display(int set[], int b[]){
		boolean isEmpty = true;
		System.out.print("{ ");
		for(int i =0; i<set.length;i++){
			if(b[i]==1){
				System.out.print(set[i]+" ");
				isEmpty = false;
			}
		}
		System.out.print("}");
		
	}
	
	public static void main(String[] args) {
		int set[]={1,2,3};
		int b[] = new int[set.length];
		subsets(set,b,0);
		
	}
	
	
}
