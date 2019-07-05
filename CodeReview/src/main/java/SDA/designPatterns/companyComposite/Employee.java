package SDA.designPatterns.companyComposite;

import javax.naming.OperationNotSupportedException;

public interface Employee {

    String getName();
    Double getSalary();
    void showDirectSubordinatesSalaries();
    void showChainOfCommand();
    void addSubordinate(Employee e) throws OperationNotSupportedException;
    void removeSubordinate(Employee e) throws OperationNotSupportedException;
}
