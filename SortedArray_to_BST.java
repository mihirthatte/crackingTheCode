package test;
import java.util.*;
public class SortedArray_to_BST {
	 TreeNode createBST(int[] nums, int start, int end){
	        if(start > end) return null;
	        if(start == end)
	            return new TreeNode(nums[start]);
	        int mid = (start + end)/2;
	        TreeNode root = new TreeNode(nums[mid]);
	        root.left = createBST(nums, start, mid-1);
	        root.right = createBST(nums, mid+1, end);
	        return root;
	    }
	    public TreeNode sortedArrayToBST(int[] nums) {
	        if (nums.length == 0) return null;
	        return createBST(nums,0,nums.length - 1);
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			int []  nums = {3,5,2,8,9,10};
			new SortedArray_to_BST().sortedArrayToBST(nums);
	}

}
