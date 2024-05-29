package internship;

import java.util.List;

public class Accountant {

    public double calculateTotalSalary(List<Employee> employees) {
        double totalSalary = 0;
        for (Employee employee : employees) {
            totalSalary += employee.getMonthlySalary();
        }
        return totalSalary;
    }
}
