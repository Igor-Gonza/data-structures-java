package org.example.applications;

public class Polynomial {
  private Node head;

  public Polynomial() {
    this.head = null;
  }

  public void add(float coefficient, int exponent) {
    if (coefficient == 0)
      return;

    Node newNode = new Node(coefficient, exponent);
    if (head == null) {
      head = newNode;
      return;
    }
    if (exponent > head.exponent) {
      newNode.attach(head);
      head = newNode;
      return;
    }

    Node aux = head;
    while (aux.next != null && exponent <= aux.next.exponent)
      aux = aux.next;

    if (aux.exponent == exponent) {
      aux.coefficient += coefficient;
      if (aux.coefficient == 0) {
        deleteNode(aux);
      }
    } else if (aux.next == null) {
      aux.attach(newNode);
    } else {
      newNode.attach(aux.next);
      aux.attach(newNode);
    }
  }

  private void deleteNode(Node node) {
    if (node != head) {
      node.prev.attach(node.next);
      return;
    }
    head = node.next;
    if (head != null) {
      head.prev = null;
    }
  }

  public Polynomial add(Polynomial addend) {
    Node aux1 = addend.getHead();
    Node aux2 = this.head;
    Polynomial result = new Polynomial();

    while (aux1 != null && aux2 != null) {
      if (aux1.exponent == aux2.exponent) {
        float sum = aux1.coefficient + aux2.coefficient;
        if (sum != 0)
          result.add(sum, aux1.exponent);
        aux1 = aux1.next;
        aux2 = aux2.next;
      } else if (aux1.exponent > aux2.exponent) {
        result.add(aux1.coefficient, aux1.exponent);
        aux1 = aux1.next;
      } else {
        result.add(aux2.coefficient, aux2.exponent);
        aux2 = aux2.next;
      }
    }
    while (aux1 != null) {
      result.add(aux1.coefficient, aux1.exponent);
      aux1 = aux1.next;
    }
    while (aux2 != null) {
      result.add(aux2.coefficient, aux2.exponent);
      aux2 = aux2.next;
    }
    return result;
  }

  public Polynomial multiply(Polynomial multiplier) {
    Node aux1 = multiplier.getHead();
    Node aux2 = this.head;
    Polynomial result = new Polynomial();

    if (aux1 == null || aux2 == null)
      return result;

    while (aux1 != null) {
      while (aux2 != null) {
        float coefficientsProduct = aux1.coefficient * aux2.coefficient;
        int exponentsSum = aux1.exponent + aux2.exponent;
        result.add(coefficientsProduct, exponentsSum);
        aux2 = aux2.next;
      }
      aux1 = aux1.next;
      aux2 = this.head;
    }
    return result;
  }

  public boolean isEqual(Polynomial polynomial) {
    Node aux1 = polynomial.getHead();
    Node aux2 = this.head;

    if (aux1 == null && aux2 == null)
      return true;

    while (aux1 != null && aux2 != null) {
      if (!floatEquals(aux1.coefficient, aux2.coefficient))
        return false;
      if (aux1.exponent != aux2.exponent)
        return false;
      aux1 = aux1.next;
      aux2 = aux2.next;
    }
    return aux1 == null && aux2 == null;
  }

  private boolean floatEquals(float a, float b) {
    return Math.abs(a - b) < 1e-6f;
  }

  Node getHead() {
    return head;
  }

  public void print() {
    if (head == null) {
      System.out.println("No polynomial");
      return;
    }
    Node curr = head;
    while (curr != null) {
      System.out.printf("(%.1fx^%d)", curr.coefficient, curr.exponent);
      curr = curr.next;
      if (curr != null)
        System.out.print(" + ");
    }
  }

  private static class Node {
    float coefficient;
    int exponent;
    Node prev;
    Node next;

    Node(float coefficient, int exponent) {
      this.coefficient = coefficient;
      this.exponent = exponent;
      this.prev = null;
      this.next = null;
    }

    public void attach(Node newNode) {
      this.next = newNode;
      if (newNode != null)
        newNode.prev = this;
    }
  }
}
