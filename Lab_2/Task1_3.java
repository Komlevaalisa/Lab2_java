package Lab2;

public class Task1_3 {
    private String firstName;
    private String middleName;
    private String lastName;

    public Task1_3(String firstName, String middleName, String lastName) {
        this.firstName = firstName != null ? firstName : "";
        this.middleName = middleName != null ? middleName : "";
        this.lastName = lastName != null ? lastName : "";
    }

    // Приватный вспомогательный метод для проверки строки
    private boolean isNotEmpty(String str) {
        return str != null && !str.trim().isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        if (isNotEmpty(firstName)) {
            result.append(firstName);
        }

        if (isNotEmpty(middleName)) {
            if (result.length() > 0) {
                result.append(" ");
            }
            result.append(middleName);
        }

        // Если отчество не пустое
        if (isNotEmpty(lastName)) {
            // Если уже что-то добавлено, добавляем пробел
            if (result.length() > 0) {
                result.append(" ");
            }
            result.append(lastName); // Добавляем отчество
        }

        return result.toString(); // Возвращаем итоговую строку
    }
}