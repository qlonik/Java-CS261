//**************************************************************************
// 	BinarySearchTreeADT.java        		Author:  Prichard & Carrano	
//                                                          Revised by Wayne Cutcliffe 					
//
// 	Defines  a Binary Search Tree structure
//  Assumption:
//      A tree contains at most one item with a given search key at any time.
//
// 	inherits "root" plus the methods isEmpty(), makeEmpty(), getRootItem(), 
// 	iterator methods and the use of the constructors from BinaryTreeBasis
//**************************************************************************
package binaryTree;

public class BinarySearchTree<T extends KeyedItem<KT>, KT extends Comparable<? super KT>>
        extends BinaryTreeBasis<T> implements BinarySearchTreeADT<T, KT> {

//You must update "count" in any method where this is required
//-------------------------------------------------------------
  protected int count = 0;

  public BinarySearchTree() {
    super();
  }  // end default constructor

  public BinarySearchTree(T rootItem) {
    super(rootItem);
  }  // end constructor

  @Override
  public void setRootItem(T newItem) throws UnsupportedOperationException {
    throw new UnsupportedOperationException();
  }  // end setRootItem

  @Override
  public void insert(T newItem) {
    count++;
    root = insertItem(root, newItem);
  }  // method insert

  @Override
  public T retrieve(KT searchKey) {
    return retrieveItem(root, searchKey);
  }  // end retrieve

  @Override
  public void delete(KT searchKey) throws TreeException {
    root = deleteItem(root, searchKey);
    count--;
  }  // end delete

  @Override
  public void delete(T item) throws TreeException {
    root = deleteItem(root, item.getKey());
    count--;
  }  // end delete

  @Override
  public int size() {
    return count;
  }

  @Override
  public boolean contains(KT searchKey) {
    T item = retrieve(searchKey);
    return item == null ? false : true;
  }	// method contains

  @Override
  public T findMinimum() throws TreeException {
    TreeNode<T> current = root;
    while (current.leftChild != null) {
      current = current.leftChild;
    }
    return current.item;
  }	// method findMinimum

  protected TreeNode<T> insertItem(TreeNode<T> tNode, T newItem) {
    //	TreeNode<T> newSubtree;
    if (tNode == null) {
      // position of insertion found; insert after leaf
      return new TreeNode<>(newItem, null, null);
    }  // end if

    T nodeItem = tNode.item;
    // search for the insertion position
    if (newItem.getKey().compareTo(nodeItem.getKey()) < 0) {
      // search the left subtree
      tNode.leftChild = insertItem(tNode.leftChild, newItem);
      return tNode;
    } else { // search the right subtree
      tNode.rightChild = insertItem(tNode.rightChild, newItem);
      return tNode;
    }  // end if
  }  // method insertItem

  protected T retrieveItem(TreeNode<T> tNode, KT searchKey) {
    //	T treeItem;
    if (tNode == null) {
      return null;
    }

    T nodeItem = tNode.item;
    if (searchKey.compareTo(nodeItem.getKey()) == 0) {
      // item is in the root of some subtree
      return tNode.item;
    }
    if (searchKey.compareTo(nodeItem.getKey()) < 0) {
      // search the left subtree
      return retrieveItem(tNode.leftChild, searchKey);
    } else // search the right subtree
    {
      return retrieveItem(tNode.rightChild, searchKey);
    }
    // end if

    // return treeItem;
  }  // method retrieveItem

  protected TreeNode<T> deleteItem(TreeNode<T> tNode,
          KT searchKey) {
    // Calls: deleteNode.
    //	TreeNode<T> newSubtree;
    if (tNode == null) {
      throw new TreeException("TreeException: Item not found");
    }

    T nodeItem = tNode.item;
    if (searchKey.compareTo(nodeItem.getKey()) == 0) {
      // item is in the root of some subtree
      tNode = deleteNode(tNode);  // delete the item
    } // else search for the item
    else if (searchKey.compareTo(nodeItem.getKey()) < 0) // search the left subtree
    {
      tNode.leftChild = deleteItem(tNode.leftChild, searchKey);
    } else { 					// search the right subtree
      tNode.rightChild = deleteItem(tNode.rightChild, searchKey);
    }  // end if

    return tNode;
  }  // end deleteItem

  protected TreeNode<T> deleteNode(TreeNode<T> tNode) {
    // Algorithm note: There are four cases to consider:

    // Calls: findLeftmost and deleteLeftmost
    //	T replacementItem;

    // Case 1: tNode is a leaf
    if ((tNode.leftChild == null)
            && (tNode.rightChild == null)) {
      return null;
    }  // end if leaf
    // Case 2: tNode has no left child.
    if (tNode.leftChild == null) {
      return tNode.rightChild;
    }  // end if no left child
    // Case 3: tNode has no right child
    if (tNode.rightChild == null) {
      return tNode.leftChild;
    }  // end if no right child

    // Case 4: tNode has two children:
    // retrieve and delete the inorder successor

    T replacementItem = findLeftmost(tNode.rightChild);
    tNode.item = replacementItem;
    tNode.rightChild = deleteLeftmost(tNode.rightChild);
    return tNode;

  }  // method deleteNode

  protected T findLeftmost(TreeNode<T> tNode) {
    if (tNode.leftChild == null) {
      return tNode.item;
    } else {
      return findLeftmost(tNode.leftChild);
    }  // end if
  }  // end findLeftmost

  protected TreeNode<T> deleteLeftmost(TreeNode<T> tNode) {
    if (tNode.leftChild == null) {
      return tNode.rightChild;
    } else {
      tNode.leftChild = deleteLeftmost(tNode.leftChild);
      return tNode;
    }  // end if
  }  // end deleteLeftmost

  //------------------------------------------------------------------
  //  Returns the tree height.
  //  An empty tree has height 0; leaf has height 1
  //  Otherwise, height is 1 + height of larger subtree
  //------------------------------------------------------------------
  public int getHeight() {
    return findHeight(root);
  }

  private int findHeight(TreeNode<T> node) {
    if (node == null) {
      return 0;
    } else {
      return 1 + Math.max(findHeight(node.leftChild), findHeight(node.rightChild));
    }
  }

  @Override
  public String toString() {
    return root.toString();
  }
}  // end BinarySearchTree
