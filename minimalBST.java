import java.util.*;
//Given sorted array with unique integer elements, write an algorithm to create a binary search tree with minimal height

/*
class TreeNode{
	int data;
	TreeNode left;
	TreeNode right;
	TreeNode(int data){
		this.data = data;
		left = null;
		right = null;
	}
} */
public class minimalBST {
	static TreeNode createMinimalBST(int arr[], int start, int end){
		if(start > end) return null;
		int mid = (end + start)/2;
		TreeNode root = new TreeNode(arr[mid]);
		root.left = createMinimalBST(arr,start,mid-1);
		root.right = createMinimalBST(arr,mid+1,end);
		return root;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {2,3,5,8,13,14};
		TreeNode root = createMinimalBST(a,0,a.length-1);
		System.out.print("Inorder -- ");
		inorder(root);
		System.out.println();
		System.out.print("BFS -- ");
		BFS(root);
	}
	static void inorder(TreeNode node){
		if(node != null){
			inorder(node.left);
			System.out.print(node.data+" ");
			inorder(node.right);
		}
	}
	
	static void BFS(TreeNode root){
		java.util.Queue<TreeNode> q= new java.util.LinkedList<TreeNode>();
		if(root != null){
			q.add(root);
			while(!q.isEmpty()){
				TreeNode tmp = q.poll();
				System.out.print(tmp.data+" ");
				if(tmp.left != null) q.add(tmp.left);
				if(tmp.right != null) q.add(tmp.right);
				
			}
		}
	
}
}
