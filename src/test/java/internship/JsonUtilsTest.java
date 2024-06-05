package internship;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class JsonUtilsTest {

    @Test
    public void testToJson() throws JSONException {
        Manager manager = new Manager("John", "Doe", 1);
        manager.setSalaryRate(5000);
        manager.setWorkedHours(160);

        JSONObject json = JsonUtils.toJson(manager);

        assertEquals("John", json.getString("firstName"));
        assertEquals("Doe", json.getString("lastName"));
        assertEquals(1, json.getInt("id"));
        assertEquals(5000, json.getDouble("salaryRate"), 0);
        assertEquals(160, json.getInt("workedHours"));
        assertEquals(Manager.class.getName(), json.getString("className"));
    }

    @Test
    public void testFromJson() throws JSONException, ReflectiveOperationException {
        JSONObject json = new JSONObject();
        json.put("className", Manager.class.getName());
        json.put("firstName", "John");
        json.put("lastName", "Doe");
        json.put("id", 1);
        json.put("salaryRate", 5000);
        json.put("workedHours", 160);

        Employee employee = JsonUtils.fromJson(json);

        assertTrue(employee instanceof Manager);
        assertEquals("John", employee.getFirstName());
        assertEquals("Doe", employee.getLastName());
        assertEquals(1, employee.getId());
        assertEquals(5000, employee.getSalaryRate(), 0);
        assertEquals(160, employee.getWorkedHours());
    }
}
