package TaskModules;



import java.util.ArrayList;
import java.util.List;

public class TaskManager {

    private List<Task> tasks;

    public TaskManager() {
        this.tasks = new ArrayList<>();
    }

    public List<Task> loadTasks() {
        // In a real scenario, you might load from a file or database.
        return tasks;
    }

    public void saveTasks(List<Task> tasks) {
        // Simulate saving; for real usage, persist to a file or database.
        this.tasks = tasks;
        System.out.println("Tasks saved.");
    }

    public Task findTaskById(long id) {
        return tasks.stream().filter(task -> task.getId() == id).findFirst().orElse(null);
    }
}

