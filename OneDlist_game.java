/*
  Let's play a game on an array! You're standing at index  0 of an n-element array named game. From some index i (where 0 <= i <= n), you can perform one of the following moves:

Move Backward: If cell  i-1 exists and contains a 0, you can walk back to cell i-1.
Move Forward:
If cell  i+1 contains a zero, you can walk to cell i+1.
If cell  i+leap contains a zero, you can jump to cell i+leap.
If you're standing in cell  n-1 or the value of i+leap >= n, you can walk or jump off the end of the array and win the game.

In other words, you can move from index i to index i+1, i+leap, i-1, or  as long as the destination index is a cell containing a 0. 
If the destination index is greater than n-1, you win the game.

 */


package test;
import java.util.*;
public class OneDlist_game {
     public static boolean canWin(int leap, int[] game, int index) {
	        // Return true if you can win the game; otherwise, return false.
		 if(index >= game.length) return true;
		 if(index < 0 ) return false;
		 else{
			 if (game[index]==0){
				 game[index]=1;
				 if(canWin(leap, game, index+leap)) return true;
				 if(canWin(leap, game, index+1)) return true;
				 if(canWin(leap, game, index-1)) return true;
			 }
			 return false;
		 }
		 
	    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
            int n = 9;
            int leap = 4;
            
            int[] game = { 0, 1, 1, 0, 0, 1, 0, 0, 1 };

            System.out.println( (canWin(leap, game,0)) ? "YES" : "NO" );
        scan.close();
    }
}