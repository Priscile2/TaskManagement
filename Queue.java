public class Queue {
    Task[] queue;  // An array to store tasks in the queue.
    int size;      // The current number of tasks in the queue.
    int top;       // Index for the top of the queue.
    int bottom;    // Index for the bottom of the queue.
    public int length; // Not used, seems like an unused variable.

    public Queue() {
        queue = new Task[4];  // Initialize the queue as an array of size 10.
        this.size = 0;        // Initialize the size to 0.
        this.top = -1;        // Initialize the top index to -1.
        this.bottom = 0;      // Initialize the bottom index to 0.
    }

    // This method implements a circular queue where elements are added to the top of the queue.
    public void enqueue(Task task) {
        if (size == queue.length) {
            System.out.println("The queue is full.");
        } else {
            top = (top + 1) % queue.length;  // Circularly increment the top index.
            queue[top] = task;  // Add the task to the top.
            size++;  // Increase the size of the queue.
        }
    }

    // The method also implements a circular queue, but elements are evicted from the bottom of the queue.
    public Task dequeue() {
        if (size == 0) {
            System.out.println("The queue is empty.");
            return null;
        } else {
            Task removed = queue[bottom];  // Get the task from the bottom.
            queue[bottom] = null;  // Clear the slot at the bottom.
            bottom = (bottom + 1) % queue.length;  // Circularly increment the bottom index.
            size--;  // Decrease the size of the queue.
            return removed;  // Return the removed task.
        }
    }

    // Check if the queue is empty.
    public boolean isEmpty() {
        return size == 0;
    }
}
