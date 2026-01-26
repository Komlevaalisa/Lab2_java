package Lab2;

public class Task2_4 {
    private String name;
    private Department department;

    // Конструктор сотрудника
    public Task2_4(String name, Department department) {
        this.name = name;
        this.department = department;
    }

    public String getName() {
        return name;
    }


    @Override
    public String toString() {
        // Формируем строку с информацией о сотруднике и его отделе
        return name + " работает в отделе " + department.getName() +
                ", начальник которого " + department.getHead().getName();
    }
}

// Внутренний класс Department (отдел)
class Department {
    private String name;
    private Task2_4 head;

    public Department(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Task2_4 getHead() {
        return head;
    }

    public void setHead(Task2_4 head) {
        this.head = head; // Устанавливаем начальника отдела
    }
}
