package TaskModules;

public class Task {
    private long id;
    private String description;
    private String status;

    public Task(long id, String description, String status) {
        this.id = id;
        this.description = description;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return id + ". " + description + " [" + status + "]";
    }
}
