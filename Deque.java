public class Deque {
    private Task[] deque;
    private int size;
    private int top; // Replaces "front"
    private int bottom; // Replaces "rear"
    public Task[] elements;

    public Deque() {
        deque = new Task[5];
        size = 0;
        top = 0;
        bottom = -1;
    }

    // Add a task to the top of the deque (like a queue)
    public void enqueueTop(Task task) {
        if (size < deque.length) {
            top = (top - 1 + deque.length) % deque.length;
            deque[top] = task;
            size++;
        } else {
            System.out.println("The deque is full.");
        }
    }

    // Add a task to the bottom of the deque (like a stack)
    public void pushBottom(Task task) {
        if (size < deque.length) {
            bottom = (bottom + 1) % deque.length;
            deque[bottom] = task;
            size++;
        } else {
            System.out.println("The deque is full.");
        }
    }

    // Remove and return a task from the top of the deque
    public Task dequeueTop() {
        if (size > 0) {
            Task removed = deque[top];
            deque[top] = null;
            top = (top + 1) % deque.length;
            size--;
            return removed;
        } else {
            System.out.println("The deque is empty.");
            return null;
        }
    }

    // Remove and return a task from the bottom of the deque
    public Task popBottom() {
        if (size > 0) {
            Task removed = deque[bottom];
            deque[bottom] = null;
            bottom = (bottom - 1 + deque.length) % deque.length;
            size--;
            return removed;
        } else {
            System.out.println("The deque is empty.");
            return null;
        }
    }

    // Check if the deque is empty
    public boolean isEmpty() {
        return size == 0;
    }

    public void addFirst(Task task) {
    }

    public void addLast(Task task) {
    }

    public Task Top() {
        return null;
    }
}
