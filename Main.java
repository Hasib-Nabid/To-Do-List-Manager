import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the To Do List Manager!\n");
        while (true) {
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    register(scanner);
                    break;
                case 2:
                    if (login(scanner)) {
                        manageToDoList(scanner);
                    }
                    break;
                case 3:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void register(Scanner scanner) {
        System.out.print("Enter a username to register: ");
        String username = scanner.nextLine();
        System.out.print("Enter a password: ");
        String password = scanner.nextLine();

        if (User.register(username, password)) {
            System.out.println("Registration successful! You can now log in.");
        } else {
            System.out.println("Username already exists. Please try a different username.");
        }
    }

    private static boolean login(Scanner scanner) {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        if (User.login(username, password)) {
            System.out.println("Login successful! Welcome, " + username + "!");
            return true;
        } else {
            System.out.println("Invalid credentials. Please try again.");
            return false;
        }
    }

    private static void manageToDoList(Scanner scanner) {
        System.out.println("Type `help` to see a list of commands.");

        while (true) {
            System.out.print("\n> ");
            String command = scanner.nextLine().toLowerCase();

            switch (command) {
                case "add":
                    ToDoList.addTask(scanner);
                    break;
                case "done":
                    ToDoList.markTaskAsDone(scanner);
                    break;
                case "edit":
                    ToDoList.editTask(scanner);
                    break;
                case "filter":
                    ToDoList.filterTasksByPriority(scanner);
                    break;
                case "search":
                    ToDoList.searchTasksByName(scanner);
                    break;
                case "show":
                    ToDoList.showTasks();
                    break;
                    case "help":
                    System.out.println("\nAvailable Commands:");
                    System.out.println("  add    - Add a new task");
                    System.out.println("  done   - Mark a task as done");
                    System.out.println("  edit   - Edit an existing task");
                    System.out.println("  filter - Filter tasks by priority");
                    System.out.println("  search - Search tasks by name");
                    System.out.println("  show   - Show all tasks");
                    System.out.println("  logout - Logout the To Do List Manager");
                    break;
                case "logout":
                    System.out.println("Logging out...");
                    return;
                default:
                    System.out.println("Unknown command. Type `help` for a list of commands.");
            }
        }
    }
}
