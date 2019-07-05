package SDA.designPatterns.companyComposite;

import javax.naming.OperationNotSupportedException;
import java.util.LinkedList;
import java.util.List;

public class Director implements Employee {
    private static Director director = new Director();
    private String name;
    private double salary;
    private List<Employee> subordinates = new LinkedList<>();

    private Director(){}
    public static Director changeDirector(String name, double salary) {
        director.name = name;
        director.salary = salary;
        return director;
    }
    public void showDirectSubordinatesSalaries(){
        for (Employee e: subordinates) {
            System.out.println(e.getName()+" "+e.getSalary());
        }
    }
    public void showChainOfCommand(){
        System.out.println("Director: "+director.getName()+" salary: "+director.getSalary());
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
