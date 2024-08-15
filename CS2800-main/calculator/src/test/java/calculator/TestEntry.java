package calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Stack;
import org.junit.jupiter.api.Test;

class TestEntry {
  private Cs2800Entry entry1;
  private Cs2800Entry entry2;
  private Cs2800Entry entry3;
  private Cs2800Entry entry4;
  private Cs2800Entry entry5;
  private Cs2800Entry entry6;

  @Test // Test 1
  // Checks a float type entry can be created. Done by creating a constructor that takes a float.
  void testFloat() {
    entry1 = new Cs2800Entry(0.555f);
  }

  @Test // Test 2
  // Checks a string type entry can be created. Done by creating a constructor that takes a string.
  void testString() {
    entry1 = new Cs2800Entry("testing");
  }

  @Test // Test 3
  // Checks a symbol type entry can be created. Done by creating a constructor that takes a symbol
  // ENUM. For this test to pass the Symbol ENUM was created.
  void testSymbol() {
    entry1 = new Cs2800Entry(Symbol.LEFT_BRACKET);
  }

  @Test // Test 4
  // Checks that entries are assigned the correct type. Was initially faked by returning the desired
  // type in the getType() method. Upon adjusting the test to check multiple entries the
  // constructors had to be changed to assign the correct type to each entry. For this test to pass
  // the Type ENUM was created.
  void getType() {
    entry1 = new Cs2800Entry(0.25f);
    entry2 = new Cs2800Entry("String");
    entry3 = new Cs2800Entry(Symbol.DIVIDE);
    assertEquals(entry1.getType(), Type.NUMBER, "Entry should be a number type");
    assertEquals(entry2.getType(), Type.STRING, "Entry should be a string type");
    assertEquals(entry3.getType(), Type.SYMBOL, "Entry should be a symbol type");
  }

  @Test // Test 5
  // Checks that the getString() method returns the expected string. Was implemented by returning
  // the entries string.
  void getString() throws BadTypeException {
    entry1 = new Cs2800Entry("testing");
    assertEquals(entry1.getString(), "testing", "String should match string passed in");
  }

  @Test // Test 6
  // Checks that upon calling getString method on an entry that isn't a string that an
  // BadTypeException is thrown, this was done via an if statement in getString() that checks if the
  // type is a string.
  void getStringException() {
    entry1 = new Cs2800Entry(Symbol.LEFT_BRACKET);
    assertThrows(BadTypeException.class, () -> entry1.getString(),
        "Cant get string on non-string type");
  }

  @Test // Test 7
  // Checks that the getSymbol() method returns the expected symbol. Was implemented by returning
  // the entries symbol.
  void getSymbol() throws BadTypeException {
    entry1 = new Cs2800Entry(Symbol.LEFT_BRACKET);
    assertEquals(entry1.getSymbol(), Symbol.LEFT_BRACKET, "Symbol should match symbol passed in");
  }

  @Test // Test 8
  // Checks that upon calling getSymbol method on an entry that isn't a symbol that an
  // BadTypeException is thrown, this was done via an if statement in getSymbol() that checks if the
  // type is a symbol.
  void getSymbolException() {
    entry1 = new Cs2800Entry(0.555f);
    assertThrows(BadTypeException.class, () -> entry1.getSymbol(), "Cant get symbol on float type");
  }

  @Test // Test 9
  // Checks that the getValue() method returns the expected value. Was implemented by returning
  // the entries value.
  void getValue() throws BadTypeException {
    entry1 = new Cs2800Entry(1.23f);
    assertEquals(entry1.getValue(), 1.23f, "Float should match float passed in");
  }

  @Test // Test 10
  // Checks that upon calling getValue method on an entry that isn't a number that an
  // BadTypeException is thrown, this was done via an if statement in getVaue() that checks if the
  // type is a number.
  void getValueException() {
    entry1 = new Cs2800Entry("String");
    assertThrows(BadTypeException.class, () -> entry1.getValue(), "Cant get value on string type");
  }

  @Test // Test 11
  // Checks that two identical entries will return true when equals() is called. Done via the
  // eclipse auto-generated equals method.
  void testEqualsTrue() {
    entry1 = new Cs2800Entry("String");
    entry2 = new Cs2800Entry("String");
    assertEquals(entry1.equals(entry2), true, "Two identical string entries should return true");
    entry3 = new Cs2800Entry(0.1f);
    entry4 = new Cs2800Entry(0.1f);
    assertEquals(entry3.equals(entry4), true, "Two identical float entries should return true");
    entry5 = new Cs2800Entry(Symbol.TIMES);
    entry6 = new Cs2800Entry(Symbol.TIMES);
    assertEquals(entry5.equals(entry6), true, "Two identical symbol entries should return true");


  }

  @SuppressWarnings("unlikely-arg-type")
  @Test // Test 12
  // Checks that two different entries will return false when equals() is called. Done via the
  // eclipse auto-generated equals method.
  void testEqualsFalse() {
    entry1 = new Cs2800Entry("String");
    entry2 = new Cs2800Entry("Strung");
    assertEquals(entry1.equals(entry2), false, "Two diffrent string entries should return false");
    entry3 = new Cs2800Entry(0.1f);
    entry4 = new Cs2800Entry(0.6f);
    assertEquals(entry3.equals(entry4), false, "Two diffrent float entries should return false");
    entry5 = new Cs2800Entry(Symbol.TIMES);
    entry6 = new Cs2800Entry(Symbol.MINUS);
    assertEquals(entry5.equals(entry6), false, "Two diffrent symbol entries should return false");
    assertEquals(entry1.equals(null), false, "An entry and null should return false");
    assertEquals(entry1.equals(Stack.class), false,
        "An entry and a non-entry object should return false");
  }

  @Test // Test 13
  // Checks that two identical entries will return the same hashcode when hashcode() is called.
  // Done via the eclipse auto-generated equals method.
  void testHashSame() {
    entry1 = new Cs2800Entry("String");
    entry2 = new Cs2800Entry("String");
    assertEquals(entry1.hashCode(), entry2.hashCode(),
        "Two identical string entries should return the same hashcode");
    entry3 = new Cs2800Entry(0.1f);
    entry4 = new Cs2800Entry(0.1f);
    assertEquals(entry3.hashCode(), entry4.hashCode(),
        "Two identical float entries should return the same hashcode");
    entry5 = new Cs2800Entry(Symbol.RIGHT_BRACKET);
    entry6 = new Cs2800Entry(Symbol.RIGHT_BRACKET);
    assertEquals(entry5.hashCode(), entry6.hashCode(),
        "Two identical symbol entries should return the same hashcode");
  }

  @Test // Test 14
  // Checks that two different entries will return different hashcodes when hashcode() is called.
  // Done via the eclipse auto-generated equals method.
  void testHashDiff() {
    entry1 = new Cs2800Entry("String");
    entry2 = new Cs2800Entry("Stringy");
    assertNotEquals(entry1.hashCode(), entry2.hashCode(),
        "Two diffrent string entries should return the same hashcode");
    entry3 = new Cs2800Entry(0.1f);
    entry4 = new Cs2800Entry(0.75f);
    assertNotEquals(entry3.hashCode(), entry4.hashCode(),
        "Two diffrent string entries should return the same hashcode");
    entry5 = new Cs2800Entry(Symbol.DIVIDE);
    entry6 = new Cs2800Entry(Symbol.LEFT_BRACKET);
    assertNotEquals(entry5.hashCode(), entry6.hashCode(),
        "Two diffrent string entries should return the same hashcode");
  }


}
