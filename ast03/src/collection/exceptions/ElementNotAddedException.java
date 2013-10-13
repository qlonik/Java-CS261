package collection.exceptions;

//**********************************************************************
//  ElementNotAddedException.java     			Author: Wayne Cutcliffe
//
//  Represents a situation where a target element is not inserted
//	into a collection because it is considered a dulpicate entry
//
//**********************************************************************
public class ElementNotAddedException extends RuntimeException {

  /**
   * ******************************************************************
   * Sets up this exception with an appropriate message.
   * ******************************************************************
   */
  public ElementNotAddedException() {
    super("---- Duplicate element: The target element is not added");
  }
}	// class ElementNotAddedException

