//**********************************************************************
//  BinaryTreeInterface.java					Authors:  Cutcliffe
//										Version 1.0,	31/10/2012
//
//	Defines the interface to a binary tree data structure.
//**********************************************************************

package binaryTree;

import java.util.Iterator;
//import TreeException;

public interface BinaryTreeInterface<T>
{


    public boolean isEmpty();			// is the binary tree empty?

  	public void makeEmpty();			// remove all nodes from the tree.

									// returns a reference to root element
  	public T getRootItem() throws TreeException;

  	public abstract void setRootItem(T newItem);

	//  Create an iterator for the Binary Tree Structure

   			//  Performs an inorder traversal on this binary tree by calling an
        	//	overloaded, recursive inorder method that starts with the root.
    public Iterator<T> iteratorInOrder();


   			//  Performs a preorder traversal on this binary tree by calling an
        	//	overloaded, recursive preorder method that starts with the root.
    public Iterator<T> iteratorPreOrder();


   			//  Performs a postorder traversal on this binary tree by calling an
        	//	overloaded, recursive postorder method that starts with the root.
    public Iterator<T> iteratorPostOrder();


   			//  Performs a levelorder traversal on the binary tree, using a queue.
    public Iterator<T> iteratorLevelOrder();

}  // interface BinaryTreeADT

