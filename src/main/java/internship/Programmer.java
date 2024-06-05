package internship;

public class Programmer extends Employee {

    public Programmer() {
    }

    public Programmer(String firstName, String lastName, int id) {
        super(firstName, lastName, id);
    }

    @Override
    public double getMonthlySalary() {
        return getSalaryRate() * (getWorkedHours() / 160.0);
    }
}
