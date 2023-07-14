import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NumberList {
    private List<Integer> numbers;
    private Scanner scanner;

    public NumberList() {
        numbers = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void run() {
        int choice;
        do {
            displayMenu();
            System.out.println("Введіть номер опції: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1: {
                    addNumberToList();
                    break;
                }
                case 2: {
                    removeNumberFromList();
                    break;
                }
                case 3: {
                    showListComponents();
                    break;
                }
                case 4: {
                    checkNumberInList();
                    break;
                }
                case 5: {
                    replaceNumberInList();
                    break;
                }
                case 0: {
                    System.out.println("Програма завершується.");
                    break;
                }
                default: {
                    System.out.println("Недійсний вибір. Введіть номер опції зі списку.");
                    break;
                }
            }
        } while (choice != 0);
        scanner.close();
    }

    private void displayMenu() {
        System.out.println("Муню:");
        System.out.println("1. Додати елемент в список");
        System.out.println("2. Видалити елемент з списку");
        System.out.println("3. Показати вміст списку");
        System.out.println("4. Перивірити чи є хначення в списку");
        System.out.println("5. Замінити значення в списку списку");
        System.out.println("0. Вийти");
    }

    private void addNumberToList() {
        System.out.println("Введіть число для додавання");
        int addNumber = scanner.nextInt();
        numbers.add(addNumber);
        System.out.println("Число" + addNumber + " додати до списку.");
    }

    private void removeNumberFromList() {
        System.out.println("Введіть індекс елемента, який потрібно видалити:");
        int removeIndex = scanner.nextInt();
        if (removeIndex >= 0 && removeIndex < numbers.size()) {
            int removedNumber = numbers.remove(removeIndex);
            System.out.println("Число " + removedNumber + " видалено зі списку.");
        } else {
            System.out.println("Недійсний індекс");
        }
    }

    private void showListComponents() {
        System.out.println("Вміст списку:");
        for (int number : numbers) {
            System.out.print(number + ",");
        }
    }

    private void checkNumberInList() {
        System.out.println("Введіть число для перевірки: ");
        int checkNumber = scanner.nextInt();
        boolean containsNumber = numbers.contains(checkNumber);
        if (containsNumber) {
            System.out.println("Список містить число" + checkNumber + ".");

        } else {
            System.out.println("Список не містить число" + checkNumber + ".");

        }
    }

    private void replaceNumberInList() {
        System.out.print("Введіть індекс елемента, який потрібно замінити: ");
        int replaceIndex = scanner.nextInt();
        if (replaceIndex >= 0 && replaceIndex < numbers.size()) {
            System.out.print("Введіть нове число: ");
            int newNumber = scanner.nextInt();
            int replacedNumber = numbers.set(replaceIndex, newNumber);
            System.out.println("Число " + replacedNumber + "замінено на число :" + newNumber + ".");
        } else {
            System.out.println("Недійсний індекс.");
        }
    }
}
