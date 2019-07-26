package com.sunil.ds.immutable.queue;

/**
 * This is Immutable Linked List implementation.
 * Items are added to the end.
 * @param <T>
 *
 * @author sunil singh
 */
public final class ImmutableLinkedList<T> implements LList<T> {
  private final T last;
  private final LList<T> beforeLast;

  private ImmutableLinkedList(T last, LList<T> beforeLast) {
    this.last = last;
    this.beforeLast = beforeLast;
  }

  public static final LList build() {
    return LinkedListBuilder.getInstance();
  }

  @Override
  public final LList<T> addToLast(T t) {
    return new ImmutableLinkedList<>(t, this);
  }

  @Override
  public final LList<T> removeFromLast() throws InvalidOperationException {
    return beforeLast;
  }

  @Override
  public final T peekLast() throws InvalidOperationException {
    return last;
  }

  @Override
  public final boolean isEmpty() {
    return false;
  }

  private static final class LinkedListBuilder<T> implements LList<T> {
    private static final LinkedListBuilder LINKED_LIST_BUILDER = new LinkedListBuilder();

    public final static LinkedListBuilder getInstance() {
      return LINKED_LIST_BUILDER;
    }

    @Override
    public final LList<T> addToLast(T t) {
      return new ImmutableLinkedList<>(t, this);
    }

    @Override
    public final LList<T> removeFromLast() throws InvalidOperationException {
      throw new InvalidOperationException("This list is empty");
    }

    @Override
    public final T peekLast() throws InvalidOperationException {
      throw new InvalidOperationException("This list is empty");
    }

    @Override
    public final boolean isEmpty() {
      return true;
    }
  }
}
