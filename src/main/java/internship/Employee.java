package internship;

public abstract class Employee {
    private String firstName;
    private String lastName;
    private int id;
    private double salaryRate;
    private int workedHours;

    public Employee(String firstName, String lastName, int id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getId() {
        return id;
    }

    public double getSalaryRate() {
        return salaryRate;
    }

    public int getWorkedHours() {
        return workedHours;
    }

    public void setSalaryRate(double salaryRate) {
        this.salaryRate = salaryRate;
    }

    public void setWorkedHours(int workedHours) {
        this.workedHours = workedHours;
    }

    public double getWorkedTimePercentage() {
        int normHours = 160; // assuming 20 working days a month
        return (double) workedHours / normHours * 100;
    }

    public abstract double getMonthlySalary();

    @Override
    public String toString() {
        return "Employee{"
                + "firstName='" + firstName + '\''
                + ", lastName='" + lastName + '\''
                + ", id=" + id
                + ", salaryRate=" + salaryRate
                + ", workedHours=" + workedHours
                + '}';
    }
}
