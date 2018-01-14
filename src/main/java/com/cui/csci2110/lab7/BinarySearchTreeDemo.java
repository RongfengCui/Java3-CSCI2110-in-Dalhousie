package com.cui.csci2110.lab7;


public class BinarySearchTreeDemo { //t is a binarySearchTree and I also created some binaryTree without satisfy the order of binarySearchTree
	public static void main(String [] args){
		BinarySearchTree<Integer> t = new BinarySearchTree<Integer>();
		t.insert(1);
		t.insert(5);
		t.insert(4);
		t.insert(8);
		t.insert(7);
		t.insert(2);
		BinaryTree<Integer> A = new BinaryTree<Integer>();
		BinaryTree<Integer> B = new BinaryTree<Integer>();
		BinaryTree<Integer> C = new BinaryTree<Integer>();
		BinaryTree<Integer> D = new BinaryTree<Integer>();
		A.makeRoot(1);
		B.makeRoot(2);
		C.makeRoot(3);
		D.makeRoot(4);
		B.attachLeft(C);
		B.attachRight(A);
		System.out.println(t.findMax());
		System.out.println("");
		System.out.println(t.findMin());
		System.out.println("");
		System.out.println(t.recursiveSearch(10));
		System.out.println(t.recursiveSearch(1));
		System.out.println("");
		System.out.println(t.isBinarySearchTree(t.getTree()));
		System.out.println(t.isBinarySearchTree(B));
	}
}
