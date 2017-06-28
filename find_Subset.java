// Extracts all subsets of the given set
	/*
	 * 
	 * This method uses a recursive algorithm to find the subsets.
	 * 
	 * Suppose we want to extract the subsets of
	 * 
	 * A = {a, b, c, ...}
	 * 
	 * First we separate the first element from A:
	 * 
	 * first-element: a
	 * B = {b, c, ...}
	 * 
	 * Now we use this recursive law:
	 * 
	 * The subsets of A are the collection of subsets of B,
	 * plus the collection of subsets of B once again, but this time
	 * the first element a is added to these subset:
	 * 
	 * Subsets-Of (A) = Subsets-Of (B) + ({a} + Subsets-Of (B))
	 * 
	 * For example, if A has three members:
	 * 
	 * A = {a, b, c}
	 * 
	 * then
	 *
	 * first-element = a
	 * B = {b, c}.
	 * 
	 * The subsets of B:
	 * Subsets-Of (B) = Subsets-Of (C) + ({b} + Subsets-Of (C))
	 *
	 * then , 
	 * C = {c}
	 * 
	 * The subset of C = { {}, {c} }
	 * 
	 * Therefore, subset of B = { {}, {c} } + { b + {{}, {c}} } = { {}, {c} } + { {b}, {b, c} }
	 * i.e subset of B = {{}, {c} , {b}, {b, c}} 
	 * 
	 * hence, subset of A = {{}, {c} , {b}, {b, c}} + {a + {{}, {c} , {b}, {b, c}}} = {{}, {c} , {b}, {b, c}} + {{a}, {a, c} , {a, b}, {a, b, c}}
	 * 
	 * i.e subset of A = { {}, {c}, {b}, {b, c}, {a}, {a, c}, {a, b}, {a, b, b} }
	 * 
	 * If the set is an empty set {}, this function
	 * returns the only subset: {}, and recursion terminates here.
	 * 
	 * The input of this method, set, is an ArrayList<Integer>.
	 *  
	 * The output is an ArrayList of sets, That is the elements
	 * of ArrayList are ArrayList, themselves: ArrayList <ArrayList <E>>
	 * 
	 * */



package test;
import java.util.*;

public class find_Subset {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> set = new ArrayList<Integer>();
		int a[] = {1,2,3};
		for (int element :a){
			set.add(element);
		}
		ArrayList<ArrayList<Integer>> subSet = new ArrayList<ArrayList<Integer>>();
		subSet = getSubset(set);
		for(ArrayList<Integer> element: subSet){
			System.out.println(subSet);
		}
	}
	
	
	static ArrayList<ArrayList<Integer>> getSubset(ArrayList<Integer> set){
		ArrayList<ArrayList<Integer>> subsetCollection = new ArrayList<ArrayList<Integer>>();
		
		if(set.size()==0){ //base case for recursion
			subsetCollection.add(new ArrayList<Integer>());
		}
		
		else{
			ArrayList<Integer> reducedSet = new ArrayList<Integer>();
			reducedSet.addAll(set); 
			int first = reducedSet.remove(0); //remove first element of parent set
			ArrayList<ArrayList<Integer>> subSet = getSubset(reducedSet); //find subset of set recursively after removing the first element
			
			subsetCollection.addAll(subSet); //e.g this is subset of B
			
			subSet = getSubset(reducedSet);
			
			for(ArrayList<Integer> ele : subSet){
				ele.add(0,first); //add removed element to subset
			}
			subsetCollection.addAll(subSet); //combine both the sets - removed + added
		}
		return subsetCollection;
	}

}
