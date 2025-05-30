package org.example.data_structures;

public class CircularDoublyLinkedList<T> {
  private Node tail;
  private int size;

  public CircularDoublyLinkedList() {
    this.tail = null;
    this.size = 0;
  }

  public void addToEnd(T data) {
    Node newNode = new Node(data);
    if (size == 0)
      newNode.attach(newNode);
    else {
      Node head = tail.next;
      tail.attach(newNode);
      newNode.attach(head);
    }
    tail = newNode;
    size++;
  }

  public void addAfterIndex(int index, T data) {
    if (index < 0 || index >= size)
      throw new IndexOutOfBoundsException();

    if (index == size - 1) {
      addToEnd(data);
      return;
    }
    Node newNode = new Node(data);
    Node aux = tail.next;
    while (index-- > 0)
      aux = aux.next;
    newNode.attach(aux.next);
    aux.attach(newNode);
    size++;
  }

  public void addBeforeIndex(int index, T data) {
    if (index < 0 || index >= size)
      throw new IndexOutOfBoundsException();

    if (index == 0) {
      addToBeginning(data);
      return;
    }
    Node newNode = new Node(data);
    Node aux = tail.next;
    while (index-- > 1)
      aux = aux.next;
    newNode.attach(aux.next);
    aux.attach(newNode);
    size++;
  }

  public void addToBeginning(T data) {
    Node newNode = new Node(data);
    if (size == 0) {
      tail = newNode;
      newNode.attach(newNode);
    } else {
      Node oldHead = tail.next;
      tail.attach(newNode);
      newNode.attach(oldHead);
    }
    size++;
  }

  public boolean deleteFirst() {
    if (size == 0)
      return false;

    if (size == 1)
      return clear();

    Node newHead = tail.next.next;
    tail.attach(newHead);
    size--;
    return true;
  }

  public boolean deleteFromIndex(int index) {
    if (index < 0 || index >= size)
      throw new IndexOutOfBoundsException();

    if (index == 0)
      return deleteFirst();

    if (index == size - 1)
      return deleteLast();

    Node aux = tail.next;
    while (index-- > 2)
      aux = aux.next;
    aux.attach(aux.next.next);
    size--;
    return true;
  }

  public boolean deleteLast() {
    if (size == 0)
      return false;

    if (size == 1)
      return clear();

    Node newTail = tail.prev;
    Node head = tail.next;
    newTail.attach(head);
    tail = newTail;
    size--;
    return true;
  }

  public boolean clear() {
    tail = null;
    size = 0;
    return true;
  }

  public void revertList() {
    if (size < 2)
      return;

    Node oldHead = tail.next;
    Node prev = tail;
    Node curr = tail.next;
    Node next;
    do {
      next = curr.next;
      curr.attach(prev);
      prev = curr;
      curr = next;
    } while (curr != oldHead);
    tail = oldHead;
  }

  public Object[] toArray() {
    Object[] array = new Object[size];
    if (size == 0)
      return array;

    Node current = tail.next;
    int index = 0;
    do {
      array[index++] = current.data;
      current = current.next;
    } while (current != tail.next);
    return array;
  }

  public T getFirst() {
    return tail == null ? null : tail.next.data;
  }

  public T getLast() {
    return tail == null ? null : tail.data;
  }

  public int getSize() {
    return this.size;
  }

  private class Node {
    private final T data;
    private Node prev;
    private Node next;

    Node(T data) {
      this.data = data;
      this.prev = null;
      this.next = null;
    }

    public void attach(Node newNode) {
      newNode.prev = this;
      this.next = newNode;
    }
  }
}
