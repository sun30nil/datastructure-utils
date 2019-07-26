package com.sunil.ds.immutable.queue;

/**
 * This is an optimal implementation of Immuatable queue.
 * Enqueue is O(1) since item is added to tail.
 * Dequeue is O(N) worst case since tail is reveresed,
 * when head first added head is removed
 * @param <T>
 * @author sunil singh
 */
public final class FastImmutableQueue<T> implements Queue<T> {

  private final LList<T> head;
  private final LList<T> tail;

  private FastImmutableQueue(LList<T> head, LList<T> tail) {
    this.head = head;
    this.tail = tail;
  }

  public final static Queue build() {
    return QueueBuilder.getInstance();
  }

  @Override
  public final Queue<T> enQueue(T t) {
    return new FastImmutableQueue<>(head, tail.addToLast(t));
  }

  @Override
  public final Queue<T> deQueue() throws InvalidOperationException {
    LList<T> headList = head.removeFromLast();
    if (!headList.isEmpty()) {
      return new FastImmutableQueue<>(headList, tail);
    } else if (tail.isEmpty()) {
      return FastImmutableQueue.build();
    }
    // if tail is not empty we need to transfer from tail to head
    return new FastImmutableQueue<>(ListUtils.reverseLList(tail), ImmutableLinkedList.build());
  }

  @Override
  public final T head() throws InvalidOperationException {
    return head.peekLast();
  }

  @Override
  public final boolean isEmpty() {
    return false;
  }

  private static final class QueueBuilder<T> implements Queue<T> {
    private static final QueueBuilder QUEUE_BUILDER = new QueueBuilder<>();

    public static final QueueBuilder getInstance() {
      return QUEUE_BUILDER;
    }

    @Override
    public final Queue<T> enQueue(T t) {
      return new FastImmutableQueue(ImmutableLinkedList.build().addToLast(t),
          ImmutableLinkedList.build());
    }

    @Override
    public final Queue<T> deQueue() throws InvalidOperationException {
      throw new InvalidOperationException("Empty queue!");
    }

    @Override
    public final T head() throws InvalidOperationException {
      throw new InvalidOperationException("Empty queue!");
    }

    @Override
    public final boolean isEmpty() {
      return true;
    }
  }
}
