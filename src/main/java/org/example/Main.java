package org.example;

import org.example.data_structures.CircularDoublyLinkedList;
import org.example.data_structures.CircularSinglyLinkedList;
import org.example.data_structures.DoublyLinkedList;
import org.example.data_structures.SinglyLinkedList;


public class Main {
  public static void main(String[] args) {
    System.out.println("  #---- SINGLY ----#");
    singlyLinkedListTest();

    System.out.println("  #---- DOUBLY ----#");
    doublyLinkedListTest();

    System.out.println("  #---- CIRCULAR SINGLY ----#");
    circularSinglyLinkedListTest();

    System.out.println("  #---- CIRCULAR DOUBLY ----#");
    circularDoublyLinkedListTest();
  }

  private static void singlyLinkedListTest() {
    SinglyLinkedList<Integer> list = new SinglyLinkedList<>();

    list.deleteFirst();
    list.deleteLast();

    list.addToEnd(10);
    list.addToEnd(20);
    list.addToEnd(30);
    list.addToEnd(40);
    list.addToEnd(50);

    list.addToBeginning(8);
    list.addToBeginning(6);
    list.addToBeginning(4);
    list.addToBeginning(2);
    list.addToBeginning(1);

    list.deleteFirst();
    list.deleteFirst();
    list.deleteFirst();

    list.deleteLast();
    list.deleteLast();
    list.deleteLast();

    list.revertList();

    list.addToIndex(0, 30);
    list.addToIndex(4, 7);
    list.addToIndex(6, 5);

    list.deleteFromIndex(0);
    list.deleteFromIndex(5);
    list.deleteFromIndex(3);

    list.clear();

    System.out.printf(" -> The first is %d\n", list.getFirst());
    System.out.printf(" -> The last is %d\n", list.getLast());
    System.out.printf(" -> The list has %d elements\n\n", list.getSize());
  }

  private static void doublyLinkedListTest() {
    DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

    list.deleteFirst();
    list.deleteLast();

    list.addToEnd(10);
    list.addToEnd(20);
    list.addToEnd(30);
    list.addToEnd(40);
    list.addToEnd(50);

    list.addToBeginning(8);
    list.addToBeginning(6);
    list.addToBeginning(4);
    list.addToBeginning(2);
    list.addToBeginning(1);

    list.deleteFirst();
    list.deleteFirst();
    list.deleteFirst();

    list.deleteLast();
    list.deleteLast();
    list.deleteLast();

    list.revertList();

    list.addAfterIndex(3, 4);
    list.addAfterIndex(2, 7);
    list.addAfterIndex(0, 15);

    list.addBeforeIndex(6, 5);
    list.addBeforeIndex(3, 9);
    list.addBeforeIndex(0, 25);

    list.deleteFromIndex(2);
    list.deleteFromIndex(0);
    list.deleteFromIndex(7);
    list.deleteFromIndex(5);
    list.deleteFromIndex(3);

    list.clear();

    System.out.printf(" -> The first is %d\n", list.getFirst());
    System.out.printf(" -> The last is %d\n", list.getLast());
    System.out.printf(" -> The list has %d elements\n\n", list.getSize());
  }

  private static void circularSinglyLinkedListTest() {
    CircularSinglyLinkedList<Integer> list = new CircularSinglyLinkedList<>();

    list.deleteFirst();
    list.deleteLast();

    list.addToEnd(10);
    list.addToEnd(20);
    list.addToEnd(30);
    list.addToEnd(40);
    list.addToEnd(50);

    list.addToBeginning(8);
    list.addToBeginning(6);
    list.addToBeginning(4);
    list.addToBeginning(2);
    list.addToBeginning(1);

    list.deleteFirst();
    list.deleteFirst();
    list.deleteFirst();

    list.deleteLast();
    list.deleteLast();
    list.deleteLast();

    list.revertList();

    list.addToIndex(0, 30);
    list.addToIndex(4, 7);
    list.addToIndex(6, 5);

    list.deleteFromIndex(0);
    list.deleteFromIndex(5);
    list.deleteFromIndex(3);

    list.clear();

    System.out.printf(" -> The first is %d\n", list.getFirst());
    System.out.printf(" -> The last is %d\n", list.getLast());
    System.out.printf(" -> The list has %d elements\n\n", list.getSize());
  }

  private static void circularDoublyLinkedListTest() {
    CircularDoublyLinkedList<Integer> list = new CircularDoublyLinkedList<>();

    list.deleteFirst();
    list.deleteLast();

    list.addToEnd(10);
    list.addToEnd(20);
    list.addToEnd(30);
    list.addToEnd(40);
    list.addToEnd(50);

    list.addToBeginning(8);
    list.addToBeginning(6);
    list.addToBeginning(4);
    list.addToBeginning(2);
    list.addToBeginning(1);

    list.deleteFirst();
    list.deleteFirst();
    list.deleteFirst();

    list.deleteLast();
    list.deleteLast();
    list.deleteLast();

    list.revertList();

    list.addAfterIndex(3, 4);
    list.addAfterIndex(2, 7);
    list.addAfterIndex(0, 15);

    list.addBeforeIndex(6, 5);
    list.addBeforeIndex(3, 9);
    list.addBeforeIndex(0, 25);

    list.deleteFromIndex(2);
    list.deleteFromIndex(0);
    list.deleteFromIndex(7);
    list.deleteFromIndex(5);
    list.deleteFromIndex(3);

    list.clear();

    System.out.printf(" -> The first is %d\n", list.getFirst());
    System.out.printf(" -> The last is %d\n", list.getLast());
    System.out.printf(" -> The list has %d elements\n\n", list.getSize());
  }
}