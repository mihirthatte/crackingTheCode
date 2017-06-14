//Check for matching parenthesis

package test;
import java.util.*;
public class javaStack {
	static boolean match(char top, char bottom){
	       if(top=='{' && bottom == '}'){
	    	   return true;
	       }else if(top=='(' && bottom == ')') return true;
	       else if (top=='[' && bottom == ']') return true;
	       else return false;
	   }
	   public static void main(String []argh)
	   {     
		   Stack<Character> st = new Stack<Character>();
		   String input="({}[()])";
		   for(int i=0; i<input.length();i++){
			   char c = input.charAt(i);
			   //System.out.println("Character under consideration - "+c);
			   if(!st.empty()){
				   if(c=='}' && st.peek()=='{'){
					   st.pop();
				   }
				   else if(c==']' && st.peek()=='['){					 
					   st.pop();
				   }
				   else if(c==')' && st.peek()=='('){					  
					   st.pop();
				   }
				   else {
					   st.push(c);
				   }
			   }
			   else st.push(c);
	      }
		  System.out.println(st.empty());

}
}
