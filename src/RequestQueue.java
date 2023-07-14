import java.time.LocalDateTime;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class RequestQueue {
    private Queue<String> requestQueue;
    private Queue<String> statisticsQueue;
    private Scanner scanner;

    public RequestQueue() {
        requestQueue = new ArrayDeque<>();
        statisticsQueue = new ArrayDeque<>();
        scanner = new Scanner(System.in);
    }

    public void run() {
        int choice;
        do {
            displayMenu();
            System.out.print("Введіть номер опції: ");
            choice = scanner.nextInt();
            switch (choice){
                case 1:{
                    addRequest();
                    break;
                }
                case 2:{
                    processNextRequest();
                    break;
                }
                case 3:{
                    showStatistics();
                    break;
                }
                case 0:{
                    System.out.println("Програма завершується.");
                    break;
                }
                default:{
                    System.out.println("Недійсний вибір. Введіть номер опції зі списку.");
                    break;
                }

            }
            System.out.println();
        } while (choice != 0);
        scanner.close();
    }

    private void displayMenu() {
        System.out.println("Меню:");
        System.out.println("1. Додати запит до черги");
        System.out.println("2. Обробити наступний запит");
        System.out.println("3. Показати статистику запитів");
        System.out.println("0. Вийти");
    }

    private void addRequest() {
        System.out.print("Введіть логін користувача: ");
        String user = scanner.next();
        System.out.print("Введіть пріоритет (від 1 до 5): ");
        int priority = scanner.nextInt();
        String request = user + " (пріоритет: " + priority + ")";
        requestQueue.offer(request);
        System.out.println("Запит від користувача " + user + " додано до черги.");
        statisticsQueue.offer(user + " (" + LocalDateTime.now() + ")");
    }

    private void processNextRequest() {
        if (!requestQueue.isEmpty()) {
            String request = requestQueue.poll();
            System.out.println("Оброблено запит: " + request);
        } else {
            System.out.println("Черга запитів порожня.");
        }
    }
    private void showStatistics(){
        System.out.println("Статистика запитів:");
        for (String statistic : statisticsQueue){
            System.out.println(statistic);
        }
    }
}
