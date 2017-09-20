package test;
import java.util.*;
public class longest_substring_DP {
	static void findLongestSubstring(String s){
		boolean table[][] = new boolean[s.length()][s.length()];
		int start =0;
		int maxLength = 1;
		for(int i =0; i<s.length();i++)
			table[i][i] = true;
		
		for(int i =0; i< s.length()-1;i++){
			if(s.charAt(i)==s.charAt(i+1)){
				start = i;
				maxLength = 2;
				table[i][i+1]=true;
			}
		}
		
		for(int k =3; k<= s.length();k++){
			for(int i =0; i < s.length()-k+1; i++){
				int j = i + k - 1;
				if(table[i+1][j-1] && s.charAt(i) == s.charAt(j)){
					table[i][j] = true;
					if(k > maxLength){
						start = i;
						maxLength = k;
					}
				}
				
			}
			
		}
		System.out.println(s.substring(start, start+maxLength));
		
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		findLongestSubstring("kzzsjjp");

	}

}
