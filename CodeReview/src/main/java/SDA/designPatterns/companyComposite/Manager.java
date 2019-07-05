package SDA.designPatterns.companyComposite;

import javax.naming.OperationNotSupportedException;
import java.util.LinkedList;
import java.util.List;

public class Manager implements Employee {
    private String name;
    private double salary;
    private List<Employee> subordinates = new LinkedList<>();

    public Manager(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }
    public void showDirectSubordinatesSalaries(){
        for (Employee e: subordinates) {
            System.out.println(e.getName()+" "+e.getSalary());
        }
    }

    @Override
    public void showChainOfCommand() {
        System.out.println("\tManager: "+this.getName()+" salary: "+this.getSalary());
        for (Employee e: subordinates
        ) {
            e.showChainOfCommand();
        }
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Double getSalary() {
        return salary;
    }

    @Override
    public void addSubordinate(Employee e) throws OperationNotSupportedException {
        subordinates.add(e);
    }

    @Override
    public void removeSubordinate(Employee e) throws OperationNotSupportedException {
        subordinates.remove(e);
    }
}
