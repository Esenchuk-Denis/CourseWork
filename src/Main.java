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

    //---------------------------------------------------------------------------
    // индексация зп всех сотрудников на процент
    public static void indexSalary(double precent) {
        double indx = 0;
        for (Employee employee : employees) {
            indx = employee.getSalary() * (precent / 100) + employee.getSalary();
            employee.setSalary(indx);
        }
//        System.out.println("Индексация зп всех сотрудников:");
//        for (int i = 0; i < employeeCount; i++) {
//            System.out.println(employees[i]);
//        }
        System.out.println("Индексация зп сотрудников");
        printAllEmployees();
    }

    //минимальная зп в заданном отделе
    public static Employee minSalaryDepartment(int dep) {

        Employee minSalaryDepartment = employees[0];
        for (Employee employee : employees) {
            if (employee.getDepartment() == dep) {
                if (employee.getSalary() < minSalaryDepartment.getSalary()) {
                    minSalaryDepartment = employee;
                }
            }

        }
        return minSalaryDepartment;
    }

    //максимальная зп в заданном отделе
    public static Employee maxSalaryDepartment(int dep) {

        Employee maxSalaryDepartment = employees[0];
        for (Employee employee : employees) {
            if (employee.getDepartment() == dep) {
                if (employee.getSalary() > maxSalaryDepartment.getSalary()) {
                    maxSalaryDepartment = employee;
                }
            }

        }
        return maxSalaryDepartment;
    }

    // Сумма затрат на зп в заданном отделе
    public static double calculSalaryEmployeesDepartment(int dep) {
        double sum = 0;
        for (Employee employee : employees) {
            if (employee.getDepartment() == dep) {
                sum += employee.getSalary();
            }
        }
        return sum;
    }

    //Средняя зп по заданному отделу
    public static double meanSalaryEmployeesDepartment(int dep) {
        double meanSalary = 0;
        int employeeCounter = 0;
        for (Employee employee : employees) {
            if (employee.getDepartment() == dep) {
                employeeCounter++;
                meanSalary = calculSalaryEmployeesDepartment(dep) / employeeCounter;
            }
        }
        return meanSalary;
    }

    //индексация зп всех сотрудников заданного отдела на заданный процент и вывод сотрудников
    public static void indxSalaryEmployeesDepartment(int dep, double precent) {
        double indx = 0;
        System.out.println("Проиндексированы зарплаты сотрудников заданного отдела:");
        for (Employee employee : employees) {
            if (employee.getDepartment() == dep) {
                indx = employee.getSalary() * (precent / 100) + employee.getSalary();
                employee.setSalary(indx);
                System.out.println("id= " + employee.getId() + ", ФИО: " + employee.getFullName() + ", Зарплата: " + employee.getSalary());
            }
        }
    }

    //Вывод сотрудников с зп меньше заданного числа
    public static void printEmployeesWithSalaryLessSpecNumber(double num) {
        for (Employee employee : employees) {
            if (employee.getSalary() < num) {
                System.out.println("id= " + employee.getId() + ", ФИО: " + employee.getFullName() + ", Зарплата: " + employee.getSalary());
            }
        }
    }

    //Вывод сотрудников с зп больше заданного числа
    public static void printEmployeesWithSalaryHigherSpecNumber(double num) {
        for (Employee employee : employees) {
            if (employee.getSalary() > num) {
                System.out.println("id= " + employee.getId() + ", ФИО: " + employee.getFullName() + ", Зарплата: " + employee.getSalary());
            }
        }
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
        System.out.println(" ");
        // Повышенная сложность(часть 2)
        System.out.println("Повышенная сложность(часть 2)");
        System.out.println(" ");
        indexSalary(5);
        System.out.println("Сотрудник с наименьшей зп в заданном отделе");
        System.out.println(minSalaryDepartment(2));
        System.out.println("Сотрудник с наибольшей зп в заданном отделе");
        System.out.println(maxSalaryDepartment(2));
        System.out.println("Сумма затрат на зп в заданном отделе");
        System.out.println(calculSalaryEmployeesDepartment(2));
        System.out.println("Средняя зп по отделу");
        System.out.println(meanSalaryEmployeesDepartment(2));
        indxSalaryEmployeesDepartment(2, 5);

        System.out.println("Сотрудники с зп меньше заданного числа");
        printEmployeesWithSalaryLessSpecNumber(50000);
        System.out.println("Сотрудники с зп больше заданного числа");
        printEmployeesWithSalaryHigherSpecNumber(50000);

    }
}