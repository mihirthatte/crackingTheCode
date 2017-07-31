package test;
//Program to convert Roman string to its equivalent integer value
public class roman_to_Decimal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "XIV";
		int nums[] = new int[s.length()];
		for(int i =0; i<s.length();i++){
		char c = s.charAt(i);
		if(c == 'I') nums[i] = 1;
		else if(c == 'V') nums[i] = 5;
		else if(c == 'X') nums[i] = 10;
		else if(c == 'L') nums[i] = 50;
		else if(c == 'C') nums[i] = 100;
		else if(c == 'M') nums[i] = 1000;
		else if(c == 'D') nums[i] = 500;
		}
		int sum = 0;
		for(int i =0; i< nums.length-1; i++){
			if(nums[i] < nums[i+1])
				sum = sum - nums[i];
			else sum+=nums[i];
		}
		sum+=nums[nums.length-1];
		
		System.out.println(sum);
		
	}

}
