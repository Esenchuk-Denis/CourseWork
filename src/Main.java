public class Main {
    private static Employee[] employees = new Employee[10];
    private static int employeeCount = 0;

    private static void addEmployee(String fullName, int department, double salary) {
        if (employeeCount < employees.length) {
            employees[employeeCount++] = new Employee(fullName, department, salary);
        } else {
            System.out.println("Хранилище сотрудников заполнено.");
        }
    }

    //    Получить список всех сотрудников со всеми имеющимися по ним данными (вывести в консоль значения всех полей (toString));
    public static void printAllEmployees() {
        System.out.println(" Все сотрудники:");
        for (int i = 0; i < employeeCount; i++) {
            System.out.println(employees[i]);
        }
    }

    //    Посчитать сумму затрат на ЗП в месяц;
    public static double calculSalaryEmployees() {
        double total = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                total += employee.getSalary();
            }
        }
        return total;
    }

    //    Найти сотрудника с максимальной ЗП;
    public static Employee maxSalaryEmployee() {

        Employee maxSalaryEmployee = employees[0];
        for (Employee employee : employees) {
            if (employee.getSalary() > maxSalaryEmployee.getSalary()) {
                maxSalaryEmployee = employee;
            }
        }


        return maxSalaryEmployee;
    }

    //    Найти сотрудника с минимальной ЗП;
    public static Employee minSalaryEmployee() {

        Employee minSalaryEmployee = employees[0];
        for (Employee employee : employees) {
            if (employee.getSalary() < minSalaryEmployee.getSalary()) {
                minSalaryEmployee = employee;
            }
        }


        return minSalaryEmployee;
    }

    //    Подсчитать среднее значение зарплат (можно использовать для этого метод из пункта b);
    public static double meanSalary() {
        double meanSalary;
        meanSalary = calculSalaryEmployees() / employees.length;
        return meanSalary;
    }
//    Распечатать ФИО всех сотрудников (метод ничего).

    public static void main(String[] args) {
        addEmployee("Иванов Иван Иванович", 1, 50000);
        addEmployee("Корнев Дмитрий Александрович", 2, 45000);
        addEmployee("Шмелев Евгений Максимович", 3, 50780);
        addEmployee("Смелов Борис Денисович", 4, 36800);
        addEmployee("Катержина Оксана Николаевна", 5, 63195);
        addEmployee("Великих Антон Макарович", 2, 78415);
        addEmployee("Синицина Варвара Петровна", 5, 32590);
        addEmployee("Яйцев Максим Викторович", 4, 57250);
        addEmployee("Шмелева Кристина Генадьевна", 1, 78250);
        addEmployee("Сталин Иосиф Виссарионович", 3, 89600);

        printAllEmployees();
        System.out.println("Сумма всех затрат на зп = " + calculSalaryEmployees());
        System.out.println("Средняя значение зарплат" + meanSalary());
        System.out.println("Сотрудник с максимальной зп - " + maxSalaryEmployee());
        System.out.println("Сотрудник с минимальной зп - " + minSalaryEmployee());
    }
}