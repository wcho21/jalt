import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import jalt.collections.PriorityQueue;
import jalt.collections.MaxPriorityQueue;

public class MaxPriorityQueueTest {
  @Test
  public void testInOutOneElem() {
    Integer[] arr = { 1 };
    PriorityQueue<Integer> queue = MaxPriorityQueue.fromArray(arr);

    assertEquals(queue.dequeue(), 1);
  }

  @Test
  public void testInOutThreeElem() {
    Integer[] arr = { 10, 30, 20 };
    PriorityQueue<Integer> queue = MaxPriorityQueue.fromArray(arr);

    assertEquals(queue.dequeue(), 30);
    assertEquals(queue.dequeue(), 20);
    assertEquals(queue.dequeue(), 10);
  }
}
