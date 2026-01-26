package Lab2;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("ЛАБОРАТОРНАЯ РАБОТА 2");

        boolean exit = false; // Флаг для выхода из программы
        while (!exit) {
            System.out.println("\n=== ГЛАВНОЕ МЕНЮ ===");
            System.out.println("1. Задание 1.3");
            System.out.println("2. Задание 1.4");
            System.out.println("3. Задание 2.4");
            System.out.println("4. Задание 3.4");
            System.out.println("5. Задание 4.4");
            System.out.println("6. Задание 5.4");
            System.out.println("0. Выход");
            System.out.print("Выберите задание (0-6): ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    task1_3_Class(scanner);
                    break;
                case "2":
                    task1_4(scanner);
                    break;
                case "3":
                    task2_4(scanner);
                    break;
                case "4":
                    task3_4_Class(scanner);
                    break;
                case "5":
                    task4_4(scanner);
                    break;
                case "6":
                    task5_4(scanner);
                    break;
                case "0":
                    exit = true;
                    System.out.println("Выход из программы...");
                    break;
                default:
                    System.out.println("Неверный выбор! Попробуйте снова.");
            }
        }

        scanner.close();
    }

    // Задание 1.3
    public static void task1_3_Class(Scanner scanner) {
        System.out.println("\nЗАДАНИЕ 1.3 - РАБОТА С ИМЕНАМИ");

        // Запрашиваем количество имен
        int totalCount = getPositiveInt(scanner, "Введите количество имен для создания: ");

        // Цикл для создания каждого имени
        for (int i = 0; i < totalCount; i++) {
            System.out.println("\nИмя " + (i + 1));
            String firstName = getLettersInput(scanner, "Введите фамилию (или Enter чтобы пропустить): ", false);
            String middleName = getLettersInput(scanner, "Введите имя: ", true);
            String lastName = getLettersInput(scanner, "Введите отчество (или Enter чтобы пропустить): ", false);

            // Создаем объект имени
            Task1_3 name = new Task1_3(firstName, middleName, lastName);
            System.out.println(name);
        }
    }

    // Задание 1.4
    public static void task1_4(Scanner scanner) {
        System.out.println("\nЗАДАНИЕ 1.4 - ВРЕМЯ (ПЕРЕВОД СЕКУНД В ФОРМАТ ЧЧ:ММ:СС)");

        boolean exitMenu = false;

        while (!exitMenu) {
            System.out.println("\n--- МЕНЮ ЗАДАНИЯ 1.4 ---");
            System.out.println("1. Ввести количество секунд для перевода в формат ЧЧ:ММ:СС");
            System.out.println("0. Вернуться в главное меню");
            System.out.print("Выберите действие: ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    // Ввод секунд для перевода
                    System.out.println("\n--- ПЕРЕВОД СЕКУНД В ФОРМАТ ЧЧ:ММ:СС ---");
                    int seconds = getPositiveInt(scanner, "Введите количество секунд: ");

                    // Создаем объект времени
                    Task1_4 time = new Task1_4(seconds); // Создаем объект времени
                    System.out.println("\nРезультат:");
                    System.out.println(seconds + " секунд -> " + time);
                    break;

                case "0":
                    exitMenu = true;
                    break;

                default:
                    System.out.println("Неверный выбор! Попробуйте снова.");
            }
        }
    }

    // Задание 2.4
    public static void task2_4(Scanner scanner) {
        System.out.println("\nЗАДАНИЕ 2.4 - ОТДЕЛЫ И СОТРУДНИКИ (1 ОТДЕЛ)");

        System.out.print("Введите название отдела: ");
        String deptName = scanner.nextLine(); // Читаем название отдела
        Department department = new Department(deptName); // Создаем отдел

        int count = getPositiveInt(scanner, "Введите количество сотрудников в отделе: ");

        Task2_4[] employees = new Task2_4[count]; // Создаем массив сотрудников

        for (int i = 0; i < count; i++) {
            String name = getLettersInput(scanner, "Фамилия сотрудника " + (i + 1) + ": ", true);
            employees[i] = new Task2_4(name, department); // Создаем сотрудника
        }

        // Назначаем начальника отдела
        Task2_4 head = null;
        while (head == null) {
            String nameHead = getLettersInput(scanner, "Введите фамилию начальника отдела: ", true);
            // Ищем сотрудника с указанной фамилией
            for (Task2_4 emp : employees) {
                if (emp.getName().equals(nameHead)) {
                    head = emp;
                    break;
                }
            }
            if (head == null) {
                System.out.println("Сотрудник с фамилией '" + nameHead + "' не найден! Попробуйте снова.");
            }
        }
        department.setHead(head); // Назначаем начальника

        // Выводим информацию о всех сотрудниках
        System.out.println("\n=== Информация о сотрудниках ===");
        for (Task2_4 emp : employees) {
            System.out.println(emp);
        }
    }

    // Задание 3.4
    public static void task3_4_Class(Scanner scanner) {
        System.out.println("\nЗАДАНИЕ 3.4 - ОТДЕЛЫ И СОТРУДНИКИ (НЕСКОЛЬКО ОТДЕЛОВ)");

        List<Department3_4> departments = new ArrayList<>();

        int deptCount = getPositiveInt(scanner, "Введите количество отделов: ");

        for (int i = 0; i < deptCount; i++) {
            System.out.println("\n--- Создание отдела " + (i + 1) + " ---");
            System.out.print("Введите название отдела: ");
            Department3_4 dept = new Department3_4(scanner.nextLine()); // Создаем отдел
            departments.add(dept); // Добавляем в список

            int empCount = getPositiveInt(scanner, "Введите количество сотрудников в отделе '" + dept.getName() + "': ");

            if (empCount > 0) {
                Task3_4[] employees = new Task3_4[empCount]; // Создаем массив сотрудников

                for (int j = 0; j < empCount; j++) {
                    String name = getLettersInput(scanner, "Фамилия сотрудника " + (j + 1) + ": ", true);
                    employees[j] = new Task3_4(name, dept); // Создаем сотрудника
                }

                // Назначаем начальника отдела
                Task3_4 head = null;
                while (head == null) {
                    String nameHead = getLettersInput(scanner, "Введите фамилию начальника отдела: ", true);

                    // Ищем сотрудника с указанной фамилией
                    for (Task3_4 emp : employees) {
                        if (emp.getName().equals(nameHead)) {
                            head = emp;
                            break;
                        }
                    }

                    if (head == null) {
                        System.out.println("Сотрудник с фамилией '" + nameHead + "' не найден в этом отделе! Попробуйте снова.");
                    }
                }
                dept.setHead(head); // Назначаем начальника

                System.out.println("Отдел '" + dept.getName() + "' создан. Начальник: " + head.getName());
            }
        }

        // Дополнительная демонстрация: поиск сотрудника
        System.out.println("\nПОИСК СОТРУДНИКА И ЕГО КОЛЛЕГ");
        boolean continueSearch = true;

        while (continueSearch) {
            System.out.print("Введите фамилию сотрудника для поиска (или 'выход' для завершения): ");
            String searchName = scanner.nextLine().trim();

            if (searchName.equalsIgnoreCase("выход")) {
                continueSearch = false;
                continue;
            }

            Task3_4 foundEmployee = null;
            Department3_4 foundDept = null;

            // Поиск сотрудника по всем отделам
            for (Department3_4 dept : departments) {
                for (Task3_4 emp : dept.getEmployees()) {
                    if (emp.getName().equalsIgnoreCase(searchName)) {
                        foundEmployee = emp;
                        foundDept = dept;
                        break;
                    }
                }
                if (foundEmployee != null) break;
            }

            // Вывод результатов поиска
            if (foundEmployee != null) {
                System.out.println("\nНайден сотрудник: " + foundEmployee);
                System.out.println("Все сотрудники отдела " + foundDept.getName() + ":");

                List<Task3_4> deptEmployees = foundEmployee.getDepartmentEmployees();
                for (Task3_4 emp : deptEmployees) {
                    String headMark = emp.isHeadOfDepartment() ? " (начальник)" : "";
                    System.out.println("- " + emp.getName() + headMark);
                }
                System.out.println("Всего: " + deptEmployees.size() + " сотрудников\n");
            } else {
                System.out.println("Сотрудник с фамилией '" + searchName + "' не найден.\n");
            }
        }
    }

    // Задание 4.4
    public static void task4_4(Scanner scanner) {
        System.out.println("\nЗАДАНИЕ 4.4 - ВРЕМЯ С МЕНЮ");

        List<Task4_4> timeList = new ArrayList<>(); // Список для хранения созданных времен
        boolean exitMenu = false;

        while (!exitMenu) {
            System.out.println("\n--- МЕНЮ РАБОТЫ СО ВРЕМЕНЕМ ---");
            System.out.println("1. Создать время из секунд");
            System.out.println("2. Создать время из часов, минут, секунд");
            System.out.println("0. Вернуться в главное меню");
            System.out.print("Выберите действие: ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    System.out.println("\n--- СОЗДАНИЕ ВРЕМЕНИ ИЗ СЕКУНД ---");
                    int seconds = getPositiveInt(scanner, "Введите количество секунд: ");

                    try {
                        Task4_4 time = new Task4_4(seconds); // Создаем время
                        timeList.add(time); // Добавляем в список
                        System.out.println("Создано время: " + time);
                        System.out.println("Детали:");
                        System.out.println("  Часы: " + time.getHours());
                        System.out.println("  Минуты: " + time.getMinutes());
                        System.out.println("  Секунды: " + time.getSecondsPart());
                        System.out.println("  Всего секунд: " + time.getTotalSeconds());
                    } catch (Exception e) {
                        System.out.println("Ошибка при создании времени: " + e.getMessage());
                    }
                    break;

                case "2":
                    System.out.println("\n--- СОЗДАНИЕ ВРЕМЕНИ ИЗ ЧАСОВ, МИНУТ, СЕКУНД ---");
                    int hours = getPositiveInt(scanner, "Введите часы (0-23): ");
                    // Валидация часов
                    while (hours < 0 || hours > 23) {
                        System.out.println("Часы должны быть в диапазоне 0-23!");
                        hours = getPositiveInt(scanner, "Введите часы (0-23): ");
                    }

                    int minutes = getPositiveInt(scanner, "Введите минуты (0-59): ");
                    // Валидация минут
                    while (minutes < 0 || minutes > 59) {
                        System.out.println("Минуты должны быть в диапазоне 0-59!");
                        minutes = getPositiveInt(scanner, "Введите минуты (0-59): ");
                    }

                    int secs = getPositiveInt(scanner, "Введите секунды (0-59): ");
                    // Валидация секунд
                    while (secs < 0 || secs > 59) {
                        System.out.println("Секунды должны быть в диапазоне 0-59!");
                        secs = getPositiveInt(scanner, "Введите секунды (0-59): ");
                    }

                    try {
                        Task4_4 time = new Task4_4(hours, minutes, secs); // Создаем время
                        timeList.add(time); // Добавляем в список
                        System.out.println("Создано время: " + time);
                        System.out.println("Детали:");
                        System.out.println("  Часы: " + time.getHours());
                        System.out.println("  Минуты: " + time.getMinutes());
                        System.out.println("  Секунды: " + time.getSecondsPart());
                        System.out.println("  Всего секунд: " + time.getTotalSeconds());
                    } catch (Exception e) {
                        System.out.println("Ошибка при создании времени: " + e.getMessage());
                    }
                    break;

                case "0":
                    exitMenu = true;
                    break;

                default:
                    System.out.println("Неверный выбор! Попробуйте снова.");
            }
        }
    }

    // Задание 5.4
    public static void task5_4(Scanner scanner) {
        System.out.println("\nЗАДАНИЕ 5.4 - ВРЕМЯ С ДОПОЛНИТЕЛЬНЫМИ МЕТОДАМИ");

        boolean exitMenu = false;

        while (!exitMenu) {
            System.out.println("\n--- МЕНЮ ЗАДАНИЯ 5.4 ---");
            System.out.println("1. Введите количество секунд для вычисления часов");
            System.out.println("2. Введите количество секунд для вычисления минут");
            System.out.println("3. Введите количество секунд для вычисления секунд");
            System.out.println("0. Вернуться в главное меню");
            System.out.print("Выберите действие: ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    calculateHours(scanner);
                    break;

                case "2":
                    calculateMinutes(scanner);
                    break;

                case "3":
                    calculateSeconds(scanner);
                    break;

                case "0":
                    exitMenu = true;
                    break;

                default:
                    System.out.println("Неверный выбор! Попробуйте снова.");
            }
        }
    }

    // Метод для вычисления часов
    private static void calculateHours(Scanner scanner) {
        System.out.println("\n--- ВЫЧИСЛЕНИЕ ЧАСОВ ---");
        System.out.println("Введите количество секунд (например, 34056):");
        int seconds = getPositiveInt(scanner, "Секунды: ");
        Task5_4 time = new Task5_4(seconds); // Создаем объект времени

        System.out.println("\nРезультат:");
        System.out.println("Время " + seconds + " секунд:");
        System.out.println("Часы: " + time.getHours()); // Выводим часы
        System.out.println("Полное время: " + time); // Выводим полное время
    }

    // Метод для вычисления минут
    private static void calculateMinutes(Scanner scanner) {
        System.out.println("\n--- ВЫЧИСЛЕНИЕ МИНУТ ---");
        System.out.println("Введите количество секунд (например, 4532):");
        int seconds = getPositiveInt(scanner, "Секунды: ");
        Task5_4 time = new Task5_4(seconds); // Создаем объект времени

        System.out.println("\nРезультат:");
        System.out.println("Время " + seconds + " секунд:");
        System.out.println("Минуты с начала часа: " + time.getMinutes()); // Выводим минуты
        System.out.println("Полное время: " + time); // Выводим полное время
    }

    // Метод для вычисления секунд
    private static void calculateSeconds(Scanner scanner) {
        System.out.println("\n--- ВЫЧИСЛЕНИЕ СЕКУНД ---");
        System.out.println("Введите количество секунд (например, 123):");
        int seconds = getPositiveInt(scanner, "Секунды: ");
        Task5_4 time = new Task5_4(seconds); // Создаем объект времени

        System.out.println("\nРезультат:");
        System.out.println("Время " + seconds + " секунд:");
        System.out.println("Секунды с начала минуты: " + time.getSecondsPart()); // Выводим секунды
        System.out.println("Полное время: " + time); // Выводим полное время
    }

    // Метод для получения положительного целого числа
    private static int getPositiveInt(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                int number = Integer.parseInt(scanner.nextLine().trim()); // Пытаемся преобразовать строку в число
                if (number >= 0) return number; // Проверяем, что число не отрицательное
                System.out.println("Число не может быть отрицательным!");
            } catch (NumberFormatException e) {
                System.out.println("Введите целое число!");
            }
        }
    }

    // Метод для получения строки, содержащей только буквы
    private static String getLettersInput(Scanner scanner, String prompt, boolean required) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();

            // Если поле не обязательно и пустое - возвращаем пустую строку
            if (!required && input.isEmpty()) return input;
            // Если поле обязательно и пустое - сообщаем об ошибке
            if (input.isEmpty()) {
                System.out.println("Поле не может быть пустым!");
                continue;
            }
            // Проверяем, что строка содержит только буквы, пробелы и дефисы
            if (input.matches("[a-zA-Zа-яА-ЯёЁ\\s-]+")) return input;
            System.out.println("Поле должно содержать только буквы, пробелы и дефисы!");
        }
    }
}