package com.cui.csci2110.lab6;

import java.util.*;
public class BinaryTreeDemo1 {
	public static void main(String [] args){
		ArrayList<BinaryTree<String>> list = new ArrayList<BinaryTree<String>>();
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter name or done: ");
		String name = keyboard.nextLine();
		while(!name.equals("done")){
			BinaryTree<String> A = new BinaryTree<String>(); // create a binarytree
			A.makeRoot(name); // make root to the name
			list.add(A); // add to arraylist
			System.out.print("Enter name or done: ");
			name = keyboard.nextLine();
		}
		if (list.isEmpty())
			System.out.println("Empty list");
		else {
			build(list);
			System.out.println("Height of the tree is: "
					+ BinaryTree.findHeight(list.get(0)));
			System.out.println("Number of nodes in the tree is: "
					+ BinaryTree.findNumberNode(list.get(0)));
			System.out.print("Preorder:\t");
			BinaryTree.preorder(list.get(0));
			System.out.println();

			System.out.print("Inorder:\t");
			BinaryTree.inorder(list.get(0));
			System.out.println();

			System.out.print("Postorder:\t");
			BinaryTree.postorder(list.get(0));
			System.out.println();

			System.out.print("Levelorder:\t");
			BinaryTree.levelOrder(list.get(0));
			System.out.println();
		}

	}	
	public static void build(ArrayList<BinaryTree<String>> list){
		for(int i = 2; i <= list.size(); i++){
			if(i % 2 == 0) 
				list.get(i / 2 - 1).attachLeft(list.get(i-1)); // if i can be divided exactly by 2 , then attachleft
			else
				list.get(i / 2 - 1).attachRight(list.get(i-1));
		}
		
	}
}
