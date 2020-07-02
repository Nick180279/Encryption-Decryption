class Employee {

    String name = "unknown";
    int salary;
    String address = "unknown";

    Employee() {
        this.salary = 0;
    }

    Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    Employee(String name, int salary, String address) {
        this(name, salary);
        this.address = address;
    }
}