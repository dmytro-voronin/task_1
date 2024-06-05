package internship;

import org.json.JSONException;
import org.json.JSONObject;

public class JsonUtils {

    public static JSONObject toJson(Employee employee) throws JSONException {
        JSONObject json = new JSONObject();
        json.put("className", employee.getClass().getName());
        json.put("firstName", employee.getFirstName());
        json.put("lastName", employee.getLastName());
        json.put("id", employee.getId());
        json.put("salaryRate", employee.getSalaryRate());
        json.put("workedHours", employee.getWorkedHours());
        return json;
    }

    public static Employee fromJson(JSONObject json) throws JSONException,
            ReflectiveOperationException {
        String className = json.getString("className");
        String firstName = json.getString("firstName");
        String lastName = json.getString("lastName");
        int id = json.getInt("id");
        double salaryRate = json.getDouble("salaryRate");
        int workedHours = json.getInt("workedHours");

        Class<?> clazz = Class.forName(className);
        Employee employee = (Employee) clazz.getConstructor(String.class, String.class, int.class)
                .newInstance(firstName, lastName, id);
        employee.setSalaryRate(salaryRate);
        employee.setWorkedHours(workedHours);
        return employee;
    }
}
