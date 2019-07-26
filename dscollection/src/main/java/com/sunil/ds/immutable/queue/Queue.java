package com.sunil.ds.immutable.queue;

/**
 *
 * This ideas of using the interface is to implement immutable Queue.
 * functionalities following FIFO principles.
 *
 * @param <T> the type used in the queue
 *
 *
 * @author sunil singh
 * @see ImmutableQueue
 */
public interface Queue<T> {

  /**
   * Add item to the queue
   * @param t
   * @return clone of the modified queue instance
   */
  Queue<T> enQueue(T t);

  /**
   * Remove item from the queue
   * @return clone of the modified queue instance
   * @throws InvalidOperationException if the queue is empty
   */
  Queue<T> deQueue() throws InvalidOperationException;

  /**
   * Peek the head of the queue
   * @return the head value and null if the queue is empty
   * @throws InvalidOperationException if the queue is empty
   */
  T head() throws InvalidOperationException;

  /**
   * Check if the queue is empty or not
   * @return boolean depending on the queue's empty or not
   */
  boolean isEmpty();
}
