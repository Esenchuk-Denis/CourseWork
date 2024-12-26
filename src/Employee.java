import java.util.Objects;

public class Employee {
    private static int counter = 1;
    private final int id;
    private String fullName;
    private int department;
    private double salary;


    public Employee(String fullName, int department, double salary) {
        this.id = counter++;
        this.fullName = fullName;
        this.setDepartment(department);
        this.setSalary(salary);
    }

    //геттеры
    public String getFullName() {
        return fullName;
    }

    public double getSalary() {
        return salary;
    }

    public int getId() {
        return id;

    }

    public int getDepartment() {
        return department;
    }

    //сеттеры


    public void setDepartment(int department) {
        if (department < 1 || department > 5) {
            throw new IllegalArgumentException("Отдел может быть только 1-5");
        }
        this.department = department;
    }

    public void setSalary(double salary) {
        if (salary < 0) {
            throw new IllegalArgumentException("Зарплата не может быть отрицательной");
        }
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id) && Objects.equals(fullName, employee.fullName) && Objects.equals(department, employee.department) && Objects.equals(salary, employee.salary);
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }

    @Override
    public String toString() {
        return "id= " + id + ", ФИО: " + fullName + ", отдел: " + department + ", зарплата: " + salary;
    }
}

