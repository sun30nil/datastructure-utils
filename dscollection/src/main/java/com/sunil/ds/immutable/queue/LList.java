package com.sunil.ds.immutable.queue;

/**
 * Generic interface for Linked List
 * @param <T>
 */
public interface LList<T> {

  /**
   * add to the end of the queue
   * @param t
   * @return
   */
  LList<T> addToLast(T t);

  /**
   * remove from the end of the linked list
   * @return return immutable linked list after remove the last element
   * @throws InvalidOperationException
   */
  LList<T> removeFromLast() throws InvalidOperationException;

  /**
   * query the last item of the list without removing it
   * @return last element
   * @throws InvalidOperationException
   */
  T peekLast() throws InvalidOperationException;

  /**
   * check if the list is empty
   * @return
   */
  boolean isEmpty();

}
