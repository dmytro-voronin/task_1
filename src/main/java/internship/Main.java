package internship;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;

public class Main {

    public static void main(String[] args) throws JSONException {

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

        // Запись Загрузка сотрудников из JSON
        EmployeeFileManager employeeFileManager = new EmployeeFileManager("employees.json");

        try {
            employeeFileManager.saveEmployees(employees);

            List<Employee> loadedEmployees = employeeFileManager.loadEmployees();

            for (Employee emp : loadedEmployees) {
                System.out.println(emp);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        // Создаем объект для клонирования
        Manager original = new Manager("John", "Doe", 123);
        original.setSalaryRate(5000.0);
        original.setWorkedHours(160);

        // Клонируем объект
        Manager clone = ObjectCloner.cloneObject(original);

        // Проверяем, что клонирование прошло успешно
        System.out.println("Original: " + original);
        System.out.println("Clone: " + clone);
    }
}
