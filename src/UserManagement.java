import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UserManagement {
    private Map<String, String> users;
    private Scanner scanner;

    public UserManagement() {
        users = new HashMap<>();
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
                    addUser();
                    break;
                }
                case 2:{
                    removeUser();
                    break;
                }
                case 3:{
                    checkUserExists();
                    break;
                }
                case 4:{
                    changeUsername();
                    break;
                }
                case 5:{
                    changePassword();
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
        } while (choice != 0);
    }

    private void displayMenu() {
        System.out.println("Меню:");
        System.out.println("1. Додати нового користувача");
        System.out.println("2. Видалення існуючого користувача");
        System.out.println("3. Перевірити чи існує користувач");
        System.out.println("4. Змінити логін");
        System.out.println("5. Змінити пароль");
        System.out.println("0. Вийти");
    }

    private void addUser() {
        System.out.print("Введіть логін нового користувача: ");
        String username = scanner.nextLine();
        if (users.containsKey(username)) {
            System.out.println("Користувач з таким логіном вже є!");
        } else {
            System.out.print("Введіть пароль для користувача: ");
            String password = scanner.nextLine();
            users.put(username, password);
            System.out.println("Користувач" + username + " додано.");
        }
    }

    private void removeUser() {
        System.out.println("Введіть логін коритувача для видалення: ");
        String username = scanner.nextLine();
        if (users.containsKey(username)) {
            users.remove(username);
            System.out.println("Користувача " + username + " видалено.");
        } else {
            System.out.println("Користувача з таким логіном не існує.");
        }
    }

    private void checkUserExists() {
        System.out.print("Введіть логін користувача для перевірки: ");
        String username = scanner.nextLine();
        if (users.containsKey(username)) {
            System.out.println("Користувач " + username + " існує.");
        } else {
            System.out.println("Користувача з таким логіном не знайдено.");
        }
    }

    private void changeUsername() {
        System.out.print("Введіть поточний логін користувача: ");
        String currentUsername = scanner.nextLine();
        if (users.containsKey(currentUsername)) {
            System.out.print("Введіть новий логін для користувача: ");
            String newUsername = scanner.nextLine();
            String password = users.remove(currentUsername);
            users.put(newUsername, password);
            System.out.println("Логін користувача " + currentUsername + " змінено на " + newUsername + ".");
        } else {
            System.out.println("Користувача з таким логіном не знайдено.");
        }
    }

    private void changePassword() {
        System.out.print("Введіть логін користувача, для якого потрібно змінити пароль: ");
        String username = scanner.next();
        if (users.containsKey(username)) {
            System.out.print("Введіть новий пароль для користувача: ");
            String newPassword = scanner.nextLine();
            users.put(username, newPassword);
            System.out.println("Пароль користувача " + username + " змінено.");
        } else {
            System.out.println("Користувача з таким логіном не знайдено.");
        }
    }

}
