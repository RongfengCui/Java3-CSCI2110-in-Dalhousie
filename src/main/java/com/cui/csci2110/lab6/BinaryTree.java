package com.cui.csci2110.lab6;

import java.util.*;
public class BinaryTree<T> 
{
	private T data;
	private BinaryTree<T> parent;
	private BinaryTree<T> left;
	private BinaryTree<T> right;
	
	public BinaryTree()
	{
		parent = left = right = null;
		data = null;
	}
	
	
	public void makeRoot(T data)
	{
		if (!isEmpty())
		{
			System.out.println("Can't make root. Already exists");
		}
		else
			this.data = data;
	}
	
	public void setData(T data)
	{
		this.data = data;
	}
	
	public void setLeft(BinaryTree<T> tree)
	{
		left = tree;
	}
	public void setRight(BinaryTree<T> tree)
	{
		right = tree;
	}
	public void setParent(BinaryTree<T> tree)
	{
		parent = tree;
	}
	
	public T getData()
	{
		return data;
	}
	public BinaryTree<T> getParent()
	{
		return parent;
	}
	public BinaryTree<T> getLeft()
	{
		return left;
	}
	public BinaryTree<T> getRight()
	{
		return right;
	}
	
	
	public void attachLeft(BinaryTree<T> tree)
	{
		if (tree==null) return;
		else if (left!=null || tree.getParent()!=null)
		{
			System.out.println("Can't attach");
			return;
		}
		else
		{
			
				tree.setParent(this);
				this.setLeft(tree);
		}
	}
	
	public void attachRight(BinaryTree<T> tree)
	{
		if (tree==null) return;
		else if (right!=null || tree.getParent()!=null)
		{
			System.out.println("Can't attach");
			return;
		}
		else
		{
	
				tree.setParent(this);
				this.setRight(tree);
		}
	}
	
	public BinaryTree<T> detachLeft()
	{
		if (this.isEmpty()) return null;
		BinaryTree<T> retLeft = left;
		left = null;
		if (retLeft!=null) retLeft.setParent(null);
		return retLeft;
	}
	public BinaryTree<T> detachRight()
	{
		if (this.isEmpty()) return null;
		BinaryTree<T> retRight = right;
		right =null;
		if (retRight!=null) retRight.setParent(null);
		return retRight;
	}
	public boolean isEmpty()
	{
		if (data == null)
			return true;
		else
			return false;
	}
	public void clear()
	{
		left = right = parent =null;
		data = null;
	}
	
	public BinaryTree<T> root()
	{
		if (parent == null)
			return this;
		else
		{
			BinaryTree<T> next = parent;
			while (next.getParent()!=null)
				next = next.getParent();
			return next;
		}
	}
	
	public static <T> void preorder(BinaryTree<T> t)
	{
		if (t!=null)
		{
			System.out.print(t.getData()+"\t");
			preorder(t.getLeft());	
			preorder(t.getRight());
		}
	}
	
	public static <T> void inorder(BinaryTree<T> t)
	{
		if (t!=null)
		{
			inorder(t.getLeft());
			System.out.print(t.getData() + "\t");
			inorder(t.getRight());
		}
	}
	
	public static <T> void postorder(BinaryTree<T> t)
	{
		if (t!=null)
		{
			postorder(t.getLeft());
			postorder(t.getRight());
			System.out.print(t.getData() + "\t");
		}
	}
	public static <T> int findNumberNode(BinaryTree<T> t){
		if(t == null){ // if t equal to null then the recursive stop.
			return 0;
		}
		else
			return 1 + findNumberNode(t.getLeft()) + findNumberNode(t.getRight());	//if t has left then plus 1. if t has right then plus 1		
	}
	public static <T> int findHeight(BinaryTree<T> t){
		if(t == null)
			return -1;
		else if(findNumberNode(t.getLeft()) >= findNumberNode(t.getRight())) // if the number of node in left subtree more than those in right subtree
			return 1 + findHeight(t.getLeft()); // then get left and plus 1
		else
			return 1 + findHeight(t.getRight());
	}
	public static <T> boolean heightBalance(BinaryTree<T> t){
		if(t == null)
			return true;
		else if(Math.abs(findHeight(t.getRight())-findHeight(t.getLeft())) >1){
			return false; // if the height of right subtree not equal to left or more than 1 return false
		}
		else 
			return true;
	}
	public static<T> void levelOrder(BinaryTree<T> tree){
		ArrayList<BinaryTree<T>> list = new ArrayList<BinaryTree<T>>();
		BinaryTree<T> t = tree;
		if(t == null){
			System.out.println("Empty tree");
			return;
		}	
		list.add(t);// add the first node
		while(!list.isEmpty()){
			for(int i = 0; i < list.size(); i++){
				if(list.get(i).getLeft() != null && list.get(i).getRight() != null){
					list.add(list.get(i).getLeft()); // if list have both left and right node, then add to arraulist
					list.add(list.get(i).getRight());	
				}
				
				else if(list.get(i).getLeft() == null && list.get(i).getRight() != null)
					list.add(list.get(i).getRight());
				
				else if(list.get(i).getLeft() != null && list.get(i).getRight() == null)
					list.add(list.get(i).getLeft());
				
				System.out.print(list.get(i).getData() + "\t"); // get the current node
				list.remove(i); // then remove
				i--;
			}
		}			
	}
}
