import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите числа через пробел:");

        // Чтение строки с числами
        String input = scanner.nextLine();

        // Разделение строки на части и преобразование в список целых чисел
        List<Integer> numbers = new ArrayList<>();
        String[] parts = input.split(" ");

        for (String part : parts) {
            try {
                int number = Integer.parseInt(part);
                numbers.add(number); // Добавление числа в список
            } catch (NumberFormatException e) {
                System.out.println("Пожалуйста, введите корректные числа.");
                return; // Завершение программы при ошибке
            }
        }

        rearrangeList(numbers);

        // Вывод результата
        System.out.println("Переставленный список: " + numbers);
    }

    public static void rearrangeList(List<Integer> list) {
        int n = list.size();
        int positiveIndex = 0; // Индекс для положительных чисел

        for (int i = 0; i < n; i++) {
            if (list.get(i) >= 0) {
                // Перемещаем положительные числа в начало списка
                int temp = list.get(i);
                list.set(i, list.get(positiveIndex));
                list.set(positiveIndex, temp);
                positiveIndex++;
            }
        }
    }
}