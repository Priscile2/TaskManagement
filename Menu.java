import java.util.Scanner;

public class Menu {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Stack stack = new Stack(); // Create a stack for high-priority tasks.
        Queue queue = new Queue(); // Create a queue for normal-priority tasks.
        Queue completed = new Queue(); // Create a queue for completed tasks.

        // Displaying to the users what the options are for the task management system.
        while (true) {
            System.out.println("\nTask management system !!!!");
            System.out.println("1. Add a task.");
            System.out.println("2. Process a task.");
            System.out.println("3. View high priority tasks.");
            System.out.println("4. View other (normal) tasks.");
            System.out.println("5. View processed tasks.");
            System.out.println("6. Quit.");
            System.out.println("Enter your choice: ");

            int choice = input.nextInt();

            // Using switch case to process the request of the user
            switch (choice) {
                // Collecting input from the user to add a new task
                case 1:
                    System.out.println("Enter task ID: ");
                    int ID = input.nextInt();
                    System.out.println("Enter task description: ");
                    String description = input.next();
                    System.out.println("Enter task priority between 0-10: ");
                    int priority = input.nextInt();

                    if (priority < 1 || priority > 10) {
                        System.out.println("Priority must be between 0 and 10.");
                        break;
                    }

                    // Adding a task either to the stack or queue depending on its priority
                    Task task = new Task(ID, description, priority);
                    if (priority > 5) {
                        stack.push(task); // Add to the high-priority stack.
                    } else {
                        queue.enqueue(task); // Add to the normal-priority queue.
                    }
                    break;

                case 2:
                    // Processing elements from the stack first (high priority) if not empty.
                    if (!stack.isEmpty()) {
                        Task processed_task = stack.pop();
                        processed_task.setStatus(Task.Status.COMPLETED);
                        System.out.println("High priority task processed: " + processed_task.toString());
                        completed.enqueue(processed_task);
                    } else {
                        // Processing the normal priority tasks
                        if (!queue.isEmpty()) {
                            Task taskToProcess = queue.dequeue();
                            taskToProcess.setStatus(Task.Status.COMPLETED);
                            System.out.println("Processed task: " + taskToProcess.toString());
                            completed.enqueue(taskToProcess);
                        }
                    }
                    break;

                case 3:
                    System.out.println("These are the high priority tasks: ");
                    // Print the stack (high priority tasks)
                    if (stack.isEmpty()) {
                        System.out.println("Relax, No high priority tasks.");
                    } else {
                        System.out.println("Recorded tasks:");
                        for (Task t : stack.tasks) {
                            if (t != null)
                                System.out.println("* " + t.toString());
                        }
                    }
                    break;

                case 4:
                    System.out.println("These are the tasks with normal priority: ");
                    // Print the queue (normal priority tasks)
                    if (queue.isEmpty()) {
                        System.out.println("Chill, no tasks to perform.");
                    } else {
                        System.out.println("Recorded tasks:");
                        for (Task t : queue.queue) {
                            if (t != null)
                                System.out.println("* " + t.toString());
                        }
                    }
                    break;

                case 5:
                    System.out.println("These are the processed tasks");
                    // Print the completed queue (completed tasks)
                    if (completed.isEmpty()) {
                        System.out.println("No tasks have been completed yet.");
                    } else {
                        for (Task t : completed.queue) {
                            if (t != null) {
                                System.out.println("* " + t);
                            }
                        }
                    }
                    break;

                case 6:
                    System.out.println("Until we meet again, bye bye......");
                    input.close();
                    System.exit(0);
                default:
                    System.out.println("Your choice is not valid, please check and enter again.");
            }
        }
    }
}
