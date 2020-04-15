package com.java.educative;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BSTPerimeter {
	
	static class Node  
	{ 
	    int data; 
	    Node left, right; 
	   
	    public Node(int data)  
	    { 
	        this.data = data; 
	        left = right = null; 
	    } 
	} 
	
	public static void printLeftNodes(Node root, Stack<Integer> aStack) {
		if (root == null) return;
		if (root.left != null) {
			printLeftNodes(root.left, aStack);
		} else if (root.right != null) {
			printLeftNodes(root.right, aStack);
		}
		if (root.left != null || root.right != null) {
			aStack.add(root.data);
		}
			
		
	}
	
	public static void printLeafNodes(Node root, Stack<Integer> aStack) {
		if (root == null) return;
		if (root.right != null) {
			printLeafNodes(root.right, aStack);
		}
		if (root.left != null) {
			printLeafNodes(root.left, aStack);
		}

		if (root.left == null && root.right == null) {
			aStack.add(root.data);
		}
			
		
	}
	
	public static void printRightNodes(Node root, Queue<Integer> nodeQueue) {
		if (root == null) return;
		if (root.right != null) {
			printRightNodes(root.right, nodeQueue);
		} else if (root.left != null) {
			printRightNodes(root.left, nodeQueue);
		}
		if (root.left != null || root.right != null) {
			nodeQueue.add(root.data);
		}
			
		
	}	
	
	public static void main(String[] args) {
		Node root = new Node(100);
		root.left = new Node(50);
		root.right = new Node(200);
		
		root.left.left = new Node(25);
		root.left.right = new Node(60);
		
		root.left.left.left = new Node(10);
		root.left.right.right = new Node(70);
		
		root.right.right = new Node(350);
		root.right.right.right = new Node(400);
		
		Stack<Integer> nodeStack = new Stack<Integer>();
		
		Queue<Integer> nodeQueue = new LinkedList<Integer>();
		
		printRightNodes(root.right,nodeQueue);
		printLeafNodes(root,nodeStack);
		printLeftNodes(root, nodeStack);
		
		StringBuilder stb = new StringBuilder();
		
		while(!nodeStack.isEmpty()) {
			
			if (stb.length() == 0) {
				stb.append(nodeStack.pop());
			} else {
				stb.append(" " + nodeStack.pop());
			}
			
		}
		
		while(!nodeQueue.isEmpty()) {
			if (stb.length() == 0) {
				stb.append(nodeQueue.remove());
			} else {
				stb.append(" " + nodeQueue.remove());
			}
		}
		
		System.out.println(stb.toString());
		
	}

}
