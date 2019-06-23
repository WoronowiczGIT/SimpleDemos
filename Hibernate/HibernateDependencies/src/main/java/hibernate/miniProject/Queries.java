package hibernate.miniProject;

import hibernate.HibernateUtils;
import hibernate.miniProject.models.*;
import org.hibernate.SessionFactory;

import javax.persistence.EntityManager;
import java.util.List;

public class Queries {
    final static SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
    final static EntityManager manager = sessionFactory.createEntityManager();

    public static void main(String[] args) {

//        generateTaskless();
//        removeTaskless();
        extractBlockerAndChangeName();
//        printByPhoneBrand("IPHONE");


        HibernateUtils.shutdown();
    }


    public static void extractBlockerAndChangeName(){
        manager.getTransaction().begin();
        List<Tasks> blockers = manager.createQuery(
                "select t from Tasks t where t.priority = :priority")
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
