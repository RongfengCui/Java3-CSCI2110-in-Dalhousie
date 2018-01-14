package com.cui.csci2110.lab7;

import java.util.ArrayList;

//Binary Search Tree class
//uses the Binary Tree class
public class BinarySearchTree<T extends Comparable<T>>
//you are using the compareTo method on objects of type T; hence T should extend Comparable<T>
{
	private BinaryTree<T> tree;
	private int size;
	
	public BinarySearchTree()
	{
		tree = new BinaryTree<T>();
		size=0;
	}
	public BinaryTree<T> getTree()
	{
		return tree;
	}
	public boolean isEmpty()
	{
		return tree.isEmpty();
	}
	public int size()
	{
		return size;
	}
	public BinaryTree<T> search(T key)
	{
		BinaryTree<T> t = tree;
		if (isEmpty()) return null;
		while (t!=null)
		{
			if (key.compareTo(t.getData())<0)
				t = t.getLeft();
			else if (key.compareTo(t.getData())>0)
				t = t.getRight();
			else // key is found
				return t;
		}
		return null;
	}
		
		
	public void insert(T item)
	{
		BinaryTree<T> newNode = new BinaryTree<T>(); //sets left, right, parent and data to null
		newNode.setData(item);

		if (size==0){tree = newNode; size++;return;}
		
		BinaryTree<T> t = tree;
		boolean done = false;
		while (!done)
		{
			int c = item.compareTo(t.getData());
			if (c==0)
			{
				System.out.println("Duplicate key. Can't insert");
				return;
			}
			else if (c<0) //need to go left
			{
				if (t.getLeft()==null)	//place to insert found
				{
					t.setLeft(newNode);
					newNode.setParent(t);
					size++;
					done = true;
				}
				else
					t = t.getLeft(); //otherwise go left one branch
			}
			else //c>0; need to go right
			{
				if (t.getRight()==null) //place to insert found
				{
					t.setRight(newNode);
					newNode.setParent(t);
					size++;
					done=true;
				}
				else
					t = t.getRight();
			}
		}
	}
	
	public BinaryTree<T> findPredecessor(BinaryTree<T> node)
	{
		if (node==null) return null;
		if (node.getLeft()==null) return null;
		BinaryTree<T> pred = node.getLeft();
		while (pred.getRight()!=null)
			pred = pred.getRight();
		return pred;
	}
	
	public void deleteHere(BinaryTree<T> deleteNode, BinaryTree<T> attach)
	{
		if (deleteNode==null) return;
		BinaryTree<T> parent = deleteNode.getParent();
		
		if (parent == null) return;
		if (attach == null)
		{
			if (parent.getLeft()==deleteNode)
				parent.setLeft(null);
			else
				parent.setRight(null);
			return;
		}
		if (deleteNode==parent.getRight())
		{
			parent.detachRight();
			deleteNode.setParent(null);
			//attach.setParent(parent);
			attach.setParent(null);
			parent.attachRight(attach);
			attach.setParent(parent);
		}
		else
		{
			parent.detachLeft();
			deleteNode.setParent(null);
			
			//attach.setParent(parent);
			attach.setParent(null);
			parent.attachLeft(attach);
			attach.setParent(parent);
		}
		deleteNode.clear();
	}
	
	public void delete(T key)
	{
		if (size==0){System.out.println("Can't delete. Empty tree"); return;}
		BinaryTree<T> deleteNode = search(key);
		if (deleteNode==null) {System.out.println("Key not found. Can't delete"); return;}
		
		BinaryTree<T> hold = null;
		if (deleteNode.getLeft()==null && deleteNode.getRight()==null)
		{
			deleteHere(deleteNode, null);
		}
		else if (deleteNode.getLeft()==null)
		{
			hold = deleteNode.getRight();
			deleteHere(deleteNode, hold);
		}
		else if (deleteNode.getRight()==null)
		{
			hold = deleteNode.getLeft();
			deleteHere(deleteNode, hold);
		}
		else
		{
			hold = findPredecessor(deleteNode);
			deleteNode.setData(hold.getData());
			deleteNode=hold;
			deleteHere(deleteNode, deleteNode.getLeft());
		}
		size--;
	}
	public T findMax(){
		BinaryTree<T> t = tree;
		if(t == null)
			return null;
		else if(t.getRight() == null) 
			return t.getData();
		else
			while(t.getRight() != null) //just keep find the right node of tree and the last one is the max one
				t = t.getRight();	
			return t.getData();			
	}
	public T findMin(){
		BinaryTree<T> t = tree;
		if(t == null)
			return null;
		else if(t.getLeft() == null)
			return t.getData();
		else
			while(t.getLeft() != null) //just keep find the left node of tree and the last one is the min one
				t = t.getLeft();	
			return t.getData();			
	}
	public BinaryTree<T> recursiveSearch(T key){
		BinaryTree<T> t = tree;
		if (t.isEmpty())
			return null;
		else
			return recursiveSearch(t, key);
	}
	public BinaryTree<T> recursiveSearch(BinaryTree<T> t, T key){
		if(t == null)
			return null;
		else if(t.getData().compareTo(key) > 0) //compare the data in binary tree t and key, if data bigger than key,then t go left
			return recursiveSearch(t.getLeft(), key);
		else if(t.getData().compareTo(key) < 0)
			return recursiveSearch(t.getRight(), key);
		else
			return t; //if find return the address, else return null
	}
	public boolean isBinarySearchTree(BinaryTree<T> t){
		ArrayList<T> list = new ArrayList<T>();
		ArrayList<T> list1 = new ArrayList<T>();
		if(t == null)
			return true;	
		else{
			list.addAll(inorder(t,list1)); //get the arraylist of inorder traversal 
			for(int i = 0; i < list.size(); i++){ //compare the order just by using the feature of binarysearchtree about inorder traversal
				for(int j = i+1; j < list.size(); j++){
					if(list.get(i).compareTo(list.get(j)) > 0)
						return false;
				}
			}	
		}
		return true;
	}
	public static<T> ArrayList<T> inorder(BinaryTree<T> tree,ArrayList<T> arr) { //use inorder method just like that in binarytree class
		if (tree == null) {
			return arr;
		}
		inorder(tree.getLeft(),arr);
		arr.add(tree.getData()); //add the inorder traversal to an arraylist
		inorder(tree.getRight(),arr);
		return arr;
	}
}
	