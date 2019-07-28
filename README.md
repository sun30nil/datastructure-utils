# datastructure-utils

# Immutable Queue:

Usage:

Clone: 

```git clone https://github.com/sun30nil/datastructure-utils.git```

Change to the java project directory

```cd dscollection```

To ensure all the tests run successfully, run below command

```mvn clean test```
### Brute-Force Implementation:
1. Uses java.utils LinkedList to preserve queue elements
2. Enqueue is O(N), since existing LinkedList is cloned with every enqueue operation
3. Dequeue is O(N), since existing LinkedList is cloned with every dequeue operation
4. Refer to this implementation ```com.sunil.ds.immutable.queue.ImmutableQueue```
5. Refer to the unit tests here ```com.sunil.ds.immutable.queue.ImmutableQueueTest```

### Efficient Implementation:
1. Uses Immutable LinkedList with addToLast and removeFromLast implementation using headLinkedList and tailLinkedList
2. Every enqueue is O(1) since item is added to the end of the ImmutableLinkedList
3. Dequeue is O(N) in worst case since ref to first inserted item to queue is held as head and when thats empty we need reverse the tail queue to head LinkedList
4. Implementation ref: ```com.sunil.ds.immutable.queue.FastImmutableQueue```
5. Unit tests:  ```com.sunil.ds.immutable.queue.FastImmutableQueueTest```


# Analytics Backend System Design

