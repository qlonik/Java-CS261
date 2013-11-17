package ast05;

import binaryTree.KeyedItem;

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

  public static String createKey(String lastName, String firstName) {
    return lastName + " " + firstName;
  }

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

  @Override
  public int compareTo(Member o) {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  public void setDonated(double donated) {
    this.donated = donated;
    updateMembership();
  }

  public double getDonated() {
    return donated;
  }

  public String getMembership() {
    return membership;
  }

  public int getMembershipYear() {
    return membershipYear;
  }

  @Override
  public String toString() {
    return lastName + ", " + firstName + " (" + membershipYear + ") - $"
            + donated + " - " + membership;
  }
}
