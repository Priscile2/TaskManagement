import java.util.Scanner;

public class DequeMenu {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Deque taskDeque = new Deque();
        Deque completedTasks = new Deque();

        while (true) {
            System.out.println("\nTask Management System Menu:");
            System.out.println("1. Add Task ");
            System.out.println("2. Process Task");
            System.out.println("3. View Deque");
            System.out.println("4. View Completed Tasks");
            System.out.println("5. Quit");
            System.out.print("Enter your choice: ");

            int choice = input.nextInt();
            input.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                System.out.print("Enter task id: ");
                int id = input.nextInt();
                System.out.print("Enter task description: ");
                String description = input.next();
                System.out.print("Enter task priority (0-10): ");
                int priority = input.nextInt();
                Task task = new Task(id, description, priority);

                if(priority <1 || priority >10){
                    System.out.println("Priority must be between 1 and 10");
                    break;
                }

                if(priority >5){
                    taskDeque.addFirst(task);
                }
                else{
                    taskDeque.addLast(task);
                }
                break;
                

                case 2:
                Task taskToProcess = taskDeque.Top(); // Process tasks from the front
                if (taskToProcess != null) {
                    taskToProcess.setStatus(Task.Status.COMPLETED);
                    System.out.println("Processing task: " + taskToProcess.toString());
                    completedTasks.addLast(taskToProcess);
                } else {
                    System.out.println("No tasks to process.");
                }
                break;

                case 3:
                System.out.println("Recorded tasks:");
                for (Task t : taskDeque.elements) {
                    if(!(t ==null))
                        System.out.println(t.toString());
                }
                break;

                case 4:
                System.out.println("Completed Tasks:");
                for (Task t : completedTasks.elements) {
                    if(!(t ==null))
                        System.out.println(t.toString());
                }
                break;

                case 5:
                System.out.println("Exiting Task Management System. Goodbye!");
                input.close();
                System.exit(0);

                default:
                System.out.println("Invalid choice. Check and come back later.");
            }
        }
    }
}