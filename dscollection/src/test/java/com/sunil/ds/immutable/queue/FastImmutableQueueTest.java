package com.sunil.ds.immutable.queue;

import org.junit.Assert;
import org.junit.Test;

public class FastImmutableQueueTest extends Assert {

  @Test(expected = InvalidOperationException.class)
  public void testDequeueEmptyInvalidException() {
    Queue<Integer> queue = FastImmutableQueue.build();
    queue.deQueue();
  }

  @Test(expected = InvalidOperationException.class)
  public void testHeadEmptyInvalidException() {
    Queue<Integer> queue = FastImmutableQueue.build();
    queue.head();
  }

  @Test
  public void testBasicQueueOperation() {
    Queue<Integer> queue = FastImmutableQueue.build();
    queue.enQueue(1);
    queue.enQueue(2);
    assertTrue("The queue should be empty", queue.isEmpty());
    Queue<Integer> queue1 = queue.enQueue(3);
    assertTrue("The queue should be empty", queue.isEmpty());
    assertTrue("Q1 dequeue should be empty queue", queue1.deQueue().isEmpty());
    assertTrue("The queue should be empty", queue.isEmpty());
    Queue<Integer> queue2 = queue.enQueue(4);
    queue2 = queue2.enQueue(5);
    queue2 = queue2.enQueue(6);
    assertTrue("The queue should be empty", queue.isEmpty());
    assertFalse("The queue1 should be not be empty", queue1.isEmpty());
    assertFalse("The queue2 should not be empty", queue1.isEmpty());
    queue2 = queue2.deQueue();
    assertEquals("queue2 dequeue should be 5", queue2.head().intValue(), 5);
    queue2 = queue2.deQueue();
    assertEquals("queue2 dequeue should be 6", queue2.head().intValue(), 6);
    queue2 = queue2.deQueue();
    assertTrue("queue2 dequeue should be now empty", queue2.isEmpty());
  }

}
