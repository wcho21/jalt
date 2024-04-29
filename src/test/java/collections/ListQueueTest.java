import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import jalt.collections.ListQueue;
import jalt.collections.Queue;

public class ListQueueTest {
  @Test
  public void testFirstInFirstOut() {
    Queue<Integer> queue = new ListQueue<>();

    queue.enqueue(1);
    queue.enqueue(2);
    assertEquals(queue.dequeue(), 1);
    assertEquals(queue.dequeue(), 2);
  }

  @Test
  public void testEmpty() {
    Queue<Integer> queue = new ListQueue<>();

    queue.enqueue(1);
    assertFalse(queue.isEmpty());
    queue.dequeue();
    assertTrue(queue.isEmpty());
  }

  @Test
  public void testSize() {
    Queue<Integer> queue = new ListQueue<>();

    queue.enqueue(1);
    queue.enqueue(2);
    assertEquals(queue.size(), 2);
  }

  @Test
  public void testIterator() {
    Queue<Integer> queue = new ListQueue<>();

    queue.enqueue(1);
    queue.enqueue(2);
    queue.enqueue(3);

    assertIterableEquals(queue, Arrays.asList(1, 2, 3));
  }
}
