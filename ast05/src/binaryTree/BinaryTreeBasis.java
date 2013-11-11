//***********************************************************************
//  BinaryTreeBasis.java                	Authors: Prichard & Carrano
//
//
//  Represents an abstract class with common properties for binary trees
//***********************************************************************

package binaryTree;
import java.util.*;

public abstract class BinaryTreeBasis<T> implements BinaryTreeInterface<T>
{
  	protected TreeNode<T> root;

								// Constructors
  	public BinaryTreeBasis()
  	{
    	root = null;
  	}  // end default constructor


  	public BinaryTreeBasis(T rootItem)
  	{
    	root = new TreeNode<T>(rootItem);
  	}  // end constructor


  	public boolean isEmpty()
  	{
  		// Returns true if the tree is empty, else returns false.
    	return root == null;
  	}  // end isEmpty


  	public void makeEmpty()
  	{
  		// Remove all nodes from the tree.
    	root = null;
  	}  // end makeEmpty


  	public T getRootItem() throws TreeException
  	{
  		// Returns the item in the tree's root.
    	if (root == null) {
      		throw new TreeException("TreeException: Empty tree");
    	}
    	else {
      		return root.item;
    	}  // end if
  	}  // end getRootItem


  	public abstract void setRootItem(T newItem);
    // Throws UnsupportedOperationException if operation is not supported.


   /*****************************************************************
     Performs an inorder traversal on this binary tree by calling an
     overloaded, recursive inorder method that starts with the root
   *****************************************************************/
   public Iterator<T> iteratorInOrder()
   {
      ArrayList<T> tempList = new ArrayList<T>();

      inorder(root, tempList);

      return tempList.iterator();
   }

   //  Performs a recursive inorder traversal.
   protected void inorder (TreeNode<T> node,
                           ArrayList<T> tempList)
   {
      if (node != null)
      {
         inorder (node.leftChild, tempList);
         tempList.add(node.item);
         inorder (node.rightChild, tempList);
      }
   }  // method inorder


   //-------------------------------------------------------------------
   //  Performs an preorder traversal on this binary tree by calling an
   //  overloaded, recursive preorder method that starts with the root.
   //-------------------------------------------------------------------
	public Iterator<T> iteratorPreOrder()
   	{
    	ArrayList tempList = new ArrayList();

      	preorder (root, tempList);

      	return tempList.iterator();

	}

   //  Performs a recursive preorder traversal.
   	protected void preorder (TreeNode<T> node, ArrayList tempList)
   	{
    	if (node != null)
      	{
        	tempList.add(node.item);			// add to Rear
         	preorder (node.leftChild, tempList);
         	preorder (node.rightChild, tempList);
      	}
   	}


   //-------------------------------------------------------------------
   //  Performs an postorder traversal on this binary tree by calling
   //  overloaded, recursive postorder method that starts the root.
   //-------------------------------------------------------------------
   	public Iterator<T> iteratorPostOrder()
   	{
    	ArrayList tempList = new ArrayList();

      	postorder (root, tempList);

      	return tempList.iterator();

   	}

   //  Performs a recursive postorder traversal.
   	protected void postorder (TreeNode<T> node, ArrayList tempList)
   	{
    	if (node != null)
      	{
        	postorder (node.leftChild, tempList);
         	postorder (node.rightChild, tempList);
         	tempList.add(node.item);			// add to Rear
      	}
   	}


   //-------------------------------------------------------------------
   //  Performs a levelorder traversal on this binary tree, using a
   //  templist.
   //-------------------------------------------------------------------
 	 public Iterator<T> iteratorLevelOrder()
     {
     	//----->>>   Not implemented
     	// 	Returns a "stub" for an empty list

    	ArrayList tempList = new ArrayList();
      	return tempList.iterator();
     }

}  // end BinaryTreeBasis