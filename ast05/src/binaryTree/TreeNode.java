//*******************************************************************
//  TreeNode.java                	Authors: Prichard & Carrano
//
//
//  Represents a node in a binary tree with a left and right child.
//*******************************************************************
package binaryTree;

class TreeNode<T> {

  private final String SPACE_INC = " ";
  protected T item;
  protected TreeNode<T> leftChild;
  protected TreeNode<T> rightChild;

  // constructors
  // Initializes tree node with item and no children.
  public TreeNode(T newItem) {
    item = newItem;
    leftChild = null;
    rightChild = null;
  }  // end constructor

// Initializes tree node with item and left and right children references.
  public TreeNode(T newItem, TreeNode<T> left, TreeNode<T> right) {
    item = newItem;
    leftChild = left;
    rightChild = right;
  }  // end constructor

  public String prepareString(TreeNode<T> node, int depth) {
    String result = "";
    String spaces = "";
    for (int i = 0; i < depth; i++) {
      spaces += " ";
    }
    if (node == null) {
      result = spaces + "null";
    } else {
      result = spaces + "(" + node.item + "\n"
              + spaces + " " + prepareString(node.leftChild, depth + 1) + "\n"
              + spaces + " " + prepareString(node.rightChild, depth + 1) + "\n"
              + spaces + spaces + ")";
    }
    return result;
  }

  @Override
  public String toString() {
    return prepareString(this, 0);
  }
}  // end TreeNode
