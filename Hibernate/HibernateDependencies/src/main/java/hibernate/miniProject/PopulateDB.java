package hibernate.miniProject;

import hibernate.HibernateUtils;
import hibernate.miniProject.models.*;
import org.hibernate.SessionFactory;

import javax.persistence.EntityManager;
import java.util.ArrayDeque;
import java.util.Queue;

public class PopulateDB {
    final static SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
    final static EntityManager manager = sessionFactory.createEntityManager();

    public static void main(String[] args) {

        Queue<Projects> projects = createProjects();
        Queue<Phones> phones = createPhones();
        Queue<Tasks> tasks = createTasks();

        manager.getTransaction().begin();

        Employees emp = createEmployee("name1",tasks.poll(),phones.poll(),projects.poll());
        Employees emp1 = createEmployee("name2",tasks.poll(),phones.poll(),projects.poll());
        Employees emp2 = createEmployee("name3",tasks.poll(),phones.poll(),projects.peek());
        Employees emp3 = createEmployee("name4",tasks.poll(),phones.poll(),projects.peek());
        Employees emp4 = createEmployee("name5",tasks.poll(),phones.poll(),projects.poll());
        Employees emp5 = createEmployee("name6",tasks.poll(),phones.poll(),projects.poll());
        Employees emp6 = createEmployee("name7",tasks.poll(),phones.poll(),projects.peek());

        manager.persist(emp);
        manager.persist(emp1);
        manager.persist(emp2);
        manager.persist(emp3);
        manager.persist(emp4);
        manager.persist(emp5);
        manager.persist(emp6);

        manager.getTransaction().commit();

    manager.close();
        HibernateUtils.shutdown();
    }
    public static Employees createEmployee(String name, Tasks task,Phones phone, Projects project){
        Employees emp = new Employees();
        emp.setName(name);

        emp.getTasksSet().add(task);
        task.setEmployee(emp);
        manager.persist(task);

        emp.setMyPhone(phone);
        phone.setEmployee(emp);
        manager.persist(phone);

        emp.getProjectsSet().add(project);
        project.getEmployeeSet().add(emp);
        manager.persist(project);
        return emp;
    }

    public static Tasks taskFacrory(String name, Priority priority, String desc){
        Tasks tasks = new Tasks();
        tasks.setName(name);
        tasks.setPriority(priority);
        tasks.setDescription(desc);

        return tasks;
    }

    public static Queue<Tasks> createTasks(){
        Queue<Tasks> q = new ArrayDeque<>();
        q.add(taskFacrory("Task name 1",Priority.NORMAL,"description..."));
        q.add(taskFacrory("Task name 2",Priority.HIGH_PRIORITY,"description..."));
        q.add(taskFacrory("Task name 3",Priority.BLOCKER,"description..."));
        q.add(taskFacrory("Task name 4",Priority.NORMAL,"description..."));
        q.add(taskFacrory("Task name 5",Priority.NORMAL,"description..."));
        q.add(taskFacrory("Task name 6",Priority.BLOCKER,"description..."));
        q.add(taskFacrory("Task name 7",Priority.NORMAL,"description..."));
        q.add(taskFacrory("Task name 8",Priority.HIGH_PRIORITY,"description..."));
        q.add(taskFacrory("Task name 9",Priority.HIGH_PRIORITY,"description..."));
        q.add(taskFacrory("super Task",Priority.NORMAL,"description..."));

        return q;
    }




    public static Queue<Projects> createProjects(){
        Queue<Projects> projects = new ArrayDeque<>();
        projects.add(projectFactory("easy project"));
        projects.add(projectFactory("Hard project"));
        projects.add(projectFactory("My project"));
        projects.add(projectFactory("Lazy project"));
        projects.add(projectFactory("SUPER HARD project"));

        return projects;
    }
    public static Projects projectFactory(String name){
        Projects p = new Projects();
        p.setProjectName(name);
        return p;
    }

    public static Phones phoneFactory(String brand, String model){
        Phones phone = new Phones();
        phone.setBrand(brand);
        phone.setModel(model);
        return phone;
    }

    public static  Queue<Phones> createPhones(){
        Queue<Phones> queue = new ArrayDeque<>();
        queue.add(phoneFactory("Samsung","galaxy s3"));
        queue.add(phoneFactory("Samsung","galaxy s3"));
        queue.add(phoneFactory("Samsung","galaxy s3"));
        queue.add(phoneFactory("Samsung","galaxy s3"));
        queue.add(phoneFactory("Samsung","galaxy s6"));
        queue.add(phoneFactory("Samsung","galaxy s6"));
        queue.add(phoneFactory("Samsung","galaxy s6"));
        queue.add(phoneFactory("Iphone","X"));
        queue.add(phoneFactory("Iphone","X"));
        queue.add(phoneFactory("Iphone","X"));

        return queue;
    }



}
