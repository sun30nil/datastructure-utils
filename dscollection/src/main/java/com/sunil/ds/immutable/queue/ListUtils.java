package com.sunil.ds.immutable.queue;

/**
 * List based utils
 *
 * @author sunil singh
 */
public final class ListUtils {


  /**
   * Reverse a given linked list
   * @param lList
   * @return reverse of the lList
   */
  public static final LList reverseLList(LList lList) {
    LList lL = ImmutableLinkedList.build();
    while(!lList.isEmpty()) {
      lL = lL.addToLast(lList.peekLast());
      lList = lList.removeFromLast();
    }
    return lL;
  }
}
