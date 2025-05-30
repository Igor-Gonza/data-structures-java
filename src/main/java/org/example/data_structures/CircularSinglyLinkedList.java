package org.example.data_structures;

public class CircularSinglyLinkedList<T> {
  private Node tail;
  private int size;

  public CircularSinglyLinkedList() {
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

  public void addToIndex(int position, T data) {
    if (position < 0 || position > size)
      throw new IndexOutOfBoundsException();

    if (position == 0) {
      addToBeginning(data);
      return;
    }
    if (position == size) {
      addToEnd(data);
      return;
    }
    Node newNode = new Node(data);
    Node aux = tail.next;
    while (position-- > 1)
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
      Node head = tail.next;
      tail.attach(newNode);
      newNode.attach(head);
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

  public boolean deleteFromIndex(int position) {
    if (position < 0 || position >= size)
      throw new IndexOutOfBoundsException();

    if (position == 0)
      return deleteFirst();

    if (position == size - 1)
      return deleteLast();

    Node aux = tail.next;
    while (position-- > 1)
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

    Node aux = tail;
    do {
      aux = aux.next;
    } while (aux.next != tail);
    Node newTail = aux;
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
    if (tail == null)
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
    private Node next;

    Node(T data) {
      this.data = data;
      this.next = null;
    }

    public void attach(Node newNode) {
      this.next = newNode;
    }
  }
}
