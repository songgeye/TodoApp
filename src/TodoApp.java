import java.util.ArrayList;
import java.util.Scanner;

class Task {
    String title;
    String description;
    boolean isCompleted;

    Task(String title, String description) {
        this.title = title;
        this.description = description;
        this.isCompleted = false;
    }

    @Override
    public String toString() {
        return (isCompleted ? "[完了] " : "[未完了] ") + title + ": " + description;
    }
}

public class TodoApp {
    private static final ArrayList<Task> tasks = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    private static void addTask() {
        System.out.print("タスクのタイトル: ");
        String title = scanner.nextLine();
        System.out.print("タスクの説明: ");
        String description = scanner.nextLine();
        tasks.add(new Task(title, description));
        System.out.println("タスクが追加されました。");
    }

    private static void displayTasks() {
        if (tasks.isEmpty()) {
            System.out.println("タスクがありません。");
        } else {
            System.out.println("すべてのタスク:");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }

    private static void completeTask() {
        System.out.print("完了するタスクの番号: ");
        int taskNumber = scanner.nextInt();
        scanner.nextLine(); // consume newline
        if (taskNumber > 0 && taskNumber <= tasks.size()) {
            tasks.get(taskNumber - 1).isCompleted = true;
            System.out.println("タスクが完了しました。");
        } else {
            System.out.println("無効なタスク番号です。");
        }
    }

    private static void deleteTask() {
        System.out.print("削除するタスクの番号: ");
        int taskNumber = scanner.nextInt();
        scanner.nextLine(); // consume newline
        if (taskNumber > 0 && taskNumber <= tasks.size()) {
            tasks.remove(taskNumber - 1);
            System.out.println("タスクが削除されました。");
        } else {
            System.out.println("無効なタスク番号です。");
        }
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nメニュー:");
            System.out.println("1. タスクを追加する");
            System.out.println("2. すべてのタスクを表示する");
            System.out.println("3. タスクを完了する");
            System.out.println("4. タスクを削除する");
            System.out.println("5. アプリを終了する");
            System.out.print("選択肢を入力してください: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addTask();
                    break;
                case 2:
                    displayTasks();
                    break;
                case 3:
                    completeTask();
                    break;
                case 4:
                    deleteTask();
                    break;
                case 5:
                    System.out.println("アプリを終了します。");
                    return;
                default:
                    System.out.println("無効な選択肢です。もう一度試してください。");
            }
        }
    }
}