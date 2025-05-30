package org.example.data_structures;

public class SinglyLinkedList<T> {
  private Node head;
  private Node tail;
  private int size;

  public SinglyLinkedList() {
    this.head = null;
    this.tail = null;
    this.size = 0;
  }

  public void addToBeginning(T data) {
    Node newNode = new Node(data);
    if (size == 0)
      tail = newNode;
    else
      newNode.attach(head);
    head = newNode;
    size++;
  }

  public void addToIndex(int index, T data) {
    if (index < 0 || index > size)
      throw new IndexOutOfBoundsException();

    if (index == 0) {
      addToBeginning(data);
      return;
    }
    if (index == size) {
      addToEnd(data);
      return;
    }
    Node newNode = new Node(data);
    Node aux = head;
    while (index-- > 1)
      aux = aux.next;
    newNode.attach(aux.next);
    aux.attach(newNode);
    size++;
  }

  public void addToEnd(T data) {
    Node newNode = new Node(data);
    if (size == 0)
      head = newNode;
    else
      tail.attach(newNode);
    tail = newNode;
    size++;
  }

  public boolean deleteFirst() {
    if (size == 0)
      return false;

    if (size == 1)
      return clear();

    head = head.next;
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

    Node aux = head;
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

    Node aux = head;
    while (aux.next.next != null)
      aux = aux.next;
    tail = aux;
    tail.detachFromNext();
    size--;
    return true;
  }

  public boolean clear() {
    head = null;
    tail = null;
    size = 0;
    return true;
  }

  public void revertList() {
    if (size < 2)
      return;

    Node prev;
    Node curr = head;
    Node next = head.next;
    tail = head;
    curr.detachFromNext();
    while (next != null) {
      prev = next;
      next = next.next;
      prev.attach(curr);
      curr = prev;
    }
    head = curr;
  }

  public Object[] toArray() {
    Object[] array = new Object[size];
    Node current = head;
    int index = 0;
    while (current != null) {
      array[index++] = current.data;
      current = current.next;
    }
    return array;
  }

  public T getFirst() {
    return size == 0 ? null : head.data;
  }

  public T getLast() {
    return size == 0 ? null : tail.data;
  }

  public int getSize() {
    return size;
  }

  private class Node {
    final T data;
    private Node next;

    Node(T data) {
      this.data = data;
      this.next = null;
    }

    public void attach(Node newNode) {
      this.next = newNode;
    }

    public void detachFromNext() {
      this.next = null;
    }
  }
}
