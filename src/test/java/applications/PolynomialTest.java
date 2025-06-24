package applications;

import org.example.applications.Polynomial;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Polynomial")
public class PolynomialTest {

  @Test
  @DisplayName("Should start empty")
  void emptyPolynomialTest() {
    float[][] expectedResult = {};
    Polynomial emptyPolynomial = new Polynomial();

    assertEquals(0, emptyPolynomial.getSize());
    assertArrayEquals(expectedResult, emptyPolynomial.toArray());
  }

  @Test
  @DisplayName("Add single term to empty polynomial")
  void addTermTest1() {
    float[][] expectedResult = {{2, 2}};
    Polynomial monomial = new Polynomial();
    monomial.addTerm(2, 2);

    assertEquals(1, monomial.getSize());
    assertArrayEquals(expectedResult, monomial.toArray());
  }

  @Test
  @DisplayName("Add multiple terms to empty polynomial")
  void addTermTest2() {
    float[][] expectedResult = {{5, 5}, {4, 4}, {3, 3}, {2, 2}, {1, 1}};
    Polynomial polynomial = new Polynomial();
    polynomial.addTerm(4, 4);
    polynomial.addTerm(2, 2);
    polynomial.addTerm(5, 5);
    polynomial.addTerm(1, 1);
    polynomial.addTerm(3, 3);

    assertEquals(5, polynomial.getSize());
    assertArrayEquals(expectedResult, polynomial.toArray());
  }

  @Test
  @DisplayName("Add term with coefficient zero")
  void addTermTest3() {
    float[][] expectedResult = {{5, 5}, {4, 4}, {3, 3}, {2, 2}, {1, 1}};
    Polynomial polynomial = createPolynomialA();

    polynomial.addTerm(0, 6);

    assertEquals(5, polynomial.getSize());
    assertArrayEquals(expectedResult, polynomial.toArray());
  }

  @Test
  @DisplayName("Add term that cancels another existing term")
  void addTermTest4() {
    float[][] expectedResult = {{4, 4}, {2, 2}};
    Polynomial polynomial = createPolynomialA();

    polynomial.addTerm(-3, 3);
    polynomial.addTerm(-5, 5);
    polynomial.addTerm(-1, 1);

    assertEquals(2, polynomial.getSize());
    assertArrayEquals(expectedResult, polynomial.toArray());
  }

  @Test
  @DisplayName("Add term that cancel the whole polynomial")
  void addTermTest5() {
    float[][] expectedResult = {};
    Polynomial monomial = createMonomial();

    monomial.addTerm(-3, 3);

    assertEquals(0, monomial.getSize());
    assertArrayEquals(expectedResult, monomial.toArray());
  }

  @Test
  @DisplayName("Add two empty polynomials")
  void addTest1() {
    float[][] expectedResult = {};
    Polynomial p1 = new Polynomial();
    Polynomial p2 = new Polynomial();
    Polynomial result = p1.add(p2);

    assertTrue(p1.equals(p2));
    assertTrue(p1.equals(result));
    assertEquals(0, result.getSize());
    assertArrayEquals(expectedResult, result.toArray());
  }

  @Test
  @DisplayName("Add empty polynomial and a monomial")
  void addTest2() {
    float[][] expectedResult = {{3, 3}};
    Polynomial empty = new Polynomial();
    Polynomial monomial = createMonomial();

    Polynomial resultA = empty.add(monomial);
    Polynomial resultB = monomial.add(empty);

    assertTrue(resultA.equals(monomial));
    assertEquals(1, resultA.getSize());
    assertArrayEquals(expectedResult, resultA.toArray());

    assertTrue(resultB.equals(monomial));
    assertEquals(1, resultB.getSize());
    assertArrayEquals(expectedResult, resultB.toArray());
  }

  @Test
  @DisplayName("Add empty polynomial and a polynomial")
  void addTest3() {
    float[][] expectedResult = {{5, 5}, {4, 4}, {3, 3}, {2, 2}, {1, 1}};
    Polynomial empty = new Polynomial();
    Polynomial polynomial = createPolynomialA();

    Polynomial resultA = empty.add(polynomial);
    Polynomial resultB = polynomial.add(empty);

    assertTrue(resultA.equals(polynomial));
    assertEquals(5, resultA.getSize());
    assertArrayEquals(expectedResult, resultA.toArray());

    assertTrue(resultB.equals(polynomial));
    assertEquals(5, resultB.getSize());
    assertArrayEquals(expectedResult, resultB.toArray());
  }

  @Test
  @DisplayName("Add two polynomials")
  void addTest4() {
    float[][] expectedResult = {{10, 10}, {8, 8}, {6, 6}, {5, 5}, {8, 4}, {3, 3}, {4, 2}, {1, 1}};
    Polynomial p1 = createPolynomialA();
    Polynomial p2 = createPolynomialB();

    Polynomial resultA = p1.add(p2);
    Polynomial resultB = p2.add(p1);

    assertEquals(8, resultA.getSize());
    assertArrayEquals(expectedResult, resultA.toArray());

    assertEquals(8, resultB.getSize());
    assertArrayEquals(expectedResult, resultB.toArray());
  }

  @Test
  @DisplayName("Add polynomials that cancel each other")
  void addTest5() {
    float[][] expectedResult = {};
    Polynomial p1 = createPolynomialA();
    Polynomial inverse = createInversePolynomialA();

    Polynomial resultA = p1.add(inverse);
    Polynomial resultB = inverse.add(p1);

    assertEquals(0, resultA.getSize());
    assertArrayEquals(expectedResult, resultA.toArray());

    assertEquals(0, resultB.getSize());
    assertArrayEquals(expectedResult, resultB.toArray());
  }

  @Test
  @DisplayName("Multiply two empty polynomials")
  void multiplyTest1() {
    float[][] expectedResult = {};
    Polynomial p1 = new Polynomial();
    Polynomial p2 = new Polynomial();
    Polynomial result = p1.multiply(p2);

    assertTrue(p1.equals(p2));
    assertTrue(p1.equals(result));
    assertEquals(0, result.getSize());
    assertArrayEquals(expectedResult, result.toArray());
  }

  @Test
  @DisplayName("Multiply empty polynomial and a monomial")
  void multiplyTest2() {
    float[][] expectedResult = {};
    Polynomial empty = new Polynomial();
    Polynomial monomial = createMonomial();

    Polynomial resultA = empty.multiply(monomial);
    Polynomial resultB = monomial.multiply(empty);

    assertTrue(resultA.equals(empty));
    assertEquals(0, resultA.getSize());
    assertArrayEquals(expectedResult, resultA.toArray());

    assertTrue(resultB.equals(empty));
    assertEquals(0, resultB.getSize());
    assertArrayEquals(expectedResult, resultB.toArray());
  }

  @Test
  @DisplayName("Multiply empty polynomial and a polynomial")
  void multiplyTest3() {
    float[][] expectedResult = {};
    Polynomial empty = new Polynomial();
    Polynomial polynomial = createPolynomialA();

    Polynomial resultA = empty.multiply(polynomial);
    Polynomial resultB = polynomial.multiply(empty);

    assertTrue(resultA.equals(empty));
    assertEquals(0, resultA.getSize());
    assertArrayEquals(expectedResult, resultA.toArray());

    assertTrue(resultB.equals(empty));
    assertEquals(0, resultB.getSize());
    assertArrayEquals(expectedResult, resultB.toArray());
  }

  @Test
  @DisplayName("Multiply two polynomials")
  void multiplyTest4() {
    float[][] expectedResult = {{50, 15}, {40, 14}, {70, 13}, {52, 12}, {64, 11}, {40, 10},
            {46, 9}, {28, 8}, {28, 7}, {16, 6}, {10, 5}, {4, 4}, {2, 3}};
    Polynomial p1 = createPolynomialA();
    Polynomial p2 = createPolynomialB();

    Polynomial resultA = p1.multiply(p2);
    Polynomial resultB = p2.multiply(p1);

    assertEquals(13, resultA.getSize());
    assertArrayEquals(expectedResult, resultA.toArray());

    assertEquals(13, resultB.getSize());
    assertArrayEquals(expectedResult, resultB.toArray());
  }

  @Test
  @DisplayName("Multiply multiple polynomials")
  void multiplyTest5() {
    float[][] expectedResult = {{1, 3}, {-1, 1}};
    Polynomial p1 = new Polynomial();
    p1.addTerm(1, 1);
    p1.addTerm(1, 0);

    Polynomial p2 = new Polynomial();
    p2.addTerm(1, 1);

    Polynomial p3 = new Polynomial();
    p3.addTerm(1, 1);
    p3.addTerm(-1, 0);

    Polynomial result = p1.multiply(p2).multiply(p3);

    assertEquals(2, result.getSize());
    assertArrayEquals(expectedResult, result.toArray());
  }

  @Test
  @DisplayName("Compare empty polynomials")
  void equalsTest1() {
    Polynomial p1 = new Polynomial();
    Polynomial p2 = new Polynomial();

    assertTrue(p1.equals(p2));
  }

  @Test
  @DisplayName("Compare polynomials with different sizes")
  void equalsTest2() {
    Polynomial p1 = new Polynomial();
    p1.addTerm(3, 3);
    p1.addTerm(2, 2);
    p1.addTerm(1, 1);

    Polynomial p2 = new Polynomial();
    p2.addTerm(3, 3);
    p2.addTerm(2, 2);

    assertFalse(p1.equals(p2));
  }

  @Test
  @DisplayName("Compare polynomials with clashing coefficients")
  void equalsTest3() {
    Polynomial p1 = new Polynomial();
    p1.addTerm(3, 3);
    p1.addTerm(4, 2);
    p1.addTerm(1, 1);

    Polynomial p2 = new Polynomial();
    p2.addTerm(3, 3);
    p2.addTerm(2, 2);
    p2.addTerm(1, 1);

    assertFalse(p1.equals(p2));
  }

  @Test
  @DisplayName("Compare polynomials with clashing exponents")
  void equalsTest4() {
    Polynomial p1 = new Polynomial();
    p1.addTerm(3, 3);
    p1.addTerm(2, 2);
    p1.addTerm(1, 1);

    Polynomial p2 = new Polynomial();
    p2.addTerm(3, 3);
    p2.addTerm(2, 2);
    p2.addTerm(1, 0);

    assertFalse(p1.equals(p2));
  }

  @Test
  @DisplayName("Compare actually similar polynomials")
  void equalsTest5() {
    Polynomial p1 = new Polynomial();
    p1.addTerm(3, 3);
    p1.addTerm(2, 2);
    p1.addTerm(1, 1);

    Polynomial p2 = new Polynomial();
    p2.addTerm(3, 3);
    p2.addTerm(2, 2);
    p2.addTerm(1, 1);

    assertTrue(p1.equals(p2));
  }

  private Polynomial createMonomial() {
    Polynomial monomial = new Polynomial();
    monomial.addTerm(3, 3);
    return monomial;
  }

  private Polynomial createPolynomialA() {
    Polynomial polynomial = new Polynomial();
    polynomial.addTerm(5, 5);
    polynomial.addTerm(4, 4);
    polynomial.addTerm(3, 3);
    polynomial.addTerm(2, 2);
    polynomial.addTerm(1, 1);
    return polynomial;
  }

  private Polynomial createInversePolynomialA() {
    Polynomial polynomial = new Polynomial();
    polynomial.addTerm(-5, 5);
    polynomial.addTerm(-4, 4);
    polynomial.addTerm(-3, 3);
    polynomial.addTerm(-2, 2);
    polynomial.addTerm(-1, 1);
    return polynomial;
  }

  private Polynomial createPolynomialB() {
    Polynomial polynomial = new Polynomial();
    polynomial.addTerm(10, 10);
    polynomial.addTerm(8, 8);
    polynomial.addTerm(6, 6);
    polynomial.addTerm(4, 4);
    polynomial.addTerm(2, 2);
    return polynomial;
  }
}
