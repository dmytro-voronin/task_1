package internship;

public class Manager extends Employee {

    public Manager() {
    }

    public Manager(String firstName, String lastName, int id) {
        super(firstName, lastName, id);
    }

    @Override
    public double getMonthlySalary() {
        double workedPercentage = getWorkedTimePercentage();
        if (workedPercentage >= 100) {
            return getSalaryRate();
        } else {
            return getSalaryRate() * (workedPercentage / 100);
        }
    }
}
