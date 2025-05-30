package data_structures;

import org.example.data_structures.DoublyLinkedList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Doubly Linked List")
public class DoublyLinkedListTest {

  DoublyLinkedList<Integer> list;
  Integer[] expectedResult = null;

  @BeforeEach
  void setup() {
    list = new DoublyLinkedList<>();
  }

  @AfterEach
  void teardown() {
    if (expectedResult != null) {
      assertArrayEquals(expectedResult, list.toArray());
      expectedResult = null;
    }
    list = null;
  }

  @Test
  @DisplayName("Should start empty")
  void emptyListTest() {
    assertListState(0, null, null);
    expectEmpty();
  }

  @Test
  @DisplayName("Add to beginning of empty list")
  void addToBeginningTest1() {
    int addedItem = 42;

    list.addToBeginning(addedItem);

    assertListState(1, addedItem, addedItem);
    expectListOf(42);
  }

  @Test
  @DisplayName("Add multiple items to beginning")
  void addToBeginningTest2() {
    int firstAdded = 10;
    int secondAdded = 20;
    int thirdAdded = 30;
    int fourthAdded = 40;

    list.addToBeginning(firstAdded);
    list.addToBeginning(secondAdded);
    list.addToBeginning(thirdAdded);
    list.addToBeginning(fourthAdded);

    assertListState(4, fourthAdded, firstAdded);
    expectListOf(40, 30, 20, 10);
  }

  @Test
  @DisplayName("Add to end of empty list")
  void addToEndTest1() {
    int addedItem = 42;

    list.addToEnd(addedItem);

    assertListState(1, addedItem, addedItem);
    expectListOf(42);
  }

  @Test
  @DisplayName("Add multiple items to end")
  void addToEndTest2() {
    int firstAdded = 10;
    int secondAdded = 20;
    int thirdAdded = 30;
    int fourthAdded = 40;

    list.addToEnd(firstAdded);
    list.addToEnd(secondAdded);
    list.addToEnd(thirdAdded);
    list.addToEnd(fourthAdded);

    assertListState(4, firstAdded, fourthAdded);
    expectListOf(10, 20, 30, 40);
  }

  @Test
  @DisplayName("Add after position at the beginning")
  void addAfterIndexTest1() {
    int firstAdded = 10;
    int secondAdded = 20;
    int thirdAdded = 30;
    populateListWithMultipleItems();

    list.addAfterIndex(0, firstAdded);
    list.addAfterIndex(0, secondAdded);
    list.addAfterIndex(0, thirdAdded);

    assertListState(8, 1, 5);
    expectListOf(1, 30, 20, 10, 2, 3, 4, 5);
  }

  @Test
  @DisplayName("Add after position at the end")
  void addAfterIndexTest2() {
    int firstAdded = 10;
    int secondAdded = 20;
    int thirdAdded = 30;
    populateListWithMultipleItems();

    list.addAfterIndex(4, firstAdded);
    list.addAfterIndex(5, secondAdded);
    list.addAfterIndex(6, thirdAdded);

    assertListState(8, 1, thirdAdded);
    expectListOf(1, 2, 3, 4, 5, 10, 20, 30);
  }

  @Test
  @DisplayName("Add after position in the middle")
  void addAfterIndexTest3() {
    int firstAdded = 20;
    int secondAdded = 30;
    int thirdAdded = 40;
    populateListWithMultipleItems();

    list.addAfterIndex(1, firstAdded);
    list.addAfterIndex(3, secondAdded);
    list.addAfterIndex(5, thirdAdded);

    assertListState(8, 1, 5);
    expectListOf(1, 2, 20, 3, 30, 4, 40, 5);
  }

  @Test
  @DisplayName("Should throw exception when adding after position in empty list")
  void addAfterIndexTest4() {
    int addedItem = 42;

    assertThrows(IndexOutOfBoundsException.class, () -> list.addAfterIndex(0, addedItem));
  }

  @Test
  @DisplayName("Should throw exception when adding after invalid position")
  void addAfterIndexTest5() {
    int addedItem = 42;
    populateListWithMultipleItems();

    assertThrows(IndexOutOfBoundsException.class, () -> list.addAfterIndex(6, addedItem));
    assertThrows(IndexOutOfBoundsException.class, () -> list.addAfterIndex(-1, addedItem));
  }

  @Test
  @DisplayName("Add before position at the beginning")
  void addBeforeIndexTest1() {
    int firstAdded = 10;
    int secondAdded = 20;
    int thirdAdded = 30;
    populateListWithMultipleItems();

    list.addBeforeIndex(0, firstAdded);
    list.addBeforeIndex(0, secondAdded);
    list.addBeforeIndex(0, thirdAdded);

    assertListState(8, thirdAdded, 5);
    expectListOf(30, 20, 10, 1, 2, 3, 4, 5);
  }

  @Test
  @DisplayName("Add before position at the end")
  void addBeforeIndexTest2() {
    int firstAdded = 10;
    int secondAdded = 20;
    int thirdAdded = 30;
    populateListWithMultipleItems();

    list.addBeforeIndex(4, firstAdded);
    list.addBeforeIndex(5, secondAdded);
    list.addBeforeIndex(6, thirdAdded);

    assertListState(8, 1, 5);
    expectListOf(1, 2, 3, 4, 10, 20, 30, 5);
  }

  @Test
  @DisplayName("Add before position in the middle")
  void addBeforeIndexTest3() {
    int firstAdded = 10;
    int secondAdded = 20;
    int thirdAdded = 30;
    populateListWithMultipleItems();

    list.addBeforeIndex(1, firstAdded);
    list.addBeforeIndex(3, secondAdded);
    list.addBeforeIndex(5, thirdAdded);

    assertListState(8, 1, 5);
    expectListOf(1, 10, 2, 20, 3, 30, 4, 5);
  }

  @Test
  @DisplayName("Should throw exception when adding before position in empty list")
  void addBeforeIndexTest4() {
    int addedItem = 42;

    assertThrows(IndexOutOfBoundsException.class, () -> list.addBeforeIndex(0, addedItem));
  }

  @Test
  @DisplayName("Should throw exception when adding before invalid position")
  void addBeforeIndexTest5() {
    int addedItem = 42;
    populateListWithMultipleItems();

    assertThrows(IndexOutOfBoundsException.class, () -> list.addBeforeIndex(6, addedItem));
    assertThrows(IndexOutOfBoundsException.class, () -> list.addBeforeIndex(-1, addedItem));
  }

  @Test
  @DisplayName("Delete first from empty list")
  void deleteFirstTest1() {
    assertFalse(list.deleteFirst());

    assertListState(0, null, null);
    expectEmpty();
  }

  @Test
  @DisplayName("Delete first from 1 item list")
  void deleteFirstTest2() {
    populateListWithSingleItem();

    assertTrue(list.deleteFirst());

    assertListState(0, null, null);
    expectEmpty();
  }

  @Test
  @DisplayName("Delete first from 2+ items list")
  void deleteFirstTest3() {
    populateListWithMultipleItems();

    assertTrue(list.deleteFirst());

    assertListState(4, 2, 5);
    expectListOf(2, 3, 4, 5);
  }

  @Test
  @DisplayName("Delete last from empty list")
  void deleteLastTest1() {
    assertFalse(list.deleteLast());

    assertListState(0, null, null);
    expectEmpty();
  }

  @Test
  @DisplayName("Delete last from 1 item list")
  void deleteLastTest2() {
    populateListWithSingleItem();

    assertTrue(list.deleteLast());

    assertListState(0, null, null);
    expectEmpty();
  }

  @Test
  @DisplayName("Delete last from 2+ items list")
  void deleteLastTest3() {
    populateListWithMultipleItems();

    assertTrue(list.deleteLast());

    assertListState(4, 1, 4);
    expectListOf(1, 2, 3, 4);
  }

  @Test
  @DisplayName("Delete from position at the beginning")
  void deleteFromIndexTest1() {
    populateListWithMultipleItems();

    assertTrue(list.deleteFromIndex(0));
    assertTrue(list.deleteFromIndex(0));
    assertTrue(list.deleteFromIndex(0));

    assertListState(2, 4, 5);
    expectListOf(4, 5);
  }

  @Test
  @DisplayName("Delete from position at the end")
  void deleteFromIndexTest2() {
    populateListWithMultipleItems();

    assertTrue(list.deleteFromIndex(4));
    assertTrue(list.deleteFromIndex(3));
    assertTrue(list.deleteFromIndex(2));

    assertListState(2, 1, 2);
    expectListOf(1, 2);
  }

  @Test
  @DisplayName("Delete from position in the middle")
  void deleteFromIndexTest3() {
    populateListWithMultipleItems();

    assertTrue(list.deleteFromIndex(3));
    assertTrue(list.deleteFromIndex(2));
    assertTrue(list.deleteFromIndex(1));

    assertListState(2, 1, 5);
    expectListOf(1, 5);
  }

  @Test
  @DisplayName("Delete from position from empty list")
  void deleteFromIndexTest4() {
    assertThrows(IndexOutOfBoundsException.class, () -> list.deleteFromIndex(0));
  }

  @Test
  @DisplayName("Should throw exception when deleting from invalid position")
  void deleteFromIndexTest5() {
    populateListWithMultipleItems();

    assertThrows(IndexOutOfBoundsException.class, () -> list.deleteFromIndex(5));
    assertThrows(IndexOutOfBoundsException.class, () -> list.deleteFromIndex(-1));
  }

  @Test
  @DisplayName("Clear empty list")
  void clearTest1() {
    assertTrue(list.clear());

    assertListState(0, null, null);
    expectEmpty();
  }

  @Test
  @DisplayName("Clear list with 1 item")
  void clearTest2() {
    populateListWithSingleItem();

    assertTrue(list.clear());

    assertListState(0, null, null);
    expectEmpty();
  }

  @Test
  @DisplayName("Clear list with multiple items")
  void clearTest3() {
    populateListWithMultipleItems();

    assertTrue(list.clear());

    assertListState(0, null, null);
    expectEmpty();
  }

  @Test
  @DisplayName("Revert empty list")
  void revertListTest1() {
    list.revertList();

    assertListState(0, null, null);
    expectEmpty();
  }

  @Test
  @DisplayName("Revert list with 1 item")
  void revertListTest2() {
    populateListWithSingleItem();

    list.revertList();

    assertListState(1, 1, 1);
    expectListOf(1);
  }

  @Test
  @DisplayName("Revert list with multiple items")
  void revertListTest3() {
    populateListWithMultipleItems();

    list.revertList();

    assertListState(5, 5, 1);
    expectListOf(5, 4, 3, 2, 1);
  }

  void populateListWithSingleItem() {
    list.addToEnd(1);
  }

  void populateListWithMultipleItems() {
    list.addToEnd(1);
    list.addToEnd(2);
    list.addToEnd(3);
    list.addToEnd(4);
    list.addToEnd(5);
  }

  private void assertListState(int expectedSize, Object expectedFirst, Object expectedLast) {
    assertEquals(expectedSize, list.getSize());
    assertEquals(expectedFirst, list.getFirst());
    assertEquals(expectedLast, list.getLast());
  }

  void expectEmpty() {
    expectedResult = new Integer[]{};
  }

  void expectListOf(Integer... values) {
    expectedResult = values;
  }
}
