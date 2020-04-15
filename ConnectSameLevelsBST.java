package com.java.educative;

import java.util.LinkedList;
import java.util.Queue;

public class ConnectSameLevelsBST {
	static class Node  
	{ 
	    int data; 
	    Node left, right,nextToRight; 
	   
	    public Node(int data)  
	    { 
	        this.data = data; 
	        left = right = null; 
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
		Queue<Node> evenQueue = new LinkedList<Node>();
		Queue<Node> oddQueue = new LinkedList<Node>();
		
		evenQueue.add(root);
		while (!evenQueue.isEmpty() || !oddQueue.isEmpty()) {
			Queue<Node> currQueue;
			Queue<Node> childQueue;
			if(evenQueue.isEmpty()) {
				currQueue = oddQueue;
				childQueue = evenQueue;
			} else {
				currQueue = evenQueue;
				childQueue = oddQueue;
			}
			
			Node prevNode = null;
			while (!currQueue.isEmpty()) {
				Node currNode = currQueue.remove();
				if (prevNode != null) {
					prevNode.nextToRight = currNode;
				}
				
				if (currNode.left != null) childQueue.add(currNode.left);
				if (currNode.right != null) childQueue.add(currNode.right);
				prevNode = currNode;
			}
			prevNode.nextToRight = null;
		}
		
		System.out.println("Done");
		
	}	
	
}
