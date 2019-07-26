package com.sunil.ds.immutable.queue;

import java.util.LinkedList;
import java.util.List;

/**
 * This is Immutable Queue implementation using LinkedList as the FIFO management datastructure.
 * LinkedList will have O(1) enqueue and O(1) dequeue operation.
 * Enqueue Operation => O(N) since we're create a new copy of the existing LL and adding new item to it
 * and again creating an instance of this class.
 * @param <T>
 *
 * @author sunil singh
 */
public final class ImmutableQueue<T> implements Queue<T> {

  private final List<T> linkedList;

  public ImmutableQueue(List<T> list) {
    this.linkedList = new LinkedList(list);
  }

  public ImmutableQueue() {
    this.linkedList = new LinkedList<>();
  }

  @Override
  public Queue<T> enQueue(T t) {
    List<T> tempLl = new LinkedList<>(this.linkedList);
    ((LinkedList<T>) tempLl).addLast(t);
    return new ImmutableQueue(tempLl);
  }

  @Override
  public Queue<T> deQueue() {
    if (this.isEmpty()) {
      throw new InvalidOperationException("Cannot dequeue an already empty queue.");
    }
    List<T> tempLl= new LinkedList<>(this.linkedList);
    ((LinkedList<T>) tempLl).removeFirst();
    return new ImmutableQueue(tempLl);
  }

  @Override
  public T head() {
    if (this.isEmpty()) {
      throw new InvalidOperationException("Cannot get head of an already empty queue.");
    }
    return (T) ((LinkedList)this.linkedList).peekFirst();
  }

  @Override
  public boolean isEmpty() {
    return this.linkedList.isEmpty();
  }
}
