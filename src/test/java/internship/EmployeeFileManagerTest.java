package internship;

import org.json.JSONException;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class EmployeeFileManagerTest {

    private static final String TEST_FILENAME = "test_employees.json";

    @Test
    public void testSaveEmployees() throws JSONException {
        Manager manager = new Manager("John", "Doe", 1);
        manager.setSalaryRate(5000);
        manager.setWorkedHours(160);

        Programmer programmer = new Programmer("Jane", "Smith", 2);
        programmer.setSalaryRate(4000);
        programmer.setWorkedHours(150);

        List<Employee> employees = Arrays.asList(manager, programmer);
        EmployeeFileManager fileManager = new EmployeeFileManager(TEST_FILENAME);

        fileManager.saveEmployees(employees);

        File file = new File(TEST_FILENAME);
        assertTrue(file.exists());
        assertTrue(file.length() > 0);
    }

    @Test
    public void testLoadEmployees() throws JSONException, IOException, ReflectiveOperationException {
        String jsonContent = "["
                + "{\"className\":\"internship.Manager\",\"firstName\":\"John\",\"lastName\":\"Doe\",\"id\":1,\"salaryRate\":5000,\"workedHours\":160},"
                + "{\"className\":\"internship.Programmer\",\"firstName\":\"Jane\",\"lastName\":\"Smith\",\"id\":2,\"salaryRate\":4000,\"workedHours\":150}"
                + "]";
        Files.write(Paths.get(TEST_FILENAME), jsonContent.getBytes());

        EmployeeFileManager fileManager = new EmployeeFileManager(TEST_FILENAME);
        List<Employee> employees = fileManager.loadEmployees();

        assertEquals(2, employees.size());

        Employee manager = employees.get(0);
        assertTrue(manager instanceof Manager);
        assertEquals("John", manager.getFirstName());
        assertEquals("Doe", manager.getLastName());
        assertEquals(1, manager.getId());
        assertEquals(5000, manager.getSalaryRate(), 0);
        assertEquals(160, manager.getWorkedHours());

        Employee programmer = employees.get(1);
        assertTrue(programmer instanceof Programmer);
        assertEquals("Jane", programmer.getFirstName());
        assertEquals("Smith", programmer.getLastName());
        assertEquals(2, programmer.getId());
        assertEquals(4000, programmer.getSalaryRate(), 0);
        assertEquals(150, programmer.getWorkedHours());
    }
}
