package test3;

import java.util.Scanner;

public class U {
    public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		BinarySearchTree bst = new BinarySearchTree();
		while(in.hasNextLine()){
		    String[] s = in.nextLine().split(" ");
		    int c = Integer.parseInt(s[0]);
		    int key = 0;
		    switch(c){
		        case 1:
		        	key = Integer.parseInt(s[1]);
		        	bst.insert(key);
		        	break;
		        case 2:
		        	key = Integer.parseInt(s[1]);
		        	bst.deleteKey(key);
		        	break;
		        case 3:
		        	bst.printPreorderTree();
		        	System.out.println();
		        	break;
		        case 4:
		        	bst.printInorderTree();
		        	System.out.println();
		        	break;
		        case 5:
		        	bst.printPostorderTree();
		        	System.out.println();
		        	break;
		    }
		}
	}
}

class BinarySearchTree{
	private Node root;
	
	public BinarySearchTree(){
		root = null;
	}
	
	public void insert(int key){
		root = insertNode(root, key);
	}
	
	public Node insertNode(Node node, int key){
		if(node == null){
			node = new Node(key);
		} else {
			if(node.key > key){
				node.left = insertNode(node.left, key);
			} else {
				node.right = insertNode(node.right, key);
			}
		}
		return node;
	}
	
	public void deleteKey(int key){
		root = deleteNode(root, key);
	}
	
	public Node deleteNode(Node node, int key){
		if(node == null){
			return node;
		}
		if(key < node.key){
			node.left = deleteNode(node.left, key);
		} else if(key > node.key) {
			node.right = deleteNode(node.right, key);
		} else {
			if(node.left == null){
				return node.right;
			} else if(node.right == null){
				return node.left;
			}
			node.key = getMinValue(node.right);
			node.right = deleteNode(node.right, node.key);
		}
		return node;
	}
	
	public int getMinValue(Node node){
		int min = node.key;
		while(node.left != null){
			min = node.left.key;
			node = node.left;
		}
		return min;
	}
	
	public void printInorder(Node node){
		if(node != null){
			printInorder(node.left);
			System.out.print(node.key + " ");
			printInorder(node.right);
		}
	}
	
	public void printInorderTree(){
		printInorder(root);
	}
	
	public void printPreorder(Node node){
		if(node != null){
			System.out.print(node.key + " ");
			printPreorder(node.left);
			printPreorder(node.right);
		}
	}
	
	public void printPreorderTree(){
		printPreorder(root);
	}
	
	public void printPostorder(Node node){
		if(node != null){
			printPostorder(node.left);
			printPostorder(node.right);
			System.out.print(node.key + " ");
		}
	}
	
	public void printPostorderTree(){
		printPostorder(root);
	}
	
}

class Node{
	int key;
	Node left;
	Node right;
	
	public Node(int key){
		this.key = key;
		left = null;
		right = null;
	}
}
