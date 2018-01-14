package com.cui.csci2110.lab6;

public class BinaryTreeDemo
{
	public static void main(String[] args)
	{
		BinaryTree<String> A = new BinaryTree<String>();
		BinaryTree<String> B = new BinaryTree<String>();
		BinaryTree<String> C = new BinaryTree<String>();
		BinaryTree<String> D = new BinaryTree<String>();
		BinaryTree<String> E = new BinaryTree<String>();
		BinaryTree<String> F = new BinaryTree<String>();
		BinaryTree<String> G = new BinaryTree<String>();
		BinaryTree<String> H = new BinaryTree<String>();
		BinaryTree<String> I = new BinaryTree<String>();
		BinaryTree<String> J  = new BinaryTree<String>();
		BinaryTree<String> K = new BinaryTree<String>();
		BinaryTree<String> L = new BinaryTree<String>();
		BinaryTree<String> M = new BinaryTree<String>();
		A.makeRoot("APPLE");
		B.makeRoot("BEN");
		C.makeRoot("CAR");
		D.makeRoot("DOG");
		E.makeRoot("EGG");
		F.makeRoot("FIRE");
		G.makeRoot("GPS");
		H.makeRoot("HAT");
		I.makeRoot("IM");
		J.makeRoot("JET");
		K.makeRoot("KONG");
		L.makeRoot("LINEAR");
		M.makeRoot("MOM");
		A.attachLeft(C);
		A.attachRight(B);
		C.attachLeft(D);
		D.attachLeft(E);
		F.attachLeft(G);
		F.attachRight(H);
		I.attachLeft(J);
		I.attachRight(K);
		K.attachRight(M);
		
		System.out.println("The number of node is "+ BinaryTree.findNumberNode(A));
		System.out.println("The height is " + BinaryTree.findHeight(A));
		if(BinaryTree.heightBalance(A))
			System.out.println("height balanced");
		else
			System.out.println("not height balanced");
		BinaryTree.levelOrder(A);
		System.out.println("\n");
		System.out.println("The number of node is "+ BinaryTree.findNumberNode(F));
		System.out.println("The height is " + BinaryTree.findHeight(F));
		if(BinaryTree.heightBalance(F))
			System.out.println("height balanced");
		else
			System.out.println("not height balanced");
		BinaryTree.levelOrder(F);
		System.out.println("\n");
		System.out.println("The number of node is "+ BinaryTree.findNumberNode(I));
		System.out.println("The height is " + BinaryTree.findHeight(I));
		if(BinaryTree.heightBalance(I))
			System.out.println("height balanced");
		else
			System.out.println("not height balanced");
		BinaryTree.levelOrder(I);
		System.out.println("\n");
		
	}
	
}