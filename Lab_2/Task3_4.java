package Lab2;

import java.util.ArrayList;
import java.util.List;

public class Task3_4 {
    private String name;
    private Department3_4 department;

    public Task3_4(String name, Department3_4 department) {
        this.name = name;
        this.department = department;
        this.department.addEmployee(this); // Автоматически добавляем сотрудника в отдел
    }

    public String getName() {
        return name;
    }


    // Метод проверяет, является ли сотрудник начальником отдела
    public boolean isHeadOfDepartment() {
        return this.department.getHead() == this; // Сравниваем ссылки
    }

    // Метод возвращает всех сотрудников этого отдела
    public List<Task3_4> getDepartmentEmployees() {
        return this.department.getEmployees();
    }

    @Override
    public String toString() {
        if (isHeadOfDepartment()) {
            // Если сотрудник - начальник
            return name + " начальник отдела " + department.getName();
        } else {
            // Если сотрудник - не начальник
            String headName = department.getHead() != null ?
                    department.getHead().getName() : "не назначен"; // Получаем имя начальника или "не назначен"
            return name + " работает в отделе " + department.getName() +
                    ", начальник которого " + headName;
        }
    }
}

class Department3_4 {
    private String name;
    private Task3_4 head;
    private List<Task3_4> employees;

    public Department3_4(String name) {
        this.name = name;
        this.employees = new ArrayList<>(); // Создаем пустой список сотрудников
    }

    public String getName() {
        return name;
    }

    public Task3_4 getHead() {
        return head;
    }

    public void setHead(Task3_4 head) {
        this.head = head; // Устанавливаем начальника
    }

    // Метод для добавления сотрудника в отдел
    public void addEmployee(Task3_4 employee) {
        if (!employees.contains(employee)) { // Проверяем, нет ли уже такого сотрудника
            employees.add(employee);
        }
    }

    // Метод возвращает копию списка сотрудников (защита от внешних изменений)
    public List<Task3_4> getEmployees() {
        return new ArrayList<>(employees); // Возвращаем новую копию списка
    }

}