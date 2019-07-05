package SDA.designPatterns.companyComposite;

import javax.naming.OperationNotSupportedException;

public class JuniorDeveloper implements Employee {
    private String name;
    private double salary;

    public JuniorDeveloper(String name, double salary) {
        this.name = name;
        this.salary = salary;
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
    public void showDirectSubordinatesSalaries() {
        System.out.println("END");
    }

    @Override
    public void showChainOfCommand() {
        System.out.println("\t\t\tSlave: "+this.getName()+" salary: "+this.getSalary());
    }

    @Override
    public void addSubordinate(Employee e) throws OperationNotSupportedException {
        throw new OperationNotSupportedException("slaves cant have slaves");
    }

    @Override
    public void removeSubordinate(Employee e) throws OperationNotSupportedException {
        throw new OperationNotSupportedException("slaves cant have slaves");
    }
}
