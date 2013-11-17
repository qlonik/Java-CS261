package ast05;

import binaryTree.BinarySearchTree;
import binaryTree.TreeException;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author qlonik
 */
public class MembershipList {

  BinarySearchTree<Member, String> list;

  public MembershipList(Scanner input) {
    list = new BinarySearchTree<>();
    parseFile(input);
  }

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

  public boolean contains(String searchKey) {
    return list.contains(searchKey);
  }

  public void add(Member newMember) {
    list.insert(newMember);
  }

  public boolean delete(Member member) {
    boolean result = false;

    try {
      list.delete(member);
      result = true;
    } catch (TreeException treeException) {
    }

    return result;
  }

  public boolean delete(String searchKey) {
    boolean result = false;

    try {
      list.delete(searchKey);
      result = true;
    } catch (TreeException treeException) {
    }

    return result;
  }

  public Member find(String searchKey) {
    return list.retrieve(searchKey);
  }

  public void update(Member updateMember, double donation) {
    updateMember.setDonated(donation);
  }

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
