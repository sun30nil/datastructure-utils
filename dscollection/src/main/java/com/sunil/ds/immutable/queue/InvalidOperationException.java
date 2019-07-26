package com.sunil.ds.immutable.queue;

/**
 * If an operation is invalid or cannot be performed like dequeueing and already empty queue.
 *
 * @author sunil singh
 */
public class InvalidOperationException extends RuntimeException {

  /**
   * Constructs InvalidOperationException with no message
   */
  public InvalidOperationException() {
    super();
  }

  /**
   * Constructs InvalidOperationException with passed message
   * @param message
   */
  public InvalidOperationException(String message) {
    super(message);
  }

}
