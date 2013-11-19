package ast05;

import binaryTree.BinarySearchTree;
import binaryTree.TreeException;
import java.util.Iterator;
import java.util.Scanner;

/*
 * MembershipList.java    Nikita Volodin 127196
 * CS261,   ast05
 * 
 * Class represents list of members
 */
public class MembershipList {

  BinarySearchTree<Member, String> list;

  public MembershipList(Scanner input) {
    list = new BinarySearchTree<>();
    parseFile(input);
  }

  /**
   * Method parses input and saves given tree
   *
   * @param input link to the input tree
   */
  private void parseFile(Scanner input) {
    while (input.hasNextLine()) {
      String line = input.nextLine();
      line = line.trim();

      if (!line.equals("")) {
        Scanner lineScan = new Scanner(line);
        lineScan.useDelimiter("\\s+");
        String lastName = lineScan.next();
        String firstName = lineScan.next();
        Double donation = lineScan.nextDouble();
        Integer membershipYear = lineScan.nextInt();

        Member newMember = new Member(firstName, lastName, donation, membershipYear);
        add(newMember);
      }
    }
  }

  /**
   * Method checks if item with given searchKey exists in the tree
   *
   * @param searchKey given search query
   * @return TRUE if item with given searchKey was found
   */
  public boolean contains(String searchKey) {
    return list.contains(searchKey);
  }

  /**
   * Method adds new member in the tree
   *
   * @param newMember member that is being added
   */
  public void add(Member newMember) {
    list.insert(newMember);
  }

  /**
   * Method deleted specified member
   *
   * @param member member that is being deleted
   * @return TRUE if deletion was successful
   */
  public boolean delete(Member member) {
    boolean result = false;

    try {
      list.delete(member);
      result = true;
    } catch (TreeException treeException) {
    }

    return result;
  }

  /**
   * Method deletes member by searchKey
   *
   * @param searchKey key of a member that is being deleted
   * @return TRUE if deletion was successful
   */
  public boolean delete(String searchKey) {
    boolean result = false;

    try {
      list.delete(searchKey);
      result = true;
    } catch (TreeException treeException) {
    }

    return result;
  }

  /**
   * Method finds member by given search key
   *
   * @param searchKey key of a member that is being searched
   * @return found member
   */
  public Member find(String searchKey) {
    return list.retrieve(searchKey);
  }

  /**
   * Update money member donated
   *
   * @param updateMember member that is being updated
   * @param donation updated amount of money
   */
  public void update(Member updateMember, double donation) {
    updateMember.setDonated(donation);
  }

  /**
   * Method returns height of the tree
   *
   * @return Height of the tree
   */
  public int getHeight() {
    return list.getHeight();
  }

  @Override
  public String toString() {
    return list.toString();
  }

  public Iterator<Member> getInOrderIterator() {
    return list.iteratorInOrder();
  }
}
