//*******************************************************************
//  TreeNode.java                	Authors: Prichard & Carrano
//
//
//  Represents a node in a binary tree with a left and right child.
//*******************************************************************

package binaryTree;

class TreeNode<T>
{
  	protected T 			item;
  	protected TreeNode<T> leftChild;
  	protected TreeNode<T> rightChild;

  // constructors

  // Initializes tree node with item and no children.
  public TreeNode(T newItem) {
    	item = newItem;
    	leftChild  = null;
    	rightChild = null;
  }  // end constructor

// Initializes tree node with item and left and right children references.
  public TreeNode(T newItem,TreeNode<T> left, TreeNode<T> right)
  {
    	item = newItem;
    	leftChild  = left;
    	rightChild = right;
  }  // end constructor

}  // end TreeNode
