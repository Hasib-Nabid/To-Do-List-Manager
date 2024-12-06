import java.util.*;
import java.util.stream.Collectors;

class ToDoList {
    private static List<Task> tasks = new ArrayList<>();

    public static void addTask(Scanner scanner) {
        System.out.print("Enter Task Name: ");
        String taskName = scanner.nextLine();

        System.out.print("Enter Deadline (e.g., 23 November, 2023): ");
        String deadline = scanner.nextLine();

        System.out.print("Enter priority (1 - Low, 2 - Medium, 3 - High): ");
        int priority = scanner.nextInt();
        scanner.nextLine();

        Task newTask = new Task(taskName, deadline, priority);
        tasks.add(newTask);
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
            System.out.println("Invalid index. No task removed.");
        }
    }

    public static void editTask(Scanner scanner) {
        showTasks();
        System.out.print("Enter the index of the task to edit: ");
        int index = scanner.nextInt() - 1;
        scanner.nextLine();

        if (index >= 0 && index < tasks.size()) {
            Task task = tasks.get(index);

            System.out.println("Editing Task: " + task.getTaskName());
            System.out.print("Enter new Task Name (leave blank to keep the same): ");
            String newTaskName = scanner.nextLine();
            if (!newTaskName.isEmpty()) {
                task.setTaskName(newTaskName);
            }

            System.out.print("Enter new Deadline (leave blank to keep the same): ");
            String newDeadline = scanner.nextLine();
            if (!newDeadline.isEmpty()) {
                task.setDeadline(newDeadline);
            }

            System.out.print("Enter new Priority (1 - Low, 2 - Medium, 3 - High, leave blank to keep the same): ");
            String newPriorityInput = scanner.nextLine();
            if (!newPriorityInput.isEmpty()) {
                task.setPriority(Integer.parseInt(newPriorityInput));
            }

            System.out.println("Task updated successfully!");
        } else {
            System.out.println("Invalid index. No task edited.");
        }
    }

    public static void filterTasksByPriority(Scanner scanner) {
        System.out.print("Enter priority to filter by (1 - Low, 2 - Medium, 3 - High): ");
        int priority = scanner.nextInt();
        scanner.nextLine();

        List<Task> filteredTasks = tasks.stream()
                .filter(task -> task.getPriority() == priority)
                .collect(Collectors.toList());

        if (filteredTasks.isEmpty()) {
            System.out.println("No tasks found for the selected priority.");
        } else {
            System.out.println("\nFiltered Tasks:");
            int index = 1;
            for (Task task : filteredTasks) {
                System.out.println("Task " + index + ": " + task);
                index++;
            }
        }
    }

    public static void searchTasksByName(Scanner scanner) {
        System.out.print("Enter a keyword to search for: ");
        String keyword = scanner.nextLine().toLowerCase();

        List<Task> matchedTasks = tasks.stream()
                .filter(task -> task.getTaskName().toLowerCase().contains(keyword))
                .collect(Collectors.toList());

        if (matchedTasks.isEmpty()) {
            System.out.println("No tasks matched your search.");
        } else {
            System.out.println("\nMatched Tasks:");
            int index = 1;
            for (Task task : matchedTasks) {
                System.out.println("Task " + index + ": " + task);
                index++;
            }
        }
    }

    public static void showTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks found.");
        } else {
            tasks.sort(Comparator.comparing(Task::getPriority).reversed());
            int index = 1;
            for (Task task : tasks) {
                System.out.println("Task " + index + ": " + task);
                index++;
            }
        }
    }
}
