package sheetSolutions.stackNQueues;
/*
This program aims to implement queue from scratch
 */
public class implementQueue {
  int rear, front, size;
  int capacity;
  int[] arr;

  public implementQueue(int c) {
    capacity = c;
    front = 0;
    rear = c - 1;
    arr = new int[c];
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public boolean isFull() {
    return size == capacity;
  }

  public void enqueue(int item) {
    if (isFull()) {
      return;
    }
    rear = (rear + 1) % capacity; // so as insertion take place in front only
    arr[rear] = item;
    size++;
    System.out.println(item + " enqueued to queue");
  }

  public int dequeue() {
    if (isEmpty()) {
      System.out.println("Queue is empty");
      return -1;
    }
    int item = arr[front];
    front = (front + 1) % capacity;
    size--;
    return item;
  }

  int getFront() {
    if (isEmpty()) return -1;
    return arr[front];
  }

  int getRear() {
    if (isEmpty()) return -1;
    return arr[rear];
  }

  public static void main(String[] args) {
    implementQueue q = new implementQueue(5);
    q.enqueue(1);
    q.enqueue(2);
    q.enqueue(3);
    q.enqueue(4);
    q.enqueue(5);
    System.out.println(q.dequeue());
    System.out.println(q.getFront());
    System.out.println(q.getRear());
  }
}
