//************************************************************************//  Node.java       			Authors: textbook revised by W Cutcliffe////  Represents a node in a linked list.//************************************************************************//package collection;public class Node<T>{    protected T item;    protected Node<T> next;   //   Creates an empty node.   //----------------------------------------------------------------    public Node()    {        item = null;        next = null;    }    //  Creates a node storing the specified item.    //----------------------------------------------------------------    public Node (T newItem)    {        item = newItem;        next = null;    }    //   Creates a node storing the specified item and next reference    //----------------------------------------------------------------    public Node (T newItem, Node nextNode)    {        item = newItem;        next = nextNode;    }    //  Returns the node that follows this one.    //----------------------------------------------------------------    public Node<T> getNext()    {        return next;    }    //  Sets the node that follows this one.    //----------------------------------------------------------------    public void setNext (Node<T> node)    {        next = node;    }    //  Returns the item stored in this node.    //----------------------------------------------------------------    public T getElement()    {        return item;    }    //  Sets the item stored in this node.    //----------------------------------------------------------------    public void setElement (T newItem)    {        item = newItem;    }}  // class Node