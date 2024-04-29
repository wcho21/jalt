import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import jalt.collections.ListStack;
import jalt.collections.Stack;

public class ListStackTest {
  @Test
  public void testFirstInLastOut() {
    Stack<Integer> stack = new ListStack<>();

    stack.push(1);
    stack.push(2);
    assertEquals(stack.pop(), 2);
    assertEquals(stack.pop(), 1);
  }

  @Test
  public void testEmpty() {
    Stack<Integer> stack = new ListStack<>();

    stack.push(1);
    assertFalse(stack.isEmpty());
    stack.pop();
    assertTrue(stack.isEmpty());
  }

  @Test
  public void testSize() {
    Stack<Integer> stack = new ListStack<>();

    stack.push(1);
    stack.push(2);
    assertEquals(stack.size(), 2);
  }

  @Test
  public void testIterator() {
    Stack<Integer> stack = new ListStack<>();

    stack.push(1);
    stack.push(2);
    stack.push(3);

    assertIterableEquals(stack, Arrays.asList(3, 2, 1));
  }
}
