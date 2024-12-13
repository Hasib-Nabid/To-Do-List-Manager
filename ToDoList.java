import java.util.*;

public class ToDoList {
    private static List<Task> tasks = new ArrayList<>();

    public static void addTask(Scanner scanner) {
        System.out.print("Enter Task Name: ");
        String taskName = scanner.nextLine();

        System.out.print("Enter Deadline: ");
        String deadline = scanner.nextLine();

        System.out.print("Enter priority (1 - Low, 2 - Medium, 3 - High): ");
        int priority = scanner.nextInt();
        scanner.nextLine(); 

        tasks.add(new Task(taskName, deadline, priority));
        System.out.println("Task added successfully!");
    }

    public static void markTaskAsDone(Scanner scanner) {
        showTasks();
        System.out.print("Enter the index of the task to mark as done: ");
        int index = scanner.nextInt() - 1;
        scanner.nextLine();

        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
            System.out.println("Task marked as done and removed!");
        } else {
            System.out.println("Invalid index. No task marked as done.");
        }
    }

    public static void editTask(Scanner scanner) {
        showTasks();
        System.out.print("Enter the index of the task to edit: ");
        int index = scanner.nextInt() - 1;
        scanner.nextLine();
    
        if (index >= 0 && index < tasks.size()) {
            Task task = tasks.get(index);
    
            System.out.print("Enter new Task Name (or press Enter to keep the same): ");
            String newTaskName = scanner.nextLine();
            if (!newTaskName.isEmpty()) task.setTaskName(newTaskName);
    
            System.out.print("Enter new Deadline (or press Enter to keep the same): ");
            String newDeadline = scanner.nextLine();
            if (!newDeadline.isEmpty()) task.setDeadline(newDeadline);
    
            System.out.print("Enter new Priority (1 - Low, 2 - Medium, 3 - High, or press Enter to keep the same): ");
            String newPriorityInput = scanner.nextLine();
            if (!newPriorityInput.isEmpty()) task.setPriority(Integer.parseInt(newPriorityInput));
    
            System.out.println("Task updated successfully!");
        } else {
            System.out.println("Invalid index. No task edited.");
        }
    }
    

    public static void filterTasksByPriority(Scanner scanner) {
        System.out.print("Enter priority to filter by (1 - Low, 2 - Medium, 3 - High): ");
        int priority = scanner.nextInt();
        scanner.nextLine();

        for (Task task : tasks) {
            if (task.getPriority() == priority) {
                System.out.println(task);
            }
        }
    }

    public static void searchTasksByName(Scanner scanner) {
        System.out.print("Enter a keyword to search for: ");
        String keyword = scanner.nextLine().toLowerCase();

        for (Task task : tasks) {
            if (task.getTaskName().toLowerCase().contains(keyword)) {
                System.out.println(task);
            }
        }
    }

    public static void showTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks found.");
        } else {
            tasks.sort(Comparator.comparing(Task::getPriority).reversed());
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println("Task " + (i + 1) + ": " + tasks.get(i));
            }
        }
    }
}
