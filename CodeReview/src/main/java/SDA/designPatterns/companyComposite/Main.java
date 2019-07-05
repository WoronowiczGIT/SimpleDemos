package SDA.designPatterns.companyComposite;

import javax.naming.OperationNotSupportedException;

public class Main {
    public static void main(String[] args) throws OperationNotSupportedException {
        Director director = Director.changeDirector("Bill Gates", 1000000);

        Employee managerTom = new Manager("Tom", 200000);
        Employee managerMike = new Manager("Mike", 250000);

        Employee seniorMckee = new SeniorDeveloper("Mickel", 50000);
        Employee seniorJohn = new SeniorDeveloper("John", 60000);
        Employee seniorAdam = new SeniorDeveloper("Adam", 40000);

        Employee slave1 = new JuniorDeveloper("noName1", 1);
        Employee slave2 = new JuniorDeveloper("noName2", 0);
        Employee slave3 = new JuniorDeveloper("noName3", 0);
        Employee slave4 = new JuniorDeveloper("noName4", 1);
        Employee slave5 = new JuniorDeveloper("noName5", 2);
        Employee slave6 = new JuniorDeveloper("noName6", 1);
        Employee slave7 = new JuniorDeveloper("noName7", 2);
        Employee slave8 = new JuniorDeveloper("noName8", 1);
        Employee dung = new JuniorDeveloper("dung beetle", 3);

        director.addSubordinate(managerTom);
        director.addSubordinate(managerMike);

        managerMike.addSubordinate(seniorMckee);
        managerMike.addSubordinate(seniorAdam);

        managerTom.addSubordinate(seniorAdam);
        managerTom.addSubordinate(seniorJohn);

        seniorAdam.addSubordinate(slave1);
        seniorAdam.addSubordinate(slave2);
        seniorAdam.addSubordinate(slave3);

        seniorJohn.addSubordinate(slave4);
        seniorJohn.addSubordinate(slave5);

        seniorMckee.addSubordinate(slave6);
        seniorMckee.addSubordinate(slave7);
        seniorMckee.addSubordinate(slave8);
        seniorMckee.addSubordinate(dung);

        director.showChainOfCommand();
//        director.showDirectSubordinatesSalaries();
    }
}
