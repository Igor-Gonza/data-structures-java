package org.example;

import org.example.applications.Polynomial;

public class Main {
  public static void main(String[] args) {
    sumTest();
    productTest();
  }

  public static void sumTest() {
    Polynomial teste1 = new Polynomial();
    Polynomial teste2 = new Polynomial();

    teste1.addTerm(23, 6);
    teste1.addTerm(2, 4);
    teste1.addTerm(12, 3);

    teste2.addTerm(12, 6);
    teste2.addTerm(7, 3);
    teste2.addTerm(25, 5);
    teste2.addTerm(43, 0);

    Polynomial teste3 = teste1.add(teste2);

    System.out.println("Sum");
    teste1.print();
    System.out.println();
    teste2.print();
    System.out.println();
    teste3.print();
    System.out.println();
    System.out.println();
  }

  public static void productTest() {
    Polynomial teste4 = new Polynomial();
    Polynomial teste5 = new Polynomial();

    teste4.addTerm(4, 3);
    teste4.addTerm(6, 6);
    teste4.addTerm(8, 1);

    teste5.addTerm(7, 3);
    teste5.addTerm(3, 2);
    teste5.addTerm(2, 1);
    teste5.addTerm(1, 0);

    Polynomial teste6 = teste4.multiply(teste5);

    System.out.println("Product");
    teste4.print();
    System.out.println();
    teste5.print();
    System.out.println();
    teste6.print();
    System.out.println();
  }
}