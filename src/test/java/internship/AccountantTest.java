package internship;

import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class AccountantTest {

    @Test
    public void testCalculateTotalSalary() {
        Employee programmer = new Programmer("John", "Doe", 1);
        programmer.setSalaryRate(5000);
        programmer.setWorkedHours(160);

        Employee manager = new Manager("Jane", "Smith", 2);
        manager.setSalaryRate(6000);
        manager.setWorkedHours(150);

        List<Employee> employees = Arrays.asList(programmer, manager);
        Accountant accountant = new Accountant();
        double totalSalary = accountant.calculateTotalSalary(employees);

        assertEquals(5000, programmer.getMonthlySalary(), 0);
        assertEquals(5625, manager.getMonthlySalary(), 0);
        assertEquals(10625, totalSalary, 0);
    }
}
