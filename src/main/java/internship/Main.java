package internship;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Создание сотрудников
        Employee programmer1 = new Programmer("John", "Doe", 1);
        programmer1.setSalaryRate(5000);
        programmer1.setWorkedHours(160);

        Employee programmer2 = new Programmer("Alice", "Johnson", 2);
        programmer2.setSalaryRate(5500);
        programmer2.setWorkedHours(140);

        Employee manager1 = new Manager("Jane", "Smith", 3);
        manager1.setSalaryRate(6000);
        manager1.setWorkedHours(170);

        Employee manager2 = new Manager("Bob", "Brown", 4);
        manager2.setSalaryRate(6500);
        manager2.setWorkedHours(130);

        // Создание списка сотрудников
        List<Employee> employees = new ArrayList<>();
        employees.add(programmer1);
        employees.add(programmer2);
        employees.add(manager1);
        employees.add(manager2);

        // Расчет общей зарплаты
        Accountant accountant = new Accountant();
        double totalSalary = accountant.calculateTotalSalary(employees);

        // Вывод информации о зарплатах
        for (Employee employee : employees) {
            System.out.println("Employee: " + employee.getFirstName() + " "
                    + employee.getLastName() + ", Monthly Salary: "
                    + employee.getMonthlySalary());
        }
        System.out.println("Total Salary: " + totalSalary);
    }
}
