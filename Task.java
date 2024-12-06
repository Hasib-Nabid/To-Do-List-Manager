import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Task {
    private String taskName;
    private String deadline;
    private boolean isDone;
    private int priority;

    public Task(String taskName, String deadline, int priority) {
        this.taskName = taskName;
        this.deadline = deadline;
        this.priority = priority;
        this.isDone = false;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return taskName + " | Priority: " + priority + " | Deadline: " + deadline + " | Done: " + isDone;
    }
}
