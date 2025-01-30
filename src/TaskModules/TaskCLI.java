package TaskModules;

import java.util.List;
import java.util.Scanner;

public class TaskCLI {

    private final TaskManager taskManager;

    public TaskCLI() {
        this.taskManager = new TaskManager();
    }

    public static void main(String[] args) {
        TaskCLI cli = new TaskCLI();
        cli.run();
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        List<Task> tasks = taskManager.loadTasks();

        System.out.println("Welcome to Task CLI Manager");

        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine().trim();
            if (input.equalsIgnoreCase("exit")) {
                break;
            }

            String[] parts = input.split(" ", 2);
            String command = parts[0].toLowerCase();
            String argument = parts.length > 1 ? parts[1].trim() : "";

            switch (command) {
                case "add":
                    addTask(tasks, argument);
                    break;
                case "update":
                    updateTask(tasks, argument);
                    break;
                case "delete":
                    deleteTask(tasks, argument);
                    break;
                case "mark-in-progress":
                    markTaskStatus(tasks, argument, "in-progress");
                    break;
                case "mark-done":
                    markTaskStatus(tasks, argument, "done");
                    break;
                case "list":
                    listTasks(tasks, argument);
                    break;
                default:
                    System.out.println("Invalid command. Try again.");
            }
        }

        taskManager.saveTasks(tasks);
        scanner.close();
        System.out.println("Goodbye!");
    }

    private void addTask(List<Task> tasks, String description) {
        if (description.isEmpty()) {
            System.out.println("Task description cannot be empty.");
            return;
        }
        long newId = tasks.isEmpty() ? 1 : tasks.get(tasks.size() - 1).getId() + 1;
        tasks.add(new Task(newId, description, "todo"));
        System.out.println("Task added successfully (ID: " + newId + ")");
    }

    private void updateTask(List<Task> tasks, String input) {
        String[] parts = input.split(" ", 2);
        if (parts.length < 2) {
            System.out.println("Usage: update <id> <new description>");
            return;
        }
        long id = Long.parseLong(parts[0]);
        String newDescription = parts[1];
        Task task = taskManager.findTaskById(id);
        if (task != null) {
            task.setDescription(newDescription);
            System.out.println("Task updated successfully.");
        } else {
            System.out.println("Task not found.");
        }
    }

    private void deleteTask(List<Task> tasks, String input) {
        try {
            long id = Long.parseLong(input);
            tasks.removeIf(task -> task.getId() == id);
            System.out.println("Task deleted successfully.");
        } catch (NumberFormatException e) {
            System.out.println("Invalid task ID.");
        }
    }

    private void markTaskStatus(List<Task> tasks, String input, String status) {
        try {
            long id = Long.parseLong(input);
            Task task = taskManager.findTaskById(id);
            if (task != null) {
                task.setStatus(status);
                System.out.println("Task marked as " + status + ".");
            } else {
                System.out.println("Task not found.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid task ID.");
        }
    }

    private void listTasks(List<Task> tasks, String filter) {
        if (tasks.isEmpty()) {
            System.out.println("No tasks found.");
            return;
        }

        for (Task task : tasks) {
            if (filter.isEmpty() || task.getStatus().equalsIgnoreCase(filter)) {
                System.out.println(task.getId() + ". " + task.getDescription() + " [" + task.getStatus() + "]");
            }
        }
    }
}