public class Stack {
    Task[] tasks; // An array to store tasks in the stack.
    int size;     // The current number of tasks in the stack.
    int top;      // Index for the top of the stack.
    public int length; // Not used, seems like an unused variable.

    public Stack() {
        tasks = new Task[4]; // Initialize the stack as an array of size 4.
        this.size = 0;       // Initialize the size to 0.
        this.top = -1;       // Initialize the top index to -1.
    }

    public void push(Task task) {
        /**
         * Push a task onto the stack at the appropriate position based on its priority.
         * 
         * @param task The task of high priority to be placed in the stack.
         */
        if (top < tasks.length - 1) {
            // Push high-priority tasks to the top of the stack
             
            // Finding the correct position to insert the task
            int insert_position = top + 1;
            while (insert_position > 0 && tasks[insert_position - 1] != null && tasks[insert_position - 1].getPriority() <= task.getPriority()) {
                insert_position--;
            }
            // Shift tasks to make space for the new task
            for (int i = top; i >= insert_position; i--) {
                tasks[i + 1] = tasks[i];
            }
            // Insert the new task
            tasks[insert_position] = task;
            top++;
            size++;
        } else {
            System.out.println("The stack is full.");
        }
    }

    public Task pop() {
        if (top >= 0) {
            // Call bubbleSort to ensure the highest priority task is at the top
            bubbleSort(tasks);

            Task task = tasks[top];
            tasks[top--] = null;
            size--;
            return task;
        } else {
            System.out.println("The stack is empty.");
            return null;
        }
    }

    public Task top() {
        if (isEmpty()) {
            System.out.println("The stack is empty.");
            return null;
        } else {
            return tasks[top];
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public static void bubbleSort(Task[] tasks) {
        int n = tasks.length;
        boolean swapped;
        int validElements = countValidTasks(tasks);

        for (int i = 0; i < validElements - 1; i++) {
            swapped = false;
            for (int j = 0; j < validElements - i - 1; j++) {
                if (tasks[j].getPriority() > tasks[j + 1].getPriority()) {
                    Task temp = tasks[j];
                    tasks[j] = tasks[j + 1];
                    tasks[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }

    // Helper method to count the number of non-null elements in the tasks array
    private static int countValidTasks(Task[] tasks) {
        int count = 0;
        for (Task task : tasks) {
            if (task != null) {
                count++;
            }
        }
        return count;
    }
}
