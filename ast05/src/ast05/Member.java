package ast05;

import binaryTree.KeyedItem;

/*
 * Member.java    Nikita Volodin 127196
 * CS261,   ast05
 * 
 * Class represents member who donated some amount of money
 */
public class Member extends KeyedItem<String> implements Comparable<Member> {

  private String firstName, lastName, membership;
  private int membershipYear;
  private double donated;

  public Member(String firstName, String lastName,
          double donated, int membershipYear) {
    super(createKey(lastName, firstName));
    this.firstName = firstName;
    this.lastName = lastName;
    this.donated = donated;
    this.membershipYear = membershipYear;
    updateMembership();
  }

  /**
   * Static method creates search key
   *
   * @param lastName Last name of member
   * @param firstName First name of member
   * @return Search key for current member
   */
  public static String createKey(String lastName, String firstName) {
    return lastName + " " + firstName;
  }

  /**
   * Method updates membership type depending upon the amount donated
   */
  private void updateMembership() {
    if (donated < 50) {
      membership = "None";
    }
    if (50 <= donated && donated < 250) {
      membership = "Supporter";
    }
    if (250 <= donated && donated < 500) {
      membership = "Contributor";
    }
    if (500 <= donated && donated < 1000) {
      membership = "Benefactor";
    }
    if (1000 <= donated && donated < 5000) {
      membership = "Producer's Circle";
    }
    if (5000 <= donated) {
      membership = "Founders Circle";
    }
  }

  /**
   * Method compares to Members
   *
   * @param o Member that is being compared to
   * @return the difference between members that are being compared
   */
  @Override
  public int compareTo(Member o) {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  /**
   * Method sets amount donated by member
   *
   * @param donated how much donated
   */
  public void setDonated(double donated) {
    this.donated = donated;
    updateMembership();
  }

  /**
   * Methods returns amount donated by member
   *
   * @return how much donated
   */
  public double getDonated() {
    return donated;
  }

  /**
   * Method returns type of the membership of member
   *
   * @return String representation of membership
   */
  public String getMembership() {
    return membership;
  }

  /**
   * Returns year member became member
   *
   * @return Year of becoming member
   */
  public int getMembershipYear() {
    return membershipYear;
  }

  @Override
  public String toString() {
    return lastName + ", " + firstName + " (" + membershipYear + ") - $"
            + donated + " - " + membership;
  }
}
