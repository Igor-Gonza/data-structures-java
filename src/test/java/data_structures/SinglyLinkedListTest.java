package data_structures;

import org.example.data_structures.SinglyLinkedList;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Singly Linked List")
public class SinglyLinkedListTest {

  SinglyLinkedList<Integer> list;
  Integer[] expectedResult = null;

  @BeforeEach
  void setup() {
    list = new SinglyLinkedList<>();
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
  @DisplayName("Add to position at the beginning")
  void addToIndexTest1() {
    int firstAdded = 10;
    int secondAdded = 20;
    int thirdAdded = 30;
    populateListWithMultipleItems();

    list.addToIndex(0, firstAdded);
    list.addToIndex(0, secondAdded);
    list.addToIndex(0, thirdAdded);

    assertListState(8, thirdAdded, 5);
    expectListOf(30, 20, 10, 1, 2, 3, 4, 5);
  }

  @Test
  @DisplayName("Add to position at the end")
  void addToIndexTest2() {
    int firstAdded = 10;
    int secondAdded = 20;
    int thirdAdded = 30;
    populateListWithMultipleItems();

    list.addToIndex(5, firstAdded);
    list.addToIndex(6, secondAdded);
    list.addToIndex(7, thirdAdded);

    assertListState(8, 1, thirdAdded);
    expectListOf(1, 2, 3, 4, 5, 10, 20, 30);
  }

  @Test
  @DisplayName("Add to position in the middle")
  void addToIndexTest3() {
    int firstAdded = 10;
    int secondAdded = 20;
    int thirdAdded = 30;
    populateListWithMultipleItems();

    list.addToIndex(1, firstAdded);
    list.addToIndex(3, secondAdded);
    list.addToIndex(5, thirdAdded);

    assertListState(8, 1, 5);
    expectListOf(1, 10, 2, 20, 3, 30, 4, 5);
  }

  @Test
  @DisplayName("Add to position in empty list")
  void addToIndexTest4() {
    int addedItem = 42;

    list.addToIndex(0, addedItem);

    assertListState(1, addedItem, addedItem);
    expectListOf(42);
  }

  @Test
  @DisplayName("Should throw exception when adding to invalid position")
  void addToIndexTest5() {
    int addedItem = 42;
    populateListWithMultipleItems();

    assertThrows(IndexOutOfBoundsException.class, () -> list.addToIndex(6, addedItem));
    assertThrows(IndexOutOfBoundsException.class, () -> list.addToIndex(-1, addedItem));
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
