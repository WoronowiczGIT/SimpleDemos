package hibernate.miniProject;

import hibernate.HibernateUtils;
import hibernate.miniProject.models.*;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;

import javax.persistence.EntityManager;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Queries {
    final static SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
    final static EntityManager manager = sessionFactory.createEntityManager();

    public static void main(String[] args) {

//        generateTaskless();
//        removeTaskless();
//        extractBlockerAndChangeName();
//        printByPhoneBrand("IPHONE");
//            printTaskPage(4);
        fromMostToLeast();
        HibernateUtils.shutdown();
    }
    public static void fromMostToLeast(){
        manager.getTransaction().begin();
        String s = "SELECT e FROM Employees e Join fetch e.tasksSet";



        List<Employees> taskMaster = manager.createQuery(s,Employees.class).getResultList();

        manager.getTransaction().commit();
    }
    // NOT COMPLETE
    public static void transferTasks(){
        manager.getTransaction().begin();
        List<Employees> employees = manager.createQuery(
                "select e from Employees",Employees.class)
                .getResultList();

        int totaltasks = 0;

        for (Employees e: employees
             ) {
            totaltasks += e.getTasksSet().size();
        }
        int taskAvg = totaltasks / employees.size();

        Set<Tasks> spareTasks = new HashSet<>();

        for (Employees e : employees
             ) {
            Iterator<Tasks> iterator = e.getTasksSet().iterator();
            while(e.getTasksSet().size() > taskAvg && iterator.hasNext()){
                spareTasks.add(iterator.next());
                iterator.remove();
            }
        }
        Iterator<Tasks> tasksIterator = spareTasks.iterator();
        Iterator<Employees> employeesIterator = employees.iterator();
        while (tasksIterator.hasNext()){
            employeesIterator.next().getTasksSet().add(tasksIterator.next());
        }

        manager.getTransaction().commit();
    }


    public static void printTaskPage(int pageNumber){
        if(pageNumber <= 1) pageNumber = 0;else pageNumber = (pageNumber-1)*3;
        manager.getTransaction().begin();

        List<Tasks> tasks = manager.createQuery("select t from Tasks t",Tasks.class)
                .setFirstResult(pageNumber)
                .setMaxResults(pageNumber+3)
                .getResultList();

        manager.getTransaction().commit();

        for (Tasks t: tasks
             ) {
            System.out.println(t.getTaskID()+" "+t.getName()+" "+t.getPriority());
        }
    }

    public static void generateTasks(int employeeID){
        addTasksToUser(employeeID,"newTask",Priority.HIGH_PRIORITY);
        addTasksToUser(employeeID,"newTask2",Priority.NORMAL);
        addTasksToUser(employeeID,"newTask3",Priority.BLOCKER);
        addTasksToUser(employeeID,"newTask4",Priority.BLOCKER);
        addTasksToUser(employeeID,"newTask5",Priority.HIGH_PRIORITY);
    }

    public static void addTasksToUser(int userID, String name, Priority priority){
        Employees emp = manager.find(Employees.class,userID);
        Tasks tasks = new Tasks();
        tasks.setName(name);
        tasks.setPriority(priority);
        emp.getTasksSet().add(tasks);
        manager.getTransaction().begin();
        manager.persist(tasks);
        manager.persist(emp);
        manager.getTransaction().commit();
    }

    public static void extractBlockerAndChangeName(){
        manager.getTransaction().begin();
        List<Tasks> blockers = manager.createQuery(
                "select t from Tasks t where t.priority = :priority",Tasks.class)
                .setParameter("priority", Priority.BLOCKER)
                .getResultList();
        for (Tasks t: blockers
             ) {
            String newName = t.getName()+"BLOCKER!";
            t.setName(newName);
        }

        manager.getTransaction().commit();
    }

    public static void removeTaskless(){
        //execute QUERY!
        manager.getTransaction().begin();
        manager.createQuery("Delete from Employees e where e.tasksSet is empty").executeUpdate();
        manager.getTransaction().commit();
    }

    public static void printByPhoneBrand(String brandname){
        manager.getTransaction().begin();
        List<Employees> list = manager.createQuery("select e from Employees e " +
                "join fetch e.myPhone where e.myPhone.brand = :brand", Employees.class)
                .setParameter("brand",brandname)
                .getResultList();
        for (Employees e: list
             ) {
            System.out.println(e.getName());
        }
        manager.getTransaction().commit();
    }
    public static void generateTaskless(){
        addTasklessEmployee("Andrzej","IPHONE","petProject");
        addTasklessEmployee("Adam","Samsung","petProject");
        addTasklessEmployee("Maciek","Sony","petProject");
    }

    public static void addTasklessEmployee(String name, String phoneBrand, String projectName){
        manager.getTransaction().begin();
        Employees emp = new Employees();
        Projects proj = new Projects();
            proj.setProjectName(projectName);
            proj.getEmployeeSet().add(emp);
        Phones phone = new Phones();
            phone.setEmployee(emp);
            phone.setBrand(phoneBrand);
            phone.setModel("N10");
        emp.setMyPhone(phone);
            emp.setName(name);
            emp.getProjectsSet().add(proj);

            manager.persist(phone);
            manager.persist(proj);
            manager.persist(emp);
            manager.getTransaction().commit();
    }

}
