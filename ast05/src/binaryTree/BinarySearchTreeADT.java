//**************************************************************************
// 	BinarySearchTreeADT.java        		Author: Wayne Cutcliffe 
//											Revised from Prichard & Carrano						
//
// Defines the interface to a binary search tree.
//**************************************************************************

package binaryTree;

public interface BinarySearchTreeADT<T extends KeyedItem<KT>,
									KT extends Comparable<? super KT>>
							extends BinaryTreeInterface<T>
{
   			//  Adds the specified element to the proper location in this tree.
   	public void insert (T newItem);

   			//  Removes and returns the specified element from this tree. 
	public void delete(KT searchKey) throws TreeException;

  	public void delete(T item) throws TreeException;

   			//  Returns a reference to the element in this tree.
   			//	Returns "null", it item is not found
  	public T retrieve(KT searchKey);

			//	Returns true, if the binary search tree contains an element 
			//	that matches the specified element;  otherwise false
   	public boolean contains (KT searchKey);  							

			//	Returns the number of items in the tree
  	public int size();

   			//  Returns a reference to the smallest element in this tree.
   public T findMinimum();

}  // interface BinarySearchTree

