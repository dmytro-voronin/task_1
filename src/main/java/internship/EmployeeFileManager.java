package internship;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class EmployeeFileManager {
    private String filename;

    public EmployeeFileManager(String filename) {
        this.filename = filename;
    }

    public void saveEmployees(List<Employee> employees) throws JSONException {
        JSONArray jsonArray = new JSONArray();
        for (Employee employee : employees) {
            jsonArray.put(JsonUtils.toJson(employee));
        }

        try (FileWriter fileWriter = new FileWriter(filename)) {
            fileWriter.write(jsonArray.toString());
            System.out.println("Employees saved to " + filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Employee> loadEmployees() {
        try {
            String jsonContent = new String(Files.readAllBytes(Paths.get(filename)));
            JSONArray loadedArray = new JSONArray(jsonContent);
            List<Employee> employees = new ArrayList<>();
            for (int i = 0; i < loadedArray.length(); i++) {
                JSONObject employeeJson = loadedArray.getJSONObject(i);
                Employee loadedEmployee = JsonUtils.fromJson(employeeJson);
                employees.add(loadedEmployee);
            }
            return employees;
        } catch (IOException | ReflectiveOperationException | JSONException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
